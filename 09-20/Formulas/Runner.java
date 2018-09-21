import java.util.Scanner;

public class Runner {
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		Formulas formulas = new Formulas();
		loop: while(true) {
			System.out.println("Select a formula. Enter in a number.");
			System.out.println("0 - Quit");
			System.out.println("1 - Volume of a Cone");
			System.out.println("2 - Area of a Cone");
			System.out.println("3 - Area of a Sphere");
			System.out.println("4 - Volume of a Sphere");
			System.out.println("5 - Area of a Cylinder");
			System.out.println("6 - Volume of a Cylinder");
			System.out.println("7 - Area of a Cube");
			System.out.println("8 - Volume of a Cube");
			System.out.println("9 - Area of a Cuboid");
			System.out.println("10 - Volume of a Cuboid");
			System.out.println("11 - Speed of a Falling Object");
			System.out.println("12 - Velocity of a Falling Object");
			System.out.println("13 - Force based upon mass and accelation");
			System.out.println("14 - Energy based upon mass");
			System.out.println("15 - Distance based upon velocity and time");
			int selection = kb.nextInt();
			switch (selection) {
				case 0: break loop;
				case 1: formulas.volCone();
					break;
				case 2: formulas.areaCone();
					break;
				case 3: formulas.areaSphere();
					break;
				case 4: formulas.volSphere();
					break;
				case 5: formulas.areaCylinder();
					break;
				case 6: formulas.volCylinder();
					break;
				case 7: formulas.areaCube();
					break;
				case 8: formulas.volCube();
					break;
				case 9: formulas.areaCuboid();
					break;
				case 10: formulas.volCuboid();
					break;
				case 11: formulas.speed();
					break;
				case 12: formulas.velocity();
					break;
				case 13: formulas.force();
					break;
				case 14: formulas.energy();
					break;
				case 15: formulas.distance();
					break;
			}
		}
	}
}