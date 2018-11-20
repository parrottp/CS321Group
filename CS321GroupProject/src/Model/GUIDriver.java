package Model;



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
        login();
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
    
    //UNUSED. FOR TESTING ONLY
    public static void home() {
        Model m = new Model("Username placeholder", "Birthday placeholder", "Game Interest Placeholder", 0);
        HomePageView v = new HomePageView("Profile", m.getFriendsList());
        HomePageController c = new HomePageController(m,v);
    }
    
}
