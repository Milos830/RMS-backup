package Ctrl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Observable;
import java.util.Observer;

import Data.Prodaja;
import Data.StavkeProdaje;
import Model.Model;
import View.frmProdaja;
import Data.Kupac;
import Data.Zaposleni;
import Data.Nekretnina;


public class ProdajaCtrl implements Observer {

	private String[] zaglavlje = {"ID", "ID prodaje","Nekretnina", "Cena po kvadratu"};
	private frmProdaja view;
	private Model model;
	private Prodaja prodaja;
	private StavkeProdaje stavkeprodaje;
	private Nekretnina nekretnina;
	private String status;
	
	
	public ProdajaCtrl(frmProdaja view, Model model, String status) {
		this.view=view;
		this.model=model;
		view.setSacuvajLsn(new ProdajaListener("sacuvaj"));
		view.setStavkeLsn(new ProdajaListener("stavke"));
		view.setZavrsiLsn(new ProdajaListener("zavrsi"));
		model.addObserver(this);
		model.getStavkeProdaje();
		model.getAllEmmployers();
		model.getAllCustomers();
		model.getAllRealEstate("Slobodno");
		
	
	}
	@Override
	public void update(Observable o, Object arg) 	{
		
		if(!((ArrayList<Object>)arg).isEmpty()) 
		{	
			if(((ArrayList<Object>)arg).get(0) instanceof StavkeProdaje)
			{
			ArrayList<StavkeProdaje> lista = (ArrayList<StavkeProdaje>)arg;
		Object[][] podaci = new Object[lista.size()][zaglavlje.length];
		int i = 0;
		for (StavkeProdaje red : lista)
		{	
				podaci[i][0] = red.getIDstavke_nekretnine();
				podaci[i][1] = red.getProdaja().getIDevidencija_prodaje();
				podaci[i][2] = red.getNekretnina();
				podaci[i][3] = red.getCena_po_kvadratu();
				i++;	
		}
		view.setTableData(zaglavlje, podaci);
	}
		else if (((ArrayList<Object>)arg).get(0) instanceof Kupac)
		{
			ArrayList<Kupac> kup = (ArrayList<Kupac>) arg;
			view.setKupacCB(kup);
		}
		else if (((ArrayList<Object>)arg).get(0) instanceof Zaposleni)
		{
			ArrayList<Zaposleni> zap = (ArrayList<Zaposleni>) arg;
			view.setZaposleniCB(zap);
		}
		else 
		{
			ArrayList<Nekretnina> nek = (ArrayList<Nekretnina>) arg;
			view.setNekretninaCB(nek);

		}
	}
}
	
	public class ProdajaListener implements ActionListener {
		private String action;
		public ProdajaListener(String action)
		{
			this.action=action;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(action.equals("sacuvaj"))
			{
			
			prodaja = new Prodaja(0, view.getDate(), view.getBrojProdaje(),  (Kupac) view.getKupac(), (Zaposleni) view.getZaposleni());
			model.SacuvajProdaja(prodaja);
			view.EnableStavke();
		}
			else if (action.equals("stavke")) {
				StavkeProdaje stavke = new StavkeProdaje(0, prodaja, (Nekretnina) view.getNekretnina(), view.getCena());
				((Nekretnina) view.getNekretnina()).setStatus("Prodato");
				model.SacuvajStavke(stavke);
				model.IzmeniSTATUSnekretninePRODAJA((Nekretnina)view.getNekretnina());
				model.getStavkeProdaje();	
				view.ClearFilds();
			}
			else if(action.equals("zavrsi")) {
				
			}
		
	}
	
	public String getDate(long timeStamp)
	{
		DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
		Date time = new Date((long) timeStamp*1000);
		return df.format(time);
	}
}
}
