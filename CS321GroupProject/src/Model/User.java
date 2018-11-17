package Model;

/**
 *
 * @author livweaver
 */

import java.util.*;

public class User
{
    private String firstname;
    private String lastname;
    private String username;
    private String password;
    private String birthday;
    private String gameInterest;
    private int level;
    private int messagesSent;
    
    //
    //
    //Class constructors
    //
    //
    
    /**
     * User constructor for a registerController
     * @param firstname
     * @param lastname
     * @param username
     * @param password
     * @param birthday
     * @param aGameInterest 
     */
    public User(String firstname, String lastname, String username, String password, String birthday, String aGameInterest, int messagesSent)
    {
       this.firstname = firstname;
       this.lastname = lastname;
       this.username = username;
       this.password = password;
       this.birthday = birthday;
       this.gameInterest = gameInterest;
       this.messagesSent = messagesSent;
    }
    
    /**
     * User constructor for a loginController
     * @param username
     * @param password 
     */
    public User(String username, String password)
    {
        this.username = username;
        this.password = password;
    }
    
    /**
     * User constructor for a HomePageController
     * @param username
     * @param birthday
     * @param gameInterest 
     */
    public User(String username, String birthday, String gameInterest)
    {
        this.username = username;
        this.birthday = birthday;
        this.gameInterest = gameInterest;
    }
    
    //
    //Class get and set methods
    //
   
   /**
    * Returns the Username
    * @return 
    */
   public String getUsername()
   {
      return username;
   }
   
   /**
    * Set the username
    * @param username 
    */
   public void setUsername(String username)
   {
       this.username = username;
   }
   
   /**
    * Returns the User password
    * @return 
    */
   public String getPassword()
   {
       return password;
   }
   
   /**
    * Sets the password
    * @param newPassword 
    */
   public void setPassword(String newPassword)
   {
      password = newPassword;
   }
   
   /**
    * Returns the firstname
    * @return 
    */
   public String getFirstName()
   {
       return firstname;
   }
   
   /**
    * Sets the firstname
    * @param firstname 
    */
   public void setFirstName(String firstname)
   {
       this.firstname = firstname;
   }
   
   /**
    * Returns the lastname
    * @return 
    */
   public String getLastName()
   {
       return lastname;
   }
   
   /**
    * Sets the lastname
    * @param lastname 
    */
   public void setLastname(String lastname)
   {
        this.lastname = lastname;
   }
   
   /**
    * Returns the gameInterest
    * @return 
    */
   public String getGameInterest()
   {
        return gameInterest;
   }
   
   /**
    * Sets the gameInterest
    * @param gameInterest 
    */
   public void setGameInterest(String gameInterest)
   {
        this.gameInterest = gameInterest;
   }
   
   /**
    * Returns birthday
    * @return 
    */
   public String getBirthday()
   {
        return birthday;
   }
   
   /**
    * Sets the birthday
    * @return 
    */
   public void setBirthday(String birthday)
   {
        this.birthday = birthday;
   }
   
   /**
    * Returns the level
    * @return 
    */
   public int getLevel()
   {
       this.calculateLevel();
       return level;
   }
   
   /**
    * Returns the level
    * @param level 
    */
   public void setLevel(int level)
   {
       this.level = level;
   }
   
   /**
    * calculates the level based on messagesSent
    */
   private void calculateLevel()
   {
       level = (messagesSent/5);
   }
   
   /**
    * Returns the messagesSent
    * @return 
    */
   public int getMessagesSent()
   {
       return messagesSent;
   }
   
   /**
    * Sets the messagesSent
    * @param messagesSent 
    */
   public void setMessagesSent(int messagesSent)
   {
       this.messagesSent = messagesSent;
   }
}
