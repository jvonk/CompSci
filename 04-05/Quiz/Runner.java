import java.util.*;
public class Runner {
	public static void main (String[] args) {
		John j = new John();
		System.out.println(j.getName());
		System.out.println(j.getAddress());
		
		List<Monster> ms = new ArrayList<>();
		ms.add(new Vampire("Elvira"));
		ms.add(new Mummy("Frank"));
		for (Monster m: ms) {
			System.out.println(m.getInfo());
		}
	}
}