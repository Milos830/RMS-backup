package View;

import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Data.Zaposleni;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class frmIZVESTAJ_All_sales_by_agents extends JFrame {
	private JComboBox cbZaposleni;
	private JTable tblProdajaNekreninaPoAgentu;
	private int ID;
	private JTextField txtZarada;
	private JTextField txtProvizija;

	

	public frmIZVESTAJ_All_sales_by_agents(String arg0)  {
		super(arg0);
		
		initialize();
		
	}
	
	private void initialize()
	{
		setBounds(100,200,759,633);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblIzaberiZaposlenog = new JLabel("Izaberi zaposlenog:");
		lblIzaberiZaposlenog.setBounds(24, 22, 100, 14);
		getContentPane().add(lblIzaberiZaposlenog);
		
		cbZaposleni = new JComboBox();
		
		cbZaposleni.setBounds(147, 19, 213, 20);
		getContentPane().add(cbZaposleni);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 50, 723, 448);
		getContentPane().add(scrollPane);
		
		tblProdajaNekreninaPoAgentu = new JTable();
		tblProdajaNekreninaPoAgentu.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblProdajaNekreninaPoAgentu);
		
		JLabel lblUkupno = new JLabel("UKUPNO:");
		lblUkupno.setBounds(381, 546, 58, 14);
		getContentPane().add(lblUkupno);
		
		txtZarada = new JTextField();
		txtZarada.setBounds(436, 543, 132, 20);
		getContentPane().add(txtZarada);
		txtZarada.setColumns(10);
		
		txtProvizija = new JTextField();
		txtProvizija.setBounds(601, 543, 132, 20);
		getContentPane().add(txtProvizija);
		txtProvizija.setColumns(10);
	}
	
	public void SetCBListener(ActionListener al)
	{
		cbZaposleni.addActionListener(al);
	}
	public void setTableData(String[] zaglavlje, Object[][] podaci)
	{
		tblProdajaNekreninaPoAgentu.setModel(new DefaultTableModel(podaci, zaglavlje));
	}
	
	public Object getZaposleni()
	{
		return cbZaposleni.getSelectedItem();
	}
	
	public void setZaposleniCB (ArrayList<Zaposleni> zap)
	{
		for (Zaposleni z : zap) {
			cbZaposleni.addItem(z);
			
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
	
	public void setZaradaPr(Double sum)
	{
		txtZarada.setText(Double.toString(sum));
	}
	
	public void setProvizijaPr(Double sum1)
	{
		txtProvizija.setText(Double.toString(sum1));
	}
}
