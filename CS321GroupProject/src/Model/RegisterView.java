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
 *
 * @author livweaver, noahe
 */
public class RegisterView {
    //JFrame
    private JFrame frame;
    
    //JLabels
    private JLabel firstnameLabel;
    private JLabel lastnameLabel;
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JLabel birthdayLabel;
    private JLabel gameLabel;
    private JLabel levelLabel;
 
    //JTextFields
    private JTextField firstnameTextfield;
    private JTextField lastnameTextfield;
    private JTextField usernameTextfield;
    private JPasswordField passwordTextfield;
    private JTextField birthdayTextfield;
    private JTextField gameTextfield;
 
    //JButton
    private JButton createProfile;

    /**
     * Constructs RegisterView with input String
     * @param title title of GUI window
     */
    public RegisterView(String title) {
     
        //Create the principal frame
        frame = new JFrame(title);
        frame.getContentPane().setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        //Create JLabels for User information
        firstnameLabel = new JLabel("First name: ");
        lastnameLabel = new JLabel("Last name: ");
        usernameLabel = new JLabel("Username: ");
        passwordLabel = new JLabel("Password: ");
        birthdayLabel = new JLabel("Birthday: ");
        gameLabel = new JLabel("I'm currently playing: ");
        levelLabel = new JLabel("Level 1");
  
        //Create JTextFields for User input
        firstnameTextfield = new JTextField();
        lastnameTextfield = new JTextField();
        usernameTextfield = new JTextField();
        passwordTextfield = new JPasswordField();
        birthdayTextfield = new JTextField();
        gameTextfield = new JTextField();
  
        //Create JButton for User function
        createProfile = new JButton("Create Profile");
  
        //Add UI element to JFrame
        GroupLayout layout = new GroupLayout(frame.getContentPane());
        layout.setAutoCreateGaps(true);
        layout.setHorizontalGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(firstnameLabel)
                .addComponent(lastnameLabel)
                .addComponent(usernameLabel)
                .addComponent(passwordLabel)
                .addComponent(birthdayLabel)
                .addComponent(gameLabel)
                .addComponent(levelLabel))
          
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(firstnameTextfield)
                .addComponent(lastnameTextfield)
                .addComponent(usernameTextfield)
                .addComponent(passwordTextfield)
                .addComponent(birthdayTextfield)
                .addComponent(gameTextfield))
          
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(createProfile))
        );
        layout.setVerticalGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(firstnameLabel)
                .addComponent(firstnameTextfield))
            
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(lastnameLabel)
                .addComponent(lastnameTextfield))
          
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(usernameLabel)
                .addComponent(usernameTextfield))
            
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(passwordLabel)
                .addComponent(passwordTextfield))
            
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(birthdayLabel)
                .addComponent(birthdayTextfield))
            
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(gameLabel)
                .addComponent(gameTextfield)
                .addComponent(createProfile))
                
                 .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(levelLabel))
        );
        layout.linkSize(SwingConstants.HORIZONTAL, createProfile);
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
        return frame;
    }

    
    /**
     * Mutator for frame
     * @param frame new JFrame
     */
    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

   
    /**
     * Accessor for firstnameTextfield
     * @return current firstnameTextfield
     */
    public JTextField getFirstnameTextfield() {
        return firstnameTextfield;
    }

    
    /**
     * Mutator for firstnameTextfield
     * @param firstnameTextfield new firstnameTextfield
     */
    public void setFirstnameTextfield(JTextField firstnameTextfield) {
        this.firstnameTextfield = firstnameTextfield;
    }

    
    /**
     * Accessor for lastnameTextfield
     * @return current lastnameTextfield
     */
    public JTextField getLastnameTextfield() {
        return lastnameTextfield;
    }

    
    /**
     * Mutator for lastnameTextfield
     * @param lastnameTextfield new lastnameTextfield
     */
    public void setLastnameTextfield(JTextField lastnameTextfield) {
        this.lastnameTextfield = lastnameTextfield;
    }
 
    
    /**
     * Accessor for usernameTextfield
     * @return current usernameTextfield
     */
    public JTextField getUsernameTextfield() {
        return usernameTextfield;
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
     * Mutator for passwordTextField
     * @param passwordTextField new passwordTextField
     */
    public void setPasswordTextfield(JPasswordField passwordTextField) {
        this.passwordTextfield = passwordTextField;
    }
 
    
    /**
     * Accessor for birthdayTextfield
     * @return current birthdayTextfield
     */
    public JTextField getBirthdayTextfield() {
        return birthdayTextfield;
    }

    
    /**
     * Mutator for birthdayTextField
     * @param birthdayTextField new birthdayTextField
     */
    public void setBirthdayTextfield(JTextField birthdayTextField) {
        this.birthdayTextfield = birthdayTextField;
    }
 
    
    /**
     * Accessor for gameTextField
     * @return current gameTextField
     */
    public JTextField getGameTextfield() {
        return gameTextfield;
    }

    
    /**
     * Mutator for gameTextField
     * @param gameTextField new usernameTextField
     */
    public void setGameTextfield(JTextField gameTextField) {
        this.gameTextfield = gameTextField;
    }
    
        /**
     * Accessor for levelLabel
     * @return current levelLabel
     */
    public JLabel getLevelLabel() {
        return levelLabel;
    }

    
    /**
     * Mutator for levelLabel
     * @param levelLabel new levelLabel
     */
    public void setLevelLabel(JLabel levelLabel) {
        this.levelLabel = levelLabel;
    }

    
    /**
     * Accessor for createProfile button
     * @return current createProfile button
     */
    public JButton getCreateProfileButton() {
        return createProfile;
    }
 
    
    /**
     * Mutator for createProfile button
     * @param createProfile new createProfile button
     */
    public void setCreateProfileButton(JButton createProfile) {
        this.createProfile = createProfile;
    }

}
