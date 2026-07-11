package Entities;

import Enums.OrderStatus;

import java.util.List;

public class Order {
    private int id;
    private User user;
    private OrderStatus orderStatus;
    private int total;
    private List<OrderItem> orderItemList;

    public Order(int id, User user, OrderStatus orderStatus, int total, List<OrderItem> orderItemList) {
        this.id = id;
        this.user = user;
        this.orderStatus = orderStatus;
        this.total = total;
        this.orderItemList = orderItemList;
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

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<OrderItem> getOrderItemList() {
        return orderItemList;
    }

    public void setOrderItemList(List<OrderItem> orderItemList) {
        this.orderItemList = orderItemList;
    }
}
