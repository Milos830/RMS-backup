package Ctrl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import Data.Namestenost;
import Model.Model;
import View.frmNamestenost;

public class NamestenostCtrl implements Observer {
	private String [] zaglavlje = {"ID", "Tip namestenosti"};
	private frmNamestenost view;
	private Model model;

	public NamestenostCtrl(frmNamestenost view, Model model) {
		
		this.view=view;
		this.model=model;
		model.addObserver(this);
		model.getAllFurniture();
		view.SacuvajLsn(new NamestenostListener());
	}

	@Override
	public void update(Observable o, Object arg) {

		ArrayList<Namestenost> lista = (ArrayList<Namestenost>) arg;
		Object[][] podaci = new Object[lista.size()][zaglavlje.length];
		int i= 0;
		for (Namestenost namestenost : lista) {
			podaci[i][0] = namestenost.getIDnamestenost();
			podaci[i][1] = namestenost.getNaziv();
			i++;
			
		}
		view.setTableData(zaglavlje, podaci);
	}

	public class NamestenostListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {

			Namestenost nam = new Namestenost(0, view.getNazivNamestenost());
			model.SacuvajNamestenost(nam);
			model.getAllFurniture();
			view.ClearFields();
		}
		
	}
}
