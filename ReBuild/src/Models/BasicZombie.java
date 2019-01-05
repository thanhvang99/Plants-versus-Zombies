package Models;

import Services.Timer;
import java.awt.Rectangle;
import Services.ZombieInterface;
import Views.Playground;

public abstract class BasicZombie extends GameObject implements ZombieInterface {
    protected final int DEFAULT_WIDTH = 96,
                        DEFAULT_HEIGHT = 130;
    private float currentSpeed,
                  initialSpeed;
    public BasicZombie(float x,float y,float speed){
        super(x,y,ZOMBIE);
        this.currentSpeed = speed;
        this.initialSpeed = speed;
        
        setHealth(100);
        createRectangle();
    }
    
    public void createRectangle(){
        
        float xPixel = Playground.convert_CordinateX_to_Pixel(getX());
        float yPixel = Playground.convert_CordinateY_to_Pixel(getY());
        
        setRect(new Rectangle((int)xPixel,(int)yPixel,DEFAULT_WIDTH,DEFAULT_HEIGHT));
        
    }
    
    public void changeSpeedTo(float speed){
        if( currentSpeed < speed )
            increaseSpeedTo(speed);
        else
            decreaseSpeedTo(speed);
    }
    public void decreaseSpeedTo(float speed){
        if (currentSpeed <= speed) {
            currentSpeed = speed;
        } else {
            currentSpeed -= 0.02f;
        }
    }

    public void increaseSpeedTo(float speed) {
        if (currentSpeed >= speed) {
            currentSpeed = speed;
        } else {
            currentSpeed += 0.02f;
        }

    }
    public void setCurrentSpeed(float speed){ this.currentSpeed = speed; }
    public float getCurrentSpeed(){ return currentSpeed; }
    public float getInitialSpeed(){ return initialSpeed; }
    
    

}
