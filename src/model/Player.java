package model;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private String position;
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

    public void fleeTheFight(){
        // fuire un combat
    }

    public void parry(){
        // parer une attaque
    }
}
