public class Profile {
	private String name, speciality;
	public Profile(String a, String b) {
		name = a;
		speciality = b;
	}
	public void speak() {
		System.out.println("Hi, My name is "+name);
	}
	public String speciality() {
		return speciality;
	}
}