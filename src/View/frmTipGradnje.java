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

public class frmTipGradnje extends JFrame {
	private JTextField txtNazivTipaGradnje;
	private JTable tblTipGradnje;
	private JButton btnSacuvaj;

	
	public frmTipGradnje(String title)  {
		super(title);
		
		initialize();
		
	}

	private void initialize() {
		setBounds(100,200,313,292);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblNazivTipa = new JLabel("Naziv tipa:");
		lblNazivTipa.setBounds(10, 22, 60, 14);
		getContentPane().add(lblNazivTipa);
		
		txtNazivTipaGradnje = new JTextField();
		txtNazivTipaGradnje.setBounds(78, 19, 108, 20);
		getContentPane().add(txtNazivTipaGradnje);
		txtNazivTipaGradnje.setColumns(10);
		
		btnSacuvaj = new JButton("Sacuvaj");
		btnSacuvaj.setBounds(206, 18, 89, 23);
		getContentPane().add(btnSacuvaj);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 55, 277, 187);
		getContentPane().add(scrollPane);
		
		tblTipGradnje = new JTable();
		tblTipGradnje.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblTipGradnje);
	}
	
	public String getNazivTipaGradnje()
	{
		return txtNazivTipaGradnje.getText();
	}
	
	public void setNazivTipaGradnje(String ntg)
	{
		txtNazivTipaGradnje.setText(ntg);
	}
	
	public void SacuvajLsn(ActionListener e)
	{
		btnSacuvaj.addActionListener(e);
	}
	
	public void setTableData(String[] zaglavlje, Object[][] podaci)
	{
		tblTipGradnje.setModel(new DefaultTableModel(podaci,zaglavlje));
	}
	
	public void ClearFields() {
		txtNazivTipaGradnje.setText("");
	}
	
}
