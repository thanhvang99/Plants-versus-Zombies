package Helper;

import Controllers.Game;
import Services.ImageFrames;
import Views.TestView;


public class Launcher {
    public static void main(String[] args){
        
        GUI Gui = GUI.getInstance();
        
        // Set up for game
        
        ImageFrames.setUpAllFrames();       // Load all image
        Gui.setUp();                        // Create canvas, frame as Window
        
        
        Game game = new Game(Gui);          // Create Game run by Gui
        game.start();                       // Start loop game!
        
    }
    
}
