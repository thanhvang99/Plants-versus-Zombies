package Models;

import Services.PlantInterface;
import Views.Playground;
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
        
        float xPixel = Playground.convert_CordinateX_to_Pixel(getX());
        float yPixel = Playground.convert_CordinateY_to_Pixel(getY());
        
        setRect(new Rectangle((int)xPixel,(int)yPixel,DEFAULT_WIDTH,DEFAULT_HEIGHT));
        
        
    }
    @Override
    public void checkCollision(){
        // Nothing HERE
    }
}
