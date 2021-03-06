/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;
import bus.ticket.reservation.system.Home;
import java.sql.*;
import java.util.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Avishek Saha
 */
public class g_search_details extends javax.swing.JFrame {

    private String fm;
    private String to;
    private String jDate;
    public g_search_details(String fm,String to, String jDate) {
        this.fm=fm;
        this.to=to;
        this.jDate=jDate;
        initComponents();
        searchBuses();
    }

    public Connection getConnection()
   {
       Connection con;
       try {
           con = DriverManager.getConnection("jdbc:mysql://localhost:3306/btrs", "root","");
           return con;
       } catch (Exception e) {
           e.printStackTrace();
           return null;
       }
   }
    
     public ArrayList<Bus> getBus(){ 
	
		ArrayList<Bus> buses	= new ArrayList<Bus>();
		Connection con = getConnection();
		
		Statement stat;
		ResultSet rs;
		Bus b;
                
              
	
	try{
		stat = con.createStatement();
		String sql="select * from bus_details where source ='"+fm+"' and destination = '"+to+"' and date = '"+jDate+"' ";
		rs= stat.executeQuery(sql);
		
		while(rs.next()){
			
			b = new Bus(
			      rs.getInt("id"),
				  rs.getString("name"),
				  rs.getString("source"),
				  rs.getString("destination"),
				  rs.getString("type"),
				  rs.getString("departure"),
				  rs.getString("arrival"),
				  rs.getInt("seats_available"),
				  rs.getInt("fare"),
                                rs.getString("date")
			);
			
			buses.add(b);
		}
	}
	catch (Exception e) {
            e.printStackTrace();          
        }
		
	
	return buses;
}
     
      public void searchBuses()
    {
        ArrayList<Bus> list = getBus();
        DefaultTableModel model = (DefaultTableModel)table_g_search_details.getModel();
        
        Object[] row = new Object[8];
       for(int i = 0; i < list.size(); i++)
       {
           //row[0] = list.get(i).getId();
             row[0] = list.get(i).getName();
              row[1] = list.get(i).getSource();
               row[2] = list.get(i).getDestination();
	        row[3] = list.get(i).getType();
	         row[4] = list.get(i).getDeparture();
		  row[5] = list.get(i).getArrival();
		   row[6] = list.get(i).getSeatsAvailable();
				    row[7] = list.get(i).getFare();
           
           model.addRow(row);
       }
    }
     
     
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_g_search_details = new javax.swing.JTable();
        b_backHome = new javax.swing.JButton();
        l_info = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 153, 51));

        jPanel1.setBackground(new java.awt.Color(51, 153, 0));
        jPanel1.setForeground(new java.awt.Color(204, 51, 0));

        table_g_search_details.setBackground(new java.awt.Color(153, 255, 153));
        table_g_search_details.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Bus Name", "Source", "Destination", "Type", "Departure", "Arrival", "Seats Avaiable", "Fare"
            }
        ));
        jScrollPane1.setViewportView(table_g_search_details);

        b_backHome.setBackground(new java.awt.Color(51, 255, 204));
        b_backHome.setText("Back To Home");
        b_backHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_backHomeActionPerformed(evt);
            }
        });

        l_info.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        l_info.setForeground(new java.awt.Color(204, 204, 204));
        l_info.setText("You have to Login to book seats");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 853, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(294, 294, 294)
                        .addComponent(b_backHome, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(275, 275, 275)
                        .addComponent(l_info, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(l_info, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(b_backHome, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void b_backHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_backHomeActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        Home obj = new Home();
    }//GEN-LAST:event_b_backHomeActionPerformed

    /**
     * @param args the command line arguments
     */
   /* public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
    /*    try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(g_search_details.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(g_search_details.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(g_search_details.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(g_search_details.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
       
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b_backHome;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel l_info;
    private javax.swing.JTable table_g_search_details;
    // End of variables declaration//GEN-END:variables
}
