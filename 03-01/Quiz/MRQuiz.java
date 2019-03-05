public class MRQuiz {
	private int[][] numMatrix;
	public MRQuiz(int[][] in) {
		numMatrix=in;
	}
	public void print() {
		for (int i = 0; i < numMatrix.length; i++) {
			for (int j = 0; j < numMatrix[i].length; j++) {
				System.out.print(numMatrix[i][j]+(j==numMatrix[i].length-1?"\n":"\t"));
			}
		}
	}
	public int count(int in) {
		int count = 0;
		for (int i = 0; i < numMatrix.length; i++) {
			for (int j = 0; j < numMatrix[i].length; j++) {
				count+=numMatrix[i][j]==in?1:0;
			}
		}
		return count;
	}
	public void searchReplace(int a, int b) {
		for (int i = 0; i < numMatrix.length; i++) {
			for (int j = 0; j < numMatrix[i].length; j++) {
				numMatrix[i][j]=numMatrix[i][j]==a?b:numMatrix[i][j];
			}
		}
	}
}