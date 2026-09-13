import Model.Pizza;

import Enum.Size;
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Pizza p1 = new Pizza.Builder("Mushroom", Size.LARGE).addchicken(true).addveggie(true).build();

        System.out.println(p1);
    }
}