package test.test;


import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import main.java.memoranda.GymUser;


public class GymUserWhitebox {

    String user = "username";
    String pwd = "password!";
    String name = "Test Account";
    String accountType = "admin";
    String belt = "blue";
    GymUser testUser = new GymUser(user,pwd,name,accountType,belt);

    @Test
    public void defaultUserCreationTest() {
        GymUser user = new GymUser();
        assertEquals(null,user.getUserName());
    }

    @Test
    public void parametirizedConstructedUserNotNull() {
        assertNotEquals(null,testUser.getUserName());
    }

    @Test
    public void returnCorrectUserName () {
        assertEquals(user,testUser.getUserName());
    }

    @Test
    public void returnCorrectPassword() {
        assertEquals(pwd,testUser.getPassword());
    }

    @Test
    public void returnCorrectName() {
        assertEquals(name,testUser.getFullName());
    }

    @Test
    public void returnCorrectUserType() {
        assertEquals(accountType,testUser.getUserType());
    }

    @Test
    public void returnCorrectBeltRank() { 
        assertEquals(belt, testUser.getBeltRank());
    }

    @Test
    public void setAndGetNewUserName() {
        String newName = "newUser";
        testUser.setName(newName);
        assertEquals(newName,testUser.getUserName());
    }

    @Test
    public void setAndGetNewPassword() {
        String newPwd = "ThisIsNew!";
        testUser.setPassword(newPwd);
        assertEquals(newPwd,testUser.getPassword());
    }

    @Test
    public void setAndGetNewFullName() {
        String newFullName = "John Doe";
        testUser.setFullName(newFullName);
        assertEquals(newFullName,testUser.getFullName());
    }

    @Test
    public void setAndGetNewUserType() {
        String acctType = "student";
        testUser.setUserType(acctType);
        assertEquals(acctType,testUser.getUserType());
    }

    @Test
    public void setAndGetNewBeltRank() {
        String newBelt = "black";
        testUser.setBeltRank(newBelt);
        assertEquals(newBelt,testUser.getBeltRank());
    }

}
