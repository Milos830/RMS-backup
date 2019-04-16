package Data;

public class Nekretnina {

	
	private int IDnekretnina;
	private String SifraNekretnine;
	private TipNekretnine tipNekretnine;
	private TipGradnje tipGradnje;
	private Grad grad;
	private String Adresa;
	private Lokacija lokacija;
	private int Povrsina;
	private int Broj_soba;
	
	private int Broj_kupatila;
	private Namestenost namestenost;
	private Grejanje grejanje;
	private String Status;
	
	private int IDevidencija_iznajmljivanja;
	
	
	public Nekretnina(int iDnekretnina, String sifraNekretnine, TipNekretnine tipNekretnine, TipGradnje tipGradnje,
			Grad grad, String adresa, Lokacija lokacija, int povrsina, int broj_soba, int broj_kupatila,
			Namestenost namestenost, Grejanje grejanje, String status) {
		
		IDnekretnina = iDnekretnina;
		SifraNekretnine = sifraNekretnine;
		this.tipNekretnine = tipNekretnine;
		this.tipGradnje = tipGradnje;
		this.grad = grad;
		Adresa = adresa;
		this.lokacija = lokacija;
		Povrsina = povrsina;
		Broj_soba = broj_soba;
		Broj_kupatila = broj_kupatila;
		this.namestenost = namestenost;
		this.grejanje = grejanje;
		Status = status;
	}
	
	public Nekretnina(int iDnekretnina, Grad grad, TipNekretnine tipNekretnine, TipGradnje tipGradnje,  Lokacija lokacija, int povrsina,
			int broj_soba, int broj_kupatila, Namestenost namestenost, Grejanje grejanje, String status) {
		
		this.IDnekretnina=iDnekretnina;
		this.tipNekretnine = tipNekretnine;
		this.tipGradnje = tipGradnje;
		this.grad = grad;
		this.lokacija = lokacija;
		this.Povrsina = povrsina;
		this.Broj_soba = broj_soba;
		this.Broj_kupatila = broj_kupatila;
		this.namestenost = namestenost;
		this.grejanje = grejanje;
		this.Status = status;
	}


	public int getIDevidencija_iznajmljivanja() {
		return IDevidencija_iznajmljivanja;
	}

	public void setIDevidencija_iznajmljivanja(int iDevidencija_iznajmljivanja) {
		IDevidencija_iznajmljivanja = iDevidencija_iznajmljivanja;
	}

	public int getIDnekretnina() {
		return IDnekretnina;
	}

	public void setIDnekretnina(int iDnekretnina) {
		IDnekretnina = iDnekretnina;
	}

	public String getSifraNekretnine() {
		return SifraNekretnine;
	}

	public void setSifraNekretnine(String sifraNekretnine) {
		SifraNekretnine = sifraNekretnine;
	}

	public TipNekretnine getTipNekretnine() {
		return tipNekretnine;
	}

	public void setTipNekretnine(TipNekretnine tipNekretnine) {
		this.tipNekretnine = tipNekretnine;
	}

	public TipGradnje getTipGradnje() {
		return tipGradnje;
	}

	public void setTipGradnje(TipGradnje tipGradnje) {
		this.tipGradnje = tipGradnje;
	}

	public Grad getGrad() {
		return grad;
	}

	public void setGrad(Grad grad) {
		this.grad = grad;
	}

	public String getAdresa() {
		return Adresa;
	}

	public void setAdresa(String adresa) {
		Adresa = adresa;
	}

	public Lokacija getLokacija() {
		return lokacija;
	}

	public void setLokacija(Lokacija lokacija) {
		this.lokacija = lokacija;
	}

	public int getPovrsina() {
		return Povrsina;
	}

	public void setPovrsina(int povrsina) {
		Povrsina = povrsina;
	}

	public int getBroj_soba() {
		return Broj_soba;
	}

	public void setBroj_soba(int broj_soba) {
		Broj_soba = broj_soba;
	}

	public int getBroj_kupatila() {
		return Broj_kupatila;
	}

	public void setBroj_kupatila(int broj_kupatila) {
		Broj_kupatila = broj_kupatila;
	}

	public Namestenost getNamestenost() {
		return namestenost;
	}

	public void setNamestenost(Namestenost namestenost) {
		this.namestenost = namestenost;
	}

	public Grejanje getGrejanje() {
		return grejanje;
	}

	public void setGrejanje(Grejanje grejanje) {
		this.grejanje = grejanje;
	}
	
	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	@Override
	public String toString() {
		return SifraNekretnine;
//		return SifraNekretnine + "- " + tipNekretnine + "-  " + Adresa;
	}
}
