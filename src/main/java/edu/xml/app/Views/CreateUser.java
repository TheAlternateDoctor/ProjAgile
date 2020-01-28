package edu.xml.app.Views;

import edu.xml.app.Model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class CreateUser extends JFrame {
    private JLabel username;
    private JLabel password;
    private JTextField usernameField;
    private JTextField passwordField;
    private Container container;
    private JButton submit;
    private Model model;

public CreateUser(){
    model=new Model();
    username=new JLabel("<html><div style='text-align:center;margin-left:40%;'>Nouveau nom d'utilisateur</div></html>");
    password=new JLabel("<html><div style='text-align:center;margin-left:40%;'>Nouveau mot de passe</div></html>");
    usernameField=new JTextField();
    passwordField=new JTextField();
    container=new Container();
    submit=new JButton("Se connecter ");
    container.add(username);
    container.add(usernameField);
    container.add(password);
    container.add(passwordField);
    container.add(submit);
    container.setLayout(new GridLayout(5,1));
    this.setSize(300    ,300);
    this.getContentPane().add(container);
    this.setVisible(true);

    submit.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {


        }
    });
}





}
