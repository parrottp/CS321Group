package UserProfile;

/**
 *
 * @author livweaver
 */

import java.io.*;
import java.util.*;
import java.util.Scanner;

public class UserInput extends DataLoader
{
    
        /**  
        * Read string from user, parse into array and return. 
        *
        */ 
        String UserLoad()
        {
          //Read input from user
          Scanner input = new Scanner(System.in);
          
          //Set string to input
          String data = input.nextLine();
          
        return data;
        }
        
        public static void createProfile()
        {
            //View supplemeneted here
            System.out.println("Enter Username");
            System.out.println("Enter Password");
            System.out.println("Enter Game Interested in");
            System.out.println("Enter Age");

            //Read data from user
            DataLoader data = new DataLoader();
            UserInput user = new UserInput();
            data.setString(user.UserLoad());

            //Create file with username
            FileData file = new FileData();
            file.FileCreate(data.getString());
            file.FileWrite(data.getString());

            //Add password, game, and age to user file
            for(int i = 0; i < 3; i++)
            {
                UserInput userData = new UserInput();
                data.setString(userData.UserLoad());
                file.FileWrite(data.getString());
            }
        }

    }
