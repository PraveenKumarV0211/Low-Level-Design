package Entities;

import Enum.Symbol;
public class Player {
    private String name;
    private int age;
    private String userName;
    private Symbol symbol;

    public Player(String name, int age, String userName, Symbol symbol) {
        this.name = name;
        this.age = age;
        this.userName = userName;
        this.symbol = symbol;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
