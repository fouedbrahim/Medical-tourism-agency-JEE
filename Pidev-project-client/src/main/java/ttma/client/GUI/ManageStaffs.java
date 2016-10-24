package ttma.client.GUI;
import javax.swing.ButtonGroup;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.Image;
import java.awt.Insets;
import java.awt.PrintJob;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.security.cert.PKIXRevocationChecker.Option;
import java.util.Properties;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTabbedPane;

import ttma.Entities.MedicalCenters;
import ttma.Entities.Operation;
import ttma.Entities.Staff;
import ttma.client.delegate.GestionDoctorDelegate;
import ttma.client.delegate.GestionMedicalCentersDelegate;
import ttma.client.delegate.GestionOperationsDelegate;
import ttma.client.delegate.ManageRHDeleguate;

import javax.swing.JTable;

import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.beansbinding.ObjectProperty;
import org.jfree.ui.RefineryUtilities;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.StringUtils;

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
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.border.MatteBorder;

import java.awt.SystemColor;

import javax.swing.JScrollPane;

public class ManageStaffs extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField nm;
	private JTextField ad;
	private JTextArea ds;
	private JTable table;
	List <Staff> staff;
	Staff staf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageStaffs frame = new ManageStaffs();
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
	public ManageStaffs() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\FOUED BRAHIM\\Desktop\\bg\\finalBg.png"));
		
			staff=new ArrayList<Staff>();
			staff=ManageRHDeleguate.tofindAll();
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1393, 956);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel_2 = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(panel_2, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 1367, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 863, Short.MAX_VALUE)
		);
		panel_2.setLayout(null);
		
		JButton btnHome = new JButton("home");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AgencyResponsible t =new AgencyResponsible();
				t.setVisible(true);
				
			}
		});
		btnHome.setBounds(48, 359, 152, 48);
		panel_2.add(btnHome);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setForeground(Color.BLACK);
		tabbedPane.setFont(new Font("Tahoma", Font.BOLD, 13));
		tabbedPane.setBounds(235, 277, 1079, 525);
		panel_2.add(tabbedPane);
		
		JButton btnNewButton_3 = new JButton("search by operation and clinic");
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_3.setForeground(new Color(0, 0, 0));
	
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.menu);
		tabbedPane.addTab("Manage Staffs", null, panel_1, null);
		panel_1.setLayout(null);
		//panel_1.add(table);
		
		JTextArea ds = new JTextArea();
		ds.setBounds(149, 280, 194, 33);
		panel_1.add(ds);
		
		JLabel lblLogin = new JLabel("Login :");
		lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblLogin.setForeground(new Color(30, 144, 255));
		lblLogin.setBounds(12, 166, 129, 16);
		panel_1.add(lblLogin);
		
		JLabel lab = new JLabel("Name :");
		lab.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lab.setForeground(new Color(30, 144, 255));
		lab.setBounds(12, 304, 129, 16);
		panel_1.add(lab);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEmail.setForeground(new Color(30, 144, 255));
		lblEmail.setBounds(12, 227, 129, 16);
		panel_1.add(lblEmail);
		
		JButton btnImprimer = new JButton("Print");
		btnImprimer.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnImprimer.setIcon(new ImageIcon("C:\\images\\48x48\\print.png"));
		btnImprimer.setBounds(833, 54, 182, 49);
		panel_1.add(btnImprimer);
		
		nm = new JTextField();
		nm.setColumns(10);
		nm.setBounds(149, 160, 194, 33);
		panel_1.add(nm);
		
		ad = new JTextField();
		ad.setColumns(10);
		ad.setBounds(149, 221, 194, 33);
		panel_1.add(ad);
		
		JButton button_1 = new JButton("Export");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String browse= nm.getText();
				String browse1= ds.getText();
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
		            JOptionPane.showMessageDialog(null, "bien export�");
		        }
		        
		        catch(Exception e1){
		            
		            JOptionPane.showMessageDialog(null, e1);
		            
		        }
				
				
				
			}
		});
		
			
		button_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		button_1.setIcon(new ImageIcon("C:\\images\\48x48\\down.png"));
		button_1.setBounds(673, 54, 150, 49);
		panel_1.add(button_1);
		
		JButton button_2 = new JButton("Add");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Staff staf=new Staff();
	               staf.setLogin(nm.getText());
	              staf.setEmail(ad.getText());
					staf.setName(ds.getText());
	               if(ManageRHDeleguate.toaddStaff(staf)){
	            		 try{
	         				JOptionPane.showMessageDialog(null, "Add with success...");
	         	        }
	         	        
	         	        catch(Exception e1){
	         	            
	         	            JOptionPane.showMessageDialog(null, e1);
	         	            
	         	        }
	         				
				
	               }}	
		});
		
		
		button_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		button_2.setIcon(new ImageIcon("C:\\images\\48x48\\add.png"));
		button_2.setBounds(360, 363, 150, 59);
		panel_1.add(button_2);
		
		JButton button_3 = new JButton("Delete");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 Staff staf=staff.get(table.getSelectedRow());
			if(ManageRHDeleguate.todeleteStaff(staf)){
				JOptionPane.showMessageDialog(null, "delete reussie...");
				nm.setText("");
				ds.setText("");
				ad.setText("");
				staff=ManageRHDeleguate.tofindAll();
				initDataBindings();
			}
			else{}
		}
	});
		button_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		button_3.setIcon(new ImageIcon("C:\\images\\48x48\\trash.png"));
		button_3.setBounds(186, 363, 157, 59);
		panel_1.add(button_3);
		
		JButton button_4 = new JButton("Modify");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				  staf.setLogin(nm.getText());
	              staf.setEmail(ad.getText());
				staf.setName(ds.getText());
				if(ManageRHDeleguate.toupdateStaff(staf))
				
				{
					JOptionPane.showMessageDialog(null, "update reussie...");
					nm.setText("");
					ds.setText("");
					ad.setText("");
					staff=ManageRHDeleguate.tofindAll();
					initDataBindings();
				}
				else{}
			}
		});
		
			
		button_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		button_4.setIcon(new ImageIcon("C:\\images\\48x48\\applications.png"));
		button_4.setBounds(26, 365, 150, 57);
		panel_1.add(button_4);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(402, 151, 560, 117);
		panel_1.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setBackground(UIManager.getColor("Tree.textBackground"));
		table.setCellSelectionEnabled(true);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				staf=staff.get(table.getSelectedRow());
				nm.setText(staf.getLogin());
				ad.setText(staf.getEmail());
				ds.setText(staf.getName());
			}
		});
		
		table.setCellSelectionEnabled(true);
		table.setBackground(Color.WHITE);
		
		JButton btnNewButton = new JButton("Send Mail");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EnvoiMail em = new EnvoiMail();
				em.show();
			}
		});
		btnNewButton.setIcon(new ImageIcon("C:\\images\\48x48\\mail.png"));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setBounds(549, 363, 157, 59);
		panel_1.add(btnNewButton);
		GridBagConstraints gbc_table = new GridBagConstraints();
		gbc_table.fill = GridBagConstraints.BOTH;
		gbc_table.insets = new Insets(0, 0, 5, 5);
		gbc_table.gridwidth = 4;
		gbc_table.gridx = 7;
		gbc_table.gridy = 3;
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
		
		JButton btnAfficherStatOperation = new JButton("Statistics");
		btnAfficherStatOperation.setIcon(new ImageIcon("D:\\4 GL A\\SEMESTRE 1\\PIdev\\workspace2\\Pidev-project-client\\src\\main\\java\\IMAGES\\ttma.Images\\png\\48x48\\chart.png"));
		btnAfficherStatOperation.setBounds(48, 289, 152, 57);
		panel_2.add(btnAfficherStatOperation);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\images\\bg f.png"));
		lblNewLabel.setBounds(0, 0, 1353, 906);
		panel_2.add(lblNewLabel);
		btnAfficherStatOperation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				StaffsStats stat = new StaffsStats("Statistique des stafs connect�s " );  
			      stat.setSize( 560 , 367 );    
			      RefineryUtilities.centerFrameOnScreen( stat
			    		  );    
			     stat.setVisible( true ); 
				
			}
		});
		contentPane.setLayout(gl_contentPane);
		initDataBindings();
	}
	
	
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
		protected void initDataBindings() {
			JTableBinding<Staff, List<Staff>, JTable> jTableBinding = SwingBindings.createJTableBinding(UpdateStrategy.READ, staff, table);
			//
			BeanProperty<Staff, String> staffBeanProperty = BeanProperty.create("login");
			jTableBinding.addColumnBinding(staffBeanProperty).setColumnName("Id");
			//
			BeanProperty<Staff, String> staffBeanProperty_1 = BeanProperty.create("login");
			jTableBinding.addColumnBinding(staffBeanProperty_1).setColumnName("Login");
			//
			BeanProperty<Staff, String> staffBeanProperty_2 = BeanProperty.create("mdp");
			jTableBinding.addColumnBinding(staffBeanProperty_2).setColumnName("password");
			//
			BeanProperty<Staff, String> staffBeanProperty_3 = BeanProperty.create("name");
			jTableBinding.addColumnBinding(staffBeanProperty_3).setColumnName("Name");
			//
			BeanProperty<Staff, byte[]> staffBeanProperty_4 = BeanProperty.create("photo");
			jTableBinding.addColumnBinding(staffBeanProperty_4).setColumnName("Photo");
			//
			BeanProperty<Staff, Float> staffBeanProperty_5 = BeanProperty.create("salaire");
			jTableBinding.addColumnBinding(staffBeanProperty_5).setColumnName("Salaire");
			//
			BeanProperty<Staff, Date> staffBeanProperty_6 = BeanProperty.create("dns");
			jTableBinding.addColumnBinding(staffBeanProperty_6).setColumnName("Date de naissance");
			//
			BeanProperty<Staff, String> staffBeanProperty_7 = BeanProperty.create("surname");
			jTableBinding.addColumnBinding(staffBeanProperty_7).setColumnName("Surname");
			//
			BeanProperty<Staff, String> staffBeanProperty_8 = BeanProperty.create("email");
			jTableBinding.addColumnBinding(staffBeanProperty_8).setColumnName("Email");
			//
			BeanProperty<Staff, String> staffBeanProperty_9 = BeanProperty.create("function");
			jTableBinding.addColumnBinding(staffBeanProperty_9).setColumnName("Function");
			//
			jTableBinding.bind();
		}
}
