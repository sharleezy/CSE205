//Sharliz Reyes
//1218634313
//MW 1:30-2:45
//Implement the flight list functionality of Flight Management System

public class LinkedList {
    Flight first;
    int size;

    public LinkedList(){
        this.first = null;
        this.size = 0;
    }

    // Choice A
    public void addFlight(String flightNumber, String destination, int numberOfPassengers){
        Flight newFlight = new Flight(flightNumber, destination, numberOfPassengers);
        if(this.first == null){
            this.first = newFlight;
        }
        else{
            Flight pointer = first;
            while(pointer.next != null)
                pointer = pointer.next;

            pointer.next = newFlight;
        }
        this.size++;
    }
    
    public int getNumberOfPassengers(String destination) {
    	Flight pointer = first;
    	int passengers = 0;
    	
    	
    	while(pointer != null) {//if list is not empty
        		
        	if(pointer.destination.equals(destination)) {
        		
        		//add to number of passengers
        		passengers += pointer.numberOfPassengers;
        		
        	} 
        		
        	pointer = pointer.next;
        		
        }
    	return passengers;
    	
		
    }
    
    public Flight removeFirstFlight() {
    	Flight pointer = first;
    	
    	if(first != null) { //if list is not empty
    		
    		//shift next element to first
    		first = first.next;
    		
    		//decrease size
    		size--;
    		
    	} else {
			System.out.println("You have no flights to remove");
		}
    	return pointer;

    	
    }
    
    public String listFlights() {
    	Flight pointer = first;
    	String flights = "";
    	
    	
    	if(pointer == null) { //if list is empty
    		return "No flights scheduled for departure at this time.\n";
    	} else {
    		
    		while(pointer != null) { //if list is not empty
        		
        		flights += pointer.toString(); //print current flight to String
        		
        		pointer = pointer.next; //go to next element
        	}
    		return flights + "\nTotal flights: " + size + ".\n";
    	}
    	
    }
    
    public int getPosition(String flightNumber) {
    	Flight pointer = first;
    	int count = 0;
    	
    	
    	if (pointer == null) { //if list is empty
    		return -1; //return -1;
    		
    	} else {
    		while (pointer != null) {
    			
    			//if flight number equals the flight number, return the count
    			if(pointer.flightNumber.equals(flightNumber)) {
    				return count;
    			} 
    			count++;
    			pointer = pointer.next;
    		}
    	}
    	return -1;
    }
    
    public Flight removeFlight(String flightNumber) {
    	Flight current = first;
    	Flight previous = null;
    	
    	
    	while(current != null) {
    		if(current.flightNumber.equals(flightNumber)) {
    			break;
    		} 
    		previous = current;
    		current = current.next;
    	} 
    	
    	//if list is not empty
    	if (current != null) {
    		
    		//if previous is not null
    		if(previous != null) {
    			
    			//make previous store the current
    			previous.next = current.next;
    		} else {
    			first = first.next;
    		
    		}
    		size--;
    		if(size == 0) {
    			first = null;
    		}
    		return current;
    	} else {
    		return new EmptyFlight();
    	}
    	

    }
    
    
    

}
