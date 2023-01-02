// Assignment: 8
// Name: Sharliz Reyes
// StudentID: 1218634313
// Lecture: MW 1:30-2:45
// Description: The method returns an integer that denotes which hotel object comes earlier in this hierarchy.

import java.util.*;

public class ReviewHotelTypeComparator implements Comparator<Hotel> {
	
	public int compare(Hotel first, Hotel second) {
		
		//If both hotel types are the same, 
		//the method should return an integer 
		//that denotes which hotel has the lower price range. 
		//If the price range is the same, the method should 
		//return an integer that denotes which hotel name 
		//comes earlier in the alphabet, etc
		
		HotelType type1 = first.getHotelType();
		HotelType type2 = second.getHotelType();
		
		int price1 = first.getPriceRange();
		int price2 = second.getPriceRange();
		
		String name1 = first.getHotelName();
		String name2 = second.getHotelName();
		
		String location1 = first.getLocation();
		String location2 = second.getLocation();
		
		String review1 = first.getReview();
		String review2 = second.getReview();
		
		
		
		if(type1.equals(type2) == true) {
			
			//if hotel types are the same, check prices.
			
			if(price1 > price2) {
				
				return price1;
				
			} else if (price2 > price1) {
				
				return price2;
				
			} else { 
				
				//If the price range is the same, the method 
				//should return an integer that denotes which hotel 
				//name comes earlier in the alphabet
				int nameCompare = name1.compareTo(name2);
				
				if(nameCompare > 0) {
					 
					return nameCompare;
					
				} else if (nameCompare < 0) {
					
					return nameCompare;
					
				} else if (nameCompare == 0) {
					
					int locationCompare = location1.compareTo(location2);
					
					if(locationCompare > 0) {
						
						return locationCompare;
						
					} else if (locationCompare < 0) {
						
						return locationCompare;
						
					} else if (locationCompare == 0){
						
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
			
		} 
			
			
		return 0;	
		
		
	}

}
