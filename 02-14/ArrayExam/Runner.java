import java.util.ArrayList; 

public class Runner{
	public static void main(String args[]){

		ArrayExam obj = new ArrayExam();		
		int[] myArray = new int[5];
		
		for(int i=0; i<myArray.length; i++){
			myArray[i] = (int)(Math.random()*10+1);
		}

		//10 Points
		//Print the array using a for each loop, all on one line.  
		//Print a new line at the end.
		System.out.println("\nPrint Array");
		obj.print(myArray); 
		
		//10 Points
		//Search and return the largest number in the array.
		System.out.println("\nLargest in the Array: ");
		int largest = obj.maxArray(myArray); 
		System.out.println(largest); 

		//15 Points
		//Scramble the myArray.
		System.out.println("\nScramble Array");
		obj.scrambleArray(myArray); 
		obj.print(myArray); 

		
		
		//20 Points
		//Sort the Array from Greatest to Least using bubble or selection sort.
		System.out.println("\nSort Array");
		obj.sort(myArray); 
		obj.print(myArray); 


		ArrayList<Card> myArrayList = new ArrayList<Card>();
		for(int i=0; i<10; i++){
			myArrayList.add(new Card( ((int)(Math.random()*5))/10.0) );
		}
		
		//10 Points
		//Print the ArrayList using a for each loop, all on one line.  
		//Print a new line at the end.
		//The Card class has a toString() that you will utilize.
		System.out.println("\nPrint ArrayList: ");
		obj.print(myArrayList);

		
		//15 Points
		//Search and Delete all occurrences of card with a given value
		//Use a for loop.
		int rand = (int)(Math.random()*myArrayList.size());
		double number = myArrayList.get(rand).getValue();
		System.out.println("\nSearch and delete: " + number );
		obj.searchAndDelete(number, myArrayList);
		obj.print(myArrayList);
		
		
		//20 Points
		//Sort the ArrayList by Card Value
		//from Greatest to Least using bubble or selection sort.
		System.out.println("\nSort ArrayList");
		obj.sort(myArrayList); 
		obj.print(myArrayList); 
		System.out.println();
					
	}
}
