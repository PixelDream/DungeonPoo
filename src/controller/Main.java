package controller;

import model.Difficulty;
import model.Game;
import model.Player;
import model.Trap;
import utils.Console;
import utils.FileManager;
import utils.Interaction;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    private static FileManager fm;

    public static void main(String[] args) {
        fm = new FileManager("DungeonPoo");

        Console.afficherNomJeu();

        try {
            Game game = Game.openGame();

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

        Game game = new Game(player, Difficulty.EASY);
        game.launchGame();
    }

    public static FileManager fm() {
        return fm;
    }
}
