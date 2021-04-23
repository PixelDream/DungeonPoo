package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Door implements Serializable {

    private boolean open;
    private Direction direction;
    private Key key;
    private List<Room> rooms;

    public Door() {
        rooms = new ArrayList<>();
        this.key = new Key();
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(Key key) {
        this.open = this.key.equals(key);
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }
}
