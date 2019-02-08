import java.util.*;
public class ArrayListQuiz2 {
	public void printList(ArrayList<Student> in) {
		for (Student s : in) {
			System.out.println(s);
		}
		System.out.println();
	}
	public void scramble(ArrayList<Student> in) {
		for(int i = 0; i < in.size(); i++) {
			int j = (int)(Math.random()*in.size());
			Student temp = in.get(i);
			in.set(i, in.get(j));
			in.set(j, temp);
		}
	}
	public void sort(ArrayList<Student> in) {
		for(int i = 0; i < in.size(); i++) {
			for (int j = i+1; j<in.size(); j++) {
				if (in.get(i).getID()<=in.get(j).getID()) {
					continue;
				}
				Student temp = in.get(i);
				in.set(i, in.get(j));
				in.set(j, temp);
			}
		}
	}
}