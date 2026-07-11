package Service;

import Entities.Order;
import Entities.OrderItem;
import Entities.ShoppingCart;
import Enums.OrderStatus;

import java.util.ArrayList;
import java.util.List;

public class OrderService {
    private List<Order> orders;
    private int orderCounter;

    public OrderService() {
        this.orders = new ArrayList<>();
        this.orderCounter = 0;
    }

    public Order placeOrder(ShoppingCart cart) {
        if (cart.getOrderItemList().isEmpty()) {
            System.out.println("Cart is empty, cannot place order.");
            return null;
        }
        // Snapshot the cart items into a new list
        List<OrderItem> orderItems = new ArrayList<>(cart.getOrderItemList());

        Order order = new Order(++orderCounter, cart.getUser(), OrderStatus.PLACED, cart.getTotal(), orderItems);
        orders.add(order);

        // Clear the cart after order is placed
        cart.getOrderItemList().clear();
        cart.setTotal(0);

        System.out.println("Order placed with ID: " + order.getId());
        return order;
    }

    public void updateOrderStatus(Order order, OrderStatus newStatus) {
        order.setOrderStatus(newStatus);
        System.out.println("Order " + order.getId() + " updated to: " + newStatus);
    }

    public Order getOrderById(int orderId) {
        for (Order order : orders) {
            if (order.getId() == orderId) {
                return order;
            }
        }
        return null;
    }
}
