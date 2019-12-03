package dao;

import java.sql.*;

public class DbConnection {
    protected String connectionString = "jdbc:sap://localhost:30015/HNE?currentschema=<SCHEMA_NAME>";
    protected String userName = "username";
    protected String password = "password";
    private Connection conn;
    public DbConnection(){
        try {
            conn = DriverManager.getConnection(connectionString, userName, password);
        } catch (SQLException e) {
            e.printStackTrace();
            return;
        }
    }
    public ResultSet runQuery(String query) throws SQLException{
        Statement statement = conn.createStatement();
        return statement.executeQuery(query);
    }
    public void closeConn() throws SQLException{
        this.conn.close();
    }
}
