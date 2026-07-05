package Entities;

import Enums.OrderStatus;

import java.time.LocalDateTime;
import java.util.List;

public class Order {
    private int id;
    private User user;
    private List<OrderItem> orderItems;
    private Double totalAmount;
    private OrderStatus orderStatus;
    private LocalDateTime orderDate;

    public Order(int id, User user, List<OrderItem> orderItems, Double totalAmount, OrderStatus orderStatus, LocalDateTime orderDate) {
        this.id = id;
        this.user = user;
        this.orderItems = orderItems;
        this.totalAmount = totalAmount;
        this.orderStatus = orderStatus;
        this.orderDate = orderDate;
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

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }
}
