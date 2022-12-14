package engine;

import entities.Ball;
import entities.Brick;
import entities.Paddle;
import entities.Wall;
import states.GameState;
import states.State;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;

public class Game implements Runnable{
    private Window window;
    private int width, height;
    private String title;
    private boolean running = false;
    private Thread thread;
    private BufferStrategy bs;
    private Graphics g;

    private KeyManager keyManager;

    private Handler handler;

    //States
    private State gameState;




    public Game(String title, int width, int height){
        this.title = title;
        this.width = width;
        this.height = height;

        keyManager = new KeyManager();
    }

    private void init(){
        window = new Window(title, width, height);
        window.addKeyListener(keyManager);

        handler = new Handler(this);

        gameState = new GameState(handler);
        State.setState(gameState);

    }

    private void update(){
        if(State.getState() != null)
            State.getState().update();

    }

    private void render(){
        bs = window.getCanvas().getBufferStrategy();
        if(bs == null){
            window.getCanvas().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();
        g.clearRect(0, 0, width, height);
        //Draw Here!

        if(State.getState() != null)
            State.getState().render(g);

        //End Drawing!
        bs.show();
        g.dispose();
    }

    @Override
    public void run() {
        init();

        //Get the system time
        long lastTime = System.nanoTime();
        //Specify how many seconds there are in a minute as a double
        //store as a double cause 60 sec in nanosec is big and store as final so it can't be changed
        final double ticks = 60D;
        //Set definition of how many ticks per 1000000000 ns or 1 sec
        double ns = 1000000000 / ticks;
        double delta = 0;

        while(running){
            //Update the time
            long now = System.nanoTime();
            //calculate change in time since last known time
            delta += (now - lastTime) / ns;
            //update last known time
            lastTime = now;
            //continue while delta is less than or equal to 1
            if(delta >= 1){
                //Go through one update
                update();

                delta--;
            }

            //Render outside of delta
            render();
        }

        stop();
        window.setVisible(false);
        window.dispose();
    }

    //Threading
    public synchronized void start(){
        if(running)
            return;
        running = true;
        thread = new Thread(this);
        thread.start();
    }
    public synchronized void stop(){
        if(!running)
            return;
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //GETTERS

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public KeyManager getKeyManager() {
        return keyManager;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }
}
