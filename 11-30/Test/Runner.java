public class Runner {
	public static void main (String[] args) {
		Exam2 e = new Exam2();
		String score = e.getScore(5, 7);
		System.out.println(score);
		e.count(5, 10);
		int[] numArray = new int[5];
		for (int i = 0; i < numArray.length; i++)
			numArray[i]=(int)(Math.random()*5+1);
		e.printArray(numArray);
		int sum = e.sumArray(numArray);
		System.out.println(sum);		
	}
}