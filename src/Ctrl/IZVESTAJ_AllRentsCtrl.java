package Ctrl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JFileChooser;
import com.itextpdf.awt.geom.Rectangle;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.ElementListener;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import Data.Nekretnina;
import Data.StavkeIznajmljivanja;
import Model.Model;
import View.frmIZVESTAJ_AllRents;


public class IZVESTAJ_AllRentsCtrl implements Observer{
	private Model model;
	private frmIZVESTAJ_AllRents view;
	private StavkeIznajmljivanja stavkeIznajmljivanja;
	private ArrayList<StavkeIznajmljivanja> stavke;
	private String[] zaglavlje = {"Zaposleni", "Nekretnina", "Pocetak iznajmljivanja",
			"Kraj iznajmljivanja", "Meseci", "Cena", "Zarada","Provizija"};

	public IZVESTAJ_AllRentsCtrl(Model model, frmIZVESTAJ_AllRents view) {
		this.model=model;
		this.view=view;
		model.addObserver(this);
		model.getRentRealEstateReport();
		view.setPrintLsn(new IzvestajListener("Print to PDF"));
		}

	@Override
	public void update(Observable arg0, Object arg1) {

		if(((ArrayList<Object>)arg1).get(0) instanceof StavkeIznajmljivanja)
		{
			stavke = (ArrayList<StavkeIznajmljivanja>)arg1;
			Object[][] podaci = new Object[stavke.size()][zaglavlje.length];
			int i=0;
			for(StavkeIznajmljivanja red : stavke)
			{
				podaci[i][0] = red.getZaposleni();
				podaci[i][1] = red.getNekretnina();
				podaci[i][2] = getDate(red.getDatum_pocetak());
				podaci[i][3] = getDate(red.getDatum_kraj());
				podaci[i][4] = red.GetBrojDanaIznajmljivanja1();
				podaci[i][5] = red.getCena();
				podaci[i][6] = getRound2(red.getZarada());
				podaci[i][7] = red.getProvizija();
				i++;
			}
			view.setTableDataSvaIznajmljivanja(zaglavlje, podaci);
		}
	}
	
	public String getDate(long timeStamp)
	{
		DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
		Date time = new Date((long) timeStamp*1000);
		return df.format(time);
	} 
	
	public  Double getRound2(String val) {
	    return new BigDecimal(val.toString()).setScale(2,RoundingMode.HALF_UP).doubleValue();
	}
	
	public void pdfAllRents() {
		JFileChooser c = new JFileChooser();
		String putanja = "";
	      // Demonstrate "Open" dialog:
	      int rVal = c.showSaveDialog(view);
	      if (rVal == JFileChooser.APPROVE_OPTION) {
	    	  putanja = c.getSelectedFile().getAbsolutePath();
	    	  
		Document document = new Document();
		try {
			PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(putanja)); //LOKACIJA PDF 
			document.open(); //OTVARANJE DOKUMENTA										f://PDF/IzvestajRadnici.pdf"
			
			Paragraph par = new Paragraph("REPORT OF RENTED PROPERTIES ");
			document.add(par);
			
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); //DATUM TRENUTNI KAD STVARAMO PDF
			Date date = new Date();
	
			PdfPTable table1 = new PdfPTable(3); //PRVA TABELA
			PdfPCell datum= new PdfPCell(new Paragraph("Datum: "+ dateFormat.format(date))); //POSTAVLJANJE DATUMA
			datum.setColspan(3); //DA SE JEDNO POLJE TABELE RASIRI NA 3
			datum.setBorder(0); //SKIDANJE BORDERA 
			datum.setHorizontalAlignment(Element.ALIGN_LEFT); //LEVO PORAVNANJE
			table1.addCell(datum); //RED GDE MI PISE DATUM, DODAVANJE
			PdfPCell Izn = new PdfPCell(new Paragraph("Iznajmljivanje: ",new Font(Font.FontFamily.TIMES_ROMAN,15)));
			Izn.setColspan(3);
			Izn.setBorder(0);
			Izn.setHorizontalAlignment(Element.ALIGN_LEFT);
			table1.addCell(Izn); //RED GDE MI PISE GAZDINSTVO, DODAVANJE
			PdfPCell eeee = new PdfPCell(new Paragraph(" ")); 
			eeee.setColspan(3);
			eeee.setBorder(0);
			table1.addCell(eeee); //PRAZAN RED U TABELI ISPOD GAZDINSTVA
			
			PdfPCell title = new PdfPCell(new Paragraph("Izvestaj svih iznajmljenih nekretnina",  new Font(Font.FontFamily.TIMES_ROMAN,15,Font.BOLD))); //POSTAVLJANJE NASLOVA
			title.setColspan(3);
			title.setBorder(0);
			title.setHorizontalAlignment(Element.ALIGN_CENTER);
			table1.addCell(title); //NASLOV, DODAVANJE U TABELU
			document.add(table1); //DODAVANJE TABELE U DOKUMENT
			Paragraph empty = new Paragraph(" "); //PRAZAN PARAGRAPH
			addEmptyLine(empty, 2); //DVE PRAZNE LINIJE
			document.add(empty); //DODAVANJE PRAZNIH LINIJA U DOKUMENT
			
			Font tblFont = new Font(new Font(Font.FontFamily.TIMES_ROMAN,10)); //FONT ZA SADRZAJ 2 TABELE
			Font hedFont = new Font(new Font(Font.FontFamily.TIMES_ROMAN,10,Font.BOLD)); //FONT ZA ZAGLAVLJE 2 TABELE
			
			PdfPTable table = new PdfPTable(7);		//POSTAVLJANJE 2 TABELE - 3 OZNACAVA BROJ KOLONA
			PdfPCell h1 = new PdfPCell(new Phrase("Nekretnina",hedFont));
			h1.setBackgroundColor(BaseColor.LIGHT_GRAY);
			table.addCell(h1);
			PdfPCell h2 = new PdfPCell(new Phrase("Pocetak iznajmljivanja", hedFont));
			h2.setBackgroundColor(BaseColor.LIGHT_GRAY);
			table.addCell(h2);
			PdfPCell h3 = new PdfPCell(new Paragraph("Kraj iznajmljivanja", hedFont));
			h3.setBackgroundColor(BaseColor.LIGHT_GRAY);
			table.addCell(h3);
			PdfPCell h4 = new PdfPCell(new Paragraph("Broj meseci", hedFont));
			h4.setBackgroundColor(BaseColor.LIGHT_GRAY);
			table.addCell(h4);
			
			PdfPCell h5 = new PdfPCell(new Paragraph("Cena/mesec", hedFont));
			h5.setBackgroundColor(BaseColor.LIGHT_GRAY);
			table.addCell(h5);
			PdfPCell h6 = new PdfPCell(new Paragraph("Provizija", hedFont));
			h6.setBackgroundColor(BaseColor.LIGHT_GRAY);
			table.addCell(h6);
			PdfPCell h7 = new PdfPCell(new Paragraph("Zarada zaposlenog", hedFont));
			h7.setBackgroundColor(BaseColor.LIGHT_GRAY);
			table.addCell(h7);
			
			float[] columnWidths = new float[]{22f, 30f, 30f, 15f,25f, 20f, 25f };
			table.setWidths(columnWidths);
		
			// DOVDE ZAGLAVLJE 2 TABELE
			for(StavkeIznajmljivanja si : stavke) //SADRZAJ 2 TABELE
			{ 
				PdfPCell cell1 = new PdfPCell(new Paragraph(String.valueOf(si.getNekretnina().getIDnekretnina()),tblFont));
				table.addCell(cell1);
				PdfPCell cell2 = new PdfPCell(new Paragraph(String.valueOf(getDate(si.getDatum_pocetak())),tblFont));
				table.addCell(cell2);
				PdfPCell cell3 = new PdfPCell(new Paragraph(String.valueOf(getDate(si.getDatum_kraj())),tblFont));
				table.addCell(cell3);
				PdfPCell cell4 = new PdfPCell(new Paragraph(String.valueOf(si.GetBrojDanaIznajmljivanja1()),tblFont));
				table.addCell(cell4);
				PdfPCell cell5 = new PdfPCell(new Paragraph(String.valueOf(si.getCena()),tblFont));
				table.addCell(cell5);
				PdfPCell cell6 = new PdfPCell(new Paragraph(String.valueOf(si.getProvizija()),tblFont));
				table.addCell(cell6);
				PdfPCell cell7 = new PdfPCell(new Paragraph(String.valueOf(getRound2(si.getZarada())),tblFont));
				table.addCell(cell7);
			}
			document.add(table); //DODAVANJE 2 TABELE U DOKUMENT
			document.close(); //ZATVARANJE DOKUMENTA
		} catch(Exception e) {
			e.printStackTrace();
		}
	      }
	}

	private void addEmptyLine(Paragraph paragraph, int number) {
	    for (int i = 0; i < number; i++) {
	        paragraph.add(new Paragraph(" "));
	    	}
		}
	
	public class IzvestajListener implements ActionListener {
		private String action;
		
		public IzvestajListener(String action) {
			this.action=action;
		}
		@Override
		public void actionPerformed(ActionEvent arg0) {
			if(action.equals("Print to PDF")) {
				pdfAllRents();
			}
		}
	}
}
