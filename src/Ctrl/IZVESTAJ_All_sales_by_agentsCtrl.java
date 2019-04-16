package Ctrl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Data.StavkeProdaje;
import Data.Zaposleni;
import Model.Model;

import View.frmIZVESTAJ_All_sales_by_agents;

public class IZVESTAJ_All_sales_by_agentsCtrl implements Observer{
	private Model model;
	private frmIZVESTAJ_All_sales_by_agents view;
	private String[] zaglavlje = {"Zaposleni", "Nekretnina", "Povrsina", "Cena po kvadratu", "Ukupno", "Provizija","Provizija zaposlenog"};
	
	public IZVESTAJ_All_sales_by_agentsCtrl(Model model, frmIZVESTAJ_All_sales_by_agents view) {
		this.model=model;
		this.view=view;
		model.addObserver(this);
		model.getAllEmmployers();
		view.SetCBListener(new KlikLsn());
		
	}
	
	public class KlikLsn implements ActionListener {
			
		@Override
		public void actionPerformed(ActionEvent e) {
			ArrayList<StavkeProdaje> sp = model.getSalesByAgents(((Zaposleni) view.getZaposleni()).getIDzaposleni());
			Object[][] podaci = new Object[sp.size()][zaglavlje.length];
			int i =0;
			for(StavkeProdaje red : sp)
			{
				podaci[i][0] = red.getZaposleni();
				podaci[i][1] = red.getNekretnina();
				podaci[i][2] = red.getPovrsina();
				podaci[i][3] = red.getCena_po_kvadratu();
				podaci[i][4] = getRound2(red.getUkupno());
				podaci[i][5] = getRound2(red.getProvizija());
				podaci[i][6] = getRound2(red.getProvizijaZaposlenog());
				i++;
			}
		view.setTableData(zaglavlje, podaci);
		
		double sumaZ=0;
		double sumaP=0;
		
		for(StavkeProdaje stavke : sp)
		{
			sumaZ=sumaZ+Double.valueOf(stavke.getProvizija());
			sumaP=sumaP+Double.valueOf(stavke.getProvizijaZaposlenog());
		}
		view.setZaradaPr(sumaZ);
		view.setProvizijaPr(sumaP);
		}			
		}
		
	@Override
	public void update(Observable arg0, Object arg1) {
		if(((ArrayList<Object>)arg1).get(0) instanceof Zaposleni) 
		{
			ArrayList<Zaposleni> z = (ArrayList<Zaposleni>)arg1;
			view.setZaposleniCB(z);
		}
	}
	
	public  Double getRound2(String val) {
	    return new BigDecimal(val.toString()).setScale(2,RoundingMode.HALF_UP).doubleValue();
	}
}
