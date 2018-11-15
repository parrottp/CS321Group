package Model;

import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author livweaver, noahe
 */
public class RegisterController 
{
    
    private Model model;
    private RegisterView view;
    
    private boolean isBirthday;
    
    //login() Stuff
    Model lm;
    LoginView lv;
    LoginController lc;
    
    
    
    //constructor
    public RegisterController(Model m, RegisterView v)
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
                Logger.getLogger(RegisterController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }
    
    private void createProfile() throws ParseException
    {
        model.setFirstname(view.getFirstnameTextfield().getText());                     //Loads firstName into Model from GUI input
        model.setLastname(view.getLastnameTextfield().getText());                       //Loads lastName into Model from GUI input
        model.setUsername(view.getUsernameTextfield().getText());                       //Loads username into Model from GUI input
        model.setPassword(new String(view.getPasswordTextfield().getPassword()));       //Loads password into Model from GUI input
        model.setGameInterest(view.getGameTextfield().getText());                       //Loads gameInterest into Model from GUI input
        model.setBirthday(view.getBirthdayTextfield().getText());                       //Loads birthDate into Model from GUI input
        
        
        if (model.processBirthdate()) {                                                 //Processes birthDate in Model into age
            this.isBirthday = true;                                                     //Updates based on birthay check in processBirthdate()
        }
        if (model.getInvalidDateInput()) {
            invalidDate();
            return;
        }
        if (model.register()) {
            usernameTaken();
            return;
        }
        
        else {
            JOptionPane.showMessageDialog(null, "Welcome " + model.getUsername() + "!", "Profile Created", JOptionPane.INFORMATION_MESSAGE);
            happyBirthday();
            model.newUserFile();
            model.updateMasterList();
            view.close();
            
            login();
        }
    }
    
    public void login() {
        this.lm = new Model("Please enter username", "Please enter password");
        this.lv = new LoginView("Login");
        this.lc = new LoginController(lm, lv);
        lc.initialController();
    }
    
    public void invalidDate() {
        JOptionPane.showMessageDialog(null, "Please input Date of Birth in the following format: MM/dd/yyyy", "Invalid Date", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void happyBirthday() {
        JOptionPane.showMessageDialog(null, "Happy " + model.getAge() + "th Birthday!", "Happy Birthday!", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void usernameTaken() {
        JOptionPane.showMessageDialog(null, "I'm sorry, this username is taken.", "Invalid Username", JOptionPane.INFORMATION_MESSAGE);
    }
    
}
