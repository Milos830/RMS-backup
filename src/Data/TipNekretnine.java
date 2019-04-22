package Data;

public class TipNekretnine {

	
	private int IDtip_nekretnine;
	private String Naziv;
	
	
	public int getIDtip_nekretnine() {
		return IDtip_nekretnine;
	}
	public void setIDtip_nekretnine(int iDtip_nekretnine) {
		IDtip_nekretnine = iDtip_nekretnine;
	}
	public String getNaziv() {
		return Naziv;
	}
	public void setNaziv(String naziv) {
		Naziv = naziv;
	}
	public TipNekretnine(int iDtip_nekretnine, String naziv) {
		
		IDtip_nekretnine = iDtip_nekretnine;
		Naziv = naziv;
	}
	@Override
	public String toString() {
		return Naziv;
	}
}
