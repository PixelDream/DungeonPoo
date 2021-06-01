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
     * @param username
     * @param lifePoint
     */

    public Player(String username, int lifePoint) {
        this.username = username;
        this.lifePoint = lifePoint;
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
        Console.afficheln(enemy.getName() + " vous attaque ! (" + enemy.getLifePoint() + "pv)");

        if (fleeTheFight()) return;

        while (enemy.inLife()) {
            int attackStrength = ClassicMethods.random(0, enemy.getLifePoint());
            lifePoint -= attackStrength;

            if (lifePoint <= 0) break;

            attackStrength = ClassicMethods.random(0, enemy.getLifePoint());
            enemy.removeLifePoint(attackStrength);

            Console.afficheln("Vous avez " + lifePoint + "pv et l'ennemie a " + enemy.getLifePoint() + "pv");
        }

        if (lifePoint <= 0) {
            Console.afficheln("Vous n'avez plus de vie");
            Console.afficheln("Vous avez perdu !");
            return;
        }

        Main.getGame().getCurentRoom().clearEnemy();
    }

    /**
     * Flee a fight method
     * @return
     */

    public boolean fleeTheFight(){
        boolean isFlee = false;
        Console.afficheInLine("Vous voulez fuir le combat (Oui, Non) : ");
        String res = Interaction.lireString();
        switch (res.toLowerCase()) {
            case "oui" -> isFlee = true;
            case "non" -> isFlee = false;
        }

        return isFlee;
    }

    /**
     * Parry an attack method
     */

    public void parry(){
        // parer une attaque
    }

    public void trapped(Trap trap) {
        //TODO: Text
        Console.afficheln("Vous êtes tombé dans " + trap.getName());
        lifePoint -= trap.getDamage();
    }

    /**
     * Open chest method
     * @param chest
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
