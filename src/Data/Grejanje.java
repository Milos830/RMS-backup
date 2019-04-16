package Data;

public class Grejanje {

	
		private int IDgrejanje;
		private String Naziv;
		
		
		public int getIDgrejanje() {
			return IDgrejanje;
		}
		public void setIDgrejanje(int iDgrejanje) {
			IDgrejanje = iDgrejanje;
		}
		public String getNaziv() {
			return Naziv;
		}
		public void setNaziv(String naziv) {
			Naziv = naziv;
		}
		public Grejanje(int iDgrejanje, String naziv) {
			
			IDgrejanje = iDgrejanje;
			Naziv = naziv;
		}
		@Override
		public String toString() {
			return Naziv;
		}
		
		
}
