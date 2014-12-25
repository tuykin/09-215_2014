package ru.kpfu.disciplines.db.gtf.helpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// класс для работы с бд
public class ConnectorDB {

    private static Connection connection; // переменная, которая хранит подключение к БД

    public ConnectorDB(String url) {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection =  DriverManager.getConnection(url);
        } catch (Exception except) {
            except.printStackTrace();
        }
    }

    // получить подключение
    public Connection getConnection() {
        return connection;
    }

    // закрыть подключение
    public boolean shutdownConnection() {
        try {
            if (connection != null) {
                connection.close();
            }
            return true;
        } catch (SQLException sqlExcept) {
            System.out.println(sqlExcept.fillInStackTrace());
            return false;
        }
    }
}