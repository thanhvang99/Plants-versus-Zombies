package Models.GameObjects;

import Services.Animation;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class NormalBullet extends GameObject {

    private BufferedImage image;
    private float speed;
    private boolean isDisappear = false;
    private static final int DEFAULT_WIDTH = 20,
                             DEFAULT_HEIGHT = 20;

    public NormalBullet(float x, float y, float speed, BufferedImage image, float xAlign, float yAlign) {
        super(x + xAlign, y + yAlign, STUFF_NO_MOUSE);
        
        this.image = image;
        this.speed = speed;
        
        setSizeImage(DEFAULT_WIDTH,DEFAULT_HEIGHT);
        setAnimation();
    }

    @Override
    public void tick() {
        act();
        checkCollision();
        checkDied();
    }

    @Override
    public void act() {
        setX(getXCordinate() + speed/ 1000);        //  x += speed/1000;

        if (getXCordinate() >= 10) {
            GameObjectManager.getInstance().removeObject(this);
        }
    }


    @Override
    public boolean isSolid() {
        return false;
    }

    @Override
    public void setAnimation() {
        animation = new Animation[1];
        animation[ACT] = new Animation(image);
    }
    @Override
    public void checkCollision(){
        ArrayList<GameObject> listZombie = GameObjectManager.getInstance().getList(ZOMBIE);
        for( GameObject object : listZombie ){
            if( getCurrentRect().intersects(object.getCurrentRect()) ){
                object.setHealth(object.getHealth()-10);                // health -= 30;
                isDisappear = true;
            }
        }
    }

    @Override
    public void checkDied() {
        if( isDisappear ){
            GameObjectManager.getInstance().removeObject(this);
        }
    }
    @Override
    public void setXYPadding() {
    
    }


}
