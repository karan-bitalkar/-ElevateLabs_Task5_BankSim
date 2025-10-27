import java.util.ArrayList;
import java.util.List;

public class Account {
    protected int accountId;
    protected String holderName;
    protected double balance;
    protected List<String> transactions;

    public Account(int accountId, String holderName, double initialBalance) {
        this.accountId = accountId;
        this.holderName = holderName;
        this.balance = initialBalance;
        this.transactions = new ArrayList<>();
        transactions.add("Account created with balance: " + initialBalance);
    }

    public int getAccountId() {
        return accountId;
    }

    public String getHolderName() {
        return holderName;
    }

    public double getBalance() {
        return balance;
    }

    // deposit
    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println(" Deposit amount must be positive.");
            return;
        }
        balance += amount;
        String rec = "Deposited: " + amount + " | New balance: " + balance;
        transactions.add(rec);
        System.out.println(" " + rec);
    }

    // withdraw
    public boolean withdraw(double amount) {
        if (amount <= 0) {
            System.out.println(" Withdraw amount must be positive.");
            return false;
        }
        if (amount > balance) {
            System.out.println(" Insufficient balance.");
            return false;
        }
        balance -= amount;
        String rec = "Withdrawn: " + amount + " | New balance: " + balance;
        transactions.add(rec);
        System.out.println(" " + rec);
        return true;
    }

    public void printTransactions() {
        System.out.println("\n Transaction History for Account ID: " + accountId);
        if (transactions.isEmpty()) {
            System.out.println("(No transactions)");
            return;
        }
        for (String t : transactions) {
            System.out.println("- " + t);
        }
    }

    @Override
    public String toString() {
        return "Account ID: " + accountId + " | Holder: " + holderName + " | Balance: " + balance;
    }
}
