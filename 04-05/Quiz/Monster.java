public abstract class Monster {
	private String name;
	public Monster (String in) {
		name = in;
	}
	public abstract String getInfo();
	public String getName() {
		return name;
	}
}