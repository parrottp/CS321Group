package UserProfile;

/**
 *
 * @author livweaver
 */

import java.util.*;

public class UserData
{
    /**
      Creates UserData object.
      @param aUsername username string
      @param aPassword password string
      @param aGameInterest game title string
      @param aAge age string
   */
    public UserData(String aUsername, String aPassword, String aGameInterest, String aAge)
    {
       username = aUsername;
       password = aPassword;
       gameInterest = aGameInterest;
       age = aAge;
    }
    
    /**
      Set username
      @param newUsername the new password
   */
   public void setUsername(String newUsername)
   {
      password = newUsername;
   }
   
   /**
      Get username.
   */
   public String getUsername()
   {
      return username;
   }
   
   /**
      Set password
      @param newPassword the new password
   */
   public void setPassword(String newPassword)
   {
      password = newPassword;
   }

    /**
      Set gameInterest
      @param newGameInterest the new game interest title
   */
   public void setGameInterest(String newGameInterest)
   {
      gameInterest = newGameInterest;
   }
   
   /**
      Get gameInterest.
   */
   public String getGameInterest()
   {
      return gameInterest;
   }
   
    /**
      Set age.
      @param newAge the new age
   */
   public void setAge(String newAge)
   {
      age = newAge;
   }
   
   /**
      Get age.
   */
   public String getAge()
   {
      return age;
   }
    
   /**
   Check if the password is correct.
   @param aPassword a password to check
   @return true if the supplied password matches the user entered password.
   */
   public boolean checkPassword(String aPassword)
   {
      return aPassword.equals(password);
   }
   
    private String username;
    private String password;
    private String gameInterest;
    private String age;
    
}
