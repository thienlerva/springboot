package com.company.model;

public class Account {

    Double balance;

    public Account(double balance) {
        this.balance = balance;
    }

    public Double getBalance() {
        return balance;
    }

    public void withdraw(Double amount) {
        if(this.balance < 0) {
            System.out.println("Account is overdrawn!");
        } else {
            this.balance = this.balance - amount;
        }
    }
}
