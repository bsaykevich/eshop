package net.golovach.eshop.jujaJDBC;

import java.sql.*;

public class MyApp {

    private static final String DB_CONN_PATH = "jdbc:postgresql://127.0.0.1:5432/sqlcmd";
    private static final String POSTGRESQL_DRIVER = "org.postgresql.Driver";
    private static final String DB_USER = "sqlcmd";
    private static final String DB_PASSWORD = "sqlcmd";
    private static final String TABLE_NAME = "user";
    public static final String SHOW_EXISTING_TABLE_NAMES =
            "SELECT * FROM pg_catalog.pg_tables WHERE schemaname != 'pg_catalog' AND schemaname != 'information_schema';";
    private static final String LINE_SEPARATOR = System.lineSeparator();
    public static final String COLUMN_SEPARATOR = " | ";
    private Connection conn;

    public static void main(String[] args) {

    }

    public void simpleSQL() throws SQLException {
        checkJDBCDriver();
        createDbConnection();

    }

    private void deleteDataByTitle(String tableName, String columnName, String title) throws SQLException{
        //TODO: continue here!
        String sqlQueryDeleteByTitle =
                String.format("DELETE FROM \"%s\" TABLE WHERE ", tableName);
    }

    private void updateDataByTitle() throws SQLException{

    }

    private void showExistingDataInTable() throws SQLException{

    }

    private void addUser(String username, String password) throws SQLException, NullPointerException{
        String sqlQueryAddUser =
                String.format("INSERT INTO \"%s\" (name, password) VALUES ('%s', '%s')", TABLE_NAME, username, password);
        try (Statement stmt = conn.createStatement()){
            stmt.execute(sqlQueryAddUser);
        }

    }

    private void createTable(String tableName) throws SQLException{
        String sqlQueryCreateTable =
                String.format("CREATE TABLE public.\"%s\" (id SERIAL PRIMARY KEY, name TEXT NOT NULL, password TEXT NOT NULL)", tableName);
        try(Statement stmt = conn.createStatement()){
            stmt.execute(sqlQueryCreateTable);
        }
    }

    private void showExistingTableNames() throws SQLException{

    }

    private void createDbConnection(){

        try{
            conn = DriverManager.getConnection(DB_CONN_PATH, DB_USER, DB_PASSWORD);
        } catch (SQLException e){
            System.out.println("connection to DB failed");
        }

        if(conn != null){
            System.out.println("connection successful");
        } else {
            System.out.println("connection failed");
        }
    }

    private void checkJDBCDriver() {
        try{
            Class.forName(POSTGRESQL_DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println("driver class not found");
        }

        System.out.println("JDBC driver registered");
    }
}
