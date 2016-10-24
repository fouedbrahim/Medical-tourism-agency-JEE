package ttma.client.GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;

import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;

import ttma.Entities.TransportCompagnie;
import ttma.client.delegate.GestionOperationsDelegate;
import ttma.client.delegate.GestionTransportDelegate;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class ManageTransportCompagny extends JFrame {
	List <TransportCompagnie> transports;
	TransportCompagnie transport;
	
	private JPanel contentPane;
	private JTextField nm;
	private JTextField ad;
	private JTextField re;
	private JTextField co;
	private JTable table;



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageTransportCompagny frame = new ManageTransportCompagny();
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
	public ManageTransportCompagny() {
		transports=new ArrayList<TransportCompagnie>();
		transports=GestionTransportDelegate.dofindAllTransportCompagnie();
		getContentPane().setLayout(null);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1400,900);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JButton btnSendMail = new JButton("Send mail");
		btnSendMail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EnvoiMail o = new EnvoiMail();
				o.show();
			}
		});
		
		JButton btnNewButton = new JButton("home");
		btnNewButton.setIcon(new ImageIcon("C:\\images\\32x32\\home.png"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			ILogisticResponsible t =new ILogisticResponsible();
				t.setVisible(true);
				
			}
		});
		btnNewButton.setBounds(71, 246, 131, 41);
		panel.add(btnNewButton);
		btnSendMail.setIcon(new ImageIcon("C:\\images\\32x32\\mail.png"));
		btnSendMail.setVerticalAlignment(SwingConstants.BOTTOM);
		btnSendMail.setBounds(181, 605, 205, 36);
		panel.add(btnSendMail);
		
		JComboBox cate = new JComboBox();
		cate.setModel(new DefaultComboBoxModel(new String[] {"", "air compagny", "road company", "shipping company"}));
		cate.setBounds(568, 248, 186, 20);
		panel.add(cate);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(406, 288, 461, 128);
		panel.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				transport=transports.get(table.getSelectedRow());
				nm.setText(transport.getCompanyName());
				ad.setText(transport.getCompanyAdress());
				re.setText(transport.getCompanyResponsable());
				Float c=(transport.getCompanyCost());
				co.setText(c.toString());
			}
		});
		scrollPane.setViewportView(table);
		
		JButton button_6 = new JButton("Search");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				transports=GestionTransportDelegate.dofindTransportCompagnieByCategory(cate.getSelectedItem().toString());
				//	hotels1=GestionOperationsDelegate.dofindOperationByNam("Face Surgery");

				initDataBindings();
			
				
			}
		});
		button_6.setIcon(new ImageIcon("C:\\images\\32x32\\zoom.png"));
		button_6.setBounds(781, 240, 157, 37);
		panel.add(button_6);
		
		JButton button_5 = new JButton("VOIP CALL");
		button_5.setIcon(new ImageIcon("C:\\images\\32x32\\phone.png"));
		button_5.setBounds(895, 561, 191, 41);
		panel.add(button_5);
		
		JButton button_3 = new JButton("STATICS");
		button_3.setIcon(new ImageIcon("C:\\images\\32x32\\chart.png"));
		button_3.setBounds(895, 458, 191, 41);
		panel.add(button_3);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1.setBounds(411, 447, 461, 171);
		panel.add(panel_1);
		
		JLabel label = new JLabel("Adress :");
		
		JLabel label_1 = new JLabel("Name :");
		
		nm = new JTextField();
		nm.setColumns(10);
		
		ad = new JTextField();
		ad.setColumns(10);
		
		JLabel label_2 = new JLabel("Category :");
		
		JLabel label_3 = new JLabel("Responsable :");
		
		re = new JTextField();
		re.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "air compagny", "road company", "shipping company"}));
		
		JLabel label_4 = new JLabel("Cost :");
		
		co = new JTextField();
		co.setColumns(10);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGap(0, 461, Short.MAX_VALUE)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(6)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(label)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(label_1)))
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
						.addComponent(nm, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
						.addComponent(ad, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE))
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(label_2)
						.addComponent(label_3))
					.addGap(39)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
						.addComponent(re, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(153)
					.addComponent(label_4)
					.addGap(18)
					.addComponent(co, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
					.addGap(122))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGap(0, 171, Short.MAX_VALUE)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(14)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(nm, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(re, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_3)
						.addComponent(label)
						.addComponent(ad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_4)
						.addComponent(co, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(26))
		);
		panel_1.setLayout(gl_panel_1);
		
		JButton button_2 = new JButton("ADD");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				

				TransportCompagnie tc=new TransportCompagnie();
				tc.setCompanyAdress(ad.getText());
				tc.setCompanyCategory(comboBox.getSelectedItem().toString());
				tc.setCompanyCost(Float.parseFloat(co.getText()));
				tc.setCompanyName(nm.getText());
				tc.setCompanyResponsable(re.getText());
				//tc.setCompanyCategory(comboBox.getSelectedItem().toString());
				GestionTransportDelegate.doaddTransportCompagnie(tc);
				JOptionPane.showMessageDialog(null, "Transport Compagny added...");
				transports=GestionTransportDelegate.dofindAllTransportCompagnie();// TABLE REFRESH
				initDataBindings();
			    
				
			}
		});
		button_2.setIcon(new ImageIcon("C:\\images\\32x32\\add.png"));
		button_2.setVerticalAlignment(SwingConstants.BOTTOM);
		button_2.setBounds(181, 556, 205, 36);
		panel.add(button_2);
		
		JButton button_1 = new JButton("MODIFY");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				transport=transports.get(table.getSelectedRow());
				transport.setCompanyAdress(ad.getText());
				transport.setCompanyCategory(comboBox.getSelectedItem().toString());
				transport.setCompanyCost(Float.parseFloat(co.getText()));
				transport.setCompanyName(nm.getText());
				transport.setCompanyResponsable(re.getText());
				GestionTransportDelegate.doupdateTransportCompagnie(transport);
				JOptionPane.showMessageDialog(null, "Transport Compagny modified...");
				transports=GestionTransportDelegate.dofindAllTransportCompagnie();// TABLE REFRESH
				initDataBindings();
			}
		});
		button_1.setIcon(new ImageIcon("C:\\images\\32x32\\edit.png"));
		button_1.setBounds(181, 501, 205, 37);
		panel.add(button_1);
		
		JButton button = new JButton("DELETE");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				transport=transports.get(table.getSelectedRow());
				GestionTransportDelegate.dodeleteTransportCompagnie(transport);
				JOptionPane.showMessageDialog(null, "Transport Compagny deleted...");
				transports=GestionTransportDelegate.dofindAllTransportCompagnie();// TABLE REFRESH
				initDataBindings();
			}
		});
		button.setIcon(new ImageIcon("C:\\images\\32x32\\delete.png"));
		button.setBounds(181, 447, 205, 36);
		panel.add(button);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\images\\bg f.png"));
		lblNewLabel.setBounds(10, -15, 1400, 900);
		panel.add(lblNewLabel);
	}
	
	protected void initDataBindings() {
		JTableBinding<TransportCompagnie, List<TransportCompagnie>, JTable> jTableBinding = SwingBindings.createJTableBinding(UpdateStrategy.READ, transports, table);
		//
		BeanProperty<TransportCompagnie, Integer> transportCompagnieBeanProperty = BeanProperty.create("companyId");
		jTableBinding.addColumnBinding(transportCompagnieBeanProperty).setColumnName("Id");
		//
		BeanProperty<TransportCompagnie, String> transportCompagnieBeanProperty_1 = BeanProperty.create("companyName");
		jTableBinding.addColumnBinding(transportCompagnieBeanProperty_1).setColumnName("Name");
		//
		BeanProperty<TransportCompagnie, String> transportCompagnieBeanProperty_2 = BeanProperty.create("companyAdress");
		jTableBinding.addColumnBinding(transportCompagnieBeanProperty_2).setColumnName("Adress");
		//
		BeanProperty<TransportCompagnie, String> transportCompagnieBeanProperty_3 = BeanProperty.create("companyCategory");
		jTableBinding.addColumnBinding(transportCompagnieBeanProperty_3).setColumnName("Category");
		//
		BeanProperty<TransportCompagnie, Float> transportCompagnieBeanProperty_4 = BeanProperty.create("companyCost");
		jTableBinding.addColumnBinding(transportCompagnieBeanProperty_4).setColumnName("Cost");
		//
		jTableBinding.bind();
	}

}
