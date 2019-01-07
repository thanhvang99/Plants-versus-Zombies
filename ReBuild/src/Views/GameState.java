package Views;

import Models.BackgroundComponents.Playground;
import Controllers.GameMouse;
import Controllers.Mouse;
import Controllers.Spawner;
import Helper.GUI;
import Models.GameObjects.GameObject;
import Models.GameObjects.GameObjectManager;
import Models.GameObjects.LawnMower;
import java.awt.Graphics;
import java.util.ArrayList;

public class GameState extends State {
    private Spawner spawner;
    private GameBackground background;
    private Playground playground;
    private GameMouse mouse;
    
    
    public GameState(){
        background = new GameBackground();
        playground = new Playground(10,10);        
        spawner = new Spawner();
        mouse = new GameMouse(background,playground);
        background.setUp();
        
    }
    @Override
    public void render(Graphics g) {
        background.render(g);
        GameObjectManager.getInstance().renderAllObject(g);
        spawner.render(g);
        mouse.render(g);
    }

    @Override
    public void tick() {
        spawner.tick();
        
        GameObjectManager.getInstance().tickAllObject();
        playground.tick();
        background.tick();
        
        checkLose();
    }
    public void checkLose(){
        ArrayList<GameObject> list = GameObjectManager.getInstance().getList(GameObject.ZOMBIE);
        for(GameObject object : list){
            if( object.getXCordinate()<=-1f ){
                GameObjectManager.getInstance().resetList();
                switchToGameOver();
            }
        }
    }
    public void switchToGameOver(){
        GUI gui = GUI.getInstance();
        background.getMoney().set(1000);
        State.setState(gui.getGameOverState());
        Mouse.removeCurrentMouseFrom(gui);
        Mouse.setCurrentMouse(gui.getGameOverState().getMouse());
        Mouse.addCurrentMouseTo(gui);
    }
    @Override
    public Mouse getMouse() { return mouse; }
    
}
