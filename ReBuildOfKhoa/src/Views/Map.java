
package Views;

import java.awt.Graphics;
import Services.GameInterface;
import Views.GameView;

public class Map implements GameView,GameInterface {
    private Background background;
    
    public Map(Background background){
        this.background = background;
    }

    @Override
    public void render(Graphics g) {
        background.render(g);
    }

    @Override
    public void tick() {
        
        
    }
    public Background getBackground(){ return background; }
    
}
