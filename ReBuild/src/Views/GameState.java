package Views;

import Controllers.GameMouse;
import Controllers.Spawner;
import Helper.GUI;
import Models.GameObjectManager;
import java.awt.Graphics;

public class GameState extends State {
    private Spawner spawner;
    private GameBackground background;
    private Playground playground;
    private GameMouse mouse;
    
    
    public GameState(){
        background = new GameBackground();
        playground = new Playground(10,10);        
        mouse = new GameMouse(background,playground);
        spawner = new Spawner();
        
        // Set up
        background.setUp();
        GUI.getInstance().getFrame().addMouseListener(mouse);
        GUI.getInstance().getCanvas().addMouseListener(mouse);
        
        GUI.getInstance().getFrame().addMouseMotionListener(mouse);
        GUI.getInstance().getCanvas().addMouseMotionListener(mouse);
        
    }
    @Override
    public void render(Graphics g) {
        background.render(g);
        GameObjectManager.getInstance().renderAllObject(g);
        mouse.render(g);
    }

    @Override
    public void tick() {
        spawner.tick();
        GameObjectManager.getInstance().tickAllObject();
        playground.tick();
        background.tick();
    }
    
    
}
