package vendingmachine;
import Domain.Coin;
import Domain.Inventory;
import Domain.Item;
import Service.VendingMachineService;
import State.IdleState;
import State.VendingMachineState;

public class VendingMachine {
    private static final VendingMachine INSTANCE = getInstance();
    public Inventory inventory = new Inventory();
    //private final VendingMachineService vendingMachineService = new VendingMachineService();
    private VendingMachineState currentState;
    private int balance = 0;
    private String selectedItemcode;


    private VendingMachine() {
        currentState = new IdleState(this);
    }

    public static VendingMachine getInstance(){
        return INSTANCE;
    }

    public Inventory getInventory(){
        return inventory;
    }

    public void insertCoin(Coin coin){
        currentState.insertCoin(coin);
    }
    public Item addItem(String code, String name, int price, int quantity){
        Item item = new Item(code,name,quantity,price);
        inventory.addItem(code,item,quantity);
        return item;
    }
    public void selecItem(String code){
        currentState.selectItem(code);
    }
    public void refundBalance(){
        System.out.println("Refunding "+balance);
        balance = 0;
    }

    public void reset(){
        selectedItemcode = null;
        balance = 0;
    }
    public void addBalance(int value){
        balance += value;
    }

    public void dispense(){
        currentState.dispense();
    }
    public Item getSelectedItem() {
        return inventory.getItem(selectedItemcode);
    }

    public void dispenseItem() {
        Item item = inventory.getItem(selectedItemcode);
        if (balance >= item.getPrice()) {
            inventory.reduceStock(selectedItemcode);
            balance -= item.getPrice();
            System.out.println("Dispensed: " + item.getName());
            if (balance > 0) {
                System.out.println("Returning change: " + balance);
            }
        }
        reset();
        setCurrentState(new IdleState(this));
    }

    public void setSelectedItemcode(String code){
        this.selectedItemcode = code;
    }
    public void setCurrentState(VendingMachineState state){
        currentState = state;
    }
    public int getBalance(){
        return balance;
    }

}
