package com.company.ClientTest;

import com.company.model.Account;
import com.company.worker.AccountHolderRunnable;

import java.util.AbstractList;

public class Main {

    public static void main(String[] args) {
	// write your code here

        Account account = new Account(6000.00);
        AccountHolderRunnable accountHolderRunnable = new AccountHolderRunnable((account));
        Thread t1 = new Thread(accountHolderRunnable);
        Thread t2 = new Thread(accountHolderRunnable);
        t1.setName("An");
        t2.setName("Vy");

        t1.start();
        t2.start();
    }
}
