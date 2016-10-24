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

public class IMedicalResponsible extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IMedicalResponsible frame = new IMedicalResponsible();
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
	public IMedicalResponsible() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1368, 954);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Manage online consultations");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setIcon(new ImageIcon("C:\\images\\48x48\\notepad.png"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IManageAppointement i = new IManageAppointement();
				i.show();
			}
		});
		
		JButton button_1 = new JButton("Manage Offers");
		button_1.setIcon(new ImageIcon("C:\\images\\48x48\\new.png"));
		button_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IGestionOffers o = new IGestionOffers();
			o.show();
			}
		});
		
		JButton btnNewButton_1 = new JButton("Leave Request");
		btnNewButton_1.setIcon(new ImageIcon("C:\\images\\48x48\\cut.png"));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IAddConge i = new IAddConge();
				i.show();
			}
		});
		
		JButton btnNewButton_2 = new JButton("DISCONNECT");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TTMAAuthentification t =new TTMAAuthentification();
				t.setVisible(true);
			}
		});
		btnNewButton_2.setIcon(new ImageIcon("C:\\images\\32x32\\home.png"));
		btnNewButton_2.setBounds(65, 265, 145, 41);
		panel.add(btnNewButton_2);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_1.setBounds(1008, 525, 261, 91);
		panel.add(btnNewButton_1);
		button_1.setBounds(760, 525, 216, 91);
		panel.add(button_1);
		
		JLabel lblMedicalResponsible = new JLabel("MEDICAL RESPONSIBLE");
		lblMedicalResponsible.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblMedicalResponsible.setForeground(Color.WHITE);
		lblMedicalResponsible.setBounds(528, 259, 261, 30);
		panel.add(lblMedicalResponsible);
		btnNewButton.setBounds(415, 525, 325, 91);
		panel.add(btnNewButton);
		
		JButton button = new JButton("Manage Clinics & Doctors");
		button.setFont(new Font("Tahoma", Font.BOLD, 16));
		button.setIcon(new ImageIcon("C:\\images\\48x48\\add.png"));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IManageClincs m = new IManageClincs();
				m.show();
			}
		});
		button.setBounds(81, 525, 312, 91);
		panel.add(button);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\images\\bg menu1.png"));
		lblNewLabel.setBounds(0, 0, 1357, 900);
		panel.add(lblNewLabel);
	}

}
