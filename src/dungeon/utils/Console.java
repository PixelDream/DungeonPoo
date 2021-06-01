package dungeon.utils;

public class Console {

    /**
     * Show info in console method
     * @param s A string
     */

    public static void info(String s) {
        System.out.println("\t" + s);
    }

    /**
     * One line console print method
     * @param s A string
     */

    public static void afficheInLine(String s) {
        System.out.print(s);
    }

    /**
     * Show text in console with 1 second interval method
     * @param s A string
     */

    public static void affiche(String s) {
        System.out.println(s);
        Interaction.pause(1);
    }

    /**
     * Show to the line text in console method
     * @param s A string
     */

    public static void afficheln(String s) {
        affiche("\n" + s);
    }

    /**
     * Show game name method
     */

    public static void afficherNomJeu() {
        info("____  _   _ _   _  ____ _____ ___  _   _");
        info("|  _ \\| | | | \\ | |/ ___| ____/ _ \\| \\ | |");
        info("| | | | | | |  \\| | |  _|  _|| | | |  \\| |");
        info("| |_| | |_| | |\\  | |_| | |__| |_| | |\\  |");
        info("|____/ \\___/|_| \\_|\\____|_____\\___/|_| \\_|\n");
    }
}
