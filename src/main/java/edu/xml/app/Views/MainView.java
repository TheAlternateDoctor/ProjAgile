package edu.xml.app.Views;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import edu.xml.app.Views.Connexion;

public class MainView  extends JFrame {
    private JMenuBar navbar;
    private JMenu file,edit,about;
    private JMenuItem newFile,openFile,exportToDocx,quit,save,saveAs,whoAreWe,connexion,database;
    private Container mainContainer;
    private JPanel panForm, panButton;
    private JButton adds,delete;
    private JTable tableau;

    private Connexion connexionPage;

    private String[][] donnees;
    private int idLivre;
    private int count;

    //Champs formulaire d'édition
    private JComboBox statusBox;
    private Object[] statusBoxValue;
    private JTextField sBook,sRelease,sAuthorName,sAuthorFirstName,scol,sLine,sImage,sHolder;
    private JTextArea spresentation = new JTextArea(3, 3);
    private JButton apply = new JButton("Appliquer");
    private JPanel panIMG;
    private ImageIcon icone;
    private JLabel image1;



    // Getters //

    public JButton getApply(){return apply;}
    public JMenuItem getExportToDocx() {  return exportToDocx;  }

    public JMenuItem getOpenFile() {
        return openFile;
    }

    public JTable getTableau(){return tableau;}
    public JMenuItem getNewFile() { return newFile;}

    public JButton getAdds() {return adds; }

    public JButton getDelete() { return delete; }

    public JMenuItem getSave() {  return save; }

    public JMenuItem getSaveAs() {  return saveAs;  }


    public JMenuItem getConnexion() { return connexion;}

    public JMenuItem getDatabase() { return database;}
    public void initEditForm(){
        panForm=new JPanel();
        panForm.setPreferredSize(new Dimension(300, 400));
        panForm.setBackground(Color.white);
        panForm.setBorder((BorderFactory.createTitledBorder("Formulaire d'interaction")));
        // Label formulaire d'édition
        JLabel holderLabel=new JLabel("Possesseur:");
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

        statusBoxValue = new Object[]{"Acquis", "Posseder","Emprunter"};
        statusBox= new JComboBox(statusBoxValue);
        sBook = new JTextField();
        sRelease = new JTextField();
        sAuthorName = new JTextField();
        sAuthorFirstName = new JTextField();
        spresentation = new JTextArea(3, 3);
        scol = new JTextField();
        sLine = new JTextField();
        sImage=new JTextField();
        apply = new JButton("Appliquer");
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
        haut.setAlignmentX(Component.CENTER_ALIGNMENT);






        haut.add(holderLabel);
        haut.add(sHolder);
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
        this.getContentPane().add(panForm,BorderLayout.EAST);
    }
    public MainView() throws HeadlessException{
        this.setSize(1366,900);//768
        this.initComponent();
        this.initEditForm();
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

    }
    private void initComponent(){
        mainContainer=new Container();
        mainContainer.setLayout(new BorderLayout(9, 9));
        // JMenu 1
        file=new JMenu("Fichier");
        newFile=new JMenuItem("Nouveau");
        openFile=new JMenuItem("Ouvrir");
        exportToDocx=new JMenuItem("Export");
        connexion=new JMenuItem("Connexion");
        database=new JMenuItem("Se connecter à une base de donnée");

        quit=new JMenuItem("quitter");
        file.add(newFile);
        file.add(openFile);
        file.add(exportToDocx);
        file.add(database);
        file.add(connexion);
        file.add(quit);

        // JMenu 2
        edit=new JMenu("Edit");
        save=new JMenuItem("sauvegarder");
        saveAs=new JMenuItem("sauvegarder sous");
        edit.add(save);
        edit.add(saveAs);
        //JMenu 3
        about=new JMenu("A propos");
        whoAreWe=new JMenuItem("qui sommes nous");
        about.add(whoAreWe);
        // JMenuBar
        navbar=new JMenuBar();
        navbar.add(file);
        navbar.add(edit);
        navbar.add(about);
        mainContainer.add(navbar,BorderLayout.NORTH);

        // JContainer Button

        adds = new JButton("<html><span style='color:green'>Ajouter livre</span></html>");
        delete = new JButton("<html><span style='color:red'>Supprimer livre</span></html>");

        panButton=new JPanel();
        panButton.setSize(1366,350);
        panButton.add(adds, BorderLayout.CENTER);
        panButton.add(delete, BorderLayout.CENTER);
        this.getContentPane().add(mainContainer,BorderLayout.CENTER);
        this.getContentPane().add(panButton,BorderLayout.SOUTH);
        tableau=new JTable();
    }
    public void table(String[][] donnees) {
        // Tableau XML
        this.donnees = donnees;
        final String[] entetes = { "Titre", "Auteur", "presentation", "parution","rangée","colonne","Urlimg","Status","nomPossesseur" };
        DefaultTableModel tableModel = (DefaultTableModel) tableau.getModel();
        tableModel.setColumnIdentifiers(entetes);
        for(int i = 1;i<donnees.length;i++){
            tableModel.addRow(donnees[i]);
        }
        JScrollPane pane=new JScrollPane(tableau);


        mainContainer.add(pane,BorderLayout.CENTER);

        SwingUtilities.updateComponentTreeUI(this);
    }

    public void addTable(String[] donnees){

        DefaultTableModel tableModel = (DefaultTableModel) tableau.getModel();
        tableModel.addRow(donnees);
        tableModel.fireTableDataChanged();
        SwingUtilities.updateComponentTreeUI(this);
    }

    public void removeTable(int index){

        DefaultTableModel tableModel = (DefaultTableModel) tableau.getModel();
        tableModel.removeRow(index);
        tableModel.fireTableDataChanged();
    }
    public String OpenfileButton() {
        Container containerOpen = new Container();
        containerOpen.setLayout(new GridLayout(1, 1));
        final JFileChooser fc = new JFileChooser();

        FileNameExtensionFilter filter = new FileNameExtensionFilter("Fichier XML/DOCX", "xml","docx");
        fc.setFileFilter(filter);
        int returnVal = fc.showOpenDialog(getParent());

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            System.out.println("You chose to open this file: " + fc.getSelectedFile().getName());
        }

        containerOpen.add(fc);

        return fc.getSelectedFile().getAbsolutePath();
    }
    public void newFileButton() {
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
        mainContainer.add(ContainerNewTable);
        mainContainer.add(pane2,BorderLayout.CENTER);
        SwingUtilities.updateComponentTreeUI(this);
    }
    public void editForm() {
        tableau.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int row = tableau.getSelectedRow();
                String imgPath = new String();
                idLivre = Integer.parseInt(donnees[row][0]);
                imgPath = (String) tableau.getValueAt(row, 7);
                sBook.setText((String) tableau.getValueAt(row, 1));
                sAuthorName.setText((String) tableau.getValueAt(row, 2));
                spresentation.setText((String) tableau.getValueAt(row, 3));
                sRelease.setText((String) tableau.getValueAt(row, 4));
                sLine.setText((String) tableau.getValueAt(row, 5));
                scol.setText((String) tableau.getValueAt(row, 6));
                sImage.setText((String) tableau.getValueAt(row, 7));

                statusBox.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if(String.valueOf(statusBox.getSelectedItem()) =="Emprunter"){
                            sHolder.setEditable(false);
                        }
                        else{
                            sHolder.setEditable(true);
                        }
                    }
                });
                printImage(sImage.getText());
            }

        });
    }

    public void printImage(String path){

        if(count>0){
            panIMG.removeAll();
            ImageIcon icone2=new ImageIcon(path);

            Image image = icone2.getImage(); // transform it
            Image newimg = image.getScaledInstance(280, 300,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
            ImageIcon iconeResize = new ImageIcon(newimg);
            Border borderImage = LineBorder.createBlackLineBorder();// transform it back
            JLabel image2=new JLabel(iconeResize);
            image2.setBorder(borderImage);
            panIMG.add(image2);



        }  else {
            icone = new ImageIcon(path);
            Image image = icone.getImage(); // transform it
            Image newimg = image.getScaledInstance(280, 300,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
            ImageIcon iconeResize1 = new ImageIcon(newimg);  // transform it back
            Border borderImage = LineBorder.createBlackLineBorder();
            image1= new JLabel(iconeResize1);
            image1.setBorder(borderImage);
            panIMG = new JPanel();
            panIMG.add(image1);

        }
        panIMG.setSize(200,200);
        panForm.add(panIMG,BorderLayout.SOUTH);
        count++;
    }

    public int supprimer(){
        return tableau.getSelectedRow();
    }
    public List <String> modifyView(){
        String modify;
        modify= idLivre + "," + sBook.getText() + "," + sAuthorName.getText() + " "+ sAuthorFirstName.getText() + "," + spresentation.getText() +","+ sRelease.getText();
        modify += "," + sLine.getText() + "," + scol.getText() + "," +sImage.getText();
        List <String> myList = new ArrayList<String>(Arrays.asList(modify.split(",")));
        return myList;

    }


}




