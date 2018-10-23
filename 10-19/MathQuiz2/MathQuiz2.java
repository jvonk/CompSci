public class MathQuiz2 {
	private double pi;
	private double radius;
	public MathQuiz2(double in) {
		pi = 3.14;
		radius = in;
	}
	public double getArea() {
		return pi*Math.pow(radius, 2);
	}
	public void setRadius(double in) {
		radius=in;
	}
}