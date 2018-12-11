package project;

public abstract class Creature extends GameObject {
    public final static int DEFAULT_HEALTH = 100;
    private int health;
    public Creature(float x,float y,ID id){
        super(x,y,id);
        health = DEFAULT_HEALTH;
    }
    
}
