package model;

import java.io.Serializable;

public class Attack implements Serializable {

    private String name;
    private double damage;
    private double luck;

    /**
     * Attack constructor from xml
     * @param name
     * @param damage
     * @param luck
     */

    public Attack(String name, double damage, double luck) {
        this.name = name;
        this.damage = damage;
        this.luck = luck;
    }

    public String getName() {
        return name;
    }

    public double getDamage() {
        return damage;
    }

    public double getLuck() {
        return luck;
    }
}
