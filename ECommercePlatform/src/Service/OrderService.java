package Service;

import Entities.*;
import Enums.OrderStatus;
import Strategy.PaymentStrategy;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class OrderService {
    private ShoppingCartService shoppingCartService;

    public OrderService(ShoppingCartService shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }

    public Order placeOrder(ShoppingCart shoppingCart, PaymentStrategy paymentStrategy) {
        List<OrderItem> orderItems = new ArrayList<>();
        for (CartItem cartItem : shoppingCart.getCartItemList()) {
            OrderItem orderItem = new OrderItem(cartItem.getProduct(), cartItem.getQuantity(), cartItem.getProduct().getPrice());
            orderItems.add(orderItem);
        }

        double total = shoppingCartService.calculateTotal();
        paymentStrategy.pay(total);

        Order order = new Order(1, shoppingCart.getUser(), orderItems, total, OrderStatus.PLACED, LocalDateTime.now());
        shoppingCart.getCartItemList().clear();
        return order;
    }

    public void updateOrderStatus(Order order, OrderStatus status) {
        order.setOrderStatus(status);
        System.out.println("Order " + order.getId() + " updated to " + status);
    }
}