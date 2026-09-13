public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}


/*

Product — id, name, quantity, threshold, List<StockObserver>
StockObserver — interface, onLowStock(...)
Seller implements StockObserver — id, name, email
InventoryService — Map<String, Product>, the four stock operations


 */