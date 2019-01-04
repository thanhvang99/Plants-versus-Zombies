package Models;

import Services.Animation;
import Services.ImageFrames;
import Views.Playground;
import java.awt.Graphics;

public class NormalZombie extends BasicZombie {
    private Animation actAnimation,
                      dieAnimation;
    
    public NormalZombie(float x,float y,float speed){
        super(x,y,speed);
        
        setAnimation();
    }

    @Override
    public void render(Graphics g) {
        float xPixel = Playground.convert_CordinateX_to_Pixel(getX());
        float yPixel = Playground.convert_CordinateY_to_Pixel(getY());
        
        g.drawImage(actAnimation.getCurrentFrame(), (int)xPixel,(int)yPixel, DEFAULT_WIDTH,DEFAULT_HEIGHT,null);
        
        // Test
        g.drawRect(getCurrentRect().x, getCurrentRect().y, getCurrentRect().width, getCurrentRect().height);
    }

    @Override
    public void tick() {
        actAnimation.tick();
        act();
        
    }

    @Override
    public void act() {
        setX(getX()-getSpeed()/1000);        //  x -= speed/1000;
        moveRect();
    }

    @Override
    public void isDied() {
    }

    @Override
    public void meetPlant() {
    }


    @Override
    public void setAnimation() {
        actAnimation = new Animation(500,ImageFrames.getNormalZombieMove());
    }
    
}
