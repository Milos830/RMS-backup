package Data;

public class StavkeProdaje {

	
		private int IDstavke_nekretnine;
		private Prodaja prodaja;
		private Zaposleni zaposleni;
		private Nekretnina nekretnina;
		private double cena_po_kvadratu;
		private int povrsina;
		private String ukupno;
		private String provizija;
		private String provizijaZaposlenog;
		
		public String getProvizijaZaposlenog() {
			return provizijaZaposlenog;
		}
		public void setProvizijaZaposlenog(String provizijaZaposlenog) {
			this.provizijaZaposlenog = provizijaZaposlenog;
		}
		public String getUkupno() {
			return ukupno;
		}
		public void setUkupno(String ukupno) {
			this.ukupno = ukupno;
		}
		public String getProvizija() {
			return provizija;
		}
		public void setProvizija(String provizija) {
			this.provizija = provizija;
		}
		public Zaposleni getZaposleni() {
			return zaposleni;
		}
		public void setZaposleni(Zaposleni zaposleni) {
			this.zaposleni = zaposleni;
		}
		public int getPovrsina() {
			return povrsina;
		}
		public void setPovrsina(int povrsina) {
			this.povrsina = povrsina;
		}
		
		public int getIDstavke_nekretnine() {
			return IDstavke_nekretnine;
		}
		public void setIDstavke_nekretnine(int iDstavke_nekretnine) {
			IDstavke_nekretnine = iDstavke_nekretnine;
		}
		public Prodaja getProdaja() {
			return prodaja;
		}
		public void setProdaja(Prodaja prodaja) {
			this.prodaja = prodaja;
		}
		
		public Nekretnina getNekretnina() {
			return nekretnina;
		}
		public void setNekretnina(Nekretnina nekretnina) {
			this.nekretnina = nekretnina;
		}
		public double getCena_po_kvadratu() {
			return cena_po_kvadratu;
		}
		public void setCena_po_kvadratu(double cena_po_kvadratu) {
			this.cena_po_kvadratu = cena_po_kvadratu;
		}
		
		public StavkeProdaje(int iDstavke_nekretnine, Prodaja prodaja, Nekretnina nekretnina, double cena_po_kvadratu) {
			
			IDstavke_nekretnine = iDstavke_nekretnine;
			this.prodaja = prodaja;
			this.nekretnina = nekretnina;
			this.cena_po_kvadratu = cena_po_kvadratu;
		}
		public StavkeProdaje(Nekretnina nekretnina, int povrsina, double cena_po_kvadratu, String ukupno, String provizija) {
			this.nekretnina = nekretnina;
			this.povrsina=povrsina;
			this.cena_po_kvadratu=cena_po_kvadratu;
			this.ukupno=ukupno;
			this.provizija=provizija;
			
		}
				
		public StavkeProdaje(Zaposleni zaposleni, Nekretnina nekretnina, double cena_po_kvadratu, int povrsina,
				String ukupno, String provizija, String provizijaZaposlenog) {
			
			this.zaposleni = zaposleni;
			this.nekretnina = nekretnina;
			this.cena_po_kvadratu = cena_po_kvadratu;
			this.povrsina = povrsina;
			this.ukupno = ukupno;
			this.provizija = provizija;
			this.provizijaZaposlenog = provizijaZaposlenog;
		}

		@Override
		public String toString() {
			return "IDstavke_nekretnine + IDProdaje + nekretnina + cena_po_kvadratu";
		}
	}
