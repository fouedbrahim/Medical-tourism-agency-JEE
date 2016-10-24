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

public class ILogisticResponsible extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ILogisticResponsible frame = new ILogisticResponsible();
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
	public ILogisticResponsible() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1368, 954);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JButton btnManageTrCompanies = new JButton("MANAGE TR COMPANIES");
		btnManageTrCompanies.setIcon(new ImageIcon("C:\\images\\48x48\\new.png"));
		btnManageTrCompanies.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnManageTrCompanies.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManageTransportCompagny o = new ManageTransportCompagny();
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
		
		JButton btnNewButton = new JButton("Disconnect");
		btnNewButton.setIcon(new ImageIcon("C:\\images\\32x32\\close.png"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TTMAAuthentification t =new TTMAAuthentification();
				t.setVisible(true);
			}
		});
		btnNewButton.setBounds(45, 265, 139, 46);
		panel.add(btnNewButton);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_1.setBounds(872, 525, 261, 91);
		panel.add(btnNewButton_1);
		btnManageTrCompanies.setBounds(513, 525, 301, 91);
		panel.add(btnManageTrCompanies);
		
		JLabel lblMedicalResponsible = new JLabel("LOGISTIC RESPONSIBLE");
		lblMedicalResponsible.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblMedicalResponsible.setForeground(Color.WHITE);
		lblMedicalResponsible.setBounds(528, 259, 261, 30);
		panel.add(lblMedicalResponsible);
		
		JButton btnManagePublicity = new JButton("MANAGE PUBLICITY");
		btnManagePublicity.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnManagePublicity.setIcon(new ImageIcon("C:\\images\\48x48\\add.png"));
		btnManagePublicity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManagePublicityy m = new ManagePublicityy();
				m.show();
			}
		});
		btnManagePublicity.setBounds(161, 525, 312, 91);
		panel.add(btnManagePublicity);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\images\\bg menu1.png"));
		lblNewLabel.setBounds(0, 0, 1357, 900);
		panel.add(lblNewLabel);
	}

}
