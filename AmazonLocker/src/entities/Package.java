package entities;

import enums.Size;

public class Package {
    private int id;
    private Size size;
    private User user;
    private int orderID;

    public Package(int id, Size size, User user, int orderID) {
        this.id = id;
        this.size = size;
        this.user = user;
        this.orderID = orderID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }
}
