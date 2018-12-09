package project;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyManager extends KeyAdapter {
    
    
    @Override
    public void keyPressed(KeyEvent e){
        if( e.getKeyCode() == KeyEvent.VK_ESCAPE ){
            System.exit(1);
        }
    }
    @Override 
    public void keyReleased(KeyEvent e){
    
    }
}
