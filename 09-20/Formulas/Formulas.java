import java.util.Scanner;

public class Formulas {
	private Scanner kb = new Scanner(System.in);
	private double pi = 3.14;
	private double grav = 9.81;
	private double c = 299792458;
	public void volCone() {
		System.out.println("Volume of a Cone");
		System.out.print("Enter in a radius: ");
		double radius = kb.nextDouble();
		System.out.print("Enter in a height: ");
		double height = kb.nextDouble();
		double vol = (1.0/3.0) * pi * Math.pow(radius, 2) * height;
		System.out.println("The volume is " + vol);
	}
	public void areaCone() {
		System.out.println("Area of a Cone");
		System.out.print("Enter in a radius: ");
		double radius = kb.nextDouble();
		System.out.print("Enter in a height: ");
		double height = kb.nextDouble();
		double area = pi * radius * (radius + Math.sqrt(Math.pow(radius, 2) + Math.pow(height, 2)));
		System.out.println("The area is " + area);
	}
	public void areaSphere() {
		System.out.println("Area of a Sphere");
		System.out.print("Enter in a radius: ");
		double radius = kb.nextDouble();
		double area = 4.0 * pi * Math.pow(radius, 2);
		System.out.println("The area is " + area);
	}
	public void volSphere() {
		System.out.println("Volume of a Sphere");
		System.out.print("Enter in a radius: ");
		double radius = kb.nextDouble();
		double vol = (4.0/3.0) * pi * Math.pow(radius, 3);
		System.out.println("The volume is " + vol);
	}
	
	public void areaCylinder() {
		System.out.println("Area of a Cylinder");
		System.out.print("Enter in a radius: ");
		double radius = kb.nextDouble();
		System.out.print("Enter in a height: ");
		double height = kb.nextDouble();
		double area = 2.0 * pi * radius * height + 2.0 * pi * Math.pow(radius, 2);
		System.out.println("The area is " + area);
	}
	public void volCylinder() {
		System.out.println("Volume of a Cylinder");
		System.out.print("Enter in a radius: ");
		double radius = kb.nextDouble();
		System.out.print("Enter in a height: ");
		double height = kb.nextDouble();
		double vol = pi * Math.pow(radius, 2) * height;
		System.out.println("The volume is " + vol);
	}
	public void areaCube() {
		System.out.println("Area of a Cube");
		System.out.print("Enter in a side length: ");
		double side = kb.nextDouble();
		double area = 6.0 * Math.pow(side, 2);
		System.out.println("The area is " + area);
	}
	public void volCube() {
		System.out.println("Volume of a Cube");
		System.out.print("Enter in a side length: ");
		double side = kb.nextDouble();
		double vol = Math.pow(side, 3);
		System.out.println("The volume is " + vol);
	}
	public void areaCuboid() {
		System.out.println("Area of a Cuboid");
		System.out.print("Enter in a first side length: ");
		double side1 = kb.nextDouble();
		System.out.print("Enter in a second side length: ");
		double side2 = kb.nextDouble();
		System.out.print("Enter in a third side length: ");
		double side3 = kb.nextDouble();
		double area = 2.0*(side1*side2 + side2*side3 + side1*side3);
		System.out.println("The area is " + area);
	}
	public void volCuboid() {
		System.out.println("Volume of a Cuboid");
		System.out.print("Enter in a first side length: ");
		double side1 = kb.nextDouble();
		System.out.print("Enter in a second side length: ");
		double side2 = kb.nextDouble();
		System.out.print("Enter in a third side length: ");
		double side3 = kb.nextDouble();
		double vol = side1*side2*side3;
		System.out.println("The volume is " + vol);
	}
	public void speed() {
		System.out.println("Speed of a Falling Object");
		System.out.print("Enter a time: ");
		double time = kb.nextDouble();
		double spd = grav*time;
		System.out.println("The speed is " + spd);
	}
	public void velocity() {
		System.out.println("Velocity of a Falling Object");
		System.out.print("Enter a time: ");
		double time = kb.nextDouble();
		double vel = -1.0*grav*time;
		System.out.println("The velocity is " + vel);
	}
	public void force() {
		System.out.println("Force based upon mass and accelation");
		System.out.print("Enter a mass: ");
		double mass = kb.nextDouble();
		System.out.print("Enter a accelation: ");
		double accel = kb.nextDouble();
		double frc = mass*accel;
		System.out.println("The force is " + frc);
	}
	
	public void energy() {
		System.out.println("Energy based upon mass");
		System.out.print("Enter a mass: ");
		double mass = kb.nextDouble();
		double enr = mass*Math.pow(c, 2);
		System.out.println("The energy is " + enr);
	}
	
	public void distance() {
		System.out.println("Distance based upon velocity and time");
		System.out.print("Enter a velocity: ");
		double vel = kb.nextDouble();
		System.out.print("Enter a time: ");
		double time = kb.nextDouble();
		double dis = vel*time;
		System.out.println("The distance is " + dis);
	}
	
}