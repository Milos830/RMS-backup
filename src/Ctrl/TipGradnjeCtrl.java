package Ctrl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import Data.TipGradnje;
import Model.Model;
import View.frmTipGradnje;

public class TipGradnjeCtrl implements Observer{
		private String[] zaglavlje = {"ID", "Naziv tipa gradnje"};
		private frmTipGradnje view;
		private Model model;

	public TipGradnjeCtrl(frmTipGradnje view, Model model) {
		this.view=view;
		this.model=model;
		model.addObserver(this);
		this.model.getAllTypesOfConstruction();
		view.SacuvajLsn(new TipGrListener());
	
	}

	@Override
	public void update(Observable arg0, Object arg1) {

		ArrayList<TipGradnje> lista = (ArrayList<TipGradnje>)arg1;
		Object[][] podaci = new Object[lista.size()][zaglavlje.length];
		int i =0;
		for (TipGradnje red : lista) {
			podaci[i][0] = red.getIDTip_gradnje();
			podaci[i][1] = red.getNaziv();
			i++;
		}
		view.setTableData(zaglavlje, podaci);
	}
	
	public class TipGrListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {

			TipGradnje tipG = new TipGradnje(0, view.getNazivTipaGradnje());
			model.SacuvajTipGradnje(tipG);
			model.getAllTypesOfConstruction();
			view.ClearFields();
		}
		
	}

}
