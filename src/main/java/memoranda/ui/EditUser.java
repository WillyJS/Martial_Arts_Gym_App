/**
 * File: EditUSer.java
 * Author: Jesus Quiroz (jaquiro1)
 * Date: 11/26/2020 
 * 
 * Description: Creates window to update and delete a Gym User.
 */

package main.java.memoranda.ui;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import main.java.memoranda.GymRegistry;
import main.java.memoranda.GymUser;

/**
 * Class: EditUser.
 * Description: Window with prepopulated user's attributes for update.
 */
public class EditUser extends JFrame implements ActionListener {

    //Labels for all panels of the window.
    JLabel registrationPanel;
    JLabel nameLabel;
    JLabel passwordLabel;
    JLabel confirmLabel;
    JLabel usernameLabel;
    JLabel userAccessLabel;
    JLabel beltRankLabel;
    JLabel userAccessed;

    //User information fields.
    JTextField name;
    JPasswordField password;
    JPasswordField passwordC;

    //Drop down Access levels
    String [] userLevelAccess = {
        "", "Admin", "Trainer", "Student"
        };

    //Drop down Belt rank levels.
    String [] beltRank = {
        "", "White", "Yellow", "Orange", "Purple", 
        "Blue", "Blue Stripe", "Green", "Green Stripe", "Brown1",
        "Brown2", "Brown3", "Black1", "Black2", "Black3"
        };

    //Drop down boxes.
    static JComboBox accessDropDown;
    static JComboBox beltDropDown;

    //Buttons.
    JButton submit;
    JButton cancel;
    JButton delete;

    //Access the current gym registry 
    GymRegistry registry;

    //Holds the user to be edited
    GymUser editUser;

    /**
     * Creates a prepopulated user attributes window for edits. 
     * @param r GymRegistry
     * @param u GymUSer 
     */
    EditUser(GymRegistry r, GymUser u) {
        //User to be modified and copy of user database passed  
        editUser = u;
        registry = r;

        //Creates User Management panel
        setVisible(true);
        setSize(500, 500);
        getContentPane().setLayout(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Dojo Manager User Management");
        setLocationRelativeTo(null);

        registrationPanel = new JLabel("User Management");
        registrationPanel.setForeground(Color.blue);
        registrationPanel.setFont(new Font("Serif", Font.BOLD, 25));

        userAccessed = new JLabel(editUser.getUserName());
        userAccessed.setHorizontalAlignment(SwingConstants.LEFT);
        nameLabel = new JLabel("Change Full name:");
        nameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        passwordLabel = new JLabel("Change Password:");
        passwordLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        confirmLabel = new JLabel("Confirm Password:");
        confirmLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        userAccessLabel = new JLabel("Change User Access");
        userAccessLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        beltRankLabel = new JLabel("Change Belt Rank");
        beltRankLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        usernameLabel = new JLabel("Username:");
        usernameLabel.setHorizontalAlignment(SwingConstants.RIGHT);

        name = new JTextField();
        password = new JPasswordField();
        password.setToolTipText("Leave blank if password is not changing ");
        password.addActionListener(this);
        passwordC = new JPasswordField();

        accessDropDown = new JComboBox(userLevelAccess);
        beltDropDown = new JComboBox(beltRank);

        submit = new JButton("Save");
        cancel = new JButton("Cancel");
        delete = new JButton("Delete User");

        accessDropDown.addActionListener(this);
        beltDropDown.addActionListener(this);
        submit.addActionListener(this);
        cancel.addActionListener(this);
        delete.addActionListener(this);

        //labels
        userAccessed.setBounds(200, 89, 140, 30);
        registrationPanel.setBounds(140, 11, 205, 50);
        nameLabel.setBounds(50, 130, 140, 30);
        userAccessLabel.setBounds(50, 170, 140, 30);
        beltRankLabel.setBounds(50, 210, 140, 30);
        passwordLabel.setBounds(50, 250, 140, 30);
        confirmLabel.setBounds(50, 290, 140, 30);
        usernameLabel.setBounds(50, 89, 140, 30);

        //fields
        name.setBounds(200, 130, 200, 30);
        accessDropDown.setBounds(200, 170, 200, 30);
        beltDropDown.setBounds(200, 210, 200, 30);
        password.setBounds(200, 250, 200, 30);
        passwordC.setBounds(200, 290, 200, 30);

        //buttons 
        submit.setBounds(334, 354, 100, 30);
        cancel.setBounds(191, 354, 100, 30);
        delete.setBounds(50, 354, 100, 30);

        getContentPane().add(registrationPanel);
        getContentPane().add(userAccessed);
        getContentPane().add(nameLabel);
        getContentPane().add(userAccessLabel);
        getContentPane().add(beltRankLabel);
        getContentPane().add(passwordLabel);
        getContentPane().add(confirmLabel);
        getContentPane().add(usernameLabel);
        getContentPane().add(name);
        getContentPane().add(accessDropDown);
        getContentPane().add(beltDropDown);
        getContentPane().add(password);
        getContentPane().add(passwordC);
        getContentPane().add(submit);
        getContentPane().add(cancel);
        getContentPane().add(delete);

        //sets default button to be the login button when hitting enter.
        getRootPane().setDefaultButton(submit);

        //Call to retrieve user information
        populateUser();
    }

    /**
     * Method used to obtain full name.
     * @return name
     */
    public JTextField getFullName() {
        return name;
    }

    /**
     * Method used to obtain password.
     * @return password
     */
    public JTextField getPassword() {
        return password;
    }

    /**
     * Method used to confirm password.
     * @return passwordC
     */
    public JTextField getPasswordConf() {
        return passwordC;
    }

    /**
     * Method used to obtain user access level.
     * @return accessDropDown
     */
    public JComboBox getUserAccess() {
        return accessDropDown;
    }

    /**
     * Method used to obtain belt rank.
     * @return beltDropDown
     */
    public JComboBox getBeltRank() {
        return beltDropDown;
    }

    /**
     * Method to obtain user being modified.
     * @return GymUser
     */
    public GymUser getUser() {
        return editUser;
    }

    /**
     * Method populates fields with user's attributes.
     */
    public void populateUser() {
        getFullName().setText(getUser().getFullName());
        getUserAccess().setSelectedItem(getUser().getUserType());

        //Get and select the User Access
        String access = getUser().getUserType();
        int foundAccess = 0;

        for (int i = 0; i < userLevelAccess.length; i++) {
            if (access.equalsIgnoreCase(userLevelAccess[i])) {
                foundAccess = i;
            }
        }
        //Set found access, if access not found it will select null 
        accessDropDown.setSelectedIndex(foundAccess);

        //Get and select the user's belt rank 
        String belt = getUser().getBeltRank();
        int foundBelt = 0;

        for (int i = 0; i < beltRank.length; i++) {
            if (belt.equalsIgnoreCase(beltRank[i])) {
                foundBelt = i;
            }
        }
        //Set found belt rank, if not found it will select null
        beltDropDown.setSelectedIndex(foundBelt);

    }

    /**
     * Method checks if there were changes made to user.
     * @return changed boolean 
     */
    public boolean findChanges() {
        boolean changed = false;
        //Check if password was changed 
        if (getPassword().getText().trim().length() > 1 
                && !editUser.getPassword().equals(getPassword().getText())) {
            changed = true; 
        }
        //Check if the user's Full Name was modified 
        if (!getFullName().getText().equals(editUser.getFullName())) {
            changed = true;
        }
        //Check if the user access type was modifed
        if (!accessDropDown.getSelectedItem().toString()
                .equals(editUser.getUserType())) {
            changed = true;
        }
        //Check if the belt rank was modified 
        if (!beltDropDown.getSelectedItem().toString()
                .equals(editUser.getBeltRank())) {
            changed = true;
        }

        return changed;
    }

    /**
     * Save registry to the user database.
     */
    public void saveRegistry() {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        FileWriter writer = null;
        
        try {
            writer = new FileWriter("dbData/users.json");
            writer.write(gson.toJson(registry));
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * Method to update user's attributes.
     */
    public void updateUser(boolean pwdChanged) {
        editUser.setFullName(getFullName().getText());
        editUser.setUserType(accessDropDown.getSelectedItem().toString());
        editUser.setBeltRank(beltDropDown.getSelectedItem().toString());

        //Update password only if it was changed
        if (pwdChanged == true) {
            editUser.setPassword(getPassword().getText());
        } 

    }

    /**
     * Saves modifications to the user in the registry. 
     */
    public void saveUser() {
        int userIndex = registry.userIndex(editUser.getUserName());
        registry.updateUser(userIndex, editUser);
        saveRegistry();
    }

    /**
     * When enter is hit submit will be automatically clicked.
     * @param e KeyEvent 
     */
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
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

        //Save changes made to user
        if (e.getSource() == submit) {
            //Check if any changes were made 
            if (findChanges() == false) {
                JOptionPane.showMessageDialog(submit, "No changes were made! "
                        + "Modify the user or click cancel to exit");
            } else {
                //Ensure Access and Belt Rank are not blank 
                if (accessDropDown.getSelectedItem().toString().equals("") 
                        || beltDropDown.getSelectedItem().toString().equals("")) {
                    JOptionPane.showMessageDialog(submit, "User Access and "
                            + "Belt Rank Cannot be Blank");
                } else {
                    //Check if password field was not left blank 
                    if (getPassword().getText().length() > 0) {
                        //Changed to the same password, call updateUser with no password change
                        if (getPassword().getText().equals(editUser.getPassword())) {
                            updateUser(false);
                            saveUser();
                            JOptionPane.showMessageDialog(submit, editUser.getUserName() 
                                    + " has been updated");
                            dispose();
                        } else {
                            if (!getPassword().getText()
                                    .equals(getPasswordConf().getText())) {

                                JOptionPane.showMessageDialog(submit, "Passwords Do Not Match");
                            } else {                            
                                //Password was changed, call updateUser with password change 
                                updateUser(true);
                                saveUser();
                                JOptionPane.showMessageDialog(submit, editUser.getUserName() 
                                        + " has been updated");
                                dispose();
                            }
                        }
                    } else {
                        //Password field was left blank, call updateUser without password change
                        updateUser(false);
                        saveUser();
                        JOptionPane.showMessageDialog(submit, editUser.getUserName() 
                                + " has been updated");
                        dispose();
                    }
                } 
            }

        }

        if (e.getSource() == delete) {
            if (JOptionPane.showConfirmDialog(null, "Are you sure you want to delete"
                    + " user " + editUser.getUserName() + " ?", "WARNING",
                    JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {

                String deleted = editUser.getUserName();
                registry.deleteUser(deleted);
                saveRegistry();
                JOptionPane.showMessageDialog(null, "User " + deleted + "was deleted");
                dispose();
            }
        }
    }

}
