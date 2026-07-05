package Entities;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private User user;
    private List<CartItem> cartItemList;

    public ShoppingCart(User user) {
        this.user = user;
        this.cartItemList = new ArrayList<>();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<CartItem> getCartItemList() {
        return cartItemList;
    }

    public void setCartItemList(List<CartItem> cartItemList) {
        this.cartItemList = cartItemList;
    }
}
