package project;

import java.awt.Graphics;

public class Bullet extends GameObject {
    private float velX;
    public Bullet(int x,int y){
        super(x,y);
        
        velX = 0.01f;
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
        if (getX() <= 3)
            g.drawImage(Stuffs.getBasicBullet(), (int)(getX()*Map.DELTA_X + Map.START_X +40), (int)(getY()*Map.DELTA_Y+ Map.START_Y + 30), null);
        else
            g.drawImage(Stuffs.getBasicBullet(), (int)(getX()*Map.DELTA_X + Map.START_X + 60), (int)(getY()*Map.DELTA_Y+ Map.START_Y + 30), null);
    }
    @Override
    public boolean isSolid(){ return false; }
}
