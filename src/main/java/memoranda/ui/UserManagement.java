/**
 * File: UserManagement.java
 * @Author: William Sanchez
 * Date: 11/19/2020
 *
 *  Description: Is triggered by the Manage button
 *  Allows admin to search for a user or list all users registered in the system.
 *
 */

package main.java.memoranda.ui;

import javax.swing.*;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import main.java.memoranda.GymRegistry;
import main.java.memoranda.GymUser;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * Class: UserManagement
 * Description: Admin can search for a particular user or see a table with users.
 */
public class UserManagement extends JFrame implements ActionListener {

    //getContentPane returns a reference so we will create a reference for the container
    Container container = getContentPane();

    //Header for our login window.
    JLabel welcomeHeader = new JLabel("Search by Username ");

    //Search button
    JButton searchButton = new JButton("Search for users");

    //displays users button
    JButton displayUsersButton = new JButton("Display all users");
    
    //To hold the gym registry contents 
    GymRegistry registry = new GymRegistry();
    
    //To hold username for desired search
    JTextField userSearchField;

    /**
     * Default constructor initializes the window along with buttons.
     */
    public UserManagement(){

        //Setting layout manager of Container to null
        container.setLayout(null);

        setTitle("User Management"); //title for window
        setBounds(10, 10,400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        welcomeHeader.setVerticalAlignment(SwingConstants.BOTTOM);
        welcomeHeader.setHorizontalAlignment(SwingConstants.RIGHT);

        welcomeHeader.setBounds(21, 86, 167, 24);
        welcomeHeader.setForeground(Color.blue);
        welcomeHeader.setFont(new Font("Serif", Font.PLAIN, 18));

        searchButton.setBounds(198, 115, 150, 30); //x=50, y=380
        displayUsersButton.setBounds(198, 193, 150, 30); //x=200, y=380

        container.add(welcomeHeader);
        container.add(searchButton);
        container.add(displayUsersButton);
        
        userSearchField = new JTextField();
        userSearchField.setToolTipText("Enter username to search");
        //userSearchField.setText("Username");
        userSearchField.setBounds(198, 80, 150, 30);
        getContentPane().add(userSearchField);
        userSearchField.setColumns(10);
        
        JLabel lblDisplayAllUsers = new JLabel("Display All Users");
        lblDisplayAllUsers.setVerticalAlignment(SwingConstants.BOTTOM);
        lblDisplayAllUsers.setHorizontalAlignment(SwingConstants.RIGHT);
        lblDisplayAllUsers.setForeground(Color.BLUE);
        lblDisplayAllUsers.setFont(new Font("Serif", Font.PLAIN, 18));
        lblDisplayAllUsers.setBounds(31, 187, 157, 36);
        getContentPane().add(lblDisplayAllUsers);
        
        JLabel label_1 = new JLabel("Search by Username or Display All Users");
        label_1.setForeground(Color.BLUE);
        label_1.setFont(new Font("Serif", Font.BOLD, 20));
        label_1.setBounds(13, 22, 350, 36);
        getContentPane().add(label_1);

        //Adding Action listener to components so when they are used things happen.
        searchButton.addActionListener(this);
        displayUsersButton.addActionListener(this);
        
        //Get the contents of the user database
        getRegistry();
        
        getRootPane().setDefaultButton(searchButton);
    }
    
    /**
     * Access the username search field. 
     * @return userSearchField
     */
    public JTextField getUser() {
        return userSearchField;
    }
    
    /**
     * When enter is hit submit will be automatically clicked.
     * @param e
     */
    public void keyPressed(KeyEvent e){
        if (e.getKeyCode() == KeyEvent.VK_ENTER){
            searchButton.doClick();
        }
    }
    
    /**
     * Retrieve gym user database. 
     */
    public void getRegistry() {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        
        //Deserialize user data from json file 
        try {
            BufferedReader br = new BufferedReader(new FileReader("dbData/users.json"));
            registry = gson.fromJson(br, GymRegistry.class);
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Method will listen for button action and will launch a new window based on selection.
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        //if Search is pressed.
        if (e.getSource() == searchButton){

            //Search users
            String userWanted = getUser().getText(); 
            
            //Check if something was typed in the field
            if (userWanted.length() > 0) {
                //Check if the user was found 
                if (registry.findUser(userWanted) == true) {
                    //Retrieve the found user 
                    GymUser foundUser = registry.getUser(userWanted);
                    //Call the user editor with the registry and found user
                    EditUser edit = new EditUser(registry,foundUser);
                    dispose();             
                } else {
                    JOptionPane.showMessageDialog(this, "User does not exist in database");
                }
                
            } else {
                JOptionPane.showMessageDialog(this, "User does not exist in database");
            }
                          
        }

        //if Search is pressed.
        if (e.getSource() == displayUsersButton){
            //display users
            DisplayUsers users = new DisplayUsers(registry);
            dispose();
        }

        //Comment for commit test
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }
}
