package Helper;

import Controllers.Game;
import Resources.ImageFrames;


public class Launcher {
    public static void main(String[] args){
        
        GUI gui = GUI.getInstance();
        
        gui.setUp();
        ImageFrames.setUp();
        Test.setUp();
        
        Game game = new Game(gui);
        game.start();
    }
    
}
