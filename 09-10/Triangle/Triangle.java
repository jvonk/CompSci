import java.util.Scanner;

public class Triangle {
	public static void main (String[] args) {
		Scanner keyboard = new Scanner(System.in);
    	System.out.println("What is the base as a double: ");
		double base = keyboard.nextDouble();
    	System.out.println("What is the height as a double: ");
		double height = keyboard.nextDouble();
		double area = base*height/2.0;
    	System.out.println("The area is: "+area);
	}
}