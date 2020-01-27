package edu.xml.app.Views;
import java.io.*;
import javax.swing.*;
import java.awt.*;

public class Connexion  extends JFrame {

    private JLabel user,password;
    private JTextField userField;
    private JPasswordField passwordField;
    private Container container;
    private JButton submit;

    String userConnect[] = new String[2];
    private int i= 0;

    public JButton getSubmit() {return submit;}

    Connexion(){

        user=new JLabel("<html><div style='text-align:center;margin-left:40%;'>utilisateur</div></html>");
        password=new JLabel("<html><div style='text-align:center;margin-left:40%;'>Mot de passe</div></html>");
        userField=new JTextField();
        passwordField=new JPasswordField();
        container=new Container();
        submit=new JButton("Se connecter ");
        container.add(user);
        container.add(userField);
        container.add(password);
        container.add(passwordField);
        container.add(submit);
        container.setLayout(new GridLayout(5,1));
        this.setSize(300    ,300);
        this.getContentPane().add(container);
        this.setVisible(true);
    }



}





