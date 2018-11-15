/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

public class Friends 
{
    FileData fileData = new FileData();
    ArrayList<String> potentialFriends;
    ArrayList<String> Friends;
    String User;
    
    public ArrayList<String> pFriendsAdd()
    {
        User = fileData.FileLoad("MasterList.txt");
        
        while(User != null)
        {
            potentialFriends.add(User);
        }
        
        return potentialFriends;
    }
    
    public ArrayList<String> pFriendsRemove(ArrayList<String> pFriends)
    {
        //If statements
        potentialFriends.remove(User);
        return potentialFriends;
    }
    
    public ArrayList<String> FriendListAdd(String user)
    {
        Friends.add(user);
        return Friends;
    }
}
