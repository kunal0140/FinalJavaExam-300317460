/*
 * Created by JFormDesigner on Tue Aug 11 11:51:17 PDT 2020
 */

package com.company;

import java.awt.event.*;
import java.sql.*;
import java.util.Scanner;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import net.miginfocom.swing.*;

/**
 * @author Kunal Sharma
 */
public class Jform extends JFrame {
    static String OldName;
    static DefaultTableModel model ;
    public Jform() {
        comboBox1 = new JComboBox<String>(new String[]{"Business", "Personal"});
        initComponents();
    }

    private void Add(MouseEvent e) {

    }
    public void display() throws ClassNotFoundException, SQLException {

        PreparedStatement query;
        Class. forName("com.mysql.jdbc.Driver");
        model = new DefaultTableModel();
        model.addColumn("Name");
        model.addColumn("Grade ");
        model.addColumn("Department");


        Connection con1  = DriverManager.getConnection("jdbc:mysql://localhost/student","root","");

        Scanner ab = new Scanner(System.in);
        String Name,Grade,Department;
        query  = con1.prepareStatement("Select * from studentinfo");
        ResultSet rs ;
        rs =query.executeQuery();
        while(rs.next()){
            model.addRow(new Object[]{rs.getString("Name"),rs.getString("Grade"),rs.getString("Department")});

        }
        table1.setModel(model);
    }

    private void edit(MouseEvent e) {
        // TODO add your code here
    }

    private void delete(MouseEvent e) {
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Kunal Sharma
        label1 = new JLabel();
        textField1 = new JTextField();
        label2 = new JLabel();
        textField2 = new JTextField();
        label3 = new JLabel();
        textField3 = new JTextField();
        label4 = new JLabel();
        textField4 = new JTextField();
        label5 = new JLabel();
        comboBox1 = new JComboBox();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        scrollPane2 = new JScrollPane();
        table2 = new JTable();
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        label6 = new JLabel();
        textField5 = new JTextField();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(new MigLayout(
            "hidemode 3",
            // columns
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]",
            // rows
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]"));

        //---- label1 ----
        label1.setText("Enter the client number: ");
        contentPane.add(label1, "cell 0 1 6 1");
        contentPane.add(textField1, "cell 7 1 9 1");

        //---- label2 ----
        label2.setText("Enter the client name:");
        contentPane.add(label2, "cell 0 2 6 1");
        contentPane.add(textField2, "cell 7 2 9 1");

        //---- label3 ----
        label3.setText("Enter the customer loan amount:");
        contentPane.add(label3, "cell 0 3 8 1");
        contentPane.add(textField3, "cell 7 3 10 1");

        //---- label4 ----
        label4.setText("Enter the number of years to pay:");
        contentPane.add(label4, "cell 0 4 8 1");
        contentPane.add(textField4, "cell 7 4 9 1");

        //---- label5 ----
        label5.setText("Enter the loan type:");
        contentPane.add(label5, "cell 0 5 8 1");
        contentPane.add(comboBox1, "cell 8 5 10 1");

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(table1);
        }
        contentPane.add(scrollPane1, "cell 0 6 7 1");

        //======== scrollPane2 ========
        {
            scrollPane2.setViewportView(table2);
        }
        contentPane.add(scrollPane2, "cell 8 6 8 1");

        //---- button1 ----
        button1.setText("Add");
        button1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Add(e);
            }
        });
        contentPane.add(button1, "cell 0 7 4 1");

        //---- button2 ----
        button2.setText("Edit");
        button2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                edit(e);
            }
        });
        contentPane.add(button2, "cell 4 7");

        //---- button3 ----
        button3.setText("Delete");
        button3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                delete(e);
            }
        });
        contentPane.add(button3, "cell 6 7");

        //---- label6 ----
        label6.setText("Monthly Payment");
        contentPane.add(label6, "cell 8 7");
        contentPane.add(textField5, "cell 10 7 6 1");
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Kunal Sharma
    private JLabel label1;
    private JTextField textField1;
    private JLabel label2;
    private JTextField textField2;
    private JLabel label3;
    private JTextField textField3;
    private JLabel label4;
    private JTextField textField4;
    private JLabel label5;
    private JComboBox comboBox1;
    private JScrollPane scrollPane1;
    private JTable table1;
    private JScrollPane scrollPane2;
    private JTable table2;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JLabel label6;
    private JTextField textField5;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
