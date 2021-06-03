package dungeon.model;

import java.io.Serializable;

public class Attack implements Serializable {

    private String name;
    private int damage;

    /**
     * Attack constructor from xml
     *
     * @param name   Attack's name
     * @param damage Damage caused by the attack
     */

    public Attack(String name, int damage) {
        this.name = name;
        this.damage = damage;
    }

    public String getName() {
        return name;
    }

    public int getDamage() {
        return damage;
    }
}
