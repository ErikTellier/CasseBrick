package entities;

import engine.Handler;
import math.Vector;

import java.awt.*;

public abstract class Entities {
    private Vector position;
    private int width, height;
    private Color c;
    private Handler handler;

    public Entities(Handler handler, Vector position, int width, int height, Color c) {
        this.handler = handler;
        this.position = position;
        this.width = width;
        this.height = height;
        this.c = c;
    }

    public abstract void update();
    public abstract void draw(Graphics g);

    //Bounds
    public Rectangle getBounds() {
        return new Rectangle((int)position.getX(), (int)position.getY(), width, height);
    }

    public boolean checkCollision(Entities ent){
        return getBounds().intersects(ent.getBounds());
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

    public void destroy(){
        this.destroy();
    }

    public Handler getHandler() {
        return handler;
    }
}
