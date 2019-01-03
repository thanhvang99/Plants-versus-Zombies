package Views;

import Services.GameInterface;
import Views.GameView;
import java.awt.Graphics;

public abstract class Background implements GameView,GameInterface {
    
    public abstract void render(Graphics g);
    
}
