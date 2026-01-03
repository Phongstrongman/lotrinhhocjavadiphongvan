package com.studeyjava.thucchien;

public class Main {

    public static void main(String[] args) {
        BankAccount acc = new BankAccount("001", "Nguyen Van An", 1000000);
        acc.deposit(500000);
        acc.withdraw(200000);
        System.out.println(acc.getAccountinfo());

    }
}
