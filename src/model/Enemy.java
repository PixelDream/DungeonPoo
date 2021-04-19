package model;

public class Enemy {

    private String name;
    private Attack attack;

    public Enemy(String name, Attack attack) {
        this.name = name;
        this.attack = attack;
    }

    public String getName() {
        return name;
    }

    public Attack getAttack() {
        return attack;
    }
}
