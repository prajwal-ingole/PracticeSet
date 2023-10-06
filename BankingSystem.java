
import java.util.Scanner;

class BankAccount {
    private int accountNumber;
    private String accountHolder;
    protected double balance;

    public BankAccount(int accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: $" + amount);
        } else {
            System.out.println("Invalid withdrawal amount or insufficient balance.");
        }
    }

    public void displayAccountDetails() {
        System.out.println("Account Type: Generic Bank Account");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Balance: $" + balance);
    }
}

class SavingsAccount extends BankAccount {
    private double interestRate;

    public SavingsAccount(int accountNumber, String accountHolder, double balance, double interestRate) {
        super(accountNumber, accountHolder, balance);
        this.interestRate = interestRate;
    }

    public void calculateInterest() {
        double interest = getBalance() * interestRate / 100;
        deposit(interest);
        System.out.println("Interest calculated and deposited: $" + interest);
    }

    private double getBalance() {
		return 0;
	}

	@Override
    public void displayAccountDetails() {
        super.displayAccountDetails();
        System.out.println("Account Type: Savings Account");
        System.out.println("Interest Rate: " + interestRate + "%");
    }
}

class CheckingAccount extends BankAccount {
    private double overdraftLimit;

    public CheckingAccount(int accountNumber, String accountHolder, double balance, double overdraftLimit) {
        super(accountNumber, accountHolder, balance);
        this.overdraftLimit = overdraftLimit;
    }

    public boolean hasOverdraftOccurred(double amount) {
        return amount > (balance + overdraftLimit);
    }

    @Override
    public void withdraw(double amount) {
        if (!hasOverdraftOccurred(amount)) {
            super.withdraw(amount);
        } else {
            System.out.println("Overdraft limit exceeded. Withdrawal not allowed.");
        }
    }

    @Override
    public void displayAccountDetails() {
        super.displayAccountDetails();
        System.out.println("Account Type: Checking Account");
        System.out.println("Overdraft Limit: $" + overdraftLimit);
    }
}

public class BankingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Create a Savings Account:");
        System.out.print("Enter account number: ");
        int savingsAccountNumber = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter account holder name: ");
        String savingsAccountHolder = scanner.nextLine();
        System.out.print("Enter initial balance: $");
        double savingsInitialBalance = scanner.nextDouble();
        System.out.print("Enter interest rate (%): ");
        double savingsInterestRate = scanner.nextDouble();
        SavingsAccount savingsAccount = new SavingsAccount(savingsAccountNumber, savingsAccountHolder, savingsInitialBalance, savingsInterestRate);

        System.out.println("\nCreate a Checking Account:");
        System.out.print("Enter account number: ");
        int checkingAccountNumber = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter account holder name: ");
        String checkingAccountHolder = scanner.nextLine();
        System.out.print("Enter initial balance: $");
        double checkingInitialBalance = scanner.nextDouble();
        System.out.print("Enter overdraft limit: $");
        double checkingOverdraftLimit = scanner.nextDouble();
        CheckingAccount checkingAccount = new CheckingAccount(checkingAccountNumber, checkingAccountHolder, checkingInitialBalance, checkingOverdraftLimit);

        // Display initial account details
        System.out.println("\nInitial Account Details:");
        savingsAccount.displayAccountDetails();
        checkingAccount.displayAccountDetails();

        // Perform transactions
        System.out.println("\nPerform Transactions:");
        savingsAccount.calculateInterest();
        System.out.println();
        checkingAccount.displayAccountDetails();
        System.out.print("Withdraw from Checking Account: $");
        double checkingWithdrawAmount = scanner.nextDouble();
        checkingAccount.withdraw(checkingWithdrawAmount);

        // Display updated account details
        System.out.println("\nUpdated Account Details:");
        savingsAccount.displayAccountDetails();
        checkingAccount.displayAccountDetails();

        scanner.close();
    }
}

