public class Exam2 {
	public String getScore(int first, int second) {
		if (first%2==1&&second%2==1)
			return "A";
		else if (first%2==1||second%2==1)
			return "B";
		else
			return "C";
	}
	public void count (int min, int max) {
		while(min<=max)
			System.out.println(min++);
	}
	public void printArray(int[] arr) {
		for(int item: arr)
			System.out.println(item);
	}
	public int sumArray(int[] arr) {
		int res = 0;
		for(int i = 0; i < arr.length; i++)
			res+=arr[i];
		return res;
	}
}