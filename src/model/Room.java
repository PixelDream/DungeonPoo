package model;

import java.io.Serializable;

public class Room implements Serializable {

    private Position position;
    private double width;
    private double height;
    private Chest chest;
    private Enemy enemy;

    public Room(Position position) {
        this.position = position;
    }
}
