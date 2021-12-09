//package test.test;

//import main.java.*;

//import main.java.memoranda.GymUser;

//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.junit.runners.Parameterized;
//import org.junit.runners.Parameterized.Parameters;

//import java.lang.reflect.Constructor;
//import java.lang.reflect.*;
//import java.util.Arrays;
//import java.util.Collection;
//import java.util.HashMap;
//import java.util.Map;

//import static org.junit.Assert.*;

//@RunWith(Parameterized.class)
//public class BackendBlackbox {

//  private Class<main.java.memoranda.GymUser> testedClass;

//    @SuppressWarnings("unchecked")
//    public BackendBlackbox(Object testedClass) {
//        this.testedClass = (Class<main.java.memoranda.GymUser>) testedClass;
//    }

//    @Parameters
//    public static Collection<Object[]> underTest() {
//        Object[][] classes = {
//                {main.java.memoranda.GymUser.class}
//        };
//        return Arrays.asList(classes);
//    }

//    main.java.memoranda.GymUser user;

//    String nameJExpected;
//    String passwordJExpected;
//    String fullNameJExpected;
//    String userTypeJExpected;
//    String beltRankJExpected;

//    @Before
//    public void setUp() throws Exception {

//      user = new GymUser();
      
//      nameJExpected = "mdiaz";
//      passwordJExpected = "noMercy";
//      fullNameJExpected = "Miguel diaz";
//      userTypeJExpected = "trainer";
//      beltRankJExpected = "black";
      
//      user.populateUser();

//    }

//    @After
//    public void tearDown() throws Exception {}

    /**
     * Sample tests making sure GymUser returns correct
     * userName when getters are used after running populate().
     */
   /*This tests userName getter method.*/
//    @Test
//    public void userNameGetter() {

//        String ans =  user.getUserName();
//        assertEquals(nameJExpected, ans);

//    }
    
    /**
     * Sample tests making sure GymUser returns correct
     * password when getters are used after running populate().
     */
   /*This tests password getter method.*/
//    @Test
//    public void passwordGetter() {

//        String ans =  user.getPassword();
//        assertEquals(passwordJExpected, ans);

//    }
    
    /**
     * Sample tests making sure GymUser returns correct
     * userType when getters are used after running populate().
     */
   /*This tests userType getter method.*/
//    @Test
//    public void userTypeGetter() {

//        String ans =  user.getUserType();
//        assertEquals(userTypeJExpected, ans);

//    }
    
    /**
     * Sample tests making sure GymUser returns correct
     * fullName when getters are used after running populate().
     */
   /*This tests fullName getter method.*/
//    @Test
//    public void userFullNameGetter() {

//        String ans =  user.getFullName();
//        assertEquals(fullNameJExpected, ans);

//    }
    
    /**
     * Sample tests making sure GymUser returns correct
     * beltRank when getters are used after running populate().
     */
   /*This tests beltRank getter method.*/
//    @Test
//    public void beltRankGetter() {

//        String ans =  user.getBeltRank();
//        assertEquals(beltRankJExpected, ans);

//    }

//}