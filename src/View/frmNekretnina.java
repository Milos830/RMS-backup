package View;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Ctrl.GradCtrl;
import Ctrl.GrejanjeCtrl;
import Ctrl.LokacijaCtrl;
import Ctrl.NamestenostCtrl;
import Ctrl.NekretninaCrtl;
import Ctrl.TipGradnjeCtrl;
import Ctrl.TipNekretnineCtrl;
import Data.Grad;
import Data.Grejanje;
import Data.Lokacija;
import Data.Namestenost;
import Data.Nekretnina;
import Data.TipGradnje;
import Data.TipNekretnine;
import Model.Model;

import java.awt.event.ActionEvent;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuItem;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.LineBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.border.TitledBorder;

public class frmNekretnina extends JFrame {
	private JTextField txtAdresa;
	private JTextField txtPovrsina;
	private JTextField txtBrSoba;
	private JTextField txtBrKupatila;
	private JTable tblNekretnina;
	private JComboBox cbTipNekretnine;
	private JComboBox cbGrad;
	private JComboBox cbLokacija;
	private JComboBox cbNamestenost;
	private JComboBox cbGrejanje;
	private JButton btnSacuvaj;
	private JButton btnDodajTipNekretnine;
	private JButton btnDodajGrad;
	private JComboBox cbTipGradnje;
	private JButton btnDodajTipGradnje;
	private JButton btnDodajLokaciju;
	private JButton btnDodajNamestenost;
	private JButton btnDodajGrejanje;
	private JPopupMenu popupMenu;
	private JMenuItem mntmIzmeni;
	private JLabel lblSifraNekretnine;
	private JTextField txtSifraNekretnine;

	

	public frmNekretnina(String arg0)  {
		super(arg0);
		setTitle("Nekretnina");
		
		
		initialize();
	
	}

	private void initialize()
	{
		setBounds(100,200,900,792);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		JSplitPane splitPane = new JSplitPane();
		splitPane.setResizeWeight(0.6);
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		
		JScrollPane scrollPane = new JScrollPane();
		splitPane.setLeftComponent(scrollPane);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Dodaj novu nekretninu", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setForeground(Color.WHITE);
		scrollPane.setViewportView(panel);
		
		lblSifraNekretnine = new JLabel("Sifra nekretnine:");
		
		txtSifraNekretnine = new JTextField();
		txtSifraNekretnine.setColumns(10);
		
		JLabel lblTipNekretnine = new JLabel("Tip nekretnine:");
		
		cbTipNekretnine = new JComboBox();
		
		btnDodajTipNekretnine = new JButton("Dodaj tip nekretnine");
		
		JLabel lblTipGradnje = new JLabel("Tip gradnje:");
		
		cbTipGradnje = new JComboBox();
		
		btnDodajTipGradnje = new JButton("Dodaj tip gradnje");
		
		JLabel lblIzaberiGrad = new JLabel("Izaberi grad:");
		
		cbGrad = new JComboBox();
		
		btnDodajNamestenost = new JButton("Dodaj namestenost");
		
		btnDodajGrad = new JButton("Dodaj grad");
		
		JLabel lblAdresa = new JLabel("Adresa:");
		
		txtAdresa = new JTextField();
		txtAdresa.setColumns(10);
		
		JLabel lblLokacija = new JLabel("Lokacija:");
		
		cbLokacija = new JComboBox();
		
		btnDodajLokaciju = new JButton("Dodaj lokaciju");
		
		JLabel lblPovrsina = new JLabel("Povrsina:");
		
		txtPovrsina = new JTextField();
		txtPovrsina.setColumns(10);
		
		JLabel lblBrojSoba = new JLabel("Broj soba:");
		
		txtBrSoba = new JTextField();
		txtBrSoba.setColumns(10);
		
		JLabel lblBrojKupatila = new JLabel("Broj kupatila:");
		
		txtBrKupatila = new JTextField();
		txtBrKupatila.setColumns(10);
		
		JLabel lblNamestenost = new JLabel("Namestenost:");
		
		cbNamestenost = new JComboBox();
		
		JLabel lblGrejanje = new JLabel("Grejanje:");
		
		cbGrejanje = new JComboBox();
		
		btnDodajGrejanje = new JButton("Dodaj grejanje");
		
		btnSacuvaj = new JButton("Sacuvaj");
		btnSacuvaj.setIcon(new ImageIcon("E:\\real-estate-managment\\src\\resources\\iconfinder_fileexport_6039.png"));
		btnSacuvaj.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(58)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(22)
									.addComponent(lblTipGradnje)
									.addGap(5)
									.addComponent(cbTipGradnje, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(42)
									.addComponent(lblAdresa)
									.addGap(5)
									.addComponent(txtAdresa, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(35)
									.addComponent(lblPovrsina)
									.addGap(5)
									.addComponent(txtPovrsina, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(31)
									.addComponent(lblBrojSoba)
									.addGap(5)
									.addComponent(txtBrSoba, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(17)
									.addComponent(lblBrojKupatila)
									.addGap(5)
									.addComponent(txtBrKupatila, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup()
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panel.createSequentialGroup()
											.addGap(18)
											.addComponent(lblIzaberiGrad)
											.addGap(5)
											.addComponent(cbGrad, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_panel.createSequentialGroup()
											.addGap(38)
											.addComponent(lblLokacija)
											.addGap(5)
											.addComponent(cbLokacija, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_panel.createSequentialGroup()
											.addComponent(lblSifraNekretnine)
											.addGap(5)
											.addComponent(txtSifraNekretnine, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_panel.createSequentialGroup()
											.addGap(8)
											.addComponent(lblTipNekretnine)
											.addGap(5)
											.addComponent(cbTipNekretnine, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_panel.createSequentialGroup()
											.addGap(13)
											.addComponent(lblNamestenost)
											.addGap(5)
											.addComponent(cbNamestenost, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_panel.createSequentialGroup()
											.addGap(35)
											.addComponent(lblGrejanje)
											.addGap(5)
											.addComponent(cbGrejanje, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)))
									.addGap(29)
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(btnDodajGrejanje, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
										.addComponent(btnDodajNamestenost, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
										.addComponent(btnDodajLokaciju, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
										.addComponent(btnDodajTipGradnje, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
										.addComponent(btnDodajGrad, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
										.addComponent(btnDodajTipNekretnine)))))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(143)
							.addComponent(btnSacuvaj, GroupLayout.PREFERRED_SIZE, 242, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(397, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(28)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(3)
							.addComponent(lblSifraNekretnine))
						.addComponent(txtSifraNekretnine, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(5)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(4)
							.addComponent(lblTipNekretnine))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(1)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(cbTipNekretnine, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnDodajTipNekretnine))))
					.addGap(7)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(4)
							.addComponent(lblTipGradnje))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(1)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(cbTipGradnje, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnDodajTipGradnje))))
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(7)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(4)
									.addComponent(lblIzaberiGrad))
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(1)
									.addComponent(cbGrad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addGap(7)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(3)
									.addComponent(lblAdresa))
								.addComponent(txtAdresa, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnDodajGrad)))
					.addGap(5)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(4)
							.addComponent(lblLokacija))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(1)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(cbLokacija, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnDodajLokaciju))))
					.addGap(7)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(3)
							.addComponent(lblPovrsina))
						.addComponent(txtPovrsina, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(5)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(3)
							.addComponent(lblBrojSoba))
						.addComponent(txtBrSoba, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(5)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(3)
							.addComponent(lblBrojKupatila))
						.addComponent(txtBrKupatila, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(5)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(4)
							.addComponent(lblNamestenost))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(1)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(cbNamestenost, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnDodajNamestenost))))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panel.createSequentialGroup()
								.addGap(4)
								.addComponent(lblGrejanje))
							.addGroup(gl_panel.createSequentialGroup()
								.addGap(1)
								.addComponent(cbGrejanje, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addComponent(btnDodajGrejanje))
					.addGap(18)
					.addComponent(btnSacuvaj, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(39, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBorder(new LineBorder(new Color(130, 135, 144)));
		splitPane.setRightComponent(scrollPane_1);
		
		tblNekretnina = new JTable();
		tblNekretnina.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		tblNekretnina.setFillsViewportHeight(true);
		scrollPane_1.setViewportView(tblNekretnina);
		
		popupMenu = new JPopupMenu();
		addPopup(tblNekretnina, popupMenu);
		
		mntmIzmeni = new JMenuItem("Izmeni");
		popupMenu.add(mntmIzmeni);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(splitPane, GroupLayout.DEFAULT_SIZE, 874, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(splitPane, GroupLayout.DEFAULT_SIZE, 731, Short.MAX_VALUE)
		);
		getContentPane().setLayout(groupLayout);
	}
	
	public String getSifraNekretnine()
	{
		return txtSifraNekretnine.getText();
	}
	
	public void setSifraNekretnine(String sifra)
	{
		txtSifraNekretnine.setText(sifra);
	}
	
	public String getAdresa()
	{
		return txtAdresa.getText();
	}
	
	public void setAdresa(String Ad)
	{
		txtAdresa.setText(Ad);
	}
	
	public int getPovrsina() 
	{
		return Integer.parseInt(txtPovrsina.getText());
	}
	
	public void setPovrsina(int p)
	{
		txtPovrsina.setText(Integer.toString(p));
	}
	
	public int getBrojSoba()
	{
		if(txtBrSoba.getText().equals("")) { // ako zelim da mi upise da nemam sobe, tj da je prazan prostor
			return  0;
		} 
		return Integer.parseInt(txtBrSoba.getText());
	}
	
	public void setBrojSoba(Integer brS)
	{
		
		txtBrSoba.setText(Integer.toString(brS));
	}
	
	
	
	public int getBrojKupatila() 
	{
		if(txtBrKupatila.getText().equals("")) {
			return 0;
		}
		return Integer.parseInt(txtBrKupatila.getText());
	}
	
	public void setBrojKupatila(Integer brK)
	{
		txtBrKupatila.setText(Integer.toString(brK));
	}
	
	public Object getTipNekretnine()
	{
		return cbTipNekretnine.getSelectedItem();
	}
	
	public void setTipNekretnine(Object tip)
	{
		cbTipNekretnine.setSelectedItem(tip);
	}
	
	public Object getTipGradnje()
	{
		return cbTipGradnje.getSelectedItem();
	}
	
	public void setTipGradnje(Object tipGr)
	{
		cbTipGradnje.setSelectedItem(tipGr);
	}
	
	public Object getGrad()
	{
		return cbGrad.getSelectedItem();
	}
	
	public void setGrad(Object grad)
	{
		cbGrad.setSelectedItem(grad);
	}
	
	public Object getLokacija()
	{
		return cbLokacija.getSelectedItem();
	}
	
	public void setLokacija(Object lokacija)
	{
		cbLokacija.setSelectedItem(lokacija);
	}
	
	public Object getNamestenost()
	{
		return cbNamestenost.getSelectedItem();
	}
	
	public void setNamestenost(Object namestenost)
	{
		cbNamestenost.setSelectedItem(namestenost);
	}
	
	public Object getGrejanje()
	{
		return cbGrejanje.getSelectedItem();
	}
	
	public void setGrejanje(Object grejanje)
	{
		cbGrejanje.setSelectedItem(grejanje);
	}
	/////// BUTTONS ////////////////
	
	
	public void setDodajTipNekretnineListener(ActionListener a)
	{
		btnDodajTipNekretnine.addActionListener(a);
	}
	
	public void setDodajTipGradnjeListener(ActionListener a)
	{
		btnDodajTipGradnje.addActionListener(a);
	}
	
	public void setDodajGradListener(ActionListener a)
	{
		btnDodajGrad.addActionListener(a);
	}
	
	public void setDodajLokacijaListener(ActionListener a)
	{
		btnDodajLokaciju.addActionListener(a);
	}
	
	public void setDodajNamestenostListener(ActionListener a)
	{
		btnDodajNamestenost.addActionListener(a);
	}
	
	public void setDodajGrejanjeListener(ActionListener a)
	{
		btnDodajGrejanje.addActionListener(a);
	}
	
	public void setSacuvajListener(ActionListener a)
	{
		btnRemoveListeners();
		btnSacuvaj.addActionListener(a);
	}
	
	private void btnRemoveListeners()
	{
		for (ActionListener al : btnSacuvaj.getActionListeners()) {
			btnSacuvaj.removeActionListener(al);
		}
	}
	
	public JMenuItem getMntmIzmeniNekretninu() {
		return mntmIzmeni;
	}
	public void desniKlikIzmeni(ActionListener a) {
		mntmIzmeni.addActionListener(a);
	}
	
	public void SacuvajButton(String s)
	{
		btnSacuvaj.setText(s);
	}
	
	/////////////////////////////////////// TABELA /////////////////
	public void setTableData(String[] zaglavlje, Object[][] podaci)
	{
		tblNekretnina.setModel(new DefaultTableModel(podaci, zaglavlje));
		
	}
	public Nekretnina getSelectedItemFromTable() {
		if(tblNekretnina.getSelectedRow()>=0)
		{
		return (Nekretnina) tblNekretnina.getValueAt(tblNekretnina.getSelectedRow(),1);
		}
		return null;
} 
	
	public void setTipNekretnine() // ZASTO OVO ?
	{
	((TipNekretnine) tblNekretnina.getValueAt(tblNekretnina.getSelectedRow(), 1)).getIDtip_nekretnine();
		for (int i =0;i<cbTipNekretnine.getItemCount();i++) {
			if((((TipNekretnine)cbTipNekretnine.getItemAt(i)).getIDtip_nekretnine())==((TipNekretnine) tblNekretnina.getValueAt(tblNekretnina.getSelectedRow(), 1)).getIDtip_nekretnine()) 
			{
				//System.out.println(id+" "+cbtipNekretnine.getComponentCount());
				cbTipNekretnine.setSelectedIndex(i);
			}
		}
		
	}
	
	public void setGrad(int id)
	{
	for (int i =0;i<cbGrad.getItemCount();i++) {
		if((((Grad)cbGrad.getItemAt(i)).getIDgrad())==id) 
		{
				cbGrad.setSelectedIndex(i);
		}
	}
	}
	
	public void setTipGradnje(int id)
	{
	for (int i =0;i<cbTipGradnje.getItemCount();i++) {
		if((((TipGradnje)cbTipGradnje.getItemAt(i)).getIDTip_gradnje())==id) 
		{
				cbTipGradnje.setSelectedIndex(i);
		}}
	}
	
	public void setTipNekretnine(int id)
	{
	for (int i =0;i<cbTipNekretnine.getItemCount();i++) {
		if((((TipNekretnine) cbTipNekretnine.getItemAt(i)).getIDtip_nekretnine())==id) 
		{
				cbTipNekretnine.setSelectedIndex(i);
		}
	}
	}
	public void setLokacija(int id)
	{
		for(int i=0; i<cbLokacija.getItemCount(); i++) {
			if((((Lokacija) cbLokacija.getItemAt(i)).getIDlokacija()) == id)
			{
				cbLokacija.setSelectedIndex(i);
			}
		}
	}
	
	public void setNamestenost(int id)
	{
		for(int i=0; i<cbNamestenost.getItemCount(); i++) {
			if((((Namestenost) cbNamestenost.getItemAt(i)).getIDnamestenost()) == id)
			{
				cbNamestenost.setSelectedIndex(i);
			}
		}
	}
	
	public void setGrejanje(int id)
	{
		for(int i=0; i<cbGrejanje.getItemCount(); i++) {
			if((((Grejanje) cbGrejanje.getItemAt(i)).getIDgrejanje())== id)
			{
				cbGrejanje.setSelectedIndex(i);
			}
		}
	}
	
	public void setGradCB(ArrayList<Grad> gradovi)
	{
		cbGrad.removeAllItems();
		System.out.println("Gradovi");
		for(Grad grad : gradovi)
		{
			cbGrad.addItem(grad);
		}
	}
		
		public void setTipNekretnineCB(ArrayList<TipNekretnine> tip)
		{
			for (TipNekretnine tipNekretnine : tip) 
			{
				cbTipNekretnine.addItem(tipNekretnine);
				
			}
		}
		
		public void setTipGradnjeCB(ArrayList<TipGradnje> tipG) /// da bi se pojavio tip gradnje u kombo boksu, setovanje
		{
			for (TipGradnje tipGradnje : tipG) {
				cbTipGradnje.addItem(tipGradnje);
			}
		}
		
		public void setLokacijaCB(ArrayList<Lokacija> loka)
		{
			for (Lokacija LOK : loka) {
				cbLokacija.addItem(LOK);
				
			}
		}
		
		public void setNamestenostCB(ArrayList<Namestenost> names)
		{
			for(Namestenost NAM : names)
			{
				cbNamestenost.addItem(NAM);
			}
		}
		
		public void setGrejanjeCB(ArrayList<Grejanje> gr)
		{
			for(Grejanje GR : gr)
			{
				cbGrejanje.addItem(GR);
			}
		}
		
		public void ClearFields()
		{
			txtAdresa.setText("");
			txtBrKupatila.setText("");
			txtBrSoba.setText("");
			txtPovrsina.setText("");
			txtSifraNekretnine.setText("");
			
			
		}
		
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}

	

