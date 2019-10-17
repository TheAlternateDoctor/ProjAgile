package app;

import javax.swing.*;
import java.awt.*;

public class View extends JFrame { // Mainwindow

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
    private JMenuItem Newfile;
    private JMenuItem Openfile;

    // Affichage fichier xml //
    private JTable table;

    private JFrame Details;
    private JButton adds;
    private JButton delete;
    ////////////////////////////////////////////////////
    // addFrame
    private JFrame adFileFrame;
    private Container containerOpen;
    private JLabel textTest;

    public View() throws HeadlessException {
        // Création de la fenêtre vide

        mainWindow = new JFrame("Agile");
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWindow.setSize(800, 400);
        container = new Container();
        container.setLayout(new GridLayout(6, 1));

        // Menu principale
        Bar = new JMenuBar();
        // Premier sous menu
        Fichier = new JMenu("Fichier");
        Openfile = new JMenuItem("Ouvrir");
        Newfile = new JMenuItem("Nouveau");
        Fichier.add(Newfile);
        Fichier.add(Openfile);
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

        mainWindow.getContentPane().add(container);
        this.mainWindow.setVisible(true);
    }

    public JMenuItem getNewfile() {
        return Newfile;
    }

    public void setNewfile(JMenuItem newfile) {
        Newfile = newfile;
    }

    public void Openfile() {

        adFileFrame = new JFrame("Nouveau fichier");
        adFileFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        adFileFrame.setSize(400, 200);

        containerOpen = new Container();
        containerOpen.setLayout(new GridLayout(6, 1));
        textTest = new JLabel("TEST");
        containerOpen.add(textTest);

        adFileFrame.getContentPane().add(containerOpen);
        adFileFrame.setVisible(true);

    }
}
