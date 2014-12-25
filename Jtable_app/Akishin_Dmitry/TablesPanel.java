/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelapplication;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author sony
 */
public class TablesPanel extends JPanel {

    private JTable table = new JTable();

    private Statement stmt = null;

    TablesPanel() {
        this.stmt = HotelForm.stmt;

        setLayout(new BorderLayout());

        Box verticalPanel = new Box(BoxLayout.Y_AXIS);
        verticalPanel.add(Box.createVerticalStrut(30));
        verticalPanel.add(createComboBox());
        verticalPanel.add(Box.createVerticalStrut(30));
        verticalPanel.add(new JScrollPane(table));
        verticalPanel.add(Box.createVerticalStrut(30));
        Box horizontalPanel = new Box(BoxLayout.X_AXIS);
        horizontalPanel.add(Box.createHorizontalStrut(30));
        horizontalPanel.add(verticalPanel);
        horizontalPanel.add(Box.createHorizontalStrut(30));

        add(horizontalPanel, BorderLayout.CENTER);
    }

    private JComboBox createComboBox() {
        Vector<String> data = new Vector<>();
        try {
            ResultSet results;
            results = stmt.executeQuery("SELECT TABLE_NAME FROM INFORMATION_SCHEMA.TABLES"
                    + " where TABLE_SCHEMA='db_hotel';");
            while (results.next()) {
                String tableName = results.getString(1);
                data.add(tableName);
            }
            results.close();

        } catch (SQLException ex) {
            Logger.getLogger(TablesPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        JComboBox comboBox = new JComboBox(data);
        comboBox.setSelectedItem(null);
        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateJTable((String) comboBox.getSelectedItem());
            }
        });
        return comboBox;
    }

    private void updateJTable(String tableName) {
        try {
            ResultSet results;
            results = stmt.executeQuery("select * from " + tableName);
            table.setModel(new MyTableModel(results));
        } catch (SQLException ex) {
            Logger.getLogger(TablesPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
