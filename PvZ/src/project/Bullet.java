package project;

import java.awt.Graphics;
import java.awt.Rectangle;

public class Bullet extends GameObject {
    public static final int DEFAULT_WIDTH = 20,
                            DEFAULT_HEIGHT = 20;
    private float velX;
    
    // Atribute column to avoid jump pixel;
    private int column;
    
    public Bullet(int x,int y,ID id){
        super(x,y,id);
        
        velX = 0.01f;
        column = x;
    }
    public void fly(){
        setX(getX()+velX);
    }
    
    @Override
    public void tick(){
        fly();
    
    }
    
    @Override
    public void render(Graphics g){
        if (column <= 3)
            g.drawImage(Stuffs.getBasicBullet(), (int)(getX()*Map.DELTA_X + Map.START_X +40), (int)(getY()*Map.DELTA_Y+ Map.START_Y + 30),DEFAULT_WIDTH,DEFAULT_HEIGHT, null);
        else
            g.drawImage(Stuffs.getBasicBullet(), (int)(getX()*Map.DELTA_X + Map.START_X + 60), (int)(getY()*Map.DELTA_Y+ Map.START_Y + 30),DEFAULT_WIDTH,DEFAULT_HEIGHT, null);
    }
    @Override
    public boolean isSolid(){ return false; }
    @Override
    public Rectangle getRect(){
        if( column <= 3)
            return new Rectangle((int)(getX()*Map.DELTA_X + Map.START_X +40), (int)(getY()*Map.DELTA_Y+ Map.START_Y + 30),DEFAULT_WIDTH,DEFAULT_HEIGHT);
        else
            return new Rectangle((int)(getX()*Map.DELTA_X + Map.START_X + 60), (int)(getY()*Map.DELTA_Y+ Map.START_Y + 30),DEFAULT_WIDTH,DEFAULT_HEIGHT);
            
    }
}
