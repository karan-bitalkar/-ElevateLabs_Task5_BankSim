# -ElevateLabs_Task5_BankSim
Bank Account Simulation (Java)

This project is part of the Elevate Labs Java Developer Internship (Task 5).
It simulates basic bank operations (create accounts, deposit, withdraw, transaction history) using Java OOP.


## Features
- Create Savings and Current accounts
- Deposit and Withdraw money
- Transaction history per account
- Simple interest application for savings
- Overdraft support for current account (custom limit)

## Files
- `Account.java` - base class (balance, deposit, withdraw, transactions)
- `SavingsAccount.java` - extends Account, supports interest
- `CurrentAccount.java` - extends Account, supports overdraft
- `BankApp.java` - main CLI application with menu

## How to run (Eclipse)
1. Open Eclipse and import or create project.
2. Add the four `.java` files to `src`.
3. Run `BankApp.java` as Java Application.
4. Use the console menu to interact.


## Notes
- This is a simulation; there is no persistent storage (database or files).
- Transaction history is stored in memory (ArrayList). For persistence, integrate file I/O or a database.

## Author
Karan Tanajising Bitalkar
