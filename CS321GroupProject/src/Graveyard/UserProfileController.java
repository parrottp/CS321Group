/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserProfile;

import javax.swing.JOptionPane;

/**
 *
 * @author livweaver
 */
public class UserProfileController 
{
    
    private UserProfileModel model;
    private UserProfileView view;
    
    
    //constructor
    public UserProfileController(UserProfileModel m, UserProfileView v)
    {
        model = m;
        view = v;
        initialView();
    }
    
    public void initialView()
    {
        view.getFirstnameTextfield().setText(model.getFirstname());
        view.getLastnameTextfield().setText(model.getLastname());
        view.getUsernameTextfield().setText(model.getUsername());
        view.getPasswordTextfield().setText(model.getPassword());
        view.getBirthdayTextfield().setText(model.getBirthday());
        view.getGameTextfield().setText(model.getGameInterest());
    }
    
    public void initialController()
    {
        view.getCreateProfileButton().addActionListener(e -> createProfile());
    }
    
    private void createProfile()
    {
        model.setFirstname(view.getFirstnameTextfield().getText());
        model.setLastname(view.getLastnameTextfield().getText());
        model.setUsername(view.getUsernameTextfield().getText());
        model.setPassword(view.getPasswordTextfield().getText());
        model.setBirthday(view.getBirthdayTextfield().getText());
        model.setGameInterest(view.getGameTextfield().getText());
        
        //Create profile data file
        FileData file = new FileData();
        file.FileCreate(model.getUsername()); //file name is username.txt
        file.FileWrite(model.getUsername(), model.getUsername());
        file.FileWrite(model.getPassword(), model.getUsername());
        file.FileWrite(model.getFirstname(), model.getUsername());
        file.FileWrite(model.getLastname(), model.getUsername());
        file.FileWrite(model.getBirthday(), model.getUsername());
        file.FileWrite(model.getGameInterest(), model.getUsername());
        
        JOptionPane.showMessageDialog(null, "Welcome "+ model.getUsername()+ "!", "Profile Created", JOptionPane.INFORMATION_MESSAGE);
    }
    
}
