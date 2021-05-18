package model;

import dungeon.Main;
import utils.ClassicMethods;
import utils.FileManager;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Game implements Serializable {
    private int gameNumber;
    private int score;
    private boolean gameSucceed;
    private Player player;
    private Room room;
    private Difficulty difficulty;
    private Room[][] roomList;

    public Game(Player player, Difficulty difficulty) {
        this.player = player;
        this.gameNumber = 0;
        this.score = 0;
        this.gameSucceed = false;
        this.difficulty = difficulty;

        generateDungeon();

        player.faireAction();
    }

    public void launchGame() {
        System.out.println("LuckChest: " + difficulty.getLuckChest());
        System.out.println("LuckTrap: " + difficulty.getLuckTrap());
        System.out.println("LuckEnemy: " + difficulty.getLuckEnemy());
        System.out.println("NumberRoom: " + difficulty.getNumberRoom());
        System.out.println("NumberRoomMax: " + difficulty.getNumberRoomMax());
    }

    public void saveGame() {
        Main.fm().saveObject(this, "game-saved.bin");
    }

    public static Game openGame(){
        return (Game) Main.fm().openSavedObject("game-saved.bin");
    }

    private void generateDungeon() {
        int numberRoom = difficulty.getNumberRoom();
        double luckChest = difficulty.getLuckChest();
        double luckTrap = difficulty.getLuckTrap();
        double luckEnemy = difficulty.getLuckEnemy();

        final int size = ((int) Math.sqrt(difficulty.getNumberRoomMax()));

        // Faire une matrice de taille numberRoomMax
        Position.MAX_XY = size;
        roomList = new Room[size][size];

        // Génération des pièces
        for(int x = 0; x < size; x++) {
            for(int y = 0; y < size; y ++ ) {
                Room room = new Room(new Position(x, y));

                if(ClassicMethods.random(0,10) < luckChest * 10){
                    Chest chest = new Chest();
                    room.addChest(chest);
                }

                roomList[x][y] = room;
            }
        }

    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    @Override
    public String toString() {
        StringBuilder strBuilder = new StringBuilder("\n");

        final int size = ((int) Math.sqrt(difficulty.getNumberRoomMax()));

        for (int x = 0; x < size; x++) {
            //if (x == 0) strBuilder.append(repeatString("_", size*5) + "\n");
            for (int y = 0; y < size; y++) {
                Position pos = player.getPosition();
                if (x == pos.getX() && y == pos.getY()) {
                    strBuilder.append("| " + "⭕" + " |  ");
                } else {
                    strBuilder.append("| " + "?" + " |  ");
                }
            }

            strBuilder.append("\n");
            //if (x == size-1) strBuilder.append(repeatString("_", size*5) + "\n");
        }

        strBuilder.append("\n");

        return strBuilder.toString();
    }

//    private String repeatString(String str, int occ) {
//        StringBuilder strBuilder = new StringBuilder();
//        for (int i = 0; i < occ; i++) strBuilder.append(str);
//
//        return strBuilder.toString();
//    }
}
