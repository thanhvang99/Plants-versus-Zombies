package Models;

import java.awt.Rectangle;
import Services.ZombieInterface;
import Views.Playground;

public abstract class BasicZombie extends GameObject implements ZombieInterface {
    protected final int DEFAULT_WIDTH = 96,
                        DEFAULT_HEIGHT = 130;
    private float speed;
    
    public BasicZombie(float x,float y,float speed){
        super(x,y,ZOMBIE);
        this.speed = speed;
        
        setHealth(100);
        createRectangle();
    }
    
    public void createRectangle(){
        
        float xPixel = Playground.convert_CordinateX_to_Pixel(getX());
        float yPixel = Playground.convert_CordinateY_to_Pixel(getY());
        
        setRect(new Rectangle((int)xPixel,(int)yPixel,DEFAULT_WIDTH,DEFAULT_HEIGHT));
        
    }
    public void setSpeed(float speed){ this.speed = speed; }
    public float getSpeed(){ return speed; }
    
    

}
