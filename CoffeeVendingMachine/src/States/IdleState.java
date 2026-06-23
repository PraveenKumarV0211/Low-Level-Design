package States;

import Model.Coffee;
import Model.Order;
import main.CoffeeVendingMachine;

public class IdleState extends VendingMachineState{

    public IdleState(CoffeeVendingMachine machine) {
        super(machine);
    }

    @Override
    public void selectDrink(Coffee coffee){
        if(!machine.getInventory().hasEnough(coffee.getRecipe())){
            throw new IllegalStateException("Insufficient ingredients for " + coffee.getName());
        }
        machine.setCurrentOrder(new Order(coffee));
        machine.setState(new DrinkSelectedState(machine));
        System.out.println("Selected: " + coffee.getName() + " | Price: " + coffee.getPrice());
    }


}
