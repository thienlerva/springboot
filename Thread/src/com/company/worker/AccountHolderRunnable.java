package com.company.worker;

import com.company.model.Account;

public class AccountHolderRunnable implements Runnable {

    Account account;

    public AccountHolderRunnable(Account account) {
        this.account = account;
    }


    @Override
    public void run() {
        for(int i = 1; i<=4; i++) {
            makeWithdrawal(2000.00);
        }
    }

    private synchronized void makeWithdrawal(Double amount) {
        if(account.getBalance() >= amount) {
            System.out.println(Thread.currentThread().getName() + " is going to withdraw $ " + amount);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException ex) {
                System.out.println(ex.toString());
            }

            account.withdraw(amount);
            System.out.println(Thread.currentThread().getName() + " completes the withdrawal of $ " + amount);
        } else {
            System.out.println(Thread.currentThread().getName() + " not enough in account to withdraw " + account.getBalance());
        }
    }
}
