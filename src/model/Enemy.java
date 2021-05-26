package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Enemy implements Serializable {

    private String name;
    private List<Attack> attacks;
    private Weapon weapon;

    /**
     * Enemy constructor
     */

    public Enemy(String name, Attack attack) {
        this.name = name;
        this.attack = attack;
        stuff = new ArrayList<>();
    }

    public Enemy(String name, List<Attack> attacks) {
        this.name = name;
        this.attacks = attacks;
    }

    public String getName() {
        return name;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }
}
