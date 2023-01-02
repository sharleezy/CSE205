// Assignment: 8
// Name: Sharliz Reyes
// StudentID: 1218634313
// Lecture: MW 1:30-2:45
// Description: The method returns the difference in rating (stars of first hotel minus stars of second hotel) if one hot got superior reviews over the other. If both hotels have the same number of stars, the comparison should return an integer that denotes which hotel comes earlier in the alphabet, etc.


import java.util.*;

public class ReviewRatingComparator implements Comparator<Hotel> {
	
	
	
	public int compare(Hotel first, Hotel second) {
		
		int stars1 = first.getStars();
		int stars2 = second.getStars();
		int difference;
		
		String name1 = first.getHotelName();
		String name2 = second.getHotelName();
		
		String location1 = first.getLocation();
		String location2 = second.getLocation();
		
		String review1 = first.getReview();
		String review2 = second.getReview();
		
		
		//if one hotel has a higher rating, return the hotel with the higher rating
		if (stars1 > stars2) {
			
			difference = stars1 - stars2;
			return difference;
			
		} else if (stars2 > stars1){
			
			difference = stars2 = stars1;
			return difference;
			
		} else if (stars1 == stars2) {
			//if they have the same rating, move through hierarchy and compare hotel names alphabetically
			
			int nameCompare = name1.compareTo(name2);
			
			if(nameCompare > 0) {
				
				return nameCompare;
				
			} else if (nameCompare < 0) {
				
				return -1;
				
				
			} else if (nameCompare == 0) {
				
				//if they start with the same let, move through hierarchy and compare locations alphabetically
				int locationCompare = location1.compareTo(location2);
				
				if(locationCompare > 0) {
					
					return 1;
					
				} else if (locationCompare < 0) {
					
					return -1;
					
				} else if (locationCompare == 0){
					
					//if they start with the same let, move through hierarchy and compare reviews alphabetically
					int reviewCompare = review1.compareTo(review2);
					
					if(reviewCompare > 0) {
						
						return reviewCompare;
						
					} else if (reviewCompare < 0) {
						
						return reviewCompare;
						
					} else {
						
						return reviewCompare;
						
					}
				}
				
			}
			
		}
		return 0;
	}
}
