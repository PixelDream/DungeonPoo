package model;

import utils.FileManager;
import utils.RandomCollection;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Enemy implements Serializable {

    private String name;
    private int lifePoint;
    private List<Attack> attacks;

    public Enemy() {
        RandomCollection<Enemy> rc = new RandomCollection<>();
        for (Enemy e : FileManager.getEnemiesList()) rc.add(1, e);

        Enemy enemy = rc.next();

        this.name = enemy.name;
        this.attacks = enemy.attacks;
        this.lifePoint = enemy.lifePoint;;
    }

    /**
     * Enemy constructor
     * @param name
     * @param attacks
     */

    public Enemy(String name, int lifePoint, List<Attack> attacks) {
        this.name = name;
        this.lifePoint = lifePoint;
        this.attacks = attacks;
    }

    public String getName() {
        return name;
    }

    public boolean inLife() {
        return lifePoint <= 0;
    }

    public int getLifePoint() {
        return lifePoint;
    }

    public void removeLifePoint(int lifePoint) {
        this.lifePoint -= lifePoint;
        if (!inLife()) this.lifePoint = 0;
    }
}
