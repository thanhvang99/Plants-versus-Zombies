package Services;

import java.awt.image.BufferedImage;
import Services.GameLogic;

public class Animation implements GameLogic{
    private BufferedImage[] frames;
    private int index = 0;
    private int timeSpeed;
    private Timer timer;
    
    public Animation(int timeSpeed,BufferedImage[] frames){
        this.timeSpeed = timeSpeed;
        this.frames = frames;
        timer = new Timer(timeSpeed);
        
        
    }

    @Override
    public void tick() {
        if( timer.isReng() ){
            index++;
            if( index >= frames.length )
                index = 0;
        }
    }
            
        
    public BufferedImage getCurrentFrame(){ return frames[index]; }
}
