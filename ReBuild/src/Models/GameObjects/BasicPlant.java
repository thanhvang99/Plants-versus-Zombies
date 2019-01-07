package Models.GameObjects;

import java.awt.Rectangle;

public abstract class BasicPlant extends GameObject {
    protected boolean isRemove = false;
    protected final int DEFAULT_WIDTH = 76,
                        DEFAULT_HEIGHT = 76;
    public BasicPlant(float x,float y){
        super(x,y,PLANT);
        
        setHealth(100);
        setAnimation();
        setSizeImage(DEFAULT_WIDTH,DEFAULT_HEIGHT);
        
        setXYPadding();
    }
    @Override
    public void checkCollision(){
    }
    @Override
    public void checkDied() {
        if (isRemove) {
            setState(DIE);
            GameObjectManager.getInstance().removeObject(this);
        } else if (getHealth() <= 0) {
            setState(DIE);
            if (animation[getState()].isNewLoop()) {
                GameObjectManager.getInstance().removeObject(this);
            }
        }
    }
    public abstract void setXYPadding();
    @Override
    public void checkMouseClick(int xPixel,int yPixel){
        if( getCurrentRect().contains(xPixel, yPixel) )
            isRemove = true;
    }

}
    