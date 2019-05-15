import java.util.*;
public class Test {
	public void printTable(int[][] t) {
		for (int[] a : t) {
			for (int b : a) {
				System.out.print(b+"\t");
			}
			System.out.println();
		}
	}
	public int findSmallest(int[][] t) {
		int min = Integer.MAX_VALUE;
		for (int[] a : t) {
			for (int b : a) {
				min=Math.min(min, b);
			}
		}
		return min;
	}
	public void printProfileList(ArrayList<Profile> as) {
		for (Profile a : as) {
			System.out.println(a);
		}
	}
	public void sortProfileList(ArrayList<Profile> as) {
		for (int i = 0; i < as.size(); i++) {
			for (int j = 0; j < as.size(); j++) {
				if (i!=j && as.get(i).getAge() > as.get(j).getAge()) Collections.swap(as, i, j);
			}
		}
	}
	public double averageAge(ArrayList<Profile> as) {
		double sum = 0.0;
		for (Profile a : as) {
			sum+=a.getAge();
		}
		return sum/as.size();
	}
	public String getPigLatin(String a) {
		return a.substring(1)+a.substring(0, 1)+"ay";
	}
}