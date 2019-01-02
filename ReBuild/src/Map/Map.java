
package Map;

import GameInterface.GameController;
import GameInterface.GameView;
import java.awt.Graphics;

public class Map implements GameView,GameController {
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
