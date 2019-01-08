package Bank;

public class Account {
	private int pin;
	protected double balance;
	protected String name;
	public Account (String a, int b, double c) {
		name = a;
		pin = b;
		balance = c;
	}
	public String toString() {
		return (name+": "+balance);
	}
}