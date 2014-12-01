package myapp;

import javax.swing.table.AbstractTableModel;

public class DBTableModel extends AbstractTableModel{
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
}