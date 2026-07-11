package Entities;

public class Product {
    private int id;
    private String name;
    private int availability;
    private int price;

    public Product(int id, String name, int availability, int price) {
        this.id = id;
        this.name = name;
        this.availability = availability;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAvailability() {
        return availability;
    }

    public void setAvailability(int availability) {
        this.availability = availability;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
