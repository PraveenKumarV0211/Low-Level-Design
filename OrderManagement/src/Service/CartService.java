package Service;

import Entities.OrderItem;
import Entities.Product;
import Entities.ShoppingCart;

public class CartService {
    private ShoppingCart cart;

    public CartService(ShoppingCart cart) {
        this.cart = cart;
    }

    public void addItem(Product product, int quantity) {
        if (product.getAvailability() < quantity) {
            System.out.println("Not enough stock for: " + product.getName());
            return;
        }

        // Check if product already in cart, if so update quantity
        for (OrderItem item : cart.getOrderItemList()) {
            if (item.getProductId() == product.getId()) {
                item.setQuantity(item.getQuantity() + quantity);
                recalculateTotal();
                return;
            }
        }

        OrderItem item = new OrderItem(product.getId(), product.getName(), product.getPrice(), quantity);
        cart.getOrderItemList().add(item);
        recalculateTotal();
    }

    public void removeItem(int productId) {
        cart.getOrderItemList().removeIf(item -> item.getProductId() == productId);
        recalculateTotal();
    }

    public void viewCart() {
        for (OrderItem item : cart.getOrderItemList()) {
            System.out.println(item.getProductName() + " x" + item.getQuantity() + " @ " + item.getPrice());
        }
        System.out.println("Total: " + cart.getTotal());
    }

    private void recalculateTotal() {
        int total = 0;
        for (OrderItem item : cart.getOrderItemList()) {
            total += item.getPrice() * item.getQuantity();
        }
        cart.setTotal(total);
    }
}
