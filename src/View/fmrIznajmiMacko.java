package View;

import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JSplitPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import Data.Iznajmljivanje;
import Data.Kupac;
import Data.Nekretnina;
import Data.StavkeIznajmljivanja;
import Data.Zaposleni;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JMenuItem;
import java.awt.Dimension;
import javax.swing.JList;
import java.awt.Font;
import javax.swing.SwingConstants;

public class fmrIznajmiMacko extends JFrame {
	private JTable tblNekretnina;
	private JTextField txtBrojIznajmljivanja;
	private JTextField txtDatumPocetak;
	private JTextField txtDatumKraj;
	private JTextField txtRazlikaDatuma;
	private JTextField txtCenaIznajmljivanja;
	private JTable tblIznajmljenihNekretnina;
	private JButton btnKreirajIznajmljivanje;
	private JComboBox cbZaposleni;
	private JComboBox cbKupci;
	private JButton btnIznajmi;
	private JMenuItem mntmZavrsiIznajmljivanje;
	private JComboBox cbNekretnina;
	private JTable tblSvaIznajmljivanja;
	private JTextField txtZarada;
	private JTextField txtBrMeseci;

	

	public fmrIznajmiMacko(String arg0)  {
		super(arg0);
		
		
		initialize();
		
	}
	
	
	private void initialize()
	{
		setBounds(100,200,1264,780);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		JSplitPane splitPane = new JSplitPane();
		splitPane.setResizeWeight(0.8);
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		
		JSplitPane splitPane_1 = new JSplitPane();
		splitPane_1.setAlignmentY(Component.CENTER_ALIGNMENT);
		splitPane_1.setAlignmentX(Component.CENTER_ALIGNMENT);
		splitPane_1.setResizeWeight(0.5);
		splitPane_1.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane.setLeftComponent(splitPane_1);
		
		JScrollPane scrollPane = new JScrollPane();
		splitPane_1.setLeftComponent(scrollPane);
		
		tblNekretnina = new JTable();
		
		tblNekretnina.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblNekretnina);
		
		JPanel panel = new JPanel();
		splitPane_1.setRightComponent(panel);
		
		JLabel lblBrojIznajmljivanja = new JLabel("Broj iznajmljivanja:");
		
		txtBrojIznajmljivanja = new JTextField();
		txtBrojIznajmljivanja.setColumns(10);
		
		JLabel lblIzaberiKupca = new JLabel("Izaberi kupca:");
		
		cbKupci = new JComboBox();
		
		JLabel lblIzaberiZaposlenog = new JLabel("Izaberi zaposlenog:");
		
		cbZaposleni = new JComboBox();
		
		btnKreirajIznajmljivanje = new JButton("Kreiraj iznajmljivanje");
		
		JLabel lblDatumPocetak = new JLabel("Datum pocetak:");
		
		txtDatumPocetak = new JTextField();
		txtDatumPocetak.setEnabled(false);
		txtDatumPocetak.setColumns(10);
		
		JLabel lblDatumKraj = new JLabel("Datum kraj:");
		
		txtDatumKraj = new JTextField();
		txtDatumKraj.setEnabled(false);
		txtDatumKraj.setColumns(10);
		
		JLabel lblVremeaTrajanjaIznajmljivanja = new JLabel("Vreme trajanja iznajmljivanja:");
		
		txtRazlikaDatuma = new JTextField();
		txtRazlikaDatuma.setEnabled(false);
		txtRazlikaDatuma.setColumns(10);
		
		JLabel lblCena = new JLabel("Cena:");
		
		txtCenaIznajmljivanja = new JTextField();
		txtCenaIznajmljivanja.setEnabled(false);
		txtCenaIznajmljivanja.setColumns(10);
		
		btnIznajmi = new JButton("Iznajmi");
		btnIznajmi.setEnabled(false);
		
		JLabel lblIzaberiNekretninu = new JLabel("Izaberi nekretninu:");
		
		cbNekretnina = new JComboBox();
		
		JScrollPane scrollPane_1 = new JScrollPane();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(44)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblBrojIznajmljivanja)
						.addComponent(lblIzaberiKupca)
						.addComponent(lblIzaberiZaposlenog))
					.addGap(27)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(btnKreirajIznajmljivanje, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
						.addComponent(cbZaposleni, Alignment.LEADING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(txtBrojIznajmljivanja)
						.addComponent(cbKupci, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE))
					.addGap(40)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(1)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblDatumPocetak, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblDatumKraj)
								.addComponent(lblIzaberiNekretninu)))
						.addComponent(lblVremeaTrajanjaIznajmljivanja, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCena, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(cbNekretnina, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnIznajmi, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(txtCenaIznajmljivanja)
						.addComponent(txtRazlikaDatuma, Alignment.TRAILING)
						.addComponent(txtDatumPocetak, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
						.addComponent(txtDatumKraj))
					.addContainerGap(91, Short.MAX_VALUE))
				.addComponent(scrollPane_1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 725, Short.MAX_VALUE)
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(25)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblBrojIznajmljivanja)
						.addComponent(txtBrojIznajmljivanja, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblIzaberiNekretninu)
						.addComponent(cbNekretnina, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtDatumPocetak, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblDatumPocetak))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblDatumKraj)
								.addComponent(txtDatumKraj, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblVremeaTrajanjaIznajmljivanja)
								.addComponent(txtRazlikaDatuma, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblCena)
								.addComponent(txtCenaIznajmljivanja, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addComponent(btnIznajmi))
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblIzaberiKupca)
								.addComponent(cbKupci, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblIzaberiZaposlenog)
								.addComponent(cbZaposleni, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addComponent(btnKreirajIznajmljivanje)))
					.addGap(18)
					.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		tblIznajmljenihNekretnina = new JTable();
		scrollPane_1.setViewportView(tblIznajmljenihNekretnina);
		tblIznajmljenihNekretnina.setFillsViewportHeight(true);
		
		JPopupMenu popupMenu = new JPopupMenu();
		addPopup(tblIznajmljenihNekretnina, popupMenu);
		
		mntmZavrsiIznajmljivanje = new JMenuItem("Zavrsi iznajmljivanje");
		popupMenu.add(mntmZavrsiIznajmljivanje);
		panel.setLayout(gl_panel);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(splitPane, GroupLayout.PREFERRED_SIZE, 704, Short.MAX_VALUE)
					.addGap(3))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(splitPane, GroupLayout.DEFAULT_SIZE, 709, Short.MAX_VALUE)
		);
		
		JPanel panel_1 = new JPanel();
		splitPane.setRightComponent(panel_1);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		
		txtZarada = new JTextField();
		txtZarada.setColumns(10);
		
		JLabel lblCenaUEurima = new JLabel("Zarada:");
		lblCenaUEurima.setHorizontalAlignment(SwingConstants.CENTER);
		
		txtBrMeseci = new JTextField();
		txtBrMeseci.setColumns(10);
		
		JLabel lblBrojMeseci = new JLabel("Broj meseci:");
		lblBrojMeseci.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblNewLabel = new JLabel("UKUPNO:");
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addComponent(scrollPane_2, GroupLayout.PREFERRED_SIZE, 1239, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(796)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
					.addGap(80)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(lblBrojMeseci, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(txtBrMeseci, GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE))
					.addGap(47)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(lblCenaUEurima, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(txtZarada, GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE))
					.addContainerGap(38, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addComponent(scrollPane_2, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE)
					.addGap(20)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCenaUEurima)
						.addComponent(lblBrojMeseci))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtZarada, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtBrMeseci, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel))
					.addContainerGap(48, Short.MAX_VALUE))
		);
		
		tblSvaIznajmljivanja = new JTable();
		tblSvaIznajmljivanja.setFillsViewportHeight(true);
		scrollPane_2.setViewportView(tblSvaIznajmljivanja);
		panel_1.setLayout(gl_panel_1);
		getContentPane().setLayout(groupLayout);
	}
	
	public String getBrojIznajmljivanja()
	{
		return txtBrojIznajmljivanja.getText();
	}
	
	public void setBrojIznajmljivanja(String brIZ)
	{
		txtBrojIznajmljivanja.setText(brIZ);
	}
	
	public double getCena()
	{
	
		return Double.parseDouble(txtCenaIznajmljivanja.getText());
	}
	
	public void setCena(double cena)
	{
		txtCenaIznajmljivanja.setText(Double.toString(cena));
	}
	
	public void setNekretninaTableData(String [] zaglavlje, Object[][] podaci)
	{
		tblNekretnina.setModel(new DefaultTableModel(podaci,zaglavlje));
	}
	
	
	
	public void setKreiranaIznajmljivanja(String[] zaglavlje2, Object[][] podaci2)
	{
		tblIznajmljenihNekretnina.setModel(new DefaultTableModel(podaci2, zaglavlje2));
	}
	
	public void setKreirajIznajmljivanjeListener(ActionListener a)
	{
		btnKreirajIznajmljivanje.addActionListener(a);
	}
	
	
	public void setZavrsiIznajmljivanjeListener(ActionListener a)
	{
		mntmZavrsiIznajmljivanje.addActionListener(a);
	}
	
	public void btnRemoveListeners()
	{
		for(ActionListener al : btnIznajmi.getActionListeners())
		{
			btnIznajmi.removeActionListener(al);
		}
	}
	
	public void setIznajmiListener(ActionListener e)
	{
		btnRemoveListeners();
		btnIznajmi.addActionListener(e);
	}
	
	/////////////////////////////////////////////////////////////////////////////////////
	
	public Object getNekretnina()
	{
		return cbNekretnina.getSelectedItem();
	}
	
	public void setNekretninaCB(ArrayList<Nekretnina> n)
	{
		for (Nekretnina nekretnina : n) {
			cbNekretnina.addItem(nekretnina);
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
	
	public Object getKupac()
	{
		return cbKupci.getSelectedItem();
	}
	
	public Object getZaposleni()
	{
		return cbZaposleni.getSelectedItem();
	}
	
	public void setKupacCB (ArrayList<Kupac> kupci)
	{
		for (Kupac k : kupci) {
			cbKupci.addItem(k);
			
		}
	}
	
	public void setZaposleniCB (ArrayList<Zaposleni> zap)
	{
		for (Zaposleni z : zap) {
			cbZaposleni.addItem(z);
			
		}
	}
	
	public void setkupacCB(int ID)
	{
		for(int i=0; i<cbKupci.getItemCount(); i++)
		{
			if(((Kupac)cbKupci.getItemAt(i)).getIDkupac()==ID)
			{
				cbKupci.setSelectedIndex(i);
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
	
	
////////// DA BI PRIKAZAO SVA IZNAJMLJIVANJA JEDNE NEKRETNINE U DRUGOJ TABELI /////////// 

	
	
	public void AddSelectionModel(ListSelectionListener listener)
	{
		tblNekretnina.getSelectionModel().addListSelectionListener(listener);
	}
	
	
	public Nekretnina getSelectedItemFromTable()
	{
		if(tblNekretnina.getSelectedRow()>=0)
		{
			return ((Nekretnina) tblNekretnina.getValueAt(tblNekretnina.getSelectedRow(), 1));
		}
		return null;
	}
	
	
	public void setTableDataStavke(String[] zaglavlje3, Object[][] podaci2)
	{
		tblSvaIznajmljivanja.setModel(new DefaultTableModel(podaci2, zaglavlje3));
	}
	
///////////////////////////////////////////////////////////////////////////////////////////////	
	
	public StavkeIznajmljivanja getSelectedItemFromTable1()
	{
		if(tblIznajmljenihNekretnina.getSelectedRow()>=0)
		{
			return (StavkeIznajmljivanja) tblIznajmljenihNekretnina.getValueAt(tblIznajmljenihNekretnina.getSelectedRow(), 2);
		}
		return null;
	}
	

	
	
	public void EnableStavke()
	{
		txtDatumPocetak.setEnabled(true);
		txtDatumKraj.setEnabled(true);
		txtRazlikaDatuma.setEnabled(true);
		txtCenaIznajmljivanja.setEnabled(true);
		btnIznajmi.setEnabled(true);
	}
	
	
	
	public void ClearFields ()
	{
		txtBrojIznajmljivanja.setText("");
		txtCenaIznajmljivanja.setText("");
		txtDatumKraj.setText("");
		txtDatumPocetak.setText("");
		txtRazlikaDatuma.setText("");
//		cbNekretnina.setSelectedItem("");
		
		
	}
	
	
	/////////////////// TIME STAMP /////////////////////////////
	
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
		if(txtDatumKraj.getText().equals(""))
		{
			return 0;
		}
		else {
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
	}
	public Double getDatumRazlika()
	{
		return Double.parseDouble(txtRazlikaDatuma.getText());
	}
	
	public void setZarada(double sum) {
		txtZarada.setText(Double.toString(sum));
	}
	public void setBrMeseci(double sum) {
		txtBrMeseci.setText(Double.toString(sum));
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
