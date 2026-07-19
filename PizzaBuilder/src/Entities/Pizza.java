package Entities;

import Enums.Crust;
import Enums.SauceType;
import Enums.Size;

import java.util.List;

public class Pizza {
    private final Size size;
    private final Crust crust;
    // optional
    private final SauceType sauce;
    private final boolean extraCheese;
    private final List<String> toppings;


    public Pizza(Builder builder) {
        this.size = builder.size;
        this.crust = builder.crust;
        this.sauce = builder.sauce;
        this.extraCheese = builder.extraCheese;
        this.toppings = builder.toppings;
    }

    public static class Builder {
        private final Size size;
        private final Crust crust;
        // optional
        private  SauceType sauce;
        private  boolean extraCheese;
        private  List<String> toppings;

        public Builder(Size size, Crust crust) {
            this.size = size;
            this.crust = crust;
        }

        public Builder sauce(SauceType sauceType){
            this.sauce = sauceType;
            return this;
        }
        public Builder extraCheese(boolean extraCheese){
            this.extraCheese = extraCheese;
            return this;
        }
        public Builder addToppings(String toppings){
            this.toppings.add(toppings);
            return this;
        }
        public Pizza build(){
            return new Pizza(this);
        }
    }
}
