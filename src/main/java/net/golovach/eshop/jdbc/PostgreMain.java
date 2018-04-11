package net.golovach.eshop.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PostgreMain {

    public static void main(String[] args) {

        PostgreWorker psWorker = new PostgreWorker();

        String query = "select * from users where id = 2;";

        Connection conn = psWorker.getConnection();

        try {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()){

                int id = resultSet.getInt(1);
                String name = resultSet.getString("name");
                String password = resultSet.getString(3);

                PostgreUser user = new PostgreUser(id, name, password);
                System.out.println(user);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
