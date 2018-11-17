/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Friends 
{
    FileData fileData = new FileData();
    ArrayList<String> potentialFriends;
    ArrayList<String> Friends;
    ArrayList<String> MasterList;
    String username;
    String User;
    String friendsFile;
   
    
    /**
     * When User class is implemented change input to User
     * @param username 
     */
    public Friends (String username)
    {
        this.username = username;
    }

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
    public ArrayList<String> FriendsListLoad (String filename)
    {
        this.Friends = fileData.FileLoadList(filename);
        return this.Friends;
    }
    /**
     * Adds user to Friends ArrayList<> and writes to a file
     * PRECONDTIONS: selecting user
     * POSTCONDITIONS: selected user is added to Friends
     * @param user String
     * @return Friends 
     */
    public ArrayList<String> FriendListAdd(String user)
    {
        
        Friends.add(user);
        fileData.FileWrite(user, friendsFile);
        return Friends;
    }
    /**
     * Removes user from potential friends list
     * PRECONDITIONS: potentialFriends is populated and user has been added to 
     * Friends List
     * POSTCONDITION: Selected user has been removed from potential friends
     * @param pFriends ArrayList<>
     * @param user String
     * @return potentialFriends
     */
    public ArrayList<String> pFriendsRemove(ArrayList<String> pFriends, String user)
    {
        potentialFriends = pFriends;
        potentialFriends.remove(user);
        return potentialFriends;
    }
    
   
}
