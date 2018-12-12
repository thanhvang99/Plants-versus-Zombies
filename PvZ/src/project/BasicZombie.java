package project;

import java.awt.Graphics;
import java.awt.Rectangle;

public class BasicZombie extends Creature {
    public static final int DEFAULT_WIDTH = 96,
                            DEFAULT_HEIGHT = 130,
                            DEFAULT_HIT_FREQUENCY = 1000;    //(ms)
    public static final float DEFAULT_SPEED = 0.002f;
    
    private Animation animation;
    private BasicPlant plantAttacked;
    
    // Timer Collision
    private long lastTime,timer;
    private float velX;
    
    public BasicZombie(float x,float y,ID id){
        super(x,y,id);
        animation = new Animation(Stuffs.getBasicZombie(),400);
        lastTime = System.currentTimeMillis();
        
        // Test
        velX = DEFAULT_SPEED;
    }
    
    public void move(){
        setX(getX()-velX);
    }
    
    @Override
    public void tick(){
        animation.tick();
        move();
        if( isDied() )
            GameObjectManager.getInstance().removeObject(this);
        // Collision between plant & zombie
        if( isCollisedWithPlant() ){
            timer += System.currentTimeMillis() - lastTime;
            lastTime = System.currentTimeMillis();
            if( timer >= DEFAULT_HIT_FREQUENCY ){
                timer = 0;
                plantAttacked.setHealth(plantAttacked.getHealth()-30);
            }
            if( plantAttacked.isDied() ){
                GameObjectManager.getInstance().removeObject(plantAttacked);
                plantAttacked = null;
            }
        }
        
    
    }
    
    @Override
    public void render(Graphics g){
        g.drawImage(animation.getCurrentFrame(), (int)(getX()*Map.DELTA_X + Map.START_X), (int)(getY()*Map.DELTA_Y+ Map.START_Y),DEFAULT_WIDTH, DEFAULT_HEIGHT, null);
    }
    @Override
    public Rectangle getRect(){
        return new Rectangle((int)(getX()*Map.DELTA_X + Map.START_X), (int)(getY()*Map.DELTA_Y+ Map.START_Y),DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }
    public boolean isCollisedWithPlant(){
        for(int i=0;i<GameObjectManager.getInstance().getList().size();i++){
            GameObject object = GameObjectManager.getInstance().getList().get(i);
            if( object.getID() == ID.BASIC_PLANT ){
                BasicPlant plant = (BasicPlant)object;
                if( getRect().intersects(plant.getRect())  ){
                    plantAttacked = plant;
                    velX = 0;
                    return true;
                }
            }
        }
//        velX = DEFAULT_SPEED;
        return false;
    }
}
