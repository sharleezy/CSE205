//Sharliz Reyes
//1218634313
//MW 1:30-2:45
//The class Flight represents a flight on the flight list

public class Flight {
    String flightNumber;
    String destination;
    int numberOfPassengers;
    Flight next;

    public Flight(String flightNumber, String destination, int numberOfPassengers){
        this.flightNumber = flightNumber;
        this.destination = destination;
        this.numberOfPassengers = numberOfPassengers;
        this.next = null;
    }

    public String toString(){
        return "\nFlight Number " + this.flightNumber + " going to " + this.destination + " has " + this.numberOfPassengers + " passengers" + ".\n";
    }

}
