package Entities;

import Enums.AccountType;

public class Account {
    private int id;
    private String name;
    private double balance;
    private long cardNumber;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public long getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(long cardNumber) {
        this.cardNumber = cardNumber;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public Account(int id, String name, double balance, long cardNumber, int pin, AccountType accountType) {
        this.id = id;
        this.name = name;
        this.balance = balance;
        this.cardNumber = cardNumber;
        this.pin = pin;
        this.accountType = accountType;
    }

    private int pin;
    private AccountType accountType;
}
