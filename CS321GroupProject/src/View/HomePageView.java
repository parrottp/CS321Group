package View;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;



/**
 * View for HomePage process of program
 */
public class HomePageView extends javax.swing.JFrame{

    //JPanels
    private final JPanel userDataPanel;
    private final JPanel bottomPanel;
    private final JPanel inputBar;
    
    //JPanes
    private final JSplitPane splitPane;
    private final JScrollPane scrollPane;
    
    //JTextArea
    private JTextArea messageOutput;        //Area for correspondance output
    
    //JTextFields
    private JTextField messageInputField;   //TextField for messageInputField in inputBar
    private JTextField friendsSearchBar;    //TextField for username search input
    
    //JButtons
    private JButton addFriendButton;
    private JButton sendButton; 
    private JButton logoutButton;
    
    //JLabels
    private JLabel usernameLabel;
    private JLabel birthdayLabel;
    private JLabel gameLabel;
    private JLabel levelLabel;
    
    //JComboBox
    private JComboBox currentFriendList;
    
    //Logo
    private ImageIcon logo = new ImageIcon("logo.png");
    
    /**
    * Constructs HomePageView with input title and friends list.
    * @param title frame title
    * @param friends friends list to populate JComboBox
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
        logoutButton = new JButton("Logout >>");
        
        //Create font styles
        Font boldFont = new Font("Helvetica", Font.BOLD,20);
        Font font = new Font("Helvetica", Font.PLAIN,16);
        
        //Background color
        userDataPanel.setBackground(Color.GRAY);
        inputBar.setBackground(Color.GRAY);

        //Create labels
        usernameLabel = new JLabel("Username: ");
        usernameLabel.setFont(boldFont);
        usernameLabel.setForeground(Color.WHITE);
        
        birthdayLabel = new JLabel("Birthday: ");
        birthdayLabel.setFont(font);
        birthdayLabel.setForeground(Color.WHITE);
        
        gameLabel = new JLabel("I'm currently playing: ");
        gameLabel.setFont(font);
        gameLabel.setForeground(Color.WHITE);
        
        levelLabel = new JLabel("Level");
        levelLabel.setFont(font);
        levelLabel.setForeground(Color.WHITE);

        setPreferredSize(new Dimension(900, 600));      //Size changed to look better
        setLocation(500, 200);                          //Centered when launched
        
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
        
        //Initializes JComboBox with input Friends list and adds it to userDataPanel
        currentFriendList = new JComboBox(friends);
        userDataPanel.add(currentFriendList);
        
        //Adds logo to userDataPanel
        try {
            BufferedImage myPicture = ImageIO.read(new File("logo.png"));
            JLabel picLabel = new JLabel(new ImageIcon(myPicture));
            userDataPanel.add(picLabel);
        } catch (IOException ex) {
            Logger.getLogger(HomePageView.class.getName()).log(Level.SEVERE, null, ex);
        }

        userDataPanel.add(friendsSearchBar);
        userDataPanel.add(addFriendButton);
        userDataPanel.add(logoutButton);

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
     * Closes HomePageView by disposing of this.JFrame
     */
    public void close() {
        this.dispose();
    }
    
    
    /**
     * Accessor for the username JLabel
     * @return usernameLabel
     */
    public JLabel getUsernameLabel() 
    {
        return usernameLabel;
    }

    
    /**
     * Mutator for the username JLabel
     * @param usernameLabel new username JLabel
     */
    public void setUsernameLabel(JLabel usernameLabel) 
    {
        this.usernameLabel = usernameLabel;
    }

    
    /**
     * Accessor for the birthday JLabel
     * @return birthdayLabel
     */
    public JLabel getBirthdayLabel() 
    {
        return birthdayLabel;
    }

    
    /**
     * Mutator for the birthday JLabel
     * @param birthdayLabel new birthday JLabel
     */
    public void setBirthdayLabel(JLabel birthdayLabel) 
    {
        this.birthdayLabel = birthdayLabel;
    }

    
    /**
     * Accessor for the game interest JLabel
     * @return gameLabel
     */
    public JLabel getGameInterestLabel() 
    {
        return gameLabel;
    }

    
    /**
     * Mutator for the game interest JLabel
     * @param gameLabel new game interest JLabel
     */
    public void setGameInterestLabel(JLabel gameLabel) 
    {
        this.gameLabel = gameLabel;
    }

    
    /**
     * Accessor for the level JLabel
     * @return levelLabel
     */
    public JLabel getLevelLabel() 
    {
        return levelLabel;
    }

    
    /**
     * Mutator for the level JLabel
     * @param levelLabel new level JLabel
     */
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
     * Accessor for currentFriend JComboBox
     * @return currentFriendList
     */
    public JComboBox getFriendBox()
    {
        return currentFriendList;
    }
    
    
    /**
     * Mutator for currentFriend JComboBox
     * @param currentFriendList new currentFriend JComboBox
     */
    public void setFriendBox(JComboBox currentFriendList)
    {
        this.currentFriendList = currentFriendList;
    }
    
    
}