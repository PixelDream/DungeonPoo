package model;

import java.io.Serializable;

public class Position implements Serializable {
    private int x, y;

    private final static int MIN_X = 0;
    private final static int MIN_Y = 0;

    public static int MAX_XY = -1;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
