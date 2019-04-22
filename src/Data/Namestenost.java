package Data;

public class Namestenost {

	
	private int IDnamestenost;
	private String Naziv;
	
	
	public int getIDnamestenost() {
		return IDnamestenost;
	}
	public void setIDnamestenost(int iDnamestenost) {
		IDnamestenost = iDnamestenost;
	}
	public String getNaziv() {
		return Naziv;
	}
	public void setNaziv(String naziv) {
		Naziv = naziv;
	}
	public Namestenost(int iDnamestenost, String naziv) {
		
		IDnamestenost = iDnamestenost;
		Naziv = naziv;
	}
	@Override
	public String toString() {
		return Naziv;
	}
}
