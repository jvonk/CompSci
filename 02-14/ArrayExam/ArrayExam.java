import java.util.*;

public class ArrayExam {
	public void print(int[] in) {
		for (int i : in) {
			System.out.print(i+" ");
		}
		System.out.println();
	}
	public int maxArray(int[] in) {
		int max = 0;
		for (int i : in) {
			max = Math.max(max, i);
		}
		return max;
	}
	public void scrambleArray(int[] in) {
		for (int i = 0; i < in.length; i++) {
			int j = (int)(Math.random()*in.length);
			int temp = in[i];
			in[i]=in[j];
			in[j]=temp;
		}
	}
	public void sort(int[] in) {
		for (int i = 0; i < in.length; i++) {
			for (int j = i+1; j < in.length; j++) {
				if (in[j]>in[i])continue;
				int temp = in[i];
				in[i]=in[j];
				in[j]=temp;
			}
		}
	}
	public void print(ArrayList<Card> in) {
		for (Card i : in) {
			System.out.print(i+" ");
		}
		System.out.println();
	}
	public void searchAndDelete(double j, ArrayList<Card> in) {
		for (int i = 0; i < in.size(); i++) {
			if (in.get(i).getValue()==j) {
				in.remove(i--);
			}
		}
	}
	public void sort(ArrayList<Card> in) {
		for (int i = 0; i < in.size(); i++) {
			for (int j = i+1; j < in.size(); j++) {
				if (in.get(j).getValue()>in.get(i).getValue())continue;
				Card temp = in.get(i);
				in.set(i, in.get(j));
				in.set(j, temp);
			}
		}
	}
}