package Models;

import Views.Playground;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class NormalBullet extends GameObject {

    private BufferedImage image;
    private float speed;
    private static final int DEFAULT_WIDTH = 20,
            DEFAULT_HEIGHT = 20;

    public NormalBullet(float x, float y, float speed, BufferedImage image) {
        super(x, y, BULLET);
        this.image = image;
        this.speed = speed;

        createRectangle();
    }

    @Override
    public void render(Graphics g) {
        float xPixel = Playground.convert_CordinateX_to_Pixel(getX());
        float yPixel = Playground.convert_CordinateY_to_Pixel(getY());

        g.drawImage(image, (int) xPixel, (int) yPixel, DEFAULT_WIDTH, DEFAULT_HEIGHT, null);
        
        // Test
        g.drawRect(getCurrentRect().x, getCurrentRect().y, getCurrentRect().width, getCurrentRect().height);
    }

    @Override
    public void tick() {
        act();
    }

    @Override
    public void act() {
        setX(getX() + speed / 1000);        //  x += speed/1000;
        moveRect();

        if (getX() >= 9) {
            GameObjectManager.getInstance().removeObject(this);
        }
        checkCollision();
    }

    @Override
    public void createRectangle() {

        float xPixel = Playground.convert_CordinateX_to_Pixel(getX());
        float yPixel = Playground.convert_CordinateY_to_Pixel(getY());

        setRect(new Rectangle((int) xPixel, (int) yPixel, DEFAULT_WIDTH, DEFAULT_HEIGHT));
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

}
