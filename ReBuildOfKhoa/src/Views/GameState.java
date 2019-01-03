package Views;

import Models.GameObjectManager;
import Services.ImageFrames;
import java.awt.Graphics;

public class GameState extends State {
    private Map map;
    private Playground playground;
    private OptionColumn column;
    
    public GameState(){
        map = new Map(new GameBackground());
        playground = new Playground(10,10);
        column = new OptionColumn();
        
//        initializeCards();
    }
    @Override
    public void render(Graphics g) {
        map.render(g);
        column.render(g);
        GameObjectManager.getInstance().renderAllObject(g);
    }

    @Override
    public void tick() {
        GameObjectManager.getInstance().tickAllObject();
        playground.tick();
    }
    
    public void initializeCards(){
//        column.addCard(ImageFrames.getPeashooterCandicateOn());
//        column.addCard(ImageFrames.getBeetrootCandicateOn());
    }
    
    
}
