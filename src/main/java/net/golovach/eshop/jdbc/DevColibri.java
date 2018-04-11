package net.golovach.eshop.jdbc;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;

public class DevColibri {

    private static final String URL = "jdbc:mysql://localhost:3306/mydbtest";
    private static final String user = "bogdan";
    private static final String password = "password";

    public static void main(String[] args) {

        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);

            /*if(!connection.isClosed()){
                System.out.println("connection opened");
            }*/

            /*if(connection.isClosed()){
                System.out.println("connection closed");
            }*/

        } catch (SQLException e){
            System.out.println("connection failed");
        }
        try(Connection connection = DriverManager.getConnection(URL, user, password);
            Statement statement = connection.createStatement()){

/*
            statement.execute("insert into animals (anim_name, anim_desc) VALUES ('dog', 'good boy');");
*/
/*
            int count  = statement.executeUpdate("UPDATE animals SET anim_name = 'barkyboomer' WHERE id = 1;");
            System.out.println(count);
*/

/*
            ResultSet resultSet = statement.executeQuery("SELECT * FROM animals");
            while (resultSet.next()){
                String name = resultSet.getString(2);
                String value = resultSet.getString(3);

                System.out.println(name + " " + value);
            }
*/
/*
            statement.addBatch("INSERT INTO animals (anim_name, anim_desc) VALUES ('cat', 'white')");
            statement.addBatch("INSERT INTO animals (anim_name, anim_desc) VALUE ('cow', 'teodora')");
            statement.addBatch("INSERT INTO animals (anim_name) VALUE ('mouse')");
            statement.addBatch("INSERT INTO animals (anim_name) VALUE ('snake')");

            statement.executeBatch();
            statement.clearBatch();
*/
            System.out.println(statement.isClosed());
            Connection connection1 = statement.getConnection();

            System.out.println(connection.equals(connection1));

        }catch (SQLException e){

        }



    }
}
