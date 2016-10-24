package ttma.client.GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.border.LineBorder;

import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;

import ttma.Entities.*;
import ttma.client.delegate.*;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;

public class IManageConge extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldDeb;
	private JTextField deb;
	private JTextField textFieldFin;
	private JTextField fin;
	private JTextField textFieldCin;
	private JTable table;
	List<Conge> conges;
	Conge conge;
	private JTable table_1;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IManageConge frame = new IManageConge();
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
	public IManageConge() {
		conges=new ArrayList<Conge>();
		conges=GestionCongeDelegate.dofindAllConges();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1372, 953);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel dateDeb = new JPanel();
		contentPane.add(dateDeb, BorderLayout.CENTER);
		dateDeb.setLayout(null);
		
		JButton btnNewButton_3 = new JButton("Send mail");
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_3.setIcon(new ImageIcon("C:\\images\\32x32\\mail.png"));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EnvoiMail p= new EnvoiMail();
				p.setVisible(true);
			}
		});
		btnNewButton_3.setBounds(69, 392, 140, 42);
		dateDeb.add(btnNewButton_3);
		
		JButton btnNewButton_2 = new JButton("home");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AgencyResponsible o= new AgencyResponsible();
				o.setVisible(true);
			}
		});
		btnNewButton_2.setIcon(new ImageIcon("C:\\images\\32x32\\home.png"));
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_2.setBounds(69, 338, 140, 41);
		dateDeb.add(btnNewButton_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(643, 341, 565, 152);
		dateDeb.add(scrollPane);
		
		table_1 = new JTable();
		scrollPane.setViewportView(table_1);
		table_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				conge=conges.get(table_1.getSelectedRow());
				textFieldCin.setText(conge.getCIN());
				deb.setText(conge.getDateDeb());
				fin.setText(conge.getDateFin());
				
			}
		});
		
		deb = new JTextField();
		deb.setFont(new Font("Tahoma", Font.BOLD, 13));
		deb.setBounds(419, 379, 184, 20);
		dateDeb.add(deb);
		deb.setColumns(10);
		
		fin = new JTextField();
		fin.setFont(new Font("Tahoma", Font.BOLD, 13));
		fin.setBounds(419, 421, 184, 20);
		dateDeb.add(fin);
		fin.setColumns(10);
		
		JComboBox comboBoxDeci = new JComboBox();
		comboBoxDeci.setFont(new Font("Tahoma", Font.BOLD, 13));
		comboBoxDeci.setModel(new DefaultComboBoxModel(new String[] {"", "Accept", "Refuse"}));
		comboBoxDeci.setBounds(419, 473, 184, 20);
		dateDeb.add(comboBoxDeci);
		
		JButton btnNewButton = new JButton("Validate");
		btnNewButton.setIcon(new ImageIcon("C:\\images\\32x32\\accept.png"));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 conge.setCIN(textFieldCin.getText());;
	             conge.setDateDeb(deb.getText());;
				 conge.setDateFin(fin.getText());
				 conge.setVerif(comboBoxDeci.getSelectedItem().toString());
				if(GestionCongeDelegate.doupdateConge(conge))
				
				{
					JOptionPane.showMessageDialog(null, "update with succes...");
					textFieldCin.setText("");
					deb.setText("");
					fin.setText("");
					
					conges=GestionCongeDelegate.dofindAllConges();
					initDataBindings();
				}
				else{}
			}

			private void initDataBindings() {
				// TODO Auto-generated method stub
				
			}

			
			}
		);
		btnNewButton.setBounds(353, 621, 140, 41);
		dateDeb.add(btnNewButton);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setIcon(new ImageIcon("C:\\images\\32x32\\delete.png"));
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnCancel.setBounds(506, 621, 145, 41);
		dateDeb.add(btnCancel);
		
		JLabel lblNewLabel = new JLabel("Leave start date :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(267, 375, 140, 20);
		dateDeb.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Leave end date :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(267, 420, 140, 14);
		dateDeb.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Decision : ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBounds(267, 462, 140, 20);
		dateDeb.add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("Cin :");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_4.setBounds(267, 341, 140, 14);
		dateDeb.add(lblNewLabel_4);
		
		textFieldCin = new JTextField();
		textFieldCin.setFont(new Font("Tahoma", Font.BOLD, 13));
		textFieldCin.setBounds(419, 342, 184, 20);
		dateDeb.add(textFieldCin);
		textFieldCin.setColumns(10);
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				conge=conges.get(table.getSelectedRow());
				textFieldDeb.setText(conge.getDateDeb().toString());
				textFieldFin.setText(conge.getDateFin().toString());
				
				
			
				}
		});
		//table = new JTable();
		//table.setBounds(311, 43, 211, 203);
		//dateDeb.add(table);
		

		
		textFieldDeb = new JTextField();
		textFieldDeb.setColumns(10);
		
		textFieldFin = new JTextField();
		textFieldFin .setColumns(10);
		
		JLabel lblDescription = new JLabel("Name :");
		
		JButton btnNewButton_1 = new JButton("Refresh table");
		btnNewButton_1.setIcon(new ImageIcon("C:\\images\\32x32\\redo.png"));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				initDataBindings();
			}
		});
		btnNewButton_1.setBounds(785, 550, 178, 41);
		dateDeb.add(btnNewButton_1);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\images\\bg f.png"));
		lblNewLabel_3.setBounds(0, 0, 1360, 900);
		dateDeb.add(lblNewLabel_3);
		initDataBindings();
	}
	protected void initDataBindings() {
		JTableBinding<Conge, List<Conge>, JTable> jTableBinding = SwingBindings.createJTableBinding(UpdateStrategy.READ, conges, table_1);
		//
		BeanProperty<Conge, String> congeBeanProperty = BeanProperty.create("CIN");
		jTableBinding.addColumnBinding(congeBeanProperty).setColumnName("CIN");
		//
		BeanProperty<Conge, String> congeBeanProperty_1 = BeanProperty.create("dateDeb");
		jTableBinding.addColumnBinding(congeBeanProperty_1).setColumnName("Start Date");
		//
		BeanProperty<Conge, String> congeBeanProperty_2 = BeanProperty.create("dateFin");
		jTableBinding.addColumnBinding(congeBeanProperty_2).setColumnName("End Date");
		//
		BeanProperty<Conge, String> congeBeanProperty_3 = BeanProperty.create("verif");
		jTableBinding.addColumnBinding(congeBeanProperty_3).setColumnName("Decision");
		//
		jTableBinding.bind();
	}
}
