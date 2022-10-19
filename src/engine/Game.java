package engine;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game implements Runnable{
    private Window window;
    private int width, height;
    private String title;

    private boolean running = false;
    private Thread thread;
    private BufferStrategy bs;
    private Graphics g;


    public Game(String title, int width, int height){
        this.title = title;
        this.width = width;
        this.height = height;


    }

    private void init(){
        window = new Window(title, width, height);
    }
    private void update(){
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

        g.setColor(Color.red);
        g.fillRect(50, 50, 50, 70);

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
}
