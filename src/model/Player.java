package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Player implements Serializable {

    private Position position;
    private String username;
    private int lifePoint;
    private Weapon weapon;

    /**
     * Player constructor
     * @param username
     * @param lifePoint
     */

    public Player(String username, int lifePoint) {
        this.username = username;
        this.lifePoint = lifePoint;
        stuff = new ArrayList<>();
        position = new Position(0, 0);
    }

    /**
     * Change room method
     * @param x
     * @param y
     * @param direction
     */

    public void move(int x, int y, Direction direction){
        position.updateCoords(x, y, direction);
    }

    /**
     * Begin a fight method
     * @param enemy
     */

    public void fight(Enemy enemy){

    }

    /**
     * Flee a fight method
     */

    public void fleeTheFight(){
        // fuire un combat
    }

    /**
     * Parry an attack method
     */

    public void parry(){
        // parer une attaque
    }

    public Position getPosition() {
        return position;
    }

}
