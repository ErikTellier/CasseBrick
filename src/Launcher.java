import engine.Game;

public class Launcher {
    public static void main(String[] args) {
        Game game = new Game("test", 250, 250);
        game.start();
    }
}
