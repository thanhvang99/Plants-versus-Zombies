package project;

import java.awt.Graphics;

public class BasicPlant extends Creature {
    // Timer
    long lastTime;
    long timer;
    
    // End Timer
    private Animation animation;
    public static final int DEFAULT_WIDTH = 76,
                            DEFAULT_HEIGHT = 76,
                            DEFAULT_SHOOT_FREQUENTCY = 3000;         // By ms
    
    public BasicPlant(float x,float y){
        super(x,y);
        animation = new Animation(Stuffs.getBasicPlant(),500);
        lastTime = System.currentTimeMillis();
    }
    public void shoot(){
        GameObjectManager.getInstance().addObject(new Bullet((int)getX(),(int)getY()));
    }
    
    @Override
    public void tick(){
        animation.tick();
        timer += System.currentTimeMillis()-lastTime;
        lastTime = System.currentTimeMillis();
        if( timer >= DEFAULT_SHOOT_FREQUENTCY ){
            timer = 0;
            shoot();
        }
        
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
