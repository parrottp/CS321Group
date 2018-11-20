package Model;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class HomePageView extends javax.swing.JFrame{

    //Panels
    private final JPanel userDataPanel;
    private final JPanel bottomPanel;
    private final JPanel inputBar;
    
    private final JSplitPane splitPane;
    private final JScrollPane scrollPane;
    private JTextArea messageOutput; //area for correspondance output
    
    //Textfields
    private  JTextField messageInputField;   //textfield for messageInputField in inputBar
    private  JTextField friendsSearchBar; //textfield for username search input
    
    //Buttons
    private JButton addFriendButton;
    private JButton sendButton; 
    private JButton logoutButton;
    
    //Labels
    private JLabel usernameLabel;
    private JLabel birthdayLabel;
    private JLabel gameLabel;
    private JLabel levelLabel;
    private JLabel chatWithLabel;
    
    //List of Friends to populate JComboBox
    private ArrayList<String> friendsList;
    //private String[] friends;
    private int friendsListSize;

    /**
    * View Constructor
    * 
    * @param title used for frame title
    *
    */
    public HomePageView(String title, String[] friends) {
        splitPane = new JSplitPane();
        userDataPanel = new JPanel();        
        bottomPanel = new JPanel();

        scrollPane = new JScrollPane();
        messageOutput = new JTextArea();

        //inputBar panel
        inputBar = new JPanel();
        messageInputField = new JTextField();  
        friendsSearchBar = new JTextField();
        addFriendButton = new JButton("Add Friend");
        sendButton = new JButton(">>");
        logoutButton = new JButton("Logout");
        
        //Create font styles
        Font boldFont = new Font("Helvetica", Font.BOLD,20);
        
        // Create labels
        usernameLabel = new JLabel("Username: ");
        usernameLabel.setFont(boldFont);
        
        birthdayLabel = new JLabel("Birthday: ");
        gameLabel = new JLabel("I'm currently playing: ");
        levelLabel = new JLabel("Level");
        chatWithLabel = new JLabel("Chat with:");

        setPreferredSize(new Dimension(600, 400));

        getContentPane().setLayout(new GridLayout());  
        getContentPane().add(splitPane);

        //SplitPane
        splitPane.setOrientation(JSplitPane.HORIZONTAL_SPLIT); //split horizontally
        splitPane.setDividerLocation(200);
        splitPane.setLeftComponent(userDataPanel);             //userDataPanel to the left 
        splitPane.setBottomComponent(bottomPanel);
        
        //Set visible
        userDataPanel.setVisible(true);
        bottomPanel.setVisible(true);
        inputBar.setVisible(true);
        
        //Set textarea to be un-editable
        messageOutput.setEditable(false);

        //Display userDataPanel labels vertically
        userDataPanel.setLayout(new BoxLayout(userDataPanel, BoxLayout.Y_AXIS));
        userDataPanel.add(usernameLabel);
        userDataPanel.add(birthdayLabel);
        userDataPanel.add(gameLabel);
        userDataPanel.add(levelLabel);
        userDataPanel.add(logoutButton);
        
        userDataPanel.add(chatWithLabel);
        
        JComboBox currentFriendList = new JComboBox(friends);
        userDataPanel.add(currentFriendList);
        
        userDataPanel.add(friendsSearchBar);
        userDataPanel.add(addFriendButton);

        //bottomPanel
        bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.Y_AXIS)); //arranges vertically 
        bottomPanel.add(scrollPane);                
        scrollPane.setViewportView(messageOutput);     //makes textarea scrollable 
        bottomPanel.add(inputBar);                // add inputBar to bottomPanel so it under the scrollPane / textArea

        //Set maximum value on inputBar
        inputBar.setMaximumSize(new Dimension(Integer.MAX_VALUE, 75));     //set  max height to 75 and the max width to unlimited
        inputBar.setLayout(new BoxLayout(inputBar, BoxLayout.X_AXIS));     //arranges horizontally

        //Set maximum value on friendsSearchBar
        friendsSearchBar.setMaximumSize(new Dimension(Integer.MAX_VALUE, 25));
        friendsSearchBar.setLayout(new BoxLayout(friendsSearchBar, BoxLayout.X_AXIS));     //arranges horizontally

        inputBar.add(messageInputField);// textfield on left
        inputBar.add(sendButton);       // >> button on right
        
        pack();
    }
   
    
    
    
    
    /**
     * 
     */
    public void close() {
        this.dispose();
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
    
    /**
     * Accessor for logoutButton button
     * @return current logoutButton button
     */
    public JButton getLogoutButton() {
        return logoutButton;
    }
 
    /**
     * Mutator for logoutButton button
     * @param logoutButton new logoutButton button
     */
    public void setLogoutButton(JButton logoutButton) {
        this.logoutButton = logoutButton;
    }
    
    /**
     * Accessor for friendsSearchBar
     * @return current friendsSearchBar
     */
    public JTextField getfriendsSearchBar() {
        return friendsSearchBar;
    }
    
    /**
     * Mutator for friendsSearchBar
     * @param friendsSearchBar new friendsSearchBar
     */
    public void setfriendsSearchBar(JTextField friendsSearchBar) {
        this.friendsSearchBar = friendsSearchBar;
    }
    
    /**
     * Accessor for messageInputField
     * @return current messageInputField
     */
    public JTextField getMessageInputField() {
        return messageInputField;
    }
    
    /**
     * Mutator for messageInputField
     * @param messageInputField new messageInputField
     */
    public void setMessageInputField(JTextField messageInputField) {
        this.messageInputField = messageInputField;
    }
    
     /**
     * Accessor for messageInputField
     * @return current messageInputField
     */
    public JTextArea getMessageOutput() {
        return messageOutput;
    }
    
    /**
     * Mutator for messageOutput
     * @param messageOutput new messageOutput
     */
    public void setMessageOutput(JTextArea messageOutput) {
        this.messageOutput = messageOutput;
    }
    
    
    /**
     * 
     * @return 
     */
    public ArrayList<String> getFriendsList() {
        return this.friendsList;
    }
    
}