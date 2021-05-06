/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bus.ticket.reservation.system;


import database.save;
import database.profileDatabase;

/**
 *
 * @author Avishek Saha
 */
public class myProfile {
    save s;
    
   public myProfile(save s){
        this.s=s;
        profileDatabase profile = new profileDatabase(s);
   }
     
   
}
    

