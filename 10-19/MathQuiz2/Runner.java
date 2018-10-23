public class Runner {
	public static void main (String[] args) {
		MathQuiz2 quiz = new MathQuiz2(15.0);
		double res = quiz.getArea();
		System.out.println(res);
		quiz.setRadius(10.0);
		double res2 = quiz.getArea();
		System.out.println(res2);
	}
}