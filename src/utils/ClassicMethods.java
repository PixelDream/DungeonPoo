package utils;

public class ClassicMethods {

    public static int random(int min, int max) {
        return min + (int) (Math.random() * ((max - min) + 1));
    }

}
