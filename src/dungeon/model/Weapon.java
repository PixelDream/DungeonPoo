package dungeon.model;

import dungeon.utils.FileManager;
import dungeon.utils.RandomCollection;

import java.io.Serializable;

public class Weapon implements Serializable {

    private String name;
    private String type;
    private int damage;
    private double rarity;

    /**
     * Random weapon constructor
     */

    public Weapon() {
        RandomCollection<Weapon> rc = new RandomCollection<>();
        for (Weapon weapon : FileManager.getWeaponsList()) rc.add(weapon.rarity, weapon);

        Weapon weapon = rc.next();

        this.name = weapon.name;
        this.type = weapon.type;
        this.damage = weapon.damage;
        this.rarity = weapon.rarity;
    }

    /**
     * Weapon constructor from xml file
     *
     * @param name   Name of the weapon
     * @param type   Type of the weapon
     * @param damage Damage caused by the weapon
     * @param rarity Chance to got this weapon
     */

    public Weapon(String name, String type, int damage, double rarity) {
        this.name = name;
        this.type = type;
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

    @Override
    public String toString() {
        return "(nom: " + name + ", type: " + type + ", dommage: " + damage + ", rarete: " + rarity + ')';
    }
}
