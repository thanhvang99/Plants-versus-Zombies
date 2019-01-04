package Views;

import Controllers.ClickToStart;
import Helper.GUI;
import java.awt.Graphics;

public class MenuState extends State  {
    
    private MenuBackground background;
    private ClickToStart start;

    public MenuState() {
        background = new MenuBackground();
        start = new ClickToStart();
        
        GUI.getInstance().getFrame().addMouseListener(start);
        GUI.getInstance().getCanvas().addMouseListener(start);
        
    }
    
    @Override
    public void render(Graphics g) {
        background.render(g);
        
        
    }

    @Override
    public void tick() {
        start.tick();
    }   
    
    public ClickToStart getClickToStart() { return start;}

    @Override
    public void setupState() {
        // Remove mouseListener
        GUI.getInstance().getFrame().removeMouseListener(start);
        GUI.getInstance().getCanvas().removeMouseListener(start);
    }
    
    


    
}
