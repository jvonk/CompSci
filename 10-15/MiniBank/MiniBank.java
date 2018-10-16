public class MiniBank {
    private double balance;
    public MiniBank (double initial) {
        balance=initial;
    }
    public void printBalance () {
        System.out.println("balance: "+balance);
    }
    public void deposit (double amount) {
        balance+=amount;
        printBalance();
    }
    public void withdraw (double amount) {
        deposit(-amount);
    }
}