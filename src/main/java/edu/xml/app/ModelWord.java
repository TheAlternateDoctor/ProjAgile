package edu.xml.app;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.apache.poi.util.Units;
import org.apache.poi.xwpf.model.XWPFHeaderFooterPolicy;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
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
        buildModel();
        exportModel("/home/mathys/Cours/Prog Avancée/test.docx");
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

        document.createTOC();

        XWPFParagraph dummy = document.createParagraph();
        dummy.setPageBreak(true);

        List<Livre> livres = sortBiblio();

        String actualAuthor = "";
        for(Livre livre: livres){
            try{
                if(actualAuthor != livre.getAuteur().getPrenom() + " " + livre.getAuteur().getNom()){

                }
                XWPFParagraph livreDisp = document.createParagraph();
                XWPFRun livreRun = livreDisp.createRun();
                String url = livre.getImgUrl();
                //InputStream is = new URL(url).openStream();
                FileInputStream is = new FileInputStream(url);
                livreRun.addPicture(is, XWPFDocument.PICTURE_TYPE_JPEG, url, Units.toEMU(200), Units.toEMU(200)); // 200x200 pixels
                is.close();
                livreRun.setText("");
                livreRun.addBreak();
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
    }

    private List<Livre> sortBiblio(){
        List<Livre> livres = bibliotheque.getLivre();
        livres.sort((o1, o2) -> o1.getAuteur().getNom().compareTo(o2.getAuteur().getNom()));
        return livres;
    }
}