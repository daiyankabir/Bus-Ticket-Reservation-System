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
public class save {
    String uname;
	String pass;
        public save(String uname, String pass){
            this.uname=uname;
            this.pass=pass;
        }

	public String getUname(){
		return this.uname;
	}
	public String getPass(){
		return this.pass;
	}
}

