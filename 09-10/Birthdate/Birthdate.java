import java.lang.Math;
import java.util.Scanner;

public class Birthdate {
	public static void main (String[] args) {
		Scanner keyboard = new Scanner(System.in);
    	System.out.println("I will be your age. Please give me your birth year as an integer.");
		int inputInt = keyboard.nextInt();
		int age = 2018-inputInt;
    	System.out.println("Your age is: "+age+" years");
	}
}