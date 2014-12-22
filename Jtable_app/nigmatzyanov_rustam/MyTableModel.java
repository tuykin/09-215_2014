import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.table.AbstractTableModel;

public class MyTableModel extends AbstractTableModel {
	
	ResultSet results = null;
	ResultSetMetaData rsmd = null;
	
	MyTableModel(ResultSet data) throws SQLException {
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
			return results.getObject(columnIndex + 1);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	@Override
	public String getColumnName(int columnIndex) {
		try {
			return rsmd.getColumnLabel(columnIndex + 1);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return "";
	}
}
