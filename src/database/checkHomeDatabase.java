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
public class checkHomeDatabase {
    Connection con;
	Statement stat;
	ResultSet rs;
	public checkHomeDatabase(){
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
	
	public Boolean checkHome(String uname,String pwd){
		try {        
			 
			String sql= "select * from user where number='"+uname+"' and password='"+pwd+"' And status = Any (select status from user where status IS NOT NULL)"; 	
    
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
