public class MiniBank {
    private double balance;
    private String name;
    public MiniBank (double initial, String n) {
        balance=initial;
        name = n;
    }
    public String getName () {
        return name;
    }
    public double getBalance () {
        return balance;
    }
    public void deposit (double amount) {
        balance+=amount;
    }
    public void withdraw (double amount) {
        balance-=amount;
    }
}