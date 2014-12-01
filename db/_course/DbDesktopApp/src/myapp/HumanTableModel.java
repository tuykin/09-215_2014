package myapp;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class HumanTableModel extends AbstractTableModel{
	ArrayList<Human> humans;
	
	HumanTableModel(ArrayList<Human> humans) {
		super();
		this.humans = humans;
	}
	
	@Override
    public int getRowCount() {
        return humans.size();
    }
	
    @Override
    public int getColumnCount() {
        return 3;
    }
    
    @Override
    public Object getValueAt(int r, int c) {
    	switch (c) {
        case 0:
            return humans.get(r).getName();
        case 1:
            return humans.get(r).getSurname();
        case 2:
            return humans.get(r).getTelephone();
        default:
            return "";
    	}
    }
    
    @Override
    public String getColumnName(int c) {
    	String result = "";
        switch (c) {
            case 0:
                result = "Name";
                break;
            case 1:
                result = "Surname";
                break;
            case 2:
                result = "Telephone";
                break;
        }
        return result;
    }
}
