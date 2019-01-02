package Helper;

import Controllers.Game;


public class Launcher {
    public static void main(String[] args){
        
        GUI gui = GUI.getInstance();
        
        Game game = new Game(gui);
        game.start();
    }
    
}
