/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

/**
 *
 * @author Avishek Saha
 */
public class profile {
    private final String Name;
    private final String Number;
    private final String Email;
	private final String Date;
	private final String Password;
    
    public profile(String name,String number,String email,String date,String password){
    
        this.Name = name;
        this.Number = number;
        this.Email = email;
		this.Date = date;
		this.Password = password;
    }

    
    
    public String getName(){
        return Name;
    }
    
    public String getNumber(){
        return Number;
    }
	
	public String getEmail(){
        return Email;
    }
	
	public String getDate(){
        return Date;
    }
	
	public String getPassword(){
        return Password;
    }
        
	
}
