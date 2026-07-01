package Entities;

public class AirCraft {
    private int id;
    private String name;

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

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public AirCraft(int id, String name, String company) {
        this.id = id;
        this.name = name;
        this.company = company;
    }

    private String company;
}
