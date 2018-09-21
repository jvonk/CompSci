public class Method2Quiz {
	private double pi = 0;
	private int radius = 0;
	public void setVariables() {
		pi = 3.14;
		radius = 10;
	}
	public void printSurfaceArea() {
		double sa = 4.0 * pi * radius * radius;
		System.out.println("Surface Area of a sphere: "+sa);
	}
}