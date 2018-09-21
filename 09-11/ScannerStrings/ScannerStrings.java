//© A+ Computer Science  -  www.apluscompsci.com
 
//scanner string example
 
import java.util.Scanner;
 
public class ScannerStrings{
    public static void main(String[] args){
        Scanner keyboard = new Scanner(System.in);
 
         
        //There are issues with nextLine() and the variable sentence.  Fix it. 
        //(1) What is happening that is not working correctly?
		//The nextLine is skipped and sentenced is never defined
        //(2) What type of errors are these? runtime or syntax?
        //both
        System.out.print("Enter an integer :: ");
        int num = keyboard.nextInt();
        
		keyboard.nextLine();
        System.out.print("Enter a sentence :: ");
        String sentence = keyboard.nextLine();
     
        System.out.println("");
         
         
        //Add code to do the following.  Decide if you should use next() or nextLine().
        //(3) Ask the user for their favorite color, then print it out.
		System.out.print("Enter your favorite color: ");
        String color = keyboard.next();

        //(4) Ask the user for their favorite saying, then print it out.

		keyboard.nextLine();
        System.out.print("Enter your favorite saying: ");
        String saying = keyboard.nextLine();
		
		System.out.println("Your number is :: " + num);
        System.out.println("Your sentence is :: " + sentence);
		System.out.println("Your color is :: " + color);
        System.out.println("Your saying is :: " + saying);

 
    }
}