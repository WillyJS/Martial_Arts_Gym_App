/**
 * File: GymRegistry.java 
 * @Author: Jesus Quiroz (jaquiro1)
 * Date: 11/17/2020
 * 
 *  Description: Contains GymRegistry class to hold all of the users
 *  in the system database     
 */

package main.java.memoranda;

import java.util.ArrayList;

/**
 * Class: GymRegistry.
 * Description: Uses data structure to hold all system user and provides 
 * functionality to search, add, delete users.  
 */
public class GymRegistry {

    private ArrayList<GymUser> users;

    /**
     * Default constructor initializes the list of users.
     * Also adds a default admin account for tech support
     */
    public GymRegistry() {
        users = new ArrayList<GymUser>();
        GymUser admin = new GymUser("admin","SuperSecret","Default Admin Account","admin","Black");
        setUser(admin);
    }

    /**
     * Adds new user to registry. 
     * @param usr GymUSer
     */
    public void setUser(GymUser usr) {
        if (findUser(usr.getUserName()) == false) {
            users.add(usr);
        } else {
            System.out.println("ERROR - User already exist");
        }
    }

    /**
     * Get registry user by username.
     * @param userName String 
     * @return GymUser 
     */
    public GymUser getUser(String userName) {
        int index = userIndex(userName);
        return users.get(index);
    }

    /**
     * Get registry user by index. 
     * @param index int 
     * @return GymUser
     */
    public GymUser getUSer(int index) {
        return users.get(index);
    }

    /**
     * Takes in a username and indicates if user exists in database. 
     * @param user String representation of the username 
     * @return found boolean to indicate if user was found or not
     */
    public boolean findUser(String user) {
        boolean found = false;

        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUserName().equals(user)) {
                found = true;
            }
        }
        return found;
    }

    /**
     * Returns the list index where the desired user is located.
     * @param user String of the username being searched  
     * @return index int of list location for the user 
     */
    public int userIndex(String user) {
        int index = -1;

        if (findUser(user) == true) {
            for (int i = 0; i < users.size(); i++) {
                if (users.get(i).getUserName().equals(user)) {
                    index = i;
                }
            }
        }
        return index;
    }

    /**
     * Remove user from registry. 
     * @param username String 
     */
    public void deleteUser(String username) {
        if (findUser(username) == true) {
            users.remove(userIndex(username));
        }
    }

    /**
     * Get the size of the registry. 
     * @return int of registry size
     */
    public int registrySize() {    
        return users.size();
    }

    /**
     * Updates user's attributes from another user. 
     * @param index int for specific user 
     * @param user GymUSer containing new values
     */
    public void updateUser(int index, GymUser user) {
        users.get(index).setFullName(user.getFullName());
        users.get(index).setUserType(user.getUserType());
        users.get(index).setBeltRank(user.getBeltRank());
        users.get(index).setPassword(user.getPassword());
    }

    /**
     * Displays the contents of the gym registry list. 
     */
    public String toString() {
        String output = "Total Users: " + users.size();
        for (int i = 0; i < users.size(); i++) {
            output += "\n" + i + users.get(i).getUserName() + "    " + users.get(i).getFullName();
        }
        return output;
    }

    /**
     * Compare GymUser by the alphabetical order of their full name. 
     */
    public void sortRegistry() {
        for (int i = 0; i < users.size(); i++) {
            for (int j = i + 1; j < users.size(); j++) {
                if (users.get(i).getFullName().compareTo(users.get(j).getFullName()) > 0) {
                    GymUser temp = users.get(i);
                    users.set(i, users.get(j));
                    users.set(j, temp);
                }
            }
        }

    }


}
