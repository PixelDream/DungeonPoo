package dungeon.model;

import java.io.Serializable;

public class Position implements Serializable {
    public static int MAX_XY = -1;
    private int x, y;
    private Direction direction;

    /**
     * Position constructor
     *
     * @param x
     * @param y
     */

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
        this.direction = Direction.NONE;
    }

    /**
     * Change position's coordinate method
     *
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
