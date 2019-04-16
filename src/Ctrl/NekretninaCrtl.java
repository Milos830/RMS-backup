package Ctrl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import Data.Grad;
import Data.Grejanje;
import Data.Lokacija;
import Data.Namestenost;
import Data.Nekretnina;
import Data.TipGradnje;
import Data.TipNekretnine;
import Model.Model;
import View.frmGrad;
import View.frmGrejanje;
import View.frmLokacija;
import View.frmNamestenost;
import View.frmNekretnina;
import View.frmTipGradnje;
import View.frmTipNekretnine;

public class NekretninaCrtl implements Observer{
	private String[] zaglavlje = 
	{"ID","Sifra", "Tip nekretnine","Tip gradnje", "Grad", 
	"Adresa", "Lokacija", "Povrsina", "Broj soba", "Broj kupatila", "Namestenost", "Grejanje", "Status"};
	private frmNekretnina view;
	private Model model;
	private Nekretnina nekretnina;
	
	
	
	public NekretninaCrtl(frmNekretnina view, Model model, Nekretnina NEK) {
		this.view=view;
		view.setSacuvajListener(new NekretninaListener("Sacuvaj"));
		
		this.model=model;
		
		model.addObserver(this);
		view.desniKlikIzmeni(new NekretninaListener("Izmeni"));
		view.setDodajTipNekretnineListener(new DodavanjeListener("TipNekretnine"));
		view.setDodajTipGradnjeListener(new DodavanjeListener("TipGradnje"));
		view.setDodajGradListener(new DodavanjeListener("Grad"));
		view.setDodajLokacijaListener(new DodavanjeListener("Lokacija"));
		view.setDodajNamestenostListener(new DodavanjeListener("Namestenost"));
		view.setDodajGrejanjeListener(new DodavanjeListener("Grejanje"));
		model.getTipNekretnine();
		model.getAllTypesOfConstruction();
		model.getAllCities();
		model.getAllLocation();
		model.getAllFurniture();
		model.getAllHeating();
		model.getAllRealEstate("");
		
	}


	@Override
	public void update(Observable o, Object arg) {
		if(!((ArrayList<Object>)arg).isEmpty())
		{
		if(((ArrayList<Object>) arg).get(0) instanceof Nekretnina)
{
	ArrayList<Nekretnina> lista = (ArrayList<Nekretnina>)arg;
	Object[][] podaci = new Object[lista.size()][zaglavlje.length];
	int i=0;
	for(Nekretnina red : lista)
	{
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
	view.setTableData(zaglavlje, podaci);
}
		else if (((ArrayList<Object>)arg).get(0) instanceof TipNekretnine)
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
			System.out.println("Osveze cb");
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
		else 
		{
			ArrayList<Grejanje> grej = (ArrayList<Grejanje>) arg;
			view.setGrejanjeCB(grej);
		}
		
	}
	}

	public class NekretninaListener implements ActionListener {
		private String izmeniSacuvaj;

		public NekretninaListener(String izmeniSacuvaj) {
			this.izmeniSacuvaj = izmeniSacuvaj;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			if (izmeniSacuvaj.equals("Sacuvaj")) {
				Nekretnina nekretnina = new Nekretnina (0, view.getSifraNekretnine(), (TipNekretnine) view.getTipNekretnine(), 
						(TipGradnje) view.getTipGradnje(), (Grad) view.getGrad(), view.getAdresa(), 
						(Lokacija) view.getLokacija(),view.getPovrsina(), view.getBrojSoba(), 
						view.getBrojKupatila(), (Namestenost) view.getNamestenost(), 
						(Grejanje) view.getGrejanje(), "Slobodno");
						model.SacuvajNekretnina(nekretnina);
						model.getAllRealEstate("");
						view.ClearFields();
			}
				
			else if (izmeniSacuvaj.equals("Izmeni")) {
				Nekretnina ne = view.getSelectedItemFromTable();
				view.setSifraNekretnine(ne.getSifraNekretnine());
				view.setTipNekretnine(ne.getTipNekretnine().getIDtip_nekretnine());
				view.setTipGradnje(ne.getTipGradnje().getIDTip_gradnje());
				view.setGrad(ne.getGrad().getIDgrad());
				view.setAdresa(ne.getAdresa());
				view.setLokacija(ne.getLokacija().getIDlokacija());
				view.setPovrsina(ne.getPovrsina());
				view.setBrojSoba(ne.getBroj_soba());
				view.setBrojKupatila(ne.getBroj_kupatila());
				view.setNamestenost(ne.getNamestenost().getIDnamestenost());
				view.setGrejanje(ne.getGrejanje().getIDgrejanje());
				view.setSacuvajListener(new NekretninaListener("SIZMENE"));
				nekretnina = ne;
			}
			else if(izmeniSacuvaj.equals("SIZMENE"))
			{
				nekretnina.setSifraNekretnine(view.getSifraNekretnine());
				nekretnina.setTipNekretnine((TipNekretnine) view.getTipNekretnine());
				nekretnina.setTipGradnje((TipGradnje)view.getTipGradnje());
				nekretnina.setGrad((Grad) view.getGrad());
				nekretnina.setAdresa(view.getAdresa());
				nekretnina.setLokacija((Lokacija) view.getLokacija());
				nekretnina.setPovrsina(view.getPovrsina());
				nekretnina.setBroj_soba(view.getBrojSoba());
				nekretnina.setBroj_kupatila(view.getBrojKupatila());
				nekretnina.setNamestenost((Namestenost) view.getNamestenost());
				nekretnina.setGrejanje((Grejanje) view.getGrejanje());
 				
				model.IzmeniNekretnina(nekretnina);
				nekretnina = null;
				view.setSacuvajListener(new NekretninaListener("Sacuvaj"));
				model.getAllRealEstate("");
			}
			
		}
	}
				
		public class DodavanjeListener implements ActionListener {
			private String KojeDugme;

			public DodavanjeListener(String KojeDugme) {
				this.KojeDugme = KojeDugme;
			}

			@Override
			public void actionPerformed(ActionEvent e) {
				if (KojeDugme.equals("TipNekretnine")) {
					frmTipNekretnine tipnek = new frmTipNekretnine("Dodaj nekretninu");
					Model model = new Model();
					TipNekretnineCtrl ctrl = new TipNekretnineCtrl(tipnek, model);
					tipnek.setVisible(true);
				} else if (KojeDugme.equals("TipGradnje")) {
					frmTipGradnje tipgr = new frmTipGradnje("Dodaj tip gradnje");
					Model model = new Model();
					TipGradnjeCtrl ctrl = new TipGradnjeCtrl(tipgr, model);
					tipgr.setVisible(true);
				}else if(KojeDugme.equals("Grad")) {
					frmGrad grad = new frmGrad("Dodaj grad");
					Model model = new Model();
					GradCtrl ctrl = new GradCtrl(grad, model);
					grad.setVisible(true);
				}else if(KojeDugme.equals("Lokacija")) {
					frmLokacija lok = new frmLokacija("Dodaj lokaciju");
					Model model = new Model();
					LokacijaCtrl ctrl = new  LokacijaCtrl(lok, model);
					lok.setVisible(true);
				}else if(KojeDugme.equals("Namestenost")) {
					frmNamestenost nam = new frmNamestenost("Dodaj tip namestenosti");
					Model model = new Model();
					NamestenostCtrl ctrl = new NamestenostCtrl(nam, model);
					nam.setVisible(true);
				}else if(KojeDugme.equals("Grejanje")) {
					frmGrejanje gre = new frmGrejanje("Dodaj tip grejanja");
					Model model = new Model();
					GrejanjeCtrl ctrl = new GrejanjeCtrl(gre, model);
					gre.setVisible(true);
				}
			}
					
		}
		
	}

