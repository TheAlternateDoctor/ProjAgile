package edu.xml.app;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.xwpf.model.XWPFHeaderFooterPolicy;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.VerticalAlign;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTText;

import edu.xml.helpers.Bibliotheque;

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
    }
}