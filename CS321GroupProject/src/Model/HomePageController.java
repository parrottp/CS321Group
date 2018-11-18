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
    
    private Model model;
    private HomePageView view;
    
    
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
    }
    
    public void initialController() 
    {
        //Action Listener for Add Friend button
        view.getAddFriendButton().addActionListener(e -> {
            addFriend();
        });
        
        //Action Listener for Send Message button
        view.getSendButton().addActionListener(e -> {
            sendMessage();
        });
    }
    
    //Send Message function for >> Button in HomePageView
    public void sendMessage(){
        
    }
    
    //Add Friend function for the String in JTextField
    public void addFriend() {
        //Read the name of potential friend from JTextField
        model.setPotentialFriend(view.getfriendsSearchBar().getText());
        
        if(model.verifyUser(model.getPotentialFriend())) {
            model.updateFriendsList(model.getPotentialFriend());
        }
        else {
            JOptionPane.showMessageDialog(null, "User does not exist or you are already friends. Please try again.", "Invalid Friend Request", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
}
