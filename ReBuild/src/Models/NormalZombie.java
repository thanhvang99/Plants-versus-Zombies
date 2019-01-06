package Models;

import Services.Animation;
import Services.ImageFrames;
import Services.Timer;
import java.awt.Graphics;
import java.util.ArrayList;

public class NormalZombie extends BasicZombie {
    private Timer timer;
    private GameObject plantCollision = null;
    
    private Animation[] animation;
    
    public NormalZombie(float x,float y,float speed){
        super(x,y,speed);
        
        timer = new Timer(3000);
        setAnimation();
    }

    @Override
    public void render(Graphics g) {
        
        g.drawImage(animation[getState()].getCurrentFrame(), (int)getXPixel(),(int)getYPixel(), DEFAULT_WIDTH,DEFAULT_HEIGHT,null);
        
        // Test
//        g.drawRect(getCurrentRect().x, getCurrentRect().y, getCurrentRect().width, getCurrentRect().height);
    }

    @Override
    public void tick() {
        animation[getState()].tick();
        checkCollision();
        act();
        checkDied();
        
        
        
    }

    @Override
    public void act() {
        if (plantCollision == null) {
            changeSpeedTo(getInitialSpeed());
            
        }else{
            changeSpeedTo(0);
            attack(plantCollision);
            
            if( plantCollision.getHealth() <= 0 ){
                plantCollision = null;
            }
        }
        setX(getXCordinate() - getCurrentSpeed() / 1000);        //  x -= speed/1000;
        moveRect();
        updateXYPixel();
    }

    @Override
    public void checkCollision(){
        ArrayList<GameObject> listPlant = GameObjectManager.getInstance().getList(PLANT);
        for(GameObject object : listPlant){
            if( getCurrentRect().intersects(object.getCurrentRect()) ){
                plantCollision = object;
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
    
    
    public void attack(GameObject object){
        if( timer.isTimeOut() ){
            object.setHealth(object.getHealth()-30);
        }
    }
    @Override
    public void meetPlant() {
    }

    @Override
    public void setAnimation() {
        animation = new Animation[2];
        animation[ACT] = new Animation(200,ImageFrames.getNormalZombieMove());
        animation[DIE] = new Animation(300,ImageFrames.getNormalZombieDie());
    }
    
}
