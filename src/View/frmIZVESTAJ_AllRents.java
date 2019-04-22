package View;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;

public class frmIZVESTAJ_AllRents extends JFrame{
	private JTable tblSvaIznajmljivanja;
	private JButton btnPrintReportTo;

	public frmIZVESTAJ_AllRents(String arg) {
		super(arg);
		setTitle("Report off all rented property");
		
		initialize();
	}
	
	private void initialize()
	{
		setBounds(100,200,846,780);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		JScrollPane scrollPane = new JScrollPane();
		
		btnPrintReportTo = new JButton("PDF");
		btnPrintReportTo.setIcon(new ImageIcon("E:\\real-estate-managment\\src\\resources\\iconfinder_filequickprint_6045.png"));
		btnPrintReportTo.setSelectedIcon(new ImageIcon("E:\\real-estate-managment\\src\\resources\\iconfinder_filequickprint_6045.png"));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnPrintReportTo, GroupLayout.PREFERRED_SIZE, 302, GroupLayout.PREFERRED_SIZE)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 789, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 592, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnPrintReportTo, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(21, Short.MAX_VALUE))
		);
		
		tblSvaIznajmljivanja = new JTable();
		tblSvaIznajmljivanja.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblSvaIznajmljivanja);
		getContentPane().setLayout(groupLayout);
	}
	
	public void setTableDataSvaIznajmljivanja(String[] zaglavlje, Object[][] podaci)
	{
		tblSvaIznajmljivanja.setModel(new DefaultTableModel(podaci, zaglavlje));
	}
	public void setPrintLsn(ActionListener a)
	{
		btnPrintReportTo.addActionListener(a);
	}
	
}
