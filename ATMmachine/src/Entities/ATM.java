package Entities;

import State.ATMStates;
import State.ATMStates;
import State.IdleState;

public class ATM {
    private int id;
    private double atmBalance;
    private String location;
    private String bankName;
    private ATMStates currentState;
    private Account account;

    public ATM(int id, double atmBalance, String location, String bankName) {
        this.id = id;
        this.atmBalance = atmBalance;
        this.location = location;
        this.bankName = bankName;
        this.currentState = new IdleState(this);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAtmBalance() {
        return atmBalance;
    }

    public void setAtmBalance(double atmBalance) {
        this.atmBalance = atmBalance;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public ATMStates getCurrentState() {
        return currentState;
    }

    public void setAtmState(ATMStates currentState) {
        this.currentState = currentState;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}