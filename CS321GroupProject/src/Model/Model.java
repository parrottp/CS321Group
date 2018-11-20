package Model;

import java.io.File;
import java.text.ParseException;
import java.util.ArrayList;

/**
 * Model for MVC of program
 * @author livweaver, noahe
 */
public class Model {
    //User data
    private String fileName;
    private String friendsList;
    private String pFriendsList;
    private String potentialFriend;
    private String currentConversation;
    private Friends f;
    
    private String firstname;
    private String lastname;
    private String username;
    private String password;
    private String birthday;
    private String gameInterest;
    private String age;
    private int level;
    
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
     * @param userLevel
     * PRECONDITION: Parameter Strings are initialized.
     * POSTCONDITION: Model object constructed for use by RegisterController.
     */
    public Model(String firstname, String lastname, String aUsername, String aPassword, String aBirthday, String aGameInterest, int userLevel) {
        this.firstname = firstname;
        this.lastname = lastname;
        username = aUsername;
        password = aPassword;
        birthday = aBirthday;
        gameInterest = aGameInterest;
        level = userLevel;
        
        //Reads File path for User data file for input username
        this.fileName = this.username + ".txt";
        this.friendsList = this.username + "friends.txt";
        
        file = FileData.getInstance();
        f = Friends.getInstance();
        f.setUsername(this.username);
        //loadPotentialFriends();
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
        
        file = FileData.getInstance();
        f = Friends.getInstance();
        f.setUsername(this.username);
        //loadPotentialFriends();
    }

    /**
     * Model constructor for a HomePageController.
     * @param aUsername
     * @param age
     * @param aGameInterest 
     * PRECONDITION: Parameter Strings are initialized.
     * POSTCONDITION: Model object constructed for use by RegisterController.
     */
    public Model(String aUsername, String age, String aGameInterest) {
        username = aUsername;
        this.age = age;
        gameInterest = aGameInterest;
        
        //Reads File path for User data file for input username
        this.fileName = this.username + ".txt";
        this.friendsList = this.username + "friends.txt";
        
        file = FileData.getInstance();
        f = Friends.getInstance();
        f.setUsername(this.username);
       // loadPotentialFriends();
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
        this.friendsList = this.username + "friends.txt";
        
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
        
        //Convert level to string 
        String stringLevel = new Integer(level).toString();
        file.FileWrite(stringLevel, fileName);
        
        //Create data file for User's friends list when their profile is created
        file.FileCreate(friendsList);
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
     * 
     * @throws ParseException 
     */
    public void readDataFile() throws ParseException {
        ArrayList<String> userDataFile = file.FileLoadList(this.fileName);
        
        //Reads in the String for User Date of Birth
        String DoB = userDataFile.get(4);
        
        //Calculate and set this.age from Date of Birth
        CalculateAge input = new CalculateAge(DoB);
        input.processAge();
        this.age = input.getAge();
        
        //Reads in the String for User Game Interest and sets it to this.gameInterest
        this.gameInterest = userDataFile.get(5);
    }
    
    
    /**
     * 
     */
    public void loadPotentialFriends() {
        //Loads usernamefriends.txt as an ArrayList Friends
        f.FriendsListLoad();
        
        //Loads an ArrayList of potential friends
        f.pFriendsLoad();
    }
    
    
    //Returns true if pFriend is valid
    public boolean verifyUser() {
        return f.isNewFriendValid(this.potentialFriend);
    }
    
    
    
   
    public void updateFriendsList() {
        //Writes User's new friend's username to friendsList
        file.FileWrite(this.potentialFriend, this.friendsList);
        

        //Deletes User name from Potential Friends List
        f.pFriendsRemove(this.potentialFriend);
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
    
     /**
     * Accessor for level
     * @return current level
     */
    public int getLevel() {
        return level;
    }
    
    
    /**
     * Mutator for age
     * @param level new level
     */
    public void setLevel(int level) {
        this.level = level;
    }
    
    
    
    public String getPotentialFriend() {
        return this.potentialFriend;
    }
   
    
    
    public void setPotentialFriend(String pFriend) {
        this.potentialFriend = pFriend;
    }
    
    /**
     * returns the user to which the active user
     * will send messages
     * @return 
     */
    public String getCurrentConversation()
    {
        return currentConversation;
    }
    
    public void setCurrentConversation(String currentConversation)
    {
        this.currentConversation = currentConversation;
    }
    
    /**
     * Creates Message objects, saving each message
     * to the perspective of each user involved
     * @param message 
     */
    public void sendMessage(String message)
    {
        Message mess = new Message(username, message, username + currentConversation + ".txt");
        Message messReverse = new Message(username, message, currentConversation + username + ".txt");
    }
    
    /**
     * 
     * @return 
     */
    public String[] getFriendsList() {
        ArrayList<String> list = f.getFriendsList();
        int friendsListSize = list.size();
        String[] friends = new String[friendsListSize];
        
        for (int i = 0; i < friendsListSize; i++) {
            friends[i] = list.get(i);
            System.out.println(friends[i]);
        }
        
        System.out.println(friends);
        return friends;
    }
}