/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Services.Animation;
import Services.ImageFrames;
import Views.Playground;
import java.awt.Graphics;

/**
 *
 * @author ldakhoa
 */
public class Sunflower extends BasicPlant {
    
    private Animation[] animation;
    
    public Sunflower(float x, float y) {
        super(x, y);
        
        setAnimation();
    }

    @Override
    public void render(Graphics g) {
        float xPixel = Playground.convert_CordinateX_to_Pixel(getX());
        float yPixel = Playground.convert_CordinateY_to_Pixel(getY());
        
        g.drawImage(animation[getState()].getCurrentFrame(), (int)xPixel,(int)yPixel, DEFAULT_WIDTH,DEFAULT_HEIGHT,null);
        
        // Test
        g.drawRect(getCurrentRect().x, getCurrentRect().y, getCurrentRect().width, getCurrentRect().height);
    }

    @Override
    public void tick() {
        animation[getState()].tick();
    }

    @Override
    public void setAnimation() {
        animation = new Animation[2];
        animation[0] = new Animation(500, ImageFrames.getSunflowerAct());
        animation[1] = new Animation(500, ImageFrames.getSunflowerDie());
    }

    @Override
    public void act() {
//        GameObjectManager.getInstance().addObject();
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
    
    
    
}
