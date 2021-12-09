import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import main.java.memoranda.ui.LoginWindow;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

/**
 * This class test the login mechanism used when the application is launched.
 * It injects a user name and password and uses that information to authenticate against test strings.
 * @author William J Sanchez
 * @version 1.0
 */
@RunWith(Parameterized.class)
public class LoginBlackBoxTest {

    private Class<main.java.memoranda.ui.LoginWindow> classUnderTest;

    @SuppressWarnings("unchecked")
    public LoginBlackBoxTest(Object classUnderTest){
        this.classUnderTest = (Class<main.java.memoranda.ui.LoginWindow>) classUnderTest;
    }

    @Parameters
    public static Collection<Object[]> underTest(){
        Object[][] classes = {
                {main.java.memoranda.ui.LoginWindow.class}
        };
        return Arrays.asList(classes);
    }

    static LoginWindow login;
    String usernameExpected;
    String passwordExpected;

    @Before
    public void setUp() throws Exception {
        login = new LoginWindow();
        login.getUsername().setText("testUsername");
        login.getPassword().setText("testPassword");

        usernameExpected = "testUsername";
        passwordExpected ="testPassword";
    }

    @After
    public void tearDown() throws Exception {
        login.dispose();
    }

    @Test
    public void getUsernameTest() {
        String ans = login.getUsername().getText();
        assertEquals(usernameExpected, ans);
    }

    @Test
    public void getPasswordTest() {
        String ans = login.getPassword().getText();
        assertEquals(passwordExpected, ans);
    }

    @Test
    public void getUsernameTestWrongUsername() {
        String pass = "testPassword1";
        assertNotEquals(login.getPassword().getText(), pass);
    }
    @Test
    public void getPasswordTestWrongPassword() {
        String pass = "testPassword1";
        assertNotEquals(login.getPassword().getText(), pass);
    }

}