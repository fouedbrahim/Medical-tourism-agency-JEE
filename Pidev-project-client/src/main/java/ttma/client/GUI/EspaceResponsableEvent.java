package ttma.client.GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class EspaceResponsableEvent extends JFrame {

	private JPanel contentPane;
	EventManage eventManage;
	EventAdd eventAdd;
 //   ReservationManage reservationManage;
    //Stat stat ;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EspaceResponsableEvent frame = new EspaceResponsableEvent();
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
	public EspaceResponsableEvent() {
		final JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 13, 1222, 900);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1264, 964);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnOperations = new JMenu("Operations");
		menuBar.add(mnOperations);
		
		JMenuItem mntmManageEvent = new JMenuItem("Manage Event");
		//mntmManageEvent.setIcon(new ImageIcon("D:\\javaEETools\\workspacee\\ClientTTMA\\manage_icon.png"));
		mntmManageEvent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				eventManage=new EventManage();
				scrollPane.setViewportView(eventManage);
			}
		});
		mnOperations.add(mntmManageEvent);
		
		JMenuItem mntmAddEvent = new JMenuItem("Add event");
		
		mntmAddEvent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eventAdd =new EventAdd();
				scrollPane.setViewportView(eventAdd);
			}
		});
		mnOperations.add(mntmAddEvent);
		
		JMenuItem mntmManageReservation = new JMenuItem("Manage Reservation");
		//mntmManageReservation.setIcon(new ImageIcon("D:\\javaEETools\\workspacee\\ClientTTMA\\calendar.png"));
		mntmManageReservation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//reservationManage =new ReservationManage();
				//scrollPane.setViewportView(reservationManage);
			}
		});
		mnOperations.add(mntmManageReservation);
		
		JMenuItem mntmDisconnect = new JMenuItem("Disconnect");
		mntmDisconnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TTMAAuthentification t = new TTMAAuthentification();
				t.show();
			}
		});
		mnOperations.add(mntmDisconnect);
		
		JMenu mnStatistic = new JMenu("Statistic");
		menuBar.add(mnStatistic);
		
		JMenuItem mntmEventStat = new JMenuItem("Event Stat");
		//mntmEventStat.setIcon(new ImageIcon("D:\\javaEETools\\workspacee\\ClientTTMA\\icon_stat.gif"));
		mntmEventStat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//stat =new Stat();
				//scrollPane.setViewportView(stat);
			}
		});
		mnStatistic.add(mntmEventStat);
		
		JMenuBar menuBar_1 = new JMenuBar();
		mnStatistic.add(menuBar_1);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(scrollPane);
	}
}
