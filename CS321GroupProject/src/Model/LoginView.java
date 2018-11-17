package Model;

import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 * View for Login process of program
 * @author livweaver, noahe
 */
public class LoginView {
    //JFrame
    private JFrame frame;
    
    //JLabels
    private JLabel usernameLabel;   //Label for Username input field
    private JLabel passwordLabel;   //Label for Password input field
 
    //JTextFields
    private JTextField usernameTextfield;       //TextField to read input Username
    private JPasswordField passwordTextfield;   //TextField to read input Password
 
    //JButtons
    private JButton loginButton;        //Button to Login with input information
    private JButton registerButton;     //Button to go to Register page

    /**
     * Constructs LoginView with input string
     * @param title title of GUI window
     */
    public LoginView(String title) {
        
        //Create the principal JFrame
        frame = new JFrame(title);
        frame.getContentPane().setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        //Create JLabels for User information
        usernameLabel = new JLabel("Username: ");
        passwordLabel = new JLabel("Password: ");
  
        //Create JTextFields for User input
        usernameTextfield = new JTextField();
        passwordTextfield = new JPasswordField();
  
        //Create JButtons for User function
        loginButton = new JButton("Login");
        registerButton = new JButton("Register Account");
  
        //Add UI element to JFrame
        GroupLayout layout = new GroupLayout(frame.getContentPane());
        layout.setAutoCreateGaps(true);
        layout.setHorizontalGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(usernameLabel)
                .addComponent(passwordLabel))
            
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(usernameTextfield)
                .addComponent(passwordTextfield))
          
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(loginButton)
                .addComponent(registerButton))
        );
        layout.setVerticalGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(usernameLabel)
                .addComponent(usernameTextfield))
            
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(passwordLabel)
                .addComponent(passwordTextfield))
          
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(loginButton))
        
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(registerButton))
        );
        layout.linkSize(SwingConstants.HORIZONTAL, loginButton);
        layout.linkSize(SwingConstants.HORIZONTAL, registerButton);
        frame.getContentPane().setLayout(layout);
    }
 
    
    /**
     * Closes the JFrame this.frame
     * PRECONDITION: this.frame must be initialized.
     * POSTCONDITION: this.frame is destroyed.
     */
    public void close() {
        frame.dispose();
    }

    
    /**
     * Accessor for frame
     * @return current frame
     */
    public JFrame getFrame() {
        return this.frame;
    }

    
    /**
     * Mutator for frame
     * @param frame new JFrame
     */
    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    /**
     * Accessor for usernameTextfield
     * @return current usernameTextfield
     */
    public JTextField getUsernameTextfield() {
        return this.usernameTextfield;
    }

    
    /**
     * Mutator for usernameTextfield
     * @param usernameTextfield new usernameTextfield
     */
    public void setUsernameTextfield(JTextField usernameTextfield) {
        this.usernameTextfield = usernameTextfield;
    }
 
    
    /**
     * Accessor for passwordTextfield
     * @return current passwordTextfield
     */
    public JPasswordField getPasswordTextfield() {
        return this.passwordTextfield;
    }

    
    /**
     * Mutator for passwordTextfield
     * @param passwordTextfield new passwordTextfield
     */
    public void setPasswordTextfield(JPasswordField passwordTextfield) {
        this.passwordTextfield = passwordTextfield;
    }
 
    
    /**
     * Accessor for loginButton
     * @return current loginButton
     */
    public JButton getLoginButton() {
        return loginButton;
    }
 
    
    /**
     * Mutator for loginButton
     * @param loginButton new loginButton
     */
    public void setLoginButton(JButton loginButton) {
        this.loginButton = loginButton;
    }
    
    
    /**
     * Accessor for registerButton
     * @return current registerButton
     */
    public JButton getRegisterButton() {
        return registerButton;
    }
 
    
    /**
     * Mutator for registerButton
     * @param registerButton new registerButton
     */
    public void setRegisterButton(JButton registerButton) {
        this.registerButton = registerButton;
    }
    
}

