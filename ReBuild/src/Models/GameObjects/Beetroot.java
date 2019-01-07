package Models.GameObjects;

import Services.Animation;
import Services.ImageFrames;
import Services.Timer;
import java.awt.Graphics;

public class Beetroot extends BasicPlant {
    private static final int DEFAULT_SPEED = 1800;
    private Timer timer;
    public Beetroot(float x,float y){
        super(x,y);
        
        timer = new Timer(DEFAULT_SPEED);
        setXYPadding();
    }
    
    @Override
    public void tick() {
        animation[getState()].tick();
        
        act();
        checkDied();
    }

    @Override
    public void act() {
        if (timer.isTimeOut()) {
            GameObjectManager.getInstance().addObject(new NormalBullet(getXCordinate(),getYCordinate(), 10.0f,ImageFrames.getBeetrootBullet(), 0.5f, 0.3f));
        }
        
    }

    @Override
    public void setAnimation() {
        animation = new Animation[2];
        animation[0] = new Animation(500,ImageFrames.getBeetrootAct());
        animation[1] = new Animation(500,ImageFrames.getBeetrootDie());
        
    }

    @Override
    public void checkCollision() {
    }

    @Override
    public void setXYPadding() {
        setY((getYCordinate() + 0.1f));
        if (getXCordinate() >= 4) {
            setX((getXCordinate() + 0.2f));
        } else {
            setX((getXCordinate() + 0.1f));
            setY(getYCordinate());
        }
    }


    

    
}
