package states;

import engine.Handler;
import entities.Ball;
import entities.Brick;
import entities.Paddle;
import entities.Wall;
import math.Vector;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class GameState extends State{

    //Entities
    Ball ball;
    Paddle paddle;
    ArrayList<Brick> bricks = new ArrayList<Brick>();
    Wall wallT, wallL, wallR;

    public GameState(Handler handler) {
        super(handler);

        paddle = new Paddle(new Vector(handler.getWidth()/2 - 20, 275), 40,7,Color.blue);

        ball = new Ball(new Vector(handler.getWidth()/2-5, 250), 10,10, Color.red);

        wallT = new Wall(new Vector(0,0), handler.getWidth(),10, Color.gray);//Top
        wallL = new Wall(new Vector(0,0), 10,handler.getHeight(), Color.gray);//Left
        wallR = new Wall(new Vector(handler.getWidth()-10,0), 10,handler.getHeight(), Color.gray);//right
        for(int j = 30; j <= 150; j += 15) {
            for (int i = 30; i <= 260; i += 25) {
                bricks.add(new Brick(new Vector(i, j), 20, 10, Color.green));

            }
        }
    }

    @Override
    public void update() {
        //Paddle Movement : TO MOVE
        if(handler.getKeyManager().getKey(KeyEvent.VK_RIGHT) && !paddle.getBounds().intersects(wallR.getBounds())){
                paddle.getPosition().setX(paddle.getPosition().getX()+2);
        }
        if(handler.getKeyManager().getKey(KeyEvent.VK_LEFT) && !paddle.getBounds().intersects(wallL.getBounds())){
            paddle.getPosition().setX(paddle.getPosition().getX()-2);
        }



        ball.update();
        paddle.update();
        wallL.update();
        wallR.update();
        wallT.update();
        bricks.forEach((n) -> n.update());
    }

    @Override
    public void render(Graphics g) {
        wallT.draw(g);
        wallL.draw(g);
        wallR.draw(g);
        bricks.forEach((n) -> n.draw(g));
        paddle.draw(g);
        ball.draw(g);
    }
}
