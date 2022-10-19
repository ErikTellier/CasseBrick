package entities;

import java.awt.*;

public abstract class Entities {
    private int x, y;
    private int width, height;
    private Color c;

    public Entities(int x, int y, int width, int height, Color c) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.c = c;
    }

    public abstract void draw(Graphics g);

    //Getters
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Color getColor() {
        return c;
    }
}
