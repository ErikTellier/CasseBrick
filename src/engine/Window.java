package engine;

import javax.swing.*;

public class Window extends JFrame {

    public Window(String title, int width, int height){
        new JFrame(title);
        setSize(width, height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
