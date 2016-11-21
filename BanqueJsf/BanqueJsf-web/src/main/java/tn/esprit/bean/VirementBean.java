package tn.esprit.bean;



import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import domain.Virement;
import service.VirementServiceLocal;

@ManagedBean
@ApplicationScoped

public class VirementBean {
@EJB
private VirementServiceLocal vs;
private ArrayList<String> devises=new ArrayList<String>();
private Virement v= new Virement();
private List<Virement> lv;

@PostConstruct
public void init(){
	lv = vs.findAll();


}

public void virement() {
vs.addVirement(v);
lv = vs.findAll();

}
public void doImprim(){
	//PDF
	try {
        File dossier = new File("C:/Virement");
        dossier.mkdir();

        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream("C:/Virement/virement" + 2+ ".pdf"));
        
        document.open();
        PdfPTable table = new PdfPTable(4);
        PdfPCell cell4 = new PdfPCell(new Paragraph("Id "));
        PdfPCell cell5 = new PdfPCell(new Paragraph("FromRib"));
        PdfPCell cell6 = new PdfPCell(new Paragraph("ToRib"));
        PdfPCell cell7 = new PdfPCell(new Paragraph("Montant"));
        table.addCell(cell4);
        table.addCell(cell5);
        table.addCell(cell6);
        table.addCell(cell7);
        
        for(int i=0;i< lv.size();i++)
        {  
        
        PdfPCell cell1 = new PdfPCell(new Paragraph(String.valueOf(lv.get(i).getFromCompteRib())));
        
        PdfPCell cell2 = new PdfPCell(new Paragraph(String.valueOf(lv.get(i).getToCompteRib())));
        
        PdfPCell cell3 = new PdfPCell(new Paragraph(String.valueOf(lv.get(i).getSolde())));
 
        table.addCell(cell1);
        table.addCell(cell2);
        table.addCell(cell3); 
  
        }
        table.getTotalHeight();
        document.add(table);
        document.close();
        } catch (DocumentException  ex) {
        ex.getCause();
    } catch (FileNotFoundException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}

}


public VirementServiceLocal getVs() {
	return vs;
}
public void setVs(VirementServiceLocal vs) {
	this.vs = vs;
}
public ArrayList<String> getDevises() {
devises.add("Euro");
devises.add("Dinar");
	return devises;
}
public void setDevises(ArrayList<String> devises) {
	this.devises = devises;
}

public Virement getV() {
	return v;
}
public void setV(Virement v) {
	this.v = v;
}

public List<Virement> getLv() {
	return lv;
}

public void setLv(List<Virement> lv) {
	this.lv = lv;
}


}
