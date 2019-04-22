package Data;

public class Zaposleni {

	
		private int IDzaposleni;
		private String sifrazaposleni;
		private String ImeIPrezimezaposleni;
		private String Telefonzaposleni;
		
		
		public int getIDzaposleni() {
			return IDzaposleni;
		}
		public void setIDzaposleni(int iDzaposleni) {
			IDzaposleni = iDzaposleni;
		}
		public String getSifrazaposleni() {
			return sifrazaposleni;
		}
		public void setSifrazaposleni(String sifrazaposleni) {
			this.sifrazaposleni = sifrazaposleni;
		}
		public String getImeIPrezimezaposleni() {
			return ImeIPrezimezaposleni;
		}
		public void setImeIPrezimezaposleni(String imeIPrezimezaposleni) {
			ImeIPrezimezaposleni = imeIPrezimezaposleni;
		}
		public String getTelefonzaposleni() {
			return Telefonzaposleni;
		}
		public void setTelefonzaposleni(String telefonzaposleni) {
			Telefonzaposleni = telefonzaposleni;
		}
		public Zaposleni(int iDzaposleni, String sifrazaposleni, String imeIPrezimezaposleni, String telefonzaposleni) {
			
			IDzaposleni = iDzaposleni;
			this.sifrazaposleni = sifrazaposleni;
			ImeIPrezimezaposleni = imeIPrezimezaposleni;
			Telefonzaposleni = telefonzaposleni;
		}
		@Override
		public String toString() {
			return ImeIPrezimezaposleni;
		}
}
