/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

import java.util.*;
import java.io.FileNotFoundException;
/**
 *  Class to control the process of logging in
 * @author Nick Burns
 */
public class Login {
    
    /**
     * method for testing the functionality of the login classes
     */
    public static void login() {
        // TODO code application logic here
        boolean loggedIn = false;
            System.out.println("*Testing login for known valid login:*");
            System.out.println("Username: catsanddogs");
            System.out.println("Password: applesandoranges");
            
            login("catsanddogs", "applesandoranges");
            
            System.out.print("\n");
            System.out.println("*Testing login for known invalid login:*");
            System.out.println("Username: notarealusername");
            System.out.println("password: notarealpassword");
            
            login("notarealusername", "notarealpassword");
    }
    
    /**
     * Called with parameters to attempt a login by the user
     * @param username
     * @param password 
     */
    private static void login(String username, String password)
    {
        boolean loggedIn = false;
        LoginInfoChecker loginCheck = new LoginInfoChecker(username, password);
        try
        {
            loggedIn = loginCheck.validateLogin();
        }
        catch(FileNotFoundException e)
        {
            e.printStackTrace();
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
    
    /**
     * will be implemented to give the user the option to register from login screen
     */
    private static void register()
    {
        LoginRegister lrg = new LoginRegister();
    }
}
