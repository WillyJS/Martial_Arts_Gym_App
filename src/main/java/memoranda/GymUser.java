/**
 * File: GymUser.java 
 * @Author: Jesus Quiroz (jaquiro1)
 * Date: 11/17/2020
 * 
 *  Description: Contains GymUser class to be used for program 
 *  access and permission 
 */

package main.java.memoranda;

/**
 * Class: GymUser. 
 * Description: Class constructs gym user with all needed attributes 
 */
public class GymUser {

    private String userName; 
    private String password; 
    private String fullName; 
    private String userType; 
    private String beltRank;

    /**
     * Default constructor. 
     */
    public GymUser() {
        this.userName = null;
        this.password = null;
        this.fullName = null;
        this.userType = null; 
        this.beltRank = null;
    }

    /**
     * Constructor with all parameters to initialize. 
     * @param usrName String representing the username for system access 
     * @param pwd String for password 
     * @param name String for the user's full name 
     * @param type String for user access account type  
     * @param belt String representing user's belt rank 
     */
    public GymUser(String usrName, String pwd, String name, String type,String belt) {
        this.userName = usrName;
        this.password = pwd;
        this.fullName = name;
        this.userType = type; 
        this.beltRank = belt;
    }

    public void setName(String user) {
        this.userName = user;
    }

    public String getUserName() {
        return userName;
    }

    public void setPassword(String pwd) {
        this.password = pwd;
    }

    public String getPassword() {
        return password;
    }

    public void setFullName(String name) {
        this.fullName = name;
    }

    public String getFullName() {
        return fullName;
    }

    public void setUserType(String type) {
        this.userType = type;
    }

    public String getUserType() {
        return userType;
    }

    public void setBeltRank(String belt) {
        this.beltRank = belt;
    }

    public String getBeltRank() {
        return beltRank;
    }
    
}

