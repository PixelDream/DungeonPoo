package dungeon.utils;

import java.util.Scanner;

public class Interaction {
    private static Scanner entree = new Scanner(System.in);

    /**
     * Read user entry method
     *
     * @return User entry
     */

    public static String lireString() {
        return entree.nextLine();
    }

    /**
     * Sleep for 1 second method
     *
     * @param sec The time we want to wait
     */

    public static void pause(int sec) {
        try {
            Thread.sleep((sec * 1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
