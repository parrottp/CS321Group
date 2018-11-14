package Model;

import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        view.getCreateProfileButton().addActionListener(e -> {
            try {
                createProfile();
            } catch (ParseException ex) {
                Logger.getLogger(UserProfileController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }
    
    private void createProfile() throws ParseException
    {
        model.setFirstname(view.getFirstnameTextfield().getText());                     //Loads firstName into Model from GUI input
        model.setLastname(view.getLastnameTextfield().getText());                       //Loads lastName into Model from GUI input
        model.setUsername(view.getUsernameTextfield().getText());                       //Loads username into Model from GUI input
        model.setPassword(new String(view.getPasswordTextfield().getPassword()));       //Loads password into Model from GUI input
        
        model.setBirthday(view.getBirthdayTextfield().getText());                       //Loads birthDate into Model from GUI input
        if (model.processBirthdate()) {                                                 //Processes birthDate in Model into age
            happyBirthday();                                                            //Prints happy birthday message if birthday
        }
        
        model.setGameInterest(view.getGameTextfield().getText());                       //Loads gameInterest into Model from GUI input
        
        if (model.register()) {
            usernameTaken();
        }
        else {
            JOptionPane.showMessageDialog(null, "Welcome "+ model.getUsername()+ "!", "Profile Created", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public void happyBirthday() {
        JOptionPane.showMessageDialog(null, "Happy " + model.getAge() + "th Birthday!", "Happy Birthday!", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void usernameTaken() {
        JOptionPane.showMessageDialog(null, "I'm sorry, this username is taken.", "Invalid Username", JOptionPane.INFORMATION_MESSAGE);
    }
    
}