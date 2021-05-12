package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Player implements Serializable {

    private Room position;
    private Direction direction;
    private String username;
    private int lifePoint;
    private List<Equipment> stuff;

    public Player(String username, int lifePoint) {
        this.username = username;
        this.lifePoint = lifePoint;
        stuff = new ArrayList<>();
    }

    public void move(){

    }

    public void fight(Enemy enemy){

    }

    public void fleeTheFight(){
        // fuire un combat
    }

    public void parry(){
        // parer une attaque
    }
}
