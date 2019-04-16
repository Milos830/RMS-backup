package View;

import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

import Data.Grad;
import Data.Grejanje;
import Data.Lokacija;
import Data.Namestenost;
import Data.TipGradnje;
import Data.TipNekretnine;

import java.awt.List;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.Choice;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;

public class frmPretraga extends JFrame {
	private JScrollPane scrollPane;
	private JTable tblPretraga;

	

	public frmPretraga(String title)  {
		super(title);
		initialize();
	
	}

	private void initialize()
	{
		setBounds(100,200,1081,647);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		scrollPane = new JScrollPane();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(25)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(588, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(132)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 443, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(22, Short.MAX_VALUE))
		);
		
		tblPretraga = new JTable();
		tblPretraga.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblPretraga);
		getContentPane().setLayout(groupLayout);
	}

	
}
