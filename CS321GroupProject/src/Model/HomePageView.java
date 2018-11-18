package Model;

import java.awt.*;
import javax.swing.*;

public class HomePageView extends javax.swing.JFrame{

    //Panels
    private final JPanel userDataPanel;
    private final JPanel bottomPanel;
    private final JPanel inputBar;
    
    private final JSplitPane splitPane;
    private final JScrollPane scrollPane;
    private final JTextArea textArea;
    private final JTextField textField;   // textfield for inputBar
    private final JTextField friendsSearchBar; //textfield for username search input
    
    //Buttons
    private JButton addFriendButton;
    private JButton sendButton; 
    
    //Labels
    private JLabel usernameLabel;
    private JLabel birthdayLabel;
    private JLabel gameLabel;
    private JLabel levelLabel;

    /**
    * View Constructor
    * 
    * @param title used for frame title
    *
    */
    public HomePageView(String title) {
  
        splitPane = new JSplitPane();
        userDataPanel = new JPanel();        
        bottomPanel = new JPanel();

        scrollPane = new JScrollPane();
        textArea = new JTextArea();

        //inputBar panel
        inputBar = new JPanel();
        textField = new JTextField();  
        friendsSearchBar = new JTextField();
        addFriendButton = new JButton("Add Friend");
        sendButton = new JButton(">>");
        
        
        // Create labels
        usernameLabel = new JLabel("Username: ");
        birthdayLabel = new JLabel("Birthday: ");
        gameLabel = new JLabel("I'm currently playing: ");
        levelLabel = new JLabel("Level");

        setPreferredSize(new Dimension(600, 400));

        getContentPane().setLayout(new GridLayout());  
        getContentPane().add(splitPane);

        //SplitPane
        splitPane.setOrientation(JSplitPane.HORIZONTAL_SPLIT); //split horizontally
        splitPane.setDividerLocation(100);
        splitPane.setLeftComponent(userDataPanel);             //userDataPanel to the left 
        splitPane.setBottomComponent(bottomPanel);
        
        //Set visible
        userDataPanel.setVisible(true);
        bottomPanel.setVisible(true);
        inputBar.setVisible(true);

        //Display userDataPanel labels vertically
        userDataPanel.setLayout(new BoxLayout(userDataPanel, BoxLayout.Y_AXIS));
        userDataPanel.add(usernameLabel);
        userDataPanel.add(birthdayLabel);
        userDataPanel.add(gameLabel);
        userDataPanel.add(levelLabel);
        userDataPanel.add(friendsSearchBar);
        userDataPanel.add(addFriendButton);

        //bottomPanel
        bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.Y_AXIS)); //arranges vertically 
        bottomPanel.add(scrollPane);                
        scrollPane.setViewportView(textArea);     //makes textarea scrollable 
        bottomPanel.add(inputBar);                // add inputBar to bottomPanel so it under the scrollPane / textArea

        //Set maximum value on inputBar
        inputBar.setMaximumSize(new Dimension(Integer.MAX_VALUE, 75));     //set  max height to 75 and the max width to unlimited
        inputBar.setLayout(new BoxLayout(inputBar, BoxLayout.X_AXIS));     //arranges horizontally

        //Set maximum value on friendsSearchBar
        friendsSearchBar.setMaximumSize(new Dimension(Integer.MAX_VALUE, 25));
        friendsSearchBar.setLayout(new BoxLayout(friendsSearchBar, BoxLayout.X_AXIS));     //arranges horizontally

        inputBar.add(textField);        // textfield on left
        inputBar.add(sendButton);       // >> button on right
        
        pack();
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

     public JLabel getLevelLabel() 
    {
        return levelLabel;
    }

    public void setLevelLabel(JLabel levelLabel) 
    {
        this.levelLabel = levelLabel;
    }
    
    /**
     * Accessor for addFriendButton button
     * @return current addFriendButton button
     */
    public JButton getAddFriendButton() {
        return addFriendButton;
    }
 
    /**
     * Mutator for addFriendButton button
     * @param addFriendButton new addFriendButton button
     */
    public void setAddFriendButton(JButton addFriendButton) {
        this.addFriendButton = addFriendButton;
    }
    
     /**
     * Accessor for sendButton button
     * @return current sendButton button
     */
    public JButton getSendButton() {
        return sendButton;
    }
 
    /**
     * Mutator for sendButton button
     * @param sendButton new sendButton button
     */
    public void setSendButton(JButton sendButton) {
        this.sendButton = sendButton;
    }
      
}