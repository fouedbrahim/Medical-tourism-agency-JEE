package ttma.client.GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import ttma.Entities.Conge;
//import ttma.Entities.Function;
import ttma.Entities.Operation;
import ttma.Entities.Timetable;
import ttma.client.delegate.GestionCongeDelegate;
import ttma.client.delegate.GestionEmploiDelegate;
import ttma.client.delegate.GestionOperationsDelegate;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import java.awt.Font;

import javax.swing.JTabbedPane;
import javax.swing.JSlider;
import javax.swing.JScrollBar;
import javax.swing.JTable;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.BeanProperty;

import javax.swing.JScrollPane;

import org.jdesktop.beansbinding.ObjectProperty;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import javax.swing.border.TitledBorder;
import javax.swing.UIManager;

import java.awt.Color;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import javax.swing.ImageIcon;

public class IManageTimetable extends JFrame {

	private JPanel contentPane;
	private JTable table;
	List<Timetable> timetables;
	
	Timetable timetable;
	private JPanel panel_1;
	private JButton button;
	private JButton button_1;
	private JButton button_2;
	private JLabel label;
	private JLabel label_1;
	private JTextField M;
	private JTextField M1;
	private JTextField T;
	private JTextField T1;
	private JTextField W;
	private JTextField W1;
	private JTextField Th;
	private JTextField Th1;
	private JTextField F;
	private JTextField F1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JLabel label_5;
	private JLabel label_6;
	private JLabel label_8;
	private JComboBox usertype;
	private JTable table_1;
	private JButton btnRefreshTable;
	private JPanel panel_2;
	private JPanel panel_3;
	private JLabel lblUsers;
	private JButton btnExport;
	private JScrollPane scrollPane;
	private JLabel lblNewLabel;
	private JButton btnNewButton_1;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IManageTimetable frame = new IManageTimetable();
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
	public IManageTimetable() {
		timetables=new ArrayList<Timetable>();
		timetables=GestionEmploiDelegate.dofindAllTimetable();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 932, 569);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(-6, -1, 955, 616);
		contentPane.add(panel);
		panel.setLayout(null);
		
		panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(10, 38, 908, 485);
		panel.add(panel_1);
		
		button = new JButton("Send E-mail");
		button.setIcon(new ImageIcon("C:\\images\\32x32\\mail.png"));
		button.setBounds(374, 259, 131, 41);
		panel_1.add(button);
		
		button_1 = new JButton("Modify");
		button_1.setIcon(new ImageIcon("C:\\images\\32x32\\configure.png"));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				timetable.setMonday(M.getText());
				timetable.setMonday1(M1.getText());
				timetable.setTuesday(T.getText());
				timetable.setTuesday1(T1.getText());
				timetable.setWednesday(W.getText());
				timetable.setWednesday1(W1.getText());
				timetable.setThursday(T.getText());
				timetable.setThursday1(Th1.getText());
				timetable.setFriday(F.getText());
				timetable.setFriday1(F1.getText());
				if(GestionEmploiDelegate.doupdateTimetable(timetable))
				
				{
					JOptionPane.showMessageDialog(null, "update with succes...");
					
					M.setText("");
					M1.setText("");
					T.setText("");
					T1.setText("");
					W.setText("");
					W1.setText("");
					Th.setText("");
				    Th1.setText("");
					F.setText("");
					F1.setText("");
				
					initDataBindings();
				}
				else{}
			}
			
		});
		button_1.setBounds(224, 259, 113, 41);
		panel_1.add(button_1);
		
		button_2 = new JButton("Validate");
		button_2.setIcon(new ImageIcon("C:\\images\\32x32\\accept.png"));
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Timetable hotel=new Timetable();
				hotel.setMonday(M.getText());
				hotel.setMonday1(M1.getText());
				hotel.setTuesday(T.getText());
				hotel.setTuesday1(T1.getText());
				hotel.setWednesday(W.getText());
			    hotel.setWednesday1(W1.getText());
			    hotel.setThursday(Th.getText());
			    hotel.setThursday1(Th1.getText());
			    hotel.setFriday(F.getText());
			    hotel.setFriday1(F1.getText());
			    hotel.setTypeU(usertype.getSelectedItem().toString());
				
				if(GestionEmploiDelegate.doaddTimetable(hotel)){
					JOptionPane.showMessageDialog(null,"add with succes");
				M.setText("");
				M1.setText("");
				T.setText("");
				T1.setText("");
				W.setText("");
				W1.setText("");
				Th.setText("");
			    Th1.setText("");
				F.setText("");
				F1.setText("");
				initDataBindings();
			}
		}});
		button_2.setBounds(65, 259, 124, 39);
		panel_1.add(button_2);
		
		panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Select Personal", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_3.setBounds(695, 65, 203, 143);
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		usertype = new JComboBox();
		usertype.setBounds(73, 105, 124, 20);
		panel_3.add(usertype);
		usertype.setModel(new DefaultComboBoxModel(new String[] {"", "EventsResponsible", "RORWP", "ROWCM", "ROLAC", "FinancialResponsible"}));
		
		label_8 = new JLabel("Type :");
		label_8.setBounds(17, 108, 46, 14);
		panel_3.add(label_8);
		
		lblUsers = new JLabel("Users");
		lblUsers.setBounds(17, 83, 46, 14);
		panel_3.add(lblUsers);
		
		btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					JOptionPane.showMessageDialog(null, "Help :   Types of staffs (RORWP:responsible of relations with patients, "
							+ "ROWCM :Responsible of relations with clinics and medical centers ROLAC:Responsible of logistics and cordinations");
		        }
		        
		        catch(Exception e1){
		            
		            JOptionPane.showMessageDialog(null, e1);
		            
		        }
			}
		});
		btnNewButton_1.setIcon(new ImageIcon("C:\\images\\32x32\\show_info.png"));
		btnNewButton_1.setBounds(162, 11, 31, 20);
		panel_3.add(btnNewButton_1);
		
		btnRefreshTable = new JButton("Refresh Table");
		btnRefreshTable.setIcon(new ImageIcon("C:\\images\\32x32\\undo.png"));
		btnRefreshTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				initDataBindings();
			}
		});
		btnRefreshTable.setBounds(537, 259, 156, 41);
		panel_1.add(btnRefreshTable);
		
		
		btnExport = new JButton("Export in PDF");
		btnExport.setIcon(new ImageIcon("C:\\images\\32x32\\documents.png"));
		btnExport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String browse= M.getText();
				String browse1= M1.getText();
				String browse2= T.getText();
				String browse3= T1.getText();
				String browse4= W.getText();
				String browse5= W1.getText();
				String browse6= Th.getText();
				String browse7= Th1.getText();
				String browse8= F.getText();
				String browse9= F1.getText();
		        Document doc = new Document();
		         try {
		                PdfWriter writer=PdfWriter.getInstance(doc,new FileOutputStream(browse+".pdf"));
		            } catch (FileNotFoundException ex) {
		            } catch (DocumentException ex) {
		        }
		        
		        
		        // String text = @"The result can be seen below, which shows that ";
		        String i=(String) table_1.getValueAt(table_1.getSelectedRow(),0).toString();
		        String j=(String) table_1.getValueAt(table_1.getSelectedRow(),1).toString();
		        String d=(String) table_1.getValueAt(table_1.getSelectedRow(),2).toString();
		        String f=(String) table_1.getValueAt(table_1.getSelectedRow(),3).toString();
		        String b=(String) table_1.getValueAt(table_1.getSelectedRow(),4).toString();
		        String c=(String) table_1.getValueAt(table_1.getSelectedRow(),5).toString();
		        String p=(String) table_1.getValueAt(table_1.getSelectedRow(),6).toString();
		        String a=(String) table_1.getValueAt(table_1.getSelectedRow(),7).toString();
		        String y=(String) table_1.getValueAt(table_1.getSelectedRow(),8).toString();
		        String l=(String) table_1.getValueAt(table_1.getSelectedRow(),9).toString();
		        try{
		            doc.open();
		           
		           doc.add(new Paragraph("Monday :\t"+ table_1.getValueAt(table_1.getSelectedRow(),0).toString()));
		           doc.add(new Paragraph("Monday afternon :\t"+ table_1.getValueAt(table_1.getSelectedRow(),1).toString()));
		           doc.add(new Paragraph("Tuesday :\t"+ table_1.getValueAt(table_1.getSelectedRow(),2).toString()));
		           doc.add(new Paragraph("Tuesday afternon :\t"+ table_1.getValueAt(table_1.getSelectedRow(),3).toString()));
		           doc.add(new Paragraph("Wednesday :\t"+ table_1.getValueAt(table_1.getSelectedRow(),4).toString()));
		           doc.add(new Paragraph("Wednesday afternon :\t"+ table_1.getValueAt(table_1.getSelectedRow(),5).toString()));
		           doc.add(new Paragraph("Thursday :\t"+ table_1.getValueAt(table_1.getSelectedRow(),6).toString()));
		           doc.add(new Paragraph("Thursday afternon :\t"+ table_1.getValueAt(table_1.getSelectedRow(),7).toString()));
		           doc.add(new Paragraph("Friday :\t"+ table_1.getValueAt(table_1.getSelectedRow(),8).toString()));
		           doc.add(new Paragraph("Friday afternon :\t"+ table_1.getValueAt(table_1.getSelectedRow(),9).toString()));
		            doc.close();
		            JOptionPane.showMessageDialog(null, "bien export�");
		        }
		        
		        catch(Exception e1){
		            
		            JOptionPane.showMessageDialog(null, e1);
		            
		        }
				
				
			}
		});
		btnExport.setBounds(725, 259, 147, 41);
		panel_1.add(btnExport);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(47, 336, 714, 104);
		panel_1.add(scrollPane);
		
		table_1 = new JTable();
		scrollPane.setViewportView(table_1);
		
		panel_2 = new JPanel();
		panel_2.setForeground(Color.LIGHT_GRAY);
		panel_2.setBackground(Color.WHITE);
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Calendar", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setBounds(19, 22, 674, 215);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		label = new JLabel("Morning Session :");
		label.setBounds(6, 55, 84, 34);
		panel_2.add(label);
		
		label_1 = new JLabel("Afternoon Session :");
		label_1.setBounds(6, 143, 95, 34);
		panel_2.add(label_1);
		
		M = new JTextField();
		M.setBounds(143, 45, 86, 55);
		panel_2.add(M);
		M.setColumns(10);
		
		M1 = new JTextField();
		M1.setBounds(143, 143, 86, 56);
		panel_2.add(M1);
		M1.setColumns(10);
		T = new JTextField();
		T.setBounds(248, 45, 86, 55);
		panel_2.add(T);
		T.setColumns(10);
		
		T1 = new JTextField();
		T1.setBounds(248, 143, 86, 56);
		panel_2.add(T1);
		T1.setColumns(10);
		
		W = new JTextField();
		W.setBounds(355, 45, 84, 55);
		panel_2.add(W);
		W.setColumns(10);
		
		W1 = new JTextField();
		W1.setBounds(353, 143, 86, 56);
		panel_2.add(W1);
		W1.setColumns(10);
		
		Th = new JTextField();
		Th.setBounds(465, 45, 86, 55);
		panel_2.add(Th);
		Th.setColumns(10);
		
		Th1 = new JTextField();
		Th1.setBounds(465, 143, 86, 56);
		panel_2.add(Th1);
		Th1.setColumns(10);
		
		F = new JTextField();
		F.setBounds(576, 45, 86, 55);
		panel_2.add(F);
		F.setColumns(10);
		
		F1 = new JTextField();
		F1.setBounds(576, 143, 86, 56);
		panel_2.add(F1);
		F1.setColumns(10);
		
		label_2 = new JLabel("Monday");
		label_2.setBounds(154, 16, 75, 22);
		panel_2.add(label_2);
		
		label_3 = new JLabel("Tuesday");
		label_3.setBounds(274, 20, 46, 18);
		panel_2.add(label_3);
		
		label_4 = new JLabel("Wednesday");
		label_4.setBounds(366, 20, 57, 18);
		panel_2.add(label_4);
		
		label_5 = new JLabel("Thursday");
		label_5.setBounds(483, 18, 68, 18);
		panel_2.add(label_5);
		
		label_6 = new JLabel("Friday");
		label_6.setBounds(596, 16, 46, 22);
		panel_2.add(label_6);
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\images\\bg f.png"));
		lblNewLabel.setBounds(0, 0, 908, 499);
		panel_1.add(lblNewLabel);
		
		btnNewButton = new JButton("home");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AgencyResponsible t = new AgencyResponsible();
				t.setVisible(true);
			}
		});
		btnNewButton.setBounds(28, 13, 97, 25);
		panel.add(btnNewButton);
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				timetable=timetables.get(table_1.getSelectedRow());
				M.setText(timetable.getMonday());
				M1.setText(timetable.getMonday1());
				T.setText(timetable.getTuesday());
				T1.setText(timetable.getTuesday1());
				Th.setText(timetable.getThursday());
				Th1.setText(timetable.getThursday1());
				W.setText(timetable.getWednesday());
				W1.setText(timetable.getWednesday1());
				F.setText(timetable.getFriday());
				F1.setText(timetable.getFriday1());
				
				
			}
		});
		
		
		
		//table=new JTable();
		initDataBindings();
		
		
	}
	protected void initDataBindings() {
		JTableBinding<Timetable, List<Timetable>, JTable> jTableBinding = SwingBindings.createJTableBinding(UpdateStrategy.READ, timetables, table_1);
		//
		BeanProperty<Timetable, String> timetableBeanProperty = BeanProperty.create("monday");
		jTableBinding.addColumnBinding(timetableBeanProperty).setColumnName("MM");
		//
		BeanProperty<Timetable, String> timetableBeanProperty_1 = BeanProperty.create("monday1");
		jTableBinding.addColumnBinding(timetableBeanProperty_1).setColumnName("MA");
		//
		BeanProperty<Timetable, String> timetableBeanProperty_2 = BeanProperty.create("tuesday");
		jTableBinding.addColumnBinding(timetableBeanProperty_2).setColumnName("TM");
		//
		BeanProperty<Timetable, String> timetableBeanProperty_3 = BeanProperty.create("tuesday1");
		jTableBinding.addColumnBinding(timetableBeanProperty_3).setColumnName("TA");
		//
		BeanProperty<Timetable, String> timetableBeanProperty_4 = BeanProperty.create("wednesday");
		jTableBinding.addColumnBinding(timetableBeanProperty_4).setColumnName("WM");
		//
		BeanProperty<Timetable, String> timetableBeanProperty_5 = BeanProperty.create("wednesday1");
		jTableBinding.addColumnBinding(timetableBeanProperty_5).setColumnName("WA");
		//
		BeanProperty<Timetable, String> timetableBeanProperty_6 = BeanProperty.create("thursday");
		jTableBinding.addColumnBinding(timetableBeanProperty_6).setColumnName("ThM");
		//
		BeanProperty<Timetable, String> timetableBeanProperty_7 = BeanProperty.create("thursday1");
		jTableBinding.addColumnBinding(timetableBeanProperty_7).setColumnName("ThA");
		//
		BeanProperty<Timetable, String> timetableBeanProperty_8 = BeanProperty.create("friday");
		jTableBinding.addColumnBinding(timetableBeanProperty_8).setColumnName("FM");
		//
		BeanProperty<Timetable, String> timetableBeanProperty_9 = BeanProperty.create("friday1");
		jTableBinding.addColumnBinding(timetableBeanProperty_9).setColumnName("FA");
		//
		BeanProperty<Timetable, String> timetableBeanProperty_10 = BeanProperty.create("typeU");
		jTableBinding.addColumnBinding(timetableBeanProperty_10).setColumnName("Type");
		//
		jTableBinding.bind();
	}
}
