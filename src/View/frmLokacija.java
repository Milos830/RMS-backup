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

public class frmLokacija extends JFrame {
	private JTextField txtNazivLokacije;
	private JTable tblLokacija;
	private JButton btnSacuvaj;

	

	public frmLokacija(String arg0)  {
		super(arg0);
		
		initialize();
	}

		private void initialize()
		{
			setBounds(100,200,320,295);
			setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			
			JLabel lblNazivLokacije = new JLabel("Naziv lokacije:");
			lblNazivLokacije.setBounds(10, 22, 75, 14);
			getContentPane().add(lblNazivLokacije);
			
			txtNazivLokacije = new JTextField();
			txtNazivLokacije.setBounds(105, 19, 86, 20);
			getContentPane().add(txtNazivLokacije);
			txtNazivLokacije.setColumns(10);
			
			btnSacuvaj = new JButton("Sacuvaj");
			btnSacuvaj.setBounds(201, 18, 89, 23);
			getContentPane().add(btnSacuvaj);
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 47, 280, 199);
			getContentPane().add(scrollPane);
			
			tblLokacija = new JTable();
			tblLokacija.setFillsViewportHeight(true);
			scrollPane.setViewportView(tblLokacija);
		}
		
		public String getNazivLokacije()
		{
			return txtNazivLokacije.getText();
		}
		
		public void setNazivLokacije(String lokacija)
		{
			txtNazivLokacije.setText(lokacija);
		}
		
		public void SacuvajLsn(ActionListener e)
		{
			btnSacuvaj.addActionListener(e);
		}
		
		public void setTableData(String[] zaglavlje, Object[][] podaci)
		{
			tblLokacija.setModel(new DefaultTableModel(podaci, zaglavlje));
			
		}
		
		public void ClearFields()
		{
			txtNazivLokacije.setText("");
		}
		
}
