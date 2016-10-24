package ttma.client.GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import ttma.Entities.FinanceManagement;
import ttma.Entities.MedicalCenters;
import ttma.Entities.Operation;
import ttma.client.delegate.GestionFinanceDelegate;
import ttma.client.delegate.GestionMedicalCentersDelegate;
import ttma.client.delegate.GestionOperationsDelegate;

import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.BeanProperty;
import org.jfree.ui.RefineryUtilities;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JSpinner;
import javax.transaction.Transactional.TxType;
import javax.swing.ImageIcon;

import java.awt.Font;

import javax.swing.JScrollPane;

public  class IFinanceManagement extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField titleinc;
	private JTextField INCEV;
	private JTextField INCCLI;
	private JTextField INCTR;
	private JTextField INCOHOT;
	private JTable table_1;
	private JTable table_2;
	private JTextField titreexp;
	private JTable table_3;
	List <FinanceManagement> finances;
	FinanceManagement financecl;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IFinanceManagement frame = new IFinanceManagement();
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
	
	public IFinanceManagement() {
		
		
		finances=new ArrayList<FinanceManagement>();
		finances=GestionFinanceDelegate.dofindAllFinaces();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1376,958);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setFont(new Font("Tahoma", Font.BOLD, 13));
		tabbedPane.setBounds(262, 317, 982, 464);
		panel.add(tabbedPane);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("EXPENSES", null, panel_2, null);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(420, 62, 482, 182);
		panel_2.add(scrollPane);
		
		table_3 = new JTable();
		scrollPane.setViewportView(table_3);
		table_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		titreexp = new JTextField();
		titreexp.setFont(new Font("Tahoma", Font.BOLD, 13));
		titreexp.setColumns(10);
		titreexp.setBounds(204, 59, 167, 22);
		panel_2.add(titreexp);
		
		JSpinner evSP = new JSpinner();
		evSP.setFont(new Font("Tahoma", Font.BOLD, 13));
		evSP.setBounds(206, 131, 165, 22);
		panel_2.add(evSP);
		JComboBox ann = new JComboBox();
		ann.setFont(new Font("Tahoma", Font.BOLD, 13));
		ann.setModel(new DefaultComboBoxModel(new String[] {"", "2015", "2014", "2013", "2012", "2011", "2010", "2009", "2008", "2007"}));
		ann.setBounds(292, 94, 79, 22);
		panel_2.add(ann);
		
		JComboBox mois = new JComboBox();
		mois.setFont(new Font("Tahoma", Font.BOLD, 13));
		mois.setModel(new DefaultComboBoxModel(new String[] {"", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"}));
		mois.setBounds(201, 94, 79, 22);
		panel_2.add(mois);
		JSpinner cl = new JSpinner();
		cl.setFont(new Font("Tahoma", Font.BOLD, 13));
		cl.setBounds(206, 167, 165, 22);
		panel_2.add(cl);
		
		JSpinner tr = new JSpinner();
		tr.setFont(new Font("Tahoma", Font.BOLD, 13));
		tr.setBounds(204, 210, 167, 22);
		panel_2.add(tr);
		
		JSpinner hot = new JSpinner();
		hot.setFont(new Font("Tahoma", Font.BOLD, 13));
		hot.setBounds(206, 252, 165, 22);
		panel_2.add(hot);
		
		JSpinner pub = new JSpinner();
		pub.setFont(new Font("Tahoma", Font.BOLD, 13));
		pub.setBounds(206, 287, 165, 22);
		panel_2.add(pub);
		
		JSpinner sal = new JSpinner();
		sal.setFont(new Font("Tahoma", Font.BOLD, 13));
		sal.setBounds(206, 334, 165, 22);
		panel_2.add(sal);
		
		JButton button = new JButton("Create Bilan");
		button.setFont(new Font("Tahoma", Font.BOLD, 13));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FinanceManagement hotel1=new FinanceManagement();
				
				Integer ev = (Integer)evSP.getValue();
			
				Integer h = (Integer)hot.getValue();
				Integer p = (Integer)pub.getValue();
				Integer sa = (Integer)sal.getValue();
				Integer c = (Integer)cl.getValue();
				Integer t = (Integer)tr.getValue();
				hotel1.setAnnee(ann.getSelectedItem().toString());
				hotel1.setClinics(c);
			
				hotel1.setEvents(ev);
				hotel1.setPublicity(p);
				hotel1.setHotels(h);
				//hotel1.set
				hotel1.setTitre(titreexp.getText());
				hotel1.setTypeBilan("EXPENSES");
				hotel1.setMois(mois.getSelectedItem().toString());
				hotel1.setSalaries(sa);
				hotel1.setTransports_compagnies(t);
				
			
				
				
				if(GestionFinanceDelegate.doaddFinance(hotel1)){
					JOptionPane.showMessageDialog(null,"BILAN ADDED");
					
					finances=GestionFinanceDelegate.dofindAllFinaces();
				
					initDataBindings();
				}
			}
		});
		
		
		
		button.setBounds(516, 333, 231, 25);
		panel_2.add(button);
		
		JLabel label_5 = new JLabel("Hotels depenses :");
		label_5.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_5.setBounds(48, 253, 104, 16);
		panel_2.add(label_5);
		
		JLabel lblTransportCompagnies = new JLabel("Transport compagnies :");
		lblTransportCompagnies.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTransportCompagnies.setBounds(48, 211, 156, 16);
		panel_2.add(lblTransportCompagnies);
		
		JLabel label_7 = new JLabel("Clinics depenses :");
		label_7.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_7.setBounds(48, 168, 131, 19);
		panel_2.add(label_7);
		
		JLabel label_8 = new JLabel("Events depenses :");
		label_8.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_8.setBounds(48, 132, 156, 16);
		panel_2.add(label_8);
		
		JLabel label_9 = new JLabel("Date");
		label_9.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_9.setBounds(48, 97, 56, 16);
		panel_2.add(label_9);
		
		JLabel label_10 = new JLabel("Bilan Title");
		label_10.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_10.setBounds(48, 62, 88, 16);
		panel_2.add(label_10);
		
		JButton button_1 = new JButton("Delete");
		button_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		button_1.setBounds(506, 279, 104, 25);
		panel_2.add(button_1);
		
		JButton button_2 = new JButton("update");
		button_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		button_2.setBounds(646, 279, 97, 25);
		panel_2.add(button_2);
		
		JLabel label_11 = new JLabel("Publicity depenses :");
		label_11.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_11.setBounds(48, 288, 131, 16);
		panel_2.add(label_11);
		
		JLabel label_12 = new JLabel("Salaries :");
		label_12.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_12.setBounds(48, 320, 131, 16);
		panel_2.add(label_12);
		
		JButton btnNewButton_5 = new JButton("Export Report");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String browse= titreexp.getText();
				//String browse1= ds.getText();
		        Document doc = new Document();
		         try {
		                PdfWriter writer=PdfWriter.getInstance(doc,new FileOutputStream(browse+".pdf"));
		            } catch (FileNotFoundException ex) {
		              // Logger.getLogger(ListStopover.class.getName()).log(Level.SEVERE, null, ex);
		            } catch (DocumentException ex) {
		          //  Logger.getLogger(ListStopover.class.getName()).log(Level.SEVERE, null, ex);
		        }
		        
		        
		        // String text = @"The result can be seen below, which shows that ";
		        String i=(String) table.getValueAt(table.getSelectedRow(),0).toString();
		        String j=(String) table.getValueAt(table.getSelectedRow(),1).toString();
		        String d=(String) table.getValueAt(table.getSelectedRow(),2).toString();
		        String f=(String) table.getValueAt(table.getSelectedRow(),3).toString();
		        try{
		            doc.open();
		           
		            doc.add(new Paragraph("Name :\t"+ table.getValueAt(table.getSelectedRow(),0).toString()));
		            doc.add(new Paragraph("Surname :\t"+ table.getValueAt(table.getSelectedRow(),1).toString()));
		            doc.add(new Paragraph("Cin :\t"+ table.getValueAt(table.getSelectedRow(),2).toString()));
		            doc.add(new Paragraph("Function :\t"+ table.getValueAt(table.getSelectedRow(),3).toString()));
		       
		            doc.close();
		            JOptionPane.showMessageDialog(null, "exported");
		        }
		        
		        catch(Exception e1){
		            
		            JOptionPane.showMessageDialog(null, e1);
		            
		        }
				
			}
		});
		btnNewButton_5.setBounds(516, 371, 183, 25);
		panel_2.add(btnNewButton_5);
		
		
	
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("INCOME", null, panel_1, null);
		panel_1.setLayout(null);
		
		titleinc = new JTextField();
		titleinc.setBounds(197, 35, 140, 22);
		panel_1.add(titleinc);
		titleinc.setColumns(10);
		
		INCEV = new JTextField();
		INCEV.setColumns(10);
		INCEV.setBounds(197, 105, 140, 22);
		panel_1.add(INCEV);
		
		INCCLI = new JTextField();
		INCCLI.setColumns(10);
		INCCLI.setBounds(197, 144, 140, 22);
		panel_1.add(INCCLI);
		
		INCTR = new JTextField();
		INCTR.setColumns(10);
		INCTR.setBounds(197, 184, 140, 22);
		panel_1.add(INCTR);
		
		JLabel lblBilanTitle = new JLabel("Bilan Title");
		lblBilanTitle.setBounds(29, 38, 88, 16);
		panel_1.add(lblBilanTitle);
		
		JLabel label = new JLabel("Date");
		label.setBounds(29, 73, 56, 16);
		panel_1.add(label);
		
		JLabel label_1 = new JLabel("Events income :");
		label_1.setBounds(29, 108, 104, 16);
		panel_1.add(label_1);
		
		JLabel label_2 = new JLabel("Clinics income :");
		label_2.setBounds(29, 144, 104, 16);
		panel_1.add(label_2);
		
		JLabel label_4 = new JLabel("Transport compagnies income :");
		label_4.setBounds(29, 187, 131, 16);
		panel_1.add(label_4);
		
		INCOHOT = new JTextField();
		INCOHOT.setColumns(10);
		INCOHOT.setBounds(197, 229, 140, 22);
		panel_1.add(INCOHOT);
		
		JLabel label_3 = new JLabel("Hotels income :");
		label_3.setBounds(29, 229, 104, 16);
		panel_1.add(label_3);
		
		JButton btnNewButton = new JButton("Create Bilan");
		btnNewButton.setBounds(205, 292, 239, 25);
		panel_1.add(btnNewButton);
		
		table_1 = new JTable();
		table_1.setBounds(528, 381, 1, 1);
		panel_1.add(table_1);
		JComboBox sm = new JComboBox();
		sm.setFont(new Font("Tahoma", Font.BOLD, 13));
		sm.setModel(new DefaultComboBoxModel(new String[] {"", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"}));
		sm.setBounds(62, 584, 132, 22);
		panel.add(sm);
		
		JComboBox sy = new JComboBox();
		sy.setFont(new Font("Tahoma", Font.BOLD, 13));
		sy.setModel(new DefaultComboBoxModel(new String[] {"", "2015", "2014", "2013", "2012", "2011", "2010", "2009", "2008", "2007"}));
		sy.setBounds(62, 549, 132, 22);
		panel.add(sy);
		JButton btnNewButton_1 = new JButton("Delete");
		btnNewButton_1.setBounds(528, 292, 104, 25);
		panel_1.add(btnNewButton_1);
		
		JButton btnUpdate = new JButton("update");
		btnUpdate.setBounds(668, 292, 97, 25);
		panel_1.add(btnUpdate);
		
		JComboBox comboBoxMOIS = new JComboBox();
		comboBoxMOIS.setModel(new DefaultComboBoxModel(new String[] {"", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"}));
		comboBoxMOIS.setBounds(197, 70, 70, 22);
		panel_1.add(comboBoxMOIS);
		
		JComboBox comboBoxANNE = new JComboBox();
		comboBoxANNE.setModel(new DefaultComboBoxModel(new String[] {"", "2015", "2014", "2013", "2012", "2011", "2010", "2009", "2008", "2007"}));
		comboBoxANNE.setBounds(279, 70, 58, 22);
		panel_1.add(comboBoxANNE);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(388, 35, 500, 171);
		panel_1.add(scrollPane_1);
		
		table_2 = new JTable();
		scrollPane_1.setViewportView(table_2);
		
		table = new JTable();
		table.setBounds(70, 56, 1, 1);
		panel.add(table);
		
		JButton btnNewButton_2 = new JButton("Statistic");
		btnNewButton_2.setIcon(new ImageIcon("C:\\images\\32x32\\chart.png"));
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_2.addActionListener(new ActionListener() {
			public  void actionPerformed(ActionEvent e) { 
				StatFinance s = new StatFinance("TTMA Finance", "Chart of financial situation of the monthe of ",sm.getSelectedItem().toString(),sy.getSelectedItem().toString());
				 s.setSize( 560 , 367 );    
			      RefineryUtilities.centerFrameOnScreen( s );    
			     s.setVisible( true );
				 
				s.show();
			}
		});
		btnNewButton_2.setBounds(52, 503, 142, 33);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Voip Call");
		btnNewButton_3.setIcon(new ImageIcon("C:\\images\\32x32\\phone.png"));
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_3.addActionListener(new ActionListener() {
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
		btnNewButton_3.setBounds(52, 317, 142, 45);
		panel.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Send email");
		btnNewButton_4.setIcon(new ImageIcon("C:\\images\\32x32\\mail.png"));
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EnvoiMail em=new EnvoiMail();
				em.show();
			}
		});
		btnNewButton_4.setBounds(52, 375, 142, 39);
		panel.add(btnNewButton_4);
		
		JButton btnDisonnect = new JButton("Disonnect");
		btnDisonnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TTMAAuthentification t =new TTMAAuthentification();
				t.setVisible(true);
				
			}
		});
		btnDisonnect.setIcon(new ImageIcon("C:\\images\\32x32\\close.png"));
		btnDisonnect.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnDisonnect.setBounds(52, 438, 142, 39);
		panel.add(btnDisonnect);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\images\\bg f.png"));
		lblNewLabel.setBounds(0, 0, 1370, 900);
		panel.add(lblNewLabel);
		
		
		initDataBindings();
	}
	protected void initDataBindings() {
		JTableBinding<FinanceManagement, List<FinanceManagement>, JTable> jTableBinding = SwingBindings.createJTableBinding(UpdateStrategy.READ, finances, table_3);
		//
		BeanProperty<FinanceManagement, Integer> financeManagementBeanProperty = BeanProperty.create("ID_bilan");
		jTableBinding.addColumnBinding(financeManagementBeanProperty).setColumnName("ID");
		//
		BeanProperty<FinanceManagement, String> financeManagementBeanProperty_1 = BeanProperty.create("titre");
		jTableBinding.addColumnBinding(financeManagementBeanProperty_1).setColumnName("Title");
		//
		BeanProperty<FinanceManagement, String> financeManagementBeanProperty_2 = BeanProperty.create("mois");
		jTableBinding.addColumnBinding(financeManagementBeanProperty_2).setColumnName("Month");
		//
		BeanProperty<FinanceManagement, String> financeManagementBeanProperty_3 = BeanProperty.create("annee");
		jTableBinding.addColumnBinding(financeManagementBeanProperty_3).setColumnName("year");
		//
		jTableBinding.bind();
	}
}
