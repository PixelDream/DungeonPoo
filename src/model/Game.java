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
    private static FileManager fm = new FileManager("DungeonPoo");

    public Game(Player player, Difficulty difficulty) {
        this.player = player;
        this.gameNumber = 0;
        this.score = 0;
        this.gameSucceed = false;
        this.difficulty = difficulty;

        generateDungeon();
    }

    public void launchGame() {
        System.out.println("LuckChest: " + difficulty.getLuckChest());
        System.out.println("LuckTrap: " + difficulty.getLuckTrap());
        System.out.println("LuckEnemy: " + difficulty.getLuckEnemy());
        System.out.println("NumberRoom: " + difficulty.getNumberRoom());
        System.out.println("NumberRoomMax: " + difficulty.getNumberRoomMax());
    }

    public void saveGame() {
        fm.saveObject(this, "game-saved.bin");
    }

    public static Game openGame(){
        return (Game) fm.openSavedObject("game-saved.bin");
    }

    private void generateDungeon() {
        int numberRoomMax = difficulty.getNumberRoomMax();
        numberRoomMax = 9;
        int numberRoom = difficulty.getNumberRoom();
        numberRoom = 3;
        double luckChest = difficulty.getLuckChest();
        double luckTrap = difficulty.getLuckTrap();
        double luckEnemy = difficulty.getLuckEnemy();

        // Faire une matrice de taille numberRoomMax
        int size = ((int) Math.sqrt(numberRoomMax));
        int[][] dungeon = new int[size][size];

        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                dungeon[i][j] = 1;

        // Enlever certaines rooms
        int diffRoom = numberRoomMax - numberRoom;

        for (int i = 0; i < diffRoom; i++) {
            int x = random(0, size - 1), y = random(0, size - 1);
            if (dungeon[x][y] != 0) {
                dungeon[x][y] = 0;
            } else {
                i--;
            }
        }

        // Mettre les numéros de room dans une liste
        int[] roomList = new int[numberRoomMax];
        int k = 0;
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                roomList[k++] = dungeon[i][j];

        // Generer les liens entre les salles avec la matrice
        int[][] coords = new int[numberRoom][numberRoom];
        System.out.println("Taille numberRoom: " + numberRoom);
        for (int i = 0; i < numberRoom; i++) {
            for (int j = 0; j < numberRoom; j++) {
                System.out.println((roomList[i] == 1 && roomList[j] == 1 && i != j) + " ==> " + i + " et " + j + " ==> " + roomList[i] + " == " + 1 + " && " + roomList[j] + " == " + 1 + " && " + i + " != " + j);
                if (roomList[i] == 1 && roomList[j] == 1 && i != j) {
                    coords[i][j] = random(0, numberRoom);
                    coords[j][i] = coords[i][j];
                }
            }
        }

        // Parcourir la matrice de liens et faire les rooms
        int numberRoomX2 = numberRoom * numberRoom;
        int l = 0, m = 0, n = 0, acc = 0;

        while (l < numberRoomX2) {

            while (m < numberRoom) {
                while (n < acc) {
//                    Room room = new Room();
//
//                    if (this.room == null) {
//                        this.room = room;
//                    } else {
//                        Door door = new Door();
//                        this.room.addDoor(door);
//                    }
                    n++;
                }
                m++;
                acc++;
            }

            l++;
        }

        // [DEBUG] Afficher la matrice
        System.out.println("Matrice simple");
        for (int i = 0; i < dungeon.length; i++) {
            for (int j = 0; j < dungeon[0].length; j++) {
                System.out.print(dungeon[i][j] + "\t");
            }
            System.out.println();
        }

        // [DEBUG] Afficher la matrice
        System.out.println("Matrice symétrique");
        for (int i = 0; i < coords.length; i++) {
            for (int j = 0; j < coords[0].length; j++) {
                System.out.print(coords[i][j] + "\t");
            }
            System.out.println();
        }

    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public int random(int min, int max) {
        return min + (int) (Math.random() * ((max - min) + 1));
    }

}
