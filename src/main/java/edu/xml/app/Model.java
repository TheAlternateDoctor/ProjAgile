package edu.xml.app;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import edu.xml.helpers.Bibliotheque;
import edu.xml.helpers.Bibliotheque.Livre;
import edu.xml.helpers.Bibliotheque.Livre.Auteur;

public class Model {

    private List<Livre> livres;
    private String filepath;

    public Model() {
        lectureFichier("./Biblio_1.xml");
    }

    public void lectureFichier(String filepath) {
        try {
            this.filepath = filepath;
            File file = new File(filepath);
            JAXBContext jc = JAXBContext.newInstance("edu.xml.helpers");
            Unmarshaller unmarshaller = jc.createUnmarshaller();
            // unmarshaller.setValidating(true);

            Bibliotheque bibliotheque = (Bibliotheque) unmarshaller.unmarshal(file);

            livres = bibliotheque.getLivre();
        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }

    public boolean saveFile() {

    }

    public List<List<String>> getLivres() {
        List<List<String>> convertedLivres = new ArrayList<>();
        for (int i = 0; i < livres.size(); i++) {
            Livre livre = livres.get(i);
            List<String> convertedLivre = new ArrayList<>();
            convertedLivre.add(livre.getTitre());
            convertedLivre.add(livre.getAuteur().getNom());
            convertedLivre.add(livre.getAuteur().getPrenom());
            convertedLivre.add(livre.getPresentation());
            convertedLivre.add(String.valueOf(livre.getParution()));
            convertedLivre.add(String.valueOf(livre.getColonne()));
            convertedLivre.add(String.valueOf(livre.getRangee()));
            convertedLivres.add(convertedLivre);
        }
        return convertedLivres;
    }

    public List<String> getLivreByIndex(int index) {
        Livre livre = livres.get(index);
        List<String> convertedLivre = new ArrayList<>();
        convertedLivre.add(livre.getTitre());
        convertedLivre.add(livre.getAuteur().getNom());
        convertedLivre.add(livre.getAuteur().getPrenom());
        convertedLivre.add(livre.getPresentation());
        convertedLivre.add(String.valueOf(livre.getParution()));
        convertedLivre.add(String.valueOf(livre.getColonne()));
        convertedLivre.add(String.valueOf(livre.getRangee()));
        return convertedLivre;
    }

    public void addLivre(List<String> livre) {
        Livre newLivre = new Livre();
        Auteur newAuteur = new Auteur();
        newLivre.setTitre(livre.get(0));
        newAuteur.setNom(livre.get(1));
        newAuteur.setPrenom(livre.get(2));
        newLivre.setAuteur(newAuteur);
        newLivre.setPresentation(livre.get(3));
        newLivre.setParution(Integer.parseInt(livre.get(4)));
        newLivre.setColonne(Short.parseShort(livre.get(5)));
        newLivre.setRangee(Short.parseShort(livre.get(6)));
        livres.add(newLivre);
    }
}
