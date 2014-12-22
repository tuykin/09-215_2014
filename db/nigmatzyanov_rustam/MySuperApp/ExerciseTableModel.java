package myapp;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.table.AbstractTableModel;

public class ExerciseTableModel extends AbstractTableModel {
	
	ResultSet results = null;
	ResultSetMetaData rsmd = null;
	
	ExerciseTableModel(ResultSet data) throws SQLException {
		this.results = data;
		this.rsmd = data.getMetaData();
	}
	
	@Override
	public int getRowCount() {
		int rowCount = 0;
		try {
			if (results.first()) { // если есть хотя бы 1 строка
				rowCount = 1;
				while (results.next()) 
					rowCount++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rowCount;
	}

	@Override
	public int getColumnCount() {
		try {
			return rsmd.getColumnCount();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		try {
			results.first();
            for (int i = 0; i < rowIndex; i++) {
                results.next();
            }
			switch (results.getString(columnIndex + 1)) { // изменяем названия упражнений в 1 столбце
			case "malerun": return "Бег на 100 м (сек.)";
			case "run3": return "Бег на 3 км (мин., сек.)";
			case "malejump": return "Прыжок в длину с места (см)";
			case "pull-ups": return "Подтягивания (кол-во раз)";
			case "maleflex": return "Наклон вперёд из положения стоя (см)";
			case "femalerun": return "Бег на 100 м (сек.)";
			case "run2": return "Бег на 2 км (мин., сек.)";
			case "femalejump": return "Прыжок в длину с места (см)";
			case "push-ups": return "Отжимания от пола (кол-во раз)";
			case "femaleflex": return "Наклон вперёд из положения стоя (см)";
			}
			return results.getString(columnIndex + 1);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	@Override
	public String getColumnName(int columnIndex) {
		switch (columnIndex) {
		case 0:
			return "Виды испытаний";
		case 1:
			return "Бронзовый знак";
		case 2:
			return "Серебряный знак";
		case 3:
			return "Золотой знак";
		default:
			return "";
		}
	}
}
