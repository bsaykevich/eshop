package net.golovach.eshop.jdbc;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.Properties;

public class MySQLExample {

    public static final String JDBC_URL = "jdbc:mysql://127.0.0.1:3306/quiz_db?user=username&password=password";

    public static void main(String[] args) throws SQLException {

        com.mysql.jdbc.Driver driver = new com.mysql.jdbc.Driver();
        Connection conn1 = driver.connect(JDBC_URL, new Properties());

        Enumeration<Driver> drivers = DriverManager.getDrivers();
        while (drivers.hasMoreElements()){
            Driver driverFromEnum = drivers.nextElement();
            Connection conn2 = driverFromEnum.connect(JDBC_URL, new Properties());
        }

        Connection conn3 = DriverManager.getConnection(JDBC_URL);

        DriverManager.registerDriver(new com.mysql.jdbc.Driver());

        /* if(!driver.acceptsURL(JDBC_URL)) {
            throw new SQLException("incorrect jdbc_url");
        }*/

        try{

            //use conn
        } finally {
            conn1.close();
        }


    }
}
