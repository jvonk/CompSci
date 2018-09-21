public class Cylinder {
	public static void main (String[] args) {
		double volume;
		double radius=6.0;
		double pi = 3.14;
		double height = 10.0;
		System.out.println("radius: "+radius);
		System.out.println("pi: "+pi);
		System.out.println("height: "+height);
		volume=pi*radius*radius*height;
		System.out.println("volume: "+volume);
	}
}