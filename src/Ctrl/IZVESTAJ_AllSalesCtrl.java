package Ctrl;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import Data.StavkeProdaje;
import Model.Model;
import View.frmIZVESTAJ_AllSales;

public class IZVESTAJ_AllSalesCtrl implements Observer{
	private frmIZVESTAJ_AllSales view;
	private Model model;
	private String[] zaglavlje = {"Nekretnina","Povrsina", "Cena po kvadratu","Ukupno","Provizija"};
	public IZVESTAJ_AllSalesCtrl(Model model, frmIZVESTAJ_AllSales view) {
		this.model=model;
		this.view=view;
		model.addObserver(this);
		this.model.getSoldRealEstateReport();
	}

	@Override
	public void update(Observable arg0, Object arg1) {

		if(((ArrayList<Object>)arg1).get(0) instanceof StavkeProdaje)
		{
			ArrayList<StavkeProdaje> lista = (ArrayList<StavkeProdaje>)arg1;
			Object[][] podaci = new Object[lista.size()][zaglavlje.length];
			int i=0;
			for(StavkeProdaje red : lista)
			{
				podaci[i][0] = red.getNekretnina();
				podaci[i][1] = red.getNekretnina().getPovrsina();
				podaci[i][2] = red.getCena_po_kvadratu();
				podaci[i][3] = red.getUkupno();
				podaci[i][4] = red.getProvizija();
				i++;
			}
			view.setTableDataSveProdateNekretnine(zaglavlje, podaci);
		}

	}
}
