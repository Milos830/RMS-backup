package Data;

public class Lokacija {

	
		private int IDlokacija;
		private String Naziv;
		
		public int getIDlokacija() {
			return IDlokacija;
		}
		public void setIDlokacija(int iDlokacija) {
			IDlokacija = iDlokacija;
		}
		public String getNaziv() {
			return Naziv;
		}
		public void setNaziv(String naziv) {
			Naziv = naziv;
		}
		public Lokacija(int iDlokacija, String naziv) {
			
			IDlokacija = iDlokacija;
			Naziv = naziv;
		}
		@Override
		public String toString() {
			return Naziv;
		}
}
