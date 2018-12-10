package project;

import java.awt.Graphics;

public class BasicPlant extends Creature {
    private Animation animation;
    public static final int DEFAULT_WIDTH = 76,
                            DEFAULT_HEIGHT = 76;
    
    public BasicPlant(float x,float y){
        super(x,y);
        animation = new Animation(Stuffs.getBasicPlant(),500);
    }
    
    @Override
    public void tick(){
        animation.tick();
    }
    
    @Override
    public void render(Graphics g){
        
        // Debug display at center of cell.
        
        if( getX()<=3 )
            g.drawImage(animation.getCurrentFrame(), (int)(getX()*Map.DELTA_X + Map.START_X), (int)(getY()*Map.DELTA_Y+ Map.START_Y + 20),DEFAULT_WIDTH, DEFAULT_HEIGHT, null);
        else
            g.drawImage(animation.getCurrentFrame(), (int)(getX()*Map.DELTA_X + Map.START_X + 20), (int)(getY()*Map.DELTA_Y+ Map.START_Y + 20),DEFAULT_WIDTH, DEFAULT_HEIGHT, null);
    }
    
}
