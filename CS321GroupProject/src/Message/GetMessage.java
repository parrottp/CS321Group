/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Message;
import java.util.*;

public class GetMessage 
{
    private String message;
    public void setMessage(String m)
    {
        message = m;
    }
    
    public String getMessage()
    {
        return message;
    }
    
    public Date timeStamp()
    {
        Date timeStamp = new Date();
        return timeStamp;
    }
    
    public void creatMessage()
    {
        
    }
}
