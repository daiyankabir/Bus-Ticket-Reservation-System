/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bus.ticket.reservation.system;
import java.awt.event.*;
import java.awt.*;  
import javax.swing.*; 
/**
 *
 * @author Avishek Saha
 */
public class printTicket {
    public printTicket(String username, String busID, String jDate, String seats,String tFare, String bname,String source,String destination,String type,String departure,String arrival){
    JFrame f=new JFrame("Print Ticket");
		
		f.addWindowFocusListener(new WindowAdapter() {
    public void windowGainedFocus(WindowEvent e) {
        f.requestFocusInWindow();
    }
});
                
     JLabel l_username=new JLabel("Username :-");  
    l_username.setBounds(70,50, 100,30);
     JLabel p_username=new JLabel(username);  
    p_username.setBounds(180,50, 100,30);
    
    JLabel l_jDate=new JLabel("Journey Date :-");  
    l_jDate.setBounds(310,50, 100,30);
    JLabel p_jDate=new JLabel(jDate);  
    p_jDate.setBounds(420,50, 100,30);
    
    JLabel l_busID=new JLabel("Bus ID :-");  
    l_busID.setBounds(70,100, 100,30);
    JLabel p_busID=new JLabel(busID);  
    p_busID.setBounds(180,100, 100,30);
    
    JLabel l_bname=new JLabel("Bus Name :-");  
    l_bname.setBounds(310,100, 100,30);
      JLabel p_bname=new JLabel(bname);  
    p_bname.setBounds(420,100, 100,30);
    
    JLabel l_source=new JLabel("Source :-");  
    l_source.setBounds(70,150, 100,30);
    JLabel p_source=new JLabel(source);  
    p_source.setBounds(180,150, 100,30);
    
    JLabel l_destination=new JLabel("Destination :-");  
    l_destination.setBounds(310,150, 100,30);
    JLabel p_destination=new JLabel(destination);  
    p_destination.setBounds(420,150, 100,30);
    
    JLabel l_type=new JLabel("Type :-");  
    l_type.setBounds(70,200, 100,30);
    JLabel p_type=new JLabel(type);  
    p_type.setBounds(180,200, 100,30);
    
    JLabel l_seats=new JLabel("Seats :-");  
    l_seats.setBounds(310,200, 100,30);
    JLabel p_seats=new JLabel(seats);  
    p_seats.setBounds(420,200, 100,30);
    
    JLabel l_fare=new JLabel("Total Fare :-");  
    l_fare.setBounds(70,250, 100,30);
    JLabel p_fare=new JLabel(tFare);  
    p_fare.setBounds(180,250, 100,30);
    
    
    
    JButton b_ok=new JButton("OK");
	b_ok.setBounds(190,350,100,40);
        
    b_ok.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                f.setVisible(false);
              Home obj =new  Home();
            }
        });
    
    
    
    f.add(l_username); f.add(p_username); f.add(l_jDate); f.add(p_jDate); f.add(l_busID); f.add(p_busID); f.add(l_bname); f.add(p_bname);
    f.add(l_source);f.add(p_source);f.add(l_destination);f.add(p_destination);f.add(l_type);f.add(p_type);f.add(l_seats);
    f.add(p_seats); f.add(l_fare); f.add(p_fare); f.add(b_ok);
    
    
    
f.setSize(800,600);
f.setLayout(null);
f.setVisible(true);
f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
}
