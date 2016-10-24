package ttma.client.GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;

import ttma.Entities.DemandeConsultationEnLigne;
import ttma.Entities.DoctorDisponibilities;
import ttma.Entities.MedicalCenters;
import ttma.Entities.OnlineConsultations;
import ttma.Entities.Operation;
import ttma.client.delegate.GestionDemandeConsDelegate;
import ttma.client.delegate.GestionDoctorDISPDelegate;
import ttma.client.delegate.GestionMedicalCentersDelegate;
import ttma.client.delegate.GestionOnlineConsDelegate;
import ttma.client.delegate.GestionOperationsDelegate;

import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.BeanProperty;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Font;

import javax.swing.JScrollPane;

public class IManageAppointement extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTable table_1;
	private JTextField pName;
	private JTextField dname;
	private JTextField dpatient;
	private JTextField ddoc;
	List <DemandeConsultationEnLigne> demandes;
	DemandeConsultationEnLigne demandeCons;
	
	List <DoctorDisponibilities> dispo;
	DoctorDisponibilities dispos;

	List <OnlineConsultations> online;
	OnlineConsultations onlines;
	private JTextField docname;
	private JTable table_2;
	private JButton btnCallSomeone;
	private JButton btnSendEmail;
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1;
	private JScrollPane scrollPane_2;
	private JScrollPane scrollPane_3;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IManageAppointement frame = new IManageAppointement();
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
	public IManageAppointement() {
		setResizable(false);
		
	demandes=new ArrayList<DemandeConsultationEnLigne>();
	demandes=GestionDemandeConsDelegate.dofindAlldemandes();
	
	dispo=new ArrayList<DoctorDisponibilities>();
	dispo=GestionDoctorDISPDelegate.dofindAllDoctorsdisp();
	
	online=new ArrayList<OnlineConsultations>();
	online=GestionOnlineConsDelegate.dofindAllCons();
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1374, 945);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		JButton btnNewButton = new JButton("search");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispo=GestionDoctorDISPDelegate.dofindAllDoctorsdispbydate(docname.getText());
				
				initDataBindings();
			
			}
		});
		
		btnSendEmail = new JButton("SEND EMAIL");
		btnSendEmail.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSendEmail.setIcon(new ImageIcon("C:\\images\\32x32\\mail.png"));
		btnSendEmail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EnvoiMail em=new EnvoiMail();
				em.show();
			}
		});
		
		JButton btnDisconnect = new JButton("home");
		btnDisconnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
IMedicalResponsible f =new IMedicalResponsible();
				
				f.setVisible(true);
			}
		});
		btnDisconnect.setIcon(new ImageIcon("C:\\images\\32x32\\close.png"));
		btnDisconnect.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnDisconnect.setBounds(56, 403, 158, 50);
		panel.add(btnDisconnect);
		
		JLabel lblNewLabel_2 = new JLabel("Requests Confirmation");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBounds(993, 535, 175, 16);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel("Patient's Requests for consultations");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(523, 237, 259, 16);
		panel.add(lblNewLabel_1);
		
		scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(862, 267, 375, 242);
		panel.add(scrollPane_3);
		
		table_1 = new JTable();
		scrollPane_3.setViewportView(table_1);
		table_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		table_1.setBorder(new LineBorder(SystemColor.textHighlight));
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispos=dispo.get(table_1.getSelectedRow());
				
				ddoc.setText(dispos.getDate_disp());
			}
		});
		
		scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(463, 267, 362, 242);
		panel.add(scrollPane_2);
		
		table = new JTable();
		scrollPane_2.setViewportView(table);
		table.setFont(new Font("Tahoma", Font.BOLD, 13));
		table.setBorder(new LineBorder(SystemColor.textHighlight));
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				demandeCons=demandes.get(table.getSelectedRow());
				pName.setText(demandeCons.getPatient_Name());
				dpatient.setText(demandeCons.getDateAppointement());
				dname.setText(demandeCons.getDoctor_name());
				docname.setText(demandeCons.getDoctor_name());

				
			
			}
		});
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(862, 564, 375, 205);
		panel.add(scrollPane);
		
		table_2 = new JTable();
		scrollPane.setViewportView(table_2);
		table_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		table_2.setBorder(new LineBorder(SystemColor.textHighlight));
		btnSendEmail.setBounds(56, 267, 158, 41);
		panel.add(btnSendEmail);
		btnNewButton.setBounds(1149, 233, 88, 25);
		panel.add(btnNewButton);
		
		JLabel lblDate = new JLabel("Doctor");
		lblDate.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDate.setBounds(873, 237, 56, 16);
		panel.add(lblDate);
		
		pName = new JTextField();
		pName.setFont(new Font("Tahoma", Font.BOLD, 13));
		pName.setBounds(647, 564, 158, 22);
		panel.add(pName);
		pName.setColumns(10);
		
		dname = new JTextField();
		dname.setFont(new Font("Tahoma", Font.BOLD, 13));
		dname.setColumns(10);
		dname.setBounds(647, 599, 158, 22);
		panel.add(dname);
		
		dpatient = new JTextField();
		dpatient.setFont(new Font("Tahoma", Font.BOLD, 13));
		dpatient.setColumns(10);
		dpatient.setBounds(647, 634, 158, 22);
		panel.add(dpatient);
		
		JLabel lblPatientName = new JLabel("Patient name");
		lblPatientName.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPatientName.setBounds(463, 564, 107, 16);
		panel.add(lblPatientName);
		
		JLabel label = new JLabel("Doctor name");
		label.setFont(new Font("Tahoma", Font.BOLD, 13));
		label.setBounds(463, 599, 107, 16);
		panel.add(label);
		
		JLabel label_1 = new JLabel("Date patient");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_1.setBounds(463, 634, 107, 16);
		panel.add(label_1);
		
		JButton btnConfirmAppointement = new JButton("Confirm Appointement");
		btnConfirmAppointement.setIcon(new ImageIcon("C:\\images\\32x32\\accept.png"));
		btnConfirmAppointement.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnConfirmAppointement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				OnlineConsultations hotel1=new OnlineConsultations();
				hotel1.setDoctorNAmeapp(dname.getText());
				hotel1.setDateApp(ddoc.getText());
				hotel1.setPatientNAmeApp(pName.getText());
				
		
				
				
				if(GestionOnlineConsDelegate.doaddCons(hotel1)){
					JOptionPane.showMessageDialog(null,"ajout reussie");
					dname.setText("");
					pName.setText("");
					dpatient.setText("");
					ddoc.setText("");
					
					online=GestionOnlineConsDelegate.dofindAllCons();
					
					initDataBindings();
				}
			}
		});
		btnConfirmAppointement.setBounds(525, 728, 214, 41);
		panel.add(btnConfirmAppointement);
		
		ddoc = new JTextField();
		ddoc.setFont(new Font("Tahoma", Font.BOLD, 13));
		ddoc.setColumns(10);
		ddoc.setBounds(647, 669, 158, 22);
		panel.add(ddoc);
		
		JLabel label_2 = new JLabel("Date doctor");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_2.setBounds(463, 669, 107, 16);
		panel.add(label_2);
		
		docname = new JTextField();
		docname.setFont(new Font("Tahoma", Font.BOLD, 13));
		docname.setBounds(948, 234, 158, 22);
		panel.add(docname);
		docname.setColumns(10);
		
		btnCallSomeone = new JButton("Voip Call");
		btnCallSomeone.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnCallSomeone.setIcon(new ImageIcon("C:\\images\\32x32\\phone.png"));
		btnCallSomeone.addActionListener(new ActionListener() {
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
		btnCallSomeone.setBounds(56, 328, 158, 50);
		panel.add(btnCallSomeone);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\images\\bg f.png"));
		lblNewLabel.setBounds(0, -11, 1349, 911);
		panel.add(lblNewLabel);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(352, 857, 2, 2);
		panel.add(scrollPane_1);
		
		
		initDataBindings();
	}
	protected void initDataBindings() {
		JTableBinding<DemandeConsultationEnLigne, List<DemandeConsultationEnLigne>, JTable> jTableBinding = SwingBindings.createJTableBinding(UpdateStrategy.READ, demandes, table);
		//
		BeanProperty<DemandeConsultationEnLigne, Integer> demandeConsultationEnLigneBeanProperty = BeanProperty.create("ID");
		jTableBinding.addColumnBinding(demandeConsultationEnLigneBeanProperty).setColumnName("ID");
		//
		BeanProperty<DemandeConsultationEnLigne, String> demandeConsultationEnLigneBeanProperty_1 = BeanProperty.create("doctor_name");
		jTableBinding.addColumnBinding(demandeConsultationEnLigneBeanProperty_1).setColumnName("DoctorNAme");
		//
		BeanProperty<DemandeConsultationEnLigne, String> demandeConsultationEnLigneBeanProperty_2 = BeanProperty.create("patient_Name");
		jTableBinding.addColumnBinding(demandeConsultationEnLigneBeanProperty_2).setColumnName("PatientName");
		//
		BeanProperty<DemandeConsultationEnLigne, String> demandeConsultationEnLigneBeanProperty_3 = BeanProperty.create("dateAppointement");
		jTableBinding.addColumnBinding(demandeConsultationEnLigneBeanProperty_3).setColumnName("Date  APP");
		//
		jTableBinding.bind();
		//
		JTableBinding<DoctorDisponibilities, List<DoctorDisponibilities>, JTable> jTableBinding_1 = SwingBindings.createJTableBinding(UpdateStrategy.READ, dispo, table_1);
		//
		BeanProperty<DoctorDisponibilities, Integer> doctorDisponibilitiesBeanProperty = BeanProperty.create("ID_disp");
		jTableBinding_1.addColumnBinding(doctorDisponibilitiesBeanProperty).setColumnName("ID");
		//
		BeanProperty<DoctorDisponibilities, String> doctorDisponibilitiesBeanProperty_1 = BeanProperty.create("doctor_name");
		jTableBinding_1.addColumnBinding(doctorDisponibilitiesBeanProperty_1).setColumnName("Doctor Name");
		//
		BeanProperty<DoctorDisponibilities, String> doctorDisponibilitiesBeanProperty_2 = BeanProperty.create("date_disp");
		jTableBinding_1.addColumnBinding(doctorDisponibilitiesBeanProperty_2).setColumnName("Date");
		//
		jTableBinding_1.bind();
		//
		JTableBinding<OnlineConsultations, List<OnlineConsultations>, JTable> jTableBinding_2 = SwingBindings.createJTableBinding(UpdateStrategy.READ, online, table_2);
		//
		BeanProperty<OnlineConsultations, Integer> onlineConsultationsBeanProperty = BeanProperty.create("IDappointement");
		jTableBinding_2.addColumnBinding(onlineConsultationsBeanProperty).setColumnName("ID");
		//
		BeanProperty<OnlineConsultations, String> onlineConsultationsBeanProperty_1 = BeanProperty.create("doctorNAmeapp");
		jTableBinding_2.addColumnBinding(onlineConsultationsBeanProperty_1).setColumnName("DoctorName");
		//
		BeanProperty<OnlineConsultations, String> onlineConsultationsBeanProperty_2 = BeanProperty.create("patientNAmeApp");
		jTableBinding_2.addColumnBinding(onlineConsultationsBeanProperty_2).setColumnName("PatientName");
		//
		BeanProperty<OnlineConsultations, String> onlineConsultationsBeanProperty_3 = BeanProperty.create("dateApp");
		jTableBinding_2.addColumnBinding(onlineConsultationsBeanProperty_3).setColumnName("Date");
		//
		jTableBinding_2.bind();
	}
}
