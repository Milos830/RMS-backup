package View;

import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class frmGrad extends JFrame {
	private JTextField txtNazivGrada;
	private JTable tblGrad;
	private JButton btnDodaj;

	
	public frmGrad(String title)  {
		super(title);
		
		initialize();
	}

	private void initialize()
	{
		setBounds(100,200,325,282);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblNazivGrada = new JLabel("Naziv grada:");
		lblNazivGrada.setBounds(10, 11, 61, 14);
		getContentPane().add(lblNazivGrada);
		
		txtNazivGrada = new JTextField();
		txtNazivGrada.setBounds(82, 8, 108, 20);
		getContentPane().add(txtNazivGrada);
		txtNazivGrada.setColumns(10);
		
		btnDodaj = new JButton("Dodaj");
		btnDodaj.setBounds(208, 7, 89, 23);
		getContentPane().add(btnDodaj);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 38, 287, 194);
		getContentPane().add(scrollPane);
		
		tblGrad = new JTable();
		tblGrad.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblGrad);
	}
	
	public String getNazivGrada()
	{
		return txtNazivGrada.getText();
	}
	
	public void setNazivGrada(String grad)
	{
		txtNazivGrada.setText(grad);
	}
	
	public void setTableData(String[] zaglavlje, Object[][] podaci)
	{
		tblGrad.setModel(new DefaultTableModel(podaci,zaglavlje));
		
	}
	
	public void setSacuvajListener(ActionListener dodaj)
	{
		btnDodaj.addActionListener(dodaj);
	}
	
	public void ClearFields()
	{
		txtNazivGrada.setText("");
	}
}
