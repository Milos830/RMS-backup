package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Observable;

import javax.swing.JComboBox;

import Data.Grad;
import Data.Grejanje;
import Data.Iznajmljivanje;
import Data.Kupac;
import Data.Lokacija;
import Data.Namestenost;
import Data.Nekretnina;
import Data.Prodaja;
import Data.StavkeIznajmljivanja;
import Data.StavkeProdaje;
import Data.TipGradnje;
import Data.TipNekretnine;
import Data.Zaposleni;
import javafx.scene.control.ComboBox;

public class Model extends Observable{

public void getAllCities () {
		
		MySqlConnection con = new MySqlConnection();
		Connection konekcija = con.getConnection();
		ArrayList<Grad> gradovi = new ArrayList<Grad>();
		try {
			Statement upit = konekcija.createStatement();
			ResultSet rs = upit.executeQuery("SELECT * FROM grad;");
			while(rs.next())
			{
				Grad grad = new Grad (rs.getInt(1), rs.getString(2));
				gradovi.add(grad);
			}
		}catch (SQLException e)
		{
			e.printStackTrace();
		}
		setChanged();
		notifyObservers(gradovi);
	}

	
	public void SacuvajGrad (Grad grad)
	{
		MySqlConnection conn = new MySqlConnection();
		Connection konekcija = conn.getConnection();
		try {
			String query = "INSERT INTO grad(Naziv) VALUES (?)";
			PreparedStatement upit = konekcija.prepareStatement(query);
			upit.setString(1, grad.getNaziv());
			upit.executeUpdate();
		}catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally {
			getAllCities();
		}
	}
	
	
	
	public void SacuvajTipNekretnine(TipNekretnine tipn)
	{
		MySqlConnection conn = new MySqlConnection();
		Connection konekcija = conn.getConnection();
		try {
			String query = "INSERT INTO tip_nekretnine(Naziv) VALUES(?)";
			PreparedStatement upit = konekcija.prepareStatement(query);
			upit.setString(1, tipn.getNaziv());
			upit.executeUpdate();
		}catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

	public void getAllHeating () {
		MySqlConnection con = new MySqlConnection();
		Connection konekcija = con.getConnection();
		ArrayList<Grejanje> gre = new ArrayList<Grejanje>();
		try {
			Statement upit = konekcija.createStatement();
			ResultSet rs = upit.executeQuery("SELECT * FROM grejanje;");
			while(rs.next())
			{
				Grejanje grejanje = new Grejanje(rs.getInt(1), rs.getString(2));
				gre.add(grejanje);
			}
		}catch (SQLException e)
		{
			e.printStackTrace();
		}
		setChanged();
		notifyObservers(gre);
	}

	
	public void SacuvajGrejanje (Grejanje grejanje) {
		MySqlConnection conn = new MySqlConnection();
		Connection konekcija = conn.getConnection();
		try {
			String query = "INSERT INTO grejanje(Naziv) VALUES (?)";
			PreparedStatement upit = konekcija.prepareStatement(query);
			upit.setString(1, grejanje.getNaziv());
			upit.executeUpdate();
		}catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public void getAllCustomers() {
		
		MySqlConnection con = new MySqlConnection();
		Connection konekcija = con.getConnection();
		ArrayList<Kupac> kupci = new ArrayList<Kupac>(); 
		try {
			Statement upit = konekcija.createStatement();
			ResultSet rs = upit.executeQuery("SELECT * FROM kupac;");
			while (rs.next())
			{
				Kupac kupac = new Kupac (rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
				kupci.add(kupac);
			}
		
		}catch (SQLException e)
		{
			e.printStackTrace();
		}
		setChanged();
		notifyObservers(kupci);
		}

		public void SacuvajKupac (Kupac kupac) 
		{
			MySqlConnection conn = new MySqlConnection();
			Connection konekcija = conn.getConnection();
			try {
				String query = "INSERT INTO kupac(imeiprezimekupac, LKkupca, Telkupac, Adresakupac, Emailkupac) VALUES (?,?,?,?,?)";
				PreparedStatement upit = konekcija.prepareStatement(query);
				upit.setString(1, kupac.getImeiprezimekupac());
				upit.setString(2, kupac.getLKkupca());
				upit.setString(3, kupac.getTelkupac());
				upit.setString(4, kupac.getAdresakupac());
				upit.setString(5, kupac.getEmailkupac());
				upit.executeUpdate();
			}catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
		
		public Kupac getKupac(int ID)
		{
			MySqlConnection conn = new MySqlConnection();
			Connection konekcija = conn.getConnection();
			Kupac kupac = null;
			try {
				Statement upit = konekcija.createStatement();
				ResultSet k = upit.executeQuery("SELECT * FROM kupac WHERE IDkupac =" + ID);
				while(k.next())
				{
					kupac = new Kupac(k.getInt(1), k.getString(2), k.getString(3), 
							k.getString(4), k.getString(5), k.getString(6));
				}
				k.close();
				upit.close();
			}catch (SQLException e)
			{
				e.printStackTrace();
			}finally 
			{
				try {
					konekcija.close();
				}catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
			return kupac;
		}

		public void IzmeniKupac (Kupac k)
		{
			MySqlConnection connn = new MySqlConnection();
			Connection konekcija = connn.getConnection();
			try {
				String query = "UPDATE izdavanjenekretnina.kupac SET imeiprezimekupac=?, LKkupca=?, Telkupac=?, Adresakupac=?, Emailkupac=? WHERE IDkupac = "+k.getIDkupac() +" ";
				PreparedStatement upit = konekcija.prepareStatement(query);
				upit.setString(1, k.getImeiprezimekupac());
				upit.setString(2, k.getLKkupca());
				upit.setString(3, k.getTelkupac());
				upit.setString(4, k.getAdresakupac());
				upit.setString(5, k.getEmailkupac());
				upit.executeUpdate();
			
			}catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
		
		public void getAllLocation() {
			MySqlConnection con = new MySqlConnection();
			Connection konekcija = con.getConnection();
			ArrayList<Lokacija> lok = new ArrayList<Lokacija>();
			try {
				Statement upit = konekcija.createStatement();
				ResultSet rs = upit.executeQuery("SELECT * FROM lokacija;");
				while (rs.next())
				{
					Lokacija lokacija = new Lokacija(rs.getInt(1), rs.getString(2));
					lok.add(lokacija);
				}
			}catch (SQLException e)
			{
				e.printStackTrace();
			}
			setChanged();
			notifyObservers(lok);

		}

			public void SacuvajLokacija(Lokacija lokacija)
			{
				MySqlConnection conn = new MySqlConnection();
				Connection konekcija = conn.getConnection();
				try {
					String query = "INSERT INTO lokacija(Naziv) VALUES (?)";
					PreparedStatement upit = konekcija.prepareStatement(query);
					upit.setString(1, lokacija.getNaziv());
					upit.executeUpdate();
				} catch (SQLException e)
				{
					e.printStackTrace();
				}
			}

			public void getAllFurniture () {
				MySqlConnection con = new MySqlConnection();
				Connection konekcija = con.getConnection();
				ArrayList<Namestenost> nam = new ArrayList<Namestenost>();
				try {
					Statement upit = konekcija.createStatement();
					ResultSet rs = upit.executeQuery("SELECT * FROM namestenost;");
					while (rs.next())
					{
						Namestenost namestenost = new Namestenost(rs.getInt(1), rs.getString(2));
						nam.add(namestenost);
					}
				}catch (SQLException e)
				{
					e.printStackTrace();
				}
				setChanged();
				notifyObservers(nam);
				
			}

			
			public void SacuvajNamestenost (Namestenost namestenost) {
				MySqlConnection conn = new MySqlConnection();
				Connection konekcija = conn.getConnection();
				try {
					String query = "INSERT INTO namestenost (Naziv) VALUES (?)";
					PreparedStatement upit = konekcija.prepareStatement(query);
					upit.setString(1, namestenost.getNaziv());
					upit.executeUpdate();
				}catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
			public void getAllRealEstate (String uslov) {
				MySqlConnection con = new MySqlConnection();
				Connection konekcija = con.getConnection();
				ArrayList<Nekretnina> nek = new ArrayList<Nekretnina>();
				try {
					Statement upit = konekcija.createStatement();
					String u = "";
					if(uslov.equals(""))
					{
						u = "SELECT * FROM nekretnina;";
					}
					else
					{
						u = "SELECT * FROM nekretnina where Status='"+ uslov+"'";
					}
					ResultSet rs = upit.executeQuery(u);
					while(rs.next())
					{
						Nekretnina ne = new Nekretnina(rs.getInt(1), rs.getString(2), getTip(rs.getInt(3)), 
								getTipGradnje(rs.getInt(4)), getGrad(rs.getInt(5)), rs.getString(6), 
								getLokacija(rs.getInt(7)), rs.getInt(8), rs.getInt(9), rs.getInt(10), 
								getNamestenost(rs.getInt(11)), getGrejanje(rs.getInt(12)), rs.getString(13));
						nek.add(ne);
					}
				}catch (SQLException e)
				{
					e.printStackTrace();
				}
				setChanged();
				notifyObservers(nek);
			}

			
			public TipNekretnine getTip(int ID) {
				MySqlConnection con = new MySqlConnection();
				Connection konekcija = con.getConnection();
				TipNekretnine tipNek = null;
				try {
					Statement upit = konekcija.createStatement();
					ResultSet tip = upit.executeQuery("SELECT * FROM tip_nekretnine WHERE IDtip_nekretnine =" + ID);
					while (tip.next())
					{
						tipNek = new TipNekretnine(tip.getInt(1), tip.getString(2));
					}
					tip.close();
					upit.close();
				}catch (SQLException e)
				{
					e.printStackTrace();
				}finally 
				{
					try {
						konekcija.close();
					}catch (SQLException e)
					{
						e.printStackTrace();
					}
				}
				return tipNek;
			}
			
			public Grad getGrad(int ID) {
				MySqlConnection con = new MySqlConnection();
				Connection konekcija = con.getConnection();
				Grad grad = null;
				try {
					Statement upit = konekcija.createStatement();
					ResultSet gr = upit.executeQuery("SELECT * FROM grad WHERE IDgrad =" + ID);
					while (gr.next())
					{
						grad = new Grad(gr.getInt(1), gr.getString(2));
					}
					gr.close();
					upit.close();
				}catch (SQLException e)
				{
					e.printStackTrace();
				}finally 
				{
					try {
						konekcija.close();
					}catch (SQLException e)
					{
						e.printStackTrace();
					}
				}
				return grad;
			}
			
			
			
			public Lokacija getLokacija(int ID) {
				MySqlConnection con = new MySqlConnection();
				Connection konekcija = con.getConnection();
				Lokacija lokacija = null;
				try {
					Statement upit = konekcija.createStatement();
					ResultSet lok = upit.executeQuery("SELECT * FROM lokacija WHERE IDlokacija =" + ID);
					while (lok.next())
					{
						lokacija = new Lokacija(lok.getInt(1), lok.getString(2));
					}
					lok.close();
					upit.close();
				}catch (SQLException e)
				{
					e.printStackTrace();
				}finally 
				{
					try {
						konekcija.close();
					}catch (SQLException e)
					{
						e.printStackTrace();
					}
				}
				return lokacija;
			}
			
			public Namestenost getNamestenost(int ID) {
				MySqlConnection con = new MySqlConnection();
				Connection konekcija = con.getConnection();
				Namestenost namestenost = null;
				try {
					Statement upit = konekcija.createStatement();
					ResultSet nam = upit.executeQuery("SELECT * FROM namestenost WHERE IDnamestenost =" + ID);
					while (nam.next())
					{
						namestenost = new Namestenost(nam.getInt(1), nam.getString(2));
					}
					nam.close();
					upit.close();
				}catch (SQLException e)
				{
					e.printStackTrace();
				}finally 
				{
					try {
						konekcija.close();
					}catch (SQLException e)
					{
						e.printStackTrace();
					}
				}
				return namestenost;
			}
			
			public TipGradnje getTipGradnje(int ID)
			{
				MySqlConnection con = new MySqlConnection();
				Connection konekcija = con.getConnection();
				TipGradnje tipGr = null;
				try {
					Statement upit = konekcija.createStatement();
					ResultSet rs = upit.executeQuery("SELECT * FROM tip_gradnje WHERE IDTip_gradnje =" +ID);
					while (rs.next())
					{
						tipGr = new TipGradnje(rs.getInt(1), rs.getString(2));
					}
					rs.close();
					upit.close();
				}catch (SQLException e)
				{
					e.printStackTrace();
				}finally {
					try {
						konekcija.close();
					}catch (SQLException e)
					{
						e.printStackTrace();
					}
				}
				return tipGr;
			}
			
			public Grejanje getGrejanje(int ID) {
				MySqlConnection con = new MySqlConnection();
				Connection konekcija = con.getConnection();
				Grejanje grejanje = null;
				try {
					Statement upit = konekcija.createStatement();
					ResultSet grej = upit.executeQuery("SELECT * FROM grejanje WHERE IDgrejanje =" + ID);
					while (grej.next())
					{
						grejanje = new Grejanje(grej.getInt(1), grej.getString(2));
					}
					grej.close();
					upit.close();
				}catch (SQLException e)
				{
					e.printStackTrace();
				}finally 
				{
					try {
						konekcija.close();
					}catch (SQLException e)
					{
						e.printStackTrace();
					}
				}
				return grejanje;
			}
			
			public Nekretnina getNekretnina(int ID)
			{
				MySqlConnection con = new MySqlConnection();
				Connection konekcija = con.getConnection();
				Nekretnina nekretnina = null;
				try {
					Statement upit = konekcija.createStatement();
					ResultSet nekr = upit.executeQuery("SELECT * FROM nekretnina WHERE IDnekretnina =" +ID);
					while (nekr.next())
					{
						nekretnina = new Nekretnina(nekr.getInt(1),nekr.getString(2), getTip(nekr.getInt(3)), getTipGradnje(nekr.getInt(4)),
								getGrad(nekr.getInt(5)), nekr.getString(6), getLokacija(nekr.getInt(7)), nekr.getInt(8), nekr.getInt(9), 
								nekr.getInt(10), getNamestenost(nekr.getInt(11)), getGrejanje(nekr.getInt(12)), nekr.getString(13));
					}
						nekr.close();
						upit.close();
					
					}catch (SQLException e)
					{
						e.printStackTrace();
					}finally
					{
						try {
							konekcija.close();
						}catch(SQLException e)
						{
							e.printStackTrace();
						}
					}
					return nekretnina;
				
			}
			
			public void SacuvajNekretnina(Nekretnina nekretnina)
			{
				MySqlConnection conn = new MySqlConnection();
				Connection konekcija = conn.getConnection();
				try {
					String query = "INSERT INTO nekretnina(SifraNekretnine, TipNekretnine, Tip_gradnje, Grad,Adresa,Lokacija,Povrsina,Broj_soba,Broj_kupatila,Namestenost,Grejanje,Status) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
					PreparedStatement upit = konekcija.prepareStatement(query);
					upit.setString(1, nekretnina.getSifraNekretnine());
					upit.setInt(2, nekretnina.getTipNekretnine().getIDtip_nekretnine());
					upit.setInt(3, nekretnina.getTipGradnje().getIDTip_gradnje());
					upit.setInt(4, nekretnina.getGrad().getIDgrad());
					upit.setString(5, nekretnina.getAdresa());
					upit.setInt(6, nekretnina.getLokacija().getIDlokacija());
					upit.setInt(7, nekretnina.getPovrsina());
					upit.setInt(8, nekretnina.getBroj_soba());
					upit.setInt(9, nekretnina.getBroj_kupatila());
					upit.setInt(10, nekretnina.getNamestenost().getIDnamestenost());
					upit.setInt(11, nekretnina.getGrejanje().getIDgrejanje());
					upit.setString(12, "Slobodno");
					upit.executeUpdate();
					
				}catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
			
			public void GetQueryResult(String upit)
			{
				MySqlConnection con = new MySqlConnection();
				Connection konekcija = con.getConnection();
				ArrayList<Nekretnina> tipGr = new ArrayList<Nekretnina>();
				try {
					Statement q = konekcija.createStatement();
					ResultSet rs = q.executeQuery(upit);
					
					while (rs.next())
					{
						Nekretnina ne = new Nekretnina(rs.getInt(1), rs.getString(2), getTip(rs.getInt(3)), 
								getTipGradnje(rs.getInt(4)), getGrad(rs.getInt(5)), rs.getString(6), 
								getLokacija(rs.getInt(7)), rs.getInt(8), rs.getInt(9), rs.getInt(10), 
								getNamestenost(rs.getInt(11)), getGrejanje(rs.getInt(12)), rs.getString(13));
						tipGr.add(ne);
					}
					
				}catch (SQLException e)
				{
					e.printStackTrace();
				}
				setChanged();
				notifyObservers(tipGr);
			}
			
			public void getAllTypesOfConstruction () {
				MySqlConnection con = new MySqlConnection();
				Connection konekcija = con.getConnection();
				ArrayList<TipGradnje> tipGr = new ArrayList<TipGradnje>();
				try {
					Statement upit = konekcija.createStatement();
					ResultSet rs = upit.executeQuery("SELECT * FROM tip_gradnje;");
					while (rs.next())
					{
						TipGradnje tipGradnje = new TipGradnje(rs.getInt(1), rs.getString(2));
						tipGr.add(tipGradnje);
					}
				}catch (SQLException e)
				{
					e.printStackTrace();
				}
				setChanged();
				notifyObservers(tipGr);
			}
			
			public void SacuvajTipGradnje(TipGradnje tipgradnje)
			{
				MySqlConnection conn = new MySqlConnection();
				Connection konekcija = conn.getConnection();
				try {
					String query = "INSERT INTO tip_gradnje(Naziv) VALUES (?)";
					PreparedStatement upit = konekcija.prepareStatement(query);
					upit.setString(1, tipgradnje.getNaziv());
					upit.executeUpdate();
				}catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
			
			public void getTipNekretnine () {
				MySqlConnection con = new MySqlConnection();
				Connection konekcija = con.getConnection();
				ArrayList<TipNekretnine> tipNekretnine = new ArrayList<TipNekretnine>();
				try {
					Statement upit = konekcija.createStatement();
					ResultSet rs = upit.executeQuery("SELECT * FROM tip_nekretnine");
					while (rs.next())
					{
						TipNekretnine tipnekretnine = new TipNekretnine(rs.getInt(1), rs.getString(2));
						tipNekretnine.add(tipnekretnine);
					}
				}catch (SQLException e)
				{
					e.printStackTrace();
				}
				setChanged();
				notifyObservers(tipNekretnine);
			}

			
				
				public void getAllEmmployers () {
					MySqlConnection con = new MySqlConnection();
					Connection konekcija = con.getConnection();
					ArrayList<Zaposleni> zap = new ArrayList<Zaposleni>();
					try {
						Statement upit = konekcija.createStatement();
						ResultSet rs = upit.executeQuery("SELECT * FROM zaposleni;");
						while (rs.next())
						{
							Zaposleni zaposleni = new Zaposleni (rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
							zap.add(zaposleni);
						}
					}catch (SQLException e)
					{
						e.printStackTrace();
					}
					setChanged();
					notifyObservers(zap);
				}
				
				public Zaposleni getZaposleni(int ID)
				{
					MySqlConnection conn = new MySqlConnection();
					Connection konekcija = conn.getConnection();
					Zaposleni zaposleni = null;
					try {
						Statement upit = konekcija.createStatement();
						ResultSet z = upit.executeQuery("SELECT * FROM zaposleni WHERE IDzaposleni =" +ID);
						while (z.next())
							{
							zaposleni = new Zaposleni(z.getInt(1), z.getString(2), z.getString(3), z.getString(4));
							}
						z.close();
						upit.close();
								
					}catch (SQLException e)
					{
						e.printStackTrace();
					}finally 
					{
						try {
							konekcija.close();
						}catch (SQLException e)
						{
							e.printStackTrace();
						}
					}
					return zaposleni;
				}
				
				public void SacuvajZaposleni (Zaposleni zaposleni) {
					MySqlConnection conn = new MySqlConnection();
					Connection konekcija = conn.getConnection();
					try {
						String query = "INSERT INTO zaposleni(Sifrazaposleni, ImeIPrezimezaposleni,TelefonZaposleni) VALUES (?,?,?)";
						PreparedStatement upit = konekcija.prepareStatement(query);
						upit.setString(1, zaposleni.getSifrazaposleni());
						upit.setString(2, zaposleni.getImeIPrezimezaposleni());
						upit.setString(3, zaposleni.getTelefonzaposleni());
						upit.executeUpdate();
					} catch (SQLException e)
					{
						e.printStackTrace();
					}
				}
				
				public void getAllSales()
				{
					MySqlConnection con = new MySqlConnection();
					Connection konekcija = con.getConnection();
					ArrayList<Prodaja> prod = new ArrayList<Prodaja>();
					try {
						Statement upit = konekcija.createStatement();
						ResultSet rs = upit.executeQuery("SELECT * FROM prodaja;");
						while(rs.next())
						{
							Prodaja prodaja = new Prodaja(rs.getInt(1),rs.getLong(2), rs.getString(3),
									 getKupac(rs.getInt(4)) , 
									getZaposleni(rs.getInt(5)));
							prod.add(prodaja);
						}
					} catch (SQLException e)
					{
						e.printStackTrace();
					}
					if(prod.size()>0) {
						setChanged();
						notifyObservers(prod);
					}
				}
					public void getStavkeProdaje()
					{
						MySqlConnection con = new MySqlConnection();
						Connection konekcija = con.getConnection();
						ArrayList<StavkeProdaje> stavke = new ArrayList<StavkeProdaje>();
						try {
							Statement upit = konekcija.createStatement(); ////// !!!!!!!!///////
							ResultSet rs = upit.executeQuery("SELECT * FROM stavke_prodaje");
							while(rs.next())
							{                ///////////// ??????????????? //////////////
								StavkeProdaje stP = new StavkeProdaje(rs.getInt(1), getProdaja(rs.getInt(2)),  getNekretnina(rs.getInt(3)), rs.getDouble(4));
								stavke.add(stP);
							}
					}catch (SQLException e)
						{
						e.printStackTrace();
						}
						setChanged();
						notifyObservers(stavke);
				}
					
					public Prodaja getProdaja(int ID)
					{
						MySqlConnection con = new MySqlConnection();
						Connection konekcija = con.getConnection();
						Prodaja prodaja = null;
						try {
							Statement upit = konekcija.createStatement();
							ResultSet rs = upit.executeQuery("SELECT * FROM prodaja WHERE IDevidencija_prodaje = "+ID);
							while(rs.next())
							{
								prodaja = new Prodaja(rs.getInt(1), rs.getLong(2),rs.getString(3),  getKupac(rs.getInt(4)), getZaposleni(rs.getInt(5)));
							}
							rs.close();
							upit.close();
							}catch (SQLException e)
						{
								e.printStackTrace();
						}finally
						{
							try {
								konekcija.close();
							}catch (SQLException e)
							{
								e.printStackTrace();
							}
						}
						return prodaja;
					}
					
					public void IzmeniProdaja (Prodaja pr)
					{
						MySqlConnection con = new MySqlConnection();
						Connection konekcija = con.getConnection();
						try {
							System.out.println(pr.getIDevidencija_prodaje());
							String query = "UPDATE izdavanjenekretnina.prodaja SET "
									+ "Broj_prodaje=?, Datum_prodaje=?, Kupac=?, Zaposleni=? "
									+ "WHERE (IDprodaja ="+ pr.getIDevidencija_prodaje() + ")";
							PreparedStatement upit = konekcija.prepareStatement(query);
							upit.setString(1, pr.getBroj_prodaje());
							upit.setLong(2, pr.getDatum_prodaje());
							upit.setInt(3, pr.getKupac().getIDkupac());
							upit.setInt(4, pr.getZaposleni().getIDzaposleni());
							upit.executeQuery();
							
						}catch (SQLException e)
						{
							e.printStackTrace();
						}
					}
					
					public void SacuvajProdaja(Prodaja pr)
					{
						MySqlConnection conn = new MySqlConnection();
						Connection konekcija = conn.getConnection();
						try {
							String query = "INSERT INTO izdavanjenekretnina.prodaja(Broj_prodaje, Datum_prodaje, Kupac, Zaposleni) VALUES (?,?,?,?)";
							PreparedStatement upit = konekcija.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
							upit.setString(1, pr.getBroj_prodaje());
							upit.setLong(2, pr.getDatum_prodaje());
							upit.setInt(3, pr.getKupac().getIDkupac());
							upit.setInt(4, pr.getZaposleni().getIDzaposleni());
							int ID = upit.executeUpdate();
							ResultSet rs = upit.getGeneratedKeys();
							if(rs.next())
							{
							ID = rs.getInt(1);	
							}
							pr.setIDevidencija_prodaje(ID);
						}catch (SQLException e)
						{
							e.printStackTrace();
						}
					}
					
					public void SacuvajStavke(StavkeProdaje sp)
					{
						MySqlConnection conn = new MySqlConnection();
						Connection konekcija = conn.getConnection();
						try {
							String query = "INSERT INTO izdavanjenekretnina.stavke_prodaje(IDProdaje,Nekretnina,Cena_po_kvadratu) VALUES (?,?,?)";
							PreparedStatement upit = konekcija.prepareStatement(query);
							upit.setInt(1, sp.getProdaja().getIDevidencija_prodaje());
							upit.setInt(2, sp.getNekretnina().getIDnekretnina());
							upit.setDouble(3, sp.getCena_po_kvadratu());
							upit.executeUpdate();
						}catch (SQLException e)
						{
							e.printStackTrace();
						}
					}
					
					public void SacuvajIznajmljivanje(Iznajmljivanje iznm)
					{
						MySqlConnection conn = new MySqlConnection();
						Connection konekcija = conn.getConnection();
						try {
							String query = "INSERT INTO izdavanjenekretnina.iznajmljivanja(Broj_iznajmljivanja,"
									+ "Kupac,Zaposleni) VALUES (?,?,?)";
							PreparedStatement upit = konekcija.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
							upit.setString(1, iznm.getBroj_iznajmljivanja());
							upit.setInt(2, iznm.getKupac().getIDkupac());
							upit.setInt(3, iznm.getZaposleni().getIDzaposleni());
							int ID = upit.executeUpdate();
							ResultSet rs = upit.getGeneratedKeys();
							if(rs.next())
							{
								ID=rs.getInt(1);
							}
								iznm.setIDevidencija_iznajmljivanja(ID);
							}catch (SQLException e)
						{
								e.printStackTrace();
						}
					}
					
					public void getAllRents()
					{
						MySqlConnection con = new MySqlConnection();
						Connection konekcija = con.getConnection();
						ArrayList<Iznajmljivanje> najam = new ArrayList<Iznajmljivanje>();
						
							try {
								Statement upit = konekcija.createStatement();
								ResultSet rs = upit.executeQuery("SELECT * FROM iznajmljivanja;");
								while(rs.next())
								{
									Iznajmljivanje izn = new Iznajmljivanje(rs.getInt(1), rs.getString(2), getKupac(rs.getInt(3)), getZaposleni(rs.getInt(4)));
									najam.add(izn);
								}
							}catch (SQLException e)
							{
								e.printStackTrace();
							}
							if(najam.size()>0) {
							setChanged();
							notifyObservers(najam);
							}
						}
					
					public Iznajmljivanje getIznajmljivanje(int ID)
					{
						MySqlConnection con = new MySqlConnection();
						Connection konekcija = con.getConnection();
						Iznajmljivanje iznajmljivanje = null;
						try {
							Statement upit = konekcija.createStatement();
							ResultSet rs = upit.executeQuery("SELECT * FROM iznajmljivanja WHERE IDevidencija_iznajmljivanja = " +ID);
							while(rs.next())
							{
								iznajmljivanje = new Iznajmljivanje(rs.getInt(1), rs.getString(2), getKupac(rs.getInt(3)), getZaposleni(rs.getInt(4)));
							}
							rs.close();
							upit.close();
						}catch (SQLException e)
						{
							e.printStackTrace();
						}finally 
						{
							try {
								konekcija.close();
							}catch (SQLException e)
							{
								e.printStackTrace();
							}
						}
						return iznajmljivanje;
					}
				
					public void getStavkeIznajmljivanja()
					{
						MySqlConnection con = new MySqlConnection();
						Connection konekcija = con.getConnection();
						ArrayList<StavkeIznajmljivanja> stavkeIz = new ArrayList<StavkeIznajmljivanja>();
						try {
							Statement upit = konekcija.createStatement();
							ResultSet rs = upit.executeQuery("SELECT * FROM izdavanjenekretnina.stavke_iznajmljivanja;");
							while(rs.next())
							{
								StavkeIznajmljivanja stIz = new StavkeIznajmljivanja(rs.getInt(1), getIznajmljivanje(rs.getInt(2)), getNekretnina(rs.getInt(3)), rs.getLong(4), rs.getLong(5), rs.getDouble(6));
								stavkeIz.add(stIz);
							}
						}catch (SQLException e)
						{
							e.printStackTrace();
						}
						setChanged();
						notifyObservers(stavkeIz);
					}
					
					
					public void SacuvajStavkeIz(StavkeIznajmljivanja sIZ)
					{
						MySqlConnection conn = new MySqlConnection();
						Connection konekcija = conn.getConnection();
						try {
							String query = "INSERT INTO izdavanjenekretnina.stavke_iznajmljivanja(IDIznajmljivanje, Nekretnina, Datum_pocetak, Datum_kraj, Cena) VALUES (?,?,?,?,?)";
							PreparedStatement upit = konekcija.prepareStatement(query);
							upit.setInt(1, sIZ.getIznajmljivanje().getIDevidencija_iznajmljivanja());
							upit.setInt(2, sIZ.getNekretnina().getIDnekretnina());
							upit.setLong(3, sIZ.getDatum_pocetak());
							upit.setLong(4, sIZ.getDatum_kraj());
							upit.setDouble(5, sIZ.getCena());
							upit.executeUpdate();
						}catch (SQLException e)
						{
							e.printStackTrace();
						}
					}
					
					public void IzmeniStavkeIznajmljivanja(StavkeIznajmljivanja stavke) { // ZAVRSAVANJE IZNAJMLJIVANJA I VRACANJE STATUSA NEKRETNINE U SLOBODNU
						MySqlConnection con = new MySqlConnection();
						Connection konekcija = con.getConnection();
						try {
							String query = "UPDATE izdavanjenekretnina.stavke_iznajmljivanja SET  Datum_kraj = ?   WHERE IDstavkeIznajmljivanja = "+ stavke.getIDstavkeIznajmljivanja() ;
							PreparedStatement upit = konekcija.prepareStatement(query);
							upit.setLong(1, stavke.getDatum_kraj());
							
							upit.executeUpdate();
							
							String query1 = "UPDATE izdavanjenekretnina.nekretnina SET Status=? WHERE IDnekretnina = "+stavke.getNekretnina().getIDnekretnina() ;
							PreparedStatement upit1 = konekcija.prepareStatement(query1);
							upit1.setString(1, "Slobodno");
							
							upit1.executeUpdate();
							
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					
					public ArrayList<StavkeIznajmljivanja> getAllStavkeIznajmljivanjaForID (int ID)
					{
						MySqlConnection con = new MySqlConnection();
						Connection konekcija = con.getConnection();
						ArrayList<StavkeIznajmljivanja> stavke = new ArrayList<StavkeIznajmljivanja>();
						try {
							Statement upit = konekcija.createStatement();
							ResultSet rs = upit.executeQuery("Select * FROM izdavanjenekretnina.stavke_iznajmljivanja si where si.nekretnina=" +ID);
							while(rs.next())
							{
								StavkeIznajmljivanja si = new StavkeIznajmljivanja (rs.getInt(1), getIznajmljivanje(rs.getInt(2)), 
										getNekretnina(rs.getInt(3)), rs.getLong(4), rs.getLong(5), rs.getDouble(6));
								stavke.add(si);
							}
							rs.close();
							upit.close();
						}catch(SQLException e)
						{
							e.printStackTrace();
					}
						finally {
							try {
								konekcija.close();
							}catch (SQLException e)
							{
								e.printStackTrace();
							}
						}
						return stavke;
					}
					
				//////////////// IZMENI //////////////////////////	
					
					public void IzmeniSTATUSnekretninePRODAJA(Nekretnina N) {
						MySqlConnection conn = new MySqlConnection();
						Connection konekcija = conn.getConnection();
						try {
							
							String query = "UPDATE izdavanjenekretnina.nekretnina SET Status=?  WHERE IDnekretnina = "+N.getIDnekretnina() +" ";
							PreparedStatement upit = konekcija.prepareStatement(query);
							
							upit.setString(1, "Prodato");
							upit.executeUpdate();
										
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					
					public void IzmeniSTATUSnekretnineIZNAJMLJIVANJE(Nekretnina NN) {
						MySqlConnection conn = new MySqlConnection();
						Connection konekcija = conn.getConnection();
						try {
							
							String query = "UPDATE izdavanjenekretnina.nekretnina SET Status=?  WHERE IDnekretnina = "+NN.getIDnekretnina() +" ";
							PreparedStatement upit = konekcija.prepareStatement(query);
							
							upit.setString(1, "Iznajmljeno");
							upit.executeUpdate();
										
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					
					public void IzmeniNekretnina(Nekretnina NEK) {
						MySqlConnection conn = new MySqlConnection();
						Connection konekcija = conn.getConnection();
						try {
							
							String query = "UPDATE izdavanjenekretnina.nekretnina SET SifraNekretnine =?,TipNekretnine=?, Tip_gradnje=?, Grad=?,"
							+ "Adresa=?,Lokacija=?,Povrsina=?,Broj_soba=?,Broj_kupatila=?,Namestenost=?,Grejanje=?,Status=? "
							+ "WHERE (IDNekretnina = "+ NEK.getIDnekretnina() +")";
							

							PreparedStatement upit = konekcija.prepareStatement(query);
							upit.setString(1, NEK.getSifraNekretnine());
							upit.setInt(2, NEK.getTipNekretnine().getIDtip_nekretnine());
							upit.setInt(3, NEK.getTipGradnje().getIDTip_gradnje());
							upit.setInt(4, NEK.getGrad().getIDgrad());
							upit.setString(5, NEK.getAdresa());
							upit.setInt(6, NEK.getLokacija().getIDlokacija());
							upit.setInt(7, NEK.getPovrsina());
							upit.setInt(8, NEK.getBroj_soba());
							upit.setInt(9, NEK.getBroj_kupatila());
							upit.setInt(10, NEK.getNamestenost().getIDnamestenost());
							upit.setInt(11, NEK.getGrejanje().getIDgrejanje());
							upit.setString(12, "Slobodno");
							upit.executeUpdate();
										
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					
					///////////////////////////////////////////IZVESTAJI/////////////////
					
					public void getSoldRealEstateReport()
					{
						MySqlConnection con = new MySqlConnection();
						Connection konekcija = con.getConnection();
						ArrayList<StavkeProdaje> stavke = new ArrayList<StavkeProdaje>();
						try {
							Statement upit = konekcija.createStatement();
							ResultSet rs = upit.executeQuery("SELECT nekretnina, ne.povrsina, Cena_po_kvadratu, Cena_po_kvadratu*ne.Povrsina as ukupno, ((Cena_po_kvadratu*ne.Povrsina*3/100)) as provizija   FROM izdavanjenekretnina.stavke_prodaje sp left join nekretnina ne on sp.Nekretnina = ne.IDnekretnina group by nekretnina;");
							while(rs.next())
							{
								StavkeProdaje sp = new StavkeProdaje(getNekretnina(rs.getInt(1)),rs.getInt(2), rs.getDouble(3), rs.getString(4),rs.getString(5));
								stavke.add(sp);
								
										}
							}catch (SQLException e)
						{
								e.printStackTrace();
						}
						setChanged();
						notifyObservers(stavke);
					}
					
					public void getRentRealEstateReport()
					{
						MySqlConnection con = new MySqlConnection();
						Connection konekcija = con.getConnection();
						ArrayList<StavkeIznajmljivanja> stavke = new ArrayList<StavkeIznajmljivanja>();
						try {
							Statement upit = konekcija.createStatement();
							ResultSet rs = upit.executeQuery("SELECT distinct zaposleni, nekretnina, Datum_pocetak, Datum_kraj, cena, \r\n" + 
									"(((Datum_kraj-Datum_pocetak)/(10.0  * 360.0 * 24.0)) / 30.0) as 'Ukupan broj meseci', \r\n" + 
									"(((Datum_kraj-Datum_pocetak)/(10.0  * 360.0 * 24.0)) / 30.0)*cena as Zarada, cena/2 as provizija\r\n" + 
									"from izdavanjenekretnina.iznajmljivanja iz right join stavke_iznajmljivanja si\r\n" + 
									"on iz.IDevidencija_iznajmljivanja = si.IDIznajmljivanje order by zaposleni;");
							while(rs.next())
							{
								StavkeIznajmljivanja si = new StavkeIznajmljivanja(getZaposleni(rs.getInt(1)), getNekretnina(rs.getInt(2)), rs.getLong(3), rs.getLong(4), rs.getString(6), rs.getDouble(5), rs.getString(7), rs.getString(8));
								stavke.add(si);
							}
						}catch (SQLException e)
						{
							e.printStackTrace();
						}
						setChanged();
						notifyObservers(stavke);
					}

				public void getSellthepropertybyagents () 
				{
					MySqlConnection con = new MySqlConnection();
					Connection konekcija = con.getConnection();
					ArrayList<Prodaja> prod = new ArrayList<Prodaja>();
					try {
						Statement upit = konekcija.createStatement();
						ResultSet rs = upit.executeQuery("SELECT distinct zaposleni, nekretnina FROM izdavanjenekretnina.prodaja pr right join stavke_prodaje sp on pr.IDevidencija_prodaje = sp.IDProdaje;");
						while(rs.next())
						{
							Prodaja pr = new Prodaja(getZaposleni(rs.getInt(1)), getNekretnina(rs.getInt(2)));
							prod.add(pr);
						}
					}catch (SQLException e)
					{
						e.printStackTrace();
					}
					setChanged();
					notifyObservers(prod);
				}
				
			public ArrayList<StavkeIznajmljivanja> getRentsByAgents (int ID)
			{
				MySqlConnection con = new MySqlConnection();
				Connection konekcija = con.getConnection();
				ArrayList<StavkeIznajmljivanja> st = new ArrayList<StavkeIznajmljivanja>();
				try {
					Statement upit = konekcija.createStatement();
					ResultSet rs = upit.executeQuery("SELECT distinct zaposleni, nekretnina, Datum_pocetak, Datum_kraj, cena, \r\n" + 
							"(((Datum_kraj-Datum_pocetak)/(10.0  * 360.0 * 24.0)) / 30.0) as 'Ukupan broj meseci', \r\n" + 
							"(((Datum_kraj-Datum_pocetak)/(10.0  * 360.0 * 24.0)) / 30.0)*cena as Zarada, cena/2 as provizija \r\n" + 
							"from izdavanjenekretnina.iznajmljivanja iz right join stavke_iznajmljivanja si \r\n" + 
							"on iz.IDevidencija_iznajmljivanja = si.IDIznajmljivanje where zaposleni=" +ID);
					while (rs.next())
					{
						StavkeIznajmljivanja S = new StavkeIznajmljivanja(getZaposleni(rs.getInt(1)), getNekretnina(rs.getInt(2)), rs.getLong(3), rs.getLong(4), rs.getString(6), rs.getDouble(5), rs.getString(7), rs.getString(8));
						st.add(S);
					}
				}catch (SQLException e)
				{
					e.printStackTrace();
				}
				return st;
			}
			
			public   ArrayList<StavkeProdaje> getSalesByAgents (int ID )
			{
				
				
				MySqlConnection conn = new MySqlConnection();
				Connection konekcija = conn.getConnection();
				ArrayList<StavkeProdaje> sp = new ArrayList<StavkeProdaje>();
				try {
					
					String query = "SELECT zaposleni, nekretnina, ne.povrsina, Cena_po_kvadratu, Cena_po_kvadratu*ne.Povrsina as ukupno, ((Cena_po_kvadratu*ne.Povrsina*3/100)) as provizija, (((Cena_po_kvadratu*ne.Povrsina*3/100))*20/100) as 'Provizija zaposlenog'	\r\n" + 
							"FROM prodaja inner join stavke_prodaje sp on sp.IDProdaje = prodaja.IDevidencija_prodaje left join nekretnina ne on sp.Nekretnina = ne.IDnekretnina where zaposleni="+ID+" group by nekretnina";
					Statement upit = konekcija.createStatement();
					ResultSet rs = upit.executeQuery(query);
					while(rs.next())
					{
						sp.add(new StavkeProdaje(getZaposleni(rs.getInt(1)), getNekretnina(rs.getInt(2)), rs.getDouble(3), rs.getInt(4), rs.getString(5), rs.getString(6), rs.getString(7)));
								
					}
								
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				
			}
				return sp;

		}
	}
			
			
			