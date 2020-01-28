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
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean connectDB() {
        boolean returnValue = false;
        try {
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/bibliotheque?" + "user=root&password=12101983");
            returnValue = true;
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            ex.printStackTrace();
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
                newLivre.setImgUrl(rs.getString(12));
                newLivre.setPret(rs.getBoolean(10));

                newLivre.setAcquis(rs.getString(11));

                newLivre.setNomAcquis(rs.getString(9));
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
    
    public void addLivre(Livre livre){
        try{
            stmt = conn.createStatement();
            String query = "INSERT INTO biblio"
                    + "(titre, autPrenom, autNom, presentation, parution, colonne, rangee, imgUrl, emprunt, acquis, nomAcquis) VALUES ("
                    + livre.getTitre() + ", "
                    + livre.getAuteur().getPrenom() + ", "
                    + livre.getAuteur().getNom() + ", "
                    + livre.getPresentation() + ", "
                    + livre.getParution() + ", "
                    + livre.getColonne() + ", "
                    + livre.getRangee() + ", "
                    + livre.getImgUrl() + ", "
                    + livre.isPret() + ", "
                    + livre.getAcquis() + ", "
                    + livre.getNomAcquis() + ")";
            rs = stmt.executeQuery(query);
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
        
    }
    
    public void modifyLivre(Livre livre){
        try{
            stmt = conn.createStatement();
            String query = "UPDATE biblio SET"
                    + "titre = " + livre.getTitre() + ", "
                    + "autPrenom = " +  livre.getAuteur().getPrenom() + ", "
                    + "autNom= " +  livre.getAuteur().getNom() + ", "
                    + "presentation = " +  livre.getPresentation() + ", "
                    + "parution = " +  livre.getParution() + ", "
                    + "colonne = " +  livre.getColonne() + ", "
                    + "rangee = " +  livre.getRangee() + ", "
                    + "imgUrl = " +  livre.getImgUrl() + ", "
                    + "emprunt = " +  livre.isPret() + ", "
                    + "acquis = " +  livre.getAcquis() + ", "
                    + "nomAcquis = " +  livre.getNomAcquis()
                    + " WHERE id = "+livre.getId();
            rs = stmt.executeQuery(query);
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
    }
    public void removeLivre(int id){
        try{
            stmt = conn.createStatement();
            String query = "DELETE FROM biblio WHERE id = " + id;
            rs = stmt.executeQuery(query);
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
    }
    public void importDB(Bibliotheque biblio){
        try{
            List<Livre> livres = biblio.getLivre();
            List<Livre> livresInDB = readDB().getLivre();
            List<String> titreLivresInDB = new ArrayList<>();
            for(Livre livre: livresInDB){
                
            }
            for(Livre livre: livres){
                if(!titreLivresInDB.contains(livre.getTitre())){
                    stmt = conn.createStatement();
                    String query = "INSERT INTO biblio"
                            + "(titre, autPrenom, autNom, presentation, parution, colonne, rangee, imgUrl, emprunt, acquis, nomAcquis) VALUES ("
                            + livre.getTitre() + ", "
                            + livre.getAuteur().getPrenom() + ", "
                            + livre.getAuteur().getNom() + ", "
                            + livre.getPresentation() + ", "
                            + livre.getParution() + ", "
                            + livre.getColonne() + ", "
                            + livre.getRangee() + ", "
                            + livre.getImgUrl() + ", "
                            + livre.isPret() + ", "
                            + livre.getAcquis() + ", "
                            + livre.getNomAcquis() + ")";
                    rs = stmt.executeQuery(query);
                }
            }
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
    }
}