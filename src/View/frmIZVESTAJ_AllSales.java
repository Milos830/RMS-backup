package View;

import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class frmIZVESTAJ_AllSales extends JFrame {
	private JTable tblSveProdateNekretnine;

	public frmIZVESTAJ_AllSales(String arg0)  {
		super(arg0);
		initialize();
	}
	
	private void initialize()
	{
		setBounds(100,200,702,574);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 667, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 516, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		tblSveProdateNekretnine = new JTable();
		tblSveProdateNekretnine.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblSveProdateNekretnine);
		getContentPane().setLayout(groupLayout);
	}
	
	public void setTableDataSveProdateNekretnine(String[] zaglavlje, Object[][] podaci)
	{
		tblSveProdateNekretnine.setModel(new DefaultTableModel(podaci, zaglavlje));
	}
}
