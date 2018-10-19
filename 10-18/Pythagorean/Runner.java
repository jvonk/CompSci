public class Runner {
	public static void main (String[] args) {
        Pythagorean math = new Pythagorean();
        math.findB(12, 13);
        System.out.println(math.getAnswer());
	}
}