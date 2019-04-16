package View;

import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;

import javax.swing.JFrame;

import Ctrl.DjordjeIznajmljivanjeCtrl;
import Ctrl.IZABERI_IZVESTAJ_Ctrl;
import Ctrl.KupacCrtl;
import Ctrl.NekretninaCrtl;
import Ctrl.ProdajaCtrl;
import Ctrl.ZaposleniCtrl;
import Data.Grad;
import Data.Grejanje;
import Data.Iznajmljivanje;
import Data.Lokacija;
import Data.Namestenost;
import Data.Nekretnina;
import Data.TipGradnje;
import Data.TipNekretnine;
import Model.Model;
import sun.invoke.empty.Empty;

import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Window.Type;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;
import javax.swing.UIManager;
import javax.swing.JCheckBox;

public class frmGlavniMeni extends JFrame implements Observer{
	private JButton btnKupac;
	private JButton btnNekretnina;
	private JButton btnZaposleni;
	private JButton btnProdaja;
	private JButton btnIznajmljivanje;
	private JButton btnIzvestaji;
	private JComboBox cbTipNekretnine;
	private JComboBox cbNamestenost;
	private JComboBox cbGrejanje;
	private JComboBox cbTipGradnje;
	private JTextField txtPovrsina;
	private JTextField txtBrSoba;
	private JComboBox cbGrad;
	private JComboBox cbLokacija;
	private JTextField txtBrKupatila;
	private JButton btnPrikazi;
	private JScrollPane scrollPane;
	private JTable tblPretraga;
	private JCheckBox chckbxIzaberiTipNekretnine;
	private JCheckBox chckbxIzaberiTipGradnje;
	private JCheckBox chckbxIzaberiLokaciju;
	private JCheckBox chckbxUpisiPovrsinu;
	private JCheckBox chckbxUpisiBrojSoba;
	private JCheckBox chckbxIzaberiNamestenost;
	private JCheckBox chckbxIzaberiTipGrejanja;
	private JCheckBox chckbxUpisiBrojKupatila;

	private String upit = "Select * from nekretnina where grad = ";
	private JLabel lblIzaberiGrad;
	private String[] zaglavlje = 
		{"ID","Sifra", "Tip nekretnine","Tip gradnje", "Grad", 
		"Adresa", "Lokacija", "Povrsina", "Broj soba", "Broj kupatila", "Namestenost", "Grejanje", "Status"};
	private Model mod;
	
	public frmGlavniMeni(String title)  {
		super(title);
		getContentPane().setBackground(new Color(255, 0, 51));
		getContentPane().setForeground(Color.BLACK);
		setTitle("IZDAVANJE I PRODAJA NEKRETNINA");
		mod = new Model();
		mod.addObserver(this);
		initialize();
	
	}

	private void initialize()
	{
		setBounds(100,200,1246,621);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		btnNekretnina = new JButton("Nekretnina");
		btnNekretnina.setForeground(Color.BLACK);
		btnNekretnina.setBackground(Color.WHITE);
		btnNekretnina.setIcon(new ImageIcon("E:\\Real Estate Managment\\iconfinder_pisa_italy_architecture_tourism_landmark_tower_travel_3465590.png"));
		btnNekretnina.setFont(new Font("Times New Roman", Font.BOLD, 33));
		
		btnKupac = new JButton("Kupac");
		btnKupac.setFont(new Font("Times New Roman", Font.BOLD, 33));
		
		btnZaposleni = new JButton("Zaposleni");
		btnZaposleni.setFont(new Font("Times New Roman", Font.BOLD, 33));
		
		btnProdaja = new JButton("Prodaja");
		btnProdaja.setIcon(new ImageIcon("E:\\Real Estate Managment\\coin.png"));
		btnProdaja.setFont(new Font("Times New Roman", Font.BOLD, 33));
		
		btnIznajmljivanje = new JButton("Iznajmljivanje");
		btnIznajmljivanje.setIcon(new ImageIcon("E:\\Real Estate Managment\\rent.png"));
		btnIznajmljivanje.setFont(new Font("Times New Roman", Font.BOLD, 33));
		
		btnIzvestaji = new JButton("Izvestaji");
		btnIzvestaji.setIcon(new ImageIcon("E:\\Real Estate Managment\\amount.png"));
			
		btnIzvestaji.setFont(new Font("Times New Roman", Font.BOLD, 33));
		
		JPanel pnPretraga = new JPanel();
		pnPretraga.setBackground(new Color(0, 128, 128));
		pnPretraga.setForeground(new Color(0, 0, 0));
		pnPretraga.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Pretrazi nekretnine", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(19)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(btnIzvestaji, GroupLayout.DEFAULT_SIZE, 327, Short.MAX_VALUE)
						.addComponent(btnIznajmljivanje, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnProdaja, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnZaposleni, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnKupac, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnNekretnina, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(18)
					.addComponent(pnPretraga, GroupLayout.DEFAULT_SIZE, 847, Short.MAX_VALUE)
					.addGap(19))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(39)
					.addComponent(btnNekretnina, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
					.addGap(30)
					.addComponent(btnKupac, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
					.addGap(31)
					.addComponent(btnZaposleni, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
					.addGap(33)
					.addComponent(btnProdaja, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
					.addGap(28)
					.addComponent(btnIznajmljivanje, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
					.addGap(31)
					.addComponent(btnIzvestaji, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(35, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(pnPretraga, GroupLayout.DEFAULT_SIZE, 560, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		cbTipNekretnine = new JComboBox();
		cbTipNekretnine.setModel(new DefaultComboBoxModel(new String[] {"Izaberi"}));
		cbTipNekretnine.setEnabled(false);
		
		cbNamestenost = new JComboBox();
		cbNamestenost.setModel(new DefaultComboBoxModel(new String[] {"Izaberi"}));
		cbNamestenost.setEnabled(false);
		
		cbGrejanje = new JComboBox();
		cbGrejanje.setModel(new DefaultComboBoxModel(new String[] {"Izaberi"}));
		cbGrejanje.setEnabled(false);
		
		cbTipGradnje = new JComboBox();
		cbTipGradnje.setEnabled(false);
		cbTipGradnje.setModel(new DefaultComboBoxModel(new String[] {"Izaberi"}));
		
		txtPovrsina = new JTextField();
		txtPovrsina.setEnabled(false);
		txtPovrsina.setColumns(10);
		
		txtBrSoba = new JTextField();
		txtBrSoba.setEnabled(false);
		txtBrSoba.setColumns(10);
		
		cbGrad = new JComboBox();
		
		cbLokacija = new JComboBox();
		cbLokacija.setModel(new DefaultComboBoxModel(new String[] {"Izaberi"}));
		cbLokacija.setEnabled(false);
		
		txtBrKupatila = new JTextField();
		txtBrKupatila.setEnabled(false);
		txtBrKupatila.setColumns(10);
		
		btnPrikazi = new JButton("Prikazi");
		btnPrikazi.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		btnPrikazi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String upit = "Select * from nekretnina where grad = " +((Grad) cbGrad.getSelectedItem()).getIDgrad();
				if(chckbxIzaberiTipNekretnine.isSelected())
				{
					upit += " and tipNekretnine =" + ((TipNekretnine) cbTipNekretnine.getSelectedItem()).getIDtip_nekretnine();
				}
				if(chckbxIzaberiTipGradnje.isSelected())
				{
					upit += " and tip_Gradnje =" + ((TipGradnje) cbTipGradnje.getSelectedItem()).getIDTip_gradnje();
				}
				if(chckbxIzaberiLokaciju.isSelected())
				{
					upit += " and Lokacija =" + ((Lokacija) cbLokacija.getSelectedItem()).getIDlokacija();
				}
				if(chckbxUpisiPovrsinu.isSelected())
				{
					upit += " and Povrsina =" + txtPovrsina.getText().toString();
				}
				if(chckbxUpisiBrojSoba.isSelected())
				{
					upit += " and Broj_soba =" + txtBrSoba.getText().toString();
				}
				if(chckbxIzaberiNamestenost.isSelected())
				{
					upit += " and Namestenost =" + ((Namestenost) cbNamestenost.getSelectedItem()).getIDnamestenost();
				}
				if(chckbxIzaberiTipGrejanja.isSelected())
				{
					upit += " and Grejanje =" + ((Grejanje) cbGrejanje.getSelectedItem()).getIDgrejanje();
				}
				if(chckbxUpisiBrojKupatila.isSelected())
				{
					upit += " and Broj_kupatila =" + txtBrKupatila.getText().toString();
				}
				
				 upit += " and Status = 'Slobodno'";
				
//				
//				  {
//				  JOptionPane.showMessageDialog(null, "Nepostoji nekretnina sa biranim kriterijumom", "GRESKA", JOptionPane.ERROR_MESSAGE);
//				  } 
				mod.GetQueryResult(upit);
				
				cbTipNekretnine.setEnabled(false);
				cbGrejanje.setEnabled(false);
				cbLokacija.setEnabled(false);
				cbNamestenost.setEnabled(false);
				cbTipGradnje.setEnabled(false);
				txtPovrsina.setEnabled(false);
				txtBrSoba.setEnabled(false);
				txtBrKupatila.setEnabled(false);
				chckbxIzaberiTipNekretnine.setSelected(false);
				chckbxIzaberiTipGrejanja.setSelected(false);
				chckbxIzaberiLokaciju.setSelected(false);
				chckbxIzaberiNamestenost.setSelected(false);
				chckbxIzaberiTipGradnje.setSelected(false);
				chckbxUpisiPovrsinu.setSelected(false);
				chckbxUpisiBrojSoba.setSelected(false);
				chckbxUpisiBrojKupatila.setSelected(false);
				
				ClearFields();
			}
		});
		
		scrollPane = new JScrollPane();
		
		chckbxIzaberiTipNekretnine = new JCheckBox("Izaberi tip nekretnine:");
		chckbxIzaberiTipNekretnine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cbTipNekretnine.setEnabled(true);
			}
		});
		
		chckbxIzaberiTipGradnje = new JCheckBox("Izaberi tip gradnje:");
		chckbxIzaberiTipGradnje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cbTipGradnje.setEnabled(true);
			}
		});
		
		chckbxIzaberiLokaciju = new JCheckBox("Izaberi lokaciju:");
		chckbxIzaberiLokaciju.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			cbLokacija.setEnabled(true);
			}
		});
		
		chckbxUpisiPovrsinu = new JCheckBox("Upisi povrsinu:");
		chckbxUpisiPovrsinu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtPovrsina.setEnabled(true);
			}
		});
		
		chckbxUpisiBrojSoba = new JCheckBox("Upisi broj soba:");
		chckbxUpisiBrojSoba.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			txtBrSoba.setEnabled(true);
			}
		});
		
		chckbxIzaberiNamestenost = new JCheckBox("Izaberi namestenost:");
		chckbxIzaberiNamestenost.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			cbNamestenost.setEnabled(true);
			}
		});
		
		chckbxIzaberiTipGrejanja = new JCheckBox("Izaberi tip grejanja:");
		chckbxIzaberiTipGrejanja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			cbGrejanje.setEnabled(true);
			}
		});
		
		chckbxUpisiBrojKupatila = new JCheckBox("Upisi broj kupatila:");
		chckbxUpisiBrojKupatila.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			txtBrKupatila.setEnabled(true);
			}
		});
		
		lblIzaberiGrad = new JLabel("Izaberi grad:");
		lblIzaberiGrad.setForeground(Color.BLACK);
		lblIzaberiGrad.setBackground(Color.LIGHT_GRAY);
		GroupLayout gl_pnPretraga = new GroupLayout(pnPretraga);
		gl_pnPretraga.setHorizontalGroup(
			gl_pnPretraga.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnPretraga.createSequentialGroup()
					.addGroup(gl_pnPretraga.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnPretraga.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 815, Short.MAX_VALUE))
						.addGroup(gl_pnPretraga.createSequentialGroup()
							.addGap(23)
							.addGroup(gl_pnPretraga.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_pnPretraga.createSequentialGroup()
									.addGroup(gl_pnPretraga.createParallelGroup(Alignment.LEADING, false)
										.addComponent(chckbxIzaberiTipGradnje, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(cbGrad, 0, 172, Short.MAX_VALUE)
										.addComponent(cbTipGradnje, 0, 172, Short.MAX_VALUE)
										.addComponent(cbTipNekretnine, 0, 172, Short.MAX_VALUE)
										.addComponent(chckbxIzaberiTipNekretnine, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
									.addGap(50))
								.addGroup(gl_pnPretraga.createSequentialGroup()
									.addComponent(lblIzaberiGrad, GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.RELATED)))
							.addGroup(gl_pnPretraga.createParallelGroup(Alignment.LEADING)
								.addComponent(txtBrSoba, GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
								.addGroup(gl_pnPretraga.createSequentialGroup()
									.addComponent(txtPovrsina, GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.RELATED))
								.addComponent(cbLokacija, 0, 176, Short.MAX_VALUE)
								.addComponent(chckbxIzaberiLokaciju, GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
								.addComponent(chckbxUpisiPovrsinu, GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
								.addComponent(chckbxUpisiBrojSoba, GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE))
							.addGap(42)
							.addGroup(gl_pnPretraga.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_pnPretraga.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_pnPretraga.createSequentialGroup()
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(cbGrejanje, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
										.addGap(18)
										.addComponent(btnPrikazi, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE))
									.addGroup(gl_pnPretraga.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(chckbxIzaberiNamestenost, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(chckbxIzaberiTipGrejanja, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(cbNamestenost, Alignment.LEADING, 0, 172, Short.MAX_VALUE)))
								.addGroup(gl_pnPretraga.createParallelGroup(Alignment.TRAILING, false)
									.addComponent(chckbxUpisiBrojKupatila, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(txtBrKupatila, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)))
							.addGap(11)))
					.addContainerGap())
		);
		gl_pnPretraga.setVerticalGroup(
			gl_pnPretraga.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnPretraga.createSequentialGroup()
					.addGroup(gl_pnPretraga.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnPretraga.createParallelGroup(Alignment.BASELINE)
							.addComponent(chckbxIzaberiLokaciju)
							.addComponent(chckbxIzaberiNamestenost))
						.addGroup(gl_pnPretraga.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblIzaberiGrad)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_pnPretraga.createParallelGroup(Alignment.BASELINE)
						.addComponent(cbGrad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(cbLokacija, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(cbNamestenost, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_pnPretraga.createParallelGroup(Alignment.BASELINE)
						.addComponent(chckbxIzaberiTipNekretnine)
						.addComponent(chckbxUpisiPovrsinu)
						.addComponent(chckbxIzaberiTipGrejanja))
					.addGap(7)
					.addGroup(gl_pnPretraga.createParallelGroup(Alignment.BASELINE)
						.addComponent(cbTipNekretnine, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtPovrsina, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(cbGrejanje, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnPrikazi))
					.addGap(18)
					.addGroup(gl_pnPretraga.createParallelGroup(Alignment.LEADING)
						.addComponent(chckbxIzaberiTipGradnje)
						.addGroup(gl_pnPretraga.createParallelGroup(Alignment.BASELINE)
							.addComponent(chckbxUpisiBrojSoba)
							.addComponent(chckbxUpisiBrojKupatila)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_pnPretraga.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnPretraga.createParallelGroup(Alignment.BASELINE)
							.addComponent(cbTipGradnje, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(txtBrKupatila, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(txtBrSoba, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 352, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		
		tblPretraga = new JTable();
		tblPretraga.setBackground(new Color(255, 255, 255));
		tblPretraga.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblPretraga);
		pnPretraga.setLayout(gl_pnPretraga);
		getContentPane().setLayout(groupLayout);
	}
	
	public void setNekretninaListener(ActionListener a)
	{
		btnNekretnina.addActionListener(a);
	}
	
	public void setKupacListener(ActionListener a)
	{
		btnKupac.addActionListener(a);
	}
	
	public void setZaposleniListener(ActionListener a)
	{
		btnZaposleni.addActionListener(a);
	}
	
	public void setProdajaListener(ActionListener a)
	{
		btnProdaja.addActionListener(a);
	}
	
	public void setIznajmljivanjeListener(ActionListener a)
	{
		btnIznajmljivanje.addActionListener(a);
	}
	
	public void setIzvestajListener(ActionListener a)
	{
		btnIzvestaji.addActionListener(a);
	}
	
	//////////////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////////////
	
	public void setTableData(String[] zaglavlje, Object[][] podaci)
	{
		tblPretraga.setModel(new DefaultTableModel(podaci, zaglavlje));
		
	}
	public int getPovrsina() 
	{
		if(txtPovrsina.getText().equals(""))
		{
			return 0;
		}
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
	
	public void setGrejanjeCB(ArrayList<Grejanje> gr)
	{
		cbGrejanje.removeAllItems();
		for(Grejanje GR : gr)
		{
			cbGrejanje.addItem(GR);
		}
	}
	
	public void setGradCB(ArrayList<Grad> gradovi)
	{
		cbGrad.removeAllItems();
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
		public void ClearFields()
		{
			txtBrKupatila.setText("");
			txtBrSoba.setText("");
			txtPovrsina.setText("");
		}
		
		public void setPrikaziListener(ActionListener a)
		{
			btnPrikazi.addActionListener(a);
		}

		@Override
		public void update(Observable arg0, Object arg1) {
			if(!((ArrayList<Object>)arg1).isEmpty())
			{
			if(((ArrayList<Object>) arg1).get(0) instanceof Nekretnina)
	{
		ArrayList<Nekretnina> lista = (ArrayList<Nekretnina>)arg1;
		Object[][] podaci = new Object[lista.size()][zaglavlje.length];
		int i=0;
		for(Nekretnina red : lista)
		{
			podaci[i][0] = red.getIDnekretnina();
			podaci[i][1] = red.getSifraNekretnine();
			podaci[i][2] = red.getTipNekretnine();
			podaci[i][3] = red.getTipGradnje();
			podaci[i][4] = red.getGrad();
			podaci[i][5] = red.getAdresa();
			podaci[i][6] = red.getLokacija();
			podaci[i][7] = red.getPovrsina();
			podaci[i][8] = red.getBroj_soba();
			podaci[i][9] = red.getBroj_kupatila();
			podaci[i][10] = red.getNamestenost();
			podaci[i][11] = red.getGrejanje();
			podaci[i][12] = red.getStatus();
			i++;
		}
		tblPretraga.setModel(new DefaultTableModel(podaci,zaglavlje));
	}
			}
			
		}
}
