package air;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

	public class connection 
	{
		String url = "jdbc:mysql://localhost:3306/";
	    String dbName = "airport";
	    String driver = "com.mysql.jdbc.Driver";
	    String userName = "root";
	    String password = "";
		private static String dbURL = "jdbc:mysql://localhost:3306/airport?user=root&password=root";
	    private static String tableName = "Orders";
	    // jdbc Connection
	    private static Connection conn = null;
	    private static Statement stmt = null;
	    private static DatabaseMetaData dbmd = null;
	    private static void createConnection()
	    {
	        try
	        {
	            Class.forName("com.mysql.jdbc.Driver").newInstance();
	            //Get a connection
	            conn = DriverManager.getConnection(dbURL); 
	            System.out.println("Connection established:");
	            dbmd = (DatabaseMetaData) conn.getMetaData();
	        }
	        catch (Exception except)
	        {
	            except.printStackTrace();
	        }
	    }

		private static void selectTable(String tableName)
	    {
	        try
	        {
	            stmt = conn.createStatement();
	            ResultSet results = stmt.executeQuery("select * from " + tableName);
	            ResultSetMetaData rsmd = results.getMetaData();
	            int numberCols = rsmd.getColumnCount();
	            for (int i=1; i<=numberCols; i++)
	            {	 
	                System.out.print(rsmd.getColumnLabel(i)+"\t\t");  
	            }	            
	            System.out.println("\n-------------------------------------------------");	            	            
	            while(results.next())
	            {
	                for (int i=1; i<=numberCols; i++) 
	                {
	                    String str = results.getString(i).split("%", 10)[0];
	                    System.out.print(str + "\t\t");
	                }
	                System.out.println();
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
	        } catch (SQLException sqlExcept) {
	        }
	    }

		public static void main(String[] args)
	    {	      
	        createConnection();
	        try
	        {
	            stmt = conn.createStatement();	                      
	            String[] types = {"TABLE"};
	            ResultSet rs = dbmd.getTables(null, null, "%", types);
	            int i = 1;
	            List<String> tables = new ArrayList<String>();	            
	            while (rs.next()) 
	            {
	                String table_name = rs.getString("TABLE_NAME");
	                tables.add(table_name);
	                System.out.println(i++ + ". " + table_name);
	            }	            
	            Scanner sc = new Scanner(System.in);
	            int num = sc.nextInt();
	            System.out.println(tables.get(num-1));
	            
	            selectTable(tables.get(num-1));	          
	        }
	        catch (SQLException sqlExcept)
	        {	           
	        } 	    
	        shutdown();
	    }		
}

 

	   

	   

	  
	