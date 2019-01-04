package Models;

import java.awt.Rectangle;
import Services.ZombieInterface;
import Views.Playground;

public abstract class BasicZombie extends GameObject implements ZombieInterface {
    protected final int HEALTH = 100;
    protected final int DEFAULT_WIDTH = 96,
                        DEFAULT_HEIGHT = 130;
    private float speed;
    
    public BasicZombie(float x,float y,float speed){
        super(x,y,ZOMBIE);
        this.speed = speed;
        createRectangle();
    }
    public float getSpeed(){ return speed; }
    
    public void createRectangle(){
        
        float xPixel = Playground.convert_CordinateX_to_Pixel(getX());
        float yPixel = Playground.convert_CordinateY_to_Pixel(getY());
        
        setRect(new Rectangle((int)xPixel,(int)yPixel,DEFAULT_WIDTH,DEFAULT_HEIGHT));
        
    }
    @Override
    public void checkCollision(){
        
    }

}
