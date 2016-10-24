package ttma.client.GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;








import ttma.Entities.Publicity;
import ttma.client.delegate.GestionPublicityDelegate;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.BeanProperty;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;

public class ManagePublicityy extends JFrame {

	private JPanel contentPane;
	private JTextField tt;
	List <Publicity> publicities;
	Publicity publicity ;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManagePublicityy frame = new ManagePublicityy();
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
	public ManagePublicityy() {
		JTextArea dd = new JTextArea();
		publicities=new ArrayList<Publicity>();
		publicities=GestionPublicityDelegate.dofindAllPublicity();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1300, 900);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		
		JButton btnNewButton = new JButton("home");
		btnNewButton.setIcon(new ImageIcon("C:\\images\\32x32\\home.png"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ILogisticResponsible t =new ILogisticResponsible();
				t.setVisible(true);
			}
		});
		btnNewButton.setBounds(59, 182, 124, 41);
		panel.add(btnNewButton);
		
		JLabel lblDescription = new JLabel("Description :");
		lblDescription.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblDescription.setBounds(343, 388, 91, 23);
		panel.add(lblDescription);
		
		JLabel lblTitle = new JLabel("Title :");
		lblTitle.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblTitle.setBounds(343, 317, 73, 23);
		panel.add(lblTitle);
		
		JLabel imgg = new JLabel("");
		imgg.setBounds(446, 531, 773, 207);
		panel.add(imgg);
		JLabel pathh = new JLabel("");
		
		
		pathh.setBounds(424, 480, 231, 23);
		panel.add(pathh);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(322, 167, 650, 121);
		panel.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				publicity=publicities.get(table.getSelectedRow());
				tt.setText(publicity.getPublicityTitle());
				dd.setText(publicity.getPublicityDescription());
				
				ImageIcon format=null;
			     format=new ImageIcon(publicity.getPublicityImage());
			    Image img = format.getImage();
			    Image newimg = img.getScaledInstance(310, 100,  java.awt.Image.SCALE_SMOOTH);
			    ImageIcon newIcon=null;
			    newIcon = new ImageIcon(newimg);
			     imgg.setIcon(newIcon);
			}
		});
		scrollPane.setColumnHeaderView(table);
		
		dd.setBounds(456, 378, 452, 71);
		panel.add(dd);
		
		tt = new JTextField();
		tt.setBounds(462, 313, 193, 33);
		panel.add(tt);
		tt.setColumns(10);
		
		
		panel.setBounds(0, 0, 1284, 749);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnChooseImage = new JButton("choose image");
		btnChooseImage.setIcon(new ImageIcon("C:\\images\\32x32\\image.png"));
		btnChooseImage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JFileChooser chooser=new JFileChooser();
				 chooser.showOpenDialog(null);
			     File f=chooser.getSelectedFile();
			     String filename =f.getAbsolutePath();
			     pathh.setText(filename);
			}
		});
		btnChooseImage.setBounds(241, 470, 149, 41);
		panel.add(btnChooseImage);
		
		JButton btnadd = new JButton("ADD");
		btnadd.setIcon(new ImageIcon("C:\\images\\32x32\\add.png"));
		btnadd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//function to transform a file to a byte[]
				 File file = new File(pathh.getText());
			       byte[] b = new byte[(int) file.length()];
			      try {
			               FileInputStream fileInputStream = new FileInputStream(file);
			            try {
			                fileInputStream.read(b);
			            } catch (IOException ex) {
			                Logger.getLogger(ManagePublicityy.class.getName()).log(Level.SEVERE, null, ex);
			            }
			               for (int i = 0; i < b.length; i++) {
			                           System.out.print((char)b[i]);
			                }
			          } catch (FileNotFoundException e1) {
			                      System.out.println("File Not Found.");
			                      e1.printStackTrace();}
				Publicity publicity=new Publicity();
				publicity.setPublicityDescription(dd.getText());
				publicity.setPublicityTitle(tt.getText());
				publicity.setPublicityImage(b);
				
				GestionPublicityDelegate.doaddPublicity(publicity);
				publicities=GestionPublicityDelegate.dofindAllPublicity();
				initDataBindings();
			}
		});
		btnadd.setBounds(241, 531, 149, 41);
		panel.add(btnadd);
		
		
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\images\\bg f.png"));
		lblNewLabel.setBounds(0, 0, 1284, 749);
		panel.add(lblNewLabel);
		initDataBindings();
		scrollPane.setViewportView(table);
	}

	protected void initDataBindings() {
		JTableBinding<Publicity, List<Publicity>, JTable> jTableBinding = SwingBindings.createJTableBinding(UpdateStrategy.READ, publicities, table);
		//
		BeanProperty<Publicity, String> publicityBeanProperty = BeanProperty.create("publicityTitle");
		jTableBinding.addColumnBinding(publicityBeanProperty).setColumnName("title");
		//
		BeanProperty<Publicity, String> publicityBeanProperty_1 = BeanProperty.create("publicityDescription");
		jTableBinding.addColumnBinding(publicityBeanProperty_1).setColumnName("description");
		//
		jTableBinding.bind();
	}
}
