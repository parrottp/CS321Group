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
        view.getBirthdayLabel().setText(model.getBirthday());
        view.getGameInterestLabel().setText(model.getGameInterest());
        
        String stringLevel = new Integer(model.getLevel()).toString();
        view.getLevelLabel().setText("Level " + stringLevel);
    }
    
    public void initialController() 
    {
        //Add Friend Button Action Listener
            //addFriend();
        
        
    }
    
    
    //Add Friend function for the String in JTextField
    public void addFriend() {
        //Read the name of potential friend from JTextField
        //model.setPotentialFriend(view.getFriendTextField().getText());
        
        if(model.verifyUser(model.getPotentialFriend())) {
            model.updateFriendsList(model.getPotentialFriend());
        }
        else {
            JOptionPane.showMessageDialog(null, "User does not exist or you are already friends. Please try again.", "Invalid Friend Request", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
}
