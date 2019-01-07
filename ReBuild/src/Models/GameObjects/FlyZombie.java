package Models.GameObjects;

import static Models.GameObjects.GameObject.ACT;
import static Models.GameObjects.GameObject.DIE;
import Services.Animation;
import Services.ImageFrames;
import Services.Timer;
import java.awt.Graphics;

public class FlyZombie extends BasicZombie {
    public FlyZombie(float x,float y,float speed){
        super(x,y,speed);
        
        setHealth(200);
        setSizeImage(DEFAULT_WIDTH+20,DEFAULT_HEIGHT+20);
        setTimer(new Timer(3000));
    }
    @Override
    public void render(Graphics g) {
        
        g.drawImage(animation[getState()].getCurrentFrame(), (int)getXPixel(),(int)getYPixel(), getWidth(),getHeight(),null);
        
        drawRect(g);
    }

    @Override
    public void setAnimation() {
        animation = new Animation[2];
        animation[ACT] = new Animation(200,ImageFrames.getFlyZombieMove());
        animation[DIE] = new Animation(100,ImageFrames.getNormalZombieDie());
    }
    @Override
    public void setXYPadding() {
    }
    @Override
    public void increaseScoreAfterDied(){
        score.set(score.get()+200);
    }
}
