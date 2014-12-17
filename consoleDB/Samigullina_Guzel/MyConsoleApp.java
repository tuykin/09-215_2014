package myapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSetMetaData;
import java.util.Properties;

public class MyApp{
   private static String url = "jdbc:mysql://localhost:3306/";// драйвер,  Локальная машина 3306-порт подключения,если порт не прописывается,то стандратный 80
    //private static String url = "jdbc:mysql:mynewdatabase";
    String dbName = "mynewdatabase";
    String driver = "com.mysql.jdbc.Driver";
    private static String userName = "root";
    private static String password = "root";
    private static String dbURL = "jdbc:mysql://localhost:3306/mynewdatabase?user=root&password=root";//user-ключ значение
    private static String tableName = "bakers";
    // jdbc Connection
    private static Connection conn = null;
    private static Statement stmt = null;

	public static void main(String[] args) {
		createConnection();
		selectTable();//выводит на экран студентов
		//shutdown();// закрытие
	}
	
	private static void createConnection()//работает
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            //Get a connection
            conn = DriverManager.getConnection(dbURL);
            System.out.println("Connection established");
        }
        catch (Exception except)
        {
            except.printStackTrace();
        }
    }
	
	private static void selectTable()
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

            System.out.println("\n---------------------------------------------------------");

            String format = "%-16s%-16s%n";
            while(results.next())
            {
                int id = results.getInt(1);
                String name = results.getString(2);
                
                System.out.printf(format, id, name);
//                System.out.println(id + "\t\t" + surname + "\t\t" + name + "\t\t" + group_id);
            }
            results.close();
            stmt.close();
        }
        catch (SQLException sqlExcept)
        {
            sqlExcept.printStackTrace();
        }
    }
	
 
	 
	
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
        {
            
        }

    }

}



