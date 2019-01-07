package Models.GameObjects;

import static Models.GameObjects.GameObject.ACT;
import static Models.GameObjects.GameObject.DIE;
import Services.Animation;
import Services.ImageFrames;
import Services.Timer;
import java.awt.Graphics;

public class FootBallZombie extends BasicZombie {
    
    
    public FootBallZombie(float x,float y,float speed){
        super(x,y,speed);
        
        setHealth(150);
        setSizeImage(DEFAULT_WIDTH + 20,DEFAULT_HEIGHT + 20);
        setTimer(new Timer(3000));
    }
    @Override
    public void setAnimation() {
        animation = new Animation[2];
        animation[ACT] = new Animation(200,ImageFrames.getFootBallZombieMove());
        animation[DIE] = new Animation(100,ImageFrames.getFootBallZombieDie());
    }
    @Override
    public void increaseScoreAfterDied(){
        score.set(score.get()+150);
    }
    @Override
    public void setXYPadding() {
    }
}
