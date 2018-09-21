public class Cone {
	public static void main (String[] args) {
		double volume;
		double radius = 3;
		double pi = 3.14;
		double height = 6;
		volume = radius*radius*height*pi*1/3.0;
		System.out.println("radius: "+radius+"\npi: "+pi+"\nheight: "+height);
		System.out.println("volume: "+volume);
	}
}