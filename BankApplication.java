import java.util.Scanner;

public class BankApplication {

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

        int choice;

        do {
            System.out.println("\n----- Bank Menu -----");
            System.out.println("1. Display Complete Details");
            System.out.println("2. Deposit Amount");
            System.out.println("3. Withdraw Amount");
            System.out.println("4. Check Balance");
            System.out.println("5. Display Account Summary");
            System.out.println("6. Check Minimum Balance");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    b.displayBankDetails();
                    b.displayUserDetails();
                    b.displayAccountDetails();
                    break;

                case 2:
                    System.out.print("Enter Deposit Amount: ");
                    double depositAmount = sc.nextDouble();
                    boolean depositSuccess = b.deposit(depositAmount);
                    if (depositSuccess) {
                        System.out.println("Deposit successful.");
                        System.out.println("Updated Balance: " + b.checkBalance());
                    } else {
                        System.out.println("Deposit failed. Amount must be greater than zero.");
                    }
                    break;

                case 3:
                    System.out.print("Enter Withdrawal Amount: ");
                    double withdrawAmount = sc.nextDouble();
                    boolean withdrawSuccess = b.withdraw(withdrawAmount);
                    if (withdrawSuccess) {
                        System.out.println("Withdrawal successful.");
                        System.out.println("Updated Balance: " + b.checkBalance());
                    } else {
                        System.out.println("Withdrawal failed. Invalid amount or insufficient balance.");
                    }
                    break;

                case 4:
                    double currentBalance = b.checkBalance();
                    System.out.println("Current Balance: " + currentBalance);
                    break;

                case 5:
                    String summary = b.createAccountSummary();
                    System.out.println(summary);
                    break;

                case 6:
                    System.out.print("Enter Minimum Balance Required: ");
                    double minimumBalance = sc.nextDouble();
                    boolean hasMinimum = b.hasMinimumBalance(minimumBalance);
                    if (hasMinimum) {
                        System.out.println("Minimum balance is maintained.");
                    } else {
                        System.out.println("Minimum balance is not maintained.");
                    }
                    break;

                case 0:
                    System.out.println("Thank you for using the Bank Application. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 0);

        sc.close();
    }
}