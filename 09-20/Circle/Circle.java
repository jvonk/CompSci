import java.util.Scanner;
public class Circle {
	private double pi = 3.14;
	private double radius = 0;
	private Scanner keyboard = new Scanner (System.in);
	public void setRadius () {
		System.out.print("Radius as a double:");
		radius = keyboard.nextDouble();
    }
	public void printArea () {
		System.out.print("Area: "+pi*radius*radius);
	}
}