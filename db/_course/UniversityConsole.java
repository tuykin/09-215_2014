package myapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSetMetaData;

public class UniversityConsole {
	String url = "jdbc:mysql://localhost:3306/";
    String dbName = "university";
    String driver = "com.mysql.jdbc.Driver";
    String userName = "root";
    String password = "";
	private static String dbURL = "jdbc:mysql://localhost:3306/university?user=root";
    private static String tableName = "students";
    // jdbc Connection
    private static Connection conn = null;
    private static Statement stmt = null;

	public static void main(String[] args) {
		createConnection();
		selectStudents();
		shutdown();
	}

	private static void createConnection()
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

	private static void selectStudents()
    {
        try
        {
            stmt = conn.createStatement();
            ResultSet results = stmt.executeQuery("select * from " + tableName);
            ResultSetMetaData rsmd = results.getMetaData();
            int numberCols = rsmd.getColumnCount();
            for (int i=1; i<=numberCols; i++)
            {
                //print Column Names
                System.out.print(rsmd.getColumnLabel(i)+"\t\t");
            }

            System.out.println("\n---------------------------------------------------------");

            String format = "%-16s%-16s%-16s%-16s%n";
            while(results.next())
            {
                int id = results.getInt(1);
                String surname = results.getString(2);
                String name = results.getString(3);
                int group_id = results.getInt(4);

                System.out.printf(format, id, surname, name, group_id);
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

    private static void insertStudents(int id, String surname, String name, int group_id)
    {
        try
        {
            stmt = conn.createStatement();
            stmt.execute("insert into " + tableName +
                    "(id, surname, name, group_id)" + " values (" +
                    "'" + id + "', '" + surname + "', '" + name + "', '" + group_id + "')");
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
