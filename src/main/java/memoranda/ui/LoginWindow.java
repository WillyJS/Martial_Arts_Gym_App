package main.java.memoranda.ui;

import com.google.gson.GsonBuilder;
import com.google.gson.Gson;
import main.java.memoranda.GymUser;
import main.java.memoranda.GymRegistry;
import main.java.memoranda.ui.App;
import main.java.memoranda.util.Configuration;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

import java.io.BufferedReader; 
import java.io.FileNotFoundException; 
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * this class is the GUI that the user will see when the application is launched.
 * It takes a user name and password and will use that information to authenticate login access.
 * @author William J Sanchez
 * @version 3.0
 */
public class LoginWindow extends JFrame implements ActionListener {

    App app = null;
    static JFrame splash = null;

    //getContentPane returns a reference so we will create a reference for the container
    Container container = getContentPane();

    //Title for the window
    ImageIcon logo = new ImageIcon("src/CKSplash.png");

    //.gif file for our login screen.
    JLabel loginImage = new JLabel(logo, JLabel.CENTER);

    //Header for our login window.
    JLabel welcomeHeader = new JLabel("Welcome! Please log in!");

    //labels for our selections
    JLabel userLabel = new JLabel("Username");
    JLabel passwordLabel = new JLabel("Password");

    //field where user can type stuff into
    JTextField userTextField = new JTextField();

    //field where user can enter password
    JPasswordField passwordField = new JPasswordField();

    //Login button
    JButton loginButton = new JButton("Login");

    //Reset button
    JButton resetButton = new JButton("Reset");

    //show password option
    JCheckBox showPassword = new JCheckBox("Show Password");
    
    //To hold the gym registry contents 
    GymRegistry registry = new GymRegistry();

    //constructor
    public LoginWindow() {

        //splash graphic will now show up before login.
        showSplash();

    	//Setting layout manager of Container to null
        container.setLayout(null);

        setTitle("Login"); //title for window
        setBounds(10, 10,370, 600); //window dimensions 10, 10. 370, 600
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //closing
        setResizable(false); //stopping resizing option
        setLocationRelativeTo(null);
        setVisible(true); //visible frame

        //Setting location, Size & font for component using setBounds() method.
        loginImage.setBounds(30, 90, 300, 100);
        welcomeHeader.setBounds(85, 30, 200, 20);
        welcomeHeader.setFont(new Font("Bodoni MT BlacT", Font.PLAIN, 18));
        userLabel.setBounds(50, 230, 100, 30);// 50, 150, 100, 30
        passwordLabel.setBounds(50, 280, 100, 30); // 50,220,100,30
        userTextField.setBounds(150, 230, 150, 30); // 150,150,150,30
        passwordField.setBounds(150, 280, 150, 30); // 150,220,150,30
        showPassword.setBounds(150, 330, 150, 30); // 150,250,150,30
        loginButton.setBounds(50, 380, 100, 30); // 50,300,100,30
        resetButton.setBounds(200, 380, 100, 30); // 200,300,100,30

        //Adding each components to the Container
        container.add(welcomeHeader);
        container.add(loginImage);
        container.add(userLabel);
        container.add(passwordLabel);
        container.add(userTextField);
        container.add(passwordField);
        container.add(showPassword);
        container.add(loginButton);
        container.add(resetButton);

        //Adding Action listener to components so when they are used things happen.
        loginButton.addActionListener(this);
        resetButton.addActionListener(this);
        showPassword.addActionListener(this);

        //sets default button to be the login button when hitting enter.
        getRootPane().setDefaultButton(loginButton);
        
        //Read user registry contents
        getRegistry();
        
        //Ensure stored user information is cleared
        clearUser();
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
     * Record the user currently logged in. 
     * @param currentUser GymUser
     */
    public void setCurrentUser(GymUser currentUser) {
    	GsonBuilder builder = new GsonBuilder();
		Gson gson = builder.create();
		
		//Serialize current user 
		try {
			FileWriter writer = new FileWriter("dbData/currentUser.json");
			writer.write(gson.toJson(currentUser));
			writer.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
    }
    
    /**
     * Clears the user information previously stored. 
     */
    public void clearUser() {
    	try {
			FileWriter writer = new FileWriter("dbData/currentUser.json");
			writer.write("");
			writer.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
    }

    /**
     * Method is used to obtain username.
     */
     public JTextField getUsername(){
        return userTextField;
     }

     /**
      * Method is used for obtaining password
      */
    public JTextField getPassword(){
        return passwordField;
    }

    /**
     * This method will click the login button when enter is hit.
     */
    public void keyPressed(KeyEvent e){
        if (e.getKeyCode() == KeyEvent.VK_ENTER){
            loginButton.doClick();
        }
    }

    /**
     * Method will listen for login button and will authenticate via database.
     * @param e
     */
	@Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == loginButton) {
            //Look for user in the gym registry 
            int foundUser = registry.userIndex(getUsername().getText());
          
            if(foundUser == -1) {
            	JOptionPane.showMessageDialog(this, "User Does Not Exist");
            } else {
            	//Retrieving user found 
            	GymUser currentUser = registry.getUser(getUsername().getText());

            	//Authenticate user input.
            	if(getUsername().getText().equals(currentUser.getUserName()) 
            			&& getPassword().getText().equals(currentUser.getPassword())) {
                    //Record the current user that successfully logged in 
            		setCurrentUser(currentUser);
            		//gets rid of login window.
                    dispose();
                    //launches the app if login is successfully
                    app = new App(true);
            	}
            	//If username & password are NOT correct.
                else {
                    app = new App(false);
                    JOptionPane.showMessageDialog(this, "Invalid Username or Password");
                }
            }
           
        }

        //Behavior for what happens when we click the Rest Button
        if (e.getSource() == resetButton){
            //clear both user input fields
            userTextField.setText("");
            passwordField.setText("");
        }

        //Behavior for what happens when we click on ShowPassword
        if (e.getSource() == showPassword){
            //if the button is pressed.
            if (showPassword.isSelected()){
                passwordField.setEchoChar((char) 0);
            }
            //if the button is not pressed hide the password with *
            else{
                passwordField.setEchoChar('*');
            }
        }

        //Comment for commit test
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

    /**
     * Method showSplash.
     */
    private void showSplash() {
        splash = new JFrame();
        ImageIcon spl = new ImageIcon(App.class.getResource("/ui/CKSplash.png"));
        JLabel l = new JLabel();
        l.setSize(900, 506);
        l.setIcon(spl);
        splash.getContentPane().add(l);
        splash.setSize(900, 506);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        splash.setLocation((screenSize.width - 900) / 2, (screenSize.height - 506) / 2);
        splash.setUndecorated(true);
        splash.setVisible(true);
        //this will close the window after 3000 millis
        try{
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        splash.dispose();
    }
}

