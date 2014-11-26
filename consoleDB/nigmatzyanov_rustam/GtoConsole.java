package myapp;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSetMetaData;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class GtoConsole {
	String url = "jdbc:mysql://localhost:3306/";
	String dbName = "gto";
	String driver = "com.mysql.jdbc.Driver"; // драйвер для подключения приложения к СУБД MySQL
	String userName = "root";
	String password = "root";
	private static String dbURL = "jdbc:mysql://localhost:3306/gto?user=root&password=root";
	// jdbc Connection
	private static Connection conn = null; // переменная, которая хранит подключение к БД
	private static Statement stmt = null; // переменная для того, чтобы делать запросы к БД
	
	// подключение к нашей БД
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
	
	// добавить студента в таблицу students
	private static void insertStudents(int id, String sname, String name, String birthday, String gender, 
			String faculty, String groupnum, int course, String badgetype) {
		try {
			stmt = conn.createStatement();
			stmt.execute("insert into students values(" + id + ",'" + sname + "','" + name + "','" + birthday +
				"','" + gender + "','" + faculty + "','" + groupnum + "'," + course + "," + badgetype + ")");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// закрыть подключение
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
	
	// метод для получения списка таблиц БД
	private static ArrayList<String> getListOfTables() {
		ArrayList<String> list = new ArrayList<>();
		try {
			DatabaseMetaData dbmd = conn.getMetaData(); // создаём объект dbmd, в котором будут хранится метаданные о БД
			ResultSet rs = dbmd.getTables(null, null, null, null); // получить инфу о таблицах в виде строк
			
			while (rs.next()) {
				String str = rs.getString(3); // получить третий атрибут строки (TABLE_NAME)
				list.add(str);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
			return list;
	}
	
	// метод для вывода в консоль таблицы по названию
	private static void selectTable(String tableName) {
		try {
			stmt = conn.createStatement();
			ResultSet results = stmt.executeQuery("select * from " + tableName); // executeQuery - возвращает мнв строк
			ResultSetMetaData rsmd = results.getMetaData(); // получить метаданные о строках
			int numberCols = rsmd.getColumnCount();
			for (int i = 1; i <= numberCols; i++) {
				// print Column Names
				System.out.print(rsmd.getColumnLabel(i) + "\t\t");
			}
			System.out.println("\n---------------------------------------------------------");
			while (results.next()) { // вывод строк по атрибутам
				for (int i = 1; i <= numberCols; i++) {
					String str = results.getString(i);
					System.out.print(str + "\t\t");
				}
				System.out.println();
			}
			results.close();
			stmt.close();
		} catch (SQLException sqlExcept) {
			sqlExcept.printStackTrace();
		}
	}

	public static void main(String[] args) throws ParseException {
		createConnection();
		//insertStudents(11, "Ivanov", "Ivan", "1995-04-12", "m", "ИТИС", "14303", 2, null); 
		//insertStudents(12, "Petrova", "Natalya", "1994-05-23", "f", "ИУТР", "4204", 3, null);
		
		System.out.println("Список доступных таблиц: ");
		ArrayList<String> list = getListOfTables();
		System.out.println(list);
		
		System.out.println("Введите номер таблицы, которую Вы хотите вывести: ");
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
	
		selectTable(list.get(number - 1)); // вывести указанную таблицу
		
		shutdown();
		sc.close();
	}
}
