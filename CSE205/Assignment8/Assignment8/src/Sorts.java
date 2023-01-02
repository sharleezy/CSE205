// Assignment: 8
// Name: Sharliz Reyes
// StudentID: 1218634313
// Lecture: MW 1:30-2:45
// Description: Use selection sort to sort an ArrayList of objects

import java.util.ArrayList;
import java.util.Comparator;

public class Sorts {
	
	public static void sort(ArrayList<Hotel> reviewList, Comparator<Hotel> xComparator) {
		//selection sort
	     int min;
	     for (int index = 0; index < reviewList.size()-1; index++)
	     {
	        min = index;
	        for (int scan = index+1; scan < reviewList.size(); scan++)
	           if (xComparator.compare(reviewList.get(scan), reviewList.get(min)) < 0)
	              min = scan;
	        swap(reviewList, min, index);
	     }
		
	      
		
		
	}
	
	private static void swap (ArrayList<Hotel> reviewList, int index1, int index2)
    {
		//swap method to swap indexes
        Hotel first = reviewList.get(index1);
        Hotel second = reviewList.get(index2);
        reviewList.set(index1, second);
        reviewList.set(index2, first);
    }
}
