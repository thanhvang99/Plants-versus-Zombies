package Models.GameObjects;

import Services.Animation;
import Services.ImageFrames;
import Services.Timer;
import java.awt.Graphics;

public class NormalZombie extends BasicZombie {
    
    public NormalZombie(float x,float y,float speed){
        super(x,y,speed);
        
        setTimer(new Timer(3000));
    }

    @Override
    public void setAnimation() {
        animation = new Animation[2];
        
        animation[ACT] = new Animation(200,ImageFrames.getNormalZombieMove());
        animation[DIE] = new Animation(100,ImageFrames.getNormalZombieDie());
    }
    @Override
    public void setXYPadding() {
    }
}
