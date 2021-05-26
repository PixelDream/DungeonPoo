package utils;

public class ClassicMethods {

    /**
     * Random number generator
     * @param min
     * @param max
     * @return
     */

    public static int random(int min, int max) {
        return min + (int) (Math.random() * ((max - min) + 1));
    }

}
