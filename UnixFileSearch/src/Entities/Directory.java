package Entities;

import java.util.ArrayList;
import java.util.List;

public class Directory extends Unit{

    public Directory(String name, int size) {
        super(name, size);
    }

    public List<Unit> getSubDirectories() {
        return subDirectories;
    }

    public void setSubDirectories(List<Unit> subDirectories) {
        this.subDirectories = subDirectories;
    }

    List<Unit> subDirectories = new ArrayList<>();

    public void add(Unit unit){
        subDirectories.add(unit);
    }

}
