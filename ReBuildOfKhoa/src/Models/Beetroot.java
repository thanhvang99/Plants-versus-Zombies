package Models;

import Services.Animation;
import Services.ImageFrames;
import Views.Playground;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Beetroot extends BasicPlant {
    
    private Animation actAnimation,
                      dieAnimation;

    public Beetroot(float x,float y){
        super(x,y);
        
     
        setAnimation();
    }
    
    @Override
    public void render(Graphics g) {
        g.drawImage(actAnimation.getCurrentFrame(), (int) ( Playground.START_X + getX()*Playground.DELTA_WIDTH_CELL ),
                    (int) ( Playground.START_Y + getY()*Playground.DELTA_HEIGHT_CELL ),
                    DEFAULT_WIDTH,DEFAULT_HEIGHT,null);

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
        actAnimation = new Animation(500,ImageFrames.getBeetrootAct());
    }
    
}
