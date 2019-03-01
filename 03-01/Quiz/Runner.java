public class Runner {
	public static void main (String[] args) {
		int[][] m1 = new int[3][5];
		for (int i = 0; i < m1.length; i++) {
			for (int j = 0; j < m1[i].length; j++) {
				m1[i][j] = (int) (Math.random()*5+1);
			}
		}
		MRQuiz m = new MRQuiz(m1);
		m.print();
		System.out.println(m.count(1));
		m.searchReplace(5, 0);
		m.print();
	}
}