package net.golovach.eshop.jdbc;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DevColibri {

    private static final String URL = "jdbc:mysql://localhost:3306/mydbtest";
    private static final String user = "bogdan";
    private static final String password = "password";

    public static void main(String[] args) {
        Connection connection;

        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
            connection = DriverManager.getConnection(URL, user, password);

            if(!connection.isClosed()){
                System.out.println("connection opened");
            }

            connection.close();

            if(connection.isClosed()){
                System.out.println("connection closed");
            }

        } catch (SQLException e){
            System.out.println("connection failed");
        }

    }
}
