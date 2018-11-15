/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author livweaver, noahe
 */
public class LoginController {
    private Model model;
    private LoginView view;
    
    //boolean loggedIn = false;
    boolean gotoRegister;
    boolean viewIsOpen;
    
    //RegisterController stuff
    private Model rm;
    private RegisterView rv;
    private RegisterController rc;
    
    
    //constructor
    public LoginController(Model m, LoginView v)
    {
        model = m;
        view = v;
        
        gotoRegister = false;
        viewIsOpen = true;
        
        initialView();
    }
    
    public void initialView()
    {
        view.getUsernameTextfield().setText(model.getUsername());
        view.getPasswordTextfield().setText(model.getPassword());
    }
    
    public void initialController()
    {
        view.getLoginButton().addActionListener(e -> {
            login();
        });
        
        view.getRegisterButton().addActionListener(e -> {
            register();
        });
    }
    
    public void login() {
        model.setUsername(view.getUsernameTextfield().getText());                       //Loads username into Model from GUI input
        model.setPassword(new String(view.getPasswordTextfield().getPassword()));       //Loads password into Model from GUI input
        
        if (model.checkUsername()) {
            if (model.checkPassword()) {
                //login();
                
                JOptionPane.showMessageDialog(null, "Welcome "+ model.getUsername()+ "!", "Login Successful", JOptionPane.INFORMATION_MESSAGE);
                this.viewIsOpen = false;
                view.close();       //Closes the login window
                
                //this.loggedIn = true;
            }
            else {
                invalidPassword();
            }
        }
        else {
            invalidUsername();
        }
    }
    
    public void register()
    {
        view.close();
        
        this.rm = new Model("Please enter first name", "Please enter last name", "Please enter username", "Please enter password", "MM/DD/YYYY", "Please enter game");
        this.rv =  new RegisterView("Create Profile");
        this.rc = new RegisterController(rm, rv);
        rc.initialController();
        //System.out.println("testing");
        //this.gotoRegister = true;
        //this.viewIsOpen = false;
        //
        
    }
    
    public void invalidUsername() {
        JOptionPane.showMessageDialog(null, "I'm sorry, this username does not exist.", "Invalid Username", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void invalidPassword() {
        JOptionPane.showMessageDialog(null, "I'm sorry, the password is incorrect.", "Incorrect Password", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public boolean getGotoRegister() {
        return this.gotoRegister;
    }
    
    public boolean getViewIsOpen() {
        return this.viewIsOpen;
    }
}
