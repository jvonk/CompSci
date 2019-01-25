public class Runner {
	public static void main(String[] args) {
		ArrayQuiz a = new ArrayQuiz();
		a.printList();
		System.out.println("scramble");
		a.scramble();
		a.printList();
		System.out.println("sort");
		a.sort();
		a.printList();
	}
}