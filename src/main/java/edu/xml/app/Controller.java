package edu.xml.app;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class Controller {

    private View view;
    private Model model;
    private ActionListener actionListener;

    public Controller() {
        this.view = new View();
        this.model = new Model();

    }

    public void control(){

        view.getOpenfile().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                model.readFile(view.Openfile());
                view.table(model.getLivres());
            }
        });
        view.getEnd().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.quitter();
            }
        });
        view.getNewfile().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.newfile();
            }
        });
        view.getAdds().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("test");
                view.Ajouter();
            }
        });
        view.getConfirmer().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<String> Addlivres = new ArrayList();
               Addlivres.add(view.getSetTitre().getText());
               Addlivres.add(view.getSetNomAuteur().getText());
               Addlivres.add(view.getSetPrenomAuteur().getText());
               Addlivres.add(view.getSetPresentation().getText());
               Addlivres.add(view.getSetParution().getText());
               model.addLivre(Addlivres);
               model.saveFile();
               String[] donnees = {view.getSetTitre().getText(),view.getSetNomAuteur().getText()+" "+view.getSetPrenomAuteur().getText(),view.getSetPresentation().getText(),view.getSetParution().getText()};
               view.addTable(donnees);

                                           }
        });
        view.getDelete().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.removeLivre(view.supprimer());
                view.removeTable(view.supprimer());
                model.saveFile();
            }
        });

    }

}
