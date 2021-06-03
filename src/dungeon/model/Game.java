package dungeon.model;

import dungeon.Main;
import dungeon.utils.*;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Game implements Serializable {
    private int score;
    private boolean gameSucceed;
    private Player player;
    private Difficulty difficulty;
    private Room[][] roomList;
    private int size;

    /**
     * Game constructor
     *
     * @param player     Player of the game
     * @param difficulty Difficulty choose by the player
     */

    public Game(Player player, Difficulty difficulty) {
        this.player = player;
        this.score = 0;
        this.gameSucceed = false;
        this.difficulty = difficulty;
        size = ((int) Math.sqrt(difficulty.getNumberRoom()));

        generateDungeon();

        int x = ClassicMethods.random(0, size - 1);
        int y = ClassicMethods.random(0, size - 1);

        player.move(x, y, Direction.NONE);
        Room room = roomList[x][y];

        room.setVisited(true);
        room.clearChest();
        room.clearEnemy();
        room.clearTrap();
    }

    /**
     * Launch game method
     */

    public void launchGame() {
        this.saveGame();
        showMap();
        nextRound();
    }

    /**
     * Open saved game from file methode
     *
     * @return saved Game
     * @throws IOException Because we open a file
     */

    public static Game openGame() throws IOException {
        return (Game) Main.fm().openSavedObject("game-saved.bin");
    }

    /**
     * Save game to file method
     */

    public void saveGame() {
        Main.fm().saveObject(this, "game-saved.bin");
    }

    public void looseGame() {
        Console.afficheln("Vous n'avez plus de vie");
        Console.afficheln("Vous avez perdu !");
        System.exit(0);
    }

    public void winGame() {
        Console.afficheln("Vous avez gagné le jeu ! Super !");
        System.exit(0);
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

                if (ClassicMethods.random(0, 10) < luckTrap * 10) {
                    RandomCollection<Trap> rc = new RandomCollection<>();
                    for (Trap trap : FileManager.getTrapsList()) rc.add(trap.getRarety(), trap);

                    Trap trap = rc.next();

                    room.setTrap(trap);
                }

                if (ClassicMethods.random(0, 10) < luckChest * 10) {
                    RandomCollection<Weapon> rc = new RandomCollection<>();
                    for (Weapon weapon : FileManager.getWeaponsList()) rc.add(weapon.getRarety(), weapon);

                    Weapon weapon = rc.next();

                    room.setChest(new Chest(weapon));
                }

                if (ClassicMethods.random(0, 10) < luckEnemy * 10) {
                    RandomCollection<Enemy> rc = new RandomCollection<>();
                    for (Enemy e : FileManager.getEnemiesList()) rc.add(1, e);

                    Enemy enemy = rc.next();

                    room.setEnemy(enemy);
                }

                roomList[x][y] = room;
            }
        }

    }

    /**
     * Changing round method
     */

    public void nextRound() {
        Console.afficheln("Ou voulez-vous allez ?");

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

        Console.afficheInLine("\nQuel est votre choix: ");

        String ligne = Interaction.lireString();
        int choix = -1;

        try {
            choix = Integer.parseInt(ligne);
        } catch (NumberFormatException e) {
            Console.affiche("Merci d'entrer un nombre");
        }

        while (!possibleMoves.contains(choix)) {
            Console.afficheInLine("\nQuel est votre choix: ");
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

        checkEvents();

        checkEndGame();

        if (!gameSucceed) launchGame();
    }

    private void checkEndGame() {
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                if (!roomList[x][y].isVisited()) {
                    return;
                }
            }
        }

        fightBoss();
    }

    private void fightBoss() {
        gameSucceed = true;

        int lifePoint = ClassicMethods.random(60, 80);

        Enemy boss = new Enemy("Boss", lifePoint, FileManager.getListAttacks());

        getCurentRoom().setEnemy(boss);

        checkEvents();

        winGame();
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
                        strBuilder.append("✓");
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

    public boolean isGameSucceed() {
        return gameSucceed;
    }

    public Player getPlayer() {
        return player;
    }
}
