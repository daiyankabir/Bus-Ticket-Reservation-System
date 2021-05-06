/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;
import java.sql.*;

/**
 *
 * @author Avishek Saha
 */
public class signupDatabase {
    Connection con;
	Statement stat;
	public signupDatabase()
    {
		
        try{
			Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/btrs","root","");
               stat=con.createStatement();
           }
        catch (Exception ae) 
        {
            System.out.println("error while connecting: "+ae);
        }
    }
	
    public void signup(String name,String number,String email,String dob,String gender,String password)
    {
        try {        
	    String sql= "insert into user (name,number,email,dob,gender,password) VALUES ('"+name+"','"+number+"','"+email+"','"+dob+"','"+gender+"','"+password+"')";		
            stat.executeUpdate(sql);
        } catch (Exception e) {
            
            System.out.println("error while insrting: "+e);           
        }
}
}
