public class Vampire extends Monster {
	public Vampire (String in) {
		super(in);
	}
	public String getInfo() {
		return "Vampire "+getName();
	}
}