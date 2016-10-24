package ttma.client.GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;
import javax.swing.ImageIcon;

import java.awt.Color;
import java.awt.Font;

import javax.swing.SwingConstants;

public class AgencyResponsible extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AgencyResponsible frame = new AgencyResponsible();
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
	public AgencyResponsible() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1368, 954);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JButton btnManageStaffs = new JButton("Manage Staffs");
		btnManageStaffs.setIcon(new ImageIcon("C:\\images\\48x48\\users.png"));
		btnManageStaffs.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnManageStaffs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManageStaffs A= new ManageStaffs();
			A.show();
			}
		});
		
		JButton btnNewButton_1 = new JButton("Leave Management");
		btnNewButton_1.setIcon(new ImageIcon("C:\\images\\48x48\\configure.png"));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IManageConge im=new IManageConge();
				im.setVisible(true);
			}
		});
		
		JButton btnNewButton = new JButton("Disconnect");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TTMAAuthentification t =new TTMAAuthentification();
				t.setVisible(true);
				
			}
		});
		
		JButton btnManageTimetable = new JButton("Manage Timetable");
		btnManageTimetable.setIcon(new ImageIcon("C:\\images\\32x32\\documents.png"));
		btnManageTimetable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IManageTimetable y= new IManageTimetable();
				y.show();
			}
		});
		btnManageTimetable.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnManageTimetable.setBounds(484, 602, 344, 91);
		panel.add(btnManageTimetable);
		btnNewButton.setBounds(41, 245, 97, 25);
		panel.add(btnNewButton);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_1.setBounds(847, 467, 344, 91);
		panel.add(btnNewButton_1);
		btnManageStaffs.setBounds(484, 467, 344, 91);
		panel.add(btnManageStaffs);
		
		JLabel lblMedicalResponsible = new JLabel("AGENCY RESPONSIBLE");
		lblMedicalResponsible.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblMedicalResponsible.setForeground(Color.WHITE);
		lblMedicalResponsible.setBounds(528, 259, 261, 30);
		panel.add(lblMedicalResponsible);
		
		JButton btnAddStaff = new JButton("Add Staff");
		btnAddStaff.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnAddStaff.setIcon(new ImageIcon("C:\\images\\48x48\\add.png"));
		btnAddStaff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FirstStaffAdd m = new FirstStaffAdd();
				m.show();
			}
		});
		btnAddStaff.setBounds(123, 467, 344, 91);
		panel.add(btnAddStaff);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\images\\bg menu1.png"));
		lblNewLabel.setBounds(0, 0, 1357, 900);
		panel.add(lblNewLabel);
	}

}
