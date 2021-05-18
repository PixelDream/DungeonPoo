package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Player implements Serializable {

    private Position position;
    private String username;
    private int lifePoint;
    private List<Equipment> stuff;

    public Player(String username, int lifePoint) {
        this.username = username;
        this.lifePoint = lifePoint;
        stuff = new ArrayList<>();
        position = new Position(0, 0);
    }

    public void move(int x, int y, Direction direction){
        position.updateCoords(x, y, direction);
    }

    public void fight(Enemy enemy){

    }

    public void fleeTheFight(){
        // fuire un combat
    }

    public void parry(){
        // parer une attaque
    }

    public Position getPosition() {
        return position;
    }

}
