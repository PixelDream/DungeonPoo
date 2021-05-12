package utils;

public class ClassicMethods {

    public int random(int min, int max) {
        return min + (int) (Math.random() * ((max - min) + 1));
    }

}
