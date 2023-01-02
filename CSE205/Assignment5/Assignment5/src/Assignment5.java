// Assignment #: 5
//         Name: Sharliz Reyes
//    StudentID: 1218634313
//      Lecture: MW 1:30-2:45
//  Description: create a class hierarchy to calculate battle statistics for aircrafts in an air warfare game. The program allows you to enter aircrafts with their characteristics and calculate their attack power.

import java.io.*;         //to use InputStreamReader and BufferedReader
import java.util.*;       //to use ArrayList

public class Assignment5 {
	public static void main(String[] args) {
        char input;
        String line;
        String inputInfo;

        // ArrayList used to store the aircraft objects
        ArrayList<AircraftEntity> aircraftList = new ArrayList<>();

        try{
            System.out.println("Welcome to the aircraft stats simulator!");
            printMenu();

            // create a BufferedREader object to read input from a keyboard
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader stdin = new BufferedReader(isr);

            do{
                System.out.println("\nWhat action would you like to perform?");
                line = stdin.readLine().trim();
                input = line.charAt(0);
                input = Character.toUpperCase(input);

                if(line.length() == 1){
                    switch (input){
                        case 'A': // add aircraft to the fleet
                            System.out.println("Please enter your aircraft stats:");
                            inputInfo = stdin.readLine().trim();
                            
                            //take the input and use aircraft parser method to add the aircraft to arrayList
                            AircraftEntity aircraft = AircraftParser.parseNewAircraft(inputInfo);
                            
                            aircraftList.add(aircraft);
                            
                            break;

                        case 'C': // calculate attack powers
                            
                        	//if the arrayList contains elements, continue to the loop
                        	if(aircraftList.isEmpty() == false) {
	                        	for(int i = 0; i < aircraftList.size(); i++) {
	                        		
	                        		//for each aircraft entity in the arrayList, call the computeAttackPower method to calculate attack power
	                        		AircraftEntity aircraftPower = aircraftList.get(i);
	                        		aircraftPower.computeAttackPower();
	                        		
	                        	}
                        	} 
                      
                            System.out.println("Attack powers computed");
                            break;

                        case 'D': // how many aircrafts have attack power equal to or larger than a user-defined value
                            System.out.print("Please enter a minimum attack power you want to calculate:\n");
                            inputInfo = stdin.readLine().trim();
                            int min = Integer.parseInt(inputInfo);
                            int count = 0;
                            
                            //if the arrayList contains elements, continue to the loop
                            if(aircraftList.isEmpty() == false) {
	                            for(int i = 0; i < aircraftList.size(); i++) {
	                            	
	                            	//for every aircraft entity in the arrayList, call getAttackPower method to retrieve the calculated attack power
	                            	AircraftEntity aircraftPower = aircraftList.get(i);
	                            	int power = aircraftPower.getAttackPower();
	                    
	                            	//increase the count if the attack power is greater than or equal to user-defined value
	                        		if(power >= min) {
	                        			count++;
	                        		}       
	                            }
	                            
                            }
                           
                            System.out.println("The number of aircrafts with " + min
                                    + " attack powers or more is: " + count);
                            break;

                        case 'L': // list aircrafts
                        	
                        	//if the arrayList contains elements, continue to the loop
                        	if(aircraftList.isEmpty() == false) {
                        		for(int i = 0; i < aircraftList.size(); i++) {
                        			
                        			//for every aircraft entity in the arrayList, print the features in the toString method
	                        		AircraftEntity listAircraft = aircraftList.get(i);
	                        		System.out.println(listAircraft.toString());
	                        	}
                        	} else {
                        		System.out.println("No aircrafts in the fleet yet.\n");
                        	}

                            break;

                        case 'Q':
                            break;

                        case '?':
                            printMenu();
                            break;

                        default:
                            System.out.println("Unknown action\n");
                            break;
                    }
                }
                else
                    System.out.println("Unknown action");

            }while (input != 'Q');
        }
        catch(IOException e){
            System.out.println("IO Exception");
        }
	}
	
    public static void printMenu(){
        System.out.print("Choice\t\tAction\n" +
                "------\t\t------\n" +
                "A\t\tAdd Aircraft\n" +
                "C\t\tCompute Attack Power\n" +
                "D\t\tCalculate the Number of Aircrafts with Minimum Attack Power\n" +
                "L\t\tList Aircrafts\n" +
                "Q\t\tQuit\n" +
                "?\t\tDisplay Help\n\n");
    }
}
