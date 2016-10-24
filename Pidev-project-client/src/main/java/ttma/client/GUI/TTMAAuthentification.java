package ttma.client.GUI;

import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import ttma.Entities.Staff;
import ttma.client.delegate.AuthentificationDeleguate;

import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


import java.awt.EventQueue;




import javax.swing.ImageIcon;

import java.awt.Color;


import java.awt.Font;

import javax.swing.JPasswordField;


import ttma.client.GUI.ManageStaffs;





public class TTMAAuthentification extends JFrame {

	private JPanel contentPane;
	
	
	private JTextField log;
	private JPasswordField pwd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TTMAAuthentification frame = new TTMAAuthentification();
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
	public TTMAAuthentification() {
	
		
		
		
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
		
		JLabel label = new JLabel("Login :");
		label.setForeground(new Color(30, 144, 255));
		label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label.setBounds(396, 363, 129, 28);
		panel_2.add(label);
		
		JLabel label_1 = new JLabel("Password :");
		label_1.setForeground(new Color(30, 144, 255));
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_1.setBounds(396, 442, 129, 32);
		panel_2.add(label_1);
		
		
		
	
		
		JButton btnSaveAccount = new JButton("Save");
		btnSaveAccount.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSaveAccount.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Staff staf=AuthentificationDeleguate.getProxy().sauvegarderUtilisateur(btnSaveAccount.isSelected());
				 System.out.println("Checked? " );
			}
		});
		btnSaveAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				
			}
		});
		btnSaveAccount.setIcon(new ImageIcon("C:\\images\\48x48\\save.png"));
		btnSaveAccount.setBounds(665, 513, 129, 47);
		panel_2.add(btnSaveAccount);
		
		log = new JTextField();
		log.setColumns(10);
		log.setBounds(522, 363, 162, 34);
		panel_2.add(log);
		
		pwd = new JPasswordField();
		pwd.setBounds(522, 442, 162, 28);
		panel_2.add(pwd);
		
		JButton button = new JButton("Connect");
		button.setFont(new Font("Tahoma", Font.BOLD, 13));
		button.setIcon(new ImageIcon("C:\\images\\48x48\\accept.png"));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Staff staf=AuthentificationDeleguate.getProxy().authentifier(log.getText(),new String(pwd.getText()));
				boolean verif=AuthentificationDeleguate.getProxy().existeLogin(log.getText().toString());
				
				if(staf!=null){
				
					
				if(staf.getFunction().equals("AgencyResponsible") )
					 new ManageStaffs().setVisible(true);
				else
				if(staf.getFunction().equals("ROWCM") )
					new IMedicalResponsible().setVisible(true);
				else
					if(staf.getFunction().equals("financial responsible") )
					new	IFinanceManagement().setVisible(true);	
					else
						if(staf.getFunction().equals("ROLAC") )
						new	ILogisticResponsible().setVisible(true);	
						else
							if(staf.getFunction().equals("event") )
							new	EspaceResponsableEvent().setVisible(true);	
							else
								if(staf.getFunction().equals("RORWP") )
								new	EspaceRespRelations().setVisible(true);
				}	
					
			}
		});
		button.setBounds(504, 513, 151, 47);
		panel_2.add(button);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\images\\bg authentif.png"));
		lblNewLabel.setBounds(0, 0, 1353, 906);
		panel_2.add(lblNewLabel);
		contentPane.setLayout(gl_contentPane);
	
	}
}
