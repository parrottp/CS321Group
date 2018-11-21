package Model;

import java.util.*;



/**
 * Creates Messages in format for output and writes them to Files.
 */
public class Message
{
    private String message;
    private String user;
    private final String fileName;
    private FileData fd;
   
    /**
     * Constructs new Message object
     * @param user User sending Message
     * @param message Message User is sending
     * @param fileName Name of output File
     */
    public Message(String user, String message, String fileName) 
    {
        this.user = user;
        this.message = message;
        this.fileName = fileName;
        this.fd = FileData.getInstance();
        writeMessage();
    }
    
    
    /**
     * Obtains current Date and Time when Message object was created
     * @return date and time as a Date object
     * PRECONDITION: None.
     * POSTCONDITION: None.
     */
    private Date timeStamp()
    {
        Date timeStamp = new Date();
        return timeStamp;
    }
    
    
    /**
     * Compiles the parts of the Message into a formatted line for output.
     * @return formatted Message line
     * PRECONDITION: this.user and this.message initialized
     * POSTCONDITION: None.
     */
    private String createMessage() {
        String line = timeStamp() + "\t" + user + ": " + message;           
        return line;
    }
    
    
    /**
     * Uses FileData to write message to File.
     * PRECONDITION: this.user, this.message, this.fileName initialized
     * POSTCONDITION: Formatted message written to File
     */
    private void writeMessage()  {
        fd = FileData.getInstance();
        fd.FileWrite(createMessage(), fileName);
    }
    
    
    /**
     * Mutator for value of message
     * @param m new value of message
     */
    public void setMessage(String m)
    {
        message = m;
    }
    
    
    /**
     * Accessor for value of message
     * @return message
     */
    public String getMessage()
    {
        return message;
    }
    
    
    /**
     * Mutator for value of user
     * @param u new value of user
     */
    public void setUser(String u)
    {
        user = u;
    }
    
    
}
