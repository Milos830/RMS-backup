package View;

import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Data.TipNekretnine;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionEvent;

public class frmTipNekretnine extends JFrame {
	private JTextField txtNazivTipNek;
	private JTable tblTipNekretnine;
	private JButton btnDodaj;

	

	public frmTipNekretnine(String title)  {
		super(title);
		
		initialize();
	
	}
	
	private void initialize()
	{
		setBounds(100,200,325,357);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblNazivTipaNekretnine = new JLabel("Naziv tipa nekretnine:");
		lblNazivTipaNekretnine.setBounds(10, 25, 112, 14);
		getContentPane().add(lblNazivTipaNekretnine);
		
		txtNazivTipNek = new JTextField();
		txtNazivTipNek.setBounds(121, 22, 180, 20);
		getContentPane().add(txtNazivTipNek);
		txtNazivTipNek.setColumns(10);
		
		btnDodaj = new JButton("Dodaj tip");
		btnDodaj.setBounds(121, 53, 180, 23);
		getContentPane().add(btnDodaj);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 96, 291, 204);
		getContentPane().add(scrollPane);
		
		tblTipNekretnine = new JTable();
		tblTipNekretnine.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblTipNekretnine);
	}
	
	public String getNazivTipNek ()
	{
		return txtNazivTipNek.getText();
	}
	
	public void setNazivTipNek(String tipNek)
	{
		txtNazivTipNek.setText(tipNek);
	}
	
	public void setSacuvajListener(ActionListener dodaj)
	{
		btnDodaj.addActionListener(dodaj);
	}
	
	public void setTableData(String [] zaglavlje, Object [][] podaci)
	{
		tblTipNekretnine.setModel(new DefaultTableModel(podaci,zaglavlje));
	}
	
	public void ClearFields() {
		txtNazivTipNek.setText("");
	}
}
