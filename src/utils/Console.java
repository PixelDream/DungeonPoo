package utils;

public class Console {
    public static void info(String s) {
        System.out.println("\t" + s);
    }

    public static void afficheInLine(String s) {
        System.out.print(s);
    }

    public static void affiche(String s) {
        System.out.println(s);
        Interaction.pause(1);
    }

    public static void afficheln(String s) {
        affiche("\n" + s);
    }

    public static void afficherNomJeu() {
        info("____  _   _ _   _  ____ _____ ___  _   _");
        info("|  _ \\| | | | \\ | |/ ___| ____/ _ \\| \\ | |");
        info("| | | | | | |  \\| | |  _|  _|| | | |  \\| |");
        info("| |_| | |_| | |\\  | |_| | |__| |_| | |\\  |");
        info("|____/ \\___/|_| \\_|\\____|_____\\___/|_| \\_|\n");
    }
}
