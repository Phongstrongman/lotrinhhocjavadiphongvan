package com.studeyjava.thucchien;

public class BankAccount {

    private String accountNumber;
    private String ownerName;
    private double balance;

    public BankAccount(String accountNumber, String ownerName, double balance) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Nạp tiền tài khoản " + accountNumber + ": " + amount);
        } else {
            System.out.println("error nạp tiền");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("số tiền bạn rút " + amount);
        } else {
            System.out.println("không thể rút tiền");
        }
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountinfo() {
        return "Account: " + accountNumber +
                " | Owner: " + ownerName +
                " | Balance: " + balance;
    }// kiến thức mở roongk
}
