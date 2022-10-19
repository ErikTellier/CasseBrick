package engine;

public class Game implements Runnable{
    private Window window;
    private int width, height;
    private String title;

    private boolean running = false;
    private Thread thread;

    public Game(String title, int width, int height){
        this.title = title;
        this.width = width;
        this.height = height;


    }

    private void init(){
        window = new Window(title, width, height);
    }
    private void update(){}
    private void render(){}

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
