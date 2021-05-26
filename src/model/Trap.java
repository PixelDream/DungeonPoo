package model;

import utils.ClassicMethods;
import utils.FileManager;
import utils.RandomCollection;

import java.io.Serializable;

public class Trap implements Serializable {

    private String name;
    private int damage;
    private double rarety;

    /**
     * Random trap constructor
     */

    public Trap() {
        RandomCollection<Trap> rc = new RandomCollection<>();
        for (Trap trap : FileManager.getTrapsList()) rc.add(trap.rarety, trap);

        Trap trap = rc.next();
        this.name = trap.name;
        this.damage = trap.damage;
        this.rarety = trap.rarety;
    }

    /**
     * Trap constructor from xml file
     * @param name
     * @param damage
     * @param rarety
     */

    public Trap(String name, int damage, double rarety) {
        this.name = name;
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

    @Override
    public String toString() {
        return "Trap{" +
                "name='" + name + '\'' +
                ", damage=" + damage +
                ", rarety=" + rarety +
                '}';
    }
}
