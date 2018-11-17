package Model;

import javax.swing.JOptionPane;

/**
 * Controller for Login process of program
 * @author livweaver, noahe
 */
public class LoginController {
    //Model and View for this instance of LoginController
    private final Model model;
    private final LoginView view;
    
    //Model, View, and Controller for RegisterController called by LoginController
    private Model rm;
    private RegisterView rv;
    private RegisterController rc;
    
    
    /**
     * Constructs LoginController with input Model and LoginView.
     * @param m input Model
     * @param v input LoginView
     * PRECONDITIONS: Model m and LoginView v must be initialized. 
     * POSTCONDITIONS: Login GUI is displayed with initial values. 
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
     * PRECONDITIONS: this.model and this.view must be initialized.
     * POSTCONDITIONS: LoginView updated with initial values.
     */
    private void initialView()
    {
        view.getUsernameTextfield().setText(model.getUsername());   //Updates LoginView to display "Please enter username" in JTextField for username
        view.getPasswordTextfield().setText(model.getPassword());   //Updates LoginView to display "Please enter password" in JPasswordField for password, which is hidden
    }
    
    
    /**
     * Initializes the LoginController to read action listeners for Login button and Register button on Login page.
     * PRECONDITIONS: this.model and this.view must be initialized. 
     * POSTCONDITIONS: Login and Register buttons in Login GUI are functional.
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
     * PRECONDITIONS: None.
     * POSTCONDITIONS: Logged in successfully. Main Chat Client opened for logged in User.
     */
    private void login() {
        //Loads username and password into Model from User input in GUI
        model.setUsername(view.getUsernameTextfield().getText());                       
        model.setPassword(new String(view.getPasswordTextfield().getPassword()));       
        
        //Checks if input Username exists in list of Registered Users
        if (model.checkUsername()) {
            //Checks if input Password is correct for input Username
            if (model.checkPassword()) {
                JOptionPane.showMessageDialog(null, "Welcome "+ model.getUsername()+ "!", "Login Successful", JOptionPane.INFORMATION_MESSAGE);
                view.close();      
                //Opens Main Chat Client GUI here
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
     * PRECONDITIONS: None.
     * POSTCONDITIONS: Register page is opened, and Login page is closed. 
     */
    private void register()
    {
        view.close();
        
        this.rm = new Model("Please enter first name", "Please enter last name", "Please enter username", "Please enter password", "MM/DD/YYYY", "Please enter game", 1);
        this.rv =  new RegisterView("Create Profile");
        this.rc = new RegisterController(rm, rv);
        rc.initialController();
    }
    
    
    /**
     * Displays error message for Invalid Username to Login GUI
     * PRECONDITIONS: None.
     * POSTCONDITIONS: Invalid Username message displayed in Login GUI.
     */
    private void invalidUsername() {
        JOptionPane.showMessageDialog(null, "I'm sorry, this username does not exist.", "Invalid Username", JOptionPane.INFORMATION_MESSAGE);
    }
    
    
    /**
     * Displays error message for Invalid Password to Login GUI
     * PRECONDITIONS: None.
     * POSTCONDITIONS: Invalid Password message displayed in Login GUI.
     */
    private void invalidPassword() {
        JOptionPane.showMessageDialog(null, "I'm sorry, the password is incorrect.", "Incorrect Password", JOptionPane.INFORMATION_MESSAGE);
    }
}
