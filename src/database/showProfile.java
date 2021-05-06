/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;
import bus.ticket.reservation.system.adminHome;
import bus.ticket.reservation.system.customerHome;
import java.awt.event.*;
//import java.awt.*;  
import javax.swing.*; 
/**
 *
 * @author Avishek Saha
 */
public class showProfile {
    save s;
    profile p;
    public showProfile(save s, profile p){
        this.s=s;
        this.p=p;
        String name = p.getName();
        String number = p.getNumber();
        String email = p.getEmail();
        String dob = p.getDate();
        String pass = p.getPassword();
        
           
        JFrame f=new JFrame("BDBUS");
		
		f.addWindowFocusListener(new WindowAdapter() {
    public void windowGainedFocus(WindowEvent e) {
        f.requestFocusInWindow();
    }
});

    JLabel l_name=new JLabel("Name");  
    l_name.setBounds(70,50, 100,30);
	JLabel l_phoneNumber=new JLabel("Phone Number");  
    l_phoneNumber.setBounds(70,100, 100,30);
	JLabel l_email=new JLabel("Email");  
    l_email.setBounds(70,150, 100,30);
	JLabel l_dob=new JLabel("Date of Birth");  
    l_dob.setBounds(70,200, 100,30);
	JLabel l_pass=new JLabel("Password");  
    l_pass.setBounds(70,250, 100,30);
	
	JTextField t_name=new JTextField(name);
	t_name.setBounds(170,50,200,40);
	JTextField t_phoneNumber=new JTextField(number);
	t_phoneNumber.setBounds(170,100,200,40);
	JTextField t_email=new JTextField(email);
	t_email.setBounds(170,150,200,40);
	JTextField t_dob=new JTextField(dob);
	t_dob.setBounds(170,200,200,40);
	
	JTextField t_pass = new JTextField(pass);
	t_pass.setBounds(170,250,200,40);
	
	JButton b_save=new JButton("SAVE");
	b_save.setBounds(170,360,70,30);
    JButton b_back=new JButton("BACK");
    b_back.setBounds(170,410,70,30);
    
    b_save.addActionListener(new ActionListener()
    {
        public void actionPerformed(ActionEvent e) 
        {
            profileUpdate update = new  profileUpdate(s,t_name.getText(),t_phoneNumber.getText(),t_email.getText(),t_dob.getText(),t_pass.getText());
            
        }
    });
	
	b_back.addActionListener(new ActionListener()
	{
		public void actionPerformed(ActionEvent e) 
		{
	f.setVisible(false);
        
	checkHomeDatabase obj = new checkHomeDatabase();
	
        String username = s.getUname();
        String password = s.getPass();
	
	if(obj.checkHome(username,password))
	{
		adminHome admin= new adminHome(s); 
	}
	else
	{
		 customerHome customer= new customerHome(s);
	}
}
	});
	
f.add(l_name);
f.add(l_phoneNumber);
f.add(l_email);
f.add(l_dob);
f.add(l_pass);	
f.add(t_name);
f.add(t_phoneNumber);
f.add(t_email);
f.add(t_dob);
f.add(t_pass);
f.add(b_save);
f.add(b_back);
	



f.setSize(800,600);
f.setLayout(null);
f.setVisible(true);
f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
      
   }
    }
    

