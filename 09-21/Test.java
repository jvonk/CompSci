import java.util.Scanner;

public class Test {
	private double pi = 0;
	private double radius = 0;
	Scanner keyboard = new Scanner(System.in);
	public void setVariables() {
		pi = 3.14;
		radius=10;
	}
	public void printCircumference() {
		System.out.print("What is the radius: ");
		radius = keyboard.nextDouble();
		System.out.println("The circumference is: "+radius*pi*2.0);
	}
}