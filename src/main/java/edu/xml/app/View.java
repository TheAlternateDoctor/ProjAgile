package edu.xml.app;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.lang.reflect.Array;

public class View extends JFrame { // Mainwindow
    // Attribut
    private JFrame mainWindow;
    private Container tableContainer;
    private Container container;
    // Menu principale //
    private JMenu Fichier;
    private JMenu Menusave;
    private JMenu About;
    private JMenuItem shortdesc;
    private  JButton Confirmer;
    private JMenuBar Bar;
    private JMenuItem save;
    private JMenuItem saveas;
    private JMenuItem End;
    private JMenuItem Newfile;
    private JMenuItem Openfile;
    private JTable tableau;
    private JTextField setTitre;
    private JTextField setNomAuteur;
    private JTextField setPrenomAuteur;
    private JTextField setPresentation;
    private JTextField setParution;
    private JTextField setRangee;
    private JTextField setcol;

    // Affichage fichier xml //
    private JTable table;



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
        container.setLayout(new BorderLayout(6, 3));
        container.setSize(580,250);
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

        Container containerButton = new Container();
        containerButton.setLayout(new GridLayout(1, 2));
        containerButton.add(adds);
        containerButton.add(delete);
        mainWindow.getContentPane().add(containerButton, BorderLayout.SOUTH);
         Confirmer=new JButton("Confirmer");
        // Print
        this.mainWindow.setVisible(true);
    }

    public JMenuItem getEnd() {
        return End;
    }

    public JButton getConfirmer() {
        return Confirmer;
    }

    public JFrame getMainWindow() {
        return mainWindow;
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


        return fc.getSelectedFile().getAbsolutePath();
    }

    public JTextField getSetRangee() {
        return setRangee;
    }

    public JTextField getSetcol() {
        return setcol;
    }

    public JTextField getSetTitre() {
        return setTitre;
    }

    public JTextField getSetAuteur() {
        return setNomAuteur;
    }

    public JTextField getSetNomAuteur() {
        return setNomAuteur;
    }

    public JTextField getSetPrenomAuteur() {
        return setPrenomAuteur;
    }

    public JTextField getSetPresentation() {
        return setPresentation;
    }

    public JTextField getSetParution() {
        return setParution;
    }

    public JButton getDelete() {
        return delete;
    }

    public void newfile() {
        // Tableau XML
        final String[] entetes = { "Titre", "Auteur", "presentation", "parution","rangée","colonne" };
        Object[][] donnees = { { "", "", "", "","","" }, { "", "", "", "","","" }, { "", "", "", "","","" }, { "", "", "", "","","" }};
        JTable tableau = new JTable(donnees, entetes);
        Container tableContainer=new Container();
        System.out.println("Debug");
        Container ContainerNewTable=new Container();
       ContainerNewTable.setLayout(new GridLayout(2,4));

       ContainerNewTable.add(tableau.getTableHeader());
        JScrollPane pane2=new JScrollPane(tableau);
       container.add(ContainerNewTable);
       container.add(pane2);
       mainWindow.getContentPane().add(container);
        SwingUtilities.updateComponentTreeUI(mainWindow);
System.out.println("Debug");
    }

    public void table(String[][] donnees) {
        // Tableau XML
        final String[] entetes = { "Titre", "Auteur", "presentation", "parution","rangée","colonne" };
        tableau = new JTable();
       DefaultTableModel tableModel = (DefaultTableModel) tableau.getModel();
       tableModel.setColumnIdentifiers(entetes);
       for(int i = 0;i<donnees.length;i++){
           tableModel.addRow(donnees[i]);
       }
       JScrollPane pane=new JScrollPane(tableau);


        container.add(pane);
        mainWindow.getContentPane().add(container,BorderLayout.NORTH);
        SwingUtilities.updateComponentTreeUI(mainWindow);
    }
    public void addTable(String[] donnees){

        DefaultTableModel tableModel = (DefaultTableModel) tableau.getModel();
        tableModel.addRow(donnees);
        tableModel.fireTableDataChanged();
    }

    public void removeTable(int index){

        DefaultTableModel tableModel = (DefaultTableModel) tableau.getModel();
        tableModel.removeRow(index);
        tableModel.fireTableDataChanged();
    }
    public int supprimer(){
        return tableau.getSelectedRow();
            }
    public void quitter() {

        mainWindow.setVisible(false);
        mainWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

    public void Ajouter() {
        Details = new JFrame("Ajouter");

        Details.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Details.setSize(400, 600);
        JLabel Titre = new JLabel("Titre");
        JLabel Auteur = new JLabel("Nom Auteur");
        JLabel AuteurPrenom=new JLabel("Prenom Auteur");
        JLabel Presentation = new JLabel("Presentation");
        JLabel Parution =new JLabel("Parution");
        JLabel rangeeLabel=new JLabel("rangée");
        JLabel colLabel=new JLabel("colonne");
       setTitre = new JTextField();
       setNomAuteur = new JTextField();
       setPrenomAuteur=new JTextField();
       setPresentation = new JTextField();
       setParution=new JTextField();
       setRangee=new JTextField();
       setcol=new JTextField();
        Container containAjouter = new Container();
        containAjouter.setLayout(new GridLayout(8, 2));
        containAjouter.add(Titre);
        containAjouter.add(setTitre);
        containAjouter.add(Auteur);

        containAjouter.add(setNomAuteur);
        containAjouter.add(AuteurPrenom);
        containAjouter.add(setPrenomAuteur);
        containAjouter.add(Presentation);
        containAjouter.add(setPresentation);
        containAjouter.add(Parution);
        containAjouter.add(setParution);
        containAjouter.add(rangeeLabel);
        containAjouter.add(setRangee);
        containAjouter.add(colLabel);
        containAjouter.add(setcol);
        containAjouter.add(Confirmer);



        Details.getContentPane().add(containAjouter);
        Details.setVisible(true);



    }
}
