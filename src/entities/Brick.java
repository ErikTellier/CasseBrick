package entities;

import java.awt.*;

public class Brick extends Entities{
    public Brick(int x, int y, int width, int height, Color c) {
        super(x, y, width, height, c);
    }

    @Override
    public void update() {

    }

    @Override
    public void draw(Graphics g) {
        g.setColor(getColor());
        g.fillRect(getX(), getY(), getWidth(), getHeight());
    }
}
