package HomePage;

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

public class HomePageView 
{
 //Labels
 private JFrame frame;
 private JLabel usernameLabel;
 private JLabel birthdayLabel;
 private JLabel gameLabel;

 /**
  * View Constructor
  * 
  * @param title used for frame title
  *
  */
 public HomePageView(String title) 
 {
     
  // Create the principal frame
  frame = new JFrame(title);
  frame.getContentPane().setLayout(new BorderLayout());
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  frame.setSize(300, 400);
  frame.setLocationRelativeTo(null);
  frame.setVisible(true);

  // Create labels
  usernameLabel = new JLabel("Username: ");
  birthdayLabel = new JLabel("Birthday: ");
  gameLabel = new JLabel("I'm currently playing: ");
  
  //Add UI element to frame
  GroupLayout layout = new GroupLayout(frame.getContentPane());
  layout.setAutoCreateGaps(true);
  layout.setHorizontalGroup(layout.createSequentialGroup()
    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
        .addComponent(usernameLabel)
        .addComponent(birthdayLabel)
        .addComponent(gameLabel))
  );
  layout.setVerticalGroup(layout.createSequentialGroup()
    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
       .addComponent(usernameLabel))
            
    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
        .addComponent(birthdayLabel))
            
    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
        .addComponent(gameLabel))
  );

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

 public JLabel getUsernameLabel() 
 {
  return usernameLabel;
 }

 public void setUsernameLabel(JLabel usernameLabel) 
 {
  this.usernameLabel = usernameLabel;
 }
 
 public JLabel getBirthdayLabel() 
 {
  return birthdayLabel;
 }

 public void setBirthdayLabel(JLabel birthdayLabel) 
 {
  this.birthdayLabel = birthdayLabel;
 }
 
 public JLabel getGameInterestLabel() 
 {
  return gameLabel;
 }

 public void setGameInterestLabel(JLabel gameLabel) 
 {
  this.gameLabel = gameLabel;
 }

}