package edu.xml.app;

import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.poi.util.Units;
import org.apache.poi.xwpf.model.XWPFHeaderFooterPolicy;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTText;

import edu.xml.helpers.Bibliotheque;
import edu.xml.helpers.Bibliotheque.Livre;

public class ModelWord {
    private XWPFDocument document = new XWPFDocument();
    private Bibliotheque bibliotheque;
    private String filename;

    public ModelWord(Bibliotheque bibliotheque, String filename) {
        this.bibliotheque = bibliotheque;
        this.filename = filename;
    }

    public void exportModel(String filepath) {
        FileOutputStream out;
        try {
            out = new FileOutputStream(filepath);
            document.write(out);
            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void buildModel(){

        //Builds header
	    CTSectPr sectPr = document.getDocument().getBody().addNewSectPr();
        XWPFHeaderFooterPolicy policy = new XWPFHeaderFooterPolicy(document, sectPr);
        CTP ctpHeader = CTP.Factory.newInstance();
	    CTR ctrHeader = ctpHeader.addNewR();
		CTText ctHeader = ctrHeader.addNewT();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");  
        LocalDateTime now = LocalDateTime.now();
		String headerText = dtf.format(now)+" "+filename;
		ctHeader.setStringValue(headerText);	
        XWPFParagraph headerParagraph = new XWPFParagraph(ctpHeader, document);
        headerParagraph.setAlignment(ParagraphAlignment.CENTER);
	    XWPFParagraph[] parsHeader = new XWPFParagraph[1];
	    parsHeader[0] = headerParagraph;
        policy.createHeader(XWPFHeaderFooterPolicy.DEFAULT, parsHeader);
        
        //Builds page de garde
        XWPFParagraph garde = document.createParagraph();
        XWPFRun gardeRun = garde.createRun();
        gardeRun.addBreak();
        gardeRun.addBreak();
        gardeRun.addBreak();
        gardeRun.addBreak();
        gardeRun.setText("BIBLIOTHEQUE");
        gardeRun.setFontSize(40);
        gardeRun.setBold(true);
        garde.setAlignment(ParagraphAlignment.CENTER);

        //Builds Sommaire
        XWPFParagraph sommaire = document.createParagraph();
        XWPFRun runSommaire = sommaire.createRun();
        runSommaire.setText("SOMMAIRE");
        runSommaire.setStyle("Header1");
        sommaire.setPageBreak(true);
        sommaire.setAlignment(ParagraphAlignment.CENTER);

        // document.createTOC();


        List<Livre> livres = sortBiblio();


        XWPFParagraph listeLivres = document.createParagraph();
        listeLivres.setPageBreak(true);
        XWPFRun listeLivresRun = listeLivres.createRun();
        listeLivresRun.setFontSize(30);
        listeLivresRun.setText("Livres:");
        listeLivres.setStyle("Heading1");
        listeLivres.setAlignment(ParagraphAlignment.CENTER);

        String actualAuthor = "";
        XWPFParagraph author = null;
        XWPFRun authorRun = null;
        XWPFTable livreTable = null;
        XWPFTableRow livreRow = null;
        XWPFTableCell livreCell = null;
        XWPFParagraph livreDisp = null;
        XWPFRun livreRun = null;
        XWPFParagraph imgDisp = null;
        XWPFRun imgRun = null;
        for(Livre livre: livres){
            try{
                if(!actualAuthor.equals(livre.getAuteur().getPrenom() + " " + livre.getAuteur().getNom()) ){
                    actualAuthor = livre.getAuteur().getPrenom() + " " + livre.getAuteur().getNom();
                    author = document.createParagraph();
                    authorRun = author.createRun();
                    authorRun.setText(actualAuthor);
                    authorRun.setFontSize(20);
                    authorRun.setBold(true);
                    author.setAlignment(ParagraphAlignment.CENTER);
                    author.setStyle("Heading2");
                }
                livreTable = document.createTable();
                livreTable.removeBorders();
                livreRow = livreTable.getRow(0);
                livreCell = livreRow.getCell(0);
                imgDisp = livreCell.getParagraphArray(0);
                imgRun = imgDisp.createRun();
                String url = livre.getImgUrl();
                //InputStream is = new URL(url).openStream();
                if(url != null){
                    FileInputStream imageStream = new FileInputStream(url);
                    BufferedImage img = ImageIO.read(imageStream);
                    double w = img.getWidth();
                    double h = img.getHeight();
                    imageStream.close();
                    FileInputStream is = new FileInputStream(url);
                    double ratio = Math.floor(h / 100);
                    h = h /ratio;
                    w = w / ratio;
                    imgRun.addPicture(is, XWPFDocument.PICTURE_TYPE_JPEG, url, Units.toEMU(w), Units.toEMU(h)); // 200x200 pixels
                    is.close();
                    livreCell = livreRow.addNewTableCell();
                }
                else{
                    livreCell = livreRow.getCell(0);
                }
                livreDisp = livreCell.getParagraphArray(0);
                livreRun = livreDisp.createRun();
                livreRun.setText(livre.getTitre());
                livreRun.setFontSize(14);
                livreRun.addBreak();
                livreRun.setText(String.valueOf(livre.getParution()));
            }
            catch(Exception e){
                // e.printStackTrace();
                livreCell = livreRow.getCell(0);
                livreDisp = livreCell.getParagraphArray(0);
                livreRun = livreDisp.createRun();
                livreRun.setText(livre.getTitre());
                livreRun.setFontSize(14);
                livreRun.addBreak();
                livreRun.setText(String.valueOf(livre.getParution()));
            }
        }
        
        XWPFParagraph pretStatus = document.createParagraph();
        pretStatus.setPageBreak(true);
        XWPFRun pretStatusRun = pretStatus.createRun();
        pretStatusRun.setFontSize(30);
        pretStatusRun.setText("Prêts:");
        pretStatus.setStyle("Heading1");
        pretStatus.setAlignment(ParagraphAlignment.CENTER);

        XWPFTable pretTable = document.createTable();
        XWPFTableRow pretRow = pretTable.getRow(0);
        XWPFTableCell pretCell = pretRow.getCell(0);
        XWPFParagraph cellParagraph = pretCell.getParagraphArray(0);
        XWPFRun cellText = cellParagraph.createRun();
        cellText.setBold(true);
        cellText.setText("Livre");
        pretCell = pretRow.addNewTableCell();
        cellParagraph = pretCell.getParagraphArray(0);
        cellText = cellParagraph.createRun();
        cellText.setBold(true);
        cellText.setText("Prêté?");
        pretCell = pretRow.addNewTableCell();
        cellParagraph = pretCell.getParagraphArray(0);
        cellText = cellParagraph.createRun();
        cellText.setBold(true);
        cellText.setText("Acquis par");
        
        for(Livre livre: livres){
            pretRow = pretTable.createRow();
            pretCell = pretRow.getCell(0);
            cellParagraph = pretCell.getParagraphArray(0);
            cellText = cellParagraph.createRun();
            cellText.setText(livre.getTitre());
            pretCell = pretRow.getCell(1);
            cellParagraph = pretCell.getParagraphArray(0);
            cellText = cellParagraph.createRun();
            boolean pret = livre.isPret();
            if(pret){
                cellText.setText("Oui");
            }
            else{
                cellText.setText("Non");
            }
            pretCell = pretRow.getCell(2);
            cellParagraph = pretCell.getParagraphArray(0);
            cellText = cellParagraph.createRun();
            cellText.setText(livre.getAcquis());
            
        }
    }

    private List<Livre> sortBiblio(){
        List<Livre> livres = bibliotheque.getLivre();
        livres.sort((o1, o2) -> o1.getAuteur().getNom().compareTo(o2.getAuteur().getNom()));
        return livres;
    }
}