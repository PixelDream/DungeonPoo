package model;

import utils.FileManager;
import utils.RandomCollection;

import java.io.Serializable;

public class Weapon implements Serializable {

    private String name;
    private String type;
    private int damage;
    private double rarety;

    /**
     * Random weapon constructor
     */

    public Weapon() {
        RandomCollection<Weapon> rc = new RandomCollection<>();
        for (Weapon weapon : FileManager.getWeaponsList()) rc.add(weapon.rarety, weapon);

        Weapon weapon = rc.next();

        this.name = weapon.name;
        this.type = weapon.type;
        this.damage = weapon.damage;
        this.rarety = weapon.rarety;
    }

    /**
     * Weapon constructor from xml file
     * @param name
     * @param type
     * @param damage
     * @param rarety
     */

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
