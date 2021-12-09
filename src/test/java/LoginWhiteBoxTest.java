package test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import main.java.memoranda.ui.LoginWindow;

import javax.swing.*;

import java.awt.*;
import java.awt.event.KeyEvent;

import static org.junit.Assert.*;

/**
 * This class test the login mechanism used when the application is launched.
 * It injects a user name and password and uses that information to authenticate against test strings.
 * @author William J Sanchez
 * @version 1.0
 */
public class LoginWhiteBoxTest {

    static LoginWindow login;

    @Before
    public void setUp() throws Exception {
        login = new LoginWindow();
        login.getUsername().setText("testUsername");
        login.getPassword().setText("testPassword");
    }

    @After
    public void tearDown() throws Exception {
        login.dispose();
    }

    @Test
    public void getUsernameTest() {
        String ans = "testUsername";
        String usernameExpected = login.getUsername().getText();
        assertEquals(usernameExpected, ans);
    }

    @Test
    public void getPasswordTest() {
        String ans = "testPassword";
        assertEquals(login.getPassword().getText(), ans);
    }
}