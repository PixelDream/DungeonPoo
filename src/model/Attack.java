package model;

import java.io.Serializable;

public class Attack implements Serializable {

    private String name;
    private double damage;

    public Attack(String name, double damage) {
        this.name = name;
        this.damage = damage;
    }

    public String getName() {
        return name;
    }

    public double getDamage() {
        return damage;
    }
}
