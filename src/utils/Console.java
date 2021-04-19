package utils;

public class Console {
    public static void info(String s) {
        System.out.println("\t" + s);
    }

    public static void affiche(String s) {
        System.out.println(s);
        Interaction.pause(1);
    }

    public static void afficheln(String s) {
        affiche("\n" + s);
    }
}
