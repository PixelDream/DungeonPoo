package model;

public class Door {

    private boolean open;
    private Direction direction;
    private Key key;

    //TODO: Des rooms ?

    public Door() {

    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(Key key) {
        this.open = this.key.equals(key);
    }
}
