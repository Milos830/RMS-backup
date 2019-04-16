package Data;

public class TipGradnje {

	
	private int IDTip_gradnje;
	private String Naziv;
	
	public int getIDTip_gradnje() {
		return IDTip_gradnje;
	}
	public void setIDTip_gradnje(int iDTip_gradnje) {
		IDTip_gradnje = iDTip_gradnje;
	}
	public String getNaziv() {
		return Naziv;
	}
	public void setNaziv(String naziv) {
		Naziv = naziv;
	}
	
	public TipGradnje(int iDTip_gradnje, String naziv) {
		
		IDTip_gradnje = iDTip_gradnje;
		Naziv = naziv;
	}
	@Override
	public String toString() {
		return Naziv;
	}
	
	 
}
