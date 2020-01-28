package edu.xml.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.xml.helpers.Bibliotheque;
import edu.xml.helpers.ObjectFactory;
import edu.xml.helpers.Bibliotheque.Livre;
import edu.xml.helpers.Bibliotheque.Livre.Auteur;

public class ModelDB {
    private Connection conn = null;
    private Statement stmt = null;
    private ResultSet rs = null;

    public ModelDB() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean connectDB() {
        boolean returnValue = false;
        try {
            conn = DriverManager.getConnection(
                    "jdbc:mysql://mathysballagny.fr/bibliotheque?" + "user=biblio&password=bibliotheque");
            returnValue = true;
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            returnValue = false;
        }
        return returnValue;
    }

    public Bibliotheque readDB() {
        try {
            List<Livre> biblio = new ArrayList<Livre>();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM biblio");
            while (rs.next()) {
                Livre newLivre = new Livre();
                Auteur newAuteur = new Auteur();
                newLivre.setTitre(rs.getString(2));
                newAuteur.setNom(rs.getString(3));
                newAuteur.setPrenom(rs.getString(4));
                newLivre.setAuteur(newAuteur);
                newLivre.setPresentation(rs.getString(5));
                newLivre.setParution(rs.getInt(6));
                newLivre.setColonne((short) rs.getInt(7));
                newLivre.setRangee((short) rs.getInt(8));
                newLivre.setImgUrl(rs.getString(9));
                newLivre.setPret(rs.getBoolean(10));

                newLivre.setAcquis(rs.getString(11));

                newLivre.setNomAcquis(rs.getString(12));
                biblio.add(newLivre);
            }
            return new Bibliotheque(biblio);
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        } finally {

            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException sqlEx) {
                } // ignore

                rs = null;
            }

            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException sqlEx) {
                } // ignore

                stmt = null;
            }
        }
        ObjectFactory objFactory = new ObjectFactory();
        return (Bibliotheque) objFactory.createBibliotheque();
    }
}