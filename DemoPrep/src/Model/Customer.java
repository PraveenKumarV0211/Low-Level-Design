package Model;

public class Customer {
    private int id;
    private String name;
    private String email;

    public Customer(int id, String praveen) {
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private Long phone;

    public Customer(int id, String name, String email, Long phone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }
}
