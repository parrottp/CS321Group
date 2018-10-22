/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package message;
import java.util.*;

public class Message 
{
    private String message;
    private String user;
   
    public void setMessage(String m)
    {
        message = m;
    }
    
    public String getMessage()
    {
        return message;
    }
    
    public void setUser (String u)
    {
        user = u;
    }
    
    public Date timeStamp()
    {
        Date timeStamp = new Date();
        return timeStamp;
    }
    
    public void writeMessage()
    {
        
    }
    
    public void creatMessage()
    {
        
    }
}
