package model;

import java.io.Serializable;

public class Attack implements Serializable {

    private String name;
    private double damage;

    /**
     * Attack constructor from xml
     * @param name Attack's name
     * @param damage Damage caused by the attack
     */

<<<<<<< Updated upstream
=======
    public Attack(String name, double damage, double luck) {
        this(name, damage);
        this.luck = luck;
    }

>>>>>>> Stashed changes
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
