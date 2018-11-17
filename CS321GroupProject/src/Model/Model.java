package Model;

import java.io.File;
import java.text.ParseException;

/**
 * Model for MVC of program
 * @author livweaver, noahe
 */
public class Model {
    //User data
    private String fileName;
    
    private String firstname;
    private String lastname;
    private String username;
    private String password;
    private String birthday;
    private String gameInterest;
    private String age;
    
    //Used by Controller to check input Dates
    private boolean invalidDateInput = false;
    
    FileData file;
    
    /**
     * Model constructor for a RegisterController.
     * @param firstname 
     * @param lastname
     * @param aUsername
     * @param aPassword
     * @param aBirthday
     * @param aGameInterest 
     * PRECONDITION: Parameter Strings are initialized.
     * POSTCONDITION: Model object constructed for use by RegisterController.
     */
    public Model(String firstname, String lastname, String aUsername, String aPassword, String aBirthday, String aGameInterest) {
        this.firstname = firstname;
        this.lastname = lastname;
        username = aUsername;
        password = aPassword;
        birthday = aBirthday;
        gameInterest = aGameInterest;
        
        file = file.getInstance();
    }
    
    
    /**
     * Model constructor for a LoginController.
     * @param username
     * @param password 
     * PRECONDITION: Parameter Strings are initialized.
     * POSTCONDITION: Model object constructed for use by LoginController.
     */
    public Model(String username, String password) {
        this.username = username;
        this.password = password;
        
        file = file.getInstance();
    }

    /**
     * Model constructor for a HomePageController.
     * @param aUsername
     * @param aBirthday
     * @param aGameInterest 
     * PRECONDITION: Parameter Strings are initialized.
     * POSTCONDITION: Model object constructed for use by RegisterController.
     */
    public Model(String aUsername, String aBirthday, String aGameInterest) {
        username = aUsername;
        birthday = aBirthday;
        gameInterest = aGameInterest;
    }
    
    /**
     * Called by RegisterController when the User inputs DoB into JTextField. 
     * @throws ParseException 
     * PRECONDITION: this.data is a valid String for DoB in the format 'MM/dd/yyyy'.
     * POSTCONDITION: Sets this.userAge = User's age, returns true if it's User's birthday on current day.
     */
    public boolean processBirthdate() throws ParseException { 
        //Creates new CalculateAge object with User input DoB
        CalculateAge input = new CalculateAge(this.birthday);
        
        //Updates this.invalidDateInput if User input DoB is invalid
        this.invalidDateInput = input.getInvalidDate();
        
        //If the User input DoB is valid, processes DoB into years, updates this.age, returns boolean for if current day is birthday
        if(this.invalidDateInput == false) {
            input.processAge();
            this.age = input.getAge();
            return input.happyBirthday();
        }
        else {
            //Returns false if User input DoB is invalid
            return false;
        }
    }
    
    
    /**
     * Checks if account exists for User input username.
     * @return true if account exists, false if username is unused.
     * PRECONDITION: this.username initialized.
     * POSTCONDITION: this.fileName set to 'username.txt'
     */
    public boolean checkUsername() {
        boolean accountExists = true;
        
        //Reads File path for User data file for input username
        this.fileName = this.username + ".txt";
        File temp = new File(fileName);
        
        //Returns false if the File path does not exist
        if(!temp.exists()) {
            accountExists = false;
        }
        
        return accountExists;
    }
    
    
    /**
     * Checks if password is correct for User input username
     * @return true if password is correct, false if wrong password
     * PRECONDITION: this.fileName and this.password initialized.
     * POSTCONDITION: None.
     */
    public boolean checkPassword() {
        boolean correctPassword = false;
        
        //Reads first line from User data file
        //FileData file = new FileData();
        String line = file.FileLoad(fileName);
        
        //Checks if the stored User password is the same as the input password
        if(line.equals(this.password)) {
            //Returns true if passwords match
            correctPassword = true;
        }
       
        return correctPassword;
    }
    
    
    /**
     * Creates a new File of User Data for a newly Registered User.
     * PRECONDITION: this.fileName, this.password, this.username, this.firstname, this.lastname, this.birthday, this.gameInterest all intialized.
     * POSTCONDITION: new User Data File created.
     */
    public void newUserFile() {
        //Create profile data file
        file.FileCreate(fileName);                  //file name is username.txt
        file.FileWrite(this.password, fileName);
        file.FileWrite(this.username, fileName);
        file.FileWrite(this.firstname, fileName);
        file.FileWrite(this.lastname, fileName);
        file.FileWrite(this.birthday, fileName);
        file.FileWrite(this.gameInterest, fileName);
    }
    
    
    /**
     * Updates MasterList of Registered Users' usernames.
     * PRECONDITION: New User successfully registered, new Data File created for User.
     * POSTCONDITION: MasterList updated with new username.
     */
    public void updateMasterList() {
        file.FileWrite(this.username, "MasterList.txt");
    }
   
    
    /**
     * Accessor for invalidDateInput. Returns true if Date is invalid.
     * @return current invalidDateInput
     */
    public boolean getInvalidDateInput() {
        return this.invalidDateInput;
    }
    
    
    /**
     * Accessor for fileName.
     * @return current fileName
     */
    public String getFileName() {
        return fileName;
    }
    
    
    /**
     * Mutator for fileName.
     * @param fileName new fileName
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    
    /**
     * Accessor for firstname
     * @return current firstname
     */
    public String getFirstname() {
        return firstname;
    }
    
    
    /**
     * Mutator for firstname
     * @param first new firstname
     */
    public void setFirstname(String first) {
        this.firstname = first;
    }

    
    /**
     * Accessor for lastname
     * @return current lastname
     */
    public String getLastname() {
        return lastname;
    }

    
    /**
     * Mutator for lastname
     * @param last new lastname
     */
    public void setLastname(String last) {
        this.lastname = last;
    }

    
    /**
     * Accessor for username
     * @return 
     */
    public String getUsername() {
        return username;
    }
    
    
    /**
     * Mutator for username
     * @param newUsername new username
     */
    public void setUsername(String newUsername) {
        username = newUsername;
    }
   
   
    /**
     * Accessor for password
     * @return current password
     */
    public String getPassword() {
        return password;
    }
   
   
    /**
     * Mutator for password
     * @param newPassword new password
     */
    public void setPassword(String newPassword) {
        password = newPassword;
    }

   
    /**
     * Accessor for gameInterest
     * @return current gameInterest
     */
    public String getGameInterest() {
        return gameInterest;
    }
   
    
    /**
     * Mutator for gameInterest
     * @param newGameInterest new gameInterest
     */
    public void setGameInterest(String newGameInterest) {
        gameInterest = newGameInterest;
    }
   
    
    /**
     * Accessor for birthday
     * @return current birthday
     */
    public String getBirthday() {
        return birthday;
    }
    
    
    /**
     * Mutator for birthday
     * @param newBirthday new birthday
     */
    public void setBirthday(String newBirthday) {
        birthday = newBirthday;
    }
   
   
    /**
     * Accessor for age
     * @return current age
     */
    public String getAge() {
        return age;
    }
    
    
    /**
     * Mutator for age
     * @param age new age
     */
    public void setAge(String age) {
        this.age = age;
    }
   
}