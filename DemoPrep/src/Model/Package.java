package Model;

import Enums.Size;

public class Package {
    private int id;
    private Size size;
    private Customer customer;

    public Package(int id, Size size, Customer customer) {
        this.id = id;
        this.size = size;
        this.customer = customer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
