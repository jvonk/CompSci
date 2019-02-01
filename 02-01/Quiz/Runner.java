import java.util.*;
public class Runner {
	public static void main(String[] args) {
		ArrayQuiz aq = new ArrayQuiz();
		ArrayList<Integer> numList = new ArrayList<Integer>();
		for (int i = 0; i < 5; i++) numList.add((int)(Math.random()*5+1));
		aq.printList(numList);
		System.out.println("search and delete");
		aq.searchAndDelete(numList, 2);
		aq.printList(numList);
		System.out.println("search and replace");
		aq.searchAndReplace(numList, 4);
		aq.printList(numList);
	}
}