package utils;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Interaction {
    private static Set<Character> keys = new HashSet<Character>();

    private static Scanner entree = new Scanner(System.in);

    /**
     * Read user entry method
     * @return
     */

    public static String lireString() {
        return entree.nextLine();
    }

    /**
     * Sleep for 1 second method
     * @param sec
     */

    public static void pause(int sec) {
        try {
            Thread.sleep((sec * 1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
