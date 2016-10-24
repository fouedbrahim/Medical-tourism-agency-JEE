package ttma.client.GUI;

import java.awt.geom.Area;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.TitledBorder;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;















import org.jdesktop.beansbinding.ObjectProperty;
import org.jdesktop.beansbinding.AutoBinding;
import org.jdesktop.beansbinding.Bindings;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;



import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;
import org.jdesktop.beansbinding.BeanProperty;

import ttma.Entities.Evenement;
import ttma.client.delegate.EventDelegate;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import java.awt.Image;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import javax.swing.ImageIcon;

public class EventManage extends JPanel {
	List<Evenement> evenements;
	private JTable table;
	private JTextField nm;
	private JTextField pl;
	private JTextField pn;
	private JTextField price;

	/**
	 * Create the panel.
	 */
	public EventManage() {
		evenements = new ArrayList<Evenement>();
		evenements= EventDelegate.findAll();
		table = new JTable();
		JPanel panel = new JPanel();
		panel.setBounds(291, 235, 632, 588);
		panel.setBorder(new TitledBorder(null, "Manage Event", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(16, 29, 541, 60);
		scrollPane.setViewportView(table);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(25, 127, 30, 13);
		lblName.setFont(new Font("Times New Roman", Font.BOLD, 11));
		
		JLabel lblPlace = new JLabel("place");
		lblPlace.setBounds(25, 154, 30, 14);
		lblPlace.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblParticipantsNumber = new JLabel("participant's number");
		lblParticipantsNumber.setBounds(25, 184, 118, 14);
		lblParticipantsNumber.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		nm = new JTextField();
		nm.setBounds(327, 123, 116, 22);
		nm.setColumns(10);
		
		pl = new JTextField();
		pl.setBounds(327, 151, 116, 22);
		pl.setColumns(10);
		
		pn = new JTextField();
		pn.setBounds(327, 181, 116, 22);
		pn.setColumns(10);
		
		JLabel lblProgram = new JLabel("program");
		lblProgram.setBounds(25, 245, 118, 14);
		lblProgram.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JTextArea pr = new JTextArea();
		pr.setBounds(255, 244, 188, 97);
		
		JButton btnDelete = new JButton("delete");
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnDelete.setBounds(28, 505, 128, 41);
		btnDelete.setIcon(new ImageIcon("C:\\images\\32x32\\delete.png"));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Evenement evenement=new Evenement();
				evenement =evenements.get(table.getSelectedRow());
				if (EventDelegate.deleteEvenement(evenement)){
				 
				evenements= EventDelegate.findAll();
				nm.setText("");
				pl.setText("");
			//	dt.setText("");
				price.setText("");
				pn.setText("");
				price.setText("");
				pr.setText("");
				JOptionPane.showMessageDialog(null, "Deleted");
				
				initDataBindings();
				}	
			}
			
			
		});
		
		JButton btnUpdate = new JButton("update");
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnUpdate.setBounds(255, 500, 128, 33);
		btnUpdate.setIcon(new ImageIcon("C:\\images\\32x32\\up.png"));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Evenement evenement=new Evenement();
				evenement =evenements.get(table.getSelectedRow());
				evenement.setName_event(nm.getText());
				evenement.setPlace_event(pl.getText());
				//evenement.setDate_event(new Date());
				evenement.setProgram(pr.getText());
				evenement.setPrice(Float.parseFloat(price.getText()));
				
				if(EventDelegate.updateEvenement(evenement)){
					JOptionPane.showMessageDialog(null, "Done");
					nm.setText("");
					pl.setText("");
					//dt.setText("");
					price.setText("");
					pn.setText("");
					price.setText("");
					pr.setText("");
					evenements= EventDelegate.findAll();
					initDataBindings();
				}
			}
		});
		
		price = new JTextField();
		price.setBounds(327, 209, 116, 22);
		price.setColumns(10);
		
		JLabel lblPrice = new JLabel("price");
		lblPrice.setBounds(25, 212, 28, 14);
		lblPrice.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel image = new JLabel("");
		image.setBounds(25, 402, 0, 0);
		
		JLabel lblPhoto = new JLabel("Photo");
		lblPhoto.setBounds(25, 377, 118, 14);
		lblPhoto.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JButton btnPdf = new JButton("Pdf");
		btnPdf.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnPdf.setIcon(new ImageIcon("C:\\images\\32x32\\print.png"));
		btnPdf.setBounds(153, 449, 116, 33);
		btnPdf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String browse= nm.getText();
				String browse1= pl.getText();
				String browse2= price.getText();
				String browse3= pn.getText();
			//	String browse4= pr.getText();
			        Document doc = new Document();
			         try {
			                PdfWriter writer=PdfWriter.getInstance(doc,new FileOutputStream(browse+".pdf"));
			            } catch (FileNotFoundException ex) {
			              // Logger.getLogger(ListStopover.class.getName()).log(Level.SEVERE, null, ex);
			            } catch (DocumentException ex) {
			          //  Logger.getLogger(ListStopover.class.getName()).log(Level.SEVERE, null, ex);
			        }
			        
			        
			        // String text = @"The result can be seen below, which shows that ";
			        String i=(String) table.getValueAt(table.getSelectedRow(),0).toString();
	                String j=(String) table.getValueAt(table.getSelectedRow(),1).toString();
		            String d=(String) table.getValueAt(table.getSelectedRow(),2).toString();			        String f=(String) table.getValueAt(table.getSelectedRow(),3).toString();			        String h=(String) table.getValueAt(table.getSelectedRow(),4).toString();
     		        String g=(String) table.getValueAt(table.getSelectedRow(),3).toString();
			        try{
			            doc.open();
			           
		            doc.add(new Paragraph("Name :\t"+ table.getValueAt(table.getSelectedRow(),0).toString()));
		            doc.add(new Paragraph("Place :\t"+ table.getValueAt(table.getSelectedRow(),1).toString()));
		            doc.add(new Paragraph("Price :\t"+ table.getValueAt(table.getSelectedRow(),2).toString()));
		            doc.add(new Paragraph("participant's number:\t"+ table.getValueAt(table.getSelectedRow(),3).toString()));
//			            doc.add(new Paragraph("Program :\t"+ table.getValueAt(table.getSelectedRow(),4).toString()));
		            doc.close();
			            JOptionPane.showMessageDialog(null, "bien export�");
			        }
			        
			        catch(Exception e1){
			            
			        	JOptionPane.showMessageDialog(null, "Done");
			            
		        }
//					
//					
					
				
			}
			
		});
		
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Evenement evenement=new Evenement();
				evenement =evenements.get(table.getSelectedRow());
				//////
				ImageIcon format=null;
			     format=new ImageIcon(evenement.getImage());
			    Image img = format.getImage();
			    Image newimg = img.getScaledInstance(352, 216,  java.awt.Image.SCALE_SMOOTH);
			    ImageIcon newIcon=null;
			    newIcon = new ImageIcon(newimg);
			     image.setIcon(newIcon);
				///////
				nm.setText(evenement.getName_event());
				pl.setText(evenement.getPlace_event());
				//dt.getText(evenement.getDate_event(());
				pr.setText(evenement.getProgram());
				price.setText(Float.toString(evenement.getPrice()));
				pn.setText(evenement.getNbr_participants().toString());
			}
		});
		panel.setLayout(null);
		panel.add(scrollPane);
		panel.add(lblName);
		panel.add(nm);
		panel.add(lblPlace);
		panel.add(pl);
		panel.add(lblParticipantsNumber);
		panel.add(pn);
		panel.add(lblPrice);
		panel.add(price);
		panel.add(lblProgram);
		panel.add(pr);
		panel.add(lblPhoto);
		panel.add(image);
		panel.add(btnPdf);
		panel.add(btnDelete);
		panel.add(btnUpdate);
		setLayout(null);
		add(panel);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\images\\bg f.png"));
		lblNewLabel.setBounds(12, 0, 1410, 900);
		add(lblNewLabel);
		initDataBindings();

	}
	protected void initDataBindings() {
		JTableBinding<Evenement, List<Evenement>, JTable> jTableBinding = SwingBindings.createJTableBinding(UpdateStrategy.READ, evenements, table);
		//
		BeanProperty<Evenement, Integer> evenementBeanProperty = BeanProperty.create("ID_event");
		jTableBinding.addColumnBinding(evenementBeanProperty).setColumnName("ID");
		//
		BeanProperty<Evenement, String> evenementBeanProperty_1 = BeanProperty.create("name_event");
		jTableBinding.addColumnBinding(evenementBeanProperty_1).setColumnName("Event name");
		//
		BeanProperty<Evenement, String> evenementBeanProperty_2 = BeanProperty.create("place_event");
		jTableBinding.addColumnBinding(evenementBeanProperty_2).setColumnName("Place event");
		//
		
		BeanProperty<Evenement, String> evenementBeanProperty_3 = BeanProperty.create("price");
		jTableBinding.addColumnBinding(evenementBeanProperty_3).setColumnName("Price");
		//
		BeanProperty<Evenement, String> evenementBeanProperty_4 = BeanProperty.create("nbr_participants");
		jTableBinding.addColumnBinding(evenementBeanProperty_4).setColumnName("Participant's number");
		//
		jTableBinding.bind();
	}
}
