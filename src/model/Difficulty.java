package model;

import java.io.Serializable;

public enum Difficulty implements Serializable {

    EASY(25,20, 0.8, 0.3, 0.3),
    NORMAL(49,35, 0.65, 0.45, 0.4),
    DIFFICULT(64,50, 0.5, 0.55, 0.5),
    HARDCORE(121,100, 0.3, 0.85, 0.75);

    private int numberRoomMax;
    private int numberRoom;
    private double luckChest;
    private double luckEnemy;
    private double luckTrap;

    Difficulty(int numberRoomMax, int numberRoom, double luckChest, double luckEnemy, double luckTrap) {
        this.numberRoomMax = numberRoomMax;
        this.numberRoom = numberRoom;
        this.luckChest = luckChest;
        this.luckEnemy = luckEnemy;
        this.luckTrap = luckTrap;
    }

    public int getNumberRoomMax() {
        return numberRoomMax;
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
