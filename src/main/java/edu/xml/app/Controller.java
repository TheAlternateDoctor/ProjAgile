package edu.xml.app;

import edu.xml.app.Views.AddsView;
import edu.xml.app.Views.Connexion;
import edu.xml.app.Views.MainView;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class Controller {


    private Model model;
    private MainView mainview;

    AddsView adsBook;


    public Controller(){
        this.model=new Model();
        this.mainview=new MainView();

        mainview.getOpenFile().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.readFile(mainview.OpenfileButton());
                mainview.table(model.getLivres());
            }
        });
        mainview.getNewFile().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
             mainview.newFileButton();
            }
        });
        mainview.getAdds().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adsBook=new AddsView();
                adsBook.getApply().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        int col=Integer.parseInt(adsBook.getScol().getText());
                        int row=Integer.parseInt(adsBook.getsLine().getText());

                        if(row > 5) {
                            System.out.println("Erreur la ligne rentrée est trop grande");
                        }
                        else if(col >5 ){
                                System.out.println("Erreur la ligne rentrée est trop grande");
                            }
                        else{

                            if(adsBook.getsBook().getText() != ""){
                                if(adsBook.getsRelease().getText() !=""){
                                    if(adsBook.getsAuthorName().getText() != ""){
                                        if(adsBook.getsAuthorName().getText() != ""){
                                            List<String> Addlivres = new ArrayList<>();

                                            Addlivres.add(adsBook.getsBook().getText());
                                            Addlivres.add(adsBook.getsAuthorName().getText());
                                            Addlivres.add(adsBook.getsAuthorFirstName().getText());
                                            Addlivres.add(adsBook.getSpresentation().getText());
                                            Addlivres.add(adsBook.getsRelease().getText());
                                            Addlivres.add(adsBook.getsLine().getText());
                                            Addlivres.add(adsBook.getScol().getText());
                                            Addlivres.add(adsBook.getsImage().getText());
                                            Addlivres.add(String.valueOf(adsBook.getStatusBox().getSelectedItem()));
                                            Addlivres.add(adsBook.getsHolder().getText());
                                            System.out.println(Addlivres);
                                            model.addLivre(Addlivres);
                                            String[] donnees = {
                                                adsBook.getsBook().getText(),
                                                adsBook.getsAuthorName().getText()+ " "+adsBook.getsAuthorFirstName().getText(),
                                                adsBook.getSpresentation().getText(),
                                                adsBook.getsRelease().getText(),adsBook.getsLine().getText(),adsBook.getScol().getText(),
                                                adsBook.getsImage().getText(),String.valueOf(adsBook.getStatusBox().getSelectedItem()),adsBook.getsHolder().getText()};
                                            mainview.addTable(donnees);
                                            adsBook.dispose();

                                        }
                                        }
                                    }
                                }
                            }
                    }
                });
            }
        });
        mainview.getSave().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.saveFile();

            }
        });
        mainview.editForm();
        mainview.getDelete().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.removeLivre(mainview.supprimer());
                mainview.removeTable(mainview.supprimer());
            }
        });
        mainview.getExportToDocx().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.exportTo(mainview.OpenfileButton());
            }
        });


    }


}
