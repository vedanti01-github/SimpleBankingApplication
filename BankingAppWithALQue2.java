
import java.util.ArrayList;
import java.util.Scanner;
//class to represent a bank account
class BankAccount {
    private String accountHolderName; //name of account holder
    private double balance; //balance of the account
//constructor to initialize account with holder's name and default balance of 0
    public BankAccount(String accountHolderName) {
        this.accountHolderName = accountHolderName;
        this.balance = 0;
    }
//Getter for account holder's name
    public String getAccountHolderName() {
        return accountHolderName;
    }
//Getter for account balance
    public double getBalance() {
        return balance;
    }
//Method to deposit money in the account
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful. New balance: $" + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }
//Method to withdraw money from the account
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful. New balance: $" + balance);
        } else {
            System.out.println("Invalid or insufficient funds.");
        }
    }
}
//Main class to manage Banking Application
public class BankingAppWithALQue2 {
//ArrayList to store multiple bank accounts
    private static ArrayList<BankAccount> accounts = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            //Display options
            System.out.println("\nSimple Banking Application");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Check Balance");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
//Perform action based on user's choice
            switch (choice) {
                case 1:
                    createAccount();
                    break;
                case 2:
                    depositMoney();
                    break;
                case 3:
                    withdrawMoney();
                    break;
                case 4:
                    checkBalance();
                    break;
                case 5:
                    System.out.println("Thank you for using the banking application!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
//Method to create a new account
    private static void createAccount() {
        System.out.print("Enter account holder's name: ");
        scanner.nextLine(); // Consume newline
        String name = scanner.nextLine();
        //Create new account and add it to the accounts list
        BankAccount account = new BankAccount(name);
        accounts.add(account);
        System.out.println("Account created successfully for " + name + "!");
    }
//Method to deposit money into selected account
    private static void depositMoney() {
        BankAccount account = selectAccount();
        if (account != null) {
            System.out.print("Enter amount to deposit: ");
            double amount = scanner.nextDouble();
            account.deposit(amount);
        }
    }
//Method to withdraw money from selected account
    private static void withdrawMoney() {
        BankAccount account = selectAccount();
        if (account != null) {
            System.out.print("Enter amount to withdraw: ");
            double amount = scanner.nextDouble();
            account.withdraw(amount);
        }
    }
//Method to check balance of a selected account
    private static void checkBalance() {
        BankAccount account = selectAccount();
        if (account != null) {
            System.out.println("Account Holder: " + account.getAccountHolderName());
            System.out.println("Current Balance: $" + account.getBalance());
        }
    }
//Method to allow user to select an account from the list
    private static BankAccount selectAccount() {
        if (accounts.isEmpty()) {
            System.out.println("No accounts available. Please create an account first.");
            return null;
        }
        //Display the list of available accounts
        System.out.println("Select an account:");
        for (int i = 0; i < accounts.size(); i++) {
            System.out.println((i + 1) + ". " + accounts.get(i).getAccountHolderName());
        }
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        if (choice > 0 && choice <= accounts.size()) {
            //return the selected account
            return accounts.get(choice - 1);
        } else {
            System.out.println("Invalid choice.");
            return null;
        }
    }
}

