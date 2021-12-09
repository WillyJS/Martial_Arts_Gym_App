/**
 * File: DisplayUsers.java 
 * @Author: Jesus Quiroz (jaquiro1)
 * Date: 11/29/2020
 * 
 *  Description: holds class to display all users in the database. 
 */


package main.java.memoranda.ui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import main.java.memoranda.GymRegistry;
import main.java.memoranda.GymUser;

/**
 * Class: DisplayUsers.
 * Description: Displays a table containing all database users. 
 */
public class DisplayUsers extends JFrame {
    
    //Container reference 
    Container container = getContentPane();
    
    //Table to hold users data 
    JTable table;
    
    //Model to user table 
    DefaultTableModel myModel;
    
    //Holds the selected user to update
    GymUser editUser;
    
    //Instructions for user to interact with table
    JLabel instructions;
    
    /**
     * Constructs an interactive table from a copy of the registry. 
     * @param r GymRegistry copy
     */
    public DisplayUsers(GymRegistry r) {

        //Frame configuration 
        setTitle("Dojo Manager Users");
        setBounds(10, 10,700, 600);
        setResizable(true);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        instructions = new JLabel("Double Click on User to Edit");
        instructions.setHorizontalAlignment(SwingConstants.CENTER);
        instructions.setFont(new Font("Tahoma", Font.BOLD, 18));
        
        //Create non editable table  
        table = new JTable() {
            public boolean isCellEditable(int rowIndex,int colIndex) {
                return false;
            }
        };
        
        //Set column names for the table 
        String[] columnNames = {"Full Name","Username","Account Type","Belt Rank"};
        
        //Data is the size of the registry by 4 columns 
        String[][] data = new String[r.registrySize()][4];
        
        //Sort registry in alphabetical order by full name
        r.sortRegistry();
        
        //Fill in the data array 
        for (int i = 0; i < r.registrySize(); i++) {    
            data[i][0] = r.getUSer(i).getFullName();
            data[i][1] = r.getUSer(i).getUserName();
            data[i][2] = r.getUSer(i).getUserType();
            data[i][3] = r.getUSer(i).getBeltRank();
        }

        //Set table model and atributes 
        myModel = new DefaultTableModel(data,columnNames);
        table.setModel(myModel);
        table.getTableHeader().setReorderingAllowed(false);
        table.setFont(new Font("Tahoma", Font.PLAIN, 12));
        table.setFocusable(true);
        table.setRowSelectionAllowed(true);
        table.setFillsViewportHeight(false);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        //Create the scroll pane and add the table to it.
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        //Add the scroll pane
        getContentPane().add(scrollPane);
        getContentPane().add(instructions, BorderLayout.SOUTH);

        //Add mouse listener to the table 
        table.addMouseListener(new MouseAdapter() {
            
            public void mouseClicked(MouseEvent e) {
                //Get row number for user selection 
                int row = table.rowAtPoint(e.getPoint());
                //Select user to update
                if (e.getClickCount() == 2) {
                    String selectedUser = data[row][1];
                    editUser = r.getUser(selectedUser);
                    EditUser edit = new EditUser(r,editUser);
                    dispose();
                }
            }
        });

    }

}
