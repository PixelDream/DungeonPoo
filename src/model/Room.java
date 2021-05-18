package model;

import java.io.Serializable;

public class Room implements Serializable {

    private Position position;
    private Chest chest;
    private Enemy enemy;
    private Trap trap;
    private boolean visited = false;

    public Room(Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    public Chest getChest() {
        return chest;
    }

    public void setChest(Chest chest) {
        this.chest = chest;
    }

    public Enemy getEnemy() {
        return enemy;
    }

    public void setEnemy(Enemy enemy) {
        this.enemy = enemy;
    }

    public Trap getTrap() {
        return trap;
    }

    public void setTrap(Trap trap) {
        this.trap = trap;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }
}
