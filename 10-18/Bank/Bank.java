public class Bank {
    private String name;
    private double balance;
    private int pin;
    private boolean access;

    public Bank(String name, double balance, int pin) {
        this.name = name;
        this.balance = balance;
        this.pin = pin;
        this.access = false;
    }

    public String getName() {
        if (access == true) {
            return name;
        } else {
            return "No Access";
        }
    }

    public double getBalance() {
        if (access == true) {
            return balance;
        } else {
            return 0.0;
        }
    }

    public boolean checkPin(int pinInput) {
        if (pinInput == pin) {
            return access = true;
        } else {
            return access = false;
        }
    }

    public void withdraw(double amount) {
        if (access && balance>=amount) {
            balance -= amount;
        }
    }

    public void deposit(double amount) {
        if (access) {
            balance += amount;
        }
    }

    public void updateName(String newName) {
        if (access) {
            name = newName;
        }
    }
}
