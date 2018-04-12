package net.golovach.eshop.jujaJDBC;

import java.sql.*;

public class DatabaseManager {

    private static final String DB_URL = "jdbc:postgres://127.0.0.1:5432/";
    private static final String POSTGRESQL_DRIVER = "org.postgresql.Driver";
    private Connection conn;

    public boolean connect(String dbName, String login, String password){

        try {
            Class.forName(POSTGRESQL_DRIVER);

            conn = DriverManager.getConnection(DB_URL+dbName, login, password);
            return true;

        } catch (ClassNotFoundException e){
            System.out.println("driver class not found! Add JDBC jar to your project.   ");
            return false;
        } catch (SQLException e) {
            System.out.println(String.format("connection failed to %s with user = %s and password = %s", dbName, login, password));
            return false;
        }
    }

    public String[] tableNames() throws SQLException {
        String sqlQuery = "SELECT table_name FROM information_schema.tables WHERE table_schema='public' AND table_type='BASE TABLE'";

        try(PreparedStatement prepStmt = conn.prepareStatement(sqlQuery,
                ResultSet.TYPE_SCROLL_SENSITIVE,
                ResultSet.CONCUR_UPDATABLE);
                ResultSet resultSet = prepStmt.executeQuery()){

            int arraySize = numberOfRows(resultSet);
            int index = 0;
            String[] tableNames = new String[arraySize];

            if (resultSet.isBeforeFirst()){
                while (resultSet.next()){
                    tableNames[index++] = resultSet.getString(1);
                }
                return tableNames;
            } else {
                return new String[0];
            }

        }

    }

    public boolean close(){
        try {
            conn.close();
            return true;
        } catch (SQLException | NullPointerException e){
            e.printStackTrace();
            return false;
        }
    }

    private int numberOfRows(ResultSet resultSet) throws SQLException {
        int rowCounter = 0;
        if(resultSet.last()){
            rowCounter = resultSet.getRow();
            resultSet.beforeFirst();
        }
        return rowCounter;
    }


}
