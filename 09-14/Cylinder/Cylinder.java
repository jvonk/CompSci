import java.util.Scanner;

public class Cylinder {
	public static void main( String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.print("height: ");
		double height = keyboard.nextDouble();
		System.out.print("\nradius: ");
		double radius = keyboard.nextDouble();
		double pi = 3.14;
		double volume = radius*radius*pi*height;
		System.out.println("\nVolume: "+volume);
	}
}