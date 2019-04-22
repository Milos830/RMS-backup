package Data;

public class StavkeIznajmljivanja {

	private int IDstavkeIznajmljivanja;
	private Iznajmljivanje iznajmljivanje;
	private Nekretnina nekretnina;
	private long Datum_pocetak;
	private long Datum_kraj;
	private double Cena;
	private Double DatumRazlika;
	/////////////////////////////////////
	private Zaposleni zaposleni;
	private String UkupanBrojDanaIznajmljivanja;
	private String Zarada;
	private String Provizija;

	public Zaposleni getZaposleni() {
		return zaposleni;
	}

	public void setZaposleni(Zaposleni zaposleni) {
		this.zaposleni = zaposleni;
	}

	public String getUkupanBrojDanaIznajmljivanja() {
		return UkupanBrojDanaIznajmljivanja;
	}

	public void setUkupanBrojDanaIznajmljivanja(String ukupanBrojDanaIznajmljivanja) {
		UkupanBrojDanaIznajmljivanja = ukupanBrojDanaIznajmljivanja;
	}

	public String getZarada() {
		return Zarada;
	}

	public void setZarada(String zarada) {
		Zarada = zarada;
	}

	public String getProvizija() {
		return Provizija;
	}

	public void setProvizija(String provizija) {
		Provizija = provizija;
	}

	public Double getDatumRazlika() {
		return DatumRazlika;
	}
	
	public StavkeIznajmljivanja(Zaposleni zaposleni, Nekretnina nekretnina, long datum_pocetak, long datum_kraj, 
			 String ukupanBrojDanaIznajmljivanja, double cena, String zarada, String provizija) {
			this.zaposleni = zaposleni;
			this.nekretnina = nekretnina;
			this.Datum_pocetak = datum_pocetak;
			this.Datum_kraj = datum_kraj;
			this.Cena = cena;
			this.UkupanBrojDanaIznajmljivanja = ukupanBrojDanaIznajmljivanja;
			this.Zarada = zarada;
			this.Provizija = provizija;
	}

	public StavkeIznajmljivanja(Nekretnina nekretnina, long datum_pocetak, long datum_kraj, double cena,
		Zaposleni zaposleni, String zarada, String provizija) {
	
			this.nekretnina = nekretnina;
			Datum_pocetak = datum_pocetak;
			Datum_kraj = datum_kraj;
			Cena = cena;
			this.zaposleni = zaposleni;
			Zarada = zarada;
			Provizija = provizija;
}

///////////////////////////////////////////////////////////////////////////////////////////////////
	public StavkeIznajmljivanja(int iDstavkeIznajmljivanja, Iznajmljivanje iznajmljivanje, Nekretnina nekretnina,
			long datum_pocetak, long datum_kraj, double cena) {
		
			IDstavkeIznajmljivanja = iDstavkeIznajmljivanja;
			this.iznajmljivanje = iznajmljivanje;
			this.nekretnina = nekretnina;
			Datum_pocetak = datum_pocetak;
			Datum_kraj = datum_kraj;
			Cena = cena;
	}
	public StavkeIznajmljivanja(long datum_pocetak) {
		this.Datum_pocetak = datum_pocetak;
	}
	public int getIDstavkeIznajmljivanja() {
		return IDstavkeIznajmljivanja;
	}

	public void setIDstavkeIznajmljivanja(int iDstavkeIznajmljivanja) {
		IDstavkeIznajmljivanja = iDstavkeIznajmljivanja;
	}

	public Iznajmljivanje getIznajmljivanje() {
		return iznajmljivanje;
	}

	public void setIznajmljivanje(Iznajmljivanje iznajmljivanje) {
		this.iznajmljivanje = iznajmljivanje;
	}

	public Nekretnina getNekretnina() {
		return nekretnina;
	}

	public void setNekretnina(Nekretnina nekretnina) {
		this.nekretnina = nekretnina;
	}

	public long getDatum_pocetak() {
		return Datum_pocetak;
	}

	public void setDatum_pocetak(long datum_pocetak) {
		Datum_pocetak = datum_pocetak;
	}

	public long getDatum_kraj() {
		return Datum_kraj;
	}

	public void setDatum_kraj(long datum_kraj) {
		Datum_kraj = datum_kraj;
	}

	public double getCena() {
		return Cena;
	}

	public void setCena(double cena) {
		Cena = cena;
	}

	@Override
	public String toString() {
		return String.valueOf(nekretnina);
	}

	public double GetBrojDanaIznajmljivanja1()
	{
		if(Datum_kraj >0)
		{
			int diff_in_millis = (int) ( Datum_kraj - Datum_pocetak) ;
			double diff_in_days =  Math.abs((diff_in_millis) / (10.0  * 360.0 * 24.0)) / 30.0;
			return (int)diff_in_days;
		}
		return 0;
	}

	public void setDatumRazlika(Double datumRazlika) {
		DatumRazlika = datumRazlika;
	}

}
