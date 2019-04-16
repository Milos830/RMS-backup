package View;

import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.event.ActionListener;
import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


import Data.Kupac;
import Data.Nekretnina;
import Data.Zaposleni;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuItem;
import java.awt.Color;

public class frmProdaja extends JFrame {
	private JTextField txtDatum;
	private JComboBox cbKupac;
	private JComboBox cbZaposleni;
	private JButton btnSacuvaj;
	public JComboBox cbNekretnina;
	private JTextField txtCena;
	private JTable tblProdaja;
	private JTextField txtBrojProdaje;
	private JButton btnStavke;
	private JButton btnZavrsi;

	

	public frmProdaja(String arg0)  {
		super(arg0);
		getContentPane().setBackground(new Color(102, 205, 170));
		initialize();
	}

	private void initialize()
	{
		setBounds(100,200,537,596);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblDatum = new JLabel("Datum:");
		lblDatum.setBounds(10, 14, 46, 14);
		getContentPane().add(lblDatum);
		
		txtDatum = new JTextField();
		txtDatum.setBounds(101, 11, 120, 20);
		getContentPane().add(txtDatum);
		txtDatum.setColumns(10);
		
		cbKupac = new JComboBox();
		cbKupac.setBounds(101, 72, 120, 20);
		getContentPane().add(cbKupac);
		
		JLabel lblKupac = new JLabel("Kupac:");
		lblKupac.setBounds(10, 75, 46, 14);
		getContentPane().add(lblKupac);
		
		JLabel lblZaposleni = new JLabel("Zaposleni:");
		lblZaposleni.setBounds(10, 106, 56, 14);
		getContentPane().add(lblZaposleni);
		
		cbZaposleni = new JComboBox();
		cbZaposleni.setBounds(101, 103, 120, 20);
		getContentPane().add(cbZaposleni);
		
		btnSacuvaj = new JButton("Kreiraj racun");
		btnSacuvaj.setBounds(368, 35, 130, 23);
		getContentPane().add(btnSacuvaj);
		
		JLabel lblNekretnina = new JLabel("Nekretnina:");
		lblNekretnina.setBounds(10, 148, 70, 14);
		getContentPane().add(lblNekretnina);
		
		cbNekretnina = new JComboBox();
		cbNekretnina.setEnabled(false);
		cbNekretnina.setBounds(101, 145, 120, 20);
		getContentPane().add(cbNekretnina);
		
		JLabel lblCena = new JLabel("Cena:");
		lblCena.setBounds(10, 176, 46, 14);
		getContentPane().add(lblCena);
		
		txtCena = new JTextField();
		txtCena.setEnabled(false);
		txtCena.setBounds(101, 173, 120, 20);
		getContentPane().add(txtCena);
		txtCena.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 208, 501, 345);
		getContentPane().add(scrollPane);
		
		tblProdaja = new JTable();
		tblProdaja.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblProdaja);
		
		JPopupMenu popupMenu = new JPopupMenu();
		addPopup(tblProdaja, popupMenu);
		
		JMenuItem mntmIzmeni = new JMenuItem("Izmeni");
		popupMenu.add(mntmIzmeni);
		
		JLabel lblBrojProdaje = new JLabel("Broj prodaje:");
		lblBrojProdaje.setBounds(10, 39, 70, 14);
		getContentPane().add(lblBrojProdaje);
		
		txtBrojProdaje = new JTextField();
		txtBrojProdaje.setBounds(101, 42, 120, 20);
		getContentPane().add(txtBrojProdaje);
		txtBrojProdaje.setColumns(10);
		
		btnStavke = new JButton("Dodaj stavku");
		btnStavke.setEnabled(false);
		btnStavke.setBounds(368, 102, 130, 23);
		getContentPane().add(btnStavke);
		
		btnZavrsi = new JButton("Zavrsi");
		btnZavrsi.setEnabled(false);
		btnZavrsi.setBounds(368, 172, 130, 23);
		getContentPane().add(btnZavrsi);
	}
	/////////// SETERI I GETERI
	public String getBrojProdaje()
	{
		return txtBrojProdaje.getText();
	}
	
	public void setBrojProdaje(String brP)
	{
		txtBrojProdaje.setText(brP);
	}
	
	
	
	
	
	public double getCena()
	{
		return Double.parseDouble(txtCena.getText());
	}
	
	public void setCena(double cena)
	{
		txtCena.setText(Double.toString(cena));
	}
	
	public long getDate()
	{
		long datum =0;
		 try {
			Date date=(Date) new SimpleDateFormat("dd.MM.yyyy").parse(txtDatum.getText());
			datum = date.getTime()/1000;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 System.out.println(datum);
		 return datum;
	}
	
	public void setDate(long timestamp)
	{
		Date date = new Date(timestamp*1000);
		try {
			txtDatum.setText(new SimpleDateFormat("dd.MM.yyyy").parse(date.toString()).toString());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

/////////////////////// Kombo boksevi
	
	public Object getKupac()
	{
		return cbKupac.getSelectedItem();
	}
	
	public Object getZaposleni()
	{
		return cbZaposleni.getSelectedItem();
	}
	
	public Object getNekretnina()
	{
		return cbNekretnina.getSelectedItem();
	}
	
	public void setKupacCB (ArrayList<Kupac> kupci)
	{
		for (Kupac k : kupci) {
			cbKupac.addItem(k);
			
		}
	}
	
	public void setZaposleniCB (ArrayList<Zaposleni> zap)
	{
		for (Zaposleni z : zap) {
			cbZaposleni.addItem(z);
			
		}
	}
	
	public void setNekretninaCB (ArrayList<Nekretnina> nek)
	{
		
		for (Nekretnina n : nek) {
			cbNekretnina.addItem(n);
			
		}
	}
	
//	public void RemoveNekretninaCB(ArrayList<Nekretnina> nekr)
//	{
//		for(Nekretnina ne : nekr)
//		{
//			cbNekretnina.removeItem(cbNekretnina.getSelectedItem());
//		}
//	}
	
	public void setkupacCB(int ID)
	{
		for(int i=0; i<cbKupac.getItemCount(); i++)
		{
			if(((Kupac)cbKupac.getItemAt(i)).getIDkupac()==ID)
			{
				cbKupac.setSelectedIndex(i);
			}
		}
	}
	
	public void setzaposleniCB(int ID)
	{
		for(int i=0; i<cbZaposleni.getItemCount(); i++)
		{
			if(((Zaposleni)cbZaposleni.getItemAt(i)).getIDzaposleni()==ID)
			{
				cbZaposleni.setSelectedIndex(i);
			}
		}
	}
	
	public void setnekretninaCB(int ID)
	{
		for(int i=0; i<cbNekretnina.getItemCount(); i++)
		{
			if(((Nekretnina)cbNekretnina.getItemAt(i)).getIDnekretnina()==ID)
			{
				cbNekretnina.setSelectedIndex(i);
				
			}
		}
	}
	//////////// ?????????????????????????????????????? /////////////
//	public void removeNekretninaCB(int ID)
//	{
//		if(cbKupac.getItemCount()>0 && cbNekretnina.getItemCount()>0)
//		{
//			Kupac kupac = (Kupac) cbKupac.getSelectedItem();
//			Nekretnina rezervisanaNek = (Nekretnina) cbNekretnina.getSelectedItem();
//			kupac.setNekretnina(rezervisanaNek);
//			cbNekretnina.removeItem(rezervisanaNek);
//		}
//			
//		
//	}
	
	////////////////// Tabela
	
	public void setTableData(String[] zaglavlje, Object[][] podaci)
	{
		tblProdaja.setModel(new DefaultTableModel(podaci, zaglavlje));
	}
	
	public void setSacuvajLsn(ActionListener sacuvaj)
	{
		btnSacuvaj.addActionListener(sacuvaj);
	}
	
	public void setStavkeLsn(ActionListener stavke)
	{
		btnStavke.addActionListener(stavke);
	}
	
	public void setZavrsiLsn(ActionListener zavrsi)
	{
		btnStavke.addActionListener(zavrsi);
	}
	public void ClearTable() {
		DefaultTableModel model = (DefaultTableModel) tblProdaja.getModel();
		model.setRowCount(0);
	}
	
	public void EnableStavke()
	{
		cbNekretnina.setEnabled(true);
		txtCena.setEnabled(true);
		btnStavke.setEnabled(true);
		btnZavrsi.setEnabled(true);
	}
	
	public void ClearFilds()
	{
		txtDatum.setText("");
		txtCena.setText("");
		txtBrojProdaje.setText("");
	}
	
	
	
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
