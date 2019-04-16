package View;

import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.event.ListSelectionListener;
import javax.swing.JSplitPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import Data.Nekretnina;
import Data.Zaposleni;
import Model.Model;

import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JButton;

public class frmIZVESTAJ_All_rentals_by_agents extends JFrame {
	private JSplitPane splitPane;
	private JScrollPane scrollPane;
	private JTable tblZaposleni;
	private JScrollPane scrollPane_1;
	private JTable tblSveProdajePoAgentima;
	private JLabel lblIzaberiAgenta;
	private JLabel lblUkupno;
	private JTextField txtZarada;
	private JTextField txtProvizija;

	

	public frmIZVESTAJ_All_rentals_by_agents(String title)  {
		super(title);
		
		initialize();
	
	}
	
	private void initialize()
	{
		setBounds(100,200,768,606);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		
		splitPane = new JSplitPane();
		splitPane.setResizeWeight(0.4);
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane.setBounds(0, 27, 752, 502);
		getContentPane().add(splitPane);
		
		scrollPane = new JScrollPane();
		splitPane.setLeftComponent(scrollPane);
		
		tblZaposleni = new JTable();
		tblZaposleni.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblZaposleni);
		
		scrollPane_1 = new JScrollPane();
		splitPane.setRightComponent(scrollPane_1);
		
		tblSveProdajePoAgentima = new JTable();
		tblSveProdajePoAgentima.setFillsViewportHeight(true);
		scrollPane_1.setViewportView(tblSveProdajePoAgentima);
		
		lblIzaberiAgenta = new JLabel("Izaberi agenta:");
		lblIzaberiAgenta.setBounds(10, 11, 167, 14);
		getContentPane().add(lblIzaberiAgenta);
		
		lblUkupno = new JLabel("UKUPNO:");
		lblUkupno.setBounds(29, 540, 72, 14);
		getContentPane().add(lblUkupno);
		
		txtZarada = new JTextField();
		txtZarada.setBounds(514, 537, 86, 20);
		getContentPane().add(txtZarada);
		txtZarada.setColumns(10);
		
		txtProvizija = new JTextField();
		txtProvizija.setBounds(675, 537, 67, 20);
		getContentPane().add(txtProvizija);
		txtProvizija.setColumns(10);
		
		JLabel lblZarada = new JLabel("Zarada:");
		lblZarada.setBounds(437, 540, 67, 14);
		getContentPane().add(lblZarada);
		
		JLabel lblProvizija = new JLabel("Provizija:");
		lblProvizija.setBounds(610, 540, 55, 14);
		getContentPane().add(lblProvizija);
	}
	
	public void setTableData(String[] zaglavlje, Object[][] podaci)
	{
		tblSveProdajePoAgentima.setModel(new DefaultTableModel(podaci, zaglavlje));
	}

	public void setTableZaposleni (String[] zaglavlje1, Object[][] podaci1)
	{
		tblZaposleni.setModel(new DefaultTableModel(podaci1,zaglavlje1));
	}
	
	public void AddSelectionListener(ListSelectionListener listener)
	{
		tblZaposleni.getSelectionModel().addListSelectionListener(listener);
	}
	
	public Zaposleni getSelectedItemFromTable()
	{
		if(tblZaposleni.getSelectedRow()>=0)
		{
			return ((Zaposleni) tblZaposleni.getValueAt(tblZaposleni.getSelectedRow(), 2));
		}
		return null;
	}
	
	public void setZarada(double sum) {
		txtZarada.setText(Double.toString(sum));
	}
	
	public void setProvizija(double sum1)
	{
		txtProvizija.setText(Double.toString(sum1));
	}
	
	
}

	
	
