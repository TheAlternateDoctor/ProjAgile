package edu.xml.app;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.Integer.parseInt;

public class View extends JFrame { // Mainwindow
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    // Attribut
    private JFrame mainWindow;
    private Container container;
    private Container leftContainer;
    // Menu principale //
    private JMenu Fichier;
    private JMenu Menusave;
    private JMenu About;
    private JMenuItem shortdesc;
    private  JButton Confirmer;
    private JMenuBar Bar;
    private JMenuItem Export;
    private JMenuItem save;
    private JMenuItem saveas;
    private JMenuItem End;
    private JMenuItem Newfile;
    private JMenuItem Openfile;
    private JTable tableau=new JTable();
    private JTextField setTitre;
    private JTextField setNomAuteur;
    private JTextField setPrenomAuteur;
    private JTextField setPresentation;
    private JTextField setParution;
    private JTextField setRangee;
    private JTextField setcol;
    private JComboBox typeEmprunt;
    private JTextField setUrlImg;
    private JLabel imageLabel;

    public JButton getApply() {
        return apply;
    }

    // Gestion images
    private ImageIcon icone;
    private JLabel image;
    private JTextField sUrl;
    private JPanel panIMG;
    public static long count = 0;

    public JTextField getSetUrlImg() {
        return setUrlImg;
    }

    public JComboBox getTypeEmprunt() {
        return typeEmprunt;
    }

    public JTable getTableau() {
        return tableau;
    }

    // Affichage fichier xml //




    private JFrame Details;
    private JButton adds;
    private JButton delete;
    // addFrame

    private Container containerOpen;

    //
    private JLabel presentationLabel,rangeeLabel,livreLabel,parutionLabel,nomAuteurLabel,prenomAuteurLabel,colonneLabel;
    private JTextField slivre,sparution,sauteurnom,sauteurprenom,srangee,scolonne;
    private JTextArea spresentation;
    JButton apply;

    /////////////////////////////////////////
    // méthode

    public View() throws HeadlessException {


        mainWindow = new JFrame("Agile");
       mainWindow.setSize(800,800);
        leftContainer=new Container();
        leftContainer.setLayout(new BorderLayout(9,9));
        container = new Container();
        container.setLayout(new BorderLayout(9, 9));

        // Menu principale
        Bar = new JMenuBar();
        // Premier sous menu
        Fichier = new JMenu("Fichier");
        Export=new JMenuItem("Export en docx");
        Openfile = new JMenuItem("Ouvrir");
        Newfile = new JMenuItem("Nouveau");

        End = new JMenuItem("Quitter");

        Fichier.add(Newfile);
        Fichier.add(Openfile);
        Fichier.add(Export);
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

        container.add(Bar,BorderLayout.NORTH);

        // Menu haut
        // Bouttons ajouter/supprimer
        adds = new JButton("<html><span style='color:green;border:1px solid black'>+</span></html>");
        delete = new JButton("<html><span style='color:red '>-</span></html>");
        //adds.setPreferredSize(new Dimension(5, 5));

        //delete.setPreferredSize(new Dimension(5, 5));
        mainWindow.getContentPane().add(container, BorderLayout.WEST);
        JPanel containerButton = new JPanel();
        //GridLayout g2=new GridLayout(1, 2);
       // g2.setHgap(10);
        //g2.setVgap(5);
        //containerButton.setLayout(g2);
        containerButton.add(adds, BorderLayout.CENTER);
        containerButton.add(delete,BorderLayout.CENTER);
        containerButton.setPreferredSize(new Dimension(10,50));
        // affichage formulaire
        JPanel panForm = new JPanel();
        panForm.setPreferredSize(new Dimension(300, 400));
        panForm.setBackground(Color.white);

        panForm.setBorder((BorderFactory.createTitledBorder("Formulaire d'interaction")));

        livreLabel = new JLabel("Titre : ");
        parutionLabel = new JLabel("Parution : ");
        nomAuteurLabel = new JLabel("Nom ");
        prenomAuteurLabel = new JLabel("Prenom");
        rangeeLabel = new JLabel("Rangée : ");
        presentationLabel = new JLabel("Présentation : ");
        colonneLabel = new JLabel("Colonne : ");
        imageLabel=new JLabel("Url:");
        slivre = new JTextField();
        sparution = new JTextField();
        sauteurnom = new JTextField();
        sauteurprenom = new JTextField();
        srangee = new JTextField();
        sUrl=new JTextField();


        Border border = BorderFactory.createLineBorder(Color.BLACK);

        spresentation = new JTextArea(3, 3);
        spresentation.setBorder(border);
        scolonne = new JTextField();
        Object[] elements = new Object[]{"Pret", "Acquis", "preter"};
        typeEmprunt= new JComboBox(elements);

        Box BLivre = Box.createHorizontalBox();
        BLivre.setPreferredSize(new Dimension(200, 25));
        BLivre.add(livreLabel/* ,RIGHT_ALIGNMENT */);

        BLivre.add(slivre);

        Box BAuteurNom = Box.createHorizontalBox();
        BAuteurNom.setPreferredSize(new Dimension(100, 25));
        BAuteurNom.add(nomAuteurLabel);
        BAuteurNom.add(sauteurnom);

        Box BAuteurPrenom = Box.createHorizontalBox();
        BAuteurPrenom.setPreferredSize(new Dimension(100, 25));
        BAuteurPrenom.add(prenomAuteurLabel);
        BAuteurPrenom.add(sauteurprenom);

        Box BAnnee = Box.createHorizontalBox();
        BAnnee.setPreferredSize(new Dimension(100, 25));
        BAnnee.add(parutionLabel);
        BAnnee.add(sparution);

        Box BPresentation = Box.createHorizontalBox();
        BPresentation.setPreferredSize(new Dimension(100, 100));
        BPresentation.add(presentationLabel);
        BPresentation.add(spresentation);

        Box BRangee = Box.createHorizontalBox();
        BRangee.setPreferredSize(new Dimension(100, 25));
        BRangee.add(rangeeLabel);
        BRangee.add(srangee);
        Box BColonne = Box.createHorizontalBox();
        BColonne.setPreferredSize(new Dimension(100, 25));
        BColonne.add(colonneLabel);
        BColonne.add(scolonne);

        apply = new JButton("Appliquer");


        Box haut = Box.createVerticalBox();

        haut.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel Possesseur=new JLabel("Possesseur");

        JLabel Status=new JLabel("Status:");
        haut.add(Status);
        haut.add(typeEmprunt);
        haut.add(BLivre);
        haut.add(BAuteurNom);
        haut.add(BAuteurPrenom);
        haut.add(BAnnee);
        haut.add(BPresentation);
        haut.add(BColonne);
        haut.add(BRangee);
        haut.add(imageLabel);
        haut.add(sUrl);
        haut.add(apply);

        panForm.add(haut);
        mainWindow.getContentPane().add(panForm,BorderLayout.EAST);
        mainWindow.getContentPane().add(containerButton,BorderLayout.SOUTH);
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

    public JMenuItem getSave() {
        return save;
    }

    public JMenuItem getSaveAs() {
        return saveas;
    }

    public JMenuItem getExport() {
        return Export;
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
    public String OpenfileDocx() {
        containerOpen = new Container();
        containerOpen.setLayout(new GridLayout(1, 1));
        final JFileChooser fc = new JFileChooser();

        FileNameExtensionFilter filter = new FileNameExtensionFilter("Fichier DOCX", "docx");
        fc.setFileFilter(filter);
        int returnVal = fc.showOpenDialog(getParent());

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            System.out.println("You chose to open this file: " + fc.getSelectedFile().getName());
        }

        containerOpen.add(fc);

        return fc.getSelectedFile().getAbsolutePath();
    }

    public JTextField getSetRangee() { return setRangee;  }

    public JTextField getSetcol() {  return setcol; }

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
       tableau = new JTable(donnees, entetes);
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
        final String[] entetes = { "Titre", "Auteur", "presentation", "parution","rangée","colonne","Urlimg","Status" };

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
        JLabel imgLabel=new JLabel("adresse de l'image");
        JLabel Titre = new JLabel("Titre");
        JLabel Auteur = new JLabel("Nom Auteur");
        JLabel AuteurPrenom=new JLabel("Prenom Auteur");
        JLabel Presentation = new JLabel("Presentation");
        JLabel Parution =new JLabel("Parution");
        JLabel rangeeLabel=new JLabel("rangée");
        JLabel colLabel=new JLabel("colonne");
        JLabel typeLabel=new JLabel("Type");
       setTitre = new JTextField();
       setNomAuteur = new JTextField();
       setPrenomAuteur=new JTextField();
       setPresentation = new JTextField();
       setParution=new JTextField();
       setRangee=new JTextField();
       setcol=new JTextField();

        Object[] elements = new Object[]{"Pret", "Acquis", "preter"};
        typeEmprunt= new JComboBox(elements);
        Container containAjouter = new Container();
        containAjouter.setLayout(new BorderLayout());
        containAjouter.setLayout(new GridLayout(11, 2));
        containAjouter.add(typeLabel);
        containAjouter.add(typeEmprunt);
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
        containAjouter.add(imgLabel);
        setUrlImg=new JTextField();
        containAjouter.add(setUrlImg);
        containAjouter.add(Confirmer,BorderLayout.WEST);
        Details.getContentPane().add(containAjouter);
        Details.setVisible(true);
    }


    public void  addIMG(String path){

    if(count>0){
        panIMG.removeAll();
        ImageIcon icone2=new ImageIcon(path);
        JLabel image2=new JLabel(icone2);
        panIMG.add(image2);



}  else {
        icone = new ImageIcon(path);
        image = new JLabel(icone);
        panIMG = new JPanel();
        panIMG.add(image);

    }
    JScrollPane scrollImage=new JScrollPane();
    scrollImage.add(panIMG);
        mainWindow.getContentPane().add(panIMG);

        count++;
    }
    public void updateIMG() {
        tableau.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int row = tableau.getSelectedRow();
                String imgPath = new String();
                imgPath = (String) tableau.getValueAt(row, 6);
                System.out.println(imgPath);
                addIMG(imgPath);
                slivre.setText((String) tableau.getValueAt(row, 0));
                sauteurnom.setText((String) tableau.getValueAt(row, 1));
                spresentation.setText((String) tableau.getValueAt(row, 2));
                sparution.setText((String) tableau.getValueAt(row, 3));
                srangee.setText((String) tableau.getValueAt(row, 4));
                scolonne.setText((String) tableau.getValueAt(row, 5));
                sUrl.setText((String) tableau.getValueAt(row, 6));


                typeEmprunt.setSelectedIndex(parseInt((String) tableau.getValueAt(row, 7)));
                SwingUtilities.updateComponentTreeUI(mainWindow);


            }

        });


    }
    public List<String> modifyView(){
        String modify=new String();
        modify= slivre.getText() + "," + sauteurnom.getText() +"," + spresentation.getText() +","+ sparution.getText();
        modify += "," + srangee.getText() + "," + scolonne.getText() + "," +sUrl.getText();
        List<String> myList = new ArrayList<String>(Arrays.asList(modify.split(",")));
        return myList;
        /*
        sauteurnom.setText((String) tableau.getValueAt(row, 1));
        spresentation.setText((String) tableau.getValueAt(row, 2));
        sparution.setText((String) tableau.getValueAt(row, 3));
        srangee.setText((String) tableau.getValueAt(row, 4));
        scolonne.setText((String) tableau.getValueAt(row, 5));
        sUrl.setText((String) tableau.getValueAt(row, 6));*/
    }


}
