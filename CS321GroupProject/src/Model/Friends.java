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
    String User;
    /**
     * Stores master list of users into potential friends list
     * PRECONDITIONS: MasterList is populated
     * POSTCONDITIONS: potentialFriends is initialized
     * @return potentialFriends
     */
    public ArrayList<String> pFriendsAdd()
    {        
        potentialFriends = fileData.FileLoadList("MasterList.txt");
        return potentialFriends;
    }
    
    /**
     * Adds user to Friends ArrayList<>
     * PRECONDTIONS: selecting user
     * POSTCONDITIONS: selected user is added to Friends
     * @param user String
     * @return Friends 
     */
    public ArrayList<String> FriendListAdd(String user)
    {
        Friends.add(user);
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
