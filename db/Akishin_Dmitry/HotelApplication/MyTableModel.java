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
import java.sql.Types;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author sony
 */
public class MyTableModel extends AbstractTableModel {

    private ArrayList<String[]> data;
    private String[] colNames;
    private int rowCount;
    private int colCount;

    //список номеров столбцов типа дата;
    //нужно для вывода дат в другом формате
    private ArrayList<Integer> dateTypeCols;

    MyTableModel(ResultSet res) {
        try {
            ResultSetMetaData rsmd = res.getMetaData();
            colCount = rsmd.getColumnCount();
            colNames = new String[colCount];
            data = new ArrayList<>();
            dateTypeCols = new ArrayList<>();
            for (int i = 0; i < colCount; i++) {
                colNames[i] = rsmd.getColumnName(i + 1);
                if (rsmd.getColumnType(i + 1) == Types.DATE) {
                    dateTypeCols.add(i);
                }
            }

            rowCount = 0;
            while (res.next()) {
                String[] row = new String[colCount];
                for (int i = 0; i < colCount; i++) {
                    if (dateTypeCols.contains(i)) {
                        row[i] = MyDateFormatter.format(res.getDate(i + 1));
                    } else {
                        row[i] = res.getString(i + 1);
                    }
                }
                data.add(row);
                rowCount++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(MyTableModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //второй конструктор с пользовательскими названиями столбцов
    MyTableModel(ResultSet res, String[] colNames) {
        try {
            colCount = colNames.length;
            this.colNames = colNames;
            data = new ArrayList<>();
            ResultSetMetaData rsmd = res.getMetaData();
            dateTypeCols = new ArrayList<>();
            for (int i = 0; i < colCount; i++) {
                if (rsmd.getColumnType(i + 1) == Types.DATE) {
                    dateTypeCols.add(i);
                }
            }
            rowCount = 0;
            while (res.next()) {
                String[] row = new String[colCount];
                for (int i = 0; i < colCount; i++) {
                    if (dateTypeCols.contains(i)) {
                        row[i] = MyDateFormatter.format(res.getDate(i + 1));
                    } else {
                        row[i] = res.getString(i + 1);
                    }
                }
                data.add(row);
                rowCount++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(MyTableModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public int getRowCount() {
        return rowCount;
    }

    @Override
    public int getColumnCount() {
        return colCount;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return data.get(rowIndex)[columnIndex];
    }

    @Override
    public String getColumnName(int columnIndex) {
        return colNames[columnIndex];
    }

}
