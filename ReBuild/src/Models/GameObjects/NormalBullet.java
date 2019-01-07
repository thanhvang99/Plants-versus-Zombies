package Models.GameObjects;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class NormalBullet extends GameObject {

    private BufferedImage image;
    private float speed;
    private static final int DEFAULT_WIDTH = 20,
                             DEFAULT_HEIGHT = 20;

    public NormalBullet(float x, float y, float speed, BufferedImage image, float xAlign, float yAlign) {
        super(x + xAlign, y + yAlign, STUFF_NO_MOUSE);
        
        setSizeImage(DEFAULT_WIDTH,DEFAULT_HEIGHT);
        this.image = image;
        this.speed = speed;
        
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(image, (int) getXPixel(), (int) getYPixel(), getWidth(), getHeight(), null);
        
        drawRect(g);
    }

    @Override
    public void tick() {
        act();
    }

    @Override
    public void act() {
        setX(getXCordinate() + speed/ 1000);        //  x += speed/1000;

        if (getXCordinate() >= 9) {
            GameObjectManager.getInstance().removeObject(this);
        }
        checkCollision();
    }


    @Override
    public boolean isSolid() {
        return false;
    }

    @Override
    public void setAnimation() {
    }
    @Override
    public void checkCollision(){
        ArrayList<GameObject> listZombie = GameObjectManager.getInstance().getList(ZOMBIE);
        for( GameObject object : listZombie ){
            if( getCurrentRect().intersects(object.getCurrentRect()) ){
                object.setHealth(object.getHealth()-30);                // health -= 30;
                GameObjectManager.getInstance().removeObject(this);
                
            }
        }
    }

    @Override
    public void checkDied() {
    }

    @Override
    public void setXYPadding() {
    
    }


}
