package Model;

import java.text.ParseException;

/**
 *
 * @author livweaver
 */
public class UserProfileModel {
    private String fileName;
    
    private String firstname;
    private String lastname;
    private String username;
    private String password;
    private String birthday;
    private String gameInterest;
    
    private String age;
    
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

public void setFileName(String fileName) {
    this.fileName = fileName;
}

public String getFileName() {
    return fileName;
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
      @param newBirthday the new birthday
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
    
   public void setAge(String age) {
       this.age = age;
   }
   
   public String getAge() {
       return age;
   }
   
   /**
     * Called by Controller when the User inputs DoB into JTextField. Sets this.userAge = User's age.
     * PRECONDITION: this.data is a valid String for DoB in the format 'MM/dd/yyyy'
     * @throws ParseException 
     */
    public boolean processBirthdate() throws ParseException { 
        CalculateAge input = new CalculateAge(this.birthday);
        this.age = input.getAge();
        
        return input.happyBirthday();
    }
   
    
    public void registerLoginInfo() {
        Login reg = new Login();
        reg.register(this.username, this.password);
        newUserFile();
    }
    
    
    public void newUserFile() {
        //Create profile data file
        FileData file = new FileData();
        this.fileName = this.username + ".txt";
        file.FileCreate(fileName);                  //file name is username.txt
        file.FileWrite(this.username, fileName);
        file.FileWrite(this.password, fileName);
        file.FileWrite(this.firstname, fileName);
        file.FileWrite(this.lastname, fileName);
        file.FileWrite(this.birthday, fileName);
        file.FileWrite(this.gameInterest, fileName);
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