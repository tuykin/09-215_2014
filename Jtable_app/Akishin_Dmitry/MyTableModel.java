/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelapplication;

import java.io.UnsupportedEncodingException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author sony
 */
public class MyTableModel extends AbstractTableModel {
    
    private ResultSet data = null;
    private ResultSetMetaData dmd = null;
    
    MyTableModel(ResultSet data) {
        this.data = data;
        try {
            this.dmd = data.getMetaData();
        } catch (SQLException ex) {
            Logger.getLogger(MyTableModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public int getRowCount() {
        int rowCount = 1;
        try {
            while (!data.isLast()) {
                data.next();
                rowCount++;
            }
            data.first();
            return rowCount;
        } catch (SQLException ex) {
            Logger.getLogger(MyTableModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rowCount;
    }
    
    @Override
    public int getColumnCount() {
        try {
            return dmd.getColumnCount();
        } catch (SQLException ex) {
            Logger.getLogger(MyTableModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        String value = "";
        try {
            for (int i = 1; i < rowIndex; i++) {
                data.next();
            }
            byte[] bytes = data.getBytes(columnIndex + 1);
            if (bytes != null) {
                value = new String(bytes, "Cp866");
            }
            data.first();
        } catch (SQLException | UnsupportedEncodingException ex) {
            Logger.getLogger(MyTableModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return value;
    }
    
    @Override
    public String getColumnName(int columnIndex) {
        try {
            return dmd.getColumnName(columnIndex + 1);
        } catch (SQLException ex) {
            Logger.getLogger(MyTableModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }
    
}
