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
    private Boolean authLevel;


    private AuthController() {
       this.authLevel=false;
        this.connexion=new Connexion();
        this.model = new Model();
        auth();
    }
        private static AuthController INSTANCE= null;

        public static synchronized AuthController getInstance(){
            if (INSTANCE==null)
            {
                INSTANCE=new AuthController();
            }
            return INSTANCE;
        }

        public void auth(){
            //authLevel=false;

            connexion.getSubmit().addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(model.logIn(connexion.getUserField().getText(),connexion.getPasswordField().getText())==true){
                      if(model.getLevel()==0 || model.getLevel()==1 )
                        {


                            setAuthLevel(false);
                            System.out.println(model.getLevel());
                            controller=new Controller();
                            connexion.setVisible(false);
                        }
                        else if (model.getLevel()==-1)
                        {

                            System.out.println(model.getLevel());
                            authLevel=true;
                            controller=new Controller();



                            connexion.setVisible(false);

                        }
                    }
                    else{
                        JOptionPane badAuth = new JOptionPane();
                        badAuth.showMessageDialog(null, "identifiants incorrect", "Erreur d'authentification", JOptionPane.ERROR_MESSAGE);
                    }
                }
            });

        }
//Getteurs & Setteurs


    public void setAuthLevel(Boolean authLevel) {
        this.authLevel = authLevel;
    }

    public Boolean getAuthLevel(){return authLevel;}





}
