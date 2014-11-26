import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.Scanner;

public class GameDevProjectsConsole {
    String url = "jdbc:mysql://localhost:3306/";
    String dbName = "for apa";
    String driver = "com.mysql.jdbc.Driver"; // драйвер для подключения приложения к СУБД MySQL
    String userName = "root";
    String password = "1994";
    private static String dbURL = "jdbc:mysql://localhost:3306/for apa?user=root&password=1994";
    private static String tableName = "students";
    // jdbc Connection
    private static Connection conn = null; // переменная, которая хранит подключение к БД
    private static Statement stmt = null; // переменная для того, чтобы делать запросы к БД

    // подключение к конкретной БД
    // класс DriverManager содержит методы для подключения к БД
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

    // метод для вывода в консоль таблицы students
    private static void selectStudents() {
        try {
            stmt = conn.createStatement();
            ResultSet results = stmt.executeQuery("select * from " + tableName); // executeQuery - возвращает мнв строк
            ResultSetMetaData rsmd = results.getMetaData();
            int numberCols = rsmd.getColumnCount();
            for (int i = 1; i <= numberCols; i++) {
                // print Column Names
                System.out.print(rsmd.getColumnLabel(i) + "\t\t");
            }
            System.out.println("\n---------------------------------------------------------");
            String format = "%-16s%-16s%-16s%-16s%n";
            while (results.next()) {
                int id = results.getInt(1);
                String surname = results.getString(2);
                String name = results.getString(3);
                int group_id = results.getInt(4);
                System.out.printf(format, id, surname, name, group_id);
                // System.out.println(id + "\t\t" + surname + "\t\t" + name +
                // "\t\t" + group_id);
            }
            results.close();
            stmt.close();
        } catch (SQLException sqlExcept) {
            sqlExcept.printStackTrace();
        }
    }

    // добавить студента в таблицу students
    private static void insertStudents(int id, String surname, String name, int group_id) {
        try {
            stmt = conn.createStatement();
            stmt.execute("insert into students values(" + id + ",'" + surname + "','" + name + "'," + group_id + ")");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    // закрыть подключение
    private static void shutdown() {
        try {
            if (stmt != null) {
//                System.out.println("111");
                stmt.close();
//                System.out.println("222");
            }
            if (conn != null) {
//                System.out.println("333");
                DriverManager.getConnection(dbURL + ";shutdown=true");
//                System.out.println("444");
                conn.close();
//                System.out.println("555");
            }
//            System.out.println("Connection interrupted");
        } catch (SQLException sqlExcept) {
        }
    }

    private static ArrayList<String> getListOfTables() {
        ArrayList<String> list = new ArrayList<String>();
        try {
            DatabaseMetaData dbmd = conn.getMetaData(); // берём метаданные бд
            ResultSet rs = dbmd.getTables(null, null, null, null); // берём инфу о таблицах
            while (rs.next()) {
                String str = rs.getString("TABLE_NAME") + " ";
                list.add(str);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    // метод для вывода в консоль таблицы по номеру
    private static void selectTableData(String tableTitle) {
        try {
            stmt = conn.createStatement();
            ResultSet results = stmt.executeQuery("select * from " + tableTitle); // executeQuery - возвращает мнв строк
            ResultSetMetaData rsmd = results.getMetaData();
            int numberCols = rsmd.getColumnCount();
            for (int i = 1; i <= numberCols; i++) {
                // print Column Names
                System.out.print(rsmd.getColumnLabel(i) + "\t\t\t");
            }
            System.out.println("\n---------------------------------------------------------");
            while (results.next()) {
                for(int i=1; i<=numberCols; i++) {
                    String cVar = results.getString(i);
                    System.out.print(cVar + "\t\t\t");
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
        createConnection(); // создаем подключение
        ArrayList<String> listOfTables = getListOfTables();
        System.out.println(listOfTables);

        System.out.println("Введите номер таблицы, которую Вы хотите вывести: ");
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();

        selectTableData(listOfTables.get(number-1));


        shutdown(); // закрываем подключение
        sc.close();
    }
}
