package model;

import utils.ClassicMethods;
import utils.FileManager;
import utils.RandomCollection;

import java.io.Serializable;

public class Trap implements Serializable {

    private String name;
    private int damage;
    private double rarety;

    public Trap() {
        RandomCollection<Trap> rc = new RandomCollection<>();
        for (Trap trap : FileManager.getTrapsList()) rc.add(trap.rarety, trap);

        Trap trap = rc.next();
        this.name = trap.name;
        this.damage = trap.damage;
        this.rarety = trap.rarety;

        System.out.println(trap.getName());
    }

    /*public Trap(){
        int totalLuck = 0;
        for (Trap trap : FileManager.getTrapsList()) {
            totalLuck += trap.rarety*10;
        }

        int randomNb = ClassicMethods.random(1,totalLuck);

        int calculatinLuck = 0;
        int chiffreAvant=0;
        for (Trap trap : FileManager.getTrapsList()) {
            calculatinLuck += trap.rarety*10;
            System.out.println("total: " + totalLuck + " random: " + randomNb);
            System.out.println(calculatinLuck);
            if(randomNb>chiffreAvant&&randomNb<=calculatinLuck) {
                this.name = trap.name;
                this.damage = trap.damage;
                this.rarety = trap.rarety;
            }
            chiffreAvant=calculatinLuck;
        }
    }*/

    public Trap(String name, int damage, double rarety) {
        this.name = name;
        this.damage = damage;
        this.rarety = rarety;
    }

    public String getName() {
        return name;
    }

    public int getDamage() {
        return damage;
    }

    public double getRarety() {
        return rarety;
    }

    @Override
    public String toString() {
        return "Trap{" +
                "name='" + name + '\'' +
                ", damage=" + damage +
                ", rarety=" + rarety +
                '}';
    }
}
