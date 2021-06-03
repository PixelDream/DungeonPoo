package dungeon.model;

import java.io.Serializable;

public class Chest implements Serializable {

    private Weapon weapon;

    /**
     * Chest constructor
     * Generate a chest with a random Weapon inside
     *
     * @param weapon
     */

    public Chest(Weapon weapon) {
        this.weapon = weapon;
    }

    public Weapon getWeapon() {
        return weapon;
    }

}
