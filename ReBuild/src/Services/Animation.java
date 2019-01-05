package Services;

import java.awt.image.BufferedImage;
import Services.GameLogic;

public class Animation implements GameLogic{
    private BufferedImage[] frames;
    private boolean isFirstLoop = true;
    private int index = 0;
    private int timeSpeed;
    private Timer timer;
    
    public Animation(int timeSpeed,BufferedImage[] frames){
        this.timeSpeed = timeSpeed;
        this.frames = frames;
        timer = new Timer(timeSpeed);
        
        
    }
    public boolean isFirstLoop(){
        return isFirstLoop;
    }

    @Override
    public void tick() {
        if( timer.isTimeOut() ){
            index++;
            if( index >= frames.length ){
                index = 0;
                isFirstLoop = false;
            }
        }
    }
            
        
    public BufferedImage getCurrentFrame(){ return frames[index]; }
}
