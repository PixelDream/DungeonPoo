package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Enemy implements Serializable {

    private String name;
    private Attack attack;
    private List<Equipment> stuff;

    public Enemy(String name, Attack attack) {
        this.name = name;
        this.attack = attack;
        stuff = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public Attack getAttack() {
        return attack;
    }

}
