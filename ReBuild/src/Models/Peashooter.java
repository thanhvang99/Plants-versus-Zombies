package Models;

import Services.Animation;
import Services.ImageFrames;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Peashooter extends BasicPlant {
    
    private Animation actAnimation,
                      dieAnimation;

    public Peashooter(float x,float y){
        super(x,y);
        
        System.out.println(ImageFrames.getPeashooterAct());
     
        setAnimation();
    }
    
    @Override
    public void render(Graphics g) {
        g.drawImage(actAnimation.getCurrentFrame(), 100, 100, null);
    }

    @Override
    public void tick() {
        actAnimation.tick();
    }

    @Override
    public void act() {
    }

    @Override
    public void isDied() {
    }

    @Override
    public Rectangle getRect() {
        return null;
    }

    @Override
    public void setAnimation() {
        actAnimation = new Animation(500,ImageFrames.getPeashooterAct());
    }
    
}
