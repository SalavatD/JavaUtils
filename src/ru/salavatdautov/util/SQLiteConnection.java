package ru.salavatdautov.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Small wrapper over java.sql.Connection for SQLite
 */
public class SQLiteConnection {
    /**
     * Private field with connection
     */
    protected final Connection connection;

    /**
     * Create connection to database
     *
     * @param filePath path to SQLite database file
     */
    public SQLiteConnection(String filePath) throws SQLException, ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection(String.format("jdbc:sqlite:%s", filePath));
    }

    /**
     * Method which execute query to database
     *
     * @param sql query string
     * @return result as ResultSet
     */
    public ResultSet executeQuery(String sql) throws SQLException {
        return connection.createStatement().executeQuery(sql);
    }

    /**
     * Close connection to database
     */
    public void disconnect() throws SQLException {
        connection.close();
    }
}
