package model;

import java.io.Serializable;

public class Position implements Serializable {
    private int x, y;
    private Direction direction;

    private final static int MIN_X = 0;
    private final static int MIN_Y = 0;

    public static int MAX_XY = -1;

    /**
     * Position constructor
     * @param x
     * @param y
     */

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
        this.direction = Direction.NONE;
    }

    /**
     * Check if a position is (x,y) method
     * @param x
     * @param y
     * @return
     */
    public boolean equals(int x, int y) {
        return this.x == x && this.y == y;
    }

    /**
     * Change position's coordinate method
     * @param x
     * @param y
     * @param direction
     */

    public void updateCoords(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }


    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Direction getDirection() {
        return direction;
    }
}
