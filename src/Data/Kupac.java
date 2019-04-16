package Data;

public class Kupac {

	
		private int IDkupac;
		private String imeiprezimekupac;
		private String LKkupca;
		private String Telkupac;
		private String Adresakupac;
		private String Emailkupac;
		private Nekretnina rezervisanaNek;
		
		
		
		public Nekretnina getRezervisanaNek() {
			return rezervisanaNek;
		}
		public static void setRezervisanaNek(Nekretnina rezervisanaNek) {
			rezervisanaNek = rezervisanaNek;
		}
		public int getIDkupac() {
			return IDkupac;
		}
		public void setIDkupac(int iDkupac) {
			IDkupac = iDkupac;
		}
		public String getImeiprezimekupac() {
			return imeiprezimekupac;
		}
		public void setImeiprezimekupac(String imeiprezimekupac) {
			this.imeiprezimekupac = imeiprezimekupac;
		}
		public String getLKkupca() {
			return LKkupca;
		}
		public void setLKkupca(String lKkupca) {
			LKkupca = lKkupca;
		}
		public String getTelkupac() {
			return Telkupac;
		}
		public void setTelkupac(String telkupac) {
			Telkupac = telkupac;
		}
		public String getAdresakupac() {
			return Adresakupac;
		}
		public void setAdresakupac(String adresakupac) {
			Adresakupac = adresakupac;
		}
		public String getEmailkupac() {
			return Emailkupac;
		}
		public void setEmailkupac(String emailkupac) {
			Emailkupac = emailkupac;
		}
		public Kupac(int iDkupac, String imeiprezimekupac, String lKkupca, String telkupac, String adresakupac,
				String emailkupac) {
			
			IDkupac = iDkupac;
			this.imeiprezimekupac = imeiprezimekupac;
			LKkupca = lKkupca;
			Telkupac = telkupac;
			Adresakupac = adresakupac;
			Emailkupac = emailkupac;
		}
		@Override
		public String toString() {
			return imeiprezimekupac;
		}
		public static void setNekretnina(Nekretnina rezervisanaNek2) {
			// TODO Auto-generated method stub
			
		}
		
		
		
		
		
}
