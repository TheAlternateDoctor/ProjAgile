package edu.xml.app;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
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

    // Gestion images
    private ImageIcon icone;
    private JLabel image;
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
    private JFrame adFileFrame;
    private Container containerOpen;
    private JLabel textTest;
    /////////////////////////////////////////
    // méthode

    public View() throws HeadlessException {


        mainWindow = new JFrame("Agile");
       mainWindow.setSize(800,800);

        container = new Container();
        container.setLayout(new BorderLayout(9, 9));
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
        adds = new JButton("<html><span style='color:green;border:1px solid black'>+</span></html>");
        delete = new JButton("<html><span style='color:red '>-</span></html>");
        adds.setPreferredSize(new Dimension(5, 5));

        delete.setPreferredSize(new Dimension(5, 5));
        mainWindow.getContentPane().add(container, BorderLayout.NORTH);
        JPanel containerButton = new JPanel();
        GridLayout g2=new GridLayout(1, 2);
        g2.setHgap(10);
        g2.setVgap(5);
        containerButton.setLayout(g2);
        containerButton.add(adds);
        containerButton.add(delete);
        containerButton.setPreferredSize(new Dimension(10,50));
        mainWindow.getContentPane().add(containerButton,BorderLayout.AFTER_LAST_LINE);
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
        final String[] entetes = { "Titre", "Auteur", "presentation", "parution","rangée","colonne","UrlIMG","Prêt" };

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

        Object[] elements = new Object[]{"Prêt", "Acquis", "prêter"};
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
        final JFileChooser fc1 = new JFileChooser();

        FileNameExtensionFilter filter = new FileNameExtensionFilter("images", "jpg");
        fc1.setFileFilter(filter);
        int returnVal = fc1.showOpenDialog(getParent());

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            System.out.println("You chose to open this file: " + fc1.getSelectedFile().getName());
        }

        containAjouter.add(fc1);
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




        mainWindow.getContentPane().add(panIMG,BorderLayout.SOUTH);
        SwingUtilities.updateComponentTreeUI(mainWindow);
        count++;
    }
    public void updateIMG() {
    tableau.addMouseListener(new MouseAdapter() {
        public void mouseClicked(MouseEvent e) {
            int row = tableau.getSelectedRow();
            String imgPath=new String();
            imgPath=(String) tableau.getValueAt(row,6);
            System.out.println(imgPath);
            addIMG(imgPath);

        }

    });
}


}
