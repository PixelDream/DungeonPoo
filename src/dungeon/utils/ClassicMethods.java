package dungeon.utils;

public class ClassicMethods {

    /**
     * Random number generator
     *
     * @param min Minimum number
     * @param max Maxilum number
     * @return A random number between the min and the max
     */

    public static int random(int min, int max) {
        return min + (int) (Math.random() * ((max - min) + 1));
    }

}
