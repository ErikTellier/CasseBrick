package states;

import engine.Handler;
import entities.*;
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

        paddle = new Paddle(handler, new Vector(handler.getWidth()/2 - 20, 275), 40,7,Color.blue);

        ball = new Ball(handler, new Vector(handler.getWidth()/2-5, 250), 10,10, Color.red);

        wallT = new Wall(handler, new Vector(0,0), handler.getWidth(),10, Color.gray);//Top
        wallL = new Wall(handler, new Vector(0,0), 10,handler.getHeight(), Color.gray);//Left
        wallR = new Wall(handler, new Vector(handler.getWidth()-10,0), 10,handler.getHeight(), Color.gray);//right
        for(int j = 30; j <= 150; j += 15) {
            for (int i = 30; i <= 260; i += 25) {
                bricks.add(new Brick(handler, new Vector(i, j), 20, 10, Color.green));

            }
        }


    }

    @Override
    public void update() {

        //Paddle Movement : TO MOVE
        if(paddle.getHandler().getKeyManager().getKey(KeyEvent.VK_RIGHT) && !paddle.checkCollision(wallR)){
            paddle.getPosition().setX(paddle.getPosition().getX()+2);
        }
        if(paddle.getHandler().getKeyManager().getKey(KeyEvent.VK_LEFT) && !paddle.checkCollision(wallL)){
            paddle.getPosition().setX(paddle.getPosition().getX()-2);
        }




        ball.update();

        if(ball.checkCollision(wallR))
        {
            ball.setDirX(ball.getDir().getX() * -1);
        }
        if(ball.checkCollision(wallT))
        {
            ball.setDirY(ball.getDir().getY() * -1);
        }
        if(ball.checkCollision(wallL))
        {
            ball.setDirX(ball.getDir().getX() * -1);
        }
        if(ball.checkCollision(paddle))
        {
            System.out.println("Collided");
            ball.setDirY(ball.getDir().getY() * -1);
            //ball.setDirX(ball.getDir().getX() * -1);
        }

        for (Entities ent: bricks) {
            if(ball.checkCollision(ent)){

                ball.setDirX(ball.getDir().getX() * -1);
                bricks.remove(ent);
                break;
            }
        }


        
        if(ball.getPosition().getY() > handler.getHeight())
        {
            handler.getGame().setRunning(false);
        }

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
