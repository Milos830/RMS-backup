package Data;

public class Prodaja {

	
		private int IDevidencija_prodaje;
		private String Broj_prodaje;
		private long Datum_prodaje;
		private Kupac kupac;
		private Zaposleni zaposleni;
		private Nekretnina nekretnina;
		
		
		public String getBroj_prodaje() {
			return Broj_prodaje;
		}
		public void setBroj_prodaje(String broj_prodaje) {
			Broj_prodaje = broj_prodaje;
		}
		public int getIDevidencija_prodaje() {
			return IDevidencija_prodaje;
		}
		public void setIDevidencija_prodaje(int iDevidencija_prodaje) {
			IDevidencija_prodaje = iDevidencija_prodaje;
		}
		public long getDatum_prodaje() {
			return Datum_prodaje;
		}
		public void setDatum_prodaje(long datum_prodaje) {
			Datum_prodaje = datum_prodaje;
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
		public Nekretnina getNekretnina() {
			return nekretnina;
		}
		public void setNekretnina(Nekretnina nekretnina) {
			this.nekretnina = nekretnina;
		}
		
		public Prodaja(int iDevidencija_prodaje, long datum_prodaje, String broj_prodaje,  Kupac kupac,
				Zaposleni zaposleni) {
			
			IDevidencija_prodaje = iDevidencija_prodaje;
			Broj_prodaje = broj_prodaje;
			Datum_prodaje = datum_prodaje;
			this.kupac = kupac;
			this.zaposleni = zaposleni;
		}
		
		public Prodaja(Zaposleni zaposleni, Nekretnina nekretnina)
		{
			this.zaposleni=zaposleni;
			this.nekretnina=nekretnina;
		}
		@Override
		public String toString() {
			return "IDevidencija_prodaje + Broj_prodaje + Datum_prodaje + kupac + zaposleni";
		}
		
			
		
		
}
