package Models.GameObjects;

import Services.Animation;
import Services.ImageFrames;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

public class LawnMower extends GameObject {
    private final int DEFAULT_WIDTH = 90,
                      DEFAULT_HEIGHT = 90;
    private Animation animation;
    
    public LawnMower(float x,float y){
        super(x,y,STUFF_NO_MOUSE);
        
        setSizeImage(DEFAULT_WIDTH,DEFAULT_HEIGHT);
        setAnimation();
        setXYPadding();
        
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(animation.getCurrentFrame(), (int)getXPixel(),(int)getYPixel(), getWidth(),getHeight(),null);
        
        drawRect(g);
    }

    @Override
    public void tick() {
        animation.tick();
        checkCollision();
        act();
        checkDied();
    }

    @Override
    public void setAnimation() {
        animation = new Animation(100,ImageFrames.getLawnMower());
    }

    @Override
    public void act() {
        if( getState() == DIE ){
            setX(getXCordinate()+0.2f);
        }
    }

    @Override
    public void checkCollision() {
        ArrayList<GameObject> list = GameObjectManager.getInstance().getList(ZOMBIE);
        for( GameObject object : list ){
            if( getCurrentRect().intersects(object.getCurrentRect()) ){
                object.setHealth(0);
                setState(DIE);
            }
        }
    }

    @Override
    public void checkDied() {
        if( getXCordinate() >= 10 ){
            GameObjectManager.getInstance().removeObject(this);
        }
    }

    @Override
    public void setXYPadding() {
        setX(getXCordinate() - getYCordinate()*0.06f);
    }
    
}
