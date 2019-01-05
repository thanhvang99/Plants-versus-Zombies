package Models;

import Services.GameLogic;
import Services.GameDraw;
import Services.ObjectInterface;
import Views.Playground;
import java.awt.Rectangle;

public abstract class GameObject implements GameDraw,GameLogic,ObjectInterface {
    public static final int ZOMBIE = 0,
                            PLANT = 1,
                            BULLET = 2;
    public static final int ACT = 0,
                            DIE = 1;
    
    
    private int kind,state;
    private float x,y;
    private int health;
    private Rectangle currentRect;
    public GameObject(float x,float y,int kind){
        this.x = x;
        this.y = y;
        this.kind = kind;
        
    }
    public void moveRect(){
        float xPixel = Playground.convert_CordinateX_to_Pixel(getX());
        float yPixel = Playground.convert_CordinateY_to_Pixel(getY());
        getCurrentRect().move((int)xPixel, (int)yPixel);
    }
    public void setX(float x){ this.x = x; }
    
    public void setRect(Rectangle rect){ this.currentRect = rect; }
    public abstract void createRectangle();
    public Rectangle getCurrentRect(){ return currentRect; }
    public float getX(){ return x; }
    public float getY(){ return y; }
    public void setHealth(int health){ this.health = health; }
    public int getHealth(){ return health; }
    
    @Override
    public boolean isSolid(){ return true; }
    @Override
    public int getKind(){ return kind; }
    
    public void setState(int STATE){ this.state = STATE; }
    public int getState(){ return state; }
    
}
