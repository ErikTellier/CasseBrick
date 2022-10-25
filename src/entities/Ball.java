package entities;

import engine.Handler;
import math.Vector;

import java.awt.*;
import java.util.ArrayList;
import java.util.Objects;

public class Ball extends Entities{


    private Vector vel;
    private Vector dir;


    public Ball(Handler handler, Vector position, int width, int height, Color c) {
        super(handler, position, width, height, c);
        vel = new Vector(2,2);
        dir = new Vector(1, 1);
    }

    @Override
    public void update() {
        //Movement, find way to handle collision
        getPosition().setX(getPosition().getX() + (vel.getX() * dir.getX()));
        getPosition().setY(getPosition().getY() + (vel.getY() * dir.getY()));

    }

    @Override
    public void draw(Graphics g) {
        g.setColor(getColor());
        g.fillOval((int)getPosition().getX(),(int) getPosition().getY(), getWidth(), getHeight());
    }


    public Vector getVel() {
        return vel;
    }

    public void setVel(Vector vel) {
        this.vel = vel;
    }

    public Vector getDir() {
        return dir;
    }

    public void setDirX(float x) {
        this.dir.setX(x);
    }
    public void setDirY(float y) {
        this.dir.setY(y);
    }
}
