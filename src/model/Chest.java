package model;

import utils.FileManager;
import utils.RandomCollection;

import java.io.Serializable;

public class Chest implements Serializable {

    private Weapon weapon;

    /**
     * Chest constructor
     * Generate a chest with a random Weapon inside
     */

    public Chest() {
        this.weapon = new Weapon();
    }

    public Weapon getWeapon() {
        return weapon;
    }

}
