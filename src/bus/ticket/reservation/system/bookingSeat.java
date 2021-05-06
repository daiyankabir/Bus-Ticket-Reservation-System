/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bus.ticket.reservation.system;
import database.bookingDatabase;
import database.save;
import java.awt.event.*;
import java.awt.*;  
import javax.swing.*; 

/**
 *
 * @author Avishek Saha
 */
public class bookingSeat {
    String t;
    String updateSeats;
    save s;
    String username;
    
    
    public bookingSeat(save s,String busID, String avaiableSeats, String jDate, String fare,String bname,String source,String destination,String type,String departure,String arrival){
        this.s=s;
        String username= s.getUname();
        JFrame f=new JFrame("BDBUS");
		
		f.addWindowFocusListener(new WindowAdapter() {
    public void windowGainedFocus(WindowEvent e) {
        f.requestFocusInWindow();
    }
});
                
                
        JLabel l_busID=new JLabel("Bus ID");  
    l_busID.setBounds(70,50, 100,30);
	JLabel l_jDate=new JLabel("Journey Date");  
    l_jDate.setBounds(70,100, 100,30);
	JLabel l_username=new JLabel("Username");  
    l_username.setBounds(70,150, 100,30);
	JLabel l_seats=new JLabel("Seats");  
    l_seats.setBounds(70,200, 100,30);
	JLabel l_tFare=new JLabel("Total Fare");  
    l_tFare.setBounds(70,250, 100,30);
    
	
	JLabel t_busID=new JLabel(busID);
	t_busID.setBounds(170,50,200,40);
	JLabel t_jDate=new JLabel(jDate);
	t_jDate.setBounds(170,100,200,40);
	JLabel p_username=new JLabel(username);
	p_username.setBounds(170,150,200,40);
	JTextField t_seats=new JTextField();
	t_seats.setBounds(170,200,70,30);
        
        JLabel l_seatNo = new JLabel("Seats No.");
        l_seatNo.setBounds(320,170,150,30);
        
        JTextField t_seatNo = new JTextField();
        t_seatNo.setBounds(320,210,150,30);
        
         JLabel l_stFare = new JLabel();
	l_stFare.setBounds(170,250,200,40);
        
	
	
	JButton b_confirm=new JButton("Confirm");
	b_confirm.setBounds(170,360,100,40);
        JButton b_tFare=new JButton("Total Fare");
	b_tFare.setBounds(380,250,100,30);
        JLabel l_info = new JLabel("Please press Total Fare before confirm");
	l_info.setBounds(350,280,250,30);
        JButton b_cancel=new JButton("Cancel");
        b_cancel.setBounds(170,430,100,30);
        
        
        b_tFare.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                int s = Integer.parseInt(t_seats.getText());
                int f = Integer.parseInt(fare);
                int tFare= s*f;
                t=Integer.toString(tFare);
               l_stFare.setText(t);
            }
        });
        
    
     b_confirm.addActionListener(new ActionListener()
    {
        public void actionPerformed(ActionEvent e) 
        {
            int as = Integer.parseInt(avaiableSeats);
            int s = Integer.parseInt(t_seats.getText());
            if(as>s){
            int upas = as - s;
            updateSeats = Integer.toString(upas);
            bookingDatabase book = new  bookingDatabase(p_username.getText(),t_busID.getText(),t_jDate.getText(),t_seats.getText(), t, updateSeats, bname, source, destination, type, departure, arrival);
            }
            else{
                JOptionPane.showMessageDialog(null, s+" Seats are not available","Ok",JOptionPane.INFORMATION_MESSAGE);
            }
            
        }
    }); 
   
    b_cancel.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                f.setVisible(false);
              Home obj =new  Home();
            }
        });
   
   
   f.add(l_busID);
   f.add(l_jDate);
   f.add(l_username);
   f.add(l_seats);
   f.add(l_tFare);
   f.add(t_busID);
   f.add(t_jDate);
   f.add(p_username);
   f.add(t_seats);
   f.add(l_stFare);
   f.add(b_confirm);
   f.add(b_tFare);
   f.add(b_cancel);
   f.add(l_info);
   f.add(l_seatNo);
    f.add(t_seatNo);
   
   
   f.setSize(800,600);
f.setLayout(null);
f.setVisible(true);
f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
        
    }
    
}
