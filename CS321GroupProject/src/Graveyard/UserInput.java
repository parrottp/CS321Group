package Graveyard;

/**
 *
 * @author livweaver
 */

import Model.DataLoader;
import java.io.*;
import java.util.*;
import java.util.Scanner;

public class UserInput extends DataLoader
{
    
        /**  
        * Read string from user, parse into array and return. 
        *
        */ 
        String UserLoad() {
            //Read input from user
            Scanner input = new Scanner(System.in);
          
            //Set string to input
            String data = input.nextLine();
          
            return data;
        }
}