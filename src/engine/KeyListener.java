package engine;

import java.awt.event.KeyEvent;

public class KeyListener implements java.awt.event.KeyListener {

    private boolean[] keys;

    public KeyListener(){
        keys = new boolean[256];

    }

    @Override
    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()] = false;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    //Getters
    public boolean getKey(int keycode)
    {
        return keys[keycode];
    }
}
