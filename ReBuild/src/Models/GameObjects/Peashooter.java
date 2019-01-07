package Models.GameObjects;

import Services.Animation;
import Services.ImageFrames;
import Services.Timer;
import java.awt.Graphics;

public class Peashooter extends BasicPlant {
    
    private static final int DEFAULT_SPEED_SHOOT = 3000;     // ms
    private boolean isShoot = false;
    private Timer timer;
    public Peashooter(float x,float y) {
        super(x, y);
        
        setSizeImage(DEFAULT_WIDTH+10,DEFAULT_HEIGHT+10);
        timer = new Timer(DEFAULT_SPEED_SHOOT);
        
    }
    @Override
    public void tick() {
        animation[getState()].tick();
        act();
        checkDied();
    }

    @Override
    public void act() {
        if( animation[getState()].isNewLoop() ){
            isShoot = false;
        }
        if( animation[getState()].getCurrentIndex() == 9 && !isShoot ){
            GameObjectManager.getInstance().addObject(new NormalBullet(getXCordinate(), getYCordinate(), 20f, ImageFrames.getPeashooterBullet(), 0.6f, 0.2f));
            isShoot = true;
            
        }
    }

    @Override
    public void checkDied() {
        if( getHealth() <= 0 ){
            setState(DIE);
            if( animation[getState()].isNewLoop() ){
                GameObjectManager.getInstance().removeObject(this);
            }
        }
    }

    @Override
    public void setAnimation() {
        animation = new Animation[2];
        animation[0] = new Animation(110,ImageFrames.getNewPeashooterAct());
        animation[1] = new Animation(500,ImageFrames.getPeashooterDie());
    }

    @Override
    public void setXYPadding() {
         setY((getYCordinate() + 0.2f));
        if (getXCordinate() >= 4) {
            setX((getXCordinate() + 0.2f));
        } else {
            setX((getXCordinate() + 0.15f));
        }
        
    }
    
    
    
    
    
}
