package banky;
import static java.lang.System.out;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class BankAccount {
    private static String bankName;
    private static String branchName;
    private static String ifsc;

    private long accNum;
    private String accHName;
    private double balance;

    public BankAccount(long accNum, String accHName, double balance) {
        this.accNum = accNum;
        this.accHName = accHName;
        this.balance = balance;
    }

    // Static block to initialize static variables
    static {
        out.println("\nBankAccount class is loaded");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }

        out.println("SV memory allocated with default values");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }

        out.println("Reading Static variables values from file and initializing them");
        try (BufferedReader fileReader = new BufferedReader(new FileReader("C:\\Users\\abc\\Desktop\\data\\prakhar data\\Banky project\\Banky Banking System\\src\\banky\\bankdetails.txt"))) {
            bankName = fileReader.readLine();
            branchName = fileReader.readLine();
            ifsc = fileReader.readLine();
            out.println("SV are initialized with file values \n");
        } catch (FileNotFoundException e) {
            System.out.println("Error: bankdetails.txt file is not found");
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
    }// static block end

    // Getters and setters for instance variables
    public void setBankName(String bankName) {
        BankAccount.bankName = bankName;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBranchName(String branchName) {
        BankAccount.branchName = branchName;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setIfsc(String ifsc) {
        BankAccount.ifsc = ifsc;
    }

    public String getIfsc() {
        return ifsc;
    }

    public long getAccNum() {
        return accNum;
    }

    public void setAccHName(String accHName) {
        this.accHName = accHName;
    }

    public String getAccHName() {
        return accHName;
    }

    // Methods for deposit, withdraw, and checking balance
    public void deposit(double amt) {
        balance += amt;
    }

    public void withdraw(double amt) {
        balance -= amt;
    }

    public double getBalance() {
        return balance;
    }

    // Override toString() method to provide string representation of object
    @Override
    public String toString() {
        return "\n  bankName\t: " + bankName + "\n" +
                "  branchName\t: " + branchName + "\n" +
                "  ifsc\t\t: " + ifsc + "\n" +
                "  accNum\t: " + accNum + "\n" +
                "  accHName\t: " + accHName + "\n" +
                "  balance\t: " + balance;
    }
}
