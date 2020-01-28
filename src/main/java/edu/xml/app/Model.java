package edu.xml.app;

import edu.xml.helpers.Bibliotheque;
import edu.xml.helpers.Bibliotheque.Livre;
import edu.xml.helpers.Bibliotheque.Livre.Auteur;
import edu.xml.helpers.ObjectFactory;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Model {

    /*
     * Index: ID Titre Nom Prenom Présentation Parution Colonne Rangee Pret Acquis Nom
     * Acquis Img_Url
     */

    private List<Livre> livres;
    private Logger logger = LogManager.getLogger();
    private String username;
    private int userLevel = 0;
    private ModelDB modelDB;
    private boolean connected = false;
    private ModelFile modelFile;
    private Bibliotheque bibliotheque;
    private int method;

    public boolean isConnected() {
        return connected;
    }

    public int getMethod() {
        return method;
    }

    public Model() {
    }
    
    public void readDB(){
        if(!connected){
            modelDB = new ModelDB();
            connected = modelDB.connectDB();
        }
        bibliotheque = modelDB.readDB();
        livres = bibliotheque.getLivre();
        method = 1;
    }
    
    public void readFile(String filepath){
        bibliotheque = modelFile.readFile(filepath);
        livres = bibliotheque.getLivre();
        method = 0;
    }
    
    public void save(){
        if(method == 0){
            modelFile.saveFile(bibliotheque);
        } else if(method == 1){
            //Do nothing
        }
    }
    
    public void exportFile(String filepath){
        modelFile.exportTo(filepath, bibliotheque);
    }
    
    public void exportDB(){
        if(!connected){
            modelDB = new ModelDB();
            connected = modelDB.connectDB();
        }
        modelDB.importDB(bibliotheque);
    }

    public boolean logIn(String username, String password) {
        ModelLogin modelLogin = new ModelLogin();
        if (modelLogin.connect(username, password)) {
            userLevel = modelLogin.getLevel();
            username = modelLogin.getUsername();
            return true;
        } else
            return false;
    }

    public String getUsername() {
        return username;
    }

    public int getLevel() {
        return userLevel;
    }
    
    public String[][] getLivres() {
        String[][] convertedLivres = new String[livres.size()][9];
        for (int i = 0; i < livres.size(); i++) {
            Bibliotheque.Livre livre = livres.get(i);
            convertedLivres[i][0] = String.valueOf(livre.getId());
            convertedLivres[i][1] = livre.getTitre();
            convertedLivres[i][2] = livre.getAuteur().getNom() + " " + livre.getAuteur().getPrenom();
            convertedLivres[i][3] = livre.getPresentation();
            convertedLivres[i][4] = String.valueOf(livre.getParution());
            convertedLivres[i][5] = String.valueOf(livre.getColonne());
            convertedLivres[i][6] = String.valueOf(livre.getRangee());

            convertedLivres[i][7] = livre.getImgUrl();
            convertedLivres[i][8] = livre.getAcquis();
            convertedLivres[i][9] = livre.getNomAcquis();

        }
        return convertedLivres;
    }

    public List<String> getLivreByIndex(int index) {
        Bibliotheque.Livre livre = livres.get(index);
        List<String> convertedLivre = new ArrayList<>();
        convertedLivre.add(livre.getTitre());
        convertedLivre.add(livre.getAuteur().getNom());
        convertedLivre.add(livre.getAuteur().getPrenom());
        convertedLivre.add(livre.getPresentation());
        convertedLivre.add(String.valueOf(livre.getParution()));
        convertedLivre.add(String.valueOf(livre.getColonne()));
        convertedLivre.add(String.valueOf(livre.getRangee()));
        convertedLivre.add(String.valueOf(livre.isPret()));
        convertedLivre.add(livre.getAcquis());
        convertedLivre.add(livre.getNomAcquis());
        convertedLivre.add(livre.getImgUrl());
        return convertedLivre;
    }

    public boolean addLivre(List<String> livre) {
        if (userLevel == -1) {
            Bibliotheque.Livre newLivre = new Bibliotheque.Livre();
            Bibliotheque.Livre.Auteur newAuteur = new Bibliotheque.Livre.Auteur();
            newLivre.setId(Integer.parseInt(livre.get(0)));
            newLivre.setTitre(livre.get(1));
            newAuteur.setNom(livre.get(2));
            newAuteur.setPrenom(livre.get(3));
            newLivre.setAuteur(newAuteur);
            newLivre.setPresentation(livre.get(4));
            newLivre.setParution(Integer.parseInt(livre.get(5)));
            newLivre.setColonne(Short.parseShort(livre.get(7)));
            newLivre.setRangee(Short.parseShort((livre.get(6))));
            newLivre.setImgUrl(livre.get(8));
            if (livre.get(9).equals("Emprunter")) {
                newLivre.setPret(true);
            } else {
                newLivre.setPret(false);
            }

            newLivre.setAcquis(livre.get(10));

            newLivre.setNomAcquis(livre.get(11));
            newLivre.setImgUrl(livre.get(12));

            livres.add(newLivre);
            logger.debug("Added " + newLivre.getTitre() + " by " + newLivre.getAuteur().getPrenom() + " "
                    + newLivre.getAuteur().getNom());
            if(method == 1){
                modelDB.addLivre(newLivre);
            }
            return true;
        } else
            return false;
    }

    public boolean modifyLivre(int index, List<String> livre) {
        if (userLevel == -1) {
            Bibliotheque.Livre newLivre = new Bibliotheque.Livre();
            Bibliotheque.Livre.Auteur newAuteur = new Bibliotheque.Livre.Auteur();
            newLivre.setTitre(livre.get(1));

            newAuteur.setNom(livre.get(2));
            newAuteur.setPrenom(" ");
            newLivre.setAuteur(newAuteur);

            newLivre.setPresentation(livre.get(3));

            newLivre.setParution(Integer.parseInt(livre.get(4)));

            newLivre.setColonne(Short.parseShort(livre.get(5)));
            newLivre.setRangee(Short.parseShort(livre.get(6)));
            newLivre.setImgUrl(livre.get(7));
            newLivre.setNomAcquis(livre.get(8));

            newLivre.setAcquis(" ");

            livres.set(index, newLivre);
            logger.debug("Modified " + newLivre.getTitre() + " by " + newLivre.getAuteur().getPrenom() + " "
                    + newLivre.getAuteur().getNom());
            if(method == 1){
                modelDB.modifyLivre(newLivre);
            }
            return true;
        } else
            return false;
    }

    public boolean removeLivre(int index) {
        if (userLevel == -1) {
            Bibliotheque.Livre livre = livres.get(index);
            livres.remove(livre);
            logger.debug("Removed " + livre.getTitre() + " by " + livre.getAuteur().getPrenom() + " "
                    + livre.getAuteur().getNom());
            if(method == 1){
                modelDB.removeLivre(livre.getId());
            }
            return true;
        } else
            return false;
    }
}
