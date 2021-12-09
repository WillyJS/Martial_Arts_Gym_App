package main.java.memoranda.ui;

import com.google.gson.GsonBuilder;
import com.google.gson.Gson;
import main.java.memoranda.GymRegistry;
import main.java.memoranda.GymUser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * This class will be used by administrators of the system to register users.
 *
 * @author William J Sanchez
 * @version 1.0
 */
public class Registration extends JFrame implements ActionListener{

    //Labels for all panels of the window.
    JLabel registration_panel;
    JLabel name_label;
    JLabel password_label;
    JLabel confirm_label;
    JLabel username_label;
    JLabel user_Access_label;
    JLabel belt_rank_label;

    //User information fields.
    JTextField name;
    JTextField username;
    JPasswordField password;
    JPasswordField passwordC;

    //Drop down Access levels
    String userLevelAccess[] = {"", "Admin", "Trainer", "Student"};

    //Drop down Belt rank levels.
    String beltRank[] = {"", "White", "Yellow", "Orange", "Purple", "Blue", "Blue Stripe", "Green", "Green Stripe", "Brown1",
            "Brown2", "Brown3", "Black1", "Black2", "Black3"};

    //Drop down boxes.
    static JComboBox accessDropDown;
    static JComboBox beltDropDown;

    //Buttons.
    JButton submit;
    JButton cancel;

    //Access the current gym registry 
    GymRegistry registry = getRegistry();

    Registration(){

        //Creates Login main panel.
        setVisible(true);
        setSize (500, 500);
        setLayout(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Dojo Manager Registration");
        setLocationRelativeTo(null);

        registration_panel = new JLabel("Dojo Manager Registration");
        registration_panel.setForeground(Color.blue);
        registration_panel.setFont(new Font("Serif", Font.BOLD, 20));

        name_label = new JLabel("Full name:");
        password_label = new JLabel("Create Password:");
        confirm_label = new JLabel("Confirm Password:");
        user_Access_label = new JLabel("Choose User Access");
        belt_rank_label = new JLabel("Choose Belt Rank");
        username_label = new JLabel("Create Username:");

        name = new JTextField();
        username = new JTextField();

        password = new JPasswordField();
        passwordC = new JPasswordField();

        accessDropDown = new JComboBox(userLevelAccess);
        beltDropDown = new JComboBox(beltRank);

        submit = new JButton("Submit");
        cancel = new JButton("Cancel");

        accessDropDown.addActionListener(this);
        beltDropDown.addActionListener(this);
        submit.addActionListener(this);
        cancel.addActionListener(this);

        //labels on registration screen
        registration_panel.setBounds(120, 30, 300, 50);
        name_label.setBounds(50, 90, 200, 30);
        user_Access_label.setBounds(50, 130, 200, 30);
        belt_rank_label.setBounds(50, 170, 200, 30);
        password_label.setBounds(50, 210, 200, 30);
        confirm_label.setBounds(50, 250, 200, 30);
        username_label.setBounds(50, 290, 200, 30);


        //fields on registration screen
        name.setBounds(200, 90, 200, 30);
        accessDropDown.setBounds(200, 130, 200, 30);
        beltDropDown.setBounds(200, 170, 200, 30);
        password.setBounds(200, 210, 200, 30);
        passwordC.setBounds(200, 250, 200, 30);
        username.setBounds(200, 290, 200, 30);

        //buttons on registration screen
        submit.setBounds(100, 350, 100, 30);
        cancel.setBounds(270, 350, 100, 30);

        add(registration_panel);
        add(name_label);
        add(user_Access_label);
        add(belt_rank_label);
        add(password_label);
        add(confirm_label);
        add(username_label);
        add(name);
        add(accessDropDown);
        add(beltDropDown);
        add(password);
        add(passwordC);
        add(submit);
        add(cancel);
        add(username);

        //sets default button to be the login button when hitting enter.
        getRootPane().setDefaultButton(submit);

    }

    /**
     * Method used to obtain full name
     * @return name
     */
    public JTextField getFullName(){
        return name;
    }

    /**
     * Method used to obtain password
     * @return password
     */
    public JTextField getPassword(){
        return password;
    }

    /**
     * Method used to confirm password
     * @return passwordC
     */
    public JTextField getPasswordConf(){
        return passwordC;
    }

    /**
     * Method used to obtain username
     * @return username
     */
    public JTextField getUserName(){
        return username;
    }

    /**
     * Method used to obtain user access level
     * @return accessDropDown
     */
    public JComboBox getUserAccess(){
        return accessDropDown;
    }

    /**
     * Method used to obtain belt rank
     * @return beltDropDown
     */
    public JComboBox getBeltRank(){
        return beltDropDown;
    }

    /**
     * Method used to read information from database.
     * @return CurrentRegistry GymRegistry 
     */
    public GymRegistry getRegistry(){
        GymRegistry currentRegistry = new GymRegistry();
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();

        try{
            BufferedReader br = new BufferedReader(new FileReader("dbData/users.json"));
            currentRegistry = gson.fromJson(br, GymRegistry.class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return currentRegistry;
    }
    
    /**
     * Save registry to the user database.
     */
    public void saveRegistry() {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();

        try {
            FileWriter writer = new FileWriter("dbData/users.json");
            writer.write(gson.toJson(registry));
            writer.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * When enter is hit submit will be automatically clicked.
     * @param e
     */
    public void keyPressed(KeyEvent e){
        if (e.getKeyCode() == KeyEvent.VK_ENTER){
            submit.doClick();
        }
    }

    /**
     * Method will listen for user action.
     * If enter is Hit it will activate Submit.
     */
    public void actionPerformed(ActionEvent e) {
        //if user hits cancel, close window.
        if (e.getSource() == cancel) {
            dispose();
        }

        if(e.getSource() == submit) {
            //collect password and confirm
            char[] pass = password.getPassword();
            char[] passC = passwordC.getPassword();

            //convert password to string
            String userPass = new String(pass);
            String userPassc = new String(passC);

            //Validate input for user to be added to the registry 
            //Ensure username does not already exist in registry 
            if (registry.findUser(getUserName().getText().toLowerCase()) == false) {
                //Ensure username field is not blank 
                if (getUserName().getText().length() > 0) {
                    //Ensure password fields is not left blank 
                    if (getPassword().getText().length() > 0) {
                        //Ensure password is confirmed 
                        if(userPass.equals(userPassc)) {
                            //Ensure full name is not left blank
                            if (getFullName().getText().length() > 0) {
                                //Ensure an access level is selected     
                                if (!getUserAccess().getSelectedItem().equals("")) {
                                    //Ensure belt rank is selected     
                                    if (!getBeltRank().getSelectedItem().equals("")) {
                                        //All validation checks passed, add user to registry     
                                        String userName = getUserName().getText().toLowerCase();
                                        String userFullName = getFullName().getText();
                                        String userAccessType = accessDropDown.getSelectedItem().toString();
                                        String userBeltRank = beltDropDown.getSelectedItem().toString();
                                        GymUser addUser = new GymUser(userName,userPass,userFullName,userAccessType,userBeltRank);
                                        registry.setUser(addUser);
                                        saveRegistry();
                                        dispose();
                                        JOptionPane.showMessageDialog(submit, "User " + userName + " Has Been Added");
                                    } else {
                                        JOptionPane.showMessageDialog(submit, "Belt Rank Selection is Required");
                                    }
                                } else {
                                    JOptionPane.showMessageDialog(submit, "User Access Selection is Required");
                                }
                            } else {
                                JOptionPane.showMessageDialog(submit, "User's Full Name is Required");
                            }

                        } else {
                            JOptionPane.showMessageDialog(submit, "Password does not match");
                        }
                    } else {
                        JOptionPane.showMessageDialog(submit, "Password Cannot be Blank");
                    }

                } else {
                    JOptionPane.showMessageDialog(submit, "Username Cannot be Blank");
                }
            } else {
                JOptionPane.showMessageDialog(submit, "User " + getUserName().getText().toLowerCase() + " Already Exists");
            }
        }
    }
}
