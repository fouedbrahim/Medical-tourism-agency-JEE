package ttma.client.GUI;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.swing.JMenu;
import javax.swing.JTable;





import mail.mail.*;
import mail.mail.MailConstruction;

import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.BeanProperty;

import ttma.Entities.Problem;
import ttma.Entities.ProblemDiscussion;
import ttma.Entities.User;
import ttma.client.delegate.GestionProblemDelegate;
import ttma.client.delegate.GestionProblemDisDelegate;

import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JFileChooser;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Date;

import javax.swing.ImageIcon;

public class GestionProblemDis extends JFrame {

	private JPanel contentPane;
	public static Problem problem=null;
	public static User user=null;
	public static GestionProblems gp=null;
	
	private JTable table;
	List <ProblemDiscussion> problemDiss;
	ProblemDiscussion problemDis;
	private JTextField ti;
	private JTextField textField;
	
	 URL url;
	    Mail mail = new Mail();
	    

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestionProblemDis frame = new GestionProblemDis(problem,user);
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
	
	public GestionProblemDis(Problem problem,User user) {
		this.problem=problem;
		this.user=user;
		
		
        JCheckBox uapp = new JCheckBox("Use application");
		
		JCheckBox uemail = new JCheckBox("Use email");
		
		problemDiss=new ArrayList<ProblemDiscussion>();
		problemDiss=(List<ProblemDiscussion>) GestionProblemDisDelegate.dofindProblemDiscussionById(problem);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 588, 734);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("New menu");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GestionProblemDis.this.setVisible(false);
				
			}
		});
		mnNewMenu.add(mntmExit);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Message to send", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Discussion", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Message Content", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JButton btnResolved = new JButton("Resolved");
		btnResolved.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				problem.setResolved(true);
				GestionProblemDelegate.doupdateHotel(problem);
				
			}
		});
		btnResolved.setIcon(new ImageIcon("C:\\images\\error_true.png"));
		
		JButton btnNewButton = new JButton("Unresolved");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				problem.setResolved(false);
				GestionProblemDelegate.doupdateHotel(problem);
			}
		});
		btnNewButton.setIcon(new ImageIcon("C:\\images\\False.png"));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 542, Short.MAX_VALUE)
						.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 542, Short.MAX_VALUE)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnResolved)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnNewButton)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 209, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnResolved)
						.addComponent(btnNewButton))
					.addContainerGap())
		);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setColumns(10);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		
		JLabel lblTitle_1 = new JLabel("Title  :");
		
		JLabel lblDescription_1 = new JLabel("Description :");
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addComponent(lblDescription_1)
						.addComponent(lblTitle_1))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING)
						.addComponent(textArea, Alignment.LEADING)
						.addComponent(textField, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 424, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(32, Short.MAX_VALUE))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTitle_1))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(textArea, GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
						.addComponent(lblDescription_1))
					.addContainerGap())
		);
		panel_2.setLayout(gl_panel_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}
		});
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ProblemDiscussion h=new ProblemDiscussion();
				h=problemDiss.get(table.getSelectedRow());
				textField.setText(h.getTitle());
				textArea.setText(h.getDescription());
			}
		});
		scrollPane.setViewportView(table);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 466, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel_1.setLayout(gl_panel_1);
		
		JLabel lblTitle = new JLabel("Title  :");
		
		ti = new JTextField();
		ti.setColumns(10);
		
		JLabel lblDescription = new JLabel("Description :");
		
		JTextArea ds = new JTextArea();
		
		JButton btnRply = new JButton("Respond");
		btnRply.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(uapp.isSelected())
				{ProblemDiscussion ps=new ProblemDiscussion();
				java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
				ps.setDate(date);
				ps.setTitle(ti.getText());
				ps.setDescription(ds.getText());
				ps.setProblem(problem);
				ps.setUser(user);
				ps.setSender("Relations responsible");
				GestionProblemDisDelegate.doaddProblem(ps);
				problemDiss=GestionProblemDisDelegate.dofindProblemDiscussionById(problem);
				initDataBindings();}
				if(uemail.isSelected()){
					
					
					mail.setMailAddressRecipient(user.getEmail());
			        mail.setPwd("onlygodcandefeatme699");
			        mail.setMailAddressSender("mhdzenati");
			        mail.setMailSubject(ti.getText());
			        String[] lines = ds.getText().split("\\n");
			        String msg="";
			        for(String s:lines){
			            msg = msg+s;
			        }
			        mail.setMailObject(msg);
			        //System.out.println(jTextArearObject.getToolTipText());
			        
			        MailConstruction mc = new MailConstruction();
			        mc.getMailProperties();
			        
			        String s = this.cleanUrl(url);
			        mc.getMailMessage(s, mail);
			        mc.SendMessage();
				}
				
			}

			public String cleanUrl(URL url){
		        
		        String s = url.toString();
		        System.out.println("Before Clean");
		        System.out.println(s);
		        String delims = "/";
		        String[] tokens = s.split(delims);
		        System.out.println("After Clean");
		        String mailPart="";
		        for (int i=1;i<tokens.length;i++){
		            mailPart+=tokens[i]+"\\\\";
		        }
		        System.out.println(mailPart);
		        return mailPart;
		    }
		
		});
		
		
		
		JButton btnMailRecipient = new JButton("Mail recipient");
		btnMailRecipient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 JFileChooser chooser = new JFileChooser();
			        int option = chooser.showOpenDialog(null);
			        if(option == JFileChooser.APPROVE_OPTION){
			            try{
			                url = chooser.getSelectedFile().toURL();
			                System.out.println(url);
			               // jLabelpieceJointe.setText(url.toString());
			               
			            }
			            catch(MalformedURLException exception){
			                System.out.println("The URL was malformed ... ");
			              
			            }
			        }
				
			}
		});
		
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(btnRply)
							.addGap(49)
							.addComponent(uapp)
							.addGap(51)
							.addComponent(uemail, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnMailRecipient))
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblDescription)
								.addComponent(lblTitle))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
								.addComponent(ti)
								.addComponent(ds, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE))))
					.addContainerGap(23, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTitle)
						.addComponent(ti, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(ds, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDescription))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(uapp)
						.addComponent(btnRply)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(uemail)
							.addComponent(btnMailRecipient)))
					.addGap(18))
		);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
		initDataBindings();
	}
	
	
	protected void initDataBindings() {
		JTableBinding<ProblemDiscussion, List<ProblemDiscussion>, JTable> jTableBinding = SwingBindings.createJTableBinding(UpdateStrategy.READ, problemDiss, table);
		//
		BeanProperty<ProblemDiscussion, String> problemDiscussionBeanProperty = BeanProperty.create("sender");
		jTableBinding.addColumnBinding(problemDiscussionBeanProperty).setColumnName("Sender");
		//
		BeanProperty<ProblemDiscussion, String> problemDiscussionBeanProperty_1 = BeanProperty.create("title");
		jTableBinding.addColumnBinding(problemDiscussionBeanProperty_1).setColumnName("Title");
		//
		BeanProperty<ProblemDiscussion, String> problemDiscussionBeanProperty_2 = BeanProperty.create("description");
		jTableBinding.addColumnBinding(problemDiscussionBeanProperty_2).setColumnName("Description");
		//
		BeanProperty<ProblemDiscussion, Date> problemDiscussionBeanProperty_3 = BeanProperty.create("date");
		jTableBinding.addColumnBinding(problemDiscussionBeanProperty_3).setColumnName("Date");
		//
		jTableBinding.bind();
	}
}
