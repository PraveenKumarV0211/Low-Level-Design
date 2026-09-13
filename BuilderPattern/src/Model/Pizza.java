package Model;
import Enum.Size;

public class Pizza {

    private final String name;
    private final Size size;
    private final boolean cheese;
    private final boolean chicken;
    private final boolean veggie;
    private final boolean thinCrust;

    @Override
    public String toString() {
        return "Pizza{" +
                "name='" + name + '\'' +
                ", size=" + size +
                ", cheese=" + cheese +
                ", chicken=" + chicken +
                ", veggie=" + veggie +
                ", thinCrust=" + thinCrust +
                '}';
    }

    private Pizza(Builder b) {
        this.name = b.name;
        this.size = b.size;
        this.cheese = b.cheese;
        this.chicken = b.chicken;
        this.veggie = b.veggie;
        this.thinCrust = b.thinCrust;
    }

    public static class Builder {
        private final String name;
        private final Size size;
        private boolean cheese;
        private boolean chicken;
        private boolean veggie;
        private boolean thinCrust;

        public Builder(String name, Size size) {
            this.name = name;
            this.size = size;
        }

        public Builder addCheese(boolean addCheese) {
            this.cheese = addCheese;
            return this;
        }

        public Builder addchicken(boolean chicken) {
            this.chicken = chicken;
            return this;
        }

        public Builder addveggie(boolean veggie) {
            this.veggie = veggie;
            return this;
        }

        public Builder addthinCrust(boolean thinCrust) {
            this.thinCrust = thinCrust;
            return this;
        }

        public Pizza build() {
            return new Pizza(this);
        }
    }
}