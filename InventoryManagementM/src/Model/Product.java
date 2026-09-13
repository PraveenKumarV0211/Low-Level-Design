package Model;

import Model.Interface.Stakeholders;
import Model.Interface.StockObserver;

import java.util.List;

public class Product {
    private int id;
    private String name;
    private int quantity;
    private List<StockObserver> stakeholdersList;
    private int threshold;

    public int getThreshold() {
        return threshold;
    }

    public void setThreshold(int threshold) {
        this.threshold = threshold;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Product(int id, String name, int quantity, List<StockObserver> stakeholdersList, int threshold) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.stakeholdersList = stakeholdersList;
        this.threshold = threshold;
    }

    public List<StockObserver> getStakeholdersList() {
        return stakeholdersList;
    }

    public void setStakeholdersList(List<StockObserver> stakeholdersList) {
        this.stakeholdersList = stakeholdersList;
    }
}
