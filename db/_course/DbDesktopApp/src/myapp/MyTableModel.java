package myapp;

import javax.swing.table.AbstractTableModel;

public class MyTableModel extends AbstractTableModel{
    @Override
    public int getRowCount() {
        return 10;
    }
    @Override
    public int getColumnCount() {
        return 10;
    }
    @Override
    public Object getValueAt(int r, int c) {
        return r * c;
    }
    @Override
    public String getColumnName(int c) {
        switch (c) {
            case 0:
                return "Column 1";
            case 1:
                return "Column 2";
            case 2:
                return "Column 3";
            default:
                return "Other Column";
        }
    }
}