package Main;

import Ctrl.GlavniMeniCtrl;
import Ctrl.KupacCrtl;
import Model.Model;
import View.frmGlavniMeni;
import View.frmKupac;

public class GlavniMeni {

	public static void main(String[] args) {

		
		frmGlavniMeni meni = new frmGlavniMeni("Prodaja i iznajmljivanje nekretnina - glavni meni");
		Model model = new Model();
		GlavniMeniCtrl ctrl = new GlavniMeniCtrl(meni, model);
		meni.setVisible(true);
	}

}


