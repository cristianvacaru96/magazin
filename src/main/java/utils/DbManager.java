package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbManager {
    private static String url = "jdbc:mysql://localhost:3306/magazin";
    private static String user = "root";
    private static String password = "";

    public DbManager() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Connection getNewConnection() throws SQLException{
        return DriverManager.getConnection(url, user, password);
    }

}