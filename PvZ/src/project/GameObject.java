package project;

import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class GameObject {
    private float x,y;                // Not evaluate by pixel
    private ID id;
    public abstract void render(Graphics g);
    public abstract void tick();
    public GameObject(float x,float y,ID id){
        this.x = x;
        this.y = y;
        this.id = id;
    }
    public float getX(){ return x; }
    public float getY(){ return y; }
    public ID getID(){ return id; }
    
    public void setX(float x){ this.x = x; }
    public void setY(float y){ this.y = y; }
    public boolean isSolid(){ return true; }
    public abstract Rectangle getRect();
}
