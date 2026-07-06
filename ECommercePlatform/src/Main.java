import Entities.*;
import Enums.Category;
import Enums.OrderStatus;
import Service.OrderService;
import Service.ShoppingCartService;
import Strategy.CreditCardPayment;
import Strategy.PaymentStrategy;

public class Main {
    public static void main(String[] args) {
        User user = new User(1, "Praveen", "praveen@email.com", 1234567890L);

        Product phone = new Product(1, "iPhone 15", 999.99, Category.ELECTRONIC);
        Product headphones = new Product(2, "AirPods Pro", 249.99, Category.ELECTRONIC);

        ShoppingCart cart = new ShoppingCart(user);
        ShoppingCartService cartService = new ShoppingCartService(cart);

        cartService.addProductToCart(phone, 1);
        cartService.addProductToCart(headphones, 2);

        System.out.println("Cart Total: $" + cartService.calculateTotal());

        OrderService orderService = new OrderService(cartService);
        PaymentStrategy payment = new CreditCardPayment("4111111111111111");

        Order order = orderService.placeOrder(cart, payment);
        System.out.println("Order placed with status: " + order.getOrderStatus());

        orderService.updateOrderStatus(order, OrderStatus.SHIPPED);
        orderService.updateOrderStatus(order, OrderStatus.DELIVERED);
    }
}