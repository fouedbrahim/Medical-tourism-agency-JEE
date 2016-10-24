package ttma.client.GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTabbedPane;

import ttma.Entities.Doctor;
import ttma.Entities.DoctorDisponibilities;
import ttma.Entities.MedicalCenters;
import ttma.client.delegate.GestionDoctorDISPDelegate;
import ttma.client.delegate.GestionDoctorDelegate;
import ttma.client.delegate.GestionMedicalCentersDelegate;

import javax.swing.JTable;

import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.beansbinding.ObjectProperty;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextArea;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JInternalFrame;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;

import com.toedter.calendar.JDateChooser;

import javax.swing.Box;

import java.awt.ScrollPane;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JScrollPane;

public class IManageClincs extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	List <Doctor> hotels;
	Doctor hotel;
	List <MedicalCenters> hotels1;
	MedicalCenters hotel1;
	private JTable table;
	private JTextField nom;
	private JTextField email;
	private JTextField cin;
	private JTextField exp;
	private JTextField adr;
	private JTextField spe;
	private JTextField CenterADR;
	private JTextField CenterSpec;
	private JTextField CenterResp;
	private JTextField centerName;
	private JTable table_1;
	private JTextField txtDoctorName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IManageClincs frame = new IManageClincs();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public IManageClincs() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setBackground(SystemColor.window);
		hotels=new ArrayList<Doctor>();
		hotels=GestionDoctorDelegate.dofindAllDoctors();
		
		
		hotels1=new ArrayList<MedicalCenters>();
		hotels1=GestionMedicalCentersDelegate.dofindAllMedicalCenters();
		setBounds(100, 100, 1371, 948);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel_2 = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 1354, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(181, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 900, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel_2.setLayout(null);
		
		JButton btnDisconnect = new JButton("home");
		btnDisconnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
IMedicalResponsible f =new IMedicalResponsible();
				
				f.setVisible(true);
			}
		});
		btnDisconnect.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnDisconnect.setIcon(new ImageIcon("C:\\images\\32x32\\close.png"));
		btnDisconnect.setBounds(39, 399, 158, 41);
		panel_2.add(btnDisconnect);
		
		JButton btnSendEmail = new JButton("SEND EMAIL");
		btnSendEmail.setIcon(new ImageIcon("C:\\images\\32x32\\mail.png"));
		btnSendEmail.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSendEmail.setBounds(39, 338, 158, 44);
		panel_2.add(btnSendEmail);
		btnSendEmail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EnvoiMail em=new EnvoiMail();
				em.show();
			}
		});
		
		JButton btnNewButton_5 = new JButton("Voip Call");
		btnNewButton_5.setIcon(new ImageIcon("C:\\images\\32x32\\phone.png"));
		btnNewButton_5.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_5.setBounds(39, 281, 158, 44);
		panel_2.add(btnNewButton_5);
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Runtime runtime = Runtime.getRuntime();
				try {
					runtime.exec(new String[] { "C:\\Program Files (x86)\\VoipConnect.com\\VoipConnect\\VoipConnect.exe" } );
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setFont(new Font("Tahoma", Font.BOLD, 13));
		tabbedPane.setBounds(227, 281, 1083, 488);
		panel_2.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Manage doctors", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblCin = new JLabel("CIN  :");
		lblCin.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCin.setBounds(34, 16, 100, 16);
		panel.add(lblCin);
		
		cin = new JTextField();
		cin.setFont(new Font("Tahoma", Font.BOLD, 13));
		cin.setBounds(177, 16, 147, 22);
		panel.add(cin);
		cin.setColumns(10);
		
		nom = new JTextField();
		nom.setFont(new Font("Tahoma", Font.BOLD, 13));
		nom.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				txtDoctorName.setText(nom.getText());
			}
		});
		nom.setBounds(177, 45, 147, 22);
		panel.add(nom);
		nom.setColumns(10);
		
		JLabel lblDoctorName = new JLabel("Doctor name:");
		lblDoctorName.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDoctorName.setBounds(34, 45, 100, 16);
		panel.add(lblDoctorName);
		
		JLabel lblAdresse = new JLabel("Email :");
		lblAdresse.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblAdresse.setBounds(34, 80, 74, 16);
		panel.add(lblAdresse);
		
		email = new JTextField();
		email.setFont(new Font("Tahoma", Font.BOLD, 13));
		email.setBounds(177, 80, 147, 22);
		panel.add(email);
		email.setColumns(10);
		
		JLabel lblDescription = new JLabel("Hospital:");
		lblDescription.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDescription.setBounds(34, 123, 74, 16);
		panel.add(lblDescription);
		
		adr = new JTextField();
		adr.setFont(new Font("Tahoma", Font.BOLD, 13));
		adr.setBounds(177, 192, 147, 22);
		panel.add(adr);
		adr.setColumns(10);
		
		spe = new JTextField();
		spe.setFont(new Font("Tahoma", Font.BOLD, 13));
		spe.setBounds(177, 227, 147, 22);
		panel.add(spe);
		spe.setColumns(10);
		
		JLabel lblSpeciality = new JLabel("Speciality :");
		lblSpeciality.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSpeciality.setBounds(34, 227, 74, 16);
		panel.add(lblSpeciality);
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblAddress.setBounds(34, 192, 74, 16);
		panel.add(lblAddress);
		
		JLabel lblNbrYearOf = new JLabel("Experience years :");
		lblNbrYearOf.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNbrYearOf.setBounds(34, 163, 131, 16);
		panel.add(lblNbrYearOf);
		
		exp = new JTextField();
		exp.setFont(new Font("Tahoma", Font.BOLD, 13));
		exp.setBounds(177, 155, 147, 22);
		panel.add(exp);
		exp.setColumns(10);
		
		//JTextArea ds = new JTextArea();

		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(930, 77, 116, 41);
		panel.add(dateChooser);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setIcon(new ImageIcon("C:\\images\\32x32\\accept.png"));
		btnNewButton.setBounds(34, 285, 147, 41);
		panel.add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("Delete");
		btnNewButton_2.setIcon(new ImageIcon("C:\\images\\32x32\\delete.png"));
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_2.setBounds(34, 341, 147, 41);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_1 = new JButton("Update");
		btnNewButton_1.setIcon(new ImageIcon("C:\\images\\32x32\\up.png"));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_1.setBounds(34, 404, 147, 41);
		panel.add(btnNewButton_1);
		
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 13));
		comboBox.setBounds(177, 120, 147, 22);
		panel.add(comboBox);
		comboBox.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				List<MedicalCenters> l=GestionMedicalCentersDelegate.dofindAllMedicalCentersbyName();
				 for(Iterator it=l.iterator(); it.hasNext();)
				 {comboBox.addItem(it.next());}
			}
			
		});
		
		JButton btnAddDoctorDisponibilities = new JButton("Add Doctor Disponibilities");
		btnAddDoctorDisponibilities.setIcon(new ImageIcon("C:\\images\\32x32\\accept.png"));
		btnAddDoctorDisponibilities.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnAddDoctorDisponibilities.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

				  String sd = dateFormat.format(dateChooser.getDate());
				  
		DoctorDisponibilities hotel1=new DoctorDisponibilities();
				hotel1.setDoctor_name(txtDoctorName.getText());
					hotel1.setDate_disp(sd);
					
					
					GestionDoctorDISPDelegate.doaddDoctordisp(hotel1);
							
						JOptionPane.showMessageDialog(null,"ajout reussie");

				
			}
		});
		btnAddDoctorDisponibilities.setBounds(795, 131, 251, 48);
		panel.add(btnAddDoctorDisponibilities);
		
		JLabel lblDoctorName_1 = new JLabel("Doctor name :");
		lblDoctorName_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDoctorName_1.setBounds(783, 16, 105, 16);
		panel.add(lblDoctorName_1);
		
		txtDoctorName = new JTextField();
		txtDoctorName.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtDoctorName.setBounds(930, 13, 116, 41);
		panel.add(txtDoctorName);
		txtDoctorName.setColumns(10);
		
		JLabel lblDisponibilityDate = new JLabel("Disponibility date :");
		lblDisponibilityDate.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDisponibilityDate.setBounds(784, 80, 121, 16);
		panel.add(lblDisponibilityDate);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(373, 16, 383, 429);
		panel.add(scrollPane);
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setFont(new Font("Tahoma", Font.BOLD, 13));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{},
			},
			new String[] {
			}
		));
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				hotel=hotels.get(table.getSelectedRow());
				nom.setText(hotel.getFirsNameDoc());
				email.setText(hotel.getEmailDoc());
				
				//comboboxCL.setText(hotel.getClinic());
				adr.setText(hotel.getAdressDoc());
				spe.setText(hotel.getSpecialityDoc());
				cin.setText(Integer.toString(hotel.getNumCinDoc()));
				exp.setText(Integer.toString(hotel.getNbrYearsOfExp()));
			}
		});
		
		
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				List<MedicalCenters> l=GestionMedicalCentersDelegate.dofindAllMedicalCentersbyName();
				 for(Iterator it=l.iterator(); it.hasNext();)
				 {comboBox.addItem(it.next());
				}
			}
		});
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				hotel.setFirsNameDoc(nom.getText());
				hotel.setEmailDoc(email.getText());
			hotel.setClinic(comboBox.getSelectedItem().toString());
				hotel.setAdressDoc(adr.getText());
				hotel.setNbrYearsOfExp(Integer.parseInt(exp.getText()));
				hotel.setNumCinDoc(Integer.parseInt(cin.getText()));
				if(GestionDoctorDelegate.doupdateDoctor(hotel)){
					JOptionPane.showMessageDialog(null, "update reussie...");
					nom.setText("");
					//comboboxCL.setText("");
					email.setText("");
					spe.setText("");
					exp.setText("");
					cin.setText("");
					adr.setText("");
					hotels=GestionDoctorDelegate.dofindAllDoctors();
					initDataBindings();
					initDataBindings1();
				}
				else{}
			}
		});
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hotel=hotels.get(table.getSelectedRow());
				if(GestionDoctorDelegate.dodeleteDoctor(hotel)){
					JOptionPane.showMessageDialog(null, "delete reussie...");
					nom.setText("");
					//comboboxCL.setText("");
					email.setText("");
					spe.setText("");
					exp.setText("");
					cin.setText("");
					adr.setText("");
					hotels=GestionDoctorDelegate.dofindAllDoctors();
					initDataBindings();
					initDataBindings1();
				}
				else{}
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Doctor hotel=new Doctor();
				hotel.setFirsNameDoc(nom.getText());
				hotel.setAdressDoc(adr.getText());
			    hotel.setClinic(comboBox.getSelectedItem().toString());
				hotel.setEmailDoc(email.getText());
				hotel.setNbrYearsOfExp(Integer.parseInt(exp.getText()));
				hotel.setNumCinDoc(Integer.parseInt(cin.getText()));
				hotel.setSpecialityDoc(spe.getText());
				
				if(GestionDoctorDelegate.doaddDoctor(hotel)){
					JOptionPane.showMessageDialog(null,"ajout reussie");
					nom.setText("");
				//	comboboxCL.setText("");
					email.setText("");
					spe.setText("");
					exp.setText("");
					cin.setText("");
					adr.setText("");
					hotels=GestionDoctorDelegate.dofindAllDoctors();
					initDataBindings();
					initDataBindings1();
				}
				
				
			}
		});
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Manage Clinics", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblCenter = new JLabel("Medical center name :");
		lblCenter.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCenter.setBounds(25, 151, 158, 16);
		panel_1.add(lblCenter);
		
		JLabel lblResponsibleName = new JLabel("Responsible name:");
		lblResponsibleName.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblResponsibleName.setBounds(25, 180, 158, 16);
		panel_1.add(lblResponsibleName);
		
		JLabel lblSpeciality_1 = new JLabel("Speciality :");
		lblSpeciality_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSpeciality_1.setBounds(25, 215, 158, 16);
		panel_1.add(lblSpeciality_1);
		
		JLabel lblAddress_1 = new JLabel("Address :");
		lblAddress_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblAddress_1.setBounds(25, 258, 158, 16);
		panel_1.add(lblAddress_1);
		
		CenterADR = new JTextField();
		CenterADR.setFont(new Font("Tahoma", Font.BOLD, 13));
		CenterADR.setColumns(10);
		CenterADR.setBounds(216, 255, 116, 22);
		panel_1.add(CenterADR);
		
		CenterSpec = new JTextField();
		CenterSpec.setFont(new Font("Tahoma", Font.BOLD, 13));
		CenterSpec.setColumns(10);
		CenterSpec.setBounds(216, 215, 116, 22);
		panel_1.add(CenterSpec);
		
		CenterResp = new JTextField();
		CenterResp.setFont(new Font("Tahoma", Font.BOLD, 13));
		CenterResp.setColumns(10);
		CenterResp.setBounds(216, 180, 116, 22);
		panel_1.add(CenterResp);
		
		centerName = new JTextField();
		centerName.setFont(new Font("Tahoma", Font.BOLD, 13));
		centerName.setColumns(10);
		centerName.setBounds(216, 151, 116, 22);
		panel_1.add(centerName);
		
		JButton btnAddMedicalCenter = new JButton("Add medical center ");
		btnAddMedicalCenter.setIcon(new ImageIcon("C:\\images\\32x32\\accept.png"));
		btnAddMedicalCenter.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnAddMedicalCenter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MedicalCenters hotel1=new MedicalCenters();
				hotel1.setAdress_Med_center(CenterADR.getText());
				hotel1.setName_Med_center(centerName.getText());
				
				hotel1.setResp_Med_center(CenterResp.getText());
				hotel1.setConventionne("YES");
			hotel1.setSpeciality_Med_center(CenterSpec.getText());
				
				
				if(GestionMedicalCentersDelegate.doaddMedicalCenters(hotel1)){
					JOptionPane.showMessageDialog(null,"ajout reussie");
					centerName.setText("");
					CenterADR.setText("");
					CenterSpec.setText("");
					CenterResp.setText("");
					
					hotels1=GestionMedicalCentersDelegate.dofindAllMedicalCenters();
					initDataBindings1();
					initDataBindings();
				}
			}
		});
		btnAddMedicalCenter.setBounds(25, 302, 307, 42);
		panel_1.add(btnAddMedicalCenter);
		
		JButton button_1 = new JButton("Delete");
		button_1.setIcon(new ImageIcon("C:\\images\\32x32\\delete.png"));
		button_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				hotel1=hotels1.get(table_1.getSelectedRow());
				if(GestionMedicalCentersDelegate.dodeleteMedicalCenters(hotel1)){
					JOptionPane.showMessageDialog(null, "delete reussie...");
					centerName.setText("");
					CenterADR.setText("");
					CenterSpec.setText("");
					CenterResp.setText("");
					hotels1=GestionMedicalCentersDelegate.dofindAllMedicalCenters();
					initDataBindings1();
					initDataBindings();
					
				}
				else{}
			}
			
		
		});
		button_1.setBounds(882, 122, 171, 45);
		panel_1.add(button_1);
		
		JButton btnUpdateMedicalCenter = new JButton("Update ");
		btnUpdateMedicalCenter.setIcon(new ImageIcon("C:\\images\\32x32\\up.png"));
		btnUpdateMedicalCenter.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnUpdateMedicalCenter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hotel1.setAdress_Med_center(CenterADR.getText());
				hotel1.setName_Med_center(centerName.getText());
				
				hotel1.setResp_Med_center(CenterResp.getText());
			hotel1.setSpeciality_Med_center(CenterSpec.getText());
				if(GestionMedicalCentersDelegate.doupdateMedicalCenters(hotel1)){
					JOptionPane.showMessageDialog(null, "update reussie...");
					centerName.setText("");
					CenterADR.setText("");
					CenterSpec.setText("");
					CenterResp.setText("");
					hotels1=GestionMedicalCentersDelegate.dofindAllMedicalCenters();
					initDataBindings1();
					initDataBindings();
				}
				else{}
			}
		});
		btnUpdateMedicalCenter.setBounds(882, 67, 171, 42);
		panel_1.add(btnUpdateMedicalCenter);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(546, 13, -169, 22);
		panel_1.add(scrollPane_1);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(403, 40, 452, 304);
		panel_1.add(scrollPane_2);
		
		table_1 = new JTable();
		scrollPane_2.setViewportView(table_1);
		table_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JLabel lblAddNewMedical = new JLabel("ADD NEW MEDICAL CENTER");
		lblAddNewMedical.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAddNewMedical.setBounds(81, 88, 277, 16);
		panel_1.add(lblAddNewMedical);
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				hotel1=hotels1.get(table_1.getSelectedRow());
				centerName.setText(hotel1.getName_Med_center());
				CenterADR.setText(hotel1.getAdress_Med_center());
				CenterSpec.setText(hotel1.getSpeciality_Med_center());
				CenterResp.setText(hotel1.getResp_Med_center());
			}
		});
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\images\\bg f.png"));
		lblNewLabel.setBounds(0, 0, 1357, 907);
		panel_2.add(lblNewLabel);
		contentPane.setLayout(gl_contentPane);
		initDataBindings1();
		initDataBindings();
	}
	
	protected void initDataBindings() {
		JTableBinding<Doctor, List<Doctor>, JTable> jTableBinding = SwingBindings.createJTableBinding(UpdateStrategy.READ, hotels, table);
		//
		BeanProperty<Doctor, Integer> hotelBeanProperty = BeanProperty.create("numCinDoc");
		jTableBinding.addColumnBinding(hotelBeanProperty).setColumnName("numCinDoc");
		//
		BeanProperty<Doctor, String> hotelBeanProperty_1 = BeanProperty.create("adressDoc");
		jTableBinding.addColumnBinding(hotelBeanProperty_1).setColumnName("adressDoc");
		//
		BeanProperty<Doctor, String> hotelBeanProperty_2 = BeanProperty.create("clinic");
		jTableBinding.addColumnBinding(hotelBeanProperty_2).setColumnName("clinic");
		//
		BeanProperty<Doctor, String> hotelBeanProperty_3 = BeanProperty.create("emailDoc");
		jTableBinding.addColumnBinding(hotelBeanProperty_3).setColumnName("emailDoc");
		//
		BeanProperty<Doctor, String> hotelBeanProperty_4 = BeanProperty.create("firsNameDoc");
		jTableBinding.addColumnBinding(hotelBeanProperty_4).setColumnName("firsNameDoc");
		//
		BeanProperty<Doctor,Integer> hotelBeanProperty_5 = BeanProperty.create("nbrYearsOfExp");
		jTableBinding.addColumnBinding(hotelBeanProperty_5).setColumnName("nbrYearsOfExp");
		//
		BeanProperty<Doctor,Integer> hotelBeanProperty_6 = BeanProperty.create("specialityDoc");
		jTableBinding.addColumnBinding(hotelBeanProperty_6).setColumnName("specialityDoc");
		//
		jTableBinding.bind();
	}
	protected void initDataBindings1() {
		JTableBinding<MedicalCenters, List<MedicalCenters>, JTable> jTableBinding = SwingBindings.createJTableBinding(UpdateStrategy.READ, hotels1, table_1);
		//
		BeanProperty<MedicalCenters, Integer> hotelBeanProperty = BeanProperty.create("ID_Med_center");
		jTableBinding.addColumnBinding(hotelBeanProperty).setColumnName("ID_Med_center");
		//
		BeanProperty<MedicalCenters, String> hotelBeanProperty_1 = BeanProperty.create("adress_Med_center");
		jTableBinding.addColumnBinding(hotelBeanProperty_1).setColumnName("adress_Med_center");
		//
		BeanProperty<MedicalCenters, String> hotelBeanProperty_2 = BeanProperty.create("name_Med_center");
		jTableBinding.addColumnBinding(hotelBeanProperty_2).setColumnName("name_Med_center");
		//
		BeanProperty<MedicalCenters, String> hotelBeanProperty_3 = BeanProperty.create("resp_Med_center");
		jTableBinding.addColumnBinding(hotelBeanProperty_3).setColumnName("resp_Med_center");
		//
		BeanProperty<MedicalCenters, String> hotelBeanProperty_4 = BeanProperty.create("speciality_Med_center");
		jTableBinding.addColumnBinding(hotelBeanProperty_4).setColumnName("speciality_Med_center");
		
		jTableBinding.bind();
	}
}
