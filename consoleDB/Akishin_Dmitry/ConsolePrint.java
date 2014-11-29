/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelapplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DEAkishin
 */
public class ConsolePrint {

    private static final String dbURL = "jdbc:mysql://localhost:3306/db_hotel?user=root";
    // jdbc Connection
    private static Connection conn = null;
    private static Statement stmt = null;

    public static void start() {
        createConnection();
        selectAllTables();
        shutdown();
    }

    private static void createConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            //Get a connection
            conn = DriverManager.getConnection(dbURL);
            System.out.println("Connection established");
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ConsolePrint.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void shutdown() {
        try {
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                DriverManager.getConnection(dbURL + ";shutdown=true");
                conn.close();
            }
        } catch (SQLException sqlExcept) {
        }
    }

    private static void selectAllTables() {
        try {
            stmt = conn.createStatement();
            ResultSet results;
            results = stmt.executeQuery("SELECT TABLE_NAME FROM INFORMATION_SCHEMA.TABLES"
                    + " where TABLE_SCHEMA='db_hotel';");
            ResultSetMetaData rsmd = results.getMetaData();

            //Вывод всех таблиц
            System.out.print("Список таблиц:\n");
            ArrayList<String> tableArray = new ArrayList<>();
            int i = 1;
            while (results.next()) {
                String tableName = results.getString(1);
                tableArray.add(tableName);
                System.out.printf(i + "\t" + tableName + "\n");
                i++;
            }
            results.close();

            //Обработка запросов на вывод конкретных таблиц
            System.out.print("Введите номер таблицы (0 или буква для выхода): ");
            Scanner scan = new Scanner(System.in);
            String input = scan.next();
            int num;
            try {
                num = Integer.valueOf(input);
            } catch (NumberFormatException e) {
                num = 0;
            }
            while (num != 0) {
                if (num > tableArray.size() || num < 0) {
                    System.out.print("Такой таблицы нет!\n");
                } else {
                    selectTable(stmt, tableArray.get(num - 1));
                }
                System.out.print("Введите номер таблицы (0 для выхода): ");
                input = scan.next();
                try {
                    num = Integer.valueOf(input);
                } catch (NumberFormatException e) {
                    num = 0;
                }
            }
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConsolePrint.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void selectTable(Statement stmt, String tableName) {
        try {
            ResultSet results;
            results = stmt.executeQuery("select * from " + tableName);
            ResultSetMetaData rsmd = results.getMetaData();
            System.out.println("\nТаблица " + tableName + ":\n");
            int numberCols = rsmd.getColumnCount();
            int colWidth = 24;
            for (int i = 1; i <= numberCols; i++) {
                //print Column Names
                System.out.printf("%-" + colWidth + "s", rsmd.getColumnLabel(i));
            }
            String line = "";
            int lineSize = colWidth * numberCols;
            for (int j = 0; j < lineSize; j++) {
                line += "-";
            }
            System.out.println("\n" + line);
            Format dateFormatter = new SimpleDateFormat("dd.MM.yyyy");
            Object obj;
            String elem;
            while (results.next()) {

                for (int i = 1; i <= numberCols; i++) {
                    if (rsmd.getColumnType(i) == Types.DATE) {
                        elem = dateFormatter.format(results.getDate(i));
                    } else {
                        elem = results.getString(i);
                    }
                    System.out.printf("%-" + colWidth + "s", elem);
                }
                System.out.printf("\n");
            }
            results.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConsolePrint.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
