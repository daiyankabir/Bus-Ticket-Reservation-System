/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bus.ticket.reservation.system;
import database.signupDatabase;
import java.awt.event.*;
import javax.swing.*; 


/**
 *
 * @author Avishek Saha
 */
public class Signup {
  public Signup(){
		JFrame f=new JFrame("BDBUS");
		
		f.addWindowFocusListener(new WindowAdapter() {
    public void windowGainedFocus(WindowEvent e) {
        f.requestFocusInWindow();
    }
});
		
		JLabel l_name=new JLabel("Name");  
    l_name.setBounds(70,50, 100,30); //x axis, y axis, width, height
	    JLabel l_phoneNumber=new JLabel("Phone Number");  
    l_phoneNumber.setBounds(70,100, 100,30);
	    JLabel l_email=new JLabel("Email");  
    l_email.setBounds(70,150, 100,30);
		JLabel l_dob=new JLabel("Date of Birth");
	l_dob.setBounds(70,200,100,30);
		JLabel l_gender=new JLabel("Gernder");
	l_gender.setBounds(70,250,100,30);
		JLabel l_pass=new JLabel("Password");  
    l_pass.setBounds(70,300,100,30);
    JLabel l_info=new JLabel("dd/mm/yyyy");
    l_info.setBounds(380,200,100,40);



	JTextField t_name=new JTextField();
		t_name.setBounds(170,50,200,40);
	JTextField t_phoneNumber=new JTextField();
		t_phoneNumber.setBounds(170,100,200,40);
	JTextField t_email=new JTextField();
		t_email.setBounds(170,150,200,40);	
	JTextField t_dob=new JTextField(); 
		t_dob.setBounds(170,200,200,40);
		
	
		
        ButtonGroup genderGroup=new ButtonGroup();  
	JRadioButton male=new JRadioButton("Male");
	male.setBounds(170,250,80,40);
	male.setActionCommand( "male" );	
	JRadioButton female=new JRadioButton("Female");
	female.setBounds(260,250,100,40);
	female.setActionCommand( "female" );	
		genderGroup.add(male);
		genderGroup.add(female);
		
	JPasswordField t_pass = new JPasswordField();
		t_pass.setBounds(170,300,200,40);
		
	
		JButton b_signup=new JButton("SIGN UP");
 b_signup.setBounds(170,360,100,40);
 JButton b_back=new JButton("BACK");
 b_back.setBounds(170,410,100,40);
 
 
 b_signup.addActionListener(new ActionListener()
 {
        public void actionPerformed(ActionEvent e)
        {
             signupDatabase mydbObj=new signupDatabase();
	    
			 int length = String.valueOf(t_phoneNumber.getText()).length();
                String pwd=new String(t_pass.getPassword());
	if (isNullOrEmpty(t_name.getText())||isNullOrEmpty(t_phoneNumber.getText())||isNullOrEmpty(t_email.getText())||
	 isNullOrEmpty(t_dob.getText())|| isNullOrEmpty(genderGroup.getSelection().getActionCommand())|| isNullOrEmpty(pwd))
	 { 
   JOptionPane.showMessageDialog(null, "Please Enter All Values","Empty Field",JOptionPane.INFORMATION_MESSAGE);
	 }
	 
	 if(length!=11 )
	 {
		JOptionPane.showMessageDialog(null, "Incorrect phone number !","Wrong Number",JOptionPane.INFORMATION_MESSAGE); 
	 }
	 
	else
	{	
	mydbObj.signup(t_name.getText(), t_phoneNumber.getText(), t_email.getText(),t_dob.getText(), genderGroup.getSelection().getActionCommand(), pwd);
	 JOptionPane.showMessageDialog(null, "Registration Successful","Successful",JOptionPane.INFORMATION_MESSAGE);
         f.setVisible(false);
	 Login log=new Login();
	}

        }
 }		);
 
 
 b_back.addActionListener(new ActionListener()
	{
		public void actionPerformed(ActionEvent e) 
		{
	f.setVisible(false);
	Home obj = new Home();
		}
	});
	
f.add(l_name);
f.add(l_phoneNumber);
f.add(l_email);
f.add(l_dob);
f.add(l_gender);
f.add(l_pass);	
f.add(t_name);
f.add(t_phoneNumber);
f.add(t_email);
f.add(t_dob);
f.add(l_info);
f.add(male);
f.add(female);
f.add(t_pass);
f.add(b_signup);
f.add(b_back);
	



f.setSize(800,600);
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
