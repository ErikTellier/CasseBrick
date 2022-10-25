package entities;

import engine.Handler;
import math.Vector;

import java.awt.*;

public class Wall extends Entities{
    public Wall(Handler handler, Vector position, int width, int height, Color c) {
        super(handler, position, width, height, c);
    }

    @Override
    public void update() {

    }

    @Override
    public void draw(Graphics g) {
        g.setColor(getColor());
        g.fillRect((int)getPosition().getX(), (int)getPosition().getY(), getWidth(), getHeight());
    }
}
