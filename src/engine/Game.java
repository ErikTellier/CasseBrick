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
    private void update(){}
    private void render(){
        bs = window.getCanvas().getBufferStrategy();
        if(bs == null){
            window.getCanvas().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();

        g.clearRect(0, 0, width, height);
        //Draw Here!


        //End Drawing!
        bs.show();
        g.dispose();
    }

    @Override
    public void run() {
        init();

        while(running){
            update();
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
