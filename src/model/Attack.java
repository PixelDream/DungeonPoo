package model;

import java.io.Serializable;

public class Attack implements Serializable {

    private String name;
    private double damage;
    private double luck;

    /**
     * Attack constructor from xml
     * @param name Attack's name
     * @param damage Damage caused by the attack
     */

    public Attack(String name, double damage, double luck) {
        this(name, damage);
        this.luck = luck;
    }

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
