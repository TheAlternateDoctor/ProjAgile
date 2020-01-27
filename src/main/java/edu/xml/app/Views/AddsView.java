package edu.xml.app.Views;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddsView extends JFrame {
    private JPanel panForm;
    private JButton apply;
    //Champs formulaire d'édition

    private JTextField sHolder=new JTextField();
    private JCheckBox isBorrowBox=new JCheckBox();
    private Object[] statusBoxValue = new Object[]{"Emprunter", "Acquis", "Posseder"};
    private JComboBox statusBox= new JComboBox(statusBoxValue);
    private JTextField sBook = new JTextField();
    private JTextField sRelease = new JTextField();
    private JTextField sAuthorName = new JTextField();
    private JTextField sAuthorFirstName = new JTextField();
    private JTextArea spresentation = new JTextArea(3, 3);
    private JTextField scol = new JTextField();
    private JTextField sLine = new JTextField();
    private JTextField sImage=new JTextField();

    public JTextField getsHolder() {  return sHolder; }

    public JCheckBox getIsBorrowBox() {  return isBorrowBox;  }

    public JComboBox getStatusBox() { return statusBox; }

    public JTextField getsBook() {  return sBook;  }

    public JTextField getsRelease() {  return sRelease; }

    public JTextField getsAuthorName() {  return sAuthorName;  }

    public JTextField getsAuthorFirstName() {    return sAuthorFirstName;  }


    public JTextArea getSpresentation() {   return spresentation; }

    public JTextField getScol() {     return scol;  }

    public JTextField getsLine() {   return sLine;  }

    public JTextField getsImage() {   return sImage; }

    public JButton getApply() { return apply; }


    public AddsView(){
        this.setSize(720,496);
        this.initComponent();
        this.setVisible(true);

    }
    private void initComponent(){
        panForm=new JPanel();
        panForm.setPreferredSize(new Dimension(300, 400));
        panForm.setBackground(Color.white);
        panForm.setBorder((BorderFactory.createTitledBorder("Nouveau livre")));
        // Label formulaire d'édition
        JLabel holderLabel=new JLabel("Possesseur:");
        JLabel isBorrowLabel=new JLabel("Emprunter");
        JLabel statusLabel=new JLabel("Status:");
        JLabel bookLabel = new JLabel("Titre : ");
        JLabel authorNameLabel = new JLabel("Nom ");
        JLabel authorFistNameLabel = new JLabel("Prenom");
        JLabel releaseLabel = new JLabel("Parution : ");
        JLabel presentationLabel = new JLabel("Présentation : ");
        JLabel colLabel = new JLabel("Colonne : ");
        JLabel lineLabel = new JLabel("Rangée : ");
        JLabel imageLabel=new JLabel("Url:");

        //Champs formulaire d'édition

        sHolder=new JTextField();
        isBorrowBox=new JCheckBox();
        statusBoxValue = new Object[]{"Emprunter", "Acquis", "Posseder"};
        statusBox= new JComboBox(statusBoxValue);
        sBook = new JTextField();
        sRelease = new JTextField();
        sAuthorName = new JTextField();
        sAuthorFirstName = new JTextField();

        spresentation = new JTextArea(3, 3);
        scol = new JTextField();
        sLine = new JTextField();
        sImage=new JTextField();
        apply = new JButton("Ajouter");

        Border border = BorderFactory.createLineBorder(Color.BLACK);

        spresentation.setBorder(border);



        Box bookBox = Box.createHorizontalBox();
        bookBox.setPreferredSize(new Dimension(200, 25));
        bookBox.add(bookLabel/* ,RIGHT_ALIGNMENT */);

        bookBox.add(sBook);

        Box authorNameBox = Box.createHorizontalBox();
        authorNameBox.setPreferredSize(new Dimension(100, 25));
        authorNameBox.add(authorNameLabel);
        authorNameBox.add(sAuthorName);

        Box authorFirstNameBox = Box.createHorizontalBox();
        authorFirstNameBox.setPreferredSize(new Dimension(100, 25));
        authorFirstNameBox.add(authorFistNameLabel);
        authorFirstNameBox.add(sAuthorFirstName);

        Box releaseBox = Box.createHorizontalBox();
        releaseBox.setPreferredSize(new Dimension(100, 25));
        releaseBox.add(releaseLabel);
        releaseBox.add(sRelease);

        Box BPresentation = Box.createHorizontalBox();
        BPresentation.setPreferredSize(new Dimension(100, 100));
        BPresentation.add(presentationLabel);
        BPresentation.add(spresentation);

        Box lineBox = Box.createHorizontalBox();
        lineBox.setPreferredSize(new Dimension(100, 25));
        lineBox.add(lineLabel);
        lineBox.add(sLine);
        Box colBox = Box.createHorizontalBox();
        colBox.setPreferredSize(new Dimension(100, 25));
        colBox.add(colLabel);
        colBox.add(scol);
        Box haut = Box.createVerticalBox();
        haut.add(holderLabel);
        haut.add(sHolder);
        haut.add(isBorrowLabel);
        haut.add(isBorrowBox);
        haut.add(statusLabel);
        haut.add(statusBox);
        haut.add(bookBox);
        haut.add(authorNameBox);
        haut.add(authorFirstNameBox);
        haut.add(releaseBox);
        haut.add(BPresentation);
        haut.add(lineBox);
        haut.add(colBox);
        haut.add(imageLabel);
        haut.add(sImage);
        haut.add(apply);
        panForm.add(haut);
        this.getContentPane().add(panForm);
        statusBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(String.valueOf(statusBox.getSelectedItem()) =="Emprunter"){
                    sHolder.setEditable(false);
                }
            }
        });




    }




}
