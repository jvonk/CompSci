import java.util.Scanner;
public class Triangle {
	public static void printArea() {
		Scanner keyboard = new Scanner(System.in);
		System.out.print("What is the base: ");
		double base = keyboard.nextDouble();
		System.out.print("What is the height: ");
		double height = keyboard.nextDouble();
		double area = .5*base*height;
		System.out.println("Area: "+area);
	}
}