/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import bus.ticket.reservation.system.Login;
import bus.ticket.reservation.system.myProfile;
import java.sql.*;
import javax.swing.*;

/**
 *
 * @author Avishek Saha
 */
public class profileUpdate extends JFrame{
  Connection con;
	Statement stat;
	ResultSet rs;
        save s;
        String name;
        String number;
        String email;
        String dob;
        String pass;
        
	public profileUpdate(save s, String name, String number, String email, String dob, String pass){
            this.s=s;
            this.name=name;
            this.number=number;
            this.email=email;
            this.dob=dob;
            this.pass=pass;
               
       
		try{
			Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/btrs","root","");
               stat=con.createStatement();
           }
        catch (Exception ae) 
        {
            System.out.println("error while connecting: "+ae);
        }  
                
          
       
           try{
               
                String username= s.getUname();
        String password= s.getPass(); 
        
            String sql ="UPDATE `user` SET `name`='"+name+"',`number`='"+number+"',`email`='"+email+"',`dob`='"+dob+"',`password`='"+pass+"' WHERE number ='"+username+"' and password = '"+password+"'";
            stat.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Profile Updated","OK",JOptionPane.INFORMATION_MESSAGE);
            setVisible(false);
            Login update = new Login();
        }
        catch(Exception e){
            System.out.println("error while validating: "+e); 
        } 
        }
        
   
}



