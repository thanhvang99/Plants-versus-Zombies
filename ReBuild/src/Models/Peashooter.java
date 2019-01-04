package Models;

import Services.Animation;
import Services.ImageFrames;
import Services.Timer;
import Views.Playground;
import java.awt.Graphics;

public class Peashooter extends BasicPlant {
    
    private static final int DEFAULT_SPEED_SHOOT = 2000;     // ms
    private Animation actAnimation,
                      dieAnimation;
    
    private Timer timer;
    public Peashooter(float x,float y){
        super(x,y);
        timer = new Timer(DEFAULT_SPEED_SHOOT);
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
        GameObjectManager.getInstance().addObject(new NormalBullet(getX(), getY(), 6f, ImageFrames.getPeashooterBullet()));
    }

    @Override
    public void isDied() {
    }

    @Override
    public void setAnimation() {
        actAnimation = new Animation(500,ImageFrames.getPeashooterAct());
    }
    
}
