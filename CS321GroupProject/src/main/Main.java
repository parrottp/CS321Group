/**
 * THIS MAIN METHOD/CLASS WILL BE USED TO DEMONSTRATE OUR
 * PROGRAMS FOR PROGRESS REPORT 1
 */
package main;
import Login.*;
import message.*;
import UserProfile.*;
/**
 *
 * @author parro
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Login.login();
        
        UserInput.createProfile();
        
        Message.main(args);
    }
    
}
