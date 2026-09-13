package Model.Interface;


import Model.Product;

import java.util.List;

public class Stakeholders implements StockObserver{
    public Stakeholders(int name, int id, String email, Long phone) {
        this.name = name;
        this.id = id;
        this.email = email;
        Phone = phone;
    }

    private int name;
    private int id;
    private String email;
    private Long Phone;

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getPhone() {
        return Phone;
    }

    public void setPhone(Long phone) {
        Phone = phone;
    }

    @Override
    public void onLowStock(Product product) {
        System.out.println("The alert is sent to the stakeHolder");
    }
}
