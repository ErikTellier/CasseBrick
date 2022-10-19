package entities;

import java.awt.*;

public abstract class Entities {
    private int x, y;
    private int longer, larger;
    private Color c;

    public Entities(int x, int y, int longer, int larger, Color c) {
        this.x = x;
        this.y = y;
        this.longer = longer;
        this.larger = larger;
        this.c = c;
    }

    //Getters
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getLongeur() {
        return longer;
    }

    public int getLarg() {
        return larger;
    }

    public Color getColor() {
        return c;
    }
}
