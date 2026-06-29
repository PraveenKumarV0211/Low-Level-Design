package Entities;

import java.util.ArrayList;
import java.util.List;

public class Theater {
    String id;
    String name;
    String address;
    List<Screen> screens;

    public Theater(String id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.screens = new ArrayList<>();
    }

    public void addScreen(Screen screen) {
        screens.add(screen);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Screen> getScreens() {
        return screens;
    }
}
