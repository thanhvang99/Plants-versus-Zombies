package Models;

import Services.Animation;
import Services.ImageFrames;
import Services.Timer;
import Views.Playground;
import java.awt.Graphics;
import java.util.ArrayList;

public class NormalZombie extends BasicZombie {
    private Timer timer;
    private GameObject plantCollision = null;
    
    private Animation[] animation;
    
    public NormalZombie(float x,float y,float speed){
        super(x,y,speed);
        
        timer = new Timer(1000);
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
        act();
        
        checkCollision();
        checkDied();
        
    }

    @Override
    public void act() {
        setX(getX()-getSpeed()/1000);        //  x -= speed/1000;
        moveRect();
    }

    @Override
    public void checkCollision(){
        ArrayList<GameObject> listPlant = GameObjectManager.getInstance().getList(PLANT);
        for(GameObject object : listPlant){
            System.out.println(getCurrentRect().intersects(object.getCurrentRect()));
            if( getCurrentRect().intersects(object.getCurrentRect()) ){
                decreaseSpeedUntilZero();
                attack(object);
            }
        }
    }
    
    @Override
    public void checkDied() {
        if( getHealth() <= 0 ){
            setState(DIE);
            if ( !animation[getState()].isFirstLoop()) {
                GameObjectManager.getInstance().removeObject(this);
            }
                
        }
    }
    
    public void decreaseSpeedUntilZero() {
        setSpeed(getSpeed() - 0.02f);
        if (getSpeed() <= 0) {
            setSpeed(0);
        }
    }
    
    public void attack(GameObject object){
        if( timer.isReng() )
            object.setHealth(getHealth()-30);
    }
    @Override
    public void meetPlant() {
    }

    @Override
    public void setAnimation() {
        animation = new Animation[2];
        animation[ACT] = new Animation(500,ImageFrames.getNormalZombieMove());
        animation[DIE] = new Animation(300,ImageFrames.getNormalZombieDie());
    }
    
}
