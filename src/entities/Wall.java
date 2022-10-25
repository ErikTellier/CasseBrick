package entities;

import math.Vector;

import java.awt.*;

public class Wall extends Entities{
    public Wall(Vector position, int width, int height, Color c) {
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
