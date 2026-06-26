package Entities;

public class User {
    private final String id;
    private  String name;
    private  String email;

    public User(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
        System.out.println("[User] Created user -> id=" + id + ", name=" + name + ", email=" + email);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("[User] setName: " + this.name + " -> " + name);
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        System.out.println("[User] setEmail: " + this.email + " -> " + email);
        this.email = email;
    }
}
