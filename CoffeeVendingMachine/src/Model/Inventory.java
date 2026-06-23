package Model;

import enums.Ingredients;

import java.util.EnumMap;
import java.util.Map;

public class Inventory {
    Map<Ingredients, Integer> stock;

    public Inventory() {
        this.stock = new EnumMap<>(Ingredients.class);
    }

    public Map<Ingredients, Integer> getStock() {
        return stock;
    }

    public void setStock(Map<Ingredients, Integer> stock) {
        this.stock = stock;
    }

    public Inventory(Map<Ingredients, Integer> stock) {
        this.stock = stock;
    }

    public void reStockIngredient(Ingredients ingredient, int quantity) {
        stock.merge(ingredient, quantity, Integer::sum);
    }

    public boolean hasEnough(Map<Ingredients, Integer> required) {
        for (Map.Entry<Ingredients, Integer> entry : required.entrySet()) {
            int available = stock.getOrDefault(entry.getKey(), 0);
            if (available < entry.getValue()) {
                return false;
            }
        }
        return true;
    }

    public void deduct(Map<Ingredients, Integer> required) {
        for (Map.Entry<Ingredients, Integer> entry : required.entrySet()) {
            stock.merge(entry.getKey(), -entry.getValue(), Integer::sum);
        }
    }



}
