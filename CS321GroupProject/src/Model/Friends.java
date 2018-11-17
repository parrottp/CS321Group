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
    
    public ArrayList<String> pFriendsAdd() throws IOException
    {        
        
        return potentialFriends;
    }
    
    public ArrayList<String> FriendListAdd(String user)
    {
        Friends.add(user);
        return Friends;
    }
    
    public ArrayList<String> pFriendsRemove(ArrayList<String> pFriends)
    {
        potentialFriends = pFriends;
        String temp;
    
        
        return potentialFriends;
    }
    
   
}
