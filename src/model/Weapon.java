package model;

import java.io.Serializable;

public class Weapon extends Equipment implements Serializable {

    private String name;
    private String type;
    private int damage;
    private double rarety;

    public Weapon(String name, String type, int damage, double rarety) {
        this.name = name;
        this.type = type;
        this.damage = damage;
        this.rarety = rarety;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getDamage() {
        return damage;
    }

    public double getRarety() {
        return rarety;
    }


}
