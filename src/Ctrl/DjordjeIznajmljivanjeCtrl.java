package Ctrl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Observable;
import java.util.Observer;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Data.Iznajmljivanje;
import Data.Kupac;
import Data.Nekretnina;
import Data.StavkeIznajmljivanja;
import Data.Zaposleni;
import Model.Model;
import View.fmrIznajmiMacko;

public class DjordjeIznajmljivanjeCtrl implements Observer{
	private String[] zaglavlje = 
		{"ID","Sifra", "Tip nekretnine","Tip gradnje", "Grad", 
		"Adresa", "Lokacija", "Povrsina", "Broj soba", "Broj kupatila", "Namestenost", "Grejanje", "Status"}; 
	
	private String[] zaglavlje2 = {"ID", "Broj iznajmljivanja","Nekretnina", "Pocetak iznajmljivanja", "Kraj iznajmljivanja","Meseci", "Cena"};
	
	private String[] zaglavlje3 = {"ID stavke", "Broj iznajmljivanja", "Nekretnina", "Pocetak iznajmljivanja", "Kraj iznajmljivanja", "Meseci", "Cena"};
	

	private fmrIznajmiMacko view;
	private Model model;
	private Nekretnina nekretnina;
	private Iznajmljivanje iznajmljivanje;
	private StavkeIznajmljivanja stavke;

	public DjordjeIznajmljivanjeCtrl(fmrIznajmiMacko view, Model model, String status) {
		this.view=view;
		this.model=model;
		view.setKreirajIznajmljivanjeListener(new DjordjeListener("Kreiraj iznajmljivanje"));
		view.setIznajmiListener(new DjordjeListener("Iznajmi"));
		view.setZavrsiIznajmljivanjeListener(new DjordjeListener("ZavrsiIznajmljivanje"));
		view.AddSelectionModel(new KlikListener());
		model.addObserver(this);
		model.getAllRents();
		model.getStavkeIznajmljivanja();
		model.getAllEmmployers();
		model.getAllCustomers();
		model.getAllRealEstate("");
		
		
		
		
	}
	
	public class KlikListener implements ListSelectionListener {

		@Override
		public void valueChanged(ListSelectionEvent e) {
			
			ArrayList<StavkeIznajmljivanja> stavke = model.getAllStavkeIznajmljivanjaForID(view.getSelectedItemFromTable().getIDnekretnina());
			Object[][] podaci3 = new Object[stavke.size()][zaglavlje3.length];
			int i = 0;
			for(StavkeIznajmljivanja red : stavke)
			{
				podaci3[i][0] = red.getIDstavkeIznajmljivanja();
				podaci3[i][1] = red.getIznajmljivanje().getIDevidencija_iznajmljivanja();
				podaci3[i][2] = red;
				podaci3[i][3] = getDate(red.getDatum_pocetak());
				podaci3[i][4] = getDate(red.getDatum_kraj());
				podaci3[i][5] = red.GetBrojDanaIznajmljivanja1();
				podaci3[i][6] =  red.getCena();
				i++;
			}
			view.setTableDataStavke(zaglavlje3, podaci3);
			
			double sumaZ=0;
			double sumaM=0;
			
			for(StavkeIznajmljivanja sta :stavke)
			{
				sumaZ=sumaZ+Double.valueOf(sta.getCena());
				sumaM=sumaM+Double.valueOf(sta.GetBrojDanaIznajmljivanja1());
			}
			view.setZarada(sumaZ);
			view.setBrMeseci(sumaM);
			
			
		}
		
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		
		if(!((ArrayList<Object>)arg1).isEmpty())
		{
		if(((ArrayList<Object>) arg1).get(0) instanceof Nekretnina)
		{
			ArrayList<Nekretnina> lista = (ArrayList<Nekretnina>)arg1;
			ArrayList<Nekretnina> lista2 = new ArrayList<Nekretnina>();
			Object[][] podaci = new Object[lista.size()][zaglavlje.length];
			int i=0;
			
			for(Nekretnina red : lista)
			{
				if(red.getStatus().equals("Slobodno"))
					lista2.add(red);
				
				podaci[i][0] = red.getIDnekretnina();
				podaci[i][1] = red;
				podaci[i][2] = red.getTipNekretnine();
				podaci[i][3] = red.getTipGradnje();
				podaci[i][4] = red.getGrad();
				podaci[i][5] = red.getAdresa();
				podaci[i][6] = red.getLokacija();
				podaci[i][7] = red.getPovrsina();
				podaci[i][8] = red.getBroj_soba();
				podaci[i][9] = red.getBroj_kupatila();
				podaci[i][10] = red.getNamestenost();
				podaci[i][11] = red.getGrejanje();
				podaci[i][12] = red.getStatus();
				i++;
			}
			view.setNekretninaTableData(zaglavlje, podaci);
			view.setNekretninaCB(lista2);
	}
		else if (((ArrayList<Object>)arg1).get(0) instanceof StavkeIznajmljivanja)
		{
			ArrayList<StavkeIznajmljivanja> lista = (ArrayList<StavkeIznajmljivanja>)arg1;
			Object[][] podaci2 = new Object[lista.size()][zaglavlje2.length];
			int i=0;
			for (StavkeIznajmljivanja red : lista) {
				podaci2[i][0] = red.getIDstavkeIznajmljivanja();
				podaci2[i][1] = red.getIznajmljivanje().getIDevidencija_iznajmljivanja();
				podaci2[i][2] = red;
				podaci2[i][3] = getDate(red.getDatum_pocetak());
				podaci2[i][4] = getDate(red.getDatum_kraj());
				podaci2[i][5] = red.GetBrojDanaIznajmljivanja1();
				podaci2[i][6] =  red.getCena();
				i++;
			}
			view.setKreiranaIznajmljivanja(zaglavlje2, podaci2);
			}
		
		else if (((ArrayList<Object>)arg1).get(0) instanceof Kupac)
		{
			ArrayList<Kupac> kup = (ArrayList<Kupac>) arg1;
			view.setKupacCB(kup);
		}
		else  if (((ArrayList<Object>)arg1).get(0) instanceof Zaposleni)
		{
			ArrayList<Zaposleni> zap = (ArrayList<Zaposleni>) arg1;
			view.setZaposleniCB(zap);
	}
		}
	}

	public class DjordjeListener implements ActionListener {
		private String action;
		
		public DjordjeListener(String action)
		{
			this.action=action;
		}
		@Override
		public void actionPerformed(ActionEvent arg0) {
			if(action.equals("Kreiraj iznajmljivanje"))
			{
				iznajmljivanje = new Iznajmljivanje(0, view.getBrojIznajmljivanja(),
						(Kupac) view.getKupac(), (Zaposleni) view.getZaposleni());
				model.SacuvajIznajmljivanje(iznajmljivanje);
				view.EnableStavke();
			}
			else if (action.equals("Iznajmi"))
			{
				StavkeIznajmljivanja stavke = new StavkeIznajmljivanja(0, iznajmljivanje, (Nekretnina) view.getNekretnina(), view.getDatePocetak(), view.getDateKraj(), view.getCena());
				model.SacuvajStavkeIz(stavke);
				model.IzmeniSTATUSnekretnineIZNAJMLJIVANJE((Nekretnina) view.getNekretnina());
				model.getAllRealEstate("");
				model.getAllRents();
				model.getStavkeIznajmljivanja();
				view.ClearFields();
				
			}
			else if (action.equals("ZavrsiIznajmljivanje"))
			{
			view.EnableStavke();
			StavkeIznajmljivanja st = view.getSelectedItemFromTable1();
			view.setnekretninaCB(st.getNekretnina().getIDnekretnina());
			view.setDatePocetak(getDate(st.getDatum_pocetak()));
			view.setCena(st.getCena());
			view.setIznajmiListener(new DjordjeListener("IZMENE"));
			stavke = st;
			}
			else if(action.equals("IZMENE"))
			{
				stavke.setDatum_kraj(view.getDateKraj());
				stavke.setDatumRazlika((stavke).GetBrojDanaIznajmljivanja1());
				model.IzmeniStavkeIznajmljivanja(stavke);
				view.setIznajmiListener(new DjordjeListener("Iznajmi"));
				model.getAllRealEstate("");
				model.getAllRents();
				model.getStavkeIznajmljivanja();
				view.ClearFields();
				
			}
		}
	
	}
	public String getDate(long timeStamp)
	{
		DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
		Date time = new Date((long) timeStamp*1000);
		return df.format(time);
	}

	public  Double getRound2(Double val) {
	    return new BigDecimal(val.toString()).setScale(2,RoundingMode.HALF_UP).doubleValue();
	}
}
