package Model;

import enums.Ingredients;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Order {
    private Coffee coffee;
    private List<AddOns> addOns;

    public Order(Coffee coffee, List<AddOns> addOns) {
        this.coffee = coffee;
        this.addOns = addOns;
    }

    public Order(Coffee coffee) {
        this.coffee = coffee;
        this.addOns = new ArrayList<>();
    }

    public Coffee getCoffee() {
        return coffee;
    }

    public void setCoffee(Coffee coffee) {
        this.coffee = coffee;
    }

    public List<AddOns> getAddOns() {
        return addOns;
    }

    public void setAddOns(List<AddOns> addOns) {
        this.addOns = addOns;
    }

    public void addAddOns(AddOns addOns){
        this.addOns.add(addOns);
    }

    public double getTotalCost() {
        double total = coffee.getPrice();
        for (AddOns addOn : addOns) {
            total += addOn.getPrice();
        }
        return total;
    }

    public Map<Ingredients, Integer> getTotalIngredients() {
        Map<Ingredients, Integer> total = new HashMap<>(coffee.getRecipe());
        for (AddOns addOn : addOns) {
            total.merge(addOn.getIngredients(), addOn.getQuantity(), Integer::sum);
        }
        return total;
    }
}
