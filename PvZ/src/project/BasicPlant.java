package project;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class BasicPlant extends Creature {
    // Timer
    long lastTime;
    long timer;
    
    // End Timer
    private Animation animation;
    public static final int DEFAULT_WIDTH = 76,
                            DEFAULT_HEIGHT = 76;
    private Random r = new Random();
    private int random_shoot_frequency;                 // By ms
    
    public BasicPlant(float x,float y,ID id){
        super(x,y,id);
        animation = new Animation(Stuffs.getBasicPlant(),500);
        lastTime = System.currentTimeMillis();
        random_shoot_frequency = (r.nextInt(3)+3)*1000;
    }
    public void shoot(){
        GameObjectManager.getInstance().addObject(new Bullet((int)getX(),(int)getY(),ID.BASIC_BULLET));
    }
    
    @Override
    public void tick(){
        animation.tick();
        timer += System.currentTimeMillis()-lastTime;
        lastTime = System.currentTimeMillis();
        if( timer >= random_shoot_frequency ){             // 3-6s shoot frequency
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
    @Override
    public Rectangle getRect(){
        if( getX()<=3 )
            return new Rectangle( (int)(getX()*Map.DELTA_X + Map.START_X),(int)(getY()*Map.DELTA_Y + Map.START_Y + 20),DEFAULT_WIDTH,DEFAULT_HEIGHT );
        else
            return new Rectangle( (int)(getX()*Map.DELTA_X + Map.START_X + 20),(int)(getY()*Map.DELTA_Y + Map.START_Y + 20),DEFAULT_WIDTH,DEFAULT_HEIGHT );
    }
    
}
