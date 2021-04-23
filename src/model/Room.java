package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Room implements Serializable {

    private double width;
    private double height;
    private List<Door> doors;
    private Chest chest;
    private Enemy enemy;

    public Room() {
        doors = new ArrayList<>();
    }

    public void addDoor(Door d){
        doors.add(d);
    }
}
