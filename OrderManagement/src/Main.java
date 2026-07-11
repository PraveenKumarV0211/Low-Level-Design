public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}

/*
product: name, price, id, availability
Product_Order: productId, price, qualtity int // I am using product_Order bcz this takes a snaps hot of product and its price during the time it was brought, this can be used tor return processing
Shoppingcart: User, List<Product_Order> list, total
Order: User, ShoppingCart, total, OrderStatus
OrderStatus : enum placed, cancelled, processing,shipping

payment: makePayment() -- > interface
CreditCard implement payment
DebitCard implement payment

Strategy pattern to list down products based on price, availability count
Notification -> observer pattern, whenever there is a change in order status, user gets notification through various channels
NotificationStrategy -> interface
method notify(User user)
SMS Notification:
Email Notification

And finally user: name, age, phn, email, address

 */