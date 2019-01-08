package Command;

import Controllers.Mouse;
import Controllers.Spawner;
import Helper.GUI;
import Services.AudioPlayer;
import Views.MenuState;
import Views.State;

public class PressSpaceCommand extends Command {
    @Override
    public void excute() {
        if( State.getCurrentState() instanceof MenuState ){
            switchToGame();
            Command.resetCurrentCommand();
        }
    }
    public void switchToGame(){
        GUI gui = GUI.getInstance();
        State.setState(gui.getGameState());
        Mouse.removeCurrentMouseFrom(gui);
        Mouse.setCurrentMouse(gui.getGameState().getMouse());
        Mouse.addCurrentMouseTo(gui);
        Spawner.reClock();
        
        AudioPlayer.loadMusic("background").loop();
        
    }
    
}
