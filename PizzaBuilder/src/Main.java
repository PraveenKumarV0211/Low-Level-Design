import Entities.Pizza;
import Enums.Crust;
import Enums.SauceType;
import Enums.Size;

public class Main {
    public static void main(String[] args) {
        Pizza pizza = new Pizza.Builder(Size.LARGE, Crust.THIN).sauce(SauceType.BBQ).addToppings("Mushroom").build();
        System.out.println(pizza.toString());
    }
}