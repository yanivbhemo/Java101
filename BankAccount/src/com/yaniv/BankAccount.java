package com.yaniv;

public class BankAccount {
    private double balance;
    private int id;

    public BankAccount(int id, double balance)
    {
        this.balance = balance;
        this.id = id;
    }

    public double GetBalance()
    {
        return this.balance;
    }

    public int GetId()
    {
        return this.id;
    }

    public void SetBalance(double balance)
    {
        this.balance = balance;
    }

    public void SetId(int id)
    {
        this.id = id;
    }
}
