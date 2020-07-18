package db;

import models.dao.Carte;
import utils.DbManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CarteDb {

    private DbManager dbManager;

    public CarteDb(DbManager dbManager) {
        this.dbManager = dbManager;
    }

    public void postCarte(Carte carte) throws SQLException {
        Connection connection = dbManager.getNewConnection();
        Statement statement = connection.createStatement();
        try{
            String query = "INSERT INTO Carte ( `titlu`, `autori`, `editura`, `anCarte`, `isbn`) VALUES('" +
                    carte.getTitlu() + "', '" +
                    carte.getAutori() + "', '" +
                    carte.getEditura() + "', '"+
                    carte.getAnCarte() + "', '"+
                    carte.getIsbn() + "');";
            statement.executeUpdate(query);
            statement.close();
        }finally {
            if(!statement.isClosed()) {
                statement.close();
            }
            connection.close();
        }
    }


    public List<Carte> getCarti() throws SQLException{
        List<Carte> carti = new ArrayList<>();

        Connection connection = dbManager.getNewConnection();
        Statement  statement  = connection.createStatement();
        try{
            String    query = "SELECT * FROM Carte;";
            ResultSet rs    = statement.executeQuery(query);

            while(rs.next()) {
                carti.add(new Carte(
                        rs.getLong("idCarte"),
                        rs.getString("titlu"),
                        rs.getString("autori"),
                        rs.getString("editura"),
                        rs.getInt("anCarte"),
                        rs.getString("isbn")));
            }
            rs.close();
            statement.close();
            return carti;
        } finally {
            if(!statement.isClosed()) {
                statement.close();
            }
            connection.close();
        }
    }

    public Carte getCarte(long idCarte) throws SQLException {
        Connection connection = dbManager.getNewConnection();
        Statement  statement  = connection.createStatement();
        try {
            String    query = "SELECT * FROM Carte WHERE idCarte=" + idCarte + ";";
            ResultSet rs    = statement.executeQuery(query);

            rs.next();
            Carte carte = new Carte(
                    rs.getLong("idCarte"),
                    rs.getString("titlu"),
                    rs.getString("autori"),
                    rs.getString("editura"),
                    rs.getInt("anCarte"),
                    rs.getString("isbn")
                    );

            rs.close();
            statement.close();
            return carte;
        } finally {
            if(!statement.isClosed()) {
                statement.close();
            }
            connection.close();
        }
    }

    public void deleteCarte(long id) throws SQLException{
        Connection connection = dbManager.getNewConnection();
        Statement statement = connection.createStatement();

        try {
            String query = "DELETE FROM Carte WHERE idcarte=" + id + ";";
            statement.executeUpdate(query);
            statement.close();
        }finally {
            if(!statement.isClosed()){
                statement.close();
            }
            connection.close();
        }
    }


    public void updateCarte (long id, Carte carte ) throws SQLException{
        Connection connection = dbManager.getNewConnection();
        Statement statement = connection.createStatement();
        try{
            String query = "UPDATE `Carte` SET " +
                    "`titlu`='" + carte.getTitlu() + "', " +
                    "`autori`='" + carte.getAutori() + "'," +
                    "`editura`='" + carte.getEditura() + "'," +
                    "`anCarte`=" + carte.getAnCarte() + "," +
                    "`isbn`='" + carte.getIsbn() +  "' WHERE idcarte=" + id + ";";

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
