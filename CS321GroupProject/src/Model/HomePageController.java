package Model;

import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * 
 * @author livweaver, noahe
 */
public class HomePageController 
{
    //Model and View for this instance of HomePageController
    private Model model;
    private HomePageView view;
    
    //Model, View and Controller for LoginController called by HomePageController
    Model lm;
    LoginView lv;
    LoginController lc;
    
    //constructor
    public HomePageController(Model m, HomePageView v)
    {
        model = m;
        view = v;
        
        initialView();
    }

    
    public void initialView()
    {
        view.getUsernameLabel().setText(model.getUsername());
        view.getBirthdayLabel().setText("Age: " + model.getAge());
        view.getGameInterestLabel().setText("Currently playing " + model.getGameInterest());
        
        String stringLevel = new Integer(model.getLevel()).toString();
        view.getLevelLabel().setText("Level " + stringLevel);
        model.setCurrentConversation((String)view.getFriendBox().getSelectedItem());
    }
    
    public void initialController() 
    {
        //Action Listener for Add Friend button
        view.getAddFriendButton().addActionListener(e -> {
            try {
                addFriend();
            } catch (ParseException ex) {
                Logger.getLogger(HomePageController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        //Action Listener for Switch Conversation
        view.getFriendBox().addActionListener(e -> {
            changeConversation();
        });
        
        //Action Listener for Send Message button
        view.getSendButton().addActionListener(e -> {
            sendMessage();
        });
        
        //Action Listener for Log Out button
        view.getLogoutButton().addActionListener(e -> {
            logOut();
        });
    }
    
    //Send Message function for >> Button in HomePageView
    public void sendMessage(){
        model.sendMessage(view.getMessageInputField().getText());
        view.getMessageInputField().setText("");
    }
    
    //Change conversation partner
    public void changeConversation()
    {
        model.setCurrentConversation((String)view.getFriendBox().getSelectedItem());
    }
    
    //Add Friend function for the String in JTextField
    public void addFriend() throws ParseException {
        //Read the name of potential friend from JTextField
        model.setPotentialFriend(view.getfriendsSearchBar().getText());
       
        
        if(model.verifyUser()) {
            model.updateFriendsList();
            JOptionPane.showMessageDialog(null, "Successfully added " + model.getPotentialFriend() + " as a friend! Log out and log back in to confirm.", "New Friend Added!", JOptionPane.INFORMATION_MESSAGE);
        }
        else {
            JOptionPane.showMessageDialog(null, "User does not exist or you are already friends. Please try again.", "Invalid Friend Request", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    //Log out function for logoutButton Button in HomePageView
    public void logOut(){
        view.close();
        
        this.lm = new Model("Please enter username", "Please enter password");
        this.lv = new LoginView("Login");
        this.lc = new LoginController(lm, lv);
        lc.initialController();
    }
    
    //Log out function for logoutButton Button in HomePageView
    public void buttonClicked(){
        JOptionPane.showMessageDialog(null, "It was clicked", "Invalid Friend Request", JOptionPane.INFORMATION_MESSAGE);
    }
    
}
