package Ctrl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import Data.Zaposleni;
import Model.Model;
import View.frmZaposleni;

public class ZaposleniCtrl implements Observer {
	private String[] zaglavlje = {"ID", "Sifra", "Ime i prezime", "Telefon"};
	private frmZaposleni view;
	private Model model;
	public ZaposleniCtrl( frmZaposleni view, Model model) {
		
		this.view=view;
		this.model=model;
		view.setSacuvajZaposleni(new ZaposleniListener());
		model.addObserver(this);
		model.getAllEmmployers();
	}

	@Override
	public void update(Observable arg0, Object arg1) {

		ArrayList<Zaposleni> lista = (ArrayList<Zaposleni>) arg1;
		Object [][] podaci = new Object[lista.size()][zaglavlje.length];
		int i=0;
		for(Zaposleni red: lista)
		{
			podaci[i][0] = red.getIDzaposleni();
			podaci[i][1] = red.getSifrazaposleni();
			podaci[i][2] = red.getImeIPrezimezaposleni();
			podaci[i][3] = red.getTelefonzaposleni();
			i++;
		}
		view.setTableData(zaglavlje, podaci);
	}
	
	public class ZaposleniListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			Zaposleni zaposleni = new Zaposleni(0, view.getSifra(), view.getImeIPrezime(), view.getTelefon());
			model.SacuvajZaposleni(zaposleni);
			model.getAllEmmployers();
			view.ClearFields();
		}
	}
}
