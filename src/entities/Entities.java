package entities;

import math.Vector;

import java.awt.*;

public abstract class Entities {
    private Vector position;
    private int width, height;
    private Color c;

    public Entities(Vector position, int width, int height, Color c) {
        this.position = position;
        this.width = width;
        this.height = height;
        this.c = c;
    }

    public abstract void update();
    public abstract void draw(Graphics g);

    //Bounds
    public Rectangle getBounds() {
        return new Rectangle(position.getX(), position.getY(), width, height);
    }


    //Getters
    public Vector getPosition() {
        return position;
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

    //Setters

    public void setX(int x) {
        this.position.setX(x);
    }

    public void setY(int y) {
        this.position.setY(y);
    }

    public void setC(Color c) {
        this.c = c;
    }
}
