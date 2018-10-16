import java.util.*;

public class Runner {
	public static void main (String[] args) {
		MathLibrary math = new MathLibrary();
        Scanner kb = new Scanner(System.in);
        System.out.print("radius: ");
        double r = kb.nextInt();
        double temp = math.areaCircle(r);
        System.out.println("areaCircle: "+temp);
        System.out.print("radius: ");
        r = kb.nextInt();
        System.out.print("height: ");
        double h = kb.nextInt();
        temp = math.volCylinder(r, h);
        System.out.println("volCylinder: "+temp);
        temp = math.volCone(r, h);
        System.out.println("volCone: "+temp);
	}
}