public class Programmer extends Profile {
	private String hobby;
	public Programmer(String a, String b) {
		super(a, "coding");
		hobby=b;
	}
	@Override
	public void speak() {
		super.speak();
		System.out.println("My speciality is "+speciality());
	}
	public void printInfo() {
		speak();
		System.out.println("My hobby is "+hobby);
	}
}