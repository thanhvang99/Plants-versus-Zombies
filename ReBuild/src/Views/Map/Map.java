
package Map;

import GameInterface.GameView;
import java.awt.Graphics;
import GameInterface.GameInterface;

public class Map implements GameView,GameInterface {
    private Background background;
    
    public Map(Background background){
        this.background = background;
    }

    @Override
    public void render(Graphics g) {
    }

    @Override
    public void tick() {
    }
    
}
