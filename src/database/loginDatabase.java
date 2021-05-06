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
public class loginDatabase {
    Connection con;
	Statement stat;
	ResultSet rs;
	public loginDatabase(){
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
	
	public Boolean checkLogin(String uname,String pwd)
    {
        try {        
			 
			String sql= "select * from user where number='"+uname+"' and password='"+pwd+"'"; 	
    
            rs=stat.executeQuery(sql);
            if(rs.next())
            {
                return true;
            }
            else
            {
                return false;
            }
        } catch (Exception e) {
            System.out.println("error while validating: "+e);
            return false;
        }
}
}
