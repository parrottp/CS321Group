package Model;

import java.util.ArrayList;

/**
 * Driver that launches GUI.
 * @author livweaver, noahe
 */
public class GUIDriver {
    
    /**
     * Main method of program.
     * @param args command line arguments
     */
    public static void main(String[]args)
    {
        //login();
        String user = " ";
        Friends friends = new Friends(user);
        ArrayList<String> help = new ArrayList<>();
        friends.FriendsListLoad("friendsfile.txt");
        help = friends.pFriendsLoad();
        
        System.out.print(help);
        
    }
        
    /**
     * Initializes Login GUI.
     * PRECONDITION: None.
     * POSTCONDITION: User is logged in, User information is stored in Model, and Chat Client is launched.
     */   
    public static void login() {
        Model m = new Model("Please enter username", "Please enter password");
        LoginView v = new LoginView("Login");
        LoginController c = new LoginController(m,v);
        c.initialController();
    }
    
    //CURRENTLY UNUSED
    public static void register() {
        Model m = new Model("Please enter first name", "Please enter last name", "Please enter username", "Please enter password", "MM/DD/YYYY", "Please enter game");
        RegisterView v = new RegisterView("Create Profile");
        RegisterController c = new RegisterController(m,v);
        c.initialController();
    }
    
}
