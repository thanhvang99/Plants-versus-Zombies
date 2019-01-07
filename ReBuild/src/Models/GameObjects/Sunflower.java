/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.GameObjects;

import Services.Animation;
import Services.ImageFrames;
import Services.Timer;
import java.awt.Graphics;
import java.util.Random;

/**
 *
 * @author ldakhoa
 */
public class Sunflower extends BasicPlant {
    private Animation[] animation;
    private Timer timer;
    
    public Sunflower(float x, float y) {
        super(x, y);
        timer = new Timer(15000);
        
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(animation[getState()].getCurrentFrame(), (int)getXPixel(),(int)getYPixel(), getWidth(),getHeight(),null);
        
        drawRect(g);
    }

    @Override
    public void tick() {
        animation[getState()].tick();
        
        act();
        checkDied();
    }

    @Override
    public void setAnimation() {
        animation = new Animation[2];
        animation[0] = new Animation(500, ImageFrames.getSunflowerAct());
        animation[1] = new Animation(500, ImageFrames.getSunflowerDie());
    }

    @Override
    public void act() {
        if (timer.isTimeOut()) {
            Random r = new Random();
            
            GameObjectManager.getInstance().addObject(new Sun(r.nextInt(5), -1));
        }
    }

    @Override
    public void checkDied() {
        if ( getHealth() <= 0 ) {
            setState(DIE);
            
            if (!animation[getState()].isFirstLoop()) {
                GameObjectManager.getInstance().removeObject(this);
            }
            
        }
    }

    @Override
    public void setXYPadding() {
        setY((getYCordinate() + 0.2f));
        if (getXCordinate() >= 4) {
            setX((getXCordinate() + 0.2f));
        } else {
            setX((getXCordinate() + 0.1f));
        }
    }
    
    
    
}
