package net.golovach.eshop.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgreWorker {

    public static final String HOST = "jdbc:postgresql://localhost:5432/postgres";
    public static final String USER = "postgres";
    public static final String PASSWORD = "password";

    public Connection connection;

    public PostgreWorker() {
        try {
            this.connection = DriverManager.getConnection(HOST, USER, PASSWORD);
        } catch (SQLException e){
            System.out.println("posgresql DB connection failed.");
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
