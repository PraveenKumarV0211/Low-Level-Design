package Entities;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private int id;
    private User user;
    private List<OrderItem> orderItemList;
    private int total;

    public ShoppingCart(int id, User user) {
        this.id = id;
        this.user = user;
        this.orderItemList = new ArrayList<>();
        this.total = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<OrderItem> getOrderItemList() {
        return orderItemList;
    }

    public void setOrderItemList(List<OrderItem> orderItemList) {
        this.orderItemList = orderItemList;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
