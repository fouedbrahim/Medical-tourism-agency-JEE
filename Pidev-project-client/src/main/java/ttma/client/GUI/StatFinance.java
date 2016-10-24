/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ttma.client.GUI;

/**
 *
 * @author admin
 */
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel; 
import org.jfree.chart.JFreeChart; 
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset; 
import org.jfree.data.category.DefaultCategoryDataset; 
import org.jfree.ui.ApplicationFrame; 
import org.jfree.ui.RefineryUtilities; 

public class StatFinance extends ApplicationFrame
{
   public StatFinance( String applicationTitle , String chartTitle,String mois,String Anne )
   {
      super( applicationTitle );        
      JFreeChart barChart = ChartFactory.createBarChart(
         chartTitle+" " +mois+" "+Anne,           
         "Category",            
         "TND",            
         createDataset(),          
         PlotOrientation.VERTICAL,           
         true, true, false);
         
      ChartPanel chartPanel = new ChartPanel( barChart );        
      chartPanel.setPreferredSize(new java.awt.Dimension( 700 , 400 ) );        
      setContentPane( chartPanel ); 
   }
   private static CategoryDataset createDataset( )
   {
      final String expenses = "EXPENSES";        
      final String incomes = "INCOMES";        
            
      final String hotels = "Hotels";        
      final String events = "Events";        
      final String pub = "Publicity";        
      final String trans = "Transoport"; 
      final String sal = "Salaries";
      final String cl = "Clinics";
      final DefaultCategoryDataset dataset = 
      new DefaultCategoryDataset( );  
      double he =100 + (int)(Math.random() * ((8000 - 100) + 1));
      double ee =100 + (int)(Math.random() * ((8000 - 100) + 1));
      double pe =100 + (int)(Math.random() * ((8000 - 100) + 1));
      double te =100 + (int)(Math.random() * ((8000 - 100) + 1));
      double se =100 + (int)(Math.random() * ((8000 - 100) + 1));
      double ce =100 + (int)(Math.random() * ((8000 - 100) + 1));
      
      int hi =100 + (int)(Math.random() * ((8000 - 100) + 1));
      int ei =100 + (int)(Math.random() * ((8000 - 100) + 1));
      
      int ti =100 + (int)(Math.random() * ((8000 - 100) + 1));
     
      int ci =100 + (int)(Math.random() * ((8000 - 100) + 1));
      
      dataset.addValue(he, expenses,hotels);
      dataset.addValue( ee, expenses,events);        
      dataset.addValue( pe, expenses,pub );        
      dataset.addValue(te, expenses,trans ); 
      dataset.addValue( se, expenses,sal );           
      dataset.addValue( ce, expenses,cl); 
      
      
        dataset.addValue( hi , incomes , hotels );        
      dataset.addValue( ei , incomes , events );        
      dataset.addValue( 0.1 , incomes , pub ); 
      dataset.addValue(  ti, incomes , trans );           
      dataset.addValue( 0.1 , incomes , sal ); 
      dataset.addValue( ci , incomes , cl );
                 

      return dataset; 
   }
   public static void main( String[ ] args )
   {
      StatFinance chart = new StatFinance("Incomes & expenses", "TTMA Incomes & expenses","Month","year");
      chart.pack( );        
      RefineryUtilities.centerFrameOnScreen( chart );        
      chart.setVisible( true ); 
   }
}