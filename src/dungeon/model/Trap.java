package dungeon.model;

import java.io.Serializable;

public class Trap implements Serializable {

    private String name;
    private int damage;
    private double rarity;

    /**
     * Trap constructor from xml file
     *
     * @param name   Name of the trap
     * @param damage Damage caused to the player
     * @param rarity Chance to got this trap
     */

    public Trap(String name, int damage, double rarity) {
        this.name = name;
        this.damage = damage;
        this.rarity = rarity;
    }

    public String getName() {
        return name;
    }

    public int getDamage() {
        return damage;
    }

    public double getRarety() {
        return rarity;
    }

}
