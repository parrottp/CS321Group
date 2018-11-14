
package Model;

import Model.LoginInfoChecker;
import java.io.File;
import java.util.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Nicholas Burns
 */
public class LoginRegister {
    private File loginFile;
    private String username = "";
    private String password = "";
    
    /**
     * login Register constructor which controls the process of registering
     */
    public LoginRegister(String username, String password)
    {
        this.username = username;
        this.password = password;
        loginFile = new File("RegisteredLogins.txt");
        int registerAttempt = 2;
        while(registerAttempt > 0)
        {
            registerAttempt = registerNewLogin();
            if(registerAttempt == 0)
            {
                System.out.println("Registered Successfully");
                break;
            }
            else if(registerAttempt == 1)
            {
                System.out.println("This username is already taken. Please try again.");
                getInfo();
            }
            else
            {
                System.out.println("Your password must be at least 8 characters long.");
                getInfo();
            }
        }
    }
    
    
    /**
     * Method which asks for the intended username and password
     */
    private void getInfo()
    {
        Scanner inputScanner = new Scanner(System.in);
        System.out.println("Username:");
        username = inputScanner.next();
        
        System.out.println("Password:");
        password = inputScanner.next();
    }
    
    
    /**
     * Determines whether username has already been taken
     * @return 
     */
    public int registerNewLogin()
    {
        LoginInfoChecker loginCheck = new LoginInfoChecker(username, password);
        boolean takenUsername = false;
        
        try
        {
            takenUsername = loginCheck.findUsername(username);
        }
        catch(FileNotFoundException e)
        {
            System.out.println("Login info file not found. Exiting program.");
            System.exit(0);
        }
        
        if(takenUsername)
        {
            return 1;
        }
        
        if((password.length() >7)){
            try
            {
                addLogin();
            }
            catch(IOException e)
            {
                System.out.println("IOException encountered while registering.");
                System.exit(0);
            }
            return 0;
        }
        else
        {
            return 2;
        }
    }
    
    
    /**
     * Upon a successful registration, this will add the new login info to the list of registered usernames and passwords
     */
    private void addLogin() throws IOException{
        //FileWriter fw = new FileWriter(loginFile, true);
        //BufferedWriter writer = new BufferedWriter(fw);
        //writer.newLine();
        //writer.append("u:" + username);
        //writer.newLine();
        //writer.append("p:" + password);
        //writer.close();
        
        BufferedWriter writer = new BufferedWriter(new FileWriter(loginFile, true));
        writer.newLine();
        writer.write("u:" + username);
        writer.newLine();
        writer.write("p:" + password);
        writer.close();
        //REGISTERED WITH USERNAME AND PASSWORD. CREATE NEW USER DATA FILE. POPULATE FILE WITH USER DATA FROM GUI
    }
}
