public class MathQuiz {
	private int num;
	public MathQuiz (int in) {
		num=in;
	}
	public void isOdd() {
		if (num%2==0) {
			System.out.println("false");
		} else {
			System.out.println("true");
		}
	}
	public void findC(int a, int b) {
		double c = Math.sqrt(Math.pow((double)a, 2.0)+Math.pow((double)b, 2.0));
		System.out.println(c);
	}
}