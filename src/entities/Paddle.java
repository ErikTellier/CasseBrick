package entities;

import java.awt.*;

public class Paddle extends Entities{
    public Paddle(int x, int y, int width, int height, Color c) {
        super(x, y, width, height, c);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(getColor());
        g.fillRect(getX(), getY(), getWidth(), getHeight());
    }
}
