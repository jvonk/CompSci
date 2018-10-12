public class Exam2 {
	private double pi;
	private double radius;
	public Exam2() {
		pi=3.14;
		radius=10;
	}
	public Exam2(double r) {
		pi=3.14;
		radius=r;
	}
	public void printCir() {
		System.out.println(2.0*pi*radius);
	}
	public void printVolCone(double h) {
		System.out.println((1.0/3.0)*pi*radius*radius*h);
	}
}