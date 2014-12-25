/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelapplication;

import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 *
 * @author sony
 */
public class HotelForm extends JFrame {

    public static Statement stmt = null;

    HotelForm() throws IOException {
        super("Гостиница");
        setMinimumSize(new Dimension(500, 400));

        createConnection();
        
        add(new TablesPanel());

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing() {
                shutdown();
                System.exit(0);
            }
        });
        setVisible(true);
    }

    private final String dbURL = "jdbc:mysql://localhost:3306/db_hotel?user=root";
    // jdbc Connection
    private Connection conn = null;

    private void createConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            //Get a connection
            conn = DriverManager.getConnection(dbURL);
            stmt = conn.createStatement();
            System.out.println("Connection established");
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ConsolePrint.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void shutdown() {
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

}
