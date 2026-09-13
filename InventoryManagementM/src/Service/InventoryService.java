package Service;

import Model.Interface.Stakeholders;
import Model.Interface.StockObserver;
import Model.Product;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InventoryService {
    private final Map<Integer, Product> productCatalog;

    public InventoryService() {
        this.productCatalog = new HashMap<>();
    }

    public boolean initialiseStock(int productId, String name, int quantity, List<StockObserver> stockObserverList, int threshold){
       Product product = new Product(productId,name,quantity,stockObserverList,threshold);
       productCatalog.put(productId,product);
       return true;
    }

    public boolean addStock(int productId, int qty){
        if (!productCatalog.containsKey(productId)){
            System.out.println("Sorry the product does not exists. go thrught new stock entering option");
            return false;
        }
        Product product = productCatalog.get(productId);
        product.setQuantity(product.getQuantity() + qty);
        return true;
    }

    public boolean removeStock(int productId, int qty){
        if (!productCatalog.containsKey(productId)){
            System.out.println("Sorry the product does not exists");
            return false;
        }

        Product product = productCatalog.get(productId);
        if (product.getQuantity() < qty){
            System.out.println("Sorry we are low in stock");
            sendRestockAlert(product);
            return false;
        }
        product.setQuantity(product.getQuantity() - qty);
        if(product.getQuantity() <= product.getThreshold()) sendRestockAlert(product);
        return true;
    }

    public void sendRestockAlert(Product product){
        for(StockObserver o : product.getStakeholdersList()){
            o.onLowStock(product);
        }
    }

}
