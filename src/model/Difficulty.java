package model;

import java.io.Serializable;

public enum Difficulty implements Serializable {

    EASY(20, 0.8, 0.3, 0.3),
    NORMAL(35, 0.65, 0.45, 0.4),
    DIFFICULT(50, 0.5, 0.55, 0.5),
    HARDCORE(100, 0.3, 0.85, 0.75);

    private final int numberRoom;
    private final double luckChest;
    private final double luckEnemy;
    private final double luckTrap;

    /**
     * Difficulty constructor
     * @param numberRoom
     * @param luckChest
     * @param luckEnemy
     * @param luckTrap
     */

    Difficulty(int numberRoom, double luckChest, double luckEnemy, double luckTrap) {
        this.numberRoom = numberRoom;
        this.luckChest = luckChest;
        this.luckEnemy = luckEnemy;
        this.luckTrap = luckTrap;
    }

    public int getNumberRoom() {
        return numberRoom;
    }

    public double getLuckChest() {
        return luckChest;
    }

    public double getLuckEnemy() {
        return luckEnemy;
    }

    public double getLuckTrap() {
        return luckTrap;
    }
}
