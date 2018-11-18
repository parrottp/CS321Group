package Model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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
    
    FileData fileData = FileData.getInstance();
    ArrayList<String> potentialFriends;
    ArrayList<String> Friends;
    ArrayList<String> MasterList;
    String username;
    String User;
    String friendsFile;
  
    
    
     /**
     * Stores master list of users into potential friends list
     * PRECONDITIONS: MasterList is populated
     * POSTCONDITIONS: potentialFriends is initialized
     * @return potentialFriends
     */
    public ArrayList<String> pFriendsLoad()
    {        
        MasterList = fileData.FileLoadList("MasterList.txt");
        potentialFriends = (ArrayList<String>)MasterList.clone(); 
        potentialFriends.removeAll(Friends);
        return potentialFriends;
    }
    
    
    /**
     * Stores friends list into ArrayList<>
     * PRECONDITIONS: Friends is populated
     * POSTCONDITIONS: Friends is initialized
     * @return Friends
     * 
     */
    public ArrayList<String> FriendsListLoad()
    {
        this.Friends = fileData.FileLoadList(this.friendsFile);
        return this.Friends;
    }
    
    
    /**
     * Adds user to Friends ArrayList<> and writes to a file
     * PRECONDTIONS: selecting user
     * POSTCONDITIONS: selected user is added to Friends
     * @param user String
     * @return Friends 
     * 
     * 
     */
    public ArrayList<String> FriendListAdd(String user)
    {
        Friends.add(user);
        fileData.FileWrite(user, friendsFile);
        return Friends;
    }
    
    
    /**
     * Removes user from potential friends list
     * @param pFriends ArrayList<>
     * @param user String
     * @return potentialFriends
     * PRECONDITIONS: potentialFriends is populated and user has been added to Friends List
     * POSTCONDITION: Selected user has been removed from potential friends
     */
    public ArrayList<String> pFriendsRemove(String user)
    {
        potentialFriends.remove(user);
        return potentialFriends;
    }
    
    
    //Returns true if the input String is in the list of potential friends
    public boolean isNewFriendValid(String friend) {
        return this.potentialFriends.contains(friend);
    }
    
    
    /**
     * 
     * @param user 
     */
    public void setUsername(String user) {
        this.username = user;
        this.friendsFile = username + "friends.txt";
    }
   
}
