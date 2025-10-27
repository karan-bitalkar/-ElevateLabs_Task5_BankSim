import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BankApp {
    private static List<Account> accounts = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("*** Welcome to Bank Account Simulation ***");

        boolean running = true;
        while (running) {
            printMenu();
            int choice = readIntInput("Enter your choice: ");
            switch (choice) {
                case 1 -> createSavingsAccount();
                case 2 -> createCurrentAccount();
                case 3 -> depositToAccount();
                case 4 -> withdrawFromAccount();
                case 5 -> viewAccount();
                case 6 -> viewAllAccounts();
                case 7 -> viewTransactions();
                case 8 -> applyInterestToSavings();
                case 9 -> {
                    running = false;
                    System.out.println("* Exiting... Thank you!");
                }
                default -> System.out.println("** Invalid choice. Try again.");
            }
        }
      
    }

    private static void printMenu() {
        System.out.println("\n--- Menu ---");
        System.out.println("1. Create Savings Account");
        System.out.println("2. Create Current Account");
        System.out.println("3. Deposit");
        System.out.println("4. Withdraw");
        System.out.println("5. View Account Balance");
        System.out.println("6. View All Accounts");
        System.out.println("7. View Transaction History");
        System.out.println("8. Apply Interest (Savings)");
        System.out.println("9. Exit");
    }

    private static int readIntInput(String prompt) {
        System.out.print(prompt);
        while (!sc.hasNextInt()) {
            System.out.println(" Please enter a valid number.");
            sc.nextLine();
            System.out.print(prompt);
        }
        int val = sc.nextInt();
        sc.nextLine(); // new line
        return val;
    }

    private static double readDoubleInput(String prompt) {
        System.out.print(prompt);
        while (!sc.hasNextDouble()) {
            System.out.println(" Please enter a valid number (decimal allowed).");
            sc.nextLine();
            System.out.print(prompt);
        }
        double val = sc.nextDouble();
        sc.nextLine();
        return val;
    }

    // create savings account
    private static void createSavingsAccount() {
        int id = readIntInput("Enter account ID (number): ");
        System.out.print("Enter holder name: ");
        String name = sc.nextLine();
        double initial = readDoubleInput("Enter initial deposit: ");
        double rate = readDoubleInput("Enter interest rate (e.g., 4 for 4%): ");
        accounts.add(new SavingsAccount(id, name, initial, rate));
        System.out.println("✅ Savings account created.");
    }

    // create current account
    private static void createCurrentAccount() {
        int id = readIntInput("Enter account ID (number): ");
        System.out.print("Enter holder name: ");
        String name = sc.nextLine();
        double initial = readDoubleInput("Enter initial deposit: ");
        double overdraft = readDoubleInput("Enter overdraft limit: ");
        accounts.add(new CurrentAccount(id, name, initial, overdraft));
        System.out.println("✅ Current account created.");
    }

    private static Account findAccountById(int accountId) {
        for (Account a : accounts) {
            if (a.getAccountId() == accountId) return a;
        }
        return null;
    }

    private static void depositToAccount() {
        int id = readIntInput("Enter account ID: ");
        Account a = findAccountById(id);
        if (a == null) {
            System.out.println(" Account not found.");
            return;
        }
        double amt = readDoubleInput("Enter deposit amount: ");
        a.deposit(amt);
    }

    private static void withdrawFromAccount() {
        int id = readIntInput("Enter account ID: ");
        Account a = findAccountById(id);
        if (a == null) {
            System.out.println(" Account not found.");
            return;
        }
        double amt = readDoubleInput("Enter withdraw amount: ");
        a.withdraw(amt);
    }

    private static void viewAccount() {
        int id = readIntInput("Enter account ID: ");
        Account a = findAccountById(id);
        if (a == null) {
            System.out.println(" Account not found.");
            return;
        }
        System.out.println(a);
    }

    private static void viewAllAccounts() {
        if (accounts.isEmpty()) {
            System.out.println("No accounts created yet.");
            return;
        }
        System.out.println("\nAll Accounts:");
        for (Account a : accounts) {
            System.out.println(a);
        }
    }

    private static void viewTransactions() {
        int id = readIntInput("Enter account ID: ");
        Account a = findAccountById(id);
        if (a == null) {
            System.out.println(" Account not found.");
            return;
        }
        a.printTransactions();
    }

    private static void applyInterestToSavings() {
        int id = readIntInput("Enter savings account ID: ");
        Account a = findAccountById(id);
        if (a == null) {
            System.out.println(" Account not found.");
            return;
        }
        if (a instanceof SavingsAccount) {
            ((SavingsAccount) a).applyInterest();
        } else {
            System.out.println(" This is not a savings account.");
        }
    }
}
