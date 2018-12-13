package project;

import java.awt.Graphics;
import java.awt.Rectangle;

public class Sunflower extends Creature {
    public static final int DEFAULT_WIDTH = 76,
                            DEFAULT_HEIGHT = 76;
    private Animation animation;
    
    public Sunflower(float x,float y,ID id){
        super(x,y,id);
        
        animation = new Animation(Stuffs.getSunflower(),500);
        
    }
    @Override
    public void tick(){
        animation.tick();
    }
    @Override
    public void render(Graphics g){
        if( getX()<=3 )
            g.drawImage(animation.getCurrentFrame(), (int)(getX()*Map.DELTA_X + Map.START_X), (int)(getY()*Map.DELTA_Y+ Map.START_Y + 20),DEFAULT_WIDTH, DEFAULT_HEIGHT, null);
        else
            g.drawImage(animation.getCurrentFrame(), (int)(getX()*Map.DELTA_X + Map.START_X + 20), (int)(getY()*Map.DELTA_Y+ Map.START_Y + 20),DEFAULT_WIDTH, DEFAULT_HEIGHT, null);
    
    }
    @Override
    public Rectangle getRect(){
        if( getX()<=3 )
            return new Rectangle( (int)(getX()*Map.DELTA_X + Map.START_X),(int)(getY()*Map.DELTA_Y + Map.START_Y + 20),DEFAULT_WIDTH,DEFAULT_HEIGHT );
        else
            return new Rectangle( (int)(getX()*Map.DELTA_X + Map.START_X + 20),(int)(getY()*Map.DELTA_Y + Map.START_Y + 20),DEFAULT_WIDTH,DEFAULT_HEIGHT );
        
    }
    
    
}
