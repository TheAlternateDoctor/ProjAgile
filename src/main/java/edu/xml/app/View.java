import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.lang.reflect.Array;

public class View extends JFrame { //Mainwindow
//Attribut
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
        FOOTBALL,
        NATATION,
        RIEN,
        TENNIS;
    }

    private JFrame Details;
    private JButton adds;
    private JButton delete;

    // addFrame
    private JFrame adFileFrame;
    private Container containerOpen;
    private JLabel textTest;
/////////////////////////////////////////


    //méthode


    public View() throws HeadlessException {
        // Création de la fenêtre vide

        mainWindow=new JFrame("Agile");

        mainWindow.setSize(800,400);
        container=new Container();
        container.setLayout(new GridLayout(6,6));

        //Menu principale
        Bar=new JMenuBar();
        // Premier sous menu
        Fichier=new JMenu("Fichier");
        Openfile=new JMenuItem("Ouvrir");
        Newfile=new JMenuItem("Nouveau");
        End=new JMenuItem("Quitter");

        Fichier.add(Newfile);
        Fichier.add(Openfile);
        Fichier.add(End);
        Bar.add(Fichier);

        // Second sous menu
        Menusave=new JMenu("Edition");
        save=new JMenuItem("Enregistrer");
        saveas=new JMenuItem("Enregistrer sous");
        Menusave.add(save);
        Menusave.add(saveas);
        Bar.add(Menusave);


        // Troisième sous menu
        About=new JMenu("A propos");
        shortdesc=new JMenuItem("Qui sommes nous ?");
        About.add(shortdesc);
        Bar.add(About);

        container.add(Bar);
        // Menu haut
        //Bouttons ajouter/supprimer
        JButton adds=new JButton("+");
        JButton delete=new JButton("-");
        adds.setPreferredSize(new Dimension(40, 40));
        delete.setPreferredSize(new Dimension(40,40));
        mainWindow.getContentPane().add(container,BorderLayout.NORTH);
        table();
        Container containerButton=new Container();
       containerButton.setLayout(new GridLayout(1,2));
        containerButton.add(adds);
        containerButton.add(delete);
        mainWindow.getContentPane().add(containerButton,BorderLayout.SOUTH);

        //Print
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
    }

    public void Openfile(){

        adFileFrame=new JFrame("Nouveau fichier");
        adFileFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        adFileFrame.setSize(400,200);

        containerOpen = new Container();
        containerOpen.setLayout(new GridLayout(1,1));
        final JFileChooser fc = new JFileChooser();

        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "Fichier XML", "xml");
        fc.setFileFilter(filter);
        int returnVal = fc.showOpenDialog(getParent());
        if(returnVal == JFileChooser.APPROVE_OPTION) {
            System.out.println("You chose to open this file: " +
                    fc.getSelectedFile().getName());
        }

        containerOpen.add(fc);
        
        adFileFrame.getContentPane().add(containerOpen);
        adFileFrame.setVisible(true);
        table();
    }

    public void table(){
        // Tableau XML
        final String[] entetes = {"Titre", "Auteur","Année","Rangée","Colonne"};
        Object[][] donnees = {
                {"Johnathan", "Sykes", Color.red, true, Sport.TENNIS},
                {"Nicolas", "Van de Kampf", Color.black, true, Sport.FOOTBALL},
                {"Damien", "Cuthbert", Color.cyan, true, Sport.RIEN},
                {"Corinne", "Valance", Color.blue, false, Sport.NATATION},
                {"Emilie", "Schrödinger", Color.magenta, false, Sport.FOOTBALL},
                {"Delphine", "Duke", Color.yellow, false, Sport.TENNIS},
                {"Eric", "Trump", Color.pink, true, Sport.FOOTBALL},
        };
        JTable tableau = new JTable(donnees, entetes);


        container.add(tableau.getTableHeader());
        container.add(tableau);
        mainWindow.getContentPane().add(container,BorderLayout.CENTER);






    }

    public void quitter(){

        mainWindow.setVisible(false);
        mainWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void Ajouter(){
        Details=new JFrame("Ajouter");
        Details.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Details.setSize(400,600);
        JLabel Titre=new JLabel("Titre");
        JLabel Auteur=new JLabel("Auteur");
        JLabel Annee=new JLabel("Année");

        JTextField setTitre=new JTextField();
        JTextField setAuteur=new JTextField();
        JTextField setAnnee=new JTextField();
        Container containAjouter=new Container();
        container.setLayout(new GridLayout(2,3));

        Container containerElem1=new Container();
        containerElem1.setLayout(new GridLayout(2,1));
       containerElem1.add(Titre);
       containerElem1.add(setTitre);
       Container containerElem2=new Container();
       containerElem2.setLayout(new GridLayout(2,1));
       containerElem2.add(Auteur);
       containerElem2.add(setAuteur);
       Container containerElem3=new Container();
       containerElem3.setLayout(new GridLayout(2,1));
       containerElem3.add(Annee);
       containerElem3.add(setAnnee);

       containAjouter.add(containerElem1);
       containAjouter.add(containerElem2);
       containAjouter.add(containerElem3);

        Details.getContentPane().add(containAjouter);
        Details.setVisible(true);







    }
}
