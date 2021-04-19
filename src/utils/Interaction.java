package utils;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Interaction {
    private static Set<Character> keys = new HashSet<Character>();

    private static Scanner entree = new Scanner(System.in);

    public static String lireString() {
        return entree.nextLine();
    }

    public static void resetKeys() {
        keys = new HashSet<Character>();
    }

    public static void acceptKey(char c) {
        keys.add(new Character(c));
    }

    public static char readAction() {
        boolean out = false;
        while (true) {
            Console.affiche(" => ");
            char c = entree.next(".*").charAt(0);
            for (Character car : keys) {
                if (Character.toUpperCase(car.charValue()) == Character.toUpperCase(c))
                    out = true;
            }
            if (out) {
                entree.nextLine();
                return c;
            }
        }
    }

    public static void pause(int sec) {
        try {
            Thread.sleep((sec * 1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static int randomPrct() {
        return (int)(Math.random() * 100.0D);
    }
}
