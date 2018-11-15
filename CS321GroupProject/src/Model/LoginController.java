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
    
    
    //constructor
    public LoginController(Model m, LoginView v)
    {
        model = m;
        view = v;
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
        
        //view.getRegisterButton().addActionListener(e -> {
        //    register();
        //});
    }
    
    public void login() {
        model.setUsername(view.getUsernameTextfield().getText());                       //Loads username into Model from GUI input
        model.setPassword(new String(view.getPasswordTextfield().getPassword()));       //Loads password into Model from GUI input
        
        if (model.checkUsername()) {
            if (model.checkPassword()) {
                //login();
                JOptionPane.showMessageDialog(null, "Welcome "+ model.getUsername()+ "!", "Login Successful", JOptionPane.INFORMATION_MESSAGE);
                view.close();       //Closes the login window
            }
            else {
                invalidPassword();
            }
        }
        else {
            invalidUsername();
        }
    }
    
    //public void register()
    //{
    //    
    //}
    
    public void invalidUsername() {
        JOptionPane.showMessageDialog(null, "I'm sorry, this username does not exist.", "Invalid Username", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void invalidPassword() {
        JOptionPane.showMessageDialog(null, "I'm sorry, the password is incorrect.", "Incorrect Password", JOptionPane.INFORMATION_MESSAGE);
    }
}
