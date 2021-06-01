package dungeon.model;

import java.io.Serializable;

public class Room implements Serializable {

    private Position position;
    private Chest chest;
    private Enemy enemy;
    private Trap trap;
    private boolean visited = false;

    /**
     * Room constructor
     * @param position The position of the room
     */

    public Room(Position position) {
        this.position = position;
    }

    public boolean hasChest() {
        return chest != null;
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

    public boolean hasEnemy() {
        return enemy != null;
    }

    public Enemy getEnemy() {
        return enemy;
    }

    public void setEnemy(Enemy enemy) {
        this.enemy = enemy;
    }

    public boolean hasTrap() {
        return trap != null;
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

    public void clearEnemy() {
        this.enemy = null;
    }

    public void clearChest() {
        this.chest = null;
    }
}
