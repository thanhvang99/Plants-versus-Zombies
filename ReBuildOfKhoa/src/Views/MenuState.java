package Views;

import java.awt.Graphics;

public class MenuState extends State {
    
    private MenuBackground background;
    
    public MenuState() {
        background = new MenuBackground();
    }
    
    @Override
    public void render(Graphics g) {
        background.render(g);
        
    }

    @Override
    public void tick() {
        // Update ... Backend
    }
    
}
