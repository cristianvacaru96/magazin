package db;

import models.dao.Produs;
import models.dao.User;
import utils.DbManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProdusDb {
    private DbManager dbManager;

    public ProdusDb(DbManager dbManager) {
        this.dbManager = dbManager;
    }


    public void addProdus(Produs produs) throws SQLException {
        Connection connection = dbManager.getNewConnection();
        Statement statement = connection.createStatement();
        try{
            String query = "INSERT INTO Produs ( `nume`, `producator`, `pret`, `cantitateStoc`, `descriere`) VALUES(" +
                    produs.getName() + "', '" +
                    produs.getProducator() + "', '" +
                    produs.getPret() + "', '"+
                    produs.getCantitateStoc() + "', '"+
                    produs.getDescriere() + "');";
            statement.executeUpdate(query);
            statement.close();
        }finally {
            if(!statement.isClosed()) {
                statement.close();
            }
            connection.close();
        }
    }

    public List<Produs> getProduse() throws SQLException{
        List<Produs> produse = new ArrayList<>();

        Connection connection = dbManager.getNewConnection();
        Statement  statement  = connection.createStatement();
        try{
            String    query = "SELECT * FROM `produs`;";
            ResultSet rs    = statement.executeQuery(query);

            while(rs.next()) {
                produse.add(new Produs(
                        rs.getLong("idProdus"),
                        rs.getString("nume"),
                        rs.getString("producator"),
                        rs.getInt("pret"),
                        rs.getInt("cantitateStoc"),
                        rs.getString("descriere")));
            }
            rs.close();
            statement.close();
            return produse;
        } finally {
            if(!statement.isClosed()) {
                statement.close();
            }
            connection.close();
        }
    }

    public Produs getProdus(long idProdus) throws SQLException {
        Connection connection = dbManager.getNewConnection();
        Statement  statement  = connection.createStatement();
        try {
            String    query = "SELECT * FROM produs WHERE idProdus=" + idProdus + ";";
            ResultSet rs    = statement.executeQuery(query);

            rs.next();
            Produs produs = new Produs(
                    rs.getLong("idProdus"),
                    rs.getString("nume"),
                    rs.getString("producator"),
                    rs.getInt("pret"),
                    rs.getInt("cantitateStoc"),
                    rs.getString("descriere")
            );

            rs.close();
            statement.close();
            return produs;
        } finally {
            if(!statement.isClosed()) {
                statement.close();
            }
            connection.close();
        }
    }

    public void deleteProdus(long idProdus) throws SQLException{
        Connection connection = dbManager.getNewConnection();
        Statement statement = connection.createStatement();

        try {
            String query = "DELETE FROM `produs` WHERE idProdus=" + idProdus + ";";
            statement.executeUpdate(query);
            statement.close();
        }finally {
            if(!statement.isClosed()){
                statement.close();
            }
            connection.close();
        }
    }


    public void updateProdus (long idProdus, Produs produs ) throws SQLException{
        Connection connection = dbManager.getNewConnection();
        Statement statement = connection.createStatement();
        try{
            String query = "UPDATE `produs` SET " +
                    "`nume`='" + produs.getName() + "', " +
                    "`producator`='" + produs.getProducator() + "'," +
                    "`pret`='" + produs.getPret() + "'," +
                    "`cantitateStoc`=" + produs.getCantitateStoc() + "," +
                    "`descriere`='" + produs.getDescriere() +  "' WHERE idProdus=" + idProdus + ";";

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
