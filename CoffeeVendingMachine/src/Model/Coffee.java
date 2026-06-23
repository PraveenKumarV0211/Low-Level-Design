package Model;

import enums.Ingredients;

import java.util.Map;

public class Coffee {
    private String name;
    private int price;
    private Map<Ingredients,Integer> recipe;

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

    public Map<Ingredients, Integer> getRecipe() {
        return recipe;
    }

    public void setRecipe(Map<Ingredients, Integer> integerMap) {
        this.recipe = integerMap;
    }

    public Coffee(String name, int price, Map<Ingredients, Integer> integerMap) {
        this.name = name;
        this.price = price;
        this.recipe = integerMap;
    }




}
