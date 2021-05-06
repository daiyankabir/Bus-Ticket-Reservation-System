/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;
import bus.ticket.reservation.system.printTicket;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.*;

/**
 *
 * @author Avishek Saha
 */
public class bookingDatabase extends javax.swing.JFrame {
        Connection con;
	Statement stat;
	ResultSet rs;
        @SuppressWarnings("OverridableMethodCallInConstructor")
    public bookingDatabase(String username, String busID, String jDate, String seats,String tFare, String availableSeats, String bname,String source,String destination,String type,String departure,String arrival){
        
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
        
            String sql ="UPDATE `bus_details` SET `seats_available`='"+availableSeats+"' WHERE id ='"+busID+"' and date = '"+jDate+"'";
            stat.executeUpdate(sql);
        }
        catch(Exception e){
            System.out.println("error while validating: "+e); 
        } 
           
            try{
        
            String sql ="INSERT INTO `book_ticket`(`username`, `id`, `bus_name`, `source`, `destination`, `type`, `departure`, `arrival`, `booked_seats`, `total_fare`, `journey_date`) VALUES ('"+username+"','"+busID+"','"+bname+"','"+source+"','"+destination+"','"+type+"','"+departure+"','"+arrival+"','"+seats+"','"+tFare+"','"+jDate+"')";
            stat.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Ticket Booked","OK",JOptionPane.INFORMATION_MESSAGE);
            setVisible(false);
            printTicket print = new printTicket(username, busID, jDate, seats, tFare, bname, source, destination, type, departure, arrival);
        }
        catch(Exception e){
            System.out.println("error while validating: "+e); 
        } 
        
        
    }
    
}
