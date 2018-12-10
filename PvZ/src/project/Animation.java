package project;

import java.awt.image.BufferedImage;

public class Animation {
    private int index = 0;
    private int speed;
    private BufferedImage[] frame;
    private long timer;
    private long lastTime;
    
    
    public void tick() {
        timer += System.currentTimeMillis() - lastTime;
        lastTime = System.currentTimeMillis();
        if( timer >= speed ) {
            index++;
            timer = 0;
            
            if( index >= frame.length ){
                index = 0;
            }
        }
    }
    
    public Animation(BufferedImage[] frame,int speed) {
        this.frame = frame;
        this.speed = speed;
        
        lastTime = System.currentTimeMillis();
    }

    public BufferedImage getCurrentFrame() {
        return frame[index];
    }
}
