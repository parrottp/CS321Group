package Controller;

import Controller.LoginController;
import Model.Model;
import View.RegisterView;
import View.LoginView;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 * Controller for Register process of program
 * @author livweaver, noahe
 */
public class RegisterController 
{
    //Model and View for this instance of RegisterController
    private Model model;
    private RegisterView view;
    ImageIcon logo = new ImageIcon("logo.png");
    
    //Model, View and Controller for LoginController called by RegisterController
    Model lm;
    LoginView lv;
    LoginController lc;
    
    //Used to check if current day is Registered User's birthday
    private boolean isBirthday;
    
    /**
     * Constructs RegisterController with input Model and RegisterView
     * @param m input Model
     * @param v input RegisterView
     */
    public RegisterController(Model m, RegisterView v)
    {
        model = m;
        view = v;
        
        //Initializes RegisterView with initial values of input Model
        initialView();
    }
    
    
    /**
     * Initializes the RegisterView with the initial values of all user data fields in Model, which are prompts for user input.
     * PRECONDITIONS: this.model and this.view must be initialized.
     * POSTCONDITIONS: RegisterView updated with initial values.
     */
    public void initialView()
    {
        view.getFirstnameTextfield().setText(model.getFirstname());     //Updates RegisterView to display "Please enter first name" in JTextField for firstname
        view.getLastnameTextfield().setText(model.getLastname());       //Updates RegisterView to display "Please enter last name" in JTextField for lastname
        view.getUsernameTextfield().setText(model.getUsername());       //Updates RegisterView to display "Please enter username" in JTextField for username
        view.getPasswordTextfield().setText(model.getPassword());       //Updates RegisterView to display "Please enter password" in JPassworldField for password, which is hidden
        view.getBirthdayTextfield().setText(model.getBirthday());       //Updates RegisterView to display "MM/dd/yyyy" in JTextField for birth date
        view.getGameTextfield().setText(model.getGameInterest());       //Updates RegisterView to display "Please enter game" in JTextField for game interest
    }
    
    
    /**
     * Initializes the RegisterController to read action listener for Register button.
     * PRECONDITIONS: this.model and this.view must be initialized. 
     * POSTCONDITIONS: Register button in Register GUI is functional.
     */
    public void initialController()
    {
        //Action Listener for Register button
        view.getCreateProfileButton().addActionListener(e -> {
            try {
                //Creates profile with input data when button pressed
                createProfile();
            } catch (ParseException ex) {
                Logger.getLogger(RegisterController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }
    
    
    /**
     * Attempts to Register new User with input Data. Rejects invalid inputs.
     * @throws ParseException 
     * PRECONDITIONS: this.model and this.view are initialized.
     * POSTCONDITIONS: New User Data File created, User's username added to MasterList of registered users, Register page closes, Login page opens.
     */
    private void createProfile() throws ParseException
    {
        model.setFirstname(view.getFirstnameTextfield().getText());                     //Loads firstName into Model from GUI input
        model.setLastname(view.getLastnameTextfield().getText());                       //Loads lastName into Model from GUI input
        model.setUsername(view.getUsernameTextfield().getText());                       //Loads username into Model from GUI input
        model.setPassword(new String(view.getPasswordTextfield().getPassword()));       //Loads password into Model from GUI input
        model.setGameInterest(view.getGameTextfield().getText());                       //Loads gameInterest into Model from GUI input
        model.setBirthday(view.getBirthdayTextfield().getText());                       //Loads birthDate into Model from GUI input
        
        //Catchs invalid inputs
        if (model.processBirthdate()) {                          //Processes birthDate in Model into age
            this.isBirthday = true;                              //Updates based on birthay check in processBirthdate()
        }
        if (model.getInvalidDateInput()) {                       //Checks if the input birthDate is a valid date
            invalidDate();                                       //Outputs error message if date invalid
            return;                                              //Allows User to input new data
        }
        if (model.checkUsername()) {                             //Checks if the input username is in use
            usernameTaken();                                     //Outputs error message if username is taken
            return;                                              //Allows User to input new data
        }
        
        //Once all inputs are valid
        else {
            //Displays Welcome message for a successful registration
            JOptionPane.showMessageDialog(null, "Welcome " + model.getUsername() + "!", "Profile Created",JOptionPane.PLAIN_MESSAGE, logo);
            
            //Displays Happy Birthday message if current day is User's birthday
            if(this.isBirthday == true) {
                happyBirthday();
            }
            
            //Creates new User Data File for successful registration
            model.newUserFile();
            
            //Updates MasterList with User's username
            model.updateMasterList();
            
            //Closes Registration Page
            view.close();
            
            //Opens Login Page
            login();
        }
    }
    
    
    /**
     * Opens Login page.
     * PRECONDITIONS: None.
     * POSTCONDITIONS: Login page is opened. 
     */
    public void login() {
        this.lm = new Model("Please enter username", "Please enter password");
        this.lv = new LoginView("Login");
        this.lc = new LoginController(lm, lv);
        lc.initialController();
    }
    
    
    /**
     * Displays error message for Invalid Birth Date to Register GUI.
     * PRECONDITIONS: None.
     * POSTCONDITIONS: Invalid Date message displayed in Register GUI.
     */
    public void invalidDate() {
        JOptionPane.showMessageDialog(null, "Please input Date of Birth in the following format: MM/dd/yyyy", "Invalid Date", JOptionPane.PLAIN_MESSAGE);
    }
    
    
    /**
     * Displays Happy Birthday message if User's DoB is the same as current day.
     * PRECONDITIONS: None.
     * POSTCONDITIONS: Happy Birthday message displayed in Register GUI.
     */
    public void happyBirthday() {
        JOptionPane.showMessageDialog(null, "Happy " + model.getAge() + "th Birthday!", "Happy Birthday!", JOptionPane.PLAIN_MESSAGE, logo);
    }
    
    
    /**
     * Displays error message for Invalid Username to Register GUI.
     * PRECONDITIONS: None.
     * POSTCONDITIONS: Invalid Username message displayed in Register GUI.
     */
    public void usernameTaken() {
        JOptionPane.showMessageDialog(null, "I'm sorry, this username is taken.", "Invalid Username", JOptionPane.PLAIN_MESSAGE);
    }
    
}
