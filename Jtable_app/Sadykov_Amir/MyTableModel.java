/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication4;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;


    public class MyTableModel extends AbstractTableModel {

        ArrayList<Brand> brands=new ArrayList<>();
        MyTableModel(ArrayList<Brand> brands)
        {
            super();
            this.brands=brands;
        }
    
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return brands.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		
                return Brand.count;
	}

	@Override
	public Object getValueAt(int r, int c) {
		// TODO Auto-generated method stub
		switch(c){
                    case 0:
                        return brands.get(r).getId();
                    case 1:
                        return brands.get(r).getBrand();
                    default:
                        return "sm";
                }
	}
    
}
