
import java.util.Scanner;

public class Square {
	public static void main (String[] args) {
		Scanner keyboard = new Scanner(System.in);
    	System.out.println("I will be finding the area of square. Please give a side length.");
		double inputDouble = keyboard.nextDouble();
		double area = inputDouble * inputDouble;
		System.out.println("The area of this square is " + area);
	}
}
