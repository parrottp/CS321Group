/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserProfile;

/**
 *
 * @author livweaver
 */
public class UserProfileModel {
    private String firstname;
    private String lastname;
    private String username;
    private String password;
    private String birthday;
    private String gameInterest;
    
//Constructor 
public UserProfileModel(String firstname, String lastname, String aUsername, String aPassword, String aBirthday, String aGameInterest)
{
    this.firstname = firstname;
    this.lastname = lastname;
    username = aUsername;
    password = aPassword;
    birthday = aBirthday;
    gameInterest = aGameInterest;
}

public String getFirstname()
{
    return firstname;
}

public void setFirstname(String first)
{
    this.firstname = first;
}

public String getLastname()
{
    return lastname;
}

public void setLastname(String last)
{
    this.lastname = last;
}

    /**
      Set username
      @param newUsername the new password
   */
   public void setUsername(String newUsername)
   {
      username = newUsername;
   }
   
   /**
      Get username.
   */
   public String getUsername()
   {
      return username;
   }
   
    /**
      Get password.
   */
   public String getPassword()
   {
      return password;
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
      Set birthday.
      @param newBirhtday the new birthday
   */
   public void setBirthday(String newBirthday)
   {
      birthday = newBirthday;
   }
   
   /**
      Get birthday.
   */
   public String getBirthday()
   {
      return birthday;
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
   
}
