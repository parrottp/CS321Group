/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserProfile;

/**
 *
 * @author livweaver
 */

import java.awt.BorderLayout;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class UserProfileView 
{
 //Labels
 private JFrame frame;
 private JLabel firstnameLabel;
 private JLabel lastnameLabel;
 private JLabel usernameLabel;
 private JLabel passwordLabel;
 private JLabel birthdayLabel;
 private JLabel gameLabel;
 
 //Textfields
 private JTextField firstnameTextfield;
 private JTextField lastnameTextfield;
 private JTextField usernameTextfield;
 private JTextField passwordTextfield;
 private JTextField birthdayTextfield;
 private JTextField gameTextfield;
 
 //Profile button
 private JButton createProfile;

 /**
  * View Constructor
  * 
  * @param title used for frame title
  *
  */
 public UserProfileView(String title) 
 {
     
  // Create the principal frame
  frame = new JFrame(title);
  frame.getContentPane().setLayout(new BorderLayout());
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  frame.setSize(600, 400);
  frame.setLocationRelativeTo(null);
  frame.setVisible(true);

  // Create labels
  firstnameLabel = new JLabel("Firstname: ");
  lastnameLabel = new JLabel("Lastname: ");
  usernameLabel = new JLabel("Username: ");
  passwordLabel = new JLabel("Password: ");
  birthdayLabel = new JLabel("Birthday: ");
  gameLabel = new JLabel("I'm currently playing: ");
  
  //Create Textfields for user input
  firstnameTextfield = new JTextField();
  lastnameTextfield = new JTextField();
  usernameTextfield = new JTextField();
  passwordTextfield = new JTextField();
  birthdayTextfield = new JTextField();
  gameTextfield = new JTextField();
  
  //Create buttons
  createProfile = new JButton("Create Profile");
  
  // Add UI element to frame
  GroupLayout layout = new GroupLayout(frame.getContentPane());
  layout.setAutoCreateGaps(true);
  layout.setHorizontalGroup(layout.createSequentialGroup()
    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
        .addComponent(firstnameLabel)
        .addComponent(lastnameLabel)
        .addComponent(usernameLabel)
        .addComponent(passwordLabel)
        .addComponent(birthdayLabel)
        .addComponent(gameLabel))
          
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
  );

  layout.linkSize(SwingConstants.HORIZONTAL, createProfile);
  frame.getContentPane().setLayout(layout);
 }

 public JFrame getFrame() 
 {
  return frame;
 }

 public void setFrame(JFrame frame) 
 {
  this.frame = frame;
 }

 public JLabel getFirstnameLabel() 
 {
  return firstnameLabel;
 }

 public void setFirstnameLabel(JLabel firstnameLabel) 
 {
  this.firstnameLabel = firstnameLabel;
 }

 public JLabel getLastnameLabel() 
 {
  return lastnameLabel;
 }

 public void setLastnameLabel(JLabel lastnameLabel) 
 {
  this.lastnameLabel = lastnameLabel;
 }

 public JTextField getFirstnameTextfield() 
 {
  return firstnameTextfield;
 }

 public void setFirstnameTextfield(JTextField firstnameTextfield) 
 {
  this.firstnameTextfield = firstnameTextfield;
 }

 public JTextField getLastnameTextfield() 
 {
  return lastnameTextfield;
 }

 public void setLastnameTextfield(JTextField lastnameTextfield) 
 {
  this.lastnameTextfield = lastnameTextfield;
 }
 
 public JTextField getUsernameTextfield() 
 {
  return usernameTextfield;
 }

 public void setUsernameTextfield(JTextField usernameTextfield) 
 {
  this.usernameTextfield = usernameTextfield;
 }
 
 public JTextField getPasswordTextfield() 
 {
  return passwordTextfield;
 }

 public void setPasswordTextfield(JTextField usernameTextfield) 
 {
  this.passwordTextfield = usernameTextfield;
 }
 
 public JTextField getBirthdayTextfield() 
 {
  return birthdayTextfield;
 }

 public void setBirthdayTextfield(JTextField usernameTextfield) 
 {
  this.birthdayTextfield = birthdayTextfield;
 }
 
 public JTextField getGameTextfield() 
 {
  return gameTextfield;
 }

 public void setGameTextfield(JTextField usernameTextfield) 
 {
  this.gameTextfield = gameTextfield;
 }

 public JButton getCreateProfileButton()
 {
     return createProfile;
 }
 
 public void setCreateProfilButton(JButton createProfile)
 {
     this.createProfile = createProfile;
 }

}
