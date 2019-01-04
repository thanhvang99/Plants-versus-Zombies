package Models;

import Services.Animation;
import Services.ImageFrames;
import Services.Timer;
import Views.Playground;
import java.awt.Graphics;

public class Beetroot extends BasicPlant {
    private static final int DEFAULT_SPEED = 1500;
    private Timer timer;
    
    private Animation actAnimation,
                      dieAnimation;

    public Beetroot(float x,float y){
        super(x,y);
        
        timer = new Timer(DEFAULT_SPEED);
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
        if( timer.isReng() )
            act();
    }

    @Override
    public void act() {
        GameObjectManager.getInstance().addObject(new NormalBullet(getX(),getY(),8.0f,ImageFrames.getBeetrootBullet()));
    }

    @Override
    public void isDied() {
    }


    @Override
    public void setAnimation() {
        actAnimation = new Animation(500,ImageFrames.getBeetrootAct());
    }

    
}
