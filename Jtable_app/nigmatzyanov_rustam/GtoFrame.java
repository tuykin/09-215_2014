import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import javax.swing.*;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class GtoFrame extends JFrame {
	private static String dbURL = "jdbc:mysql://localhost:3306/gto?user=root&password=root";
	private static Connection conn = null; // переменная, которая хранит подключение к БД
	private static Statement stmt = null; // переменная для того, чтобы делать запросы к БД
	
	GtoFrame(String s) throws SQLException {
		super(s);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		createConnection();
		ArrayList<String> tableNames = getListOfTables(); // список таблиц БД
		stmt = conn.createStatement();
		final ResultSet results = stmt.executeQuery("select * from " + tableNames.get(2));
        
		// создаём таблицу, исп-я нашу модель
        JTable gtotable = new JTable (new MyTableModel(results));
        add(new JScrollPane(gtotable));
        
        
		setSize(650, 540);
		setVisible(true);    
		setLocationRelativeTo(null);
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent ev){
				try {
					results.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				shutdown();
				System.exit(0);
			}
		});
	}
	
	private static void createConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			// Get a connection
			conn = DriverManager.getConnection(dbURL);
			System.out.println("Connection established");
		} catch (Exception except) {
			except.printStackTrace();
		}
	}
	
	private static void shutdown() {
		try {
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}
			System.out.println("Connection interrupted");
		} catch (SQLException sqlExcept) {
		}
	}
	
	private static ArrayList<String> getListOfTables() {
		ArrayList<String> list = new ArrayList<>();
		try {
			DatabaseMetaData dbmd = conn.getMetaData(); // создаём объект dbmd, в котором будут хранится метаданные о БД
			ResultSet rs = dbmd.getTables(null, null, null, null); // получить инфу о таблицах в виде строк
			
			while (rs.next()) {
				String str = rs.getString(3); // получить третий атрибут строки (TABLE_NAME)
				list.add(str);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
			return list;
	}

	public static void main(String[] args) throws ParseException, SQLException {
		new GtoFrame("Таблицы ГТО");
	}
}