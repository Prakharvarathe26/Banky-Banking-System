package banky;
import java.util.Scanner;

public class BankFrontOffice {
    public static void main(String[] args) {

        Bank HDFCBank = new Bank(); // Assuming Bank class is defined

        try (Scanner scn = new Scanner(System.in)) {
            loop: while (true) {
                System.out.println("\nChoose one option");
                System.out.println("  1. Open Account");
                System.out.println("  2. Account details");
                System.out.println("  3. Deposit");
                System.out.println("  4. Withdraw");
                System.out.println("  5. Balance Enquiry");
                System.out.println("  6. Transfer Money");
                System.out.println("  7. Display all accounts");
                System.out.println("  8. Exit");

                System.out.print("Enter option: ");
                int option = scn.nextInt();
                scn.nextLine();

                try {
                    switch (option) {
                        case 1: // Open Account
                            HDFCBank.openAccount();
                            break;

                        case 2: // Account details
                            System.out.print("Enter account number: ");
                            long accNum = scn.nextLong();
                            scn.nextLine();
                            HDFCBank.displayAccount(accNum);
                            break;

                        case 3: // Deposit
                            System.out.print("Enter account number: ");
                            long accNumDeposit = scn.nextLong();
                            scn.nextLine();

                            System.out.print("Enter deposit amount: ");
                            double depositAmt = scn.nextDouble();
                            scn.nextLine();

                            HDFCBank.deposit(accNumDeposit, depositAmt);
                            break;

                        case 4: // Withdraw
                            System.out.print("Enter account number: ");
                            long accNumWithdraw = scn.nextLong();
                            scn.nextLine();

                            System.out.print("Enter withdraw amount: ");
                            double withdrawAmt = scn.nextDouble();
                            scn.nextLine();

                            HDFCBank.withdraw(accNumWithdraw, withdrawAmt);
                            break;

                        case 5: // Balance Enquiry
                            System.out.print("Enter account number: ");
                            long accNumBalance = scn.nextLong();
                            scn.nextLine();

                            HDFCBank.balanceEnquiry(accNumBalance);
                            break;

                        case 6: // Transfer Money
                            System.out.print("Enter source account number: ");
                            long srcAccNum = scn.nextLong();
                            scn.nextLine();

                            System.out.print("Enter destination account number: ");
                            long destAccNum = scn.nextLong();
                            scn.nextLine();

                            System.out.print("Enter transfer amount: ");
                            double transferAmt = scn.nextDouble();
                            scn.nextLine();

                            ((Bank) HDFCBank).transferMoney(srcAccNum, destAccNum, transferAmt);
                            break;

                        case 7: // Display all accounts
                            System.out.println(HDFCBank);
                            break;

                        case 8: // Exit
                            System.out.println("_/\\__/\\__/\\_ Thank You, Please Visit Again _/\\__/\\__/\\_");
                            break loop;

                        default:
                            System.out.println("Invalid option");
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }
        }
    }
}
