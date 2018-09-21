//(1) What do you think the import statement does?
//The import statement adds the class Scanner to the program making it possible to use keyboard input.
import java.util.Scanner;
 
public class Inputs {
    public static void main(String[] args) {
     
        //(2) What do you think is happening with the line below?
		//A new Scanner named keyboard is initialized based upon keyboard input
        Scanner keyboard = new Scanner(System.in);
         
        //(3) What line of code takes in a number from the user and stores it in a variable?
		//The line "int num1 = keyboard.nextInt();"
        //(4) What type of number is it?
		//It is an integer or int
        System.out.print("Enter in an integer: ");
        int num1 = keyboard.nextInt();
        System.out.println("you entered: " + num1);
         
        //(5) What line of code takes in a number from the user and stores it in a variable?
		//double num2 = keyboard.nextDouble();
        //(6) What type of number is it?
		//it is a double or decimal
        System.out.print("Enter in a double: ");
        double num2 = keyboard.nextDouble();
        System.out.println("you entered: " + num2);
    }
}