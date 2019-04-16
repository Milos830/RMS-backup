package View;

import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JSplitPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.sun.corba.se.spi.orbutil.fsm.Action;
import com.sun.jmx.snmp.Timestamp;
import com.sun.org.apache.bcel.internal.generic.GETFIELD;

import Data.Iznajmljivanje;
import Data.Kupac;
import Data.Nekretnina;
import Data.Zaposleni;

import java.awt.Insets;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import javax.swing.UIManager;

public class frmIznajmljivanje extends JFrame {
	private JPanel pnlGornji;
	private JComboBox cbNekretnina;
	private JTextField txtDatumPocetak;
	private JTextField txtDatumKraj;
	private JTextField txtCenaIznajmljivanja;
	private JTable tblIznajmljivanje;
	private JButton btnIznajmi;
	private JComboBox cbKupac;
	private JComboBox cbZaposleni;
	private JLabel lblBrojIznajmljivanja;
	private JTextField txtBrIznajmljivanja;
	private JTextField txtDatumRazlika;
	private JPopupMenu popupMenu;
	private JMenuItem mntmZavrsiIznajmljivanje;

	

	public frmIznajmljivanje(String title)  {
		super(title);
		
		
		initialize();
	
	}
	
	private void initialize() {
		setBounds(100,200,861,767);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		JSplitPane splitPane = new JSplitPane();
		splitPane.setResizeWeight(0.3);
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		getContentPane().add(splitPane, BorderLayout.CENTER);
		
		pnlGornji = new JPanel();
		pnlGornji.setBackground(new Color(119, 136, 153));
		pnlGornji.setForeground(Color.RED);
		splitPane.setLeftComponent(pnlGornji);
		GridBagLayout gbl_pnlGornji = new GridBagLayout();
		gbl_pnlGornji.columnWidths = new int[]{0, 0, 0, 253, 0, 0, 0, 0, 0, 0};
		gbl_pnlGornji.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_pnlGornji.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_pnlGornji.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		pnlGornji.setLayout(gbl_pnlGornji);
		
		lblBrojIznajmljivanja = new JLabel("Broj iznajmljivanja:");
		lblBrojIznajmljivanja.setForeground(new Color(139, 0, 0));
		lblBrojIznajmljivanja.setFont(new Font("Tahoma", Font.BOLD, 17));
		GridBagConstraints gbc_lblBrojIznajmljivanja = new GridBagConstraints();
		gbc_lblBrojIznajmljivanja.insets = new Insets(0, 0, 5, 5);
		gbc_lblBrojIznajmljivanja.gridx = 1;
		gbc_lblBrojIznajmljivanja.gridy = 1;
		pnlGornji.add(lblBrojIznajmljivanja, gbc_lblBrojIznajmljivanja);
		
		txtBrIznajmljivanja = new JTextField();
		GridBagConstraints gbc_txtBrIznajmljivanja = new GridBagConstraints();
		gbc_txtBrIznajmljivanja.insets = new Insets(0, 0, 5, 5);
		gbc_txtBrIznajmljivanja.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtBrIznajmljivanja.gridx = 3;
		gbc_txtBrIznajmljivanja.gridy = 1;
		pnlGornji.add(txtBrIznajmljivanja, gbc_txtBrIznajmljivanja);
		txtBrIznajmljivanja.setColumns(10);
		
		JLabel lblKupac = new JLabel("Kupac:");
		lblKupac.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblKupac.setForeground(new Color(139, 0, 0));
		GridBagConstraints gbc_lblKupac = new GridBagConstraints();
		gbc_lblKupac.insets = new Insets(0, 0, 5, 5);
		gbc_lblKupac.gridx = 1;
		gbc_lblKupac.gridy = 2;
		pnlGornji.add(lblKupac, gbc_lblKupac);
		
		cbKupac = new JComboBox();
		GridBagConstraints gbc_cbKupac = new GridBagConstraints();
		gbc_cbKupac.insets = new Insets(0, 0, 5, 5);
		gbc_cbKupac.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbKupac.gridx = 3;
		gbc_cbKupac.gridy = 2;
		pnlGornji.add(cbKupac, gbc_cbKupac);
		
		JLabel lblZaposleni = new JLabel("Zaposleni:");
		lblZaposleni.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblZaposleni.setForeground(new Color(139, 0, 0));
		GridBagConstraints gbc_lblZaposleni = new GridBagConstraints();
		gbc_lblZaposleni.insets = new Insets(0, 0, 5, 5);
		gbc_lblZaposleni.gridx = 1;
		gbc_lblZaposleni.gridy = 3;
		pnlGornji.add(lblZaposleni, gbc_lblZaposleni);
		
		cbZaposleni = new JComboBox();
		GridBagConstraints gbc_cbZaposleni = new GridBagConstraints();
		gbc_cbZaposleni.insets = new Insets(0, 0, 5, 5);
		gbc_cbZaposleni.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbZaposleni.gridx = 3;
		gbc_cbZaposleni.gridy = 3;
		pnlGornji.add(cbZaposleni, gbc_cbZaposleni);
		
		JLabel lblNekretnina = new JLabel("Nekretnina:");
		lblNekretnina.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNekretnina.setForeground(new Color(139, 0, 0));
		GridBagConstraints gbc_lblNekretnina = new GridBagConstraints();
		gbc_lblNekretnina.insets = new Insets(0, 0, 5, 5);
		gbc_lblNekretnina.gridx = 1;
		gbc_lblNekretnina.gridy = 4;
		pnlGornji.add(lblNekretnina, gbc_lblNekretnina);
		
		cbNekretnina = new JComboBox();
		GridBagConstraints gbc_cbNekretnina = new GridBagConstraints();
		gbc_cbNekretnina.insets = new Insets(0, 0, 5, 5);
		gbc_cbNekretnina.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbNekretnina.gridx = 3;
		gbc_cbNekretnina.gridy = 4;
		pnlGornji.add(cbNekretnina, gbc_cbNekretnina);
		
		JLabel lblPocetakIznajmljivanja = new JLabel("Pocetak iznajmljivanja:");
		lblPocetakIznajmljivanja.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblPocetakIznajmljivanja.setForeground(new Color(139, 0, 0));
		GridBagConstraints gbc_lblPocetakIznajmljivanja = new GridBagConstraints();
		gbc_lblPocetakIznajmljivanja.insets = new Insets(0, 0, 5, 5);
		gbc_lblPocetakIznajmljivanja.gridx = 1;
		gbc_lblPocetakIznajmljivanja.gridy = 5;
		pnlGornji.add(lblPocetakIznajmljivanja, gbc_lblPocetakIznajmljivanja);
		
		txtDatumPocetak = new JTextField();
		GridBagConstraints gbc_txtDatumPocetak = new GridBagConstraints();
		gbc_txtDatumPocetak.insets = new Insets(0, 0, 5, 5);
		gbc_txtDatumPocetak.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDatumPocetak.gridx = 3;
		gbc_txtDatumPocetak.gridy = 5;
		pnlGornji.add(txtDatumPocetak, gbc_txtDatumPocetak);
		txtDatumPocetak.setColumns(10);
		
		JLabel lblKrajIznajmljivanja = new JLabel("Kraj iznajmljivanja:");
		lblKrajIznajmljivanja.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblKrajIznajmljivanja.setForeground(new Color(139, 0, 0));
		GridBagConstraints gbc_lblKrajIznajmljivanja = new GridBagConstraints();
		gbc_lblKrajIznajmljivanja.insets = new Insets(0, 0, 5, 5);
		gbc_lblKrajIznajmljivanja.gridx = 1;
		gbc_lblKrajIznajmljivanja.gridy = 6;
		pnlGornji.add(lblKrajIznajmljivanja, gbc_lblKrajIznajmljivanja);
		
		txtDatumKraj = new JTextField();
		GridBagConstraints gbc_txtDatumKraj = new GridBagConstraints();
		gbc_txtDatumKraj.insets = new Insets(0, 0, 5, 5);
		gbc_txtDatumKraj.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDatumKraj.gridx = 3;
		gbc_txtDatumKraj.gridy = 6;
		pnlGornji.add(txtDatumKraj, gbc_txtDatumKraj);
		txtDatumKraj.setColumns(10);
		
		btnIznajmi = new JButton("Iznajmi");
		btnIznajmi.setFont(new Font("Tahoma", Font.BOLD, 17));
		GridBagConstraints gbc_btnIznajmi = new GridBagConstraints();
		gbc_btnIznajmi.insets = new Insets(0, 0, 5, 5);
		gbc_btnIznajmi.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnIznajmi.gridx = 5;
		gbc_btnIznajmi.gridy = 6;
		pnlGornji.add(btnIznajmi, gbc_btnIznajmi);
		
		JLabel lblVremeTrajanjaIznajmljivanja = new JLabel("Vreme trajanja iznajmljivanja:");
		lblVremeTrajanjaIznajmljivanja.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblVremeTrajanjaIznajmljivanja.setForeground(new Color(139, 0, 0));
		GridBagConstraints gbc_lblVremeTrajanjaIznajmljivanja = new GridBagConstraints();
		gbc_lblVremeTrajanjaIznajmljivanja.insets = new Insets(0, 0, 5, 5);
		gbc_lblVremeTrajanjaIznajmljivanja.gridx = 1;
		gbc_lblVremeTrajanjaIznajmljivanja.gridy = 7;
		pnlGornji.add(lblVremeTrajanjaIznajmljivanja, gbc_lblVremeTrajanjaIznajmljivanja);
		
		txtDatumRazlika = new JTextField();
		GridBagConstraints gbc_txtDatumRazlika = new GridBagConstraints();
		gbc_txtDatumRazlika.insets = new Insets(0, 0, 5, 5);
		gbc_txtDatumRazlika.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDatumRazlika.gridx = 3;
		gbc_txtDatumRazlika.gridy = 7;
		pnlGornji.add(txtDatumRazlika, gbc_txtDatumRazlika);
		txtDatumRazlika.setColumns(10);
		
		JLabel lblCena = new JLabel("Cena:");
		lblCena.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblCena.setForeground(new Color(139, 0, 0));
		GridBagConstraints gbc_lblCena = new GridBagConstraints();
		gbc_lblCena.insets = new Insets(0, 0, 5, 5);
		gbc_lblCena.gridx = 1;
		gbc_lblCena.gridy = 8;
		pnlGornji.add(lblCena, gbc_lblCena);
		
		txtCenaIznajmljivanja = new JTextField();
		GridBagConstraints gbc_txtCenaIznajmljivanja = new GridBagConstraints();
		gbc_txtCenaIznajmljivanja.insets = new Insets(0, 0, 5, 5);
		gbc_txtCenaIznajmljivanja.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCenaIznajmljivanja.gridx = 3;
		gbc_txtCenaIznajmljivanja.gridy = 8;
		pnlGornji.add(txtCenaIznajmljivanja, gbc_txtCenaIznajmljivanja);
		txtCenaIznajmljivanja.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		splitPane.setRightComponent(scrollPane);
		
		tblIznajmljivanje = new JTable();
		tblIznajmljivanje.setBackground(new Color(192, 192, 192));
		tblIznajmljivanje.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblIznajmljivanje);
		
		popupMenu = new JPopupMenu();
		addPopup(tblIznajmljivanje, popupMenu);
		
		mntmZavrsiIznajmljivanje = new JMenuItem("Zavrsi iznajmljivanje");
		popupMenu.add(mntmZavrsiIznajmljivanje);
	}
	
	public String getBrojIznajmljivanja()
	{
		return  txtBrIznajmljivanja.getText();
	}
	
	public void setBrojIznajmljivanja(String brIz)
	{
		txtBrIznajmljivanja.setText(brIz);
	}
	
	public double getCena()
	{
		return Double.parseDouble(txtCenaIznajmljivanja.getText());
	}
	
	public void setCena(double Cena)
	{
		txtCenaIznajmljivanja.setText(Double.toString(Cena));
		
	}
	
	////////////////////// FUCKING TIMESTAMPS ////////////////
	
	public long getDatePocetak()
	{
		long datum =0;
		 try {
			Date date=(Date) new SimpleDateFormat("dd.MM.yyyy").parse(txtDatumPocetak.getText());
			datum = date.getTime()/1000;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 System.out.println(datum);
		 return datum;
	}
	
	public void setDatePocetak(String Date)
	{
	txtDatumPocetak.setText(Date);	
	}
	
	public long getDateKraj()
	{
		long datum =0;
		 try {
			Date date=(Date) new SimpleDateFormat("dd.MM.yyyy").parse(txtDatumKraj.getText());
			datum = date.getTime()/1000;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 System.out.println(datum);
		 return datum;
	}
//	public double getDaysBetween () {
//		 int diff_in_millis = (int) ( getDateKraj() - getDatePocetak()) ;
//		double diff_in_days = Math.abs(diff_in_millis) / (10  * 60.0 * 60.0 * 24.0);
//		return diff_in_days;
//	}
	
//	public void setDatumRazlika (Double Razlika)
//	{
//		txtDatumRazlika.setText((Iznajmljivanje)GetBrojDanaIznajmljivanja());
//	}
	
	public Double getDatumRazlika()
	{
		return Double.parseDouble(txtDatumRazlika.getText());
	}
	
	public void setDateKraj(long timestamp)
	{
		Date date = new Date(timestamp*1000);
		try {
			txtDatumKraj.setText(new SimpleDateFormat("dd.MM.yyyy").parse(date.toString()).toString());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/////////////////////// COMBOBOX //////////////////////////////////////
	
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
	
	public void setNekretninaCB(ArrayList<Nekretnina> nekret)
	{
		for(Nekretnina n : nekret)
		{
			cbNekretnina.addItem(n);
		}
	}
	
	public void setKupacCB(ArrayList<Kupac> k)
	{
		for(Kupac kup : k)
		{
			cbKupac.addItem(kup);
		}
	}
	
	public void setZaposleniCB(ArrayList<Zaposleni> z)
	{
		for(Zaposleni zaposleni : z)
		{
			cbZaposleni.addItem(zaposleni);
		}
	}
	
	public void setNekretninaCB(int ID)
	{
		for(int i=0; i<cbNekretnina.getItemCount(); i++)
		{
			if((((Nekretnina) cbNekretnina.getItemAt(i)).getIDnekretnina())==ID)
			{
				cbNekretnina.setSelectedIndex(i);
			}
		}
	}
	
	public void setZaposleniCB(int ID)
	
	{
		for(int i=0; i<cbZaposleni.getItemCount(); i++)
		{
			if((((Zaposleni) cbZaposleni.getItemAt(i)).getIDzaposleni())==ID)
			{
				cbZaposleni.setSelectedIndex(i);
			}
		}
	}
	
	
	public void setKupacCB(int ID)
	{
		for (int i=0; i<cbKupac.getItemCount(); i++)
		{
			if((((Kupac)cbKupac.getItemAt(i)).getIDkupac())==ID)
			{
				cbKupac.setSelectedIndex(i);
			}
		}
	}
	
	public Iznajmljivanje getSelectedItemFromTable()
	{
		if(tblIznajmljivanje.getSelectedRow()>0)
		{
			return (Iznajmljivanje) tblIznajmljivanje.getValueAt(tblIznajmljivanje.getSelectedRow(), 2);
		}
		return null;
	}
	
	public void setNekretnina()
	{
		((Nekretnina) tblIznajmljivanje.getValueAt(tblIznajmljivanje.getSelectedRow(), 2)).getIDnekretnina();
		
			for(int i=0; i<cbNekretnina.getItemCount(); i++) {
			if((((Nekretnina)cbNekretnina.getItemAt(i)).getIDnekretnina()) == 
			((Nekretnina) tblIznajmljivanje.getValueAt(tblIznajmljivanje.getSelectedRow(), 2)).getIDnekretnina());
			{
				cbNekretnina.setSelectedIndex(i);
			}
	
			}
	}
	
	////////////////////////////////////////////////////////////////////////////////
	
	
	
	
	
	
	////////////////////////// TABLESSS //////////////////////
	
	public void setTableData(String[]zaglavlje, Object[][] podaci)
	{
		tblIznajmljivanje.setModel(new DefaultTableModel(podaci, zaglavlje));
	}
	
	public void ClearTable()
	{
		DefaultTableModel model = (DefaultTableModel) tblIznajmljivanje.getModel();
		model.setRowCount(0);
	}
	
	/////////////// BUTTONSSSSSSSS /////////////////
	
	public void btnRemoveListeners()
	{
		for(ActionListener al : btnIznajmi.getActionListeners())
		{
			btnIznajmi.removeActionListener(al);
		}
	}
	
	public void setIznajmiListner(ActionListener e)
	{
		btnRemoveListeners();
		btnIznajmi.addActionListener(e);
	}
	
	public void ZavrsiIznLsn(ActionListener e)
	{
		mntmZavrsiIznajmljivanje.addActionListener(e);
	}
	
	public void IznajmiListener(String s)
	{
		btnIznajmi.setText(s);
	}
	 
	/////////////////////////////////////////////////////////////////////
	
	
	
	public void ClearFields()
	{
		txtBrIznajmljivanja.setText("");
		txtDatumPocetak.setText("");
		txtDatumKraj.setText("");
		txtCenaIznajmljivanja.setText("");
		
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
