/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graveyard;

import Model.FileData;
import Model.FileData;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Message extends FileData
{
    private String message;
    private String user;
    private final String fileName;
   
    /**
     * Constructs new Message object
     * @param fileName 
     */
    public Message(String fileName) 
    {
        this.fileName = fileName;
    }
    
    /**
     * Modifies value of message
     * @param m new value of message
     */
    public void setMessage(String m)
    {
        message = m;
    }
    
    /**
     * Returns value of message
     * @return message
     */
    public String getMessage()
    {
        return message;
    }
    
    /**
     * Modifies value of user
     * @param u new value of user
     */
    public void setUser(String u)
    {
        user = u;
    }
    
    /**
     * Obtains current Date and Time when Message object was created
     * @return date and time as a Date object
     */
    public Date timeStamp()
    {
        Date timeStamp = new Date();
        return timeStamp;
    }
    
    /**
     * Compiles the parts of the Message into a formatted line for output.
     * @return formatted Message line
     */
    private String createMessage() {
        String line = user + ": " + message + "\t\t\t\t\t" + timeStamp();           
        return line;
    }
    
    
    /**
     * Uses FileData to write message to File
     */
    public void writeMessage()  {
        FileData fd = new FileData();
        String s = fd.FileWrite(createMessage(), fileName);
    }
}
