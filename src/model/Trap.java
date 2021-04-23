package model;

import java.io.Serializable;

public class Trap implements Serializable {

    private Direction direction;
    private double damage;
    private String type;

    public Trap(Direction direction, double damage, String type) {
        this.direction = direction;
        this.damage = damage;
        this.type = type;
    }

    public Direction getDirection() {
        return direction;
    }

    public double getDamage() {
        return damage;
    }

    public String getType() {
        return type;
    }
}
