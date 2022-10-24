import engine.Game;

public class Launcher {
    public static void main(String[] args) {
        Game game = new Game("test", 305, 305);
        game.start();
    }
}
