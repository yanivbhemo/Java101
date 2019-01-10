package com.yaniv;

public class BankAccountDemo {
    public static void main(String args[])
    {
        BankAccount b1 = new BankAccount(204,100);
        System.out.println(b1.GetBalance());
        b1.SetBalance(200);
        System.out.println(b1.GetBalance());
    }
}
