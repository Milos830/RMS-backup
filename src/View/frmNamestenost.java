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

public class frmNamestenost extends JFrame {
	private JTextField txtNazivNamestenosti;
	private JTable tblNamestenost;
	private JButton btnSacuvaj;

	

	public frmNamestenost(String title)  {
		super(title);
		
		initialize();
	}
	
	private void initialize() {
		setBounds(100,200,343,297);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblTipNamestenost = new JLabel("Tip namestenost:");
		lblTipNamestenost.setBounds(20, 24, 93, 14);
		getContentPane().add(lblTipNamestenost);
		
		txtNazivNamestenosti = new JTextField();
		txtNazivNamestenosti.setBounds(123, 21, 86, 20);
		getContentPane().add(txtNazivNamestenosti);
		txtNazivNamestenosti.setColumns(10);
		
		btnSacuvaj = new JButton("Sacuvaj");
		btnSacuvaj.setBounds(228, 20, 89, 23);
		getContentPane().add(btnSacuvaj);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 51, 307, 196);
		getContentPane().add(scrollPane);
		
		tblNamestenost = new JTable();
		tblNamestenost.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblNamestenost);
	}

	public String getNazivNamestenost()
	{
		return txtNazivNamestenosti.getText();
	}
	
	public void setNazivNamestenost(String Nam)
	{
		txtNazivNamestenosti.setText(Nam);
	}

	public void SacuvajLsn(ActionListener e)
	{
		btnSacuvaj.addActionListener(e);
	}
	
	public void setTableData(String[] zaglavlje, Object[][] podaci)
	{
		tblNamestenost.setModel(new DefaultTableModel(podaci, zaglavlje));
		
	}
	
	public void ClearFields()
	{
		txtNazivNamestenosti.setText("");
	}
}
