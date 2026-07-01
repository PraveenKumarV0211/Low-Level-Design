package Entities;

public class Passenger {
    private String Name;
    private int age;
    private String email;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Passenger(String name, int age, String email) {
        Name = name;
        this.age = age;
        this.email = email;
    }
}
