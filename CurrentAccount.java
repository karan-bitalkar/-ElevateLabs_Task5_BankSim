public class CurrentAccount extends Account {
    private double overdraftLimit; // allowed negative balance up to this limit

    public CurrentAccount(int accountId, String holderName, double initialBalance, double overdraftLimit) {
        super(accountId, holderName, initialBalance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public boolean withdraw(double amount) {
        if (amount <= 0) {
            System.out.println(" Withdraw amount must be positive.");
            return false;
        }
        double allowed = balance + overdraftLimit;
        if (amount > allowed) {
            System.out.println(" Exceeds overdraft limit. Cannot withdraw.");
            return false;
        }
        balance -= amount;
        String rec = "Withdrawn: " + amount + " | New balance: " + balance;
        transactions.add(rec);
        System.out.println(" " + rec);
        return true;
    }
}
