package dungeon.model;

import java.io.Serializable;
import java.util.List;

public class Enemy implements Serializable {

    private String name;
    private int lifePoint;
    private List<Attack> attacks;

    /**
     * Enemy constructor
     * @param name Name of the enemy
     * @param lifePoint Lifepoint of the enemy
     * @param attacks List of enemy's attacks
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
        return lifePoint > 0;
    }

    public int getLifePoint() {
        return lifePoint;
    }

    public void removeLifePoint(int lifePoint) {
        this.lifePoint -= lifePoint;
        if (!inLife()) this.lifePoint = 0;
    }
}
