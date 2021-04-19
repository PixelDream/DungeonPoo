package model;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private String position;
    private String direction;
    private String username;
    private int lifePoint;
    private String attack;
    private List<Equipment> stuff;

    public Player(String position, String direction, String username, int lifePoint, String attack) {
        this.position = position;
        this.direction = direction;
        this.username = username;
        this.lifePoint = lifePoint;
        this.attack = attack;
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
