package edu.xml.app;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.lang.reflect.Array;

public class View extends JFrame { // Mainwindow
    // Attribut
    private JFrame mainWindow;

    private Container container;
    // Menu principale //
    private JMenu Fichier;
    private JMenu Menusave;
    private JMenu About;
    private JMenuItem shortdesc;
    private JMenuBar Bar;
    private JMenuItem save;
    private JMenuItem saveas;
    private JMenuItem End;
    private JMenuItem Newfile;
    private JMenuItem Openfile;

    // Affichage fichier xml //
    private JTable table;

    enum Sport {
        FOOTBALL, NATATION, RIEN, TENNIS;
    }

    private JFrame Details;
    private JButton adds;
    private JButton delete;

    // addFrame
    private JFrame adFileFrame;
    private Container containerOpen;
    private JLabel textTest;
    /////////////////////////////////////////

    // méthode

    public View() throws HeadlessException {
        // Création de la fenêtre vide

        mainWindow = new JFrame("Agile");

        mainWindow.setSize(800, 400);
        container = new Container();
        container.setLayout(new GridLayout(6, 6));

        // Menu principale
        Bar = new JMenuBar();
        // Premier sous menu
        Fichier = new JMenu("Fichier");
        Openfile = new JMenuItem("Ouvrir");
        Newfile = new JMenuItem("Nouveau");
        End = new JMenuItem("Quitter");

        Fichier.add(Newfile);
        Fichier.add(Openfile);
        Fichier.add(End);
        Bar.add(Fichier);

        // Second sous menu
        Menusave = new JMenu("Edition");
        save = new JMenuItem("Enregistrer");
        saveas = new JMenuItem("Enregistrer sous");
        Menusave.add(save);
        Menusave.add(saveas);
        Bar.add(Menusave);

        // Troisième sous menu
        About = new JMenu("A propos");
        shortdesc = new JMenuItem("Qui sommes nous ?");
        About.add(shortdesc);
        Bar.add(About);

        container.add(Bar);
        // Menu haut
        // Bouttons ajouter/supprimer
        adds = new JButton("+");
        delete = new JButton("-");
        adds.setPreferredSize(new Dimension(40, 40));
        delete.setPreferredSize(new Dimension(40, 40));
        mainWindow.getContentPane().add(container, BorderLayout.NORTH);
        table();
        Container containerButton = new Container();
        containerButton.setLayout(new GridLayout(1, 2));
        containerButton.add(adds);
        containerButton.add(delete);
        mainWindow.getContentPane().add(containerButton, BorderLayout.SOUTH);

        // Print
        this.mainWindow.setVisible(true);
    }

    public JMenuItem getEnd() {
        return End;
    }

    public JMenuItem getOpenfile() {
        return Openfile;
    }

    public JMenuItem getNewfile() {
        return Newfile;
    }

    public JButton getAdds() {
        return adds;
    };

    public String Openfile() {

        adFileFrame = new JFrame("Nouveau fichier");
        adFileFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        adFileFrame.setSize(400, 200);

        containerOpen = new Container();
        containerOpen.setLayout(new GridLayout(1, 1));
        final JFileChooser fc = new JFileChooser();

        FileNameExtensionFilter filter = new FileNameExtensionFilter("Fichier XML", "xml");
        fc.setFileFilter(filter);
        int returnVal = fc.showOpenDialog(getParent());

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            System.out.println("You chose to open this file: " + fc.getSelectedFile().getName());
        }

        containerOpen.add(fc);

        adFileFrame.getContentPane().add(containerOpen);
        adFileFrame.setVisible(true);
        table();
        return fc.getSelectedFile().getName();
    }

    public void newfile() {
        // Tableau XML
        final String[] entetes = { "Titre", "Auteur", "presentation", "parution" };

        Object[][] donnees = { { "", "", "", "" }, { "", "", "", "" }, { "", "", "", "" }, { "", "", "", "" }, };

        JTable tableau = new JTable(donnees, entetes);

        System.out.println("Debug");
        container.add(tableau.getTableHeader());
        container.add(tableau);
        mainWindow.getContentPane().add(container, BorderLayout.CENTER);
        SwingUtilities.updateComponentTreeUI(mainWindow);

    }

    public void table() {

    }

    public void quitter() {

        mainWindow.setVisible(false);
        mainWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

    public void Ajouter() {
        Details = new JFrame("Ajouter");

        Details.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Details.setSize(400, 600);
        JLabel Titre = new JLabel("Titre");
        JLabel Auteur = new JLabel("Auteur");
        JLabel Annee = new JLabel("Année");

        JTextField setTitre = new JTextField();
        JTextField setAuteur = new JTextField();
        JTextField setAnnee = new JTextField();
        Container containAjouter = new Container();
        containAjouter.setLayout(new GridLayout(4, 2));
        containAjouter.add(Titre);
        containAjouter.add(setTitre);
        containAjouter.add(Auteur);
        containAjouter.add(setAuteur);

        Details.getContentPane().add(containAjouter);
        Details.setVisible(true);

    }
}
