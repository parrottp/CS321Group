package Controller;

import Model.Model;
import View.RegisterView;
import View.HomePageView;
import View.LoginView;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;



/**
 * Controller for Login process of program.
 */
public class LoginController {
    //Model and View for this instance of LoginController
    private final Model model;
    private final LoginView view;
    private ImageIcon logo = new ImageIcon("logo.png");
    
    //Model, View, and Controller for RegisterController called by LoginController
    private Model rm;
    private RegisterView rv;
    private RegisterController rc;
    
    //Model, View, and Controller for HomePageController called by LoginController
    private Model hm;
    private HomePageView hv;
    private HomePageController hc;
    
    
    /**
     * Constructs LoginController with input Model and LoginView.
     * @param m input Model
     * @param v input LoginView
     * PRECONDITION: Model m and LoginView v must be initialized. 
     * POSTCONDITION: Login GUI is displayed with initial values. 
     */
    public LoginController(Model m, LoginView v)
    {
        this.model = m;
        this.view = v;
        
        //Initializes LoginView with initial values of input Model
        initialView();
    }
    
    
    /**
     * Initializes the LoginView with the initial values of username and password in Model, which are prompts for user input.
     * PRECONDITION: this.model and this.view must be initialized.
     * POSTCONDITION: LoginView updated with initial values.
     */
    private void initialView()
    {
        view.getUsernameTextfield().setText(model.getUsername());   //Updates LoginView to display "Please enter username" in JTextField for username
        view.getPasswordTextfield().setText(model.getPassword());   //Updates LoginView to display "Please enter password" in JPasswordField for password, which is hidden
    }
    
    
    /**
     * Initializes the LoginController to read action listeners for Login button and Register button on Login page.
     * PRECONDITION: this.model and this.view must be initialized. 
     * POSTCONDITION: Login and Register buttons in Login GUI are functional.
     */
    public void initialController()
    {
        //Action Listener for Login button
        view.getLoginButton().addActionListener(e -> {
            login();
        });
        
        //Action Listener for Register button
        view.getRegisterButton().addActionListener(e -> {
            register();
        });
    }
    
    
    /**
     * Attempts to Login the User with the input information. Displays error messages until login is successful, then closes Login window.
     * PRECONDITION: None.
     * POSTCONDITION: Logged in successfully. Main Chat Client opened for logged in User.
     */
    private void login() {
        //Loads username and password into Model from User input in GUI
        model.setUsername(view.getUsernameTextfield().getText());                       
        model.setPassword(new String(view.getPasswordTextfield().getPassword()));       
        
        
        //Checks if input Username exists in list of Registered Users
        if (model.checkUsername()) {
            //Checks if input Password is correct for input Username
            if (model.checkPassword()) {
                //Loads age and game interest into Model from User Data File
                try {
                    model.readDataFile();
                } catch (ParseException ex) {
                    Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
                //Displays successful login message and closes Login page
                JOptionPane.showMessageDialog(null, "Welcome "+ model.getUsername()+ "!", "Login Successful", JOptionPane.PLAIN_MESSAGE, logo);
                view.close();      
                
                
                try {
                    //Opens Main Chat Client GUI here
                    launchClient();
                } catch (ParseException ex) {
                    Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
            else {
                invalidPassword();  //Displays error message if input password is invalid
            }
        }
        else {
            invalidUsername();  //Displays error message if input username is invalid
        }
    }
    
    
    /**
     * Closes Login page and opens Register page.
     * PRECONDITION: None.
     * POSTCONDITION: Register page is opened, and Login page is closed. 
     */
    private void register()
    {
        view.close();
        
        this.rm = new Model("Please enter first name", "Please enter last name", "Please enter username", "Please enter password", "MM/DD/YYYY", "Please enter game");
        this.rv =  new RegisterView("Create Profile");
        this.rc = new RegisterController(rm, rv);
        rc.initialController();
    }
    
    
    /**
     * Initializes new HomePage using logged in User's information
     * @throws ParseException 
     * PRECONDITION: Model model initialized with User data for username, age, game interest, level, and friends list.
     * POSTCONDITION: HomePage launched and fully functional.
     */
    private void launchClient() throws ParseException {
        this.hm = new Model(model.getUsername(), model.getAge(), model.getGameInterest(), model.getLevel());
        this.hv = new HomePageView("Profile", hm.getFriendsList());
        this.hv.setVisible(true);
        this.hc = new HomePageController(hm, hv);
        
        this.hc.initialController();          
    }
    
    
    /**
     * Displays error message for Invalid Username to Login GUI.
     * PRECONDITION: None.
     * POSTCONDITION: Invalid Username message displayed in Login GUI.
     */
    private void invalidUsername() {
        JOptionPane.showMessageDialog(null, "I'm sorry, this username does not exist.", "Invalid Username", JOptionPane.PLAIN_MESSAGE);
    }
    
    
    /**
     * Displays error message for Invalid Password to Login GUI,
     * PRECONDITION: None.
     * POSTCONDITION: Invalid Password message displayed in Login GUI.
     */
    private void invalidPassword() {
        JOptionPane.showMessageDialog(null, "I'm sorry, the password is incorrect.", "Incorrect Password", JOptionPane.PLAIN_MESSAGE);
    }
    
    
}
