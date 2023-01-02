// Assignment: 8
// Name: Sharliz Reyes
// StudentID: 1218634313
// Lecture: MW 1:30-2:45
// Description: a Hotel object also has a name, number of stars (reviewer ratings), a review (String), a price range (integer between 1 and 5, represented as dollar signs in the review), and a hotel location (street address).

import java.io.Serializable;

public class Hotel implements Serializable {
	
	
	private static final long serialVersionUID = 205L;
	private String hotelName;
	private int stars;
	private String review;
	private int priceRange;
	private String location;
	private HotelType hotelType;
	
	public Hotel(String hotelName, int stars, String review, int priceRange, String location, HotelType hotelType) {
		this.hotelName = hotelName;
		this.stars = stars;
		this.review = review;
		this.priceRange = priceRange;
		this.location = location;
		this.hotelType = hotelType;
	}
	
	//accescor method 
	public String getHotelName() {
		return hotelName;
	}
	
	//accescor method 
	public int getStars() {
		
		return stars;
	}
	
	//accescor method 
	public int getPriceRange() {
		return priceRange;
	}
	
	//accescor method 
	public String getLocation() {
		return location;
	}
	
	//accescor method 
	public String getReview() {
		return review;
	}
	
	//accescor method 
	public HotelType getHotelType() {
		return hotelType;
	}
	
	//prints everything to a string.
	public String toString() {
		String first = hotelName + " hotel\n";
		String second = "\t\t";
		String third = "\n" +  hotelType.toString() + "Location: " + location + "\n" + "Review:\t" + review + "\n\n";
		String starString = "";
		String priceString = "";
		
		for(int i = 0; i <= getStars(); i++) {
			starString += "*";
		} 
		
		for(int i = 0; i <= getPriceRange(); i++) {
			priceString += "$";
		} 
		
		return first + starString + second + priceString + third;
		
	}
		
		
	
	
}

