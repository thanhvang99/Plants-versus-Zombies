package Views;

import Helper.GUI;
import Services.ImageFrames;
import java.awt.Graphics;

public class MenuBackground extends Background {

    @Override
    public void render(Graphics g) {
        g.drawImage(ImageFrames.getMenuBackground(), 0, 0, GUI.DEFAULT_WIDTH, GUI.DEFAULT_HEIGHT, null);
        g.drawImage(ImageFrames.getClickToStart(), 0, 0, 11, 11, null);
    }

    @Override
    public void tick() {
        
    }

    
}
