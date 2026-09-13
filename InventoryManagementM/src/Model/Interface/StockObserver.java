package Model.Interface;

import Model.Product;

import java.util.List;

public interface StockObserver {
    public void onLowStock(Product product);
}
