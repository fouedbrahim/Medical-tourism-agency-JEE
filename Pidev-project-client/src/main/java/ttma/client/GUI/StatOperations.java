/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ttma.client.GUI;


import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import java.awt.BorderLayout;
import javax.swing.JButton;

/**
 *
 * @author Foued ben brahim
 */

    


public class  StatOperations extends ApplicationFrame  {
    
   
   //public StatPresence() {}

    public StatOperations( String title ) 
   {
      super( title );
      setContentPane(createDemoPanel( ));
   }
   private static PieDataset createDataset( ) 
   {  int i =100 + (int)(Math.random() * ((2000 - 100) + 1));
   int i1 =100 + (int)(Math.random() * ((2000 - 100) + 1));
   int i2 =100 + (int)(Math.random() * ((2000 - 100) + 1));
   int i3 =100 + (int)(Math.random() * ((2000 - 100) + 1));
   int i4 =100 + (int)(Math.random() * ((2000 - 100) + 1));
   int i5 =100 + (int)(Math.random() * ((2000 - 100) + 1));
      DefaultPieDataset dataset = new DefaultPieDataset();
       // GestionConge g = new GestionConge();
      //dataset.setValue( "  CONGE ACCEPTE   :  '"+g.countCongeAccpte()+"'" ,g.countCongeAccpte());  
      //dataset.setValue( " CONGE REFUSE   :  '"+g.countCongeRefuse()+"'"  ,g.countCongeRefuse() );   
      //dataset.setValue( "  CONGE SANS REPONSE   :  '"+g.countCongeSansRep()+"'" ,g.countCongeSansRep());  
      dataset.setValue( "  Face Surgery   :" ,i);  
      dataset.setValue( "  Breast Surgery   :  "  ,i1 );   
      dataset.setValue( "  Surgery teeth   " ,i2);  
      dataset.setValue( "  Surgery plastic  " ,i3);  
      dataset.setValue( "  intimate Surgery  " ,i4);  
      dataset.setValue( "  gastric Band  " ,i5);  
    
      
    
      return dataset;         
   }
   private static JFreeChart createChart( PieDataset dataset )
   {
      JFreeChart chart = ChartFactory.createPieChart(      
         "Statistique des operations reserv�",  // chart title 
         dataset,        // data    
         true,           // include legend   
         true, 
         false);

      return chart;
   }
   public static JPanel createDemoPanel( )
   {
      JFreeChart chart = createChart(createDataset( ) );  
      return new ChartPanel( chart ); 
   }
   public static void main( String[ ] args )
   {
   StatOperations dem = new StatOperations("Statistique des operations reserv�" );  
      dem.setSize( 560 , 367 );    
      RefineryUtilities.centerFrameOnScreen( dem );    
      dem.setVisible( true ); 
   }

    
    
}