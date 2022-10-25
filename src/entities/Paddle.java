package entities;

import math.Vector;

import java.awt.*;

public class Paddle extends Entities{
    public Paddle(Vector position, int width, int height, Color c) {
        super(position, width, height, c);
    }

    @Override
    public void update() {

    }

    @Override
    public void draw(Graphics g) {
        g.setColor(getColor());
        g.fillRect(getPosition().getX(), getPosition().getY(), getWidth(), getHeight());
    }
}
