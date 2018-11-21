package Main;

import Controller.LoginController;
import Model.Model;
import View.LoginView;



/**
 * Driver that launches GUI.
 */
public class Main {
    
    /**
     * Main method of program. Initializes a new Login GUI.
     * @param args command line arguments
     */
    public static void main(String[]args)
    {
        //Initializes Model
        Model m = new Model("Please enter username", "Please enter password");
        
        //Initializes LoginView
        LoginView v = new LoginView("Login");
        
        //Initializes LoginController using Model and LoginView
        LoginController c = new LoginController(m,v);
        
        //Initializes LoginController ActionListeners
        c.initialController();
    }

}
