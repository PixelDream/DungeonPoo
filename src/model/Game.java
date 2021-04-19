package model;

public class Game {
    private int gameNumber;
    private int score;
    private boolean gameSucceed;
    private Player player;
    private Room room;

    public Game(Player player){
        this.player = player;
        this.gameNumber = 0;
        this.score = 0;
        this.gameSucceed = false;

        generateDungeon();
    }

    public void launchGame(){

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
