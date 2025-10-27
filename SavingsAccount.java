public class SavingsAccount extends Account {
    private double interestRate; 

    public SavingsAccount(int accountId, String holderName, double initialBalance, double interestRate) {
        super(accountId, holderName, initialBalance);
        this.interestRate = interestRate;
    }

    //  interest
    public void applyInterest() {
        double interest = balance * (interestRate / 100.0);
        balance += interest;
        transactions.add("Interest applied: " + interest + " | New balance: " + balance);
        System.out.println(" Interest applied: " + interest);
    }
    // Savings may allow withdrawal only if sufficient balance 
    @Override
    public boolean withdraw(double amount) {
        // can add additional checks here.
        return super.withdraw(amount);
    }
}
