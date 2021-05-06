/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bus.ticket.reservation.system;
import database.checkHomeDatabase;
import database.loginDatabase;
import database.save;
import java.awt.event.*;
import javax.swing.*; 

/**
 *
 * @author Avishek Saha
 */
public class Login {
    public Login(){
		JFrame f=new JFrame("BDBUS");
		
		f.addWindowFocusListener(new WindowAdapter() {
    public void windowGainedFocus(WindowEvent e) {
        f.requestFocusInWindow();
    }
});
		
		JLabel l_userName=new JLabel("Username");  
    l_userName.setBounds(70,50, 100,30); //x axis, y axis, width, height
	    JLabel l_pass=new JLabel("Password");  
    l_pass.setBounds(70,100, 100,30);
JLabel l_info=new JLabel("Put your phone number");
l_info.setBounds(410,50,150,40);
    
	JTextField t_userName=new JTextField();
		t_userName.setBounds(200,50, 200,40);
	JPasswordField t_pass = new JPasswordField();
		t_pass.setBounds(200,100, 200,40);
		
		JButton b_login=new JButton("LOGIN");
b_login.setBounds(280,300,100, 40);
 JButton b_back=new JButton("BACK");
b_back.setBounds(160,300,100, 40);
 
b_login.addActionListener(new ActionListener()
 {
        public void actionPerformed(ActionEvent e)
        {
             f.setVisible(false);
			 loginDatabase mydbObj=new loginDatabase();
			checkHomeDatabase obj=new checkHomeDatabase();
 
                String username= new String(t_userName.getText());
				String pwd=new String(t_pass.getPassword());
                  
				
				
                if(mydbObj.checkLogin(username, pwd))
                {
                         save s=new save(username, pwd);
                         
					
					if(obj.checkHome(username, pwd))
					{
						adminHome admin= new adminHome(s);
                                               
					}
					else
					{
						customerHome customer= new customerHome(s);
                                                
					}
					
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Login failed!","Failed!!",
                                        JOptionPane.ERROR_MESSAGE);
					Login log= new Login();
                }
        }
 }
		); 
 
 b_back.addActionListener(new ActionListener()
	{
		public void actionPerformed(ActionEvent e) 
		{
	f.setVisible(false);
	Home obj = new Home();
		}
	});
	
	f.add(b_login);
	f.add(b_back);
	f.add(l_userName);
	f.add(l_pass);
	f.add(t_userName);
	f.add(t_pass);
        f.add(l_info);
	
	f.setSize(800,600); 
	
f.setLayout(null);  
f.setVisible(true); 
f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
}
