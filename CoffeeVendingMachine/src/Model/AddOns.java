package Model;

import enums.Ingredients;

public class AddOns {
    private String name;
    private int price;
    private Ingredients ingredients;
    private int quantity;

    public AddOns(String name, int price, Ingredients ingredients, int quantity) {
        this.name = name;
        this.price = price;
        this.ingredients = ingredients;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Ingredients getIngredients() {
        return ingredients;
    }

    public void setIngredients(Ingredients ingredients) {
        this.ingredients = ingredients;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
