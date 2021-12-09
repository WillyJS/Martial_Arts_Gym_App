package main.java.memoranda.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import main.java.memoranda.DojoClass;
import main.java.memoranda.EventsManager;
import main.java.memoranda.EventsScheduler;
import main.java.memoranda.GymUser;
import main.java.memoranda.History;
import main.java.memoranda.Room;
import main.java.memoranda.date.CalendarDate;
import main.java.memoranda.date.CurrentDate;
import main.java.memoranda.date.DateListener;
import main.java.memoranda.util.Configuration;
import main.java.memoranda.util.CurrentStorage;
import main.java.memoranda.util.Local;
import main.java.memoranda.util.Util;

/*$Id: EventsPanel.java,v 1.25 2005/02/19 10:06:25 rawsushi Exp $*/
public class EventsPanel extends JPanel {
    BorderLayout borderLayout1 = new BorderLayout();
    JButton historyBackB = new JButton();
    JToolBar eventsToolBar = new JToolBar();
    JButton historyForwardB = new JButton();
    JButton newEventB = new JButton();
    JButton editEventB = new JButton();
    JButton removeEventB = new JButton();
    JScrollPane scrollPane = new JScrollPane();
    EventsTable eventsTable = new EventsTable();
    JPopupMenu eventPPMenu = new JPopupMenu();
    JMenuItem ppEditEvent = new JMenuItem();
    JMenuItem ppRemoveEvent = new JMenuItem();
    JMenuItem ppNewEvent = new JMenuItem();
    DailyItemsPanel parentPanel = null;

    // US70 PD Added ArrayList of dojo classes
    public ArrayList<DojoClass> dojoClasses = new ArrayList<DojoClass>();
    // US70 PD Added an arrayList of rooms to store classes
    private ArrayList<Room> rooms = new ArrayList<Room>();

    /**
    * Constructor for the EventsPanel class
    */
    public EventsPanel(DailyItemsPanel _parentPanel) {
        try {
            parentPanel = _parentPanel;
            // Create four rooms for the gym
            Room room1 = new Room();
            rooms.add(room1);
            Room room2 = new Room();
            rooms.add(room2);
            Room room3 = new Room();
            rooms.add(room3);
            Room room4 = new Room();
            rooms.add(room4);

            jbInit();
        } catch (Exception ex) {
            new ExceptionDialog(ex);
        }
    }

    void jbInit() throws Exception {
        eventsToolBar.setFloatable(false);

        historyBackB.setAction(History.historyBackAction);
        historyBackB.setFocusable(false);
        historyBackB.setBorderPainted(false);
        historyBackB.setToolTipText(Local.getString("History back"));
        historyBackB.setRequestFocusEnabled(false);
        historyBackB.setPreferredSize(new Dimension(24, 24));
        historyBackB.setMinimumSize(new Dimension(24, 24));
        historyBackB.setMaximumSize(new Dimension(24, 24));
        historyBackB.setText("");

        historyForwardB.setAction(History.historyForwardAction);
        historyForwardB.setBorderPainted(false);
        historyForwardB.setFocusable(false);
        historyForwardB.setPreferredSize(new Dimension(24, 24));
        historyForwardB.setRequestFocusEnabled(false);
        historyForwardB.setToolTipText(Local.getString("History forward"));
        historyForwardB.setMinimumSize(new Dimension(24, 24));
        historyForwardB.setMaximumSize(new Dimension(24, 24));
        historyForwardB.setText("");

        newEventB.setIcon(new ImageIcon(
                main.java.memoranda.ui.AppFrame.class.getResource("/ui/icons/event_new.png")));
        newEventB.setEnabled(true);
        newEventB.setMaximumSize(new Dimension(24, 24));
        newEventB.setMinimumSize(new Dimension(24, 24));
        newEventB.setToolTipText(Local.getString("New Class"));
        newEventB.setRequestFocusEnabled(false);
        newEventB.setPreferredSize(new Dimension(24, 24));
        newEventB.setFocusable(false);
        newEventB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                newEventB_actionPerformed(e);
            }
        });
        newEventB.setBorderPainted(false);

        editEventB.setBorderPainted(false);
        editEventB.setFocusable(false);
        editEventB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                editEventB_actionPerformed(e);
            }
        });
        editEventB.setPreferredSize(new Dimension(24, 24));
        editEventB.setRequestFocusEnabled(false);
        editEventB.setToolTipText(Local.getString("Edit Class/Add Student"));
        editEventB.setMinimumSize(new Dimension(24, 24));
        editEventB.setMaximumSize(new Dimension(24, 24));
        editEventB.setEnabled(true);
        editEventB.setIcon(new ImageIcon(
                main.java.memoranda.ui.AppFrame.class.getResource("/ui/icons/event_edit.png")));

        removeEventB.setBorderPainted(false);
        removeEventB.setFocusable(false);
        removeEventB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                removeEventB_actionPerformed(e);
            }
        });
        removeEventB.setPreferredSize(new Dimension(24, 24));
        removeEventB.setRequestFocusEnabled(false);
        removeEventB.setToolTipText(Local.getString("Remove Class"));
        removeEventB.setMinimumSize(new Dimension(24, 24));
        removeEventB.setMaximumSize(new Dimension(24, 24));
        removeEventB.setIcon(new ImageIcon(
                main.java.memoranda.ui.AppFrame.class.getResource("/ui/icons/event_remove.png")));

        this.setLayout(borderLayout1);
        scrollPane.getViewport().setBackground(Color.white);
        eventsTable.setMaximumSize(new Dimension(32767, 32767));
        eventsTable.setRowHeight(24);
        eventPPMenu.setFont(new java.awt.Font("Dialog", 1, 10));
        ppEditEvent.setFont(new java.awt.Font("Dialog", 1, 11));
        ppEditEvent.setText(Local.getString("Edit event") + "...");
        ppEditEvent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ppEditEvent_actionPerformed(e);
            }
        });
        ppEditEvent.setEnabled(false);
        ppEditEvent.setIcon(new ImageIcon(
                main.java.memoranda.ui.AppFrame.class.getResource("/ui/icons/event_edit.png")));
        ppRemoveEvent.setFont(new java.awt.Font("Dialog", 1, 11));
        ppRemoveEvent.setText(Local.getString("Remove event"));
        ppRemoveEvent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ppRemoveEvent_actionPerformed(e);
            }
        });
        ppRemoveEvent.setIcon(new ImageIcon(
                main.java.memoranda.ui.AppFrame.class.getResource("/ui/icons/event_remove.png")));
        ppRemoveEvent.setEnabled(false);
        ppNewEvent.setFont(new java.awt.Font("Dialog", 1, 11));
        ppNewEvent.setText(Local.getString("New event") + "...");
        ppNewEvent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ppNewEvent_actionPerformed(e);
            }
        });
        ppNewEvent.setIcon(new ImageIcon(
                main.java.memoranda.ui.AppFrame.class.getResource("/ui/icons/event_new.png")));
        scrollPane.getViewport().add(eventsTable, null);
        this.add(scrollPane, BorderLayout.CENTER);
        eventsToolBar.add(historyBackB, null);
        eventsToolBar.add(historyForwardB, null);
        eventsToolBar.addSeparator(new Dimension(8, 24));

        eventsToolBar.add(newEventB, null);
        eventsToolBar.add(removeEventB, null);
        eventsToolBar.addSeparator(new Dimension(8, 24));
        eventsToolBar.add(editEventB, null);

        this.add(eventsToolBar, BorderLayout.NORTH);

        PopupListener ppListener = new PopupListener();
        scrollPane.addMouseListener(ppListener);
        eventsTable.addMouseListener(ppListener);

        CurrentDate.addDateListener(new DateListener() {
            public void dateChange(CalendarDate d) {
                eventsTable.initTable(d);
                boolean enbl = d.after(CalendarDate.today()) || d.equals(CalendarDate.today());
                newEventB.setEnabled(enbl);
                ppNewEvent.setEnabled(enbl);
                editEventB.setEnabled(false);
                ppEditEvent.setEnabled(false);
                removeEventB.setEnabled(false);
                ppRemoveEvent.setEnabled(false);
            }
        });

        eventsTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                boolean enbl = eventsTable.getSelectedRow() > -1;
                editEventB.setEnabled(enbl);
                ppEditEvent.setEnabled(enbl);
                removeEventB.setEnabled(enbl);
                ppRemoveEvent.setEnabled(enbl);
            }
        });
        editEventB.setEnabled(false);
        removeEventB.setEnabled(false);
        eventPPMenu.add(ppEditEvent);
        eventPPMenu.addSeparator();
        eventPPMenu.add(ppNewEvent);
        eventPPMenu.add(ppRemoveEvent);

        // remove events using the DEL key
        eventsTable.addKeyListener(new KeyListener() {
            public void keyPressed(KeyEvent e) {
                if (eventsTable.getSelectedRows().length > 0 && e.getKeyCode() == KeyEvent.VK_DELETE) {
                    ppRemoveEvent_actionPerformed(null);
                }
            }

            public void keyReleased(KeyEvent e) {
            }

            public void keyTyped(KeyEvent e) {
            }
        });
    }

    void editEventB_actionPerformed(ActionEvent e) {
        EventDialog dlg = new EventDialog(App.getFrame(), Local.getString("Event"));
        main.java.memoranda.Event ev = (main.java.memoranda.Event) eventsTable.getModel()
                .getValueAt(eventsTable.getSelectedRow(), EventsTable.EVENT);

        dlg.timeSpin.getModel().setValue(ev.getTime());
        /*
         * if (new CalendarDate(ev.getTime()).equals(CalendarDate.today()))
         * ((SpinnerDateModel)dlg.timeSpin.getModel()).setStart(new Date()); else
         * ((SpinnerDateModel)dlg.timeSpin.getModel()).setStart(CalendarDate.today().
         * getDate());
         * ((SpinnerDateModel)dlg.timeSpin.getModel()).setEnd(CalendarDate.tomorrow().
         * getDate());
         */
        // Setting up Text US70 PD
        dlg.textField.setText(ev.getText());
        dlg.trainerField.setText(ev.getTrainer());
        // Set level spinner
        String level = ev.getLevel();
        dlg.levelSpinner.setValue(ev.getLevel());
        // Set room spinner
        Integer room = Integer.parseInt(ev.getRoom());
        dlg.roomSpinner.setValue(room);
        dlg.typeSpinner.setValue(ev.getClassType());

        // Get Dojo Class object from arraylist US70 PD
        int dojoId = Integer.parseInt(ev.getDojoId());
        DojoClass dojoClass = dojoClasses.get(dojoId);

        int rep = ev.getRepeat();
        if (rep > 0) {
            dlg.startDate.getModel().setValue(ev.getStartDate().getDate());
            if (rep == EventsManager.REPEAT_DAILY) {
                dlg.dailyRepeatRB.setSelected(true);
                dlg.dailyRepeatRB_actionPerformed(null);
                dlg.daySpin.setValue(new Integer(ev.getPeriod()));
            } else if (rep == EventsManager.REPEAT_WEEKLY) {
                dlg.weeklyRepeatRB.setSelected(true);
                dlg.weeklyRepeatRB_actionPerformed(null);
                int d = ev.getPeriod() - 1;
                if (Configuration.get("FIRST_DAY_OF_WEEK").equals("mon")) {
                    d--;
                    if (d < 0) {
                        d = 6;
                    }
                }
                dlg.weekdaysCB.setSelectedIndex(d);
            } else if (rep == EventsManager.REPEAT_MONTHLY) {
                dlg.monthlyRepeatRB.setSelected(true);
                dlg.monthlyRepeatRB_actionPerformed(null);
                dlg.dayOfMonthSpin.setValue(new Integer(ev.getPeriod()));
            } else if (rep == EventsManager.REPEAT_YEARLY) {
                dlg.yearlyRepeatRB.setSelected(true);
                dlg.yearlyRepeatRB_actionPerformed(null);
                dlg.dayOfMonthSpin.setValue(new Integer(ev.getPeriod()));
            }
            if (ev.getEndDate() != null) {
                dlg.endDate.getModel().setValue(ev.getEndDate().getDate());
                dlg.enableEndDateCB.setSelected(true);
                dlg.enableEndDateCB_actionPerformed(null);
            }
            if (ev.getWorkingDays()) {
                dlg.workingDaysOnlyCB.setSelected(true);
            }

        }

        Dimension frmSize = App.getFrame().getSize();
        Point loc = App.getFrame().getLocation();
        dlg.setLocation((frmSize.width - dlg.getSize().width) / 2 + loc.x,
                (frmSize.height - dlg.getSize().height) / 2 + loc.y);
        dlg.setVisible(true);
        if (dlg.CANCELLED) {
            return;
        }
        EventsManager.removeEvent(ev);

        Calendar calendar = new GregorianCalendar(Local.getCurrentLocale()); // Fix deprecated
                                                                             // methods to get
                                                                             // hours
        // by (jcscoobyrs) 14-Nov-2003 at 10:24:38 AM
        calendar.setTime(((Date) dlg.timeSpin.getModel().getValue()));// Fix deprecated methods to
                                                                      // get hours
        // by (jcscoobyrs) 14-Nov-2003 at 10:24:38 AM
        int hh = calendar.get(Calendar.HOUR_OF_DAY);// Fix deprecated methods to get hours
        // by (jcscoobyrs) 14-Nov-2003 at 10:24:38 AM
        int mm = calendar.get(Calendar.MINUTE);// Fix deprecated methods to get hours
        // by (jcscoobyrs) 14-Nov-2003 at 10:24:38 AM

        // int hh = ((Date) dlg.timeSpin.getModel().getValue()).getHours();
        // int mm = ((Date) dlg.timeSpin.getModel().getValue()).getMinutes();
        String text = dlg.textField.getText();
        String trainer = dlg.trainerField.getText();

        // US70 PD
        String student = dlg.studentField.getText();
        // Verify Student hasn't been already added
        boolean isPresent = false;
        for (GymUser user : dojoClass.getStudents()) {
            if (student.equals(user.getFullName())) {
                isPresent = true;
                System.out.println("Student is already enrolled in this class.");
                JOptionPane.showMessageDialog(null, "Student is already enrolled in this class.",
                        "Error", JOptionPane.INFORMATION_MESSAGE);

            }
        }
        // Add student to dojoclass if not already enrolled and check if class is public
        // US70 PD
        if (!student.equals("") && isPresent == false) {
            // Find gymuser from student string provided
            GymUser studentUser = null;
            for (GymUser user : dojoClass.getGymMembers()) {
                if (student.equals(user.getFullName())) {
                    studentUser = user;
                }
            }
            // If student string is not a gym member
            if (studentUser == null) {
                System.out.println("Student is not a Gym Member!");
                JOptionPane.showMessageDialog(null, "Student provided is not a gym member.",
                        "Error", JOptionPane.INFORMATION_MESSAGE);
            }
            // Make sure not too many students
            if (dojoClass.getStudents().size() < dojoClass.getMaxClass() && studentUser != null) {
                // Add student to public class
                if (isPresent == false && dojoClass.getClassType().equals("Public")) {
                    // Check student level to make sure right level for advanced class
                    if (dojoClass.getClassLevel().equals("Adv.")) {
                        if (dojoClass.checkStudentLevel(studentUser)) {
                            dojoClass.getStudents().add(studentUser);
                        } else {
                            JOptionPane.showMessageDialog(null, "Student is too low in Belt Rank.",
                                    "Error", JOptionPane.INFORMATION_MESSAGE);
                        }
                    } else {
                        dojoClass.getStudents().add(studentUser);
                    }
                }
                // Add Student to private class
                if (dojoClass.getClassType().equals("Private")) {
                    // Only one Student allowed
                    if (dojoClass.getStudents().size() == 0) {
                        dojoClass.getStudents().add(studentUser);
                    } else {
                        System.out.println("Class is Full");
                        JOptionPane.showMessageDialog(null, "Private Class student limit is one.",
                                "Error", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            } else if (studentUser != null) {
                // Public class has 20 students already
                System.out.println("Class Already has Maximum students.");
                JOptionPane.showMessageDialog(null,
                        "Class Limit Reached!\nPublic class Student limit is 20.", "Error",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        }
        room = (Integer) dlg.roomSpinner.getValue();

        level = (String) dlg.levelSpinner.getValue();

        String classType = (String) dlg.typeSpinner.getValue();

        // US70 PD fill attributes for dojo class object

        dojoClass.setMin(mm);
        dojoClass.setHour(hh);
        dojoClass.setClassLevel(level);
        dojoClass.setRoomNumber(room);
        dojoClass.setClassType(classType);

        // Check if trainer is valid US70 PD
        GymUser trainerUser = null;
        for (GymUser trainUser : dojoClass.getGymMembers()) {
            if (trainUser.getUserType().equals("Trainer")
                    && trainer.equals(trainUser.getFullName())) {
                trainerUser = trainUser;
            }
        }

        // Check trainer variables
        if (trainerUser != null) {
            if (dojoClass.getClassLevel().equals("Adv.")) {
                if (dojoClass.checkTrainerLevel(trainerUser)) {
                    dojoClass.setTrainer(trainerUser);
                } else {
                    JOptionPane.showMessageDialog(null, "Trainer's Level is too Low.", "Error",
                            JOptionPane.INFORMATION_MESSAGE);
                    trainer = "";
                }
            } else {
                dojoClass.setTrainer(trainerUser);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Trainer provided is not Valid.", "Error",
                    JOptionPane.INFORMATION_MESSAGE);
            trainer = "";
        }

        if (trainer.equals("")) {
            trainer = "None Assigned";
        }

        // US 70 Test class updates
        dojoClass.printClassInfo();
        dojoClass.studentBox(dojoClass.printClass(), "Class Information");

        if (dlg.noRepeatRB.isSelected()) {
            EventsManager.createEvent(CurrentDate.get(), hh, mm, text, trainer, student, room,
                    level, dojoId, classType);
        } else {
            updateEvents(dlg, hh, mm, text, trainer);
        }
        saveEvents();
    }

    void newEventB_actionPerformed(ActionEvent e) {
        Calendar cdate = CurrentDate.get().getCalendar();
        // round down to hour
        cdate.set(Calendar.MINUTE, 0);
        Util.debug("Default time is " + cdate);

        newEventB_actionPerformed(e, null, cdate.getTime(), cdate.getTime());
    }

    void newEventB_actionPerformed(ActionEvent e, String tasktext, Date startDate, Date endDate) {
        EventDialog dlg = new EventDialog(App.getFrame(), Local.getString("New event"));
        Dimension frmSize = App.getFrame().getSize();
        Point loc = App.getFrame().getLocation();

        // Create String for trainer information US29 PD
        String trainer = null;
        // Create String for students US70
        String student = null;

        if (tasktext != null) {
            dlg.textField.setText(tasktext);
        }

        // Set trainer field to null if it is not US29 PD
        dlg.trainerField.setText(trainer);
        // US70 PD
        dlg.studentField.setText(student);

        dlg.startDate.getModel().setValue(startDate);
        dlg.endDate.getModel().setValue(endDate);
        dlg.timeSpin.getModel().setValue(startDate);

        dlg.setLocation((frmSize.width - dlg.getSize().width) / 2 + loc.x,
                (frmSize.height - dlg.getSize().height) / 2 + loc.y);
        dlg.setEventDate(startDate);
        dlg.setVisible(true);
        if (dlg.CANCELLED){
            return;
        }

        // Create a dojoclass US70 PD
        DojoClass dojoClass = new DojoClass();
        dojoClasses.add(dojoClass);

        // US70 Add an id for the EventsManager
        int dojoId = dojoClasses.size() - 1;

        Calendar calendar = new GregorianCalendar(Local.getCurrentLocale()); // Fix deprecated
        // methods to get
        // hours
        // by (jcscoobyrs) 14-Nov-2003 at 10:24:38 AM
        calendar.setTime(((Date) dlg.timeSpin.getModel().getValue()));// Fix deprecated methods to
                                                                      // get hours
        // by (jcscoobyrs) 14-Nov-2003 at 10:24:38 AM
        int hh = calendar.get(Calendar.HOUR_OF_DAY);// Fix deprecated methods to get hours
        // by (jcscoobyrs) 14-Nov-2003 at 10:24:38 AM
        int mm = calendar.get(Calendar.MINUTE);// Fix deprecated methods to get hours
        // by (jcscoobyrs) 14-Nov-2003 at 10:24:38 AM

        // int hh = ((Date) dlg.timeSpin.getModel().getValue()).getHours();
        // int mm = ((Date) dlg.timeSpin.getModel().getValue()).getMinutes();
        String text = dlg.textField.getText();

        // US Get Student data US70 PD
        student = dlg.studentField.getText();

        CalendarDate eventCalendarDate = new CalendarDate(dlg.getEventDate());

        String level = (String) dlg.levelSpinner.getValue();
        String classType = (String) dlg.typeSpinner.getValue();

        // Get text from trainer field US29 PD
        trainer = dlg.trainerField.getText();

        // US70 PD fill attributes for dojo class object
        dojoClass.setName(text);
        dojoClass.setDay(eventCalendarDate);
        dojoClass.setMin(mm);
        dojoClass.setHour(hh);
        dojoClass.setClassLevel(level);

        // US70 check to see if room is available
        int room = 0;
        for (int i = 0; i < dojoClasses.size(); i++) {
            if (dojoClasses.get(i).getDay().getFullDateString()
                    .equals(dojoClass.getDay().getFullDateString())) {
                if (dojoClasses.get(i).getHour() == dojoClass.getHour()) {
                    room++;
                }
            }
        }

        // Only add class if room is available US70 PD
        if (room < 5) {

            dojoClass.setRoomNumber(room);
            // Add dojoclass to the room object
            rooms.get(room - 1).getDojoClasses().add(dojoClass);

            // Check if trainer is valid US70 PD
            GymUser trainerUser = null;
            for (GymUser trainUser : dojoClass.getGymMembers()) {
                if (trainUser.getUserType().equals("Trainer")
                        && trainer.equals(trainUser.getFullName())) {
                    trainerUser = trainUser;
                }
            }

            // Check trainer variables
            if (trainerUser != null) {
                if (dojoClass.getClassLevel().equals("Adv.")) {
                    if (dojoClass.checkTrainerLevel(trainerUser)) {
                        dojoClass.setTrainer(trainerUser);
                    } else {
                        JOptionPane.showMessageDialog(null, "Trainer's Level is too Low.", "Error",
                                JOptionPane.INFORMATION_MESSAGE);
                        trainer = "";
                    }
                } else {
                    dojoClass.setTrainer(trainerUser);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Trainer provided is not Valid.", "Error",
                        JOptionPane.INFORMATION_MESSAGE);
                trainer = "";
            }

            if (trainer.equals("")) {
                trainer = "None Assigned";
            }

            if (!student.equals("")) {
                GymUser studentUser = null;
                for (GymUser user : dojoClass.getGymMembers()) {
                    if (student.equals(user.getFullName())) {
                        studentUser = user;
                        break;
                    }
                }
                if (studentUser == null) {
                    JOptionPane.showMessageDialog(null, "Student provided is not a gym member.",
                            "Error", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    if (dojoClass.getClassLevel().equals("Adv.")) {
                        if (dojoClass.checkStudentLevel(studentUser)) {
                            dojoClass.getStudents().add(studentUser);
                        } else {
                            JOptionPane.showMessageDialog(null, "Student is too low in Belt Rank.",
                                    "Error", JOptionPane.INFORMATION_MESSAGE);
                        }
                    } else {
                        dojoClass.getStudents().add(studentUser);
                    }
                }
            }
            dojoClass.setClassType(classType);

            // Print out created class Information
            dojoClass.printClassInfo();
            dojoClass.studentBox(dojoClass.printClass(), "Class Information");

            if (dlg.noRepeatRB.isSelected()) {
                EventsManager.createEvent(eventCalendarDate, hh, mm, text, trainer, student, room,
                        level, dojoId, classType);
            } else {
                updateEvents(dlg, hh, mm, text, trainer);
            }
            saveEvents();
        } else {
            JOptionPane.showMessageDialog(null,
                    "All rooms are full!\nPlease choose a different time.", "Error",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void saveEvents() {
        CurrentStorage.get().storeEventsManager();
        eventsTable.refresh();
        EventsScheduler.init();
        parentPanel.calendar.jnCalendar.updateUI();
        parentPanel.updateIndicators();
    }

    private void updateEvents(EventDialog dlg, int hh, int mm, String text, String trainer) {
        int rtype;
        int period;
        CalendarDate sd = new CalendarDate((Date) dlg.startDate.getModel().getValue());
        CalendarDate ed = null;
        if (dlg.enableEndDateCB.isSelected()) {
            ed = new CalendarDate((Date) dlg.endDate.getModel().getValue());
        }
        if (dlg.dailyRepeatRB.isSelected()) {
            rtype = EventsManager.REPEAT_DAILY;
            period = ((Integer) dlg.daySpin.getModel().getValue()).intValue();
        } else if (dlg.weeklyRepeatRB.isSelected()) {
            rtype = EventsManager.REPEAT_WEEKLY;
            period = dlg.weekdaysCB.getSelectedIndex() + 1;
            if (Configuration.get("FIRST_DAY_OF_WEEK").equals("mon")) {
                if (period == 7) {
                    period = 1;
                } else
                    period++;
            }
        } else if (dlg.yearlyRepeatRB.isSelected()) {
            rtype = EventsManager.REPEAT_YEARLY;
            period = sd.getCalendar().get(Calendar.DAY_OF_YEAR);
            if ((sd.getYear() % 4) == 0 && sd.getCalendar().get(Calendar.DAY_OF_YEAR) > 60){
                period--;
            }
        } else {
            rtype = EventsManager.REPEAT_MONTHLY;
            period = ((Integer) dlg.dayOfMonthSpin.getModel().getValue()).intValue();
        }
        EventsManager.createRepeatableEvent(rtype, sd, ed, period, hh, mm, text, trainer,
                dlg.workingDaysOnlyCB.isSelected());
    }

    void removeEventB_actionPerformed(ActionEvent e) {
        String msg;
        main.java.memoranda.Event ev;

        if (eventsTable.getSelectedRows().length > 1) {
            msg = Local.getString("Remove") + " " + eventsTable.getSelectedRows().length + " "
                    + Local.getString("events") + "\n" + Local.getString("Are you sure?");
        } else {
            ev = (main.java.memoranda.Event) eventsTable.getModel()
                    .getValueAt(eventsTable.getSelectedRow(), EventsTable.EVENT);
            msg = Local.getString("Remove event") + "\n'" + ev.getText() + "'\nTrainer: "
                    + ev.getTrainer() + "\n" + Local.getString("Are you sure?");
        }

        int n = JOptionPane.showConfirmDialog(App.getFrame(), msg, Local.getString("Remove event"),
                JOptionPane.YES_NO_OPTION);
        if (n != JOptionPane.YES_OPTION) {
            return;
        }

        for (int i = 0; i < eventsTable.getSelectedRows().length; i++) {
            ev = (main.java.memoranda.Event) eventsTable.getModel()
                    .getValueAt(eventsTable.getSelectedRows()[i], EventsTable.EVENT);
            EventsManager.removeEvent(ev);
        }
        eventsTable.getSelectionModel().clearSelection();
        /*
         * CurrentStorage.get().storeEventsManager(); eventsTable.refresh();
         * EventsScheduler.init(); parentPanel.calendar.jnCalendar.updateUI();
         * parentPanel.updateIndicators();
         */ saveEvents();
    }

    class PopupListener extends MouseAdapter {

        public void mouseClicked(MouseEvent e) {
            if ((e.getClickCount() == 2) && (eventsTable.getSelectedRow() > -1)) {
                editEventB_actionPerformed(null);
            }
        }

        public void mousePressed(MouseEvent e) {
            maybeShowPopup(e);
        }

        public void mouseReleased(MouseEvent e) {
            maybeShowPopup(e);
        }

        private void maybeShowPopup(MouseEvent e) {
            if (e.isPopupTrigger()) {
                eventPPMenu.show(e.getComponent(), e.getX(), e.getY());
            }
        }

    }

    void ppEditEvent_actionPerformed(ActionEvent e) {
        editEventB_actionPerformed(e);
    }

    void ppRemoveEvent_actionPerformed(ActionEvent e) {
        removeEventB_actionPerformed(e);
    }

    void ppNewEvent_actionPerformed(ActionEvent e) {
        newEventB_actionPerformed(e);
    }
}