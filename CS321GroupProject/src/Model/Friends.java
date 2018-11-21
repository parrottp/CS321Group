package Model;

import java.util.ArrayList;



public class Friends 
{
    //Private instance of FileData
    private static Friends f;
    
    //Constructor is private so FileData can only be initialied from getInstance()
    private Friends() {}
    
    //Initializes only instance of FileData
    public static Friends getInstance() {
        if (f == null) {
            f = new Friends();
        }
        return f;
    }
    
    //Initializes Singleton instance of FileData
    FileData fileData = FileData.getInstance();
    
    //User data
    ArrayList<String> potentialFriends;
    ArrayList<String> Friends;
    ArrayList<String> MasterList;
    String username;
    String friendsFile;
  
    
    /**
     * Stores master list of users into potential friends list.
     * @return potentialFriends
     * PRECONDITION: MasterList is populated
     * POSTCONDITION: potentialFriends is initialized
     */
    public ArrayList<String> pFriendsLoad()
    {        
        MasterList = fileData.FileLoadList("MasterList.txt");
        potentialFriends = (ArrayList<String>)MasterList.clone(); 
        potentialFriends.removeAll(Friends);
        return potentialFriends;
    }
    
    
    /**
     * Stores friends list into ArrayList.
     * @return Friends
     * PRECONDITION: Friends is populated
     * POSTCONDITION: Friends is initialized
     */
    public ArrayList<String> FriendsListLoad()
    {
        this.Friends = fileData.FileLoadList(this.friendsFile);
        return this.Friends;
    }
    
    
    /**
     * Adds user to Friends ArrayList and writes to a file.
     * @param user String
     * @return Friends 
     * PRECONDTION: selecting user
     * POSTCONDITION: selected user is added to Friends
     */
    public ArrayList<String> FriendListAdd(String user)
    {
        Friends.add(user);
        fileData.FileWrite(user, friendsFile);
        return Friends;
    }
    
    
    /**
     * Removes user from potential friends list.
     * @param user String
     * @return potentialFriends
     * PRECONDITION: potentialFriends is populated and user has been added to Friends List
     * POSTCONDITION: Selected user has been removed from potential friends
     */
    public ArrayList<String> pFriendsRemove(String user)
    {
        potentialFriends.remove(user);
        return potentialFriends;
    }
    
    
    /**
     * Checks if friend is in the list if potential friends.
     * @param friend name being checked
     * @return true if friend is in the list of potential friends
     * PRECONDITION: String friend is initialized
     * POSTCONDITION: None.
     */
    public boolean isNewFriendValid(String friend) {
        return this.potentialFriends.contains(friend);
    }
    
    
    /**
     * Stores current User's username and the name of their User Data File.
     * @param user current User's username
     * PRECONDITION: String user is initialized
     * POSTCONDITION: this.username and this.friendsFile are initialized
     */
    public void setUsername(String user) {
        this.username = user;
        this.friendsFile = username + "friends.txt";
    }
    
    
    /**
     * Accessor for current User's friends list
     * @return current User's friends list
     */
    public ArrayList<String> getFriendsList() {
        return this.Friends;
    }
    
    
}
