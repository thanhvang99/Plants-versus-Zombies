package Views;

import Models.GameObjectManager;
import Services.ImageFrames;
import java.awt.Graphics;

public class GameState extends State {
    private Background background;
    private Playground playground;
    
    
    public GameState(){
        background = new GameBackground();
        playground = new Playground(10,10);        
        
        // Set up
        background.setUp();
    }
    @Override
    public void render(Graphics g) {
        background.render(g);
        GameObjectManager.getInstance().renderAllObject(g);
    }

    @Override
    public void tick() {
        GameObjectManager.getInstance().tickAllObject();
        playground.tick();
    }
    
    public void initializeCards(){
    }
    
}
