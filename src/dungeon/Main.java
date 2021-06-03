package dungeon;

import dungeon.model.Difficulty;
import dungeon.model.Game;
import dungeon.model.Player;
import dungeon.utils.Console;
import dungeon.utils.FileManager;
import dungeon.utils.Interaction;

import java.io.IOException;

public class Main {
    private static FileManager fm;
    private static Game game;

    public static void main(String[] args) {
        fm = new FileManager("DungeonPoo");

        Console.afficherNomJeu();
        Console.afficheln("La partie est automatiquement sauvegardé, vous pouvez reprendre à tout moment.");


        try {
            game = Game.openGame();

            Console.afficheInLine("Voulez-vous reprendre une partie : (O/N) ");
            String res = Interaction.lireString();

            if (res.equalsIgnoreCase("Oui") || res.equalsIgnoreCase("O")) {
                Console.afficheln("Bonjour " + game.getPlayer().getUsername() + " !");
                game.launchGame();
            } else {
                newGame();
            }

        } catch (IOException e) {
            newGame();
        }
    }

    public static void newGame() {
        Console.afficheInLine("Quel est votre nom : ");
        String nom = Interaction.lireString();

        Player player = new Player(nom, 150);

        Difficulty difficulty = null;

        while (difficulty == null) {
            Console.afficheInLine("Quel est la difficulté (Facile, Normal, Difficile, Hardcore) : ");
            String diff = Interaction.lireString();

            switch (diff.toLowerCase()) {
                case "facile" -> difficulty = Difficulty.EASY;
                case "normal" -> difficulty = Difficulty.NORMAL;
                case "difficile" -> difficulty = Difficulty.DIFFICULT;
                case "hardcore" -> difficulty = Difficulty.HARDCORE;
                default -> difficulty = Difficulty.NORMAL;
            }

        }


        game = new Game(player, difficulty);
        game.launchGame();
    }

    public static FileManager fm() {
        return fm;
    }

    public static Game getGame() {
        return game;
    }
}
