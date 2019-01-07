package Controllers;

import Command.Command;
import Command.PressSpaceCommand;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MenuKey implements KeyListener {

    @Override
    public void keyPressed(KeyEvent e) {
        
        if( e.getKeyCode() == KeyEvent.VK_SPACE ){
            Command pressSpaceCommand = new PressSpaceCommand();
            Command.setCurrentCommand(pressSpaceCommand);
        }
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
    }


    @Override
    public void keyReleased(KeyEvent e) {
    }
    
}
