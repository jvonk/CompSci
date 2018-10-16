public class Runner {
    public static void main(String[] args) {
        MiniBank bank = new MiniBank(100);
        bank.printBalance();
        bank.withdraw(10.50);
        bank.deposit(323.32);
    }
}