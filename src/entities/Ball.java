package entities;

import math.Vector;

import java.awt.*;

public class Ball extends Entities{

    int r;
    Vector vel;
    Vector dir;

    private int FrameWidth, FrameHeight;


    public Ball(Vector position, int width, int height, Color c) {
        super(position, width, height, c);
        vel = new Vector(2,2);
        dir = new Vector(1, 1);
    }

    @Override
    public void update() {
        //Movement, find way to handle collision
        //getPosition().setX(getPosition().getX() + (vel.getX() * dir.getX()));
        //getPosition().setY(getPosition().getY() + (vel.getY() * dir.getY()));
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(getColor());
        g.fillOval(getPosition().getX(), getPosition().getY(), getWidth(), getHeight());
    }

}
