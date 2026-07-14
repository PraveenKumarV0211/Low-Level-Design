package Entities;

import java.util.Date;

public class Card {
    private long cardNumber;
    private int pin;
    private String nameOnCard;
    private Date expirydate;

    public Card(long cardNumber, int pin, String nameOnCard, Date expirydate) {
        this.cardNumber = cardNumber;
        this.pin = pin;
        this.nameOnCard = nameOnCard;
        this.expirydate = expirydate;
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

    public String getNameOnCard() {
        return nameOnCard;
    }

    public void setNameOnCard(String nameOnCard) {
        this.nameOnCard = nameOnCard;
    }

    public Date getExpirydate() {
        return expirydate;
    }

    public void setExpirydate(Date expirydate) {
        this.expirydate = expirydate;
    }
}
