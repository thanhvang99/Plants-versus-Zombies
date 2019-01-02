package Views;

import Services.GameInterface;
import java.awt.image.BufferedImage;

public class Animation implements GameInterface{
    private BufferedImage[] frames;
    private int index = 0;
    private int timeSpeed;
    
    private long timer = 0;
    private long startTime,endTime;
    
    public Animation(int timeSpeed,BufferedImage[] frames){
        this.timeSpeed = timeSpeed;
        this.frames = frames;
        
        clock();
    }

    @Override
    public void tick() {
        endTime = System.currentTimeMillis();
        timer += (endTime - startTime);
        startTime = endTime;
        
        if( timer >= timeSpeed ){
            timer = 0;
            
            index ++;
            if( index >= frames.length )
                index = 0;
            
        }
        
    }
    public void clock(){
        startTime = System.currentTimeMillis();
    }

    public BufferedImage getCurrentFrame(){ return frames[index]; }
}
