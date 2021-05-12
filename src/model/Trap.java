package model;

import java.io.Serializable;

public class Trap implements Serializable {

    private String name;
    private int damage;
    private double rarety;

    public Trap(String type, int damage, double rarety) {
        this.name = type;
        this.damage = damage;
        this.rarety = rarety;
    }

    public String getName() {
        return name;
    }

    public int getDamage() {
        return damage;
    }

    public double getRarety() {
        return rarety;
    }
}
