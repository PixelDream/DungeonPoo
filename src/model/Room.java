package model;

import java.util.ArrayList;
import java.util.List;

public class Room {

    private double wifth;
    private double height;
    private List<Door> doors;
    private Chest chest;
    private Enemy enemy;

    public Room() {
        doors = new ArrayList<>();
    }
}
