package Models;

import java.awt.Rectangle;

public abstract class BasicZombie extends GameObject {
    protected final int DEFAULT_WIDTH = 96,
                        DEFAULT_HEIGHT = 130;
    private float currentSpeed,
                  initialSpeed;
    
    private static Score score;
            
    public BasicZombie(float x,float y,float speed){
        super(x,y,ZOMBIE);
        this.currentSpeed = speed;
        this.initialSpeed = speed;
        
        setHealth(100);
        createRectangle();
    }
    
    public void createRectangle(){
        setRect(new Rectangle((int)getXPixel(),(int)getYPixel(),DEFAULT_WIDTH,DEFAULT_HEIGHT));
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
            currentSpeed -= 0.1f;
        }
    }

    public void increaseSpeedTo(float speed) {
        if (currentSpeed >= speed) {
            currentSpeed = speed;
        } else {
            currentSpeed += 0.02f;
        }

    }
    public void increaseScoreAfterDied(int number){
        score.set(score.get()+ number);
    }
    public static void setRelationWithScore(Score scoreInput){
        score = scoreInput;
    }
    public void setCurrentSpeed(float speed){ this.currentSpeed = speed; }
    public float getCurrentSpeed(){ return currentSpeed; }
    public float getInitialSpeed(){ return initialSpeed; }
    
    

}
