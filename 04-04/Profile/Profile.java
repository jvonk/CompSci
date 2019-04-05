public abstract class Profile {
	private String name;
	private static int credits = 0;
	public Profile(String n) {
		name = n;
	}
	public abstract String getJobFunction();
	public String getName () {
		return "My name is " + name;
	}
	public static void addCredits (int in) {
		credits += in;
	}
	public static int getCredits () {
		return credits;
	}
	public void getInfo() {
		System.out.println(name+" "+getJobFunction());
	}
}