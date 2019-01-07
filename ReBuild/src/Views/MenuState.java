package Views;

import Controllers.MenuKey;
import Controllers.Mouse;
import Helper.GUI;
import Services.AudioPlayer;
import Services.ImageFrames;
import java.awt.Graphics;

public class MenuState extends State {
    private MenuKey key;
    
    public MenuState(){
        key = new MenuKey();
        
        
        GUI.getInstance().getFrame().addKeyListener(key);
        GUI.getInstance().getCanvas().addKeyListener(key);
        AudioPlayer.loadMusic("menu").loop();
    }
    
    
    @Override
    public void render(Graphics g) {
        g.drawImage(ImageFrames.getMenuBackground(), 0, 0, GUI.DEFAULT_WIDTH,GUI.DEFAULT_HEIGHT,null);

        
    }

    @Override
    public void tick() {
        
    }

    @Override
    public Mouse getMouse() {
        return null;
    }
    
}
