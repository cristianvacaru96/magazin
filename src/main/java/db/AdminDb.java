package db;

import models.dao.Admin;
import utils.DbManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AdminDb {
    private DbManager dbManager;

    public AdminDb(DbManager dbManager) {
        this.dbManager = dbManager;
    }

    public void addAdmin(Admin admin) throws SQLException {
        Connection connection = dbManager.getNewConnection();
        Statement statement = connection.createStatement();
        try{
            String query = "INSERT INTO admin ( `nume`, `prenume`, `email`, `parola`, `telefon`, `drept`) VALUES('" +
                    admin.getLastName() + "', '" +
                    admin.getFirstName() + "', '" +
                    admin.getEmail() + "', '"+
                    admin.getParola() + "', '"+
                    admin.getTelefon() + "', '"+
                    admin.getDrept() + "');";
            statement.executeUpdate(query);
            statement.close();
        }finally {
            if(!statement.isClosed()) {
                statement.close();
            }
            connection.close();
        }
    }

    public List<Admin> getAdmins() throws SQLException{
        List<Admin> admins = new ArrayList<>();

        Connection connection = dbManager.getNewConnection();
        Statement  statement  = connection.createStatement();
        try{
            String    query = "SELECT * FROM admin;";
            ResultSet rs    = statement.executeQuery(query);

            while(rs.next()) {
                admins.add(new Admin(
                        rs.getLong("idAdmin"),
                        rs.getString("nume"),
                        rs.getString("prenume"),
                        rs.getString("email"),
                        rs.getString("parola"),
                        rs.getString("telefon"),
                        rs.getString("drept")));
            }
            rs.close();
            statement.close();
            return admins;
        } finally {
            if(!statement.isClosed()) {
                statement.close();
            }
            connection.close();
        }
    }

    public Admin getAdmin(long idAdmin) throws SQLException {
        Connection connection = dbManager.getNewConnection();
        Statement  statement  = connection.createStatement();
        try {
            String    query = "SELECT * FROM admin WHERE idAdmin=" + idAdmin + ";";
            ResultSet rs    = statement.executeQuery(query);

            rs.next();
            Admin admin = new Admin(
                    rs.getLong("idAdmin"),
                    rs.getString("nume"),
                    rs.getString("prenume"),
                    rs.getString("email"),
                    rs.getString("parola"),
                    rs.getString("telefon"),
                    rs.getString("drept")
            );

            rs.close();
            statement.close();
            return admin;
        } finally {
            if(!statement.isClosed()) {
                statement.close();
            }
            connection.close();
        }
    }

    public void deleteAdmin(long idAdmin) throws SQLException{
        Connection connection = dbManager.getNewConnection();
        Statement statement = connection.createStatement();

        try {
            String query = "DELETE FROM admin WHERE idAdmin=" + idAdmin + ";";
            statement.executeUpdate(query);
            statement.close();
        }finally {
            if(!statement.isClosed()){
                statement.close();
            }
            connection.close();
        }
    }


    public void updateAdmin (long idAdmin, Admin admin ) throws SQLException{
        Connection connection = dbManager.getNewConnection();
        Statement statement = connection.createStatement();
        try{
            String query = "UPDATE `admin` SET " +
                    "`nume`='" + admin.getLastName() + "', " +
                    "`prenume`='" + admin.getFirstName() + "'," +
                    "`email`='" + admin.getEmail() + "'," +
                    "`parola`=" + admin.getParola() + "," +
                    "`telefon`=" + admin.getTelefon() + "," +
                    "`drept`='" + admin.getDrept() +  "' WHERE idAdmin=" + idAdmin + ";";

            statement.executeUpdate(query);
            statement.close();

        }finally {
            if(!statement.isClosed()){
                statement.close();
            }
            connection.close();
        }
    }


}
