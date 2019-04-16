package Ctrl;

import java.util.Observable;
import java.util.Observer;

import Model.Model;
import View.frmIZABERIizvestaj;

public class IZABERI_IZVESTAJ_Ctrl implements Observer{
	private frmIZABERIizvestaj view;
	private Model model;

	public IZABERI_IZVESTAJ_Ctrl(frmIZABERIizvestaj view, Model model) {
		this.view=view;
		this.model=model;
		model.getRentRealEstateReport();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}

}
