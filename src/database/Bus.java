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
public class Bus {
    private final int Id;
    private final String Name;
    private final String Source;
    private final String Destination;
	private final String Type;
	private final String Departure;
	private final String Arrival;
    private final int SeatsAvailable;
	private final int Fare;
        private final String Date;
    
    public Bus(int id,String name,String source,String destination,String type,String departure,String arrival,int seatsAvailable,int fare, String date){
        this.Id = id;
        this.Name = name;
        this.Source = source;
        this.Destination = destination;
		this.Type = type;
		this.Departure = departure;
		this.Arrival = arrival;
		this.SeatsAvailable = seatsAvailable;
		this.Fare = fare;
                this.Date=date;
    }
     public int getId(){
        return Id;
    }
    
    public String getName(){
        return Name;
    }
    
    public String getSource(){
        return Source;
    }
	
	public String getDestination(){
        return Destination;
    }
	
	public String getType(){
        return Type;
    }
	
	public String getDeparture(){
        return Departure;
    }
	
	public String getArrival(){
        return Arrival;
    }
	
	public int getSeatsAvailable(){
        return SeatsAvailable;
    } 
    
    public int getFare(){
        return Fare;
    }
    
    public String getDate(){
        return Date;
    }
    
}
