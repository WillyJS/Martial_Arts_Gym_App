package main.java.memoranda;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import main.java.memoranda.EventsManager.Day;
import main.java.memoranda.date.CalendarDate;

public class DojoClass {

    // Setup for Dojo Class US70 PD

    enum BeltRank {
        WHITE, YELLOW, ORANGE, PURPLE, BLUE, BLUESTRIPE, GREEN, GREENSTRIPE, BROWN1, BROWN2,
        BROWN3, BLACK1, BLACK2, BLACK3
    }

    enum ClassType {
        PUBLIC, PRIVATE
    }

    // Testing for US70
    private ArrayList<GymUser> gymMembers;
    // Attributes
    private String name;
    private GymUser trainer;
    private int roomNumber;
    private ArrayList<GymUser> students;
    // Placeholder array used before gson implementation
    private ArrayList<String> testStudents;
    private CalendarDate day;
    private int hour;
    private int min;
    private String classLevel;
    private String classType;
    private int maxClass;

    /**
     * Constructor for a dojoClass object.
     */
    public DojoClass() {
        students = new ArrayList<GymUser>();
        testStudents = new ArrayList<String>();
        maxClass = 20;
        // US70 Create a gym of users to use for testing
        gymMembers = new ArrayList<GymUser>();
        createGym();
    }

    // Getters and Setters
    public GymUser getTrainer() {
        return trainer;
    }

    public void setTrainer(GymUser trainer) {
        this.trainer = trainer;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public ArrayList<GymUser> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<GymUser> students) {
        this.students = students;
    }

    public CalendarDate getDay() {
        return day;
    }

    public void setDay(CalendarDate day) {
        this.day = day;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMin() {
        return min;

    }

    public void setMin(int min) {
        this.min = min;
    }

    public String getClassLevel() {
        return classLevel;
    }

    public void setClassLevel(String classLevel) {
        this.classLevel = classLevel;
    }

    public String getClassType() {
        return classType;
    }

    public void setClassType(String classType) {
        this.classType = classType;
    }

    public ArrayList<String> getTestStudents() {
        return testStudents;
    }

    public void setTestStudents(ArrayList<String> testStudents) {
        this.testStudents = testStudents;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxClass() {
        return maxClass;
    }

    public void setMaxClass(int maxClass) {
        this.maxClass = maxClass;
    }

    public ArrayList<GymUser> getGymMembers() {
        return gymMembers;
    }

    public void setGymMembers(ArrayList<GymUser> gymMembers) {
        this.gymMembers = gymMembers;
    }

    /**
     * This method checks the students belt level and returns true if they are an
     * advanced student.
     * 
     * @param student object that needs belt level checked
     * @return
     */
    public boolean checkStudentLevel(GymUser student) {
        String lev = student.getBeltRank();
        if (lev.equals("WHITE") || lev.equals("YELLOW") || lev.equals("ORANGE")
                || lev.equals("PURPLE")) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * This method will check the trainers belt level. It will return true if the
     * trainer is able to teach advanced classes.
     * 
     * @param trainer object that needs belt level checked
     * @return
     */
    public boolean checkTrainerLevel(GymUser trainer) {
        String lev = trainer.getBeltRank();
        if (lev.equals("BLACK2") || lev.equals("BLACK3")) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Creates a gym full of gym members that can sign up for classes.
     */
    public void createGym() {

        GymUser gymUser1 = new GymUser("1", "XXX", "111", "Student", "WHITE");
        getGymMembers().add(gymUser1);
        GymUser gymUser2 = new GymUser("2", "XXX", "222", "Student", "YELLOW");
        getGymMembers().add(gymUser2);
        GymUser gymUser3 = new GymUser("3", "XXX", "333", "Student", "ORANGE");
        getGymMembers().add(gymUser3);
        GymUser gymUser4 = new GymUser("4", "XXX", "444", "Student", "PURPLE");
        getGymMembers().add(gymUser4);
        GymUser gymUser5 = new GymUser("5", "XXX", "555", "Student", "BLUE");
        getGymMembers().add(gymUser5);
        GymUser gymUser6 = new GymUser("6", "XXX", "666", "Student", "BLUESTRIPE");
        getGymMembers().add(gymUser6);
        GymUser gymUser7 = new GymUser("7", "XXX", "777", "Student", "GREEN");
        getGymMembers().add(gymUser7);
        GymUser gymUser8 = new GymUser("8", "XXX", "888", "Student", "GREENSTRIPE");
        getGymMembers().add(gymUser8);
        GymUser gymUser9 = new GymUser("9", "XXX", "999", "Student", "BROWN1");
        getGymMembers().add(gymUser9);
        GymUser gymUser10 = new GymUser("10", "XXX", "1010", "Student", "BROWN2");
        getGymMembers().add(gymUser10);
        GymUser gymUser11 = new GymUser("11", "XXX", "1111", "Student", "BROWN3");
        getGymMembers().add(gymUser11);
        GymUser gymUser12 = new GymUser("12", "XXX", "1212", "Student", "BLACK1");
        getGymMembers().add(gymUser12);
        GymUser gymUser13 = new GymUser("13", "XXX", "1313", "Student", "BLACK2");
        getGymMembers().add(gymUser13);
        GymUser gymUser14 = new GymUser("14", "XXX", "1414", "Student", "BLACK3");
        getGymMembers().add(gymUser14);
        GymUser gymUser15 = new GymUser("15", "XXX", "trainer1", "Trainer", "BLACK1");
        getGymMembers().add(gymUser15);
        GymUser gymUser16 = new GymUser("16", "XXX", "trainer2", "Trainer", "BLACK2");
        getGymMembers().add(gymUser16);
        GymUser gymUser17 = new GymUser("17", "XXX", "trainer3", "Trainer", "BLACK3");
        getGymMembers().add(gymUser17);
        GymUser gymUser18 = new GymUser("18", "XXX", "1818", "Student", "BROWN2");
        getGymMembers().add(gymUser18);
        GymUser gymUser19 = new GymUser("19", "XXX", "1919", "Student", "BROWN2");
        getGymMembers().add(gymUser19);
        GymUser gymUser20 = new GymUser("20", "XXX", "2020", "Student", "BROWN2");
        getGymMembers().add(gymUser20);
        GymUser gymUser21 = new GymUser("21", "XXX", "2121", "Student", "BROWN2");
        getGymMembers().add(gymUser21);

    }

    /**
     * Prints the class information to the console.
     */
    public void printClassInfo() {
        System.out.println("\n");
        System.out.println(getName() + " Class Information:");
        System.out.println("Date -- " + getDay());
        System.out.println("Time -- " + getHour() + ":00");
        System.out.println("Trainer -- " + getTrainer());
        System.out.println("Class Level -- " + getClassLevel());
        System.out.println("Room # -- " + getRoomNumber());
        System.out.println("Class Type -- " + getClassType());
        System.out.println("List of Students:");
        for (String studentString : getTestStudents()) {
            System.out.println(studentString);
        }
    }

    /**
     * Used to create a string that contains the class objects information.
     * 
     * @return a string that holds class information
     */
    public String printClass() {
        String message = "";
        message += "Name: " + getName() + "\n";
        message += "Date: " + getDay().getFullDateString() + "\n";
        message += "Time: " + getHour() + ":00\n";
        message += "Room: " + getRoomNumber() + "\n";
        message += "List of Students:\n";
        for (GymUser student : getStudents()) {
            String studentString = student.getFullName();
            message += studentString + "\n";
        }
        return message;
    }

    /**
     * Creates a dialog box to display class information.
     * 
     * @param infoMessage class information
     * @param titleBar    sets title of dialog box.
     */
    public void studentBox(String infoMessage, String titleBar) {
        JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + titleBar,
                JOptionPane.INFORMATION_MESSAGE);
    }
}
