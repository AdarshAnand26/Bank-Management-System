import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Bank Name: ");
        String bankName = sc.nextLine();

        System.out.print("Enter User ID: ");
        int userId = sc.nextInt();

        sc.nextLine();

        System.out.print("Enter User Name: ");
        String userName = sc.nextLine();

        System.out.print("Enter Account Number: ");
        long accountNumber = sc.nextLong();

        sc.nextLine();

        System.out.print("Enter Account Type: ");
        String accountType = sc.nextLine();

        System.out.print("Enter Opening Balance: ");
        double balance = sc.nextDouble();

        bank b = new bank(
            bankName,
            userId,
            userName,
            accountNumber,
            accountType,
            balance
        );

        System.out.println("\nBank Details-------->");
        b.displayBankDetails();

        System.out.println("\nUser Details-------->");
        b.displayUserDetails();

        System.out.println("\nAccount Details-------->");
        b.displayAccountDetails();

        System.out.println("\nAccount Summary-------->");
        String summary = b.createAccountSummary();
        System.out.println(summary);

        System.out.print("\nEnter Minimum Balance Required: ");
        double minimumBalance = sc.nextDouble();

        boolean result = b.hasMinimumBalance(minimumBalance);

        if (result) {
            System.out.println("Minimum balance is maintained.");
        } else {
            System.out.println("Minimum balance is not maintained.");
        }

        System.out.print("\nEnter Deposit Amount: ");
        double depositAmount = sc.nextDouble();
        boolean depositSuccess = b.deposit(depositAmount);
        if (depositSuccess) {
            System.out.println("Deposit successful. New Balance: " + b.checkBalance());
        } else {
            System.out.println("Deposit failed. Amount must be greater than zero.");
        }

        System.out.print("\nEnter Withdrawal Amount: ");
        double withdrawAmount = sc.nextDouble();
        boolean withdrawSuccess = b.withdraw(withdrawAmount);
        if (withdrawSuccess) {
            System.out.println("Withdrawal successful. New Balance: " + b.checkBalance());
        } else {
            System.out.println("Withdrawal failed. Invalid amount or insufficient balance.");
        }

        System.out.println("\nCurrent Balance: " + b.checkBalance());

    }
}