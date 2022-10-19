package entities;

import java.awt.*;

public class Ball extends Entities{
    public Ball(int x, int y, int width, int height, Color c) {
        super(x, y, width, height, c);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(getColor());
        g.fillOval(getX(), getY(), getWidth(), getHeight());
    }
}
