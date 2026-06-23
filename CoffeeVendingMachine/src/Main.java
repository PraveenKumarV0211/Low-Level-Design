import Model.AddOns;
import Model.Coffee;
import enums.Ingredients;
import main.CoffeeVendingMachine;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        CoffeeVendingMachine machine = CoffeeVendingMachine.getInstance();

        // restock
        machine.getInventory().reStockIngredient(Ingredients.WATER, 1000);
        machine.getInventory().reStockIngredient(Ingredients.COFFEE_BEANS, 500);
        machine.getInventory().reStockIngredient(Ingredients.MILK, 500);
        machine.getInventory().reStockIngredient(Ingredients.SUGAR, 200);
        machine.getInventory().reStockIngredient(Ingredients.SYRUP, 200);

        // menu
        Coffee espresso = new Coffee("Espresso", 50, Map.of(Ingredients.WATER, 30, Ingredients.COFFEE_BEANS, 10));
        Coffee latte = new Coffee("Latte", 70, Map.of(Ingredients.WATER, 30, Ingredients.COFFEE_BEANS, 10, Ingredients.MILK, 100));

        AddOns extraSugar = new AddOns("Extra Sugar", 5, Ingredients.SUGAR, 10);
        AddOns syrupShot = new AddOns("Syrup Shot", 10, Ingredients.SYRUP, 15);

        // Order 1: Latte + extra sugar, overpay
        System.out.println("=== Order 1: Latte + Extra Sugar ===");
        machine.selectDrink(latte);
        machine.addAddOn(extraSugar);
        machine.insertMoney(100);

        // Order 2: Espresso, partial then full payment
        System.out.println("\n=== Order 2: Espresso, split payment ===");
        machine.selectDrink(espresso);
        machine.insertMoney(30);
        machine.insertMoney(20);

        // Order 3: Cancel after selection
        System.out.println("\n=== Order 3: Cancel ===");
        machine.selectDrink(latte);
        machine.cancel();
    }
}