package Bank;

public class AccountManager {
	private Account account;
	public AccountManager(String a, int b, double c) {
		account = new Account(a,b,c);
	}
	public void printInfo() {
		System.out.println(account.toString());
	}
}