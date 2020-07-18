package db;

import models.dao.User;
import utils.DbManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDb {

    private DbManager dbManager;

    public UserDb(DbManager dbManager) {
        this.dbManager = dbManager;
    }

    public void addUser(User user) throws SQLException {
        Connection connection = dbManager.getNewConnection();
        Statement statement = connection.createStatement();
        try{
            String query = "INSERT INTO user ( `nume`, `prenume`, `email`, `parola`, `adresa`) VALUES('" +
                    user.getLastName() + "', '" +
                    user.getFirstName() + "', '" +
                    user.getEmail() + "', '"+
                    user.getParola() + "', '"+
                    user.getAdresa() + "');";
            statement.executeUpdate(query);
            statement.close();
        }finally {
            if(!statement.isClosed()) {
                statement.close();
            }
            connection.close();
        }
    }

    public List<User> getUsers() throws SQLException{
        List<User> users = new ArrayList<>();

        Connection connection = dbManager.getNewConnection();
        Statement  statement  = connection.createStatement();
        try{
            String    query = "SELECT * FROM `user`;";
            ResultSet rs    = statement.executeQuery(query);

            while(rs.next()) {
                users.add(new User(
                        rs.getLong("idUser"),
                        rs.getString("nume"),
                        rs.getString("prenume"),
                        rs.getString("email"),
                        rs.getString("parola"),
                        rs.getString("adresa")));
            }
            rs.close();
            statement.close();
            return users;
        } finally {
            if(!statement.isClosed()) {
                statement.close();
            }
            connection.close();
        }
    }

    public User getUser(long idUser) throws SQLException {
        Connection connection = dbManager.getNewConnection();
        Statement  statement  = connection.createStatement();
        try {
            String    query = "SELECT * FROM user WHERE idUser=" + idUser + ";";
            ResultSet rs    = statement.executeQuery(query);

            rs.next();
            User user = new User(
                    rs.getLong("idAdmin"),
                    rs.getString("nume"),
                    rs.getString("prenume"),
                    rs.getString("email"),
                    rs.getString("parola"),
                    rs.getString("adresa")
            );

            rs.close();
            statement.close();
            return user;
        } finally {
            if(!statement.isClosed()) {
                statement.close();
            }
            connection.close();
        }
    }

    public void deleteUser(long idUser) throws SQLException{
        Connection connection = dbManager.getNewConnection();
        Statement statement = connection.createStatement();

        try {
            String query = "DELETE FROM `user` WHERE idAUser=" + idUser + ";";
            statement.executeUpdate(query);
            statement.close();
        }finally {
            if(!statement.isClosed()){
                statement.close();
            }
            connection.close();
        }
    }


    public void updateUser (long idUser, User user ) throws SQLException{
        Connection connection = dbManager.getNewConnection();
        Statement statement = connection.createStatement();
        try{
            String query = "UPDATE `user` SET " +
                    "`nume`='" + user.getLastName() + "', " +
                    "`prenume`='" + user.getFirstName() + "'," +
                    "`email`='" + user.getEmail() + "'," +
                    "`parola`=" + user.getParola() + "," +
                    "`adresa`='" + user.getAdresa() +  "' WHERE idUser=" + idUser + ";";

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
