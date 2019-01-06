package Models;

import Services.Animation;
import Services.ImageFrames;
import Services.Timer;
import java.awt.Graphics;

public class Peashooter extends BasicPlant {
    
    private static final int DEFAULT_SPEED_SHOOT = 3000;     // ms
    private Animation[] animation;
    
    private Timer timer;
    public Peashooter(float x,float y) {
        super(x, y);

        setXYPadding();
        moveRect();
        
        timer = new Timer(DEFAULT_SPEED_SHOOT);
        setAnimation();
        
    }
    
    @Override
    public void render(Graphics g) {
        
        g.drawImage(animation[getState()].getCurrentFrame(), (int)getXPixel(),(int)getYPixel(), DEFAULT_WIDTH,DEFAULT_HEIGHT,null);
        
        drawRect(g);

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
            GameObjectManager.getInstance().addObject(new NormalBullet(getXCordinate(), getYCordinate(), 15f, ImageFrames.getPeashooterBullet(), 0.5f, 0.1f));
        }
    }

    @Override
    public void checkDied() {
        if( getHealth() <= 0 ){
            setState(DIE);
            if( !animation[getState()].isFirstLoop() ){
                GameObjectManager.getInstance().removeObject(this);
            }
        }
    }

    @Override
    public void setAnimation() {
        animation = new Animation[2];
        animation[0] = new Animation(500,ImageFrames.getPeashooterAct());
        animation[1] = new Animation(500,ImageFrames.getPeashooterDie());
    }

    @Override
    public void setXYPadding() {
        if (getXCordinate() >= 4) {
            setX((getXCordinate() + 0.2f));
            setY((getYCordinate() + 0.1f));
        } else {
            setX((getXCordinate() + 0.15f));
            setY(getYCordinate() + 0.1f);
        }
        updateXYPixel();
        
    }
    
    
    
    
    
}
