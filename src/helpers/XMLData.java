package helpers;

public class XMLData {
    String titre;
    String nomAuteur;
    String prenomAuteur;
    String presentation;
    int parution;
    int colonne;
    int rangee;

    public XMLData(String titre, String nomAuteur, String prenomAuteur, String presentation, int parution, int colonne,
            int rangee) {
        this.titre = titre;
        this.nomAuteur = nomAuteur;
        this.prenomAuteur = prenomAuteur;
        this.presentation = presentation;
        this.parution = parution;
        this.colonne = colonne;
        this.rangee = rangee;
    }

    public String getTitre() {
        return titre;
    }

    public String getNomAuteur() {
        return nomAuteur;
    }

    public String getPrenomAuteur() {
        return prenomAuteur;
    }

    public String getPresentation() {
        return presentation;
    }

    public int getParution() {
        return parution;
    }

    public int getColonne() {
        return colonne;
    }

    public int getRangee() {
        return rangee;
    }

}