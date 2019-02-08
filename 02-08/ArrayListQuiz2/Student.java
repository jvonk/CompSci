public class Student {
	private int id;
	private String name;
	public Student(int a, String b) {
		id=a;
		name=b;
	}
	public int getID() {
		return id;
	}
	public String toString() {
		return name+" : "+id;
	}
}