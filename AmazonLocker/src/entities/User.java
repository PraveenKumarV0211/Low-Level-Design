package entities;

public class User {
    private String name;
    private int age;
    private long phoneNumber;
    private String email;

    public User(String name, int age, long phoneNumber, String email) {
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
}
