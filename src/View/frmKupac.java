package View;

import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JSplitPane;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import Data.Kupac;
import Data.Nekretnina;

import javax.swing.JButton;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuItem;

public class frmKupac extends JFrame {
	private JTextField txtImeIPrezimeKupac;
	private JTextField txtBrojLK;
	private JTextField txtTelefonKupac;
	private JTextField txtAdresaKupac;
	private JTextField txtEmailKupac;
	private JTable tblKupac;
	private JButton btnSacuvaj;
	private JMenuItem mntmIzmeni;
	private JPopupMenu popupMenu;

	

	public frmKupac(String title)  {
		super(title);
		initialize();
	}

	private void initialize() {
	setBounds(100,200,381,389);
	JSplitPane splitPane = new JSplitPane();
	splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
	splitPane.setResizeWeight(0.2);
	getContentPane().add(splitPane, BorderLayout.CENTER);
	
	JPanel pnlGornji = new JPanel();
	splitPane.setLeftComponent(pnlGornji);
	GridBagLayout gbl_pnlGornji = new GridBagLayout();
	gbl_pnlGornji.columnWidths = new int[]{100, 254, 0};
	gbl_pnlGornji.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
	gbl_pnlGornji.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
	gbl_pnlGornji.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
	pnlGornji.setLayout(gbl_pnlGornji);
	
	JLabel lblImeIPrezime = new JLabel("Ime i prezime:");
	lblImeIPrezime.setHorizontalAlignment(SwingConstants.CENTER);
	GridBagConstraints gbc_lblImeIPrezime = new GridBagConstraints();
	gbc_lblImeIPrezime.anchor = GridBagConstraints.EAST;
	gbc_lblImeIPrezime.insets = new Insets(0, 0, 5, 5);
	gbc_lblImeIPrezime.gridx = 0;
	gbc_lblImeIPrezime.gridy = 1;
	pnlGornji.add(lblImeIPrezime, gbc_lblImeIPrezime);
	
	txtImeIPrezimeKupac = new JTextField();
	GridBagConstraints gbc_txtImeIPrezimeKupac = new GridBagConstraints();
	gbc_txtImeIPrezimeKupac.anchor = GridBagConstraints.NORTH;
	gbc_txtImeIPrezimeKupac.insets = new Insets(0, 0, 5, 0);
	gbc_txtImeIPrezimeKupac.fill = GridBagConstraints.HORIZONTAL;
	gbc_txtImeIPrezimeKupac.gridx = 1;
	gbc_txtImeIPrezimeKupac.gridy = 1;
	pnlGornji.add(txtImeIPrezimeKupac, gbc_txtImeIPrezimeKupac);
	txtImeIPrezimeKupac.setColumns(10);
	
	JLabel lblbrlik = new JLabel("Broj licne karte:");
	lblbrlik.setHorizontalAlignment(SwingConstants.CENTER);
	GridBagConstraints gbc_lblbrlik = new GridBagConstraints();
	gbc_lblbrlik.anchor = GridBagConstraints.EAST;
	gbc_lblbrlik.insets = new Insets(0, 0, 5, 5);
	gbc_lblbrlik.gridx = 0;
	gbc_lblbrlik.gridy = 2;
	pnlGornji.add(lblbrlik, gbc_lblbrlik);
	
	txtBrojLK = new JTextField();
	GridBagConstraints gbc_txtBrojLK = new GridBagConstraints();
	gbc_txtBrojLK.insets = new Insets(0, 0, 5, 0);
	gbc_txtBrojLK.fill = GridBagConstraints.HORIZONTAL;
	gbc_txtBrojLK.gridx = 1;
	gbc_txtBrojLK.gridy = 2;
	pnlGornji.add(txtBrojLK, gbc_txtBrojLK);
	txtBrojLK.setColumns(10);
	
	JLabel lblTelefon = new JLabel("Telefon:");
	lblTelefon.setHorizontalAlignment(SwingConstants.CENTER);
	GridBagConstraints gbc_lblTelefon = new GridBagConstraints();
	gbc_lblTelefon.anchor = GridBagConstraints.EAST;
	gbc_lblTelefon.insets = new Insets(0, 0, 5, 5);
	gbc_lblTelefon.gridx = 0;
	gbc_lblTelefon.gridy = 3;
	pnlGornji.add(lblTelefon, gbc_lblTelefon);
	
	txtTelefonKupac = new JTextField();
	GridBagConstraints gbc_txtTelefonKupac = new GridBagConstraints();
	gbc_txtTelefonKupac.anchor = GridBagConstraints.NORTH;
	gbc_txtTelefonKupac.insets = new Insets(0, 0, 5, 0);
	gbc_txtTelefonKupac.fill = GridBagConstraints.HORIZONTAL;
	gbc_txtTelefonKupac.gridx = 1;
	gbc_txtTelefonKupac.gridy = 3;
	pnlGornji.add(txtTelefonKupac, gbc_txtTelefonKupac);
	txtTelefonKupac.setColumns(10);
	
	JLabel lblAdresa = new JLabel("Adresa:");
	lblAdresa.setHorizontalAlignment(SwingConstants.CENTER);
	GridBagConstraints gbc_lblAdresa = new GridBagConstraints();
	gbc_lblAdresa.anchor = GridBagConstraints.EAST;
	gbc_lblAdresa.insets = new Insets(0, 0, 5, 5);
	gbc_lblAdresa.gridx = 0;
	gbc_lblAdresa.gridy = 4;
	pnlGornji.add(lblAdresa, gbc_lblAdresa);
	
	txtAdresaKupac = new JTextField();
	GridBagConstraints gbc_txtAdresaKupac = new GridBagConstraints();
	gbc_txtAdresaKupac.insets = new Insets(0, 0, 5, 0);
	gbc_txtAdresaKupac.fill = GridBagConstraints.HORIZONTAL;
	gbc_txtAdresaKupac.gridx = 1;
	gbc_txtAdresaKupac.gridy = 4;
	pnlGornji.add(txtAdresaKupac, gbc_txtAdresaKupac);
	txtAdresaKupac.setColumns(10);
	
	JLabel lblEmail = new JLabel("E-mail:");
	lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
	GridBagConstraints gbc_lblEmail = new GridBagConstraints();
	gbc_lblEmail.anchor = GridBagConstraints.EAST;
	gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
	gbc_lblEmail.gridx = 0;
	gbc_lblEmail.gridy = 5;
	pnlGornji.add(lblEmail, gbc_lblEmail);
	
	txtEmailKupac = new JTextField();
	GridBagConstraints gbc_txtEmailKupac = new GridBagConstraints();
	gbc_txtEmailKupac.insets = new Insets(0, 0, 5, 0);
	gbc_txtEmailKupac.fill = GridBagConstraints.HORIZONTAL;
	gbc_txtEmailKupac.gridx = 1;
	gbc_txtEmailKupac.gridy = 5;
	pnlGornji.add(txtEmailKupac, gbc_txtEmailKupac);
	txtEmailKupac.setColumns(10);
	
	btnSacuvaj = new JButton("Sacuvaj");
	GridBagConstraints gbc_btnSacuvaj = new GridBagConstraints();
	gbc_btnSacuvaj.fill = GridBagConstraints.HORIZONTAL;
	gbc_btnSacuvaj.gridx = 1;
	gbc_btnSacuvaj.gridy = 6;
	pnlGornji.add(btnSacuvaj, gbc_btnSacuvaj);
	
	JScrollPane scrollPane = new JScrollPane();
	splitPane.setRightComponent(scrollPane);
	
	tblKupac = new JTable();
	tblKupac.setFillsViewportHeight(true);
	scrollPane.setViewportView(tblKupac);
	
	popupMenu = new JPopupMenu();
	addPopup(tblKupac, popupMenu);
	
	mntmIzmeni = new JMenuItem("Izmeni");
	popupMenu.add(mntmIzmeni);
	}
	
	public String getImeIPrezime() {
		return txtImeIPrezimeKupac.getText();
	}
	
	public void setImeIPrezime(String ime) {
		txtImeIPrezimeKupac.setText(ime);
	}
	
	public  String getBrLK()
	{
		return txtBrojLK.getText();
	}
	
	public void setBrojLK(String LK)
	{
		txtBrojLK.setText(LK);
	}
	
	public String getTelefonKupac()
	{
		return txtTelefonKupac.getText();
	}
	
	public void setTelefon(String T)
	{
		txtTelefonKupac.setText(T);
	}
	
	public String getAdresa()
	{
		return txtAdresaKupac.getText();
	}
	
	public void setAdresa(String A)
	{
		txtAdresaKupac.setText(A);
	}
	
	public String getEmail()
	{
		return txtEmailKupac.getText();
	}
	
	public void setEmail(String E)
	{
		txtEmailKupac.setText(E);
	}
	
	public void setSacuvajKupac(ActionListener a)
	{
		btnRemoveListeners();
		btnSacuvaj.addActionListener(a);
	}
	
	private void btnRemoveListeners()
	{
		for (ActionListener al : btnSacuvaj.getActionListeners()) {
			btnSacuvaj.removeActionListener(al);
		}
	}
	
	public void setIzmeniKupac(ActionListener a)
	{
		mntmIzmeni.addActionListener(a);
	}
	
	public void setTableData(String [] zaglavlje, Object[][] podaci)
	{
		tblKupac.setModel(new DefaultTableModel(podaci,zaglavlje));
	}
	
	public void ClearFields()
	{
		txtImeIPrezimeKupac.setText("");
		txtBrojLK.setText("");
		txtTelefonKupac.setText("");
		txtAdresaKupac.setText("");
		txtEmailKupac.setText("");
	}
	
	public Kupac getSelectedItemFromTable() {
		if(tblKupac.getSelectedRow()>=0)
		{
		return (Kupac) tblKupac.getValueAt(tblKupac.getSelectedRow(),1);
		}
		return null;
} 
	
	public Kupac getSelectedKupac() {
		return (Kupac) tblKupac.getValueAt(tblKupac.getSelectedRow(), 1);
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
