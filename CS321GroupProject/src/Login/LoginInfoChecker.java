/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;
/**
 *
 * @author Taquito Jr
 */
import java.util.*;
import java.io.*;

public class LoginInfoChecker {
    private String username = "";
    private String password = "";
    private File loginFile;
    
    public LoginInfoChecker(String username, String password)
    {
        this.username = username;
        this.password = password;
        loginFile = new File("RegisteredLogins.txt");
    }
    
    public boolean validateLogin() throws FileNotFoundException
    {
        boolean uTrue = false;
        boolean pTrue = false;
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
