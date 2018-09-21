import java.util.Scanner;

public class Area {
	public static void main (String[] args) {
		Scanner keyboard = new Scanner(System.in);
    	System.out.print("What is the length as a integer: ");
		int length = keyboard.nextInt();
    	System.out.print("\nWhat is the width as a double: ");
		double width = keyboard.nextDouble();
		double area = length*width;
    	System.out.println("\nThe area is: "+area);
	}
}