package model;

import utils.FileManager;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Game implements Serializable {
    private int gameNumber;
    private int score;
    private boolean gameSucceed;
    private Player player;
    private Room room;
    private Difficulty difficulty;
    private List<Room> roomList = new ArrayList<>();
    private List<Key> keysList;
    private FileManager fm = new FileManager("DungeonPoo");

    public Game(Player player, Difficulty difficulty){
        this.player = player;
        this.gameNumber = 0;
        this.score = 0;
        this.gameSucceed = false;
        this.difficulty = difficulty;

        generateDungeon();
    }

    public void launchGame(){
        System.out.println("LuckChest: " + difficulty.getLuckChest());
        System.out.println("LuckTrap: " + difficulty.getLuckTrap());
        System.out.println("LuckEnemy: " + difficulty.getLuckEnemy());
        System.out.println("NumberRoom: " + difficulty.getNumberRoom());
    }

    public void saveGame(){
        fm.saveObject(this, "game-saved.bin");
    }

    public void openGame(){
        //TODO : fm.openSavedObject("game-saved.bin");
    }

    private void generateDungeon() {
        int NumberRoom = difficulty.getNumberRoom();
        double luckEnemy = difficulty.getLuckChest();
        double LuckTrap = difficulty.getLuckTrap();
        double LuckEnemy = difficulty.getLuckEnemy();

        for (int i = 0; i < NumberRoom; i++) {
            Room room = new Room();

            for (int j = 0; j < random(1, 3); j++) {
                Door door = new Door();
                room.addDoor(door);
            }

            roomList.add(room);
        }
    }

    public int random(int min, int max) {
        return min + (int) (Math.random() * ((max - min) + 1));
    }
}
