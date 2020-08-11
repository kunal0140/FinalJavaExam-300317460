/*
 * Created by JFormDesigner on Tue Aug 11 11:51:17 PDT 2020
 */

package com.company;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Scanner;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.DefaultTableModel;

import net.miginfocom.swing.*;

/**
 * @author Kunal Sharma
 */
public class Jform extends JFrame {
    static String OldName;
    static DefaultTableModel model ;
    public Jform() {
        initComponents();
//        comboBox1 = new JComboBox<String>(new String[]{"Business", "Personal"});
    }

    private void Add(MouseEvent e) throws ClassNotFoundException, SQLException {
        PreparedStatement query;
        Class. forName("com.mysql.jdbc.Driver");

        Connection con1  = DriverManager.getConnection("jdbc:mysql://localhost/loan","root","");

        String clientno,clientname;
        Double loanamount;
        int years;
        String loantype;

        clientno = textField1.getText();
        clientname  = textField2.getText();
        loanamount = Double.valueOf(textField3.getText());
        years = Integer.parseInt(textField4.getText());
        loantype = String.valueOf(comboBox1.getSelectedItem());

        query = con1.prepareStatement("insert into loantable values(?,?,?,?,?)");
        query.setString(1,clientno);
        query.setString(2,clientname);
        query.setDouble(3,Double.valueOf(loanamount));
        query.setString(4, String.valueOf(years));
        query.setString(5, loantype);
        query.executeUpdate();
        model.setRowCount(0);
        display();
    }

    public void display() throws ClassNotFoundException, SQLException {

        PreparedStatement query;
        Class. forName("com.mysql.jdbc.Driver");
        model = new DefaultTableModel();
        model.addColumn("clientno");
        model.addColumn("clientname ");
        model.addColumn("loanamount");
        model.addColumn("years");
        model.addColumn("loantype");




        Connection con1  = DriverManager.getConnection("jdbc:mysql://localhost/loan","root","");

        Scanner ab = new Scanner(System.in);
        String clientno,clientname;
        Double loanamount;
        int years;
        query  = con1.prepareStatement("Select * from loantable");
        ResultSet rs ;
        rs =query.executeQuery();
        while(rs.next()){
            model.addRow(new Object[]{rs.getString("clientno"),rs.getString("clientname"),rs.getString("loanamount"),
                    rs.getString("years"),rs.getString(comboBox1.getSelectedIndex())});

        }
        table1.setModel(model);
    }

    private void edit(MouseEvent e) throws ClassNotFoundException, SQLException {
        PreparedStatement query;
        Class. forName("com.mysql.jdbc.Driver");

        Connection con1  = DriverManager.getConnection("jdbc:mysql://localhost/loan","root","");

        String clientno,clientname;
        Double loanamount;
        int years;
        String loantype ;

        clientno = textField1.getText();
        clientname  = textField2.getText();
        loanamount = Double.valueOf(textField3.getText());
        years = Integer.parseInt(textField4.getText());
        loantype = String.valueOf(comboBox1.getSelectedObjects());

        query = con1.prepareStatement("update loantable set clientname = ?, " +
                "loanamount = ?, years = ?, loantype = ? where clientno = ?");
        query.setString(1, clientname);
        query.setDouble(2, Double.valueOf(loanamount));
        query.setString(3, String.valueOf(years));
        query.setString(4, loantype);
        query.setString(5, clientno);
        query.executeUpdate();
        model.setRowCount(0);
        display();
    }

    private void delete(MouseEvent e) throws ClassNotFoundException, SQLException {
        PreparedStatement query;
        Class. forName("com.mysql.jdbc.Driver");

        Connection con1  = DriverManager.getConnection("jdbc:mysql://localhost/loan","root","");

        String clientno, clientname;
        Double loanamount;
        int years;
        String loantype ;

        clientno = textField1.getText();

        query = con1.prepareStatement("delete from loantable where clientno = ?");
        query.setString(1, clientno);
        query.executeUpdate();
        model.setRowCount(0);
        display();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Manmohan Singh
        label1 = new JLabel();
        textField1 = new JTextField();
        label2 = new JLabel();
        textField2 = new JTextField();
        label3 = new JLabel();
        textField3 = new JTextField();
        label4 = new JLabel();
        textField4 = new JTextField();
        label5 = new JLabel();
        comboBox1 = new JComboBox(new String[] {"Business", "Personal"});
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
                try {
                    Add(e);
                } catch (ClassNotFoundException classNotFoundException) {
                    classNotFoundException.printStackTrace();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });
        contentPane.add(button1, "cell 0 7 4 1");

        //---- button2 ----
        button2.setText("Edit");
        button2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    edit(e);
                } catch (ClassNotFoundException classNotFoundException) {
                    classNotFoundException.printStackTrace();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });
        contentPane.add(button2, "cell 4 7");

        //---- button3 ----
        button3.setText("Delete");
        button3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    delete(e);
                } catch (ClassNotFoundException classNotFoundException) {
                    classNotFoundException.printStackTrace();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
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
    // Generated using JFormDesigner Evaluation license - Manmohan Singh
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
