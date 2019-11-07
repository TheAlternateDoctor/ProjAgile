package edu.xml.app;

import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class Controller {

    private View view;
    private Model model;

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
        view.getSave().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.saveFile();
            }
        });
        view.getSaveAs().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.saveFile(view.Openfile());
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
                List<String> Addlivres = new ArrayList<>();
               Addlivres.add(view.getSetTitre().getText());
               Addlivres.add(view.getSetNomAuteur().getText());
               Addlivres.add(view.getSetPrenomAuteur().getText());
               Addlivres.add(view.getSetPresentation().getText());
               Addlivres.add(view.getSetParution().getText());
               Addlivres.add(view.getSetRangee().getText());
               Addlivres.add(view.getSetcol().getText());
               Addlivres.add(view.getTypeEmprunt().getName());
               Addlivres.add(view.getSetUrlImg().getText());
               model.addLivre(Addlivres);
               String[] donnees = {view.getSetTitre().getText(),view.getSetNomAuteur().getText()+" "+view.getSetPrenomAuteur().getText(),view.getSetPresentation().getText(),view.getSetParution().getText(),view.getSetRangee().getText(),view.getSetcol().getText(),view.getTypeEmprunt().getName(),view.getSetUrlImg().getText()};
               view.addTable(donnees);
               view.addIMG(view.getSetUrlImg().getText());


                                           }
        });
        view.getDelete().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.removeLivre(view.supprimer());
                view.removeTable(view.supprimer());
            }
        });
        view.updateIMG();
        view.getApply().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.modifyLivre(view.getTableau().getSelectedRow(),view.modifyView());

            }
        });
    }


}
