package Services;

import java.awt.image.BufferedImage;
import Services.GameLogic;

public class Animation implements GameLogic{
    private BufferedImage[] frames;
    private boolean isNewLoop = false;
    private int index = 0;
    private int timeSpeed;
    private Timer timer;
    
    public Animation(int timeSpeed,BufferedImage[] frames){
        this.timeSpeed = timeSpeed;
        this.frames = frames;
        timer = new Timer(timeSpeed);
        
        
    }
    public boolean isNewLoop(){
        return isNewLoop;
    }

    @Override
    public void tick() {
        if( timer.isTimeOut() ){
            isNewLoop = false;
            index++;
            if( index >= frames.length ){
                index = 0;
                isNewLoop = true;
            }
        }
    }
            
    
    public BufferedImage getCurrentFrame(){ return frames[index]; }
    public int getCurrentIndex(){ return index; }
}
