package model;

import controller.Main;
import utils.ClassicMethods;
import utils.Console;
import utils.Interaction;

import java.io.Serializable;

public class Player implements Serializable {

    private Position position;
    private String username;
    private int lifePoint;
    private Weapon weapon;

    /**
     * Player constructor
     * @param username Name of the player
     * @param lifePoint Initial lifepoint of the player
     */

    public Player(String username, int lifePoint) {
        this.username = username;
        this.lifePoint = lifePoint;
        position = new Position(0, 0);
    }

    /**
     * Change room method
     * @param x update x position of the player
     * @param y update y position of the player
     * @param direction update the direction of the player
     */

    public void move(int x, int y, Direction direction){
        position.updateCoords(x, y, direction);
    }

    /**
     * Begin a fight method
     * @param enemy The enemy the player is gonna fight
     */

    public void fight(Enemy enemy){
        Console.afficheln(enemy.getName() + " vous attaque ! (" + enemy.getLifePoint() + "pv)");

        if (fleeTheFight()) return;

        int enemyLifePoint = enemy.getLifePoint() / 2;

        while (enemy.inLife()) {
            int attackStrength = ClassicMethods.random(0, enemy.getLifePoint());
            lifePoint -= attackStrength;

            if (lifePoint <= 0) break;

            attackStrength = ClassicMethods.random(0, enemy.getLifePoint());
            enemy.removeLifePoint(attackStrength);

            Console.afficheln("Vous avez " + lifePoint + "pv et l'ennemie a " + enemy.getLifePoint() + "pv");
        }

        if (lifePoint <= 0) {
            Main.getGame().looseGame();
        }

        Console.afficheln("Vous avez gagné le combat, vous récupérez une potion de vie (+" + enemyLifePoint + "pv)");
        lifePoint += enemyLifePoint;

        Main.getGame().getCurentRoom().clearEnemy();
    }

    /**
     * Flee a fight method
     * @return If yes or not the player is gonna flee the fight with an enemy
     */

    public boolean fleeTheFight(){
        Console.afficheInLine("Vous voulez fuir le combat (Oui, Non) : ");
        String res = Interaction.lireString();

        return res.equalsIgnoreCase("oui");
    }

    /**
     * Fall in a trap method
     * @param trap The trap in which the player fall
     */

    public void trapped(Trap trap) {
        Console.afficheln("Vous êtes tombé dans " + trap.getName());
        lifePoint -= trap.getDamage();
        if (lifePoint <= 0) {
            Main.getGame().looseGame();
        }
    }

    /**
     * Open chest method
     * @param chest The chest which is gonna be open by the player
     */

    public void openChest(Chest chest) {
        Weapon weapon = chest.getWeapon();
        Console.afficheln("un coffre avec : " + weapon.getName() + " Youpi !");

        if (this.weapon != null && weapon.getDamage() > this.weapon.getDamage()) this.weapon = weapon;
    }

    public Position getPosition() {
        return position;
    }

}
