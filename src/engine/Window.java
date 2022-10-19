package engine;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {

    private Canvas canvas;

    public Window(String title, int width, int height){
        new JFrame(title);
        setSize(width, height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);

        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(width, height));
        canvas.setMaximumSize(new Dimension(width, height));
        canvas.setMinimumSize(new Dimension(width, height));

        add(canvas);
        pack();
    }

    public Canvas getCanvas(){
        return canvas;
    }
}
