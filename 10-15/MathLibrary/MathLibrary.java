public class MathLibrary {
	private double pi;
	public MathLibrary () {
		pi=3.14;
	}
	public double areaCircle(double r) {
		return pi*r*r;
	}
	public double volCylinder(double r, double h) {
		return areaCircle(r)*h;
	}
	public double volCone(double r, double h) {
		return volCylinder(r, h)/3.0;
	}
}