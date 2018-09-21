import java.util.Scanner;
public class Input {
	public static void main (String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.print("What is your first name only: ");
		String firstName = keyboard.next();
		System.out.println("Hello "+firstName);
		System.out.println("Triangle");
		System.out.print("Height: ");
		double height = keyboard.nextDouble();
		System.out.print("Base: ");
		double base = keyboard.nextDouble();
		double area = .5*base*height;
		System.out.println("Area: "+area);
		System.out.println("Circle");
		System.out.print("Radius: ");
		double radius = keyboard.nextDouble();
		double areaCircle = 3.14*radius*radius;
		System.out.println("Area: "+areaCircle);
	}
}