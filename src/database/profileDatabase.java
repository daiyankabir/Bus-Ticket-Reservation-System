/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import bus.ticket.reservation.system.myProfile;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Avishek Saha
 */
public class profileDatabase {
    Connection con;
	Statement stat;
	ResultSet rs;
        save s;
	public profileDatabase(save s){
            this.s=s;
            String username= s.getUname();
        String password= s.getPass();    
       
		try{
			Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/btrs","root","");
               stat=con.createStatement();
           }
        catch (Exception ae) 
        {
            System.out.println("error while connecting: "+ae);
        }
	
    
        try {        
			 
	       String sql= "select * from user where number='"+username+"' and password='"+password+"'"; 	
    
            rs=stat.executeQuery(sql);
            while(rs.next()){
             String name = rs.getString("name");
             String number = rs.getString("number");
             String email = rs.getString("email");
             String dob = rs.getString("dob");
             String pass = rs.getString("password");
             
             profile p = new profile(name, number, email, dob, pass);
             showProfile sp = new showProfile(s ,p);
            }
            
        } catch (Exception e) {
          
            System.out.println("error while validating: "+e);
        }
}
        
    
}
