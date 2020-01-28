/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.xml.app;

import edu.xml.helpers.Bibliotheque;
import edu.xml.helpers.Bibliotheque.Livre;
import edu.xml.helpers.ObjectFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author mathys
 */
public class ModelFile {
    
    private int userLevel;
    private String filepath;
    private String filename;
    
    public ModelFile(int userLevel){
        this.userLevel = userLevel;
    }
    
    public Bibliotheque readFile(String filepath) {
        try {
            Bibliotheque bibliotheque;
            this.filepath = filepath;
            File file = new File(filepath);
            filename = file.getName();
            if (file.exists() && filepath != "") {
                JAXBContext jc = JAXBContext.newInstance("edu.xml.helpers");
                Unmarshaller unmarshaller = jc.createUnmarshaller();
                // unmarshaller.setValidating(true);

                bibliotheque = (Bibliotheque) unmarshaller.unmarshal(file);
            } else {
                ObjectFactory objFactory = new ObjectFactory();
                bibliotheque = (Bibliotheque) objFactory.createBibliotheque();
            }
            return bibliotheque;
        } catch (Exception e) {
            e.printStackTrace();
        }
        ObjectFactory objFactory = new ObjectFactory();
        return (Bibliotheque) objFactory.createBibliotheque();
    }

    public boolean saveFile(Bibliotheque biblio) {
        JAXBContext jaxbContext;
        try {
            jaxbContext = JAXBContext.newInstance("edu.xml.helpers");
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, new Boolean(true));
            marshaller.marshal(biblio, new File(filepath));
            return true;
        } catch (JAXBException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean saveFile(String filepath, Bibliotheque biblio) {
        JAXBContext jaxbContext;
        try {
            jaxbContext = JAXBContext.newInstance("edu.xml.helpers");
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, new Boolean(true));
            marshaller.marshal(biblio, new File(filepath));
            return true;
        } catch (JAXBException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public void exportTo(String filepath, Bibliotheque biblio) {
        ModelWord model = new ModelWord(biblio, filename);
        model.buildModel();
        model.exportModel(filepath);
    }
}
