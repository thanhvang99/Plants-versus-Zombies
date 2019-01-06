/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.GameObjects;

import Services.Animation;
import Services.ImageFrames;
import java.awt.Graphics;

/**
 *
 * @author ldakhoa
 */
public class Walnut extends BasicPlant {
    
    private Animation[] animation;
    private static int HALF = 2;
    
    public Walnut(float x, float y) {
        super(x + 0.15f, y + 0.15f);
        setHealth(300);
        setAnimation();
        
    }

    @Override
    public void setXYPadding() {
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(animation[getState()].getCurrentFrame(), (int)getXPixel(), (int)getYPixel(), DEFAULT_WIDTH, DEFAULT_HEIGHT, null);

        drawRect(g);
    }

    @Override
    public void tick() {
        animation[getState()].tick();
        checkDied();
    }

    @Override
    public void setAnimation() {
        animation = new Animation[3];
        animation[ACT] = new Animation(500, ImageFrames.getWalnutFullHealth());
        
        animation[DIE] = new Animation(500, ImageFrames.getWalnutDie());
        animation[HALF] = new Animation(500, ImageFrames.getWalnutHalfHealth());
    }
    
    
    @Override
    public void act() {
        // Nothing
    }

    @Override
    public void checkDied() {
        
        if(getHealth() <= 300 && getHealth() >= 150) {
            setState(ACT);
        } else if(getHealth() < 150 && getHealth() >= 0) {
            setState(HALF);
        } else {
            setState(DIE);
            
            if(!animation[getState()].isFirstLoop()) {
                GameObjectManager.getInstance().removeObject(this);
            }
        }


    }
    
}
