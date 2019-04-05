public class Mummy extends Monster {
	public Mummy (String in) {
		super(in);
	}
	public String getInfo() {
		return "Mummy "+getName();
	}
}