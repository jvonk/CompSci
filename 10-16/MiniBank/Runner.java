import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        MiniBank bank = new MiniBank(100, "$$BANK$$");
        Scanner kb = new Scanner(System.in);
        int which = -1;
        while (which!=0) {
            System.out.print("0-Quit\n1-Withdraw\n2-Deposit\n3-Check Balance\n4-Display Name\nWhich: ");
            which = kb.nextInt();
            switch(which) {
                case 1: {
                    System.out.print("amount: ");
                    bank.withdraw(kb.nextDouble());
                    double amount = bank.getBalance();
                    System.out.println("balance: "+amount);
                }
                break;
                case 2: {
                    System.out.print("amount: ");
                    bank.deposit(kb.nextDouble());
                    double amount = bank.getBalance();
                    System.out.println("balance: "+amount);
                }
                break;
                case 3: {
                    double amount = bank.getBalance();
                    System.out.println("balance: "+amount);
                }
                break;
                case 4: {
                    String name = bank.getName();
                    System.out.println("name: "+name);
                }
            }
        }
    }
}