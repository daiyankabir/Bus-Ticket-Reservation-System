/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bus.ticket.reservation.system;
import database.bus_details;
import database.profile;

import database.save;
import database.search_details;
import java.awt.event.*;
import java.awt.*;  
import javax.swing.*; 

/**
 *
 * @author Avishek Saha
 */
public class adminHome {
    save s;
   
   public adminHome(save s){
       this.s=s;
       
		JFrame f=new JFrame("Admin"); 

f.addWindowFocusListener(new WindowAdapter() {
    public void windowGainedFocus(WindowEvent e) {
        f.requestFocusInWindow();
    }
});

JButton b_search=new JButton("SEARCH"); 
JLabel l_from=new JLabel("FROM");  
JLabel l_to=new JLabel("TO");  
JLabel l_doj=new JLabel("JOURNEY DATE");
JLabel l_info=new JLabel("dd/mm/yyyy");
JButton b_logout=new JButton("Log Out");
JButton b_profile=new JButton("My Profile");
JButton b_busDetails=new JButton("ADD/UPDATE/DELETE Bus Details");
JButton b_customerDetails=new JButton("UPDATE/DELETE Bus Details");

JTextField t_doj=new JTextField();  

String sourceList[]={"Bogura","Chattogram","Coxs Bazar","Cumilla","Dhaka","Feni","Jashore","Tangail",};        
     JComboBox CB_source=new JComboBox(sourceList);    
	
String destinationList[]={"Bogura","Chattogram","Coxs Bazar","Cumilla","Dhaka","Feni","Jashore","Tangail",};        
     JComboBox CB_destination=new JComboBox(destinationList);    

b_logout.setBounds(650,20,100, 40);//x axis, y axis, width, height
b_profile.setBounds(530,20,100, 40);	
b_search.setBounds(200,135,100, 40); 
b_busDetails.setBounds(500,70,230,40);
b_customerDetails.setBounds(500,120,230,40);
l_from.setBounds(20,20, 50,40); 
l_to.setBounds(260,20, 50,40); 
l_doj.setBounds(110,85,120, 40);
t_doj.setBounds(250,85,100,40);
l_info.setBounds(360,85,100,40);
CB_source.setBounds(80,20,150,40);
CB_destination.setBounds(310,20,150,40);

 b_profile.addActionListener(new ActionListener()
	{
		public void actionPerformed(ActionEvent e) 
		{
	f.setVisible(false);
	myProfile profile = new myProfile(s);
		}
	}); 


b_search.addActionListener(new ActionListener()
	{
		public void actionPerformed(ActionEvent e) 
		{
                    if (isNullOrEmpty(t_doj.getText())){
            JOptionPane.showMessageDialog(null, "Enter Journey Date","OK",JOptionPane.INFORMATION_MESSAGE);
        }
                    
                    else{           
	f.setVisible(false);
	java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new search_details(s,CB_source.getSelectedItem().toString(),CB_destination.getSelectedItem().toString(),t_doj.getText()).setVisible(true);
            }
        });
                    }
		}
	}); 

b_busDetails.addActionListener(new ActionListener()
	{
		public void actionPerformed(ActionEvent e) 
		{
	f.setVisible(false);
	java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new bus_details(s).setVisible(true);
            }
        });
		}
	});

b_logout.addActionListener(new ActionListener()
	{
		public void actionPerformed(ActionEvent e) 
		{
	f.setVisible(false);
	Home obj = new Home();
		}
	});

f.add(b_search);
f.add(l_from);
f.add(l_to);
f.add(l_doj);
f.add(l_info);
f.add(t_doj);
f.add(CB_source);
f.add(CB_destination);
f.add(b_logout);
f.add(b_profile);
f.add(b_busDetails);
f.add(b_customerDetails);
          
f.setSize(800,800); 

f.setLayout(null);
f.setVisible(true);
f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	

	} 
   public static boolean isNullOrEmpty(String str) {
        if(str != null && !str.trim().isEmpty())
            return false;
        return true;  
}
}
