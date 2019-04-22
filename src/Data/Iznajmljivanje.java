package Data;



public class Iznajmljivanje {

		
		private int IDevidencija_iznajmljivanja;
		private Nekretnina nekretnina;
		private String Broj_iznajmljivanja;
		private Kupac kupac;
		private Zaposleni zaposleni;
		private StavkeIznajmljivanja stavkeIznajmljivanja;
		
		
		public String getBroj_iznajmljivanja() {
			return Broj_iznajmljivanja;
		}
		public void setBroj_iznajmljivanja(String broj_iznajmljivanja) {
			Broj_iznajmljivanja = broj_iznajmljivanja;
		}
		public int getIDevidencija_iznajmljivanja() {
			return IDevidencija_iznajmljivanja;
		}
		public void setIDevidencija_iznajmljivanja(int iDevidencija_iznajmljivanja) {
			IDevidencija_iznajmljivanja = iDevidencija_iznajmljivanja;
		}
		
		public Kupac getKupac() {
			return kupac;
		}
		public void setKupac(Kupac kupac) {
			this.kupac = kupac;
		}
		public Zaposleni getZaposleni() {
			return zaposleni;
		}
		public void setZaposleni(Zaposleni zaposleni) {
			this.zaposleni = zaposleni;
		}

		public Iznajmljivanje(int iDevidencija_iznajmljivanja, String broj_iznajmljivanja, Kupac kupac,
				Zaposleni zaposleni) {
			
			IDevidencija_iznajmljivanja = iDevidencija_iznajmljivanja;
			Broj_iznajmljivanja = broj_iznajmljivanja;
			this.kupac = kupac;
			this.zaposleni = zaposleni;
		}
		@Override
		public String toString() {
			return Broj_iznajmljivanja;
		}
}
