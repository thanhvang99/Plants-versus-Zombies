    package Models.GameObjects;

import Models.BackgroundComponents.Playground;
import Services.Animation;
import Services.GameLogic;
import Services.GameDraw;
import Services.ObjectInterface;
import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class GameObject implements GameDraw,GameLogic,ObjectInterface {
    public static final int ZOMBIE = 0,
                            PLANT = 1,
                            STUFF_NO_MOUSE = 2,
                            STUFF_WITH_MOUSE = 3;
    public static final int ACT = 0,
                            DIE = 1,
                            ATTACK = 2;
    private int kind,state;
    private int width,height;
    protected Animation[] animation;
    
    
    
    private float xCordinate,yCordinate,
                  xPixel,yPixel;
    private int health;
    private Rectangle currentRect;
    
    public GameObject(float x,float y,int kind){
        
        xCordinate = x;
        yCordinate = y;
        
        xPixel = Playground.convert_CordinateX_to_Pixel(xCordinate);
        yPixel = Playground.convert_CordinateY_to_Pixel(yCordinate);
        
        this.kind = kind;
        
    }
    @Override
    public void render(Graphics g){
        g.drawImage(animation[getState()].getCurrentFrame(), (int)getXPixel(),(int)getYPixel(), getWidth(),getHeight(),null);
        
        drawRect(g);
    }
    
    public void setRect(Rectangle rect){ this.currentRect = rect; }
    public Rectangle getCurrentRect(){ return currentRect; }
    public void moveRect(){
        getCurrentRect().move((int)xPixel, (int)yPixel);
    }
    
    public void setX(float x){
        this.xCordinate = x;
        updateXYPixel();
        moveRect();
    }
    public void setY(float y){
        this.yCordinate = y;
        updateXYPixel(); 
        moveRect();
    }
    public abstract void setXYPadding();
    public float getXCordinate(){ return xCordinate; }
    public float getYCordinate(){ return yCordinate; }
    public float getXPixel(){ return xPixel; }
    public float getYPixel(){ return yPixel; }
    public void updateXYPixel(){
        xPixel = Playground.convert_CordinateX_to_Pixel(xCordinate);
        yPixel = Playground.convert_CordinateY_to_Pixel(yCordinate);
    }
    
    public void setHealth(int health){ this.health = health; }
    public int getHealth(){ return health; }
    
    // DEFAULT checkMouseClick()
    public void checkMouseClick(int xPixel,int yPixel){
    
    }
    public void setState(int STATE){ this.state = STATE; }
    public int getState(){ return state; }
    
    public boolean isDied(){
        if( state == DIE ){
            return true;
        }else
            return false;
    }
        
    @Override
    public boolean isSolid(){ return true; }
    @Override
    public int getKind(){ return kind; }
    
    
    public void drawRect(Graphics g){
//        g.drawRect(getCurrentRect().x, getCurrentRect().y, getCurrentRect().width, getCurrentRect().height);
    }
    public void setSizeImage(int width,int height){
        this.width = width;
        this.height = height;
        
        if( currentRect == null ){
            currentRect = new Rectangle((int)xPixel,(int)yPixel,width,height);
        }else{
            currentRect.width = width;
            currentRect.height = height;
        }
    }
    public int getWidth(){ return width; }
    public int getHeight(){ return height; }
}
