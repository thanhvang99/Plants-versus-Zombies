package Models;

import Services.PlantInterface;
import java.awt.Rectangle;

public abstract class BasicPlant extends GameObject implements PlantInterface {
    protected final int DEFAULT_WIDTH = 76,
                        DEFAULT_HEIGHT = 76;
    public BasicPlant(float x,float y){
        super(x,y,PLANT);
        
        setHealth(100);
        createRectangle();
    }
    public void createRectangle(){
        setRect(new Rectangle((int)getXPixel(),(int)getYPixel(),DEFAULT_WIDTH,DEFAULT_HEIGHT));
    }
    @Override
    public void checkCollision(){
    }
}
