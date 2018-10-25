/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import java.util.*;
import java.io.FileNotFoundException;
/**
 *
 * @author Taquito Jr
 */
public class Login {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner inputScanner = new Scanner(System.in);
        boolean loggedIn = false;
        while(!loggedIn)
        {
            System.out.println("Enter L to login or enter R to register.");
            String response = inputScanner.next();
            
            if(response.equalsIgnoreCase("L"))
            {
                login();
            }
            else if(response.equalsIgnoreCase("r"))
            {
                register();
            }
        
        }
    }
    private static void login()
    {
        boolean loggedIn = false;
        Scanner inputScanner = new Scanner(System.in);
        while(!loggedIn)
        {
            System.out.println("Please input your username:\n");
            String username = inputScanner.nextLine();
            
            System.out.println("Please input your password:\n");
            String password = inputScanner.nextLine();
            
            LoginInfoChecker loginCheck = new LoginInfoChecker(username, password);
            try
            {
                loggedIn = loginCheck.validateLogin();
            }
            catch(FileNotFoundException e)
            {
                System.out.println("Login file not found. Exiting program.");
                System.exit(0);
            }
        
            if(loggedIn)
            {
                System.out.println("Login successful");
            }
            else
            {
                System.out.println("Login unsuccessful. Please try again");
            }
        }
    }
    
    private static void register()
    {
        LoginRegister lrg = new LoginRegister();
    }
}
