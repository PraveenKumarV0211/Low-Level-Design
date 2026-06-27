package Entities;

import java.time.LocalDateTime;

public abstract class Unit {
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    int size;
    LocalDateTime createdDate;

    public Unit(String name,int size){
        this.name = name;
        this.size =size;
        createdDate = LocalDateTime.now();
    }

}
