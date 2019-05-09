public class Politician extends Profile {
	public Politician(String name, int age){
		super(name, age);
	}
	public String getAssociation() {
		return "Government";
	}
}