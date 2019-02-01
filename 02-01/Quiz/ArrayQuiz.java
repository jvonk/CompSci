import java.util.*;
public class ArrayQuiz {
	public void printList(ArrayList<Integer> in) {
		for (int a : in) System.out.println(a);
		System.out.println();
	}
	public void searchAndDelete(ArrayList<Integer> in, int j) {
		for (int i = 0; i < in.size(); ) {
			if (in.get(i)==j) {
				in.remove(i);
				continue;
			}
			i++;
		}
	}
	public void searchAndReplace(ArrayList<Integer> in, int j) {
		for (int i = 0; i < in.size(); i++) {
			if (in.get(i)==j) {
				in.set(i, 99);
			}
		}
	}
}