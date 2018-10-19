public class Pythagorean {
    private double answer;
	public void findB (double a, double c) {
		answer = Math.sqrt(Math.pow(c, 2) - Math.pow(a, 2));
    }
    public double getAnswer() {
        return answer;
    }
}