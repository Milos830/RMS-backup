package View;

import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JSplitPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class frmZaposleni extends JFrame {
	private JPanel pnlGornji;
	private JTextField txtImeIPrezime;
	private JTextField txtSifra;
	private JTextField txtTelefon;
	private JTable tblZaposleni;
	private JButton btnSacuvaj;

	
	public frmZaposleni(String title) {
		super(title);
		
		
		initialize();
	
	}
	
	
	private void initialize() {
		setBounds(100,200,376,512);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		JSplitPane splitPane = new JSplitPane();
		splitPane.setResizeWeight(0.1);
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		getContentPane().add(splitPane, BorderLayout.CENTER);
		
		pnlGornji = new JPanel();
		splitPane.setLeftComponent(pnlGornji);
		GridBagLayout gbl_pnlGornji = new GridBagLayout();
		gbl_pnlGornji.columnWidths = new int[]{0, 0, 0, 207, 0};
		gbl_pnlGornji.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_pnlGornji.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_pnlGornji.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		pnlGornji.setLayout(gbl_pnlGornji);
		
		JLabel lblImeIPrezime = new JLabel("Ime i prezime:");
		GridBagConstraints gbc_lblImeIPrezime = new GridBagConstraints();
		gbc_lblImeIPrezime.insets = new Insets(0, 0, 5, 5);
		gbc_lblImeIPrezime.gridx = 1;
		gbc_lblImeIPrezime.gridy = 1;
		pnlGornji.add(lblImeIPrezime, gbc_lblImeIPrezime);
		
		txtImeIPrezime = new JTextField();
		GridBagConstraints gbc_txtImeIPrezime = new GridBagConstraints();
		gbc_txtImeIPrezime.anchor = GridBagConstraints.NORTH;
		gbc_txtImeIPrezime.insets = new Insets(0, 0, 5, 0);
		gbc_txtImeIPrezime.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtImeIPrezime.gridx = 3;
		gbc_txtImeIPrezime.gridy = 1;
		pnlGornji.add(txtImeIPrezime, gbc_txtImeIPrezime);
		txtImeIPrezime.setColumns(10);
		
		JLabel lblSifra = new JLabel("Sifra:");
		GridBagConstraints gbc_lblSifra = new GridBagConstraints();
		gbc_lblSifra.insets = new Insets(0, 0, 5, 5);
		gbc_lblSifra.gridx = 1;
		gbc_lblSifra.gridy = 2;
		pnlGornji.add(lblSifra, gbc_lblSifra);
		
		txtSifra = new JTextField();
		GridBagConstraints gbc_txtSifra = new GridBagConstraints();
		gbc_txtSifra.insets = new Insets(0, 0, 5, 0);
		gbc_txtSifra.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtSifra.gridx = 3;
		gbc_txtSifra.gridy = 2;
		pnlGornji.add(txtSifra, gbc_txtSifra);
		txtSifra.setColumns(10);
		
		JLabel lblTelefon = new JLabel("Telefon:");
		GridBagConstraints gbc_lblTelefon = new GridBagConstraints();
		gbc_lblTelefon.insets = new Insets(0, 0, 5, 5);
		gbc_lblTelefon.gridx = 1;
		gbc_lblTelefon.gridy = 3;
		pnlGornji.add(lblTelefon, gbc_lblTelefon);
		
		txtTelefon = new JTextField();
		GridBagConstraints gbc_txtTelefon = new GridBagConstraints();
		gbc_txtTelefon.insets = new Insets(0, 0, 5, 0);
		gbc_txtTelefon.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtTelefon.gridx = 3;
		gbc_txtTelefon.gridy = 3;
		pnlGornji.add(txtTelefon, gbc_txtTelefon);
		txtTelefon.setColumns(10);
		
		btnSacuvaj = new JButton("Sacuvaj");
		GridBagConstraints gbc_btnSacuvaj = new GridBagConstraints();
		gbc_btnSacuvaj.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnSacuvaj.gridx = 3;
		gbc_btnSacuvaj.gridy = 5;
		pnlGornji.add(btnSacuvaj, gbc_btnSacuvaj);
		
		JScrollPane scrollPane = new JScrollPane();
		splitPane.setRightComponent(scrollPane);
		
		tblZaposleni = new JTable();
		tblZaposleni.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblZaposleni);
	}
	
	public String getImeIPrezime()
	{
		return txtImeIPrezime.getText();
	}
	
	public void setImeIPrezime (String ime)
	{
		txtImeIPrezime.setText(ime);
	}
	
	public String getSifra()
	{
		return txtSifra.getText();
	}
	
	public void setSifra(String sifra)
	{
		txtSifra.setText(sifra);
	}
	
	public String getTelefon()
	{
		return txtTelefon.getText();
	}
	
	public void setTelefon(String fon)
	{
		txtTelefon.setText(fon);
	}
	
	public void setSacuvajZaposleni(ActionListener a)
	{
		btnSacuvaj.addActionListener(a);
	}
	
	public void setTableData(String[] zaglavlje, Object[][] podaci)
	{
		tblZaposleni.setModel(new DefaultTableModel(podaci, zaglavlje));
	}
	
	public void ClearFields()
	{
		txtImeIPrezime.setText("");
		txtSifra.setText("");
		txtTelefon.setText("");
	}
}
