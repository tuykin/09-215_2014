/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication4;

import java.awt.Dimension;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author Амир
 */
public class JavaApplication4 {

    JTable jTabStudents;
    private static ArrayList<Brand> brands;
    
    JavaApplication4()
    {
        brands=new ArrayList<>();
        start();
       JFrame myFrame=new JFrame("jkjkf");
       myFrame.setSize(new Dimension(500, 500));
		jTabStudents=new JTable(new MyTableModel(brands));
		
		myFrame.add(new JScrollPane(jTabStudents));
		myFrame.setVisible(true);
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    private static final String dbURL = "jdbc:mysql://localhost:3306/gai?user=root&password=1234";
    // jdbc Connection
    private static Connection conn = null;
    private static Statement stmt = null;
    public static void start() {
        createConnection();
        getData();
        shutdown();
    }

    private static void createConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            //Get a connection
            conn = DriverManager.getConnection(dbURL);
            System.out.println("Connection established");
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException ex) {
            Logger.getLogger(JavaApplication4.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void shutdown() {
        try {
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                DriverManager.getConnection(dbURL + ";shutdown=true");
                conn.close();
            }
        } catch (SQLException sqlExcept) {
        }
    }
    private static void getData()
    {
        
        try {
             stmt = conn.createStatement();
            ResultSet results;
            results = stmt.executeQuery("select * from brands");
            ResultSetMetaData rsmd = results.getMetaData();
            while (results.next()) {

                brands.add(new Brand(results.getInt(1),results.getString(2)));
            }
            results.close();
        } catch (SQLException ex) {
            Logger.getLogger(JavaApplication4.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void main(String[] args) {
        JavaApplication4 j=new JavaApplication4();
        
    }
    
}
