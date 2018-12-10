package project;

import java.awt.Graphics;

public abstract class GameObject {
    private float x,y;                // Not evaluate by pixel
    public abstract void render(Graphics g);
    public abstract void tick();
    public GameObject(float x,float y){
        this.x = x;
        this.y = y;
    }
    public float getX(){ return x; }
    public float getY(){ return y; }
    
    public void setX(float x){ this.x = x; }
    public void setY(float y){ this.y = y; }
}
