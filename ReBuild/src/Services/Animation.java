package Services;

import java.awt.image.BufferedImage;

public class Animation implements GameLogic{
    private BufferedImage[] frames;
    private BufferedImage oneFrame;
    private boolean isNewLoop = false;
    private int index = 0;
    private int timeSpeed;
    private Timer timer;
    
    public Animation(int timeSpeed,BufferedImage[] frames){
        this.timeSpeed = timeSpeed;
        this.frames = frames;
        timer = new Timer(timeSpeed);
        
        
    }
    public Animation(BufferedImage oneFrame){
        this.oneFrame = oneFrame;
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
            
    public BufferedImage getCurrentFrame(){
        if( frames != null ){
            return frames[index];
        }else
            return oneFrame;
    
    }
    
    
    public int getCurrentIndex(){ return index; }
}
