package Controllers;

import Helper.GUI;
import Services.AudioPlayer;
import Views.MenuState;
import Views.State;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MenuKey implements KeyListener {
    

    @Override
    public void keyPressed(KeyEvent e) {
        
        if( State.getCurrentState() instanceof MenuState ){
            int key = e.getKeyCode();
            if( key == KeyEvent.VK_SPACE ){
                switchToGame();
            }
            
        }
    
    }
    public void switchToGame(){
        GUI gui = GUI.getInstance();
        State.setState(gui.getGameState());
        Mouse.removeCurrentMouseFrom(gui);
        Mouse.setCurrentMouse(gui.getGameState().getMouse());
        Mouse.addCurrentMouseTo(gui);
        Spawner.reClock();
        
//        AudioPlayer.loadMusic("background").loop();
        
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
    }


    @Override
    public void keyReleased(KeyEvent e) {
    }
    
}
