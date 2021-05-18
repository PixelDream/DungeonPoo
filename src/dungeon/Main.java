package dungeon;

import model.Difficulty;
import model.Game;
import model.Player;
import model.Trap;
import utils.FileManager;

public class Main {
    private static FileManager fm;

    public static void main(String[] args) {
        Player player = new Player("John", 100);
        Game game = new Game(player, Difficulty.EASY);
        fm = new FileManager("DungeonPoo");
        System.out.println(game);

        game.launchGame();

        System.out.println("----------------------------------------------------------");

        Trap trap = new Trap();

        System.out.println("\n--------------\n"+trap);
    }

    public static FileManager fm() {
        return fm;
    }
}
