package PvZ;

public abstract class GameObject implements GameView {
    private float x,y;
    private ID id;
    public GameObject(float x,float y,ID id){
        this.x = x;
        this.y = y;
        this.id = id;
    
    }
    public float getX(){ return x; }
    public float getY(){ return y; }
    
    
}
