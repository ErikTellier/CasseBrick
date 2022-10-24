package states;

import engine.Handler;
import entities.Ball;
import entities.Brick;
import entities.Paddle;
import entities.Wall;

import java.awt.*;
import java.util.ArrayList;

public class GameState extends State{

    //Entities
    Ball ball;
    Paddle paddle;
    ArrayList<Brick> bricks = new ArrayList<Brick>();
    ArrayList<Wall> walls = new ArrayList<Wall>();

    public GameState(Handler handler) {
        super(handler);

        paddle = new Paddle(handler.getWidth()/2 - 20, 275, 40,7,Color.blue);
        ball = new Ball(handler.getWidth()/2-5, 250, 10,10, Color.red);

        walls.add(new Wall(0,0, handler.getWidth(),10, Color.gray));//Top
        walls.add(new Wall(0,0, 10,handler.getHeight(), Color.gray));//Left
        walls.add(new Wall(handler.getWidth()-10,0, 10,handler.getHeight(), Color.gray));//right
        for(int j = 30; j <= 150; j += 15) {
            for (int i = 30; i <= 260; i += 25) {
                bricks.add(new Brick(i, j, 20, 10, Color.green));

            }
        }
    }

    @Override
    public void update() {

    }

    @Override
    public void render(Graphics g) {
        walls.forEach((n) -> n.draw(g));
        bricks.forEach((n) -> n.draw(g));
        paddle.draw(g);
        ball.draw(g);
    }
}
