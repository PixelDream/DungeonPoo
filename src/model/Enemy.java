package model;

import utils.FileManager;
import utils.RandomCollection;

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

    public Enemy() {
        RandomCollection<Enemy> rc = new RandomCollection<>();
        for (Enemy e : FileManager.getEnemiesList()) rc.add(1, e);

        Enemy enemy = rc.next();

        this.name = enemy.name;

        this.damage = weapon.damage;
        this.rarety = weapon.rarety;
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
