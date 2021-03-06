package Models.GameObjects;

import Models.BackgroundComponents.Money;
import Services.Animation;
import Services.ImageFrames;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Sun extends GameObject {
    private static Money currentMoney;
    
    private float xRandom,
                  yRandom;
    
    private static final int DEFAULT_WIDTH = 50,
                             DEFAULT_HEIGHT = 50;
    
    private boolean isClickByMouse = false;
    
    public Sun(float x,float y){
        super(x,y,STUFF_WITH_MOUSE);
        
        setSizeImage(DEFAULT_WIDTH,DEFAULT_HEIGHT);
        setXYPadding();
        makeRandomMoveTo();
        setAnimation();
        
    }

    @Override
    public void tick() {
        animation[getState()].tick();
        act();
    }

    @Override
    public void setAnimation() {
        animation = new Animation[1];
        animation[ACT] = new Animation(300,ImageFrames.getSun());
        
    }
    public void makeRandomMoveTo(){
        Random r = new Random();
        xRandom = r.nextInt(5);
        yRandom = r.nextInt(5);
    }
    
    @Override
    public void act() {
        if( isClickByMouse ){
            moveTo(-4, 5);
            if( getXCordinate() < -3 ){
                currentMoney.set(currentMoney.get()+50);
                GameObjectManager.getInstance().removeObject(this);
            }
        }else{
            moveTo(xRandom + 0.25f, yRandom + 0.3f);
        }
            
    }
    public void moveTo(float xCordinate,float yCordinate){
        float x1,x2,y1,y2,x,y,m,deltaX;
        // Setup
        x1 = getXCordinate();
        y1 = getYCordinate();
        x2 = xCordinate;
        y2 = yCordinate;
        if (x2 - x1 != 0) {

            m = (y2 - y1) / (x2 - x1);
            deltaX = (x2 - x1) / 100;

            // y = m*(x-x1) + y1;
            setX(x1 + deltaX);
            setY(m * (getXCordinate() - x1) + y1);

        }
        
        
    }

    @Override
    public void checkMouseClick(int xPixel,int yPixel){
        if( getCurrentRect().contains(xPixel, yPixel) ){
            isClickByMouse = true;
        }
    }
    public static void setRelationWithMoney(Money money){
        currentMoney = money;
    }
    @Override
    public void checkCollision() {
    }

    @Override
    public void checkDied() {
    }
    @Override
    public boolean isSolid(){ return false; }

    @Override
    public void setXYPadding() {
    }

    
}
