package controller;

import model.Difficulty;
import model.Game;
import model.Player;
import utils.Console;
import utils.FileManager;
import utils.Interaction;

import java.io.IOException;

public class Main {
    private static FileManager fm;
    private static Game game;

    public static void main(String[] args) {
        fm = new FileManager("DungeonPoo");

        Console.afficherNomJeu();

        try {
            game = Game.openGame();

            Console.afficheInLine("Voulez-vous reprendre une partie : (O/N) ");
            String res = Interaction.lireString();

            if (res.equalsIgnoreCase("Oui") || res.equalsIgnoreCase("O")) {
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

        Player player = new Player(nom, 100);

        Difficulty difficulty = null;

        while (difficulty == null) {
            Console.afficheInLine("Quel est la difficulté (Facile, Normal, Difficile, Hardcore) : ");
            String diff = Interaction.lireString();

            switch (diff) {
                case "Facile" -> difficulty = Difficulty.EASY;
                case "Normal" -> difficulty = Difficulty.NORMAL;
                case "Difficile" -> difficulty = Difficulty.DIFFICULT;
                case "Hardcore" -> difficulty = Difficulty.HARDCORE;
                default -> difficulty = Difficulty.NORMAL;
            };
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
