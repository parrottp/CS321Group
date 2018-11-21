package Controller;

import Model.Model;
import View.HomePageView;
import View.LoginView;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;



/**
 * Controller for HomePage process of program.
 */
public class HomePageController 
{
    //Model and View for this instance of HomePageController
    private Model model;
    private HomePageView view;
    
    //Model, View and Controller for LoginController called by HomePageController
    private Model lm;
    private LoginView lv;
    private LoginController lc;
    
    /**
     * Constructor
     * @param m Model for HomePage
     * @param v View for HomePage
     * PRECONDITIONS: Model m and HomePageView v must be initialized. 
     * POSTCONDITIONS: HomePage GUI is displayed with initial values.
     */
    public HomePageController(Model m, HomePageView v)
    {
        model = m;
        view = v;
        
        //Initializes RegisterView with initial values of input Model
        initialView();
    }

    
     /**
     * Initializes the HomePageView with the values of username, age, and game interest in Model.
     * PRECONDITIONS: Model m and HomePageView v must be initialized.
     * POSTCONDITIONS: HomePageView updated with correct User values.
     */
    private void initialView()
    {
        view.getUsernameLabel().setText(model.getUsername());
        view.getBirthdayLabel().setText("Age: " + model.getAge());
        view.getGameInterestLabel().setText("Currently playing " + model.getGameInterest());
        
        
        String stringLevel = new Integer(model.getLevel()).toString();
        view.getLevelLabel().setText("Level " + stringLevel);
        changeConversation();
    }
    
    
    /**
     * Initializes the HomePageController to read action listeners for adding a friend, switching conversation, sending a message, logging out and closing the program.
     * PRECONDITIONS: Model m and HomePageView v must be initialized. 
     * POSTCONDITIONS: All buttons on GUI functional, and User actions in GUI are read.
     */
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
        
        //Updates the User Level stored in User Data File
        view.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                model.updateUserLevel();
            }
        });
    }
    
    
    /**
     * Sends the String typed by User in TextField as a Message to the current conversation.
     * PRECONDITION: Model and HomePageView initialized. 
     * POSTCONDITION: TextField reset and writeToView() called.
     */
    private void sendMessage(){
        //Reads JTextField text into Model, which sends it as a Message
        model.sendMessage(view.getMessageInputField().getText());
        
        //Clears the JTextField
        view.getMessageInputField().setText("");
        
        //Writes the updated conversation to the View
        writeToView();
    }
    
    
    /**
     * Changes the loaded conversation when the User changes selected friend in JComboBox.
     * PRECONDITION: Model and HomePageView initialized.
     * POSTCONDITION: Displayed conversation changed to conversation for newly selected friend.
     */
    private void changeConversation()
    {
        //Updates the current conversation in Model
        model.setCurrentConversation((String)view.getFriendBox().getSelectedItem());
        
        //If the conversation exists, writes the updated conversation to the View
        if(model.getCurrentConversation() != null) {
            writeToView();
        }
    }
    
    
    /**
     * Adds a friend from the TextField. Displays whether or not it was successful.
     * @throws ParseException 
     * PRECONDITION: Model and HomePageView initialized.
     * POSTCONDITION: Friend successfully added if valid input, or rejected if not. Success/failure message Displayed to HomePageView.
     */
    private void addFriend() throws ParseException {
        //Read the name of potential friend from JTextField
        model.setPotentialFriend(view.getfriendsSearchBar().getText());
       
        //Checks if the input String is an existing User that is a potential friend for the current User
        if(model.verifyUser()) {
            //Updates the Friends list with the new friend
            model.updateFriendsList();
            JOptionPane.showMessageDialog(null, "Successfully added " + model.getPotentialFriend() + " as a friend! Log out and log back in to confirm.", "New Friend Added!", JOptionPane.PLAIN_MESSAGE);
        }
        else {
            //Displayed message for invalid friend 
            JOptionPane.showMessageDialog(null, "User does not exist or you are already friends. Please try again.", "Invalid Friend Request", JOptionPane.PLAIN_MESSAGE);
        }
    }
    
    
    /**
     * Logs User out of their account and closes the HomePage. Updates User's Data File. Launches Login page.
     * PRECONDITION: None.
     * POSTCONDITION: User's Data File updated, HomePage closed, Login page re-opened.
     */
    private void logOut(){
        model.updateUserLevel();
        view.close();
        
        this.lm = new Model("Please enter username", "Please enter password");
        this.lv = new LoginView("Login");
        this.lc = new LoginController(lm, lv);
        lc.initialController();
    }
    
   
    /**
     * Updates the View with all User data from Model.
     * PRECONDITION: Model and HomePageView initialized.
     * POSTCONDITION: User's level updated, User's send message TextField cleared, User's conversation updated
     */
    private void writeToView()
    {
        //Calculates the Level by dividing total messages sent by 5
        String stringLevel = Integer.toString(model.getLevel() / 5);
        
        //Updates View to display new Level
        view.getLevelLabel().setText("Level " + stringLevel);
        
        //Clears the JTextField User inputs Messages into
        view.getMessageOutput().setText(null);
        
        
        //Displays conversation to the View
        ArrayList<String> conversation = model.getConvoText();
        
        for(int i = 0; i < conversation.size(); i++)
        {
            view.getMessageOutput().append(conversation.get(i));
            view.getMessageOutput().append("\n");
        }
    }
    
    
}
