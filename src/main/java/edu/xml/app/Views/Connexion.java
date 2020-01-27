package edu.xml.app.Views;
import edu.xml.app.Model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.*;
import java.awt.*;

public class Connexion  extends JFrame {

    private JLabel user,password;
    private JTextField userField;
    private JTextField passwordField;
    private Container container;
    private JButton submit;


    public JTextField getUserField() {
        return userField;
    }

    public JTextField getPasswordField() {
        return passwordField;
    }

    public JButton getSubmit() {return submit;}

    public Connexion(){

        user=new JLabel("<html><div style='text-align:center;margin-left:40%;'>utilisateur</div></html>");
        password=new JLabel("<html><div style='text-align:center;margin-left:40%;'>Mot de passe</div></html>");
        userField=new JTextField();
        passwordField=new JTextField();
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








