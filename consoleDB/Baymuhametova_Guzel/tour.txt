package myapp;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSetMetaData;
import java.sql.Date;
import java.sql.DatabaseMetaData;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

///////////////////////////////////////////////////////////////////////////////////////////
public class tour{
	String url = "jdbc:mysql://localhost:3306/";// драйвер, 3306-порт подключения
    String dbName = "Tour";
    String driver = "com.mysql.jdbc.Driver";
    String userName = "root";
    String password = "";
	private static String dbURL = "jdbc:mysql://localhost:3306/tour?user=root&password=root";//user-ключ значение
    private static String tableName = "reservation";
    // jdbc Connection
    private static Connection conn = null;
    private static Statement stmt = null;
  
   
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	private static void createConnection()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            //Get a connection
            conn = DriverManager.getConnection(dbURL); // подключение с БД
            System.out.println("Connection established");
        }
        catch (Exception except)
        {
            except.printStackTrace();
        }
    }
////// метод для вывода в консоль таблицы Reservation/////////////////////////////////////////////////////////////////
		private static void selectReservation()
    {
        try
        {
            stmt = conn.createStatement();//Выражение с sql запросами 
            ResultSet results = stmt.executeQuery("select * from " + tableName);
            ResultSetMetaData rsmd = results.getMetaData();
            int numberCols = rsmd.getColumnCount();
            for (int i=1; i<=numberCols; i++)
            {
                //print Column Names
                System.out.print(rsmd.getColumnLabel(i)+"\t\t");  
            }

            String format = "%-16s%-16s%-16s%-16s%-16s%-16s%-16s%n";
            while(results.next())
            {
            	String str = "";
            	for (int i = 1; i <= numberCols; i++) {
            	str += results.getString(i) + " ";  }
            	System.out.println(str);
                int id = results.getInt(1);
                Date dat = results.getDate(2);
                int K_days = results.getInt(3);
                int K_child = results.getInt(4);
                int K_grown = results.getInt(5);
                int CustomerId = results.getInt(6);
                int TouristsId = results.getInt(7);
                
                
           System.out.printf(format, id, dat,K_days,K_child, K_grown,CustomerId,TouristsId );
              
            }
            results.close();
            stmt.close();
        }
        catch (SQLException sqlExcept)
        {
            sqlExcept.printStackTrace();
        }
    }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	private static void insertReservation( int id, Date dat, int K_days,int K_child, int K_grown,int CustomerId, int TouristsId, int HotelId)
	{
        try {
            stmt = conn.createStatement();
            stmt.execute("insert Reservation(" + id + ",'" + dat+ "','" +  K_days + "'," + K_child + "','" + CustomerId + "','" + TouristsId+ "','" + HotelId+")");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
	
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	private static void shutdown()
    {
        try
        {
            if (stmt != null)
            {
                stmt.close();
            }
            if (conn != null)
            {
                DriverManager.getConnection(dbURL + ";shutdown=true");
                conn.close();
            }           
        }
        catch (SQLException sqlExcept)
        {                            } 
      }

 // метод для получения списка таблиц БД
 	private static ArrayList<String> getListOfTables() {
 		ArrayList<String> list = new ArrayList<>();
 		try {
 			DatabaseMetaData dbmd =conn.getMetaData(); //  хранение метаданных о БД
 			ResultSet rs = dbmd.getTables(null, null, null, null); // получить инфу о таблицах в виде строк
 			
 			while (rs.next()) {
 				String str = rs.getString(1); 
 				list.add(str);
 			}
 			
 		} catch (SQLException e) {
 			e.printStackTrace();
 		}
 			return list;
 	}
 	
 	// метод для вывода в консоль таблицы по названию
 	private static void selectTable() {
 		try {
 			stmt = conn.createStatement();
 			ResultSet results = stmt.executeQuery("select * from " + tableName); 
 			ResultSetMetaData rsmd = results.getMetaData(); // получить метаданные о строках
 			int numberCols = rsmd.getColumnCount();
 			for (int i = 1; i <= numberCols; i++) {
 				// print Column Names
 				System.out.print(rsmd.getColumnLabel(i) + "\t\t");
 			}
 			System.out.println("\n---------------------------------------------------------");
 			while (results.next()) { 
 				for (int i = 1; i <= numberCols; i++) {
 					String str = results.getString(i);
 					System.out.print(str + "\t\t\t");
 				}
 				System.out.println();
 			}
 			results.close();
 			stmt.close();
 		} catch (SQLException sqlExcept) {
 			sqlExcept.printStackTrace();
 		}
 	}
   public static void main(String[] args) {
		
		SimpleDateFormat f = new SimpleDateFormat("dd.MM.yyyy hh:mm");
		createConnection();
 		//insertReservation(11, new Date(01,12,2014),1,1,1,1,1); 
 		
 		ArrayList<String> list = getListOfTables();
 		System.out.println(list);
 		
 		Scanner scan = new Scanner(System.in);
 		int number = scan.nextInt();
  		selectTable(); 
  		shutdown();
 		
		
	}

 	
 }







