public class Runner {
	public static void main(String args[]) {
		Pet p1 = new Cat("Felix");
		Pet p2 = new LoudDog("Fido");
		
		//Testing part A
		System.out.println("\nTesting part A");
		System.out.println(p1.getName() + " says " + p1.speak() );
		
		//Testing part B
		System.out.println("\nTesting part B");
		System.out.println(p2.getName() + " says " + p2.speak() );
		
		//Testing part C
		System.out.println("\nTesting part C");
		Kennel k1 = new Kennel();
		k1.add(p1);
		k1.add(p2);
		k1.allSpeak();
	}
}