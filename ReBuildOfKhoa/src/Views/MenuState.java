package Views;

import Helper.ImageLoader;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class MenuState extends State {

    private Map map;
    
    public MenuState() {
        map = new Map(new MenuBackground());
    }
    
    @Override
    public void render(Graphics g) {
        map.render(g);
        
        
    }

    @Override
    public void tick() {
        // Update ... Backend
    }
    
}
