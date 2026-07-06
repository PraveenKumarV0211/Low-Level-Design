package Service;

import Entities.CartItem;
import Entities.Product;
import Entities.ShoppingCart;

public class ShoppingCartService {
    private ShoppingCart shoppingCart;

    public ShoppingCartService(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public void addProductToCart(Product product, int quantity){
        boolean productAlreadyExists = false;
        for(CartItem cartItem : shoppingCart.getCartItemList()){
            if(cartItem.getProduct().getId() == product.getId()){
                cartItem.setQuantity(cartItem.getQuantity()+quantity);
                productAlreadyExists = true;
                break;
            }
        }
        if(!productAlreadyExists){
            CartItem cartItem = new CartItem(product,quantity);
            shoppingCart.getCartItemList().add(cartItem);
        }
    }

    public void removeProduct(Product product,int quantity){
        for (CartItem cartItem : shoppingCart.getCartItemList()){
            if (cartItem.getProduct().getId() == product.getId()){
               int currentQuantity =  cartItem.getQuantity();
               if(currentQuantity - quantity <= 0){
                   shoppingCart.getCartItemList().remove(cartItem);
               }
               else{
                   cartItem.setQuantity(currentQuantity - quantity);
               }
               break;
            }
        }
    }

    public Double calculateTotal(){
        Double total = 0.0;
        for (CartItem cartItem: shoppingCart.getCartItemList()){
            total += cartItem.getProduct().getPrice() * cartItem.getQuantity();
        }
        return total;
    }
}
