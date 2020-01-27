package edu.xml.app;

import edu.xml.app.Views.Connexion;
import edu.xml.app.Views.MainView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AuthController {
    private Connexion connexion;
    private Model model;
    private Controller controller;//controlleur de la main Windows

    public AuthController() {

        this.connexion=new Connexion();
        this.model = new Model();


    }
    public void auth(){
        connexion.getSubmit().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(model.logIn(connexion.getUserField().getText(),connexion.getPasswordField().getText())==true){
                    controller=new Controller();
                }
                else{
                    JOptionPane badAuth = new JOptionPane();
                    badAuth.showMessageDialog(null, "identifiants incorrect", "Erreur d'authentification", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

}
