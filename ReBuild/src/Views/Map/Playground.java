package Views.Map;

import Helper.ID;
import Services.GameInterface;

public class Playground implements GameInterface {
    private static final int DELTA_X = 105,
                             DELTA_Y = 140,
                             START_X = 360,
                             START_Y = 40;
    
    private int x,y;
    private ID[][] ground;
    
    public Playground(int x,int y){
        this.x = x;
        this.y = y;
        
        ground = new ID[x][y];
    }
    
    public boolean isInPlayground(int xPixel,int yPixel){
        return false;
    }
    
    @Override
    public void tick() {
    
    
    }
    
}
