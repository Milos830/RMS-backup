package Ctrl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import Model.Model;
import View.fmrIznajmiMacko;
import View.frmGlavniMeni;
import View.frmGrad;
import View.frmGrejanje;
import View.frmIZABERIizvestaj;
import View.frmKupac;
import View.frmLokacija;
import View.frmNamestenost;
import View.frmNekretnina;
import View.frmProdaja;
import View.frmTipGradnje;
import View.frmTipNekretnine;
import View.frmZaposleni;
import Ctrl.DjordjeIznajmljivanjeCtrl;
import Data.Grad;
import Data.Grejanje;
import Data.Iznajmljivanje;
import Data.Lokacija;
import Data.Namestenost;
import Data.Nekretnina;
import Data.TipGradnje;
import Data.TipNekretnine;

public class GlavniMeniCtrl implements Observer{
	private frmGlavniMeni view;
	private Model model;
	
	public GlavniMeniCtrl(frmGlavniMeni view, Model model) {
		
		this.view=view;
		this.model=model;
		model.addObserver(this);
		view.setNekretninaListener(new GlavniMeniListener("Nekretnina"));
		view.setKupacListener(new GlavniMeniListener("Kupac"));
		view.setZaposleniListener(new GlavniMeniListener("Zaposleni"));
		view.setProdajaListener(new GlavniMeniListener("Prodaja"));
		view.setIznajmljivanjeListener(new GlavniMeniListener("Iznajmljivanje"));
		view.setIzvestajListener(new GlavniMeniListener("Izvestaji"));
		model.getAllRealEstate("Slobodno");
		model.getAllFurniture();
		model.getAllLocation();
		model.getTipNekretnine();
		model.getAllTypesOfConstruction();
		model.getAllHeating();
		model.getAllCities();
		}

	@Override
	public void update(Observable o, Object arg) {

		if(!((ArrayList<Object>)arg).isEmpty())
		{
		 if (((ArrayList<Object>)arg).get(0) instanceof TipNekretnine)
		{
			ArrayList<TipNekretnine> tipovi = (ArrayList<TipNekretnine>) arg;
			view.setTipNekretnineCB(tipovi);
		}
		else if (((ArrayList<Object>)arg).get(0) instanceof TipGradnje)
		{
			ArrayList<TipGradnje> tipG = (ArrayList<TipGradnje>) arg;
			view.setTipGradnjeCB(tipG);
		}
		else if (((ArrayList<Object>)arg).get(0) instanceof Grad)
		{
			ArrayList<Grad> gradovi = (ArrayList<Grad>) arg;
			view.setGradCB(gradovi);
		}
		
		else if (((ArrayList<Object>)arg).get(0) instanceof Lokacija)
		{
			ArrayList<Lokacija> lok = (ArrayList<Lokacija>) arg;
			view.setLokacijaCB(lok);
		}
		else if (((ArrayList<Object>)arg).get(0) instanceof Namestenost) 
		{
			ArrayList<Namestenost> namestaj = (ArrayList<Namestenost>) arg;
			view.setNamestenostCB(namestaj);
		}
		else if (((ArrayList<Object>)arg).get(0) instanceof Grejanje) 
		{
			ArrayList<Grejanje> grej = (ArrayList<Grejanje>) arg;
			view.setGrejanjeCB(grej);
		}

		}
	}
	
	public class GlavniMeniListener implements ActionListener {
		private String KojeDugme;

		public GlavniMeniListener(String KojeDugme) {
			this.KojeDugme = KojeDugme;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			if (KojeDugme.equals("Nekretnina")) {
				frmNekretnina view = new frmNekretnina("Dodaj novu nekretninu");
				Model model = new Model();
				NekretninaCrtl ctrl = new NekretninaCrtl(view, model, view.getSelectedItemFromTable());
				view.setVisible(true);
			} else if (KojeDugme.equals("Kupac")) {
				frmKupac view = new frmKupac("Dodaj kupca");
				Model model = new Model();
				KupacCrtl ctrl = new KupacCrtl(view, model);
				view.setVisible(true);
			}else if(KojeDugme.equals("Zaposleni")) {
				frmZaposleni view = new frmZaposleni("Dodaj zaposlenog");
				Model model = new Model();
				ZaposleniCtrl crtl = new ZaposleniCtrl(view, model);
				view.setVisible(true);
			}else if(KojeDugme.equals("Prodaja")) {
				frmProdaja view = new frmProdaja("PRODAJ NEKRETNINU MACKO");
				Model model = new Model();
				ProdajaCtrl ctrl = new ProdajaCtrl(view, model, "Slobodno");
				view.setVisible(true);
			}else if(KojeDugme.equals("Iznajmljivanje")) {
				fmrIznajmiMacko view = new fmrIznajmiMacko("Dzordz whyyy");
				Model model = new Model();
				DjordjeIznajmljivanjeCtrl ctrl = new DjordjeIznajmljivanjeCtrl(view, model, "Slobodno");
				view.setVisible(true);
			}else if(KojeDugme.equals("Izvestaji")) {
				frmIZABERIizvestaj view = new frmIZABERIizvestaj("Izaberi izvestaj");
				Model model = new Model();
				IZABERI_IZVESTAJ_Ctrl ctrl = new IZABERI_IZVESTAJ_Ctrl(view,model);
				view.setVisible(true);
			}
		}
				
	}
}
	