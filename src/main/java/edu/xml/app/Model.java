package edu.xml.app;
import edu.xml.helpers.Bibliotheque;
import edu.xml.helpers.Bibliotheque.Livre;
import edu.xml.helpers.Bibliotheque.Livre.Auteur;
import edu.xml.helpers.ObjectFactory;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Model {

/*
    Index:
    Titre
    Nom
    Prenom
    Présentation
    Parution
    Colonne
    Rangee
    Pret
    Acquis
    Nom Acquis
    Img_Url
*/

    private List<Livre> livres;
    private String filepath;
    private String filename;
    private Bibliotheque bibliotheque;

    public Model() {
    }

    public void exportTo(String filepath){
        ModelWord model = new ModelWord(bibliotheque,filename);
        model.buildModel();
        model.exportModel(filepath);
    }

    public void readFile(String filepath) {
        try {
            this.filepath = filepath;
            File file = new File(filepath);
            filename = file.getName();
            if (file.exists() && filepath != "") {
                JAXBContext jc = JAXBContext.newInstance("edu.xml.helpers");
                Unmarshaller unmarshaller = jc.createUnmarshaller();
                // unmarshaller.setValidating(true);

                bibliotheque = (Bibliotheque) unmarshaller.unmarshal(file);

                livres = bibliotheque.getLivre();
            } else {
                ObjectFactory objFactory = new ObjectFactory();
                bibliotheque = (Bibliotheque) objFactory.createBibliotheque();
                livres = bibliotheque.getLivre();
            }
        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }

    public boolean saveFile() {
        JAXBContext jaxbContext;
        try {
            jaxbContext = JAXBContext.newInstance("edu.xml.helpers");
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, new Boolean(true));
            marshaller.marshal(bibliotheque, new File(filepath));
            return true;
        } catch (JAXBException e) {
            e.printStackTrace();
            return false;
        }
    }


    public boolean saveFile(String filepath) {
        JAXBContext jaxbContext;
        try {
            jaxbContext = JAXBContext.newInstance("edu.xml.helpers");
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, new Boolean(true));
            marshaller.marshal(bibliotheque, new File(filepath));
            return true;
        } catch (JAXBException e) {
            e.printStackTrace();
            return false;
        }
    }

    public String[][] getLivres() {
        String[][] convertedLivres = new String[livres.size()][9];
        for (int i = 0; i < livres.size(); i++) {
            Livre livre = livres.get(i);
            convertedLivres[i][0] = livre.getTitre();
            convertedLivres[i][1] = livre.getAuteur().getNom() + " " + livre.getAuteur().getPrenom()  ;
            convertedLivres[i][2] = livre.getPresentation();
            convertedLivres[i][3] = String.valueOf(livre.getParution());
            convertedLivres[i][4] = String.valueOf(livre.getColonne());
            convertedLivres[i][5] = String.valueOf(livre.getRangee());

            convertedLivres[i][6] = livre.getImgUrl();
            convertedLivres[i][7] = livre.getAcquis();
            convertedLivres[i][8] = livre.getNomAcquis();


            convertedLivres[i][6] = livre.getAcquis();
            convertedLivres[i][7] = livre.getNomAcquis();
            convertedLivres[i][8] = livre.getImgUrl();


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
        convertedLivre.add(String.valueOf(livre.isPret()));
        convertedLivre.add(livre.getAcquis());
        convertedLivre.add(livre.getNomAcquis());
        convertedLivre.add(livre.getImgUrl());
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
        newLivre.setColonne(Short.parseShort(livre.get(6)));
        newLivre.setRangee(Short.parseShort((livre.get(5))));
        newLivre.setImgUrl(livre.get(7));
        if(livre.get(8).equals("Emprunter")){
            newLivre.setPret(true);
        }
        else{
            newLivre.setPret(false);
        }

        newLivre.setAcquis(livre.get(8));


        newLivre.setNomAcquis(livre.get(9));


        newLivre.setNomAcquis(livre.get(9));
        newLivre.setImgUrl(livre.get(8));

        livres.add(newLivre);
    }


    public void modifyLivre(int index, List<String> livre) {

        Livre newLivre = new Livre();
        Auteur newAuteur = new Auteur();
        newLivre.setTitre(livre.get(0));

        newAuteur.setNom(livre.get(1));
        newAuteur.setPrenom(" ");
        newLivre.setAuteur(newAuteur);

        newLivre.setPresentation(livre.get(2));

        newLivre.setParution(Integer.parseInt(livre.get(3)));

        newLivre.setColonne(Short.parseShort(livre.get(4)));
        newLivre.setRangee(Short.parseShort(livre.get(5)));
        newLivre.setImgUrl(livre.get(6));
        newLivre.setNomAcquis(livre.get(7));

        newLivre.setAcquis(" ");

        livres.set(index, newLivre);
    }

    public void removeLivre(int index) {

        livres.remove(livres.get(index));
    }
}
