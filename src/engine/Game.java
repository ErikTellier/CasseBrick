package engine;

public class Game {
    private Window window;

    private int width, height;

    public Game(String title, int width, int height){
        this.width = width;
        this.height = height;

        window = new Window(title, width, height);
    }
}
