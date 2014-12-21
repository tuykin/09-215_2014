package myDB.GameDevHelperApp;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.*;
import java.util.ArrayList;

public class ConnectionAppWithDB {
//    String url = "jdbc:mysql://localhost:3306/";
//    String dbName = "for apa";
//    String driver = "com.mysql.jdbc.Driver"; // драйвер для подключения приложения к СУБД MySQL
//    String userName = "root";
//    String password = "1994";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/for apa?user=root&password=1994";
    // jdbc Connection
    private static Connection conn = null; // переменная, которая хранит подключение к БД
    private static Statement stmt = null; // переменная для того, чтобы делать запросы к БД

    // подключение к конкретной БД
    // класс DriverManager содержит методы для подключения к БД
    public static void createConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            // Get a connection
            conn = DriverManager.getConnection(DB_URL);
//            System.out.println("Connection established");
        } catch (Exception except) {
            except.printStackTrace();
        }
    }

    // закрыть подключение
    public static void shutdown() {
        try {
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
//            System.out.println("Connection interrupted");
        } catch (SQLException sqlExcept) {
            System.out.println(sqlExcept.fillInStackTrace());
        }
    }

    // получить список названий таблиц из бд
    public static ArrayList<String> getListOfTables() {
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

    public static void main(String[] args) {
        try {
            createConnection();
            ArrayList<String> tableNames = getListOfTables();
            stmt = conn.createStatement();
            final ResultSet results = stmt.executeQuery("select * from " + tableNames.get(1)); // executeQuery - возвращает мнв строк
            final ResultSetMetaData rsmd = results.getMetaData();
            final int numberCols = rsmd.getColumnCount();
            JFrame mainFrame = new JFrame(" Team finder");
            mainFrame.setVisible(true);
            mainFrame.setSize(800, 400);
            mainFrame.setLocation(100, 100);
            mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            mainFrame.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    try {
                        results.close();
                        stmt.close();
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                    shutdown();
                }
            });
            JTable jTable = new JTable();
            AbstractTableModel tableModel = new AbstractTableModel() {
                @Override
                public int getRowCount() {
                    int rowCount = 0;
                    try {
                        results.first();
                        while (results.next())
                            rowCount++;
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                    return rowCount;
                }

                @Override
                public int getColumnCount() {
                    return numberCols;
                }

                @Override
                public Object getValueAt(int rowIndex, int columnIndex) {
                    int i = 0;
                    try {
                        results.first();
                        while (i < rowIndex && results.next()) {
                            i++;
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
            };
            jTable.setModel(tableModel);
            mainFrame.add(new JScrollPane(jTable));
            mainFrame.revalidate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}