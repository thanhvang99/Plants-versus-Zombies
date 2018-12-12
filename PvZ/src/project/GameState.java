package project;

import java.awt.Graphics;

public class GameState extends State {
    
    private GameBackground background;
    
    private Animation plantAmt;
    private MouseManager mouseManager;
    private Map map;
    
    // Test
    
    
    
    public GameState() {
        background = new GameBackground();
        map = new Map(12,5);
        mouseManager = new MouseManager(map);
        
        Window.getInstance().getCanvas().addMouseListener(mouseManager);
        Window.getInstance().getCanvas().addMouseMotionListener(mouseManager);
        Window.getInstance().getFrame().addMouseListener(mouseManager);
        Window.getInstance().getFrame().addMouseMotionListener(mouseManager);
        
        // Initializing zombie
        GameObjectManager.getInstance().addObject(new BasicZombie(5,4,ID.BASIC_ZOMBIE));
        
    }
    
    @Override
    public void tick(){
        // Update map
        map.tick();
        
        // Update GameObjectManager
        for(int i=0;i<GameObjectManager.getInstance().getList().size();i++){
            GameObject object = GameObjectManager.getInstance().getList().get(i);
            object.tick();
        }
        
    }

    @Override
    public void render(Graphics g) {
        background.render(g);
        mouseManager.render(g);
        for(int i=0;i<GameObjectManager.getInstance().getList().size();i++){
            GameObject object = GameObjectManager.getInstance().getList().get(i);
            object.render(g);
        }
        
        /*
        
        deltaX = 105
        deltaY = 140
        
        */
        g.drawLine(360, 50, 360, Window.getInstance().getHeight());
        g.drawLine(465, 50, 465, Window.getInstance().getHeight());
        g.drawLine(570, 50, 570, Window.getInstance().getHeight());
        g.drawLine(675, 50, 675, Window.getInstance().getHeight());
        g.drawLine(780, 50, 780, Window.getInstance().getHeight());
        g.drawLine(885, 50, 885, Window.getInstance().getHeight());
        g.drawLine(990, 50, 990, Window.getInstance().getHeight());
        g.drawLine(1095, 50, 1095, Window.getInstance().getHeight());
        g.drawLine(1200, 50, 1200, Window.getInstance().getHeight());
//        g.drawLine(1305, 50, 1305, Window.getInstance().getHeight());
        
        g.drawLine(360, 40, Window.getInstance().getWidth(), 40);
        g.drawLine(360, 180, Window.getInstance().getWidth(), 180);
        g.drawLine(360, 320, Window.getInstance().getWidth(), 320);
        g.drawLine(360, 460, Window.getInstance().getWidth(), 460);
        g.drawLine(360, 600, Window.getInstance().getWidth(), 600);
        
        
        
        

    }
    
    
}
