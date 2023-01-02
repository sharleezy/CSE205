// Assignment: 8
// Name: Sharliz Reyes
// StudentID: 1218634313
// Lecture: MW 1:30-2:45
// Description: Read in the user input and execute the appropriate command, then redisplay the prompt.

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Assignment8 {
    public static void main(String[] args) {
        // Menu options
        char inputOpt = ' ';
        String inputLine;
        // Hotel and Hotel Type information
        String hotelName, hotelType;
        String review = null, location, topFeature, priceRange;

        int rating;
        // Output information
        String outFilename, inFilename;
        String outMsg, inMsg;
        // Hotel manager
        ReviewManager reviewManager = new ReviewManager();
        // Operation result
        boolean opResult;     
        
        try {
            printMenu();
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader stdin = new BufferedReader(isr);

            do {
                System.out.print("\nWhat action would you like to perform?\n");
                inputLine = stdin.readLine().trim();
                if (inputLine.isEmpty()) {
                    continue;
                }
                inputOpt = inputLine.charAt(0);
                inputOpt = Character.toUpperCase(inputOpt);

                switch (inputOpt) {

                    case 'A': // Add a new Hotel Review
                        System.out.print("Please enter the hotel information:\n");
                        System.out.print("Enter the hotel name:\n");
                        hotelName = stdin.readLine().trim();
                        System.out.print("Enter the review:\n");
                        review = stdin.readLine().trim();
                        System.out.print("Enter the price range:\n");
                        priceRange = stdin.readLine().trim();
                        System.out.print("Enter the rating:\n");
                        rating = Integer.parseInt(stdin.readLine().trim());
                        System.out.print("Enter the hotel type:\n");
                        hotelType = stdin.readLine().trim();
                        System.out.print("Enter the location:\n");
                        location = stdin.readLine().trim();
                        System.out.print("Enter the hotel's top feature\n");
                        topFeature = stdin.readLine().trim();
                        
                        //Option ‘A’ asks the user to input hotel information, a review,
                        //price range, hotel rating, hotel type, hotel location, and top feature.
                        
                        if(reviewManager.addReview(hotelName, rating, review, priceRange, hotelType, location, topFeature) == true) {
                        	System.out.println("Hotel added\n");
                        } else {
                        	System.out.println("Hotel NOT added\n");
                        }
                        
                        	
                        break;
                        
                        /*********************************************************************
                        * Complete the code by calling the addReview method.                 *
                        * If the review has been added successfully, show                    *
                        * "Hotel added\n" on screen, otherwise "Hotel NOT added\n" *
                        **********************************************************************/
                        


                    case 'D': // Search a Hotel
                        System.out.print("Please enter the Hotel name to search:\n");
                        hotelName = stdin.readLine().trim();
                        System.out.print("Please enter the hotel's location':\n");
                        location = stdin.readLine().trim();
                        
                        /*********************************************************************
                        * Complete the code. If a hotel review exists, print            *
                        * "Hotel found. Here's the review:\n"                           *
                        * Otherwise, print "Hotel not found. Please try again\n"        *
                        **********************************************************************/ 
                        
                        //looks up a hotel review in the reviewList by hotel name and location.
                        int hotelExists = reviewManager.hotelExists(hotelName, location);
                        
                        //since the hotelExists() method returns -1 if no hotel is found, 
                        //to check if a hotel exists, check if there is something in the array.
                        if(hotelExists >= 0) {
                        	System.out.println("Hotel found. Here's the review: \n" + reviewManager.getHotel(hotelExists).getReview());
                        } else {
                        	System.out.println("Hotel not found. Please try again\n");
                        }
                        
                        break;

                    case 'E': // Search for a Hotel Type
                        System.out.print("Please enter the hotel type to search:\n");
                        hotelType = stdin.readLine().trim();
                        
                        /*******************************************************************************
                        * Complete the code. If a hotel type is found, show on the screen how many       *
                        * hotels match that type by printing                                  *
                        * "%s Hotels matching %s type were found:\n" followed by the reviews. *
                        * Otherwise, print "Hotel Type: %s was NOT found\n"                              *
                        ******************************************************************************/   
                        
                        //create an arraylists of the ceratin hotel type the user input.
                        ArrayList<Integer> hotelTypeExists = reviewManager.hotelTypeExists(hotelType);
                        String string = "";
                        
                        //add up all of the reviews of that hotel type into a string
                        for(int i = 0; i < hotelTypeExists.size(); i++) {
                        	int hotel = hotelTypeExists.get(i);
                        	Hotel getHotel = reviewManager.getHotel(hotel);
                        	string += getHotel.toString();
                        	
                        }
                        
                        //print the number of hotels for that type and it's reviews.
                        if(hotelTypeExists.isEmpty() == false) {
                        	System.out.println(hotelTypeExists.size() + "%s Hotels matching " + hotelType + "s type were found:\n" + string);
                        }
                        
                        break;
   
                    case 'L': // List hotel's reviews
                        System.out.print("\n" + reviewManager.listReviews() + "\n");
                        break;
                        
                     /******************************************************************************************
                     * Complete the code by adding two cases:                                                  *
                     * case 'N': sorts the hotel reviews by rating and prints "sorted by rating\n"        *
                     * case 'P': sorts the hotel reviews by hotel type and prints "sorted by hotel type\n" *
                     ******************************************************************************************/                        
                    case 'N':
                    	
                    	//sort hotels by rating by calling sortByRating() method in ReviewManager
                    	reviewManager.sortByRating();
                    	System.out.print("sorted by rating\n");
                    	break;
                        
                    case 'P':
                    	
                    	//sort hotels by hotel type by calling sortByHotelType() method in ReviewManager
                    	reviewManager.sortByHotelType();
                    	System.out.print("sorted by hotel type\n");
                    	break;
                    	
                    	
                    case 'Q': // Quit
                        break;

                    case 'R': // Remove a review
                        System.out.print("Please enter the hotel name of the review to remove:\n");
                        hotelName = stdin.readLine().trim();
                        System.out.print("Please enter the location to remove:\n");
                        location = stdin.readLine().trim();
                        
                        /*******************************************************************************
                        * Complete the code. If a review for a certain hotel at a given location  *
                        * is found, remove the review and print that it was removed. Otherwise         *
                        * print that it was NOT removed.                                               * 
                        *******************************************************************************/
                        boolean removeReview = reviewManager.removeReview(hotelName, location);
                        
                        //if there is a review that matches the hotelName and location, the removeReview() 
                        //method returns true, so remove the review if the method is true.
                        if(removeReview == true) {
                        	System.out.print("Successfully removed.\n");
                        } else {
                        	System.out.print("Remove unsuccessful.\n");
                        }
                        break; 
                        
                    case 'T': // Close reviewList
                        reviewManager.closeReviewManager();
                        System.out.print("Hotel management system was reset\n");
                        break;

                    case 'U': // Write hotel names and reviews to a text file
                        System.out.print("Please enter a file name that we will write to:\n");
                        outFilename = stdin.readLine().trim();
                        System.out.print("Please enter the name of the hotel:\n");
                        hotelName = stdin.readLine().trim();
                        System.out.println("Please enter a review to save locally:\n");
                        review = stdin.readLine().trim();
                        outMsg = hotelName + "\n" + review + "\n";
                        
                        /*************************************************************************************
                        * Add a try and catch block to write the string outMsg into the user-specified file  *
                        * Then, print in the screen that the file " is written\n"                            *
                        * In case of an IO Exception, print "Write string inside the file error\n"           *                                                             
                        *************************************************************************************/
                        
                        //prompts the user to enter a file name, hotel name, and review. 
                        //The input is stored in a String (outMsg).
                        FileOutputStream file = null;
                        ObjectOutputStream outstream = null;
                        
                        try {
                        	file = new FileOutputStream(outFilename);
                        	outstream = new ObjectOutputStream(file);
                        	outstream.writeObject(outMsg);
                        	System.out.println(outFilename + " is written.\n");
                        	
                        }
                        catch (IOException ex) {
                        	System.out.println("Write string inside the file error.\n");
                        }
                              

                    case 'V': // Read strings from a text file
                        System.out.print("Please enter a file name which we will read from:\n");
                        inFilename = stdin.readLine().trim();
                        
                        /******************************************************************************************
                        * Add a try and catch block to read from the above text file. Confirm that the file       *
                        * " was read\n" and then print "The contents of the file are:\n" followed by the contents *
                        * In case of an IO Exception, print "Read string from file error\n"                       *  
                        * In case of a file not found exception, print that the file " was not found\n"           *                                                             
                        ******************************************************************************************/ 
                        
                        //prompts the user to enter a file name to read from.
                        String line;
                        
                        try {
                        	FileReader fileReader = new FileReader(inFilename);
                        	BufferedReader inFile = new BufferedReader(fileReader);
                        	
                        	line = inFile.readLine();
                        	while (line != null) {
                        		
                        		System.out.println("The contents of the file are:\n" + line);
                        		line = inFile.readLine();
                        		
                        	}
                        	System.out.println(inFilename + " was read\n");
                        	
                            inFile.close();
                        } catch(FileNotFoundException e ) {
                        	
                          System.out.println(inFilename + " was not found\n");
                          
                        } catch(IOException e) {
                        	
                        	System.out.println("Read string from file error\n");
                        }
 
                    case 'W': // Serialize ReviewManager to a data file
                        System.out.print("Please enter a file name to write:\n");
                        outFilename = stdin.readLine().trim();
                        
                        /****************************************************************************
                        * Add a try and catch block to serialize ReviewManager to a data file.      *
                        * Catch two exceptions and print the corresponding messages on the screen:  *
                        * "Not serializable exception\n"                                            *
                        * "Data file written exception\n"                                           * 
                        ****************************************************************************/     
                        
                        //prompts the user to enter a file name to serialize ReviewManager to a data file.
                        try {
                        	// Build the stream that can write objects (not text) to a disk
                        	FileOutputStream fileOutputStream = new FileOutputStream(outFilename);
                        	ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
                          
                        	objectOutputStream.writeObject(reviewManager);
                        	// Do NOT forget to close the output stream
                        	objectOutputStream.close();
                        } catch(NotSerializableException e) {
                        	System.out.println("Not serializable exception\n");
                        } catch(IOException e) {
                        	System.out.println("Data file written exception\n");
                        }
                        

                    case 'X': // Deserialize ReviewManager from a data file
                        System.out.print("Please enter a file name which we will read from:\n");
                        inFilename = stdin.readLine().trim();
                        
                        /*****************************************************************************
                         * Add a try and catch block to deserialize ReviewManager from a data file.  *
                         * Catch three exceptions and print the corresponding messages on the screen:*
                         * "Class not found exception\n"                                             *
                         * "Not serializable exception\n"                                            * 
                         * "Data file read exception\n"                                              *
                         ****************************************************************************/
                        
                        //prompts the user to enter a file name to deserialize ReviewManager from a data file.
                        // First create an object input stream with the readObject method
                        FileInputStream fileInputStream = new FileInputStream(inFilename);
                        ObjectInputStream objectOutputStream = new ObjectInputStream(fileInputStream);
                        
                        try {
                        	
                          reviewManager = (ReviewManager) objectOutputStream.readObject();
                          System.out.println(inFilename + " was read\n");
                          
                        } catch( ClassNotFoundException e ) {
                        	
                          System.out.println("Class not found exception\n");
                          
                        } catch(NotSerializableException e) {
                        	
                        	System.out.println("Not serializable exception\n");
                        	
                        } catch(IOException e) {
                        	
                        	System.out.println("Data file read exception\n");
                        	
                        }
                       
                        

                    case '?': // Display help
                        printMenu();
                        break;

                    default:
                        System.out.print("Unknown action\n");
                        break;
                }

            } while (inputOpt != 'Q' || inputLine.length() != 1);
        }
        catch (IOException exception) {
            System.out.print("IO Exception\n");
        }
    }

    public static void printMenu() {
        System.out.println("Welcome to HotelAdvisor! ");
        System.out.println("Find or post reviews for your favorite (and not so favorite) hotels.");

        System.out.print("Choice\t\tAction\n" + "------\t\t------\n" + "A\t\tAdd a review\n"
                + "D\t\tSearch for a hotel\n" + "E\t\tSearch for a hotel type\n"
                + "L\t\tList all reviews\n" + "N\t\tSort by stars\n" + "P\t\tSort by hotel type\n"
                + "Q\t\tQuit\n" + "R\t\tRemove a review\n"
                + "U\t\tAdd personal review to a local file\n" + "V\t\tRetrieve personal review from a local file\n"
                + "W\t\tSave reviews to a file\n"
                + "X\t\tUpload reviews from a file\n"
                + "T\t\t(admin) reset database\n"
                + "?\t\tDisplay Help\n");
    }
}
