package project;

import java.awt.Graphics;

public class BasicZombie extends Creature {
    public static final int DEFAULT_WIDTH = 96,
                            DEFAULT_HEIGHT = 130;
    
    private Animation animation;
    private float velX;
    
    public BasicZombie(float x,float y){
        super(x,y);
        animation = new Animation(Stuffs.getBasicZombie(),400);
        
        // Test
        velX = 0.002f;
    }
    
    public void move(){
        setX(getX()-velX);
    }
    
    @Override
    public void tick(){
        animation.tick();
        move();
    
    }
    
    @Override
    public void render(Graphics g){
        g.drawImage(animation.getCurrentFrame(), (int)(getX()*Map.DELTA_X + Map.START_X), (int)(getY()*Map.DELTA_Y+ Map.START_Y),DEFAULT_WIDTH, DEFAULT_HEIGHT, null);
    }
}
