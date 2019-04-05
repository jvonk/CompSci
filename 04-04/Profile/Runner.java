public class Runner {
	public static void main (String[] args) {
		Programmer p = new Programmer("Jennifer");
		p.getInfo();
		p.addCredits(10);
		Teacher t = new Teacher("John");
		t.getInfo();
		t.addCredits(12);
		System.out.println("Credits: "+Profile.getCredits());
	}
}