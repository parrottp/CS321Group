
package Model;

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
     * LoginChecker object holds the username and password for the 
     * login attempt
     * @param username
     * @param password 
     */
    public LoginInfoChecker(String username, String password)
    {
        this.username = username;
        this.password = password;
        loginFile = new File("RegisteredLogins.txt");
    }
    
    /**
     * verifies the login information attributes against the file
     * containing known login info
     * @return
     * @throws FileNotFoundException 
     */
    public boolean validateLogin() throws FileNotFoundException
    {
        boolean uTrue = false;
        String line = null;
        Scanner loginScanner;
        
        loginScanner = new Scanner(loginFile);
        
        
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
        
        if(!uTrue)
        {
            loginScanner.close();
            return false;
        }
        
        if(loginScanner.nextLine().equals("p:"+password))
        {
            loginScanner.close();
            return true;
        }
        else
        {
            loginScanner.close();
            return false;
        }
    }
    
    /**
     * When registering is implemented this method tests whether
     * a username is taken
     * @param username
     * @return
     * @throws FileNotFoundException 
     */
    public Boolean findUsername(String username) throws FileNotFoundException
    {
        Scanner loginScanner;
        String line = null;
        
        loginScanner = new Scanner(loginFile);
        
        
        line = loginScanner.nextLine();
        while(loginScanner.hasNext())
        {
            System.out.println(line);
            if(line.equals("u:" + username))
            {
                loginScanner.close();
                return true;
            }
            line = loginScanner.nextLine();
        }
        loginScanner.close();
        return false;
    }
}
