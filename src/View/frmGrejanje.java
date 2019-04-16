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

public class frmGrejanje extends JFrame {
	private JTextField txtNazivGrejanja;
	private JButton btnSacuvaj;
	private JTable tblGrejanje;

	

	public frmGrejanje(String arg0)  {
		super(arg0);
		
		initialize();
	}

		private void initialize() {
			setBounds(100,200,300,300);
			setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			
			JLabel lblTipGrejanja = new JLabel("Tip grejanja:");
			lblTipGrejanja.setBounds(10, 23, 68, 14);
			getContentPane().add(lblTipGrejanja);
			
			txtNazivGrejanja = new JTextField();
			txtNazivGrejanja.setBounds(88, 20, 86, 20);
			getContentPane().add(txtNazivGrejanja);
			txtNazivGrejanja.setColumns(10);
			
			btnSacuvaj = new JButton("Sacuvaj");
			btnSacuvaj.setBounds(184, 19, 89, 23);
			getContentPane().add(btnSacuvaj);
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 48, 264, 202);
			getContentPane().add(scrollPane);
			
			tblGrejanje = new JTable();
			tblGrejanje.setFillsViewportHeight(true);
			scrollPane.setViewportView(tblGrejanje);
		}
	
		public String getNazivTipaGrejanje()
		{
			return txtNazivGrejanja.getText();
		}
		
		public void setNazivTipaGrejanje (String grejanje)
		{
			txtNazivGrejanja.setText(grejanje);
		}
		
		public void SacuvajLsn(ActionListener e)
		{
			btnSacuvaj.addActionListener(e);
		}
		
		public void setTableData(String[] zaglavlje, Object[][] podaci)
		{
			tblGrejanje.setModel(new DefaultTableModel(podaci, zaglavlje));
		}
		
		public void ClearFields()
		{
			txtNazivGrejanja.setText("");
		}
}
