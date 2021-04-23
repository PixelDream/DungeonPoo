import model.Difficulty;
import model.Game;
import model.Player;
import utils.FileManager;

public class Main {

    public static void main(String[] args) {
        new FileManager("DungeonPoo");

        Player player = new Player("John", 100);
        Game game = new Game(player, Difficulty.DIFFICULT);

        game.launchGame();

        game.saveGame();

        System.out.println("Hello World!");
    }
}
