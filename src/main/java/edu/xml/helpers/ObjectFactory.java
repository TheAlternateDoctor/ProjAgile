//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.2.8-b130911.1802 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2019.11.06 à 12:19:40 PM CET 
//


package edu.xml.helpers;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the edu.xml.helpers package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _BibliothequeLivrePresentation_QNAME = new QName("", "presentation");
    private final static QName _BibliothequeLivreImgUrl_QNAME = new QName("", "img_url");
    private final static QName _BibliothequeLivrePret_QNAME = new QName("", "pret");
    private final static QName _BibliothequeLivreTitre_QNAME = new QName("", "titre");
    private final static QName _BibliothequeLivreParution_QNAME = new QName("", "parution");
    private final static QName _BibliothequeLivreRangee_QNAME = new QName("", "rangee");
    private final static QName _BibliothequeLivreColonne_QNAME = new QName("", "colonne");
    private final static QName _BibliothequeLivreAcquis_QNAME = new QName("", "acquis");
    private final static QName _BibliothequeLivreAuteur_QNAME = new QName("", "auteur");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: edu.xml.helpers
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Bibliotheque }
     * 
     */
    public Bibliotheque createBibliotheque() {
        return new Bibliotheque();
    }

    /**
     * Create an instance of {@link Bibliotheque.Livre }
     * 
     */
    public Bibliotheque.Livre createBibliothequeLivre() {
        return new Bibliotheque.Livre();
    }

    /**
     * Create an instance of {@link Bibliotheque.Livre.Auteur }
     * 
     */
    public Bibliotheque.Livre.Auteur createBibliothequeLivreAuteur() {
        return new Bibliotheque.Livre.Auteur();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "presentation", scope = Bibliotheque.Livre.class)
    public JAXBElement<String> createBibliothequeLivrePresentation(String value) {
        return new JAXBElement<String>(_BibliothequeLivrePresentation_QNAME, String.class, Bibliotheque.Livre.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "img_url", scope = Bibliotheque.Livre.class)
    public JAXBElement<String> createBibliothequeLivreImgUrl(String value) {
        return new JAXBElement<String>(_BibliothequeLivreImgUrl_QNAME, String.class, Bibliotheque.Livre.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "pret", scope = Bibliotheque.Livre.class)
    public JAXBElement<Boolean> createBibliothequeLivrePret(Boolean value) {
        return new JAXBElement<Boolean>(_BibliothequeLivrePret_QNAME, Boolean.class, Bibliotheque.Livre.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "titre", scope = Bibliotheque.Livre.class)
    public JAXBElement<String> createBibliothequeLivreTitre(String value) {
        return new JAXBElement<String>(_BibliothequeLivreTitre_QNAME, String.class, Bibliotheque.Livre.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "parution", scope = Bibliotheque.Livre.class)
    public JAXBElement<Integer> createBibliothequeLivreParution(Integer value) {
        return new JAXBElement<Integer>(_BibliothequeLivreParution_QNAME, Integer.class, Bibliotheque.Livre.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Short }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "rangee", scope = Bibliotheque.Livre.class)
    public JAXBElement<Short> createBibliothequeLivreRangee(Short value) {
        return new JAXBElement<Short>(_BibliothequeLivreRangee_QNAME, Short.class, Bibliotheque.Livre.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Short }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "colonne", scope = Bibliotheque.Livre.class)
    public JAXBElement<Short> createBibliothequeLivreColonne(Short value) {
        return new JAXBElement<Short>(_BibliothequeLivreColonne_QNAME, Short.class, Bibliotheque.Livre.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "acquis", scope = Bibliotheque.Livre.class)
    public JAXBElement<String> createBibliothequeLivreAcquis(String value) {
        return new JAXBElement<String>(_BibliothequeLivreAcquis_QNAME, String.class, Bibliotheque.Livre.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Bibliotheque.Livre.Auteur }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "auteur", scope = Bibliotheque.Livre.class)
    public JAXBElement<Bibliotheque.Livre.Auteur> createBibliothequeLivreAuteur(Bibliotheque.Livre.Auteur value) {
        return new JAXBElement<Bibliotheque.Livre.Auteur>(_BibliothequeLivreAuteur_QNAME, Bibliotheque.Livre.Auteur.class, Bibliotheque.Livre.class, value);
    }

}
