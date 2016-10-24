package ttma.client.GUI;
import javax.swing.ButtonGroup;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.PrintJob;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.security.cert.PKIXRevocationChecker.Option;
import java.util.Properties;
import java.awt.BorderLayout;
import java.awt.EventQueue;
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

import ttma.Entities.MedicalCenters;
import ttma.Entities.Operation;
import ttma.client.delegate.GestionDoctorDelegate;
import ttma.client.delegate.GestionMedicalCentersDelegate;
import ttma.client.delegate.GestionOperationsDelegate;

import javax.swing.JTable;

import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.beansbinding.ObjectProperty;
import org.jfree.ui.RefineryUtilities;

import antlr.collections.impl.Vector;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextArea;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterJob;

import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import java.awt.Toolkit;

import javax.swing.ImageIcon;

import java.awt.Color;

import javax.swing.border.TitledBorder;

import java.awt.Font;
import java.io.IOException;

import javax.swing.border.MatteBorder;
import javax.swing.JScrollPane;

public class IGestionOffers extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	List <Operation> hotels;
	List <Operation> hotels1;
	Operation hotel;
	private JTable table;
	private JTextField opetypeTxt;
	private JTextField MedCentertxt;
	private JTextField priceText;
	private JTextField DoctorTxt;
	private JTextField Datetext;
	private JTable table_1;
	private JTextField op2;
	private JTextField clinic2;
	private JTextField doc2;
	private JTextField date2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IGestionOffers frame = new IGestionOffers();
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
	public IGestionOffers() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\FOUED BRAHIM\\Desktop\\bg\\finalBg.png"));
		hotels=new ArrayList<Operation>();
		hotels=GestionOperationsDelegate.dofindAllOperation();
		hotels1=new ArrayList<Operation>();
		hotels1=GestionOperationsDelegate.dofindAllOperation();
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1393, 956);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel_2 = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(panel_2, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 1365, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 807, Short.MAX_VALUE)
		);
		panel_2.setLayout(null);
		
		JButton btnCallSomeone = new JButton("Call Someone");
		btnCallSomeone.setIcon(new ImageIcon("C:\\images\\32x32\\phone.png"));
		btnCallSomeone.setFont(new Font("Tahoma", Font.BOLD, 13));
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
		
		JButton btnSendEmail = new JButton("SEND EMAIL");
		btnSendEmail.setIcon(new ImageIcon("C:\\images\\32x32\\mail.png"));
		btnSendEmail.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSendEmail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EnvoiMail em=new EnvoiMail();
				em.show();
			}
		});
		btnSendEmail.setBounds(48, 496, 153, 42);
		panel_2.add(btnSendEmail);
		btnCallSomeone.setBounds(48, 432, 153, 42);
		panel_2.add(btnCallSomeone);
		
		JButton button = new JButton("Disconnect");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
IMedicalResponsible f =new IMedicalResponsible();
				
				f.setVisible(true);
			}
		});
		button.setIcon(new ImageIcon("C:\\images\\32x32\\close.png"));
		button.setFont(new Font("Tahoma", Font.BOLD, 13));
		button.setBounds(48, 359, 152, 48);
		panel_2.add(button);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setForeground(Color.BLACK);
		tabbedPane.setFont(new Font("Tahoma", Font.BOLD, 13));
		tabbedPane.setBounds(235, 277, 1079, 525);
		panel_2.add(tabbedPane);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("Manage Clinic's offers", null, panel_1, null);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(35, 33, 925, 217);
		panel_1.add(scrollPane);
		//
		
		//
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setBackground(new Color(192, 192, 192));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			}
		));
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				hotel=hotels.get(table.getSelectedRow());
				opetypeTxt.setText(hotel.getType_Operation());
				MedCentertxt.setText(hotel.getMedicCenterNAme());
				Datetext.setText(hotel.getDate());
				//priceText.setText(Integer.parseInt(hotel.getPrice_Operation()));
				DoctorTxt.setText(hotel.getDoctorName());
				
			}
		});
		
		opetypeTxt = new JTextField();
		opetypeTxt.setForeground(new Color(0, 0, 255));
		opetypeTxt.setBounds(164, 291, 251, 22);
		panel_1.add(opetypeTxt);
		opetypeTxt.setColumns(10);
		
		MedCentertxt = new JTextField();
		MedCentertxt.setForeground(new Color(0, 0, 255));
		MedCentertxt.setBounds(164, 361, 251, 22);
		panel_1.add(MedCentertxt);
		MedCentertxt.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Modify");
		btnNewButton_1.setIcon(new ImageIcon("C:\\images\\32x32\\up.png"));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_1.setBounds(500, 363, 129, 33);
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Delete");
		btnNewButton_2.setIcon(new ImageIcon("C:\\images\\32x32\\delete.png"));
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_2.setBounds(502, 317, 127, 33);
		panel_1.add(btnNewButton_2);
		
		JLabel label = new JLabel("Operation :");
		label.setFont(new Font("Tahoma", Font.BOLD, 13));
		label.setForeground(Color.BLACK);
		label.setBounds(12, 291, 129, 16);
		panel_1.add(label);
		
		JLabel lab = new JLabel("Medical center :");
		lab.setFont(new Font("Tahoma", Font.BOLD, 13));
		lab.setForeground(Color.BLACK);
		lab.setBounds(12, 361, 129, 16);
		panel_1.add(lab);
		
		JLabel Price = new JLabel("Price :");
		Price.setFont(new Font("Tahoma", Font.BOLD, 13));
		Price.setForeground(Color.BLACK);
		Price.setBounds(12, 398, 129, 16);
		panel_1.add(Price);
		
		priceText = new JTextField();
		priceText.setForeground(new Color(0, 0, 255));
		priceText.setColumns(10);
		priceText.setBounds(164, 396, 251, 22);
		panel_1.add(priceText);
		
		DoctorTxt = new JTextField();
		DoctorTxt.setForeground(new Color(0, 0, 255));
		DoctorTxt.setBounds(164, 326, 251, 22);
		panel_1.add(DoctorTxt);
		DoctorTxt.setColumns(10);
		
		JLabel label_1 = new JLabel("Doctor :");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_1.setForeground(Color.BLACK);
		label_1.setBounds(12, 326, 129, 16);
		panel_1.add(label_1);
		
		Datetext = new JTextField();
		Datetext.setForeground(new Color(0, 0, 255));
		Datetext.setColumns(10);
		Datetext.setBounds(164, 430, 251, 22);
		panel_1.add(Datetext);
		
		JLabel label_2 = new JLabel("Date :");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_2.setForeground(Color.BLACK);
		label_2.setBounds(12, 432, 129, 16);
		panel_1.add(label_2);
		
		JButton btnImprimer = new JButton("Print");
		btnImprimer.setIcon(new ImageIcon("C:\\images\\32x32\\print.png"));
		btnImprimer.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnImprimer.setBounds(500, 409, 129, 43);
		panel_1.add(btnImprimer);
		btnImprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				  PrinterJob job = PrinterJob.getPrinterJob();
				     
			        PageFormat format = job.defaultPage();
			        format.setOrientation(PageFormat.LANDSCAPE);
			  
			     //   job.setPrintable(this, format);
			        //job.setPrintable(format);
			        try{
			            if(job.printDialog()) job.print();
			        }
			        catch(Exception a){a.printStackTrace();}
				
				
				
			}
		});
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("Create Promotion", null, panel, null);
		panel.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(48, 105, 930, 233);
		panel.add(scrollPane_1);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		table_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		table_1.setForeground(new Color(0, 0, 0));
		table_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		table_1.setBackground(new Color(255, 255, 255));
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				hotel=hotels.get(table_1.getSelectedRow());
				op2.setText(hotel.getType_Operation());
				clinic2.setText(hotel.getMedicCenterNAme());
				date2.setText(hotel.getDate());
				//priceText.setText(Integer.parseInt(hotel.getPrice_Operation()));
				doc2.setText(hotel.getDoctorName());
				
			}
		});
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 13));
		comboBox.setForeground(new Color(0, 0, 0));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "Face Surgery", "breast Surgery", "Surgery teeth", "Surgery plastic", "intimate Surgery", "gastric Band"}));
		comboBox.setBounds(258, 34, 159, 22);
		panel.add(comboBox);
		
		JLabel lblOperation = new JLabel("Operation");
		lblOperation.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblOperation.setForeground(new Color(0, 0, 0));
		lblOperation.setBounds(133, 37, 84, 16);
		panel.add(lblOperation);
		
		JComboBox clinic = new JComboBox();
		clinic.setFont(new Font("Tahoma", Font.BOLD, 13));
		clinic.setForeground(new Color(0, 0, 255));
		clinic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<MedicalCenters> l=GestionMedicalCentersDelegate.dofindAllMedicalCentersbyName();
				 for(Iterator it=l.iterator(); it.hasNext();)
				 {clinic.addItem(it.next());}
			}
		});
		clinic.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				List<MedicalCenters> l=GestionMedicalCentersDelegate.dofindAllMedicalCentersbyName();
				 for(Iterator it=l.iterator(); it.hasNext();)
				 {clinic.addItem(it.next());}
			}
		});
		clinic.setBounds(540, 34, 78, 22);
		panel.add(clinic);
		
		JLabel lblClinic = new JLabel("clinic");
		lblClinic.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblClinic.setForeground(new Color(0, 0, 0));
		lblClinic.setBounds(467, 37, 56, 16);
		panel.add(lblClinic);
		
		JButton btnSearch = new JButton("Search by operation");
		btnSearch.setIcon(new ImageIcon("C:\\images\\32x32\\zoom.png"));
		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSearch.setForeground(new Color(0, 0, 0));
		btnSearch.addActionListener(new ActionListener() {
			public  void actionPerformed(ActionEvent e) {
			//if ((clinic.getSelectedItem()=="") && (minmax.getSelectedItem()=="")&& (comboBox.getSelectedItem()!="")) 
			
				//	GestionOperationsDelegate.dofindOperationByNam(comboBox.getSelectedItem().toString());
			hotels1=GestionOperationsDelegate.dofindOperationByNam(comboBox.getSelectedItem().toString());
				//	hotels1=GestionOperationsDelegate.dofindOperationByNam("Face Surgery");

				initDataBindings1();
			
			
			}
		});
		btnSearch.setBounds(765, 18, 213, 36);
		panel.add(btnSearch);
		
		op2 = new JTextField();
		op2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		op2.setForeground(new Color(0, 0, 0));
		op2.setEnabled(false);
		op2.setColumns(10);
		op2.setBounds(200, 351, 251, 22);
		panel.add(op2);
		
		JLabel label_3 = new JLabel("Operation :");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_3.setForeground(new Color(0, 0, 0));
		label_3.setBounds(48, 351, 129, 16);
		panel.add(label_3);
		
		JLabel label_4 = new JLabel("Doctor :");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_4.setForeground(new Color(0, 0, 0));
		label_4.setBounds(48, 386, 129, 16);
		panel.add(label_4);
		
		JLabel label_5 = new JLabel("Medical center :");
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_5.setForeground(new Color(0, 0, 0));
		label_5.setBounds(48, 421, 129, 16);
		panel.add(label_5);
		
		clinic2 = new JTextField();
		clinic2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		clinic2.setForeground(new Color(0, 0, 0));
		clinic2.setEnabled(false);
		clinic2.setColumns(10);
		clinic2.setBounds(200, 421, 251, 22);
		panel.add(clinic2);
		
		doc2 = new JTextField();
		doc2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		doc2.setForeground(new Color(0, 0, 0));
		doc2.setEnabled(false);
		doc2.setColumns(10);
		doc2.setBounds(200, 386, 251, 22);
		panel.add(doc2);
		
		JLabel label_7 = new JLabel("Date :");
		label_7.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_7.setForeground(new Color(0, 0, 0));
		label_7.setBounds(48, 452, 129, 16);
		panel.add(label_7);
		
		date2 = new JTextField();
		date2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		date2.setForeground(new Color(0, 0, 0));
		date2.setEnabled(false);
		date2.setColumns(10);
		date2.setBounds(200, 450, 251, 22);
		panel.add(date2);
		
		JButton btnNewButton = new JButton("Publish Offer");
		btnNewButton.setIcon(new ImageIcon("C:\\images\\32x32\\accept.png"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				hotel.setPublier("YES");
				//hotel.setPrice_Operation(Integer.parseInt(priceText.getText()));
				//hotel.setType_Operation(opetypeTxt.getText());
				if(GestionOperationsDelegate.doupdateOperation(hotel)){
					JOptionPane.showMessageDialog(null, "NEW PROMOTION IS CREATED");
					
					hotels=GestionOperationsDelegate.dofindAllOperation();
					initDataBindings1();
				}
				else{}
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBounds(666, 417, 217, 41);
		panel.add(btnNewButton);
		
		JButton btnSearchByClinic = new JButton("Search by clinic");
		btnSearchByClinic.setIcon(new ImageIcon("C:\\images\\32x32\\zoom.png"));
		btnSearchByClinic.setForeground(Color.BLACK);
		btnSearchByClinic.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSearchByClinic.setBounds(765, 57, 213, 41);
		panel.add(btnSearchByClinic);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hotel=hotels.get(table.getSelectedRow());
				if(GestionOperationsDelegate.dodeleteOperation(hotel)){
					JOptionPane.showMessageDialog(null, "delete reussie...");
					Datetext.setText("");
					DoctorTxt.setText("");
					MedCentertxt.setText("");
					opetypeTxt.setText("");
					priceText.setText("");
					hotels=GestionOperationsDelegate.dofindAllOperation();
					initDataBindings();
				}
				else{}
			}
		});
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				hotel.setDate(Datetext.getText());
				hotel.setDoctorName(DoctorTxt.getText());
				hotel.setMedicCenterNAme(MedCentertxt.getText());
				//hotel.setPrice_Operation(Integer.parseInt(priceText.getText()));
				hotel.setType_Operation(opetypeTxt.getText());
				if(GestionOperationsDelegate.doupdateOperation(hotel)){
					JOptionPane.showMessageDialog(null, "update reussie...");
					Datetext.setText("");
					DoctorTxt.setText("");
					MedCentertxt.setText("");
					opetypeTxt.setText("");
					priceText.setText("");
					hotels=GestionOperationsDelegate.dofindAllOperation();
					initDataBindings();
				}
				else{}
			}
		});
		
		JButton btnAfficherStatOperation = new JButton("Statistics");
		btnAfficherStatOperation.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnAfficherStatOperation.setIcon(new ImageIcon("C:\\images\\32x32\\chart.png"));
		btnAfficherStatOperation.setBounds(48, 289, 152, 57);
		panel_2.add(btnAfficherStatOperation);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\images\\bg f.png"));
		lblNewLabel.setBounds(0, 0, 1353, 906);
		panel_2.add(lblNewLabel);
		btnAfficherStatOperation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//StatOperations Stat=new StatOperations("Statistique des operations reserv�");
				//Stat.show();
				StatOperations dem = new StatOperations("Statistique des operations reserv�" );  
			      dem.setSize( 560 , 367 );    
			      RefineryUtilities.centerFrameOnScreen( dem );    
			      dem.setVisible( true ); 
				
			}
		});
		contentPane.setLayout(gl_contentPane);
		initDataBindings();
	}
	protected void initDataBindings() {
		JTableBinding<Operation, List<Operation>, JTable> jTableBinding = SwingBindings.createJTableBinding(UpdateStrategy.READ, hotels, table);
		//
		BeanProperty<Operation, Integer> hotelBeanProperty = BeanProperty.create("ID_offre");
		jTableBinding.addColumnBinding(hotelBeanProperty).setColumnName("ID_offre");
		//
		BeanProperty<Operation, String> hotelBeanProperty_1 = BeanProperty.create("type_Operation");
		jTableBinding.addColumnBinding(hotelBeanProperty_1).setColumnName("type_Operation");
		//
		BeanProperty<Operation, String> hotelBeanProperty_2 = BeanProperty.create("date");
		jTableBinding.addColumnBinding(hotelBeanProperty_2).setColumnName("date");
		//
		BeanProperty<Operation, String> hotelBeanProperty_3 = BeanProperty.create("doctorName");
		jTableBinding.addColumnBinding(hotelBeanProperty_3).setColumnName("doctorName");
		//
		BeanProperty<Operation, String> hotelBeanProperty_4 = BeanProperty.create("medicCenterNAme");
		jTableBinding.addColumnBinding(hotelBeanProperty_4).setColumnName("medicCenterNAme");
		//
		BeanProperty<Operation, Float> hotelBeanProperty_5 = BeanProperty.create("price_Operation");
		jTableBinding.addColumnBinding(hotelBeanProperty_5).setColumnName("price_Operation");
		//
		jTableBinding.bind();
		//
	
	}
	
	protected void initDataBindings1() {	JTableBinding<Operation, List<Operation>, JTable> jTableBinding_1 = SwingBindings.createJTableBinding(UpdateStrategy.READ, hotels1, table_1);
	//
	BeanProperty<Operation, Integer> operationBeanProperty = BeanProperty.create("ID_offre");
	jTableBinding_1.addColumnBinding(operationBeanProperty).setColumnName("ID");
	//
	BeanProperty<Operation, String> operationBeanProperty_1 = BeanProperty.create("date");
	jTableBinding_1.addColumnBinding(operationBeanProperty_1).setColumnName("Date");
	//
	BeanProperty<Operation, String> operationBeanProperty_2 = BeanProperty.create("doctorName");
	jTableBinding_1.addColumnBinding(operationBeanProperty_2).setColumnName("DoctorName");
	//
	BeanProperty<Operation, String> operationBeanProperty_3 = BeanProperty.create("medicCenterNAme");
	jTableBinding_1.addColumnBinding(operationBeanProperty_3).setColumnName("clinic");
	//
	BeanProperty<Operation, Float> operationBeanProperty_4 = BeanProperty.create("price_Operation");
	jTableBinding_1.addColumnBinding(operationBeanProperty_4).setColumnName("Price");
	//
	BeanProperty<Operation, String> operationBeanProperty_5 = BeanProperty.create("publier");
	jTableBinding_1.addColumnBinding(operationBeanProperty_5).setColumnName("Published");
	//
	BeanProperty<Operation, String> operationBeanProperty_6 = BeanProperty.create("type_Operation");
	jTableBinding_1.addColumnBinding(operationBeanProperty_6).setColumnName("Operation");
	//
	jTableBinding_1.bind();}
	 public int print(Graphics g, PageFormat format, int pagenum) {
         
	       if (pagenum > 0){
	           return Printable.NO_SUCH_PAGE;
	       }
	        
	       g.translate((int)format.getImageableX(), (int)format.getImageableY());
	               
	       float pageWidth = (float)format.getImageableWidth();
	       float pageHeight = (float)format.getImageableHeight();
	        
	       float imageHeight = (float)this.getHeight();
	       float imageWidth = (float)this.getWidth();
	        
	       float scaleFactor = Math.min((float)pageWidth/(float)imageWidth, (float)pageHeight/(float)imageHeight);
	  
	       int scaledWidth = (int)(((float)imageWidth)*scaleFactor);
	        
	       int scaledHeight = (int)(((float)imageHeight)*scaleFactor);  
	        
	       BufferedImage canvas = new BufferedImage( this.getWidth(),  this.getHeight(), BufferedImage.TYPE_INT_RGB);
	       Graphics2D gg = canvas.createGraphics();
	       this.paint( gg );  
	       Image img = canvas ;
	  
	       g.drawImage(img, 0, 0, scaledWidth, scaledHeight, null );
	  
	       return Printable.PAGE_EXISTS;
	        
	    }
}
