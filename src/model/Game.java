package model;

import controller.Main;
import utils.ClassicMethods;
import utils.Console;
import utils.Interaction;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Game implements Serializable {
    private int gameNumber;
    private int score;
    private boolean gameSucceed;
    private Player player;
    private Difficulty difficulty;
    private Room[][] roomList;
    private int size;

    /**
     * Game constructor
     *
     * @param player
     * @param difficulty
     */

    public Game(Player player, Difficulty difficulty) {
        this.player = player;
        this.gameNumber = 0;
        this.score = 0;
        this.gameSucceed = false;
        this.difficulty = difficulty;
        size = ((int) Math.sqrt(difficulty.getNumberRoom()));

        generateDungeon();
        saveGame();

    }

    /**
     * Open saved game from file methode
     *
     * @return saved Game
     * @throws IOException
     */

    public static Game openGame() throws IOException {
        return (Game) Main.fm().openSavedObject("game-saved.bin");
    }

    /**
     * Launch game method
     */

    public void launchGame() {
        showMap();
        nextRound();
    }

    /**
     * Save game to file method
     */

    public void saveGame() {
        Main.fm().saveObject(this, "game-saved.bin");
    }

    /**
     * Show map method
     */

    public void showMap() {
        System.out.println(this);
    }

    /**
     * Generation of the dungeon's rooms method
     */

    private void generateDungeon() {
        int numberRoom = difficulty.getNumberRoom();
        double luckChest = difficulty.getLuckChest();
        double luckTrap = difficulty.getLuckTrap();
        double luckEnemy = difficulty.getLuckEnemy();

        // Faire une matrice de taille numberRoomMax
        Position.MAX_XY = size;
        roomList = new Room[size][size];

        // Génération des pièces
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                Room room = new Room(new Position(x, y));

                if (ClassicMethods.random(0, 10) < luckTrap * 10) room.setTrap(new Trap());
                if (ClassicMethods.random(0, 10) < luckChest * 10) room.setChest(new Chest());
                if (ClassicMethods.random(0, 10) < luckEnemy * 10) room.setEnemy(new Enemy());

                //TODO: numberRoom Use

                roomList[x][y] = room;
            }
        }

    }

    /**
     * Changing round method
     */

    public void nextRound() {
        Console.afficheln("Ou voulez-vous allez ?");

        // C'est dans le sens oppossé
        List<Integer> possibleMoves = new ArrayList<>();

        if (player.getPosition().getX() - 1 < size && player.getPosition().getX() - 1 >= 0) {
            possibleMoves.add(1);
            if (player.getPosition().getDirection().equals(Direction.SOUTH)) {
                Console.info("1 - North (En arrière)");
            } else {
                Console.info("1 - North");
            }
        }

        if (player.getPosition().getX() + 1 < size && player.getPosition().getX() + 1 >= 0) {
            possibleMoves.add(2);
            if (player.getPosition().getDirection().equals(Direction.NORTH)) {
                Console.info("2 - South (En arrière)");
            } else {
                Console.info("2 - South");
            }
        }

        if (player.getPosition().getY() - 1 < size && player.getPosition().getY() - 1 >= 0) {
            possibleMoves.add(3);
            if (player.getPosition().getDirection().equals(Direction.WEST)) {
                Console.info("3 - West (En arrière)");
            } else {
                Console.info("3 - West");
            }
        }

        if (player.getPosition().getY() + 1 < size && player.getPosition().getY() + 1 >= 0) {
            possibleMoves.add(4);
            if (player.getPosition().getDirection().equals(Direction.EAST)) {
                Console.info("4 - East (En arrière)");
            } else {
                Console.info("4 - East");
            }
        }

        Console.affiche("Quel est votre choix: ");
        String ligne = Interaction.lireString();
        int choix = -1;
        try {
            choix = Integer.parseInt(ligne);
        } catch (NumberFormatException e) {
            Console.affiche("Merci d'entrer un nombre");
        }

        while (!possibleMoves.contains(choix)) {
            Console.affiche("Quel est votre choix: ");
            ligne = Interaction.lireString();
            try {
                choix = Integer.parseInt(ligne);
            } catch (NumberFormatException e) {
                Console.affiche("Merci d'entrer un nombre");
            }
        }

        switch (choix) {
            case 1 -> player.move(player.getPosition().getX() - 1, player.getPosition().getY(), Direction.NORTH);
            case 2 -> player.move(player.getPosition().getX() + 1, player.getPosition().getY(), Direction.SOUTH);
            case 3 -> player.move(player.getPosition().getX(), player.getPosition().getY() - 1, Direction.EAST);
            case 4 -> player.move(player.getPosition().getX(), player.getPosition().getY() + 1, Direction.WEST);
            default -> {
                nextRound();
                Console.afficheln("Ce n'est pas une bonne manipulation...");
            }
        }

        getCurentRoom().setVisited(true);

        if (getCurentRoom().getTrap() != null) Console.info("Un piège: " + getCurentRoom().getTrap().getName());

        this.saveGame();

        checkEvents();

        showMap();

        nextRound();
    }

    /**
     * Check if there's any enemy/chest in the actual room method
     */

    private void checkEvents() {
        Room room = roomList[player.getPosition().getX()][player.getPosition().getY()];

        if (room.hasEnemy()) player.fight(room.getEnemy());
        if (room.hasChest()) player.openChest(room.getChest());
        if (room.hasTrap()) player.trapped(room.getTrap());
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Room getCurentRoom() {
        return roomList[player.getPosition().getX()][player.getPosition().getY()];
    }


    @Override
    public String toString() {
        StringBuilder strBuilder = new StringBuilder("\n");

        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                Position pos = player.getPosition();
                if (x == pos.getX() && y == pos.getY()) {
                    strBuilder.append("| ");

                    switch (pos.getDirection()) {
                        case NORTH -> strBuilder.append("▲");
                        case EAST -> strBuilder.append("◀");
                        case SOUTH -> strBuilder.append("▼");
                        case WEST -> strBuilder.append("▶");
                        default -> strBuilder.append("⭕");
                    }

                    strBuilder.append(" |  ");
                } else {
                    strBuilder.append("| ");

                    if (roomList[x][y].isVisited()) {
                        strBuilder.append("Ok");
                    } else {
                        strBuilder.append("?");
                    }

                    strBuilder.append(" |  ");
                }
            }

            strBuilder.append("\n");
        }

        return strBuilder.toString();
    }
}
