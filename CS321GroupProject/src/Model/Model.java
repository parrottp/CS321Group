package Model;

import java.io.File;
import java.text.ParseException;
import java.util.ArrayList;



/**
 * Model for MVC of program
 */
public class Model {
    //User data
    private String firstname;
    private String lastname;
    private String username;
    private String password;
    private String birthday;
    private String gameInterest;
    private String age;
    private int messagesSent;
    
    //User File data
    private String fileName;
    private String friendsList;
    private String pFriendsList;
    private String potentialFriend;
    private String currentConversation;
    private String cCFileNameA;
    private String cCFileNameB;
    
    //Used by Controller to check input Dates
    private boolean invalidDateInput = false;
    
    //Singleton variables
    private FileData file;
    private Friends f;
    
    /**
     * Model constructor for a RegisterController.
     * @param firstname User's first name
     * @param lastname User's last name
     * @param aUsername User's username
     * @param aPassword User's password
     * @param aBirthday User's birth date
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
        
        //Reads File path for User data file for input username
        this.fileName = this.username + ".txt";
        this.friendsList = this.username + "friends.txt";
        
        //Initializes FileData and Friends singletons, passes current User's username to Friends
        file = FileData.getInstance();
        f = Friends.getInstance();
        f.setUsername(this.username);
    }
    
    
    /**
     * Model constructor for a LoginController.
     * @param username User's username
     * @param password User's password
     * PRECONDITION: Parameter Strings are initialized.
     * POSTCONDITION: Model object constructed for use by LoginController.
     */
    public Model(String username, String password) {
        this.username = username;
        this.password = password;
        
        //Reads File path for User data file for input username
        this.fileName = this.username + ".txt";
        this.friendsList = this.username + "friends.txt";
        
        //Initializes FileData and Friends singletons, passes current User's username to Friends
        file = FileData.getInstance();
        f = Friends.getInstance();
        f.setUsername(this.username);
    }

    
    /**
     * Model constructor for a HomePageController.
     * @param aUsername User's username
     * @param age User's age
     * @param aGameInterest User's game interest
     * @param messagesSent User's total messages sent
     * PRECONDITION: Parameter Strings are initialized.
     * POSTCONDITION: Model object constructed for use by RegisterController.
     */
    public Model(String aUsername, String age, String aGameInterest, int messagesSent) {
        username = aUsername;
        this.age = age;
        gameInterest = aGameInterest;
        this.messagesSent = messagesSent;
        
        //Reads File path for User data file for input username
        this.fileName = this.username + ".txt";
        this.friendsList = this.username + "friends.txt";
        
        //Initializes FileData and Friends singletons, passes current User's username to Friends
        file = FileData.getInstance();
        f = Friends.getInstance();
        f.setUsername(this.username);
        
        //Loads usernamefriends.txt as an ArrayList Friends
        f.FriendsListLoad();
        
        //Loads an ArrayList of potential friends in the Friends class
        f.pFriendsLoad();
    }
    
    
    /**
     * Called by RegisterController when the User inputs DoB into JTextField. 
     * @return true if User's birthday is on current day, false otherwise
     * @throws ParseException 
     * PRECONDITION: this.data is a valid String for DoB in the format 'MM/dd/yyyy'.
     * POSTCONDITION: Sets this.userAge = User's age.
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
     * Checks if password is correct for User input username.
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
        this.messagesSent = 0;
        String stringLevel = new Integer(this.messagesSent).toString();
        file.FileWrite(stringLevel, fileName);
        
        //Create data file for User's friends list when their profile is created
        file.FileCreate(friendsList);
    }
    
    
    /**
     * Updates the stored value for User's messagesSent into the User's Data File.
     * PRECONDITION: User's Data File populated
     * POSTCONDITION: User's Data File re-written with new messagesSent
     */
    public void updateUserLevel() {
        //Store User Data file into ArrayList
        ArrayList<String> userData = file.FileLoadList(this.fileName);
        
        //Convert new level to String
        String stringLevel = Integer.toString(this.messagesSent);
        
        //Update level in User Data
        userData.set(6, stringLevel);
        
        //Deletes User data File
        File temp = new File(this.fileName);
        temp.delete();
        
        //Re-writes file with new value
        file.FileCreate(this.fileName);
        for (int i = 0; i < userData.size(); i++) {
            file.FileWrite(userData.get(i), this.fileName);
        }
    }
    
    
    /**
     * Reads age and gameInterest from the current User's Data File. Used in LoginController to get all data fields for HomePage.
     * @throws ParseException 
     * PRECONDITION: User Data File populated, and this.fileName initialized
     * POSTCONDITION: age and gameInterest fields read from File and stored in Model
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
        
        //Reads in the String for User Level, turns it into an integer, and sets it to this.level
        this.messagesSent = Integer.parseInt(userDataFile.get(6));
    }
    
    
    /**
     * Adds new User's username to current User's friends list and removes User from list of potential friends.
     * PRECONDITION: this.potentialFriend and this.friendsList initialized
     * POSTCONDITION: Username added to current User's friends list, and removed from current User's list of potential friends
     */
    public void updateFriendsList() {
        //Writes User's new friend's username to friendsList
        file.FileWrite(this.potentialFriend, this.friendsList);
        
        //Deletes User name from Potential Friends List
        f.pFriendsRemove(this.potentialFriend);
        
        //Initializes conversation file names
        this.cCFileNameA = this.username + this.potentialFriend + ".txt";
        this.cCFileNameB = this.potentialFriend + this.username + ".txt";
        
        //Creates File instances to test if the conversation files exist
        File fA = new File(cCFileNameA);
        File fB = new File(cCFileNameB);
        
        //Creates new conversation files while not overwriting existing conversation files
        if (!fA.exists()) {
            file.FileCreate(this.username + this.potentialFriend + ".txt");
        }
        if (!fB.exists()) {
            file.FileCreate(this.potentialFriend + this.username + ".txt");
        }
    }
    
    
     /**
     * Gets the current User's friends list, converts from ArrayList to Array, and returns it.
     * @return String array of current User's friends list
     * PRECONDITION: this.f initialized
     * POSTCONDITION: None.
     */
    public String[] getFriendsList() {
        //Reads current User's friends list into ArrayList
        ArrayList<String> list = f.getFriendsList();
        
        //Stores size of new ArrayList
        int friendsListSize = list.size();
        
        //Initializes String Array with correct size
        String[] friends = new String[friendsListSize];
        
        //Populated String Array with values of ArrayList
        for (int i = 0; i < friendsListSize; i++) {
            friends[i] = list.get(i);
        }
        
        //Return String Array
        return friends;
    }
    
    
    /**
     * Checks if this.potentialFriend is a valid potential friend.
     * @return true if valid potential friend
     * PRECONDITION: this.f instantiated, this.potentialFriend instantiated
     * POSTCONDITION: None.
     */
    public boolean verifyUser() {
        return f.isNewFriendValid(this.potentialFriend);
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
     * Writes sent Messages to conversation files of both Users involved. Updates messageSent for every sent message.
     * @param message new sent Message
     * PRECONDITION: Conversation Files initialized.
     * POSTCONDITION: Messages written to Conversation Files. messagesSent incremented.
     */
    public void sendMessage(String message)
    {
        Message mess = new Message(username, message, this.cCFileNameA);
        Message messReverse = new Message(username, message, this.cCFileNameB);
        
        this.messagesSent++;
    }
    
    
    /**
     * Loads the current User's conversation file into an ArrayList and returns it. 
     * @return ArrayList of current conversation, each index storing a line 
     * PRECONDITION: Current conversation File initialized.
     * POSTCONDITION: None.
     */
    public ArrayList<String> getConvoText()
    {
        return file.FileLoadList(this.cCFileNameA);
    }
    
    
    /**
     * Sets this.currentConversation to current User's new conversation partner's username and updates names of conversation files.
     * @param currentConversation new conversation partner's username
     * PRECONDITION: String currentConversation contains new conversation partner's username
     * POSTCONDITION: this.currentConversation updated with new username, and associated conversation files updated
     */
    public void setCurrentConversation(String currentConversation)
    {
        //Sets new conversation partner's username
        this.currentConversation = currentConversation;
        
        //Updates names of conversation files
        this.cCFileNameA = username + currentConversation + ".txt";
        this.cCFileNameB = currentConversation + username + ".txt";
    }
    
    
    /**
     * Accessor for invalidDateInput. Returns true if Date is invalid.
     * @return current invalidDateInput
     */
    public boolean getInvalidDateInput() {
        return this.invalidDateInput;
    }
    
    
    /**
     * Accessor for current conversation partner's username.
     * @return current conversation partner's username
     */
    public String getCurrentConversation()
    {
        return this.currentConversation;
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
     * Accessor for firstname.
     * @return current firstname
     */
    public String getFirstname() {
        return firstname;
    }
    
    
    /**
     * Mutator for firstname.
     * @param first new firstname
     */
    public void setFirstname(String first) {
        this.firstname = first;
    }

    
    /**
     * Accessor for lastname.
     * @return current lastname
     */
    public String getLastname() {
        return lastname;
    }

    
    /**
     * Mutator for lastname.
     * @param last new lastname
     */
    public void setLastname(String last) {
        this.lastname = last;
    }

    
    /**
     * Accessor for username.
     * @return current username
     */
    public String getUsername() {
        return username;
    }
    
    
    /**
     * Mutator for username.
     * @param newUsername new username
     */
    public void setUsername(String newUsername) {
        username = newUsername;
    }
   
   
    /**
     * Accessor for password.
     * @return current password
     */
    public String getPassword() {
        return password;
    }
   
   
    /**
     * Mutator for password.
     * @param newPassword new password
     */
    public void setPassword(String newPassword) {
        password = newPassword;
    }

   
    /**
     * Accessor for gameInterest.
     * @return current gameInterest
     */
    public String getGameInterest() {
        return gameInterest;
    }
   
    
    /**
     * Mutator for gameInterest.
     * @param newGameInterest new gameInterest
     */
    public void setGameInterest(String newGameInterest) {
        gameInterest = newGameInterest;
    }
   
    
    /**
     * Accessor for birthday.
     * @return current birthday
     */
    public String getBirthday() {
        return birthday;
    }
    
    
    /**
     * Mutator for birthday.
     * @param newBirthday new birthday
     */
    public void setBirthday(String newBirthday) {
        birthday = newBirthday;
    }
   
   
    /**
     * Accessor for age.
     * @return current age
     */
    public String getAge() {
        return age;
    }
    
    
    /**
     * Mutator for age.
     * @param age new age
     */
    public void setAge(String age) {
        this.age = age;
    }
    
    
     /**
     * Accessor for level.
     * @return current level
     */
    public int getLevel() {
        return this.messagesSent;
    }
    
    
    /**
     * Mutator for age.
     * @param level new level
     */
    public void setLevel(int level) {
        this.messagesSent = level;
    }
    
    
    /**
     * Accessor for potentialFriend.
     * @return username of current potentialFriend
     */
    public String getPotentialFriend() {
        return this.potentialFriend;
    }
   
    
    /**
     * Mutator for potentialFriend.
     * @param pFriend username of new potentialFriend
     */
    public void setPotentialFriend(String pFriend) {
        this.potentialFriend = pFriend;
    }
    
    
}