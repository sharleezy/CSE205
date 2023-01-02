// Sharliz Reyes
// 1218634313
// MW 1:30-2:45
// Implement recursive, static methods to: Find the largest prime number in an array of integers, Calculate the sum of all even numbers in an array of integers, Check if a string is palindrome or not, Remove all occurrences of character "A" in a String


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Assignment9 {

    public static void main(String[] args) {
    	String inputLine;
		int inputNumber; 
		String palindrome;
		String removeA;
		
    	try {
            
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader stdin = new BufferedReader(isr);

            do {
            	printMenu();
                
                inputLine = stdin.readLine();
                
                //convert number input to integer
                inputNumber = Integer.parseInt(inputLine);
                
                if (inputLine.isEmpty()) {
                    continue;
                }
                
               

                switch (inputNumber) {

                    case 1: //Call your static recursive method to find the largest prime number in the array (Task 1) and display the number.
                    	
                    	int[] primeNumbers = parseInts(stdin);
                    	
                    	int largestNum = 0;
                    	
                    	//loop through prime() method and assign whatever is bigger to the current largest number.
                    	for(int i = 0; i < primeNumbers.length - 1; i++) {
                    		
                    		if(prime(primeNumbers[i]) == true) {
                    			if(prime(primeNumbers[i + 1]) == true && primeNumbers[i + 1] > primeNumbers[i]) {
                    				largestNum = primeNumbers[i + 1];
                    			} else if(prime(primeNumbers[i + 1]) == true && primeNumbers[i + 1] < primeNumbers[i]){
                    				largestNum = primeNumbers[i];
                    			} 
                    			
                    		} 
                    	}
                    	System.out.println("The largest prime number in the array is: " + largestNum);
                    	
                    	break;
                    	
                    case 2: //Call your static recursive method to calculate the sum of all even numbers (Task 2) and display the sum on the screen.
                    	
                    	
                        int[] evenNumbers = parseInts(stdin);
                    	
                        //sum stores the sum from sumOfEven() method
                        int sum = sumOfEven(evenNumbers, evenNumbers.length - 1, 0);
                    	
                    	
                    	System.out.print("The sum of all even numbers in the array is: " + sum);
                    	break;
                    	
                    case 3: //Call your static recursive method to check if the string is 
                    	//palindrome or not (Task 3) and display "true" or "false" on the screen.
                    	System.out.println("Please enter String: ");
                    	palindrome = stdin.readLine();
                    	
                    	boolean result = palindrome(palindrome);
                    	
                    	
                    	System.out.print("\nPalindrome test result is: " + result);
                    	break;
                    	
                    case 4: //Call your static recursive method to remove all occurrences 
                    	//of character "A" (Task 4) and display the resulting String on the screen.
                    	System.out.println("Please enter String:\n");
                    	removeA = stdin.readLine();
                    	
                    	String removed = removeA(removeA);
                    	
                    	System.out.print("String after removing all occurrences of character \"A\": " + removed);
                        break;
                        
                    case 5:
                    	
                    	break;
   
                    default:
                        System.out.print("Please choose a number between 1 and 5.\n");
                        break;
                }

            } while (inputNumber != 5 || inputLine.length() != 1);
        }
        catch (IOException exception) {
            System.out.print("IO Exception\n");
        }
    	
	
    }
    

    // Utility method for printing the menu 
    public static void printMenu() {
        System.out.print("\nWhat would you like to do?\n\n");
        System.out.print("1: Find the largest prime number in an array of integers\n");
        System.out.print("2: Calculate the sum of all even numbers in an array of integers\n");
        System.out.print("3: Check if a string is palindrome or not\n");
        System.out.print("4: Remove all occurrences of character \"A\" in a String\n");
        System.out.print("5: Quit\n\n");
    }

    // utility method for parsing integers from standard input
    public static int[] parseInts(BufferedReader reader) {
        String line = "";
        ArrayList<Integer> container = new ArrayList<>();
        try {
            System.out.print("Please enter integers:\n");
            line = reader.readLine();
            int num = Integer.parseInt(line);

            while (num > 0) {
                container.add(num);
                line = reader.readLine();
                num = Integer.parseInt(line);
            }

        } catch (IOException ex) {
            System.out.println("IO Exception");
        }

        int[] result = new int[container.size()];
         for(int i = 0; i < container.size(); i++){
             result[i] = container.get(i);
         }
        return result;
    }
    
    //Implement a recursive, static method to find the largest prime 
    //number in the user input array. A prime number is a positive 
    //integer p>1 that has no positive integer divisors other than 1 and p itself. 
    public static boolean prime(int x) {
    	if (x <= 1) {
    		return false;
    	} else if (x == 2) {
    		return true;
    	} else if (x % 2 == 0) {
    		return false;
    	} for (int i = 3; i <= Math.sqrt(x); i += 2) {
    		if(x % i == 0) {
    			return false;
    		}
    	} return true;
    }
    
    //Implement a recursive, static method to compute the sum of all even numbers in the user input array.
    public static int sumOfEven(int[] numbers, int i, int sum) {
    	
    	//once the length of the array hits 0, return the current sum.
    	if(i < 0) {
    		
    		return sum;
    		
    		
    	} else if(numbers[i] % 2 == 0) { //determines if number is even, then adds it to sum
    		
    		return sum + numbers[i] + sumOfEven(numbers, i - 1, sum);
    		
    	} else { //if the number is not eve, continue to next number.
    		
    		i -= 1;
    		return sum + sumOfEven(numbers, i, sum);
    		
    	}
    	
    	

    	
    }
    
    //Implement a recursive, static method that checks if a String is palindrome or not.
    public static boolean palindrome(String string) {
    	
    	//if the string has 0-1 characters, it is a palindrome
    	if(string.length() == 0 || string.length() == 1) {
    		
    		return true;
    		
    	} else if(string.charAt(0) == string.charAt(string.length() - 1)) {
    		//if the first character of the string matches the last character of the string
    		
    		//continue with the rest of the string
    		palindrome(string.substring(1, string.length()-1));
    		
    		return true;
    		
    	} return false;
    }
    
    //Implement a recursive, static method that removes all 
    //occurrences of character "A" (case sensitive, "A" and "a" are different).
    public static String removeA(String string) {
    	char a = 'A';
    	
    	if(string.length() == 0) {
    		//if the length of the string is 0, return an empty string.
    		
    		return "";
    		
    	} else if(string.charAt(0) == a) {
    		
    		
    		return removeA(string.substring(1));
    	} 
    	//print the string without the A
    	return string.charAt(0) + removeA(string.substring(1));
    	
    	
    }
    	
} 


