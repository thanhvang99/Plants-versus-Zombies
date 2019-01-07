package Models.GameObjects;

import java.awt.Rectangle;

public abstract class BasicPlant extends GameObject {
    protected final int DEFAULT_WIDTH = 76,
                        DEFAULT_HEIGHT = 76;
    public BasicPlant(float x,float y){
        super(x,y,PLANT);
        
        setHealth(100);
        setAnimation();
        setSizeImage(DEFAULT_WIDTH,DEFAULT_HEIGHT);
        
        setXYPadding();
    }
    @Override
    public void checkCollision(){
    }
    
    public abstract void setXYPadding();
}
