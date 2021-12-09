//import main.java.*;
//
//import main.java.memoranda.date.*;
//
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.junit.runners.Parameterized;
//import org.junit.runners.Parameterized.Parameters;
//
//import java.lang.reflect.Constructor;
//import java.lang.reflect.*;
//import java.util.Arrays;
//import java.util.Collection;
//import java.util.HashMap;
//import java.util.Map;
//
//import static org.junit.Assert.*;
//
//@RunWith(Parameterized.class)
//public class GeneralBlackbox {
//
//	private Class<main.java.memoranda.date.CalendarDate> testedClass;
//
//    @SuppressWarnings("unchecked")
//    public GeneralBlackbox(Object testedClass) {
//        this.testedClass = (Class<main.java.memoranda.date.CalendarDate>) testedClass;
//    }
//
//    @Parameters
//    public static Collection<Object[]> underTest() {
//        Object[][] classes = {
//                {main.java.memoranda.date.CalendarDate.class}
//        };
//        return Arrays.asList(classes);
//    }
//
//    main.java.memoranda.date.CalendarDate date;
//
//    int dayExpected;
//    int monthExpected;
//    int yearExpected;
//
//    @Before
//    public void setUp() throws Exception {
//
//    	date = new CalendarDate(1, 1, 2020);
//
//        dayExpected = 1;
//        monthExpected = 1;
//        yearExpected = 2020;
//
//    }
//
//    @After
//    public void tearDown() throws Exception {}
//
//    /**
//     * Sample tests making sure CalendarDate returns correct
//     * day, month, and year when getters are used.
//     */
//
//    /*This tests day getter method.*/
//    @Test
//    public void dayGetter() {
//
//        int ans = date.getDay();
//        assertEquals(dayExpected, ans);
//
//    }
//
//    /*This tests month getter method.*/
//    @Test
//    public void monthGetter() {
//
//        int ans = date.getMonth();
//        assertEquals(monthExpected, ans);
//
//    }
//
//    /*This tests year getter method.*/
//    @Test
//    public void yearGetter() {
//
//        int ans = date.getYear();
//        assertEquals(yearExpected, ans);
//
//    }
//
//}
