import Bank.*;

public class Runner {
	public static void main (String[] args) {
		AccountManager am = new AccountManager("John Smith", 1234, 99.99);
		am.printInfo();
	}
}