public class ArrayQuiz {
	private int[] numList;
	public ArrayQuiz() {
		numList = new int[] {2, 4, 6, 8, 10};
	}
	public void printList() {
		for(int a: numList)System.out.println(a);
	}
	public void scramble() {
		for (int i = 0; i < numList.length; i++) {
			int random = (int)(Math.random()*numList.length);
			int temp = numList[i];
			numList[i] = numList[random];
			numList[random] = temp;
		}
	}
	public void sort() {
		for (int i = 0; i < numList.length; i++) {
			for (int j = i+1; j < numList.length; j++) {
				if (numList[i] > numList[j]) {
					int temp = numList[i];
					numList[i] = numList[j];
					numList[j] = temp;
				}
			}
		}
	}
}