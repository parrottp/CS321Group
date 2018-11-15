/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author livweaver, noahe
 */
public class GUIDriver {
    
    public static void main(String[]args)
    {
        login();
        //register();
    }
    
    public static void login() {
        Model m = new Model("Please enter username", "Please enter password");
        LoginView v = new LoginView("Login");
        LoginController c = new LoginController(m,v);
        c.initialController();
    }
    
    public static void register() {
        Model m = new Model("Please enter first name", "Please enter last name", "Please enter username", "Please enter password", "MM/DD/YYYY", "Please enter game");
        RegisterView v = new RegisterView("Create Profile");
        RegisterController c = new RegisterController(m,v);
        c.initialController();
    }
    
}
