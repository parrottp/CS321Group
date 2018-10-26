/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

import java.util.*;
import java.io.*;

/**
 * Checks User login info by scanning File of User data to see if input credentials match stored values
 * @author Nicholas Burns
 */
public class LoginInfoChecker {
    private String username = "";
    private String password = "";
    private File loginFile;
    
    
    /**
     * Constructs LoginInfoChecker object
     * @param username User input username
     * @param password User input password
     */
    public LoginInfoChecker(String username, String password)
    {
        this.username = username;
        this.password = password;
        loginFile = new File("RegisteredLogins.txt");
    }
    
    
    /**
     * Validates login credentials
     * @return true if valid username AND password, false if invalid username OR password
     * @throws FileNotFoundException 
     */
    public boolean validateLogin() throws FileNotFoundException
    {
        boolean uTrue = false;
        boolean pTrue = false;
        String line = null;
        Scanner loginScanner;
        
        loginScanner = new Scanner(loginFile);
        
        //Validates username
        line = loginScanner.nextLine();
        while(loginScanner.hasNext())
        {
            if(line.equals("u:" + username))
            {
                uTrue = true;
                break;
            }
            line = loginScanner.nextLine();
        }
        
        //Stops if username not valid
        if(!uTrue)
        {
            loginScanner.close();
            return false;
        }
        
        //Validates password if username is valid
        if(loginScanner.nextLine().equals("p:"+password))
        {
            loginScanner.close();
            return true;
        }
        //Stops if password not valid
        else 
        {
            loginScanner.close();
            return false;
        }
    }
    
    
    /**
     * During registration, checks if an input username is already taken by another User 
     * @param username input username
     * @return true if username is taken, false is username is NOT taken
     * @throws FileNotFoundException 
     */
    public boolean isUsernameTaken(String username) throws FileNotFoundException
    {
        Scanner loginScanner;
        String line = null;
        
        //Opens File of Registered Users in a new Scanner
        loginScanner = new Scanner(loginFile);
        
        //Return true if username found in file
        line = loginScanner.nextLine();
        while(loginScanner.hasNext())
        {
            if(line.equals("u:" + username)) 
            {
                loginScanner.close();
                return true;
            }
            line = loginScanner.nextLine();
        }
        loginScanner.close();   //Close loginScanner when done
        
        return false;   //Return false if username not found in file
    }
    
    
}
