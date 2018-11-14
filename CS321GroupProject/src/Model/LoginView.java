package Model;

/**
 *
 * @author livweaver, noahe
 */

import java.awt.BorderLayout;
import java.awt.event.WindowEvent;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class LoginView 
{
 //Labels
 private JFrame frame;
 private JLabel usernameLabel;
 private JLabel passwordLabel;
 
 //Textfields
 private JTextField usernameTextfield;
 private JPasswordField passwordTextfield;
 
 //Profile button
 private JButton loginButton;

 /**
  * View Constructor
  * 
  * @param title used for frame title
  *
  */
 public LoginView(String title) 
 {
     
  // Create the principal frame
  frame = new JFrame(title);
  frame.getContentPane().setLayout(new BorderLayout());
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  frame.setSize(400, 120);
  frame.setLocationRelativeTo(null);
  frame.setVisible(true);

  // Create labels
  usernameLabel = new JLabel("Username: ");
  passwordLabel = new JLabel("Password: ");
  
  //Create Textfields for user input
  usernameTextfield = new JTextField();
  passwordTextfield = new JPasswordField();
  
  //Create buttons
  loginButton = new JButton("Login");
  
  //Add UI element to frame
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
        .addComponent(loginButton))
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
  );

  layout.linkSize(SwingConstants.HORIZONTAL, loginButton);
  frame.getContentPane().setLayout(layout);
 }
 
 //Closes the JFrame
 public void close() {
     frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
 }

 public JFrame getFrame() 
 {
  return frame;
 }

 public void setFrame(JFrame frame) 
 {
  this.frame = frame;
 }

 public JTextField getUsernameTextfield() 
 {
  return usernameTextfield;
 }

 public void setUsernameTextfield(JTextField usernameTextfield) 
 {
  this.usernameTextfield = usernameTextfield;
 }
 
 public JPasswordField getPasswordTextfield() 
 {
  return this.passwordTextfield;
 }

 public void setPasswordTextfield(JPasswordField usernameTextfield) 
 {
  this.passwordTextfield = usernameTextfield;
 }
 
 public JButton getLoginButton()
 {
     return loginButton;
 }
 
 public void setLoginButton(JButton loginButton)
 {
     this.loginButton = loginButton;
 }

}

