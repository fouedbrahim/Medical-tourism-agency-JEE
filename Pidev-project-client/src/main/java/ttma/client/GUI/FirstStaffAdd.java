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
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;


import javax.swing.JTextField;

import ttma.Entities.Operation;
import ttma.Entities.Staff;
import ttma.client.delegate.AuthentificationDeleguate;




import ttma.client.delegate.ManageRHDeleguate;

import javax.swing.JButton;








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
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;

public class FirstStaffAdd extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField nm;
	private JTextField sr;
	private JTextField lo;
	private JTextField ci;
	private JTextField sal;
	private JPasswordField passwordField;
	private JTextField dn;
	private JTextField em;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FirstStaffAdd frame = new FirstStaffAdd();
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
	public FirstStaffAdd() {
	
		
		
		
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
		
		JButton btnNewButton_1 = new JButton("home");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AgencyResponsible t =new AgencyResponsible();
				t.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(52, 277, 97, 25);
		panel_2.add(btnNewButton_1);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setForeground(Color.BLACK);
		tabbedPane.setFont(new Font("Tahoma", Font.BOLD, 13));
		tabbedPane.setBounds(235, 277, 1079, 525);
		panel_2.add(tabbedPane);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("Welcome Agency Responsible ", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblName = new JLabel("Name :");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblName.setForeground(new Color(30, 144, 255));
		lblName.setBounds(139, 57, 129, 28);
		panel_1.add(lblName);
		
		JLabel label_1 = new JLabel("Password :");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_1.setForeground(new Color(30, 144, 255));
		label_1.setBounds(139, 243, 129, 32);
		panel_1.add(label_1);
		
		nm = new JTextField();
		nm.setColumns(10);
		nm.setBounds(280, 57, 119, 28);
		panel_1.add(nm);
		
		sr = new JTextField();
		sr.setColumns(10);
		sr.setBounds(280, 96, 119, 28);
		panel_1.add(sr);
		
		lo = new JTextField();
		lo.setColumns(10);
		lo.setBounds(280, 135, 119, 29);
		panel_1.add(lo);
		
		ci = new JTextField();
		ci.setColumns(10);
		ci.setBounds(280, 175, 119, 28);
		panel_1.add(ci);
		
		sal = new JTextField();
		sal.setColumns(10);
		sal.setBounds(280, 212, 119, 28);
		panel_1.add(sal);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(278, 247, 121, 28);
		panel_1.add(passwordField);
		
		

		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "financial responsible", "RORWP", "ROWCM", "ROLAC", "events"}));
		comboBox.setBounds(278, 286, 121, 32);
		panel_1.add(comboBox);
		
		dn = new JTextField();
		dn.setColumns(10);
		dn.setBounds(278, 329, 121, 28);
		panel_1.add(dn);
		
		em = new JTextField();
		em.setColumns(10);
		em.setBounds(278, 374, 121, 28);
		panel_1.add(em);
		
		JButton btnAddStaff = new JButton("Affect Staff");
		btnAddStaff.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnAddStaff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
Staff staf=new Staff();
				
				staf.setCin(ci.getText());
				staf.setSalaire(Float.parseFloat(sal.getText()));
				staf.setName(nm.getText());
			staf.setFunction(comboBox.getSelectedItem().toString());
			staf.setLogin(lo.getText());
			staf.setSurname(sr.getText());
			    staf.setMdp(new String(passwordField.getText()));
				staf.setEmail(em.getText());
				staf.setDns(new Date(dn.getText()));
				
				  if(ManageRHDeleguate.toaddStaff(staf)){
		    		   System.out.println("Ok!");
			}else 
				 System.out.println("Erreur");
			}

			
			
		});
		btnAddStaff.setIcon(new ImageIcon("C:\\images\\48x48\\add.png"));
		btnAddStaff.setBounds(502, 228, 173, 53);
		panel_1.add(btnAddStaff);
		
		JLabel lblSurname = new JLabel("Surname :");
		lblSurname.setForeground(new Color(30, 144, 255));
		lblSurname.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSurname.setBounds(139, 96, 129, 28);
		panel_1.add(lblSurname);
		
		JLabel label = new JLabel("Login :");
		label.setForeground(new Color(30, 144, 255));
		label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label.setBounds(139, 135, 129, 28);
		panel_1.add(label);
		
		JLabel lblCin = new JLabel("Cin :");
		lblCin.setForeground(new Color(30, 144, 255));
		lblCin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCin.setBounds(139, 173, 129, 28);
		panel_1.add(lblCin);
		
		JLabel lblSalary = new JLabel("Salary :");
		lblSalary.setForeground(new Color(30, 144, 255));
		lblSalary.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSalary.setBounds(139, 210, 129, 28);
		panel_1.add(lblSalary);
		
		JLabel lblFunction = new JLabel("Function  :");
		lblFunction.setForeground(new Color(30, 144, 255));
		lblFunction.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblFunction.setBounds(139, 284, 129, 28);
		panel_1.add(lblFunction);
		
		JLabel lblBirthDay = new JLabel("Birth Day :");
		lblBirthDay.setForeground(new Color(30, 144, 255));
		lblBirthDay.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblBirthDay.setBounds(139, 321, 129, 28);
		panel_1.add(lblBirthDay);
		
		JLabel lblMailAddress = new JLabel("Mail Address  :");
		lblMailAddress.setForeground(new Color(30, 144, 255));
		lblMailAddress.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMailAddress.setBounds(139, 368, 129, 28);
		panel_1.add(lblMailAddress);
		
		JButton btnHome = new JButton("Home");
		btnHome.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnHome.setIcon(new ImageIcon("C:\\images\\48x48\\home.png"));
		btnHome.setBounds(496, 72, 179, 52);
		panel_1.add(btnHome);
		
		JButton btnSaveUser = new JButton("Verfify existance");
		btnSaveUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AuthentificationDeleguate.getProxy().existeLogin("");
				JOptionPane.showMessageDialog(null, "This login already EXIST in the Database ");
			}
		});
		btnSaveUser.setIcon(new ImageIcon("C:\\images\\48x48\\admin.png"));
		btnSaveUser.setBounds(496, 150, 179, 53);
		panel_1.add(btnSaveUser);
		
		JButton btnNewButton = new JButton("Help");
		btnNewButton.addActionListener(new ActionListener() {
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
		btnNewButton.setIcon(new ImageIcon("C:\\images\\48x48\\show_info.png"));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setBounds(498, 312, 177, 53);
		panel_1.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\images\\bg f.png"));
		lblNewLabel.setBounds(0, 0, 1353, 906);
		panel_2.add(lblNewLabel);
		contentPane.setLayout(gl_contentPane);
	
	}
}
