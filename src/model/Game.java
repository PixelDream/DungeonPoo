package model;

public class Game {
    private int gameNumber;
    private int score;
    private boolean gameSucceed;
    private Player player;
    private Room room;
    private Difficulty difficulty;

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

    }

    public void openGame(){

    }

    private void generateDungeon() {
        for (int i = 0; i < 20; i++) {

        }
    }
}
