import java.lang.Math;
import java.util.Scanner;

public class Exit {
	public static void main (String[] args) {
		Scanner keyboard = new Scanner(System.in);
    	System.out.println("I will be your age. Please give me your birth year as an integer.");
		int inputInt = keyboard.nextInt();
    	System.out.println("I will be your age. Please give me your birth month as an integer.");
		int inputMonth = keyboard.nextInt();
		int age = 2018-inputInt;
		int month = 9-inputMonth;
		if (month<1) {
			month+=12;
			age--;
		}
    	System.out.println("Your age is: "+age+" years and "+month+"months");
	}
}