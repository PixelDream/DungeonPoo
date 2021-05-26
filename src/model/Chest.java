package model;

import utils.FileManager;
import utils.RandomCollection;

import java.io.Serializable;

public class Chest implements Serializable {

    private Weapon weapon;

    /**
     * Chest constructor
     */

    public Chest() {
        weapon = new Weapon();
    }

    public Weapon getWeapon() {
        return weapon;
    }

}
