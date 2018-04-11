package net.golovach.eshop.jdbc;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.Calendar;

public class MySQLPreparedStmt {

    public static final String URL = "jdbc:mysql://localhost:3306/mydbtest";
    public static final String USER = "root";
    public static final String PASSWORD = "12345";

    public static final String INSERT_NEW = "INSERT INTO dish VALUES (?, ?, ?, ?, ?, ?, ?)";
    public static final String GET_ALL = "SELECT * FROM dish";
    public static final String DELETE = "DELETE FROM dish WHERE id = ?";

    public static void main(String[] args) {

        Connection conn = null;
        PreparedStatement prepStmt = null;

        try{
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
            conn = DriverManager.getConnection(URL, USER, PASSWORD);

            //PreparedStatement prepStmt = conn.prepareStatement("INSERT INTO mydbtest.users (name, age, email) VALUES (?, ?, ?)");

           /* prepStmt = conn.prepareStatement(INSERT_NEW);

            prepStmt.setInt(1, 1);
            prepStmt.setString(2, "title1");
            prepStmt.setString(3, "description1");
            prepStmt.setString(3, "description2");
            prepStmt.setDouble(4, 1.5);
            prepStmt.setBoolean(5, false);
            prepStmt.setDate(6, new Date(Calendar.getInstance().getTimeInMillis()));
            prepStmt.setBlob(7, new FileInputStream("smile.png"));*/

            /*Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(GET_ALL);*/

            prepStmt = conn.prepareStatement(DELETE);
            prepStmt.setInt(1, 1);
            int rowsChanged = prepStmt.executeUpdate();
            System.out.println(rowsChanged);

            /*while (resultSet.next()){

                int id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                String desc = resultSet.getString("description");
                Double rating = resultSet.getDouble("rating");
                boolean published = resultSet.getBoolean("published");
                Date created = resultSet.getDate("created");
                byte[] icon = resultSet.getBytes("icon");

                System.out.println("{id: " + id
                        + ", title: " + title
                        + ", description: " + desc
                        + ", rating: " + rating
                        + ", published: " + published
                        + ", created: " + created
                        + ", icon: " + icon.length
                        + "}");

            }*/

        } catch (SQLException /*| FileNotFoundException*/ e){
            e.printStackTrace();
        } finally {
            try {
                conn.close();
                prepStmt.close();
            } catch (SQLException e){
                e.printStackTrace();
            }

        }

    }


}
