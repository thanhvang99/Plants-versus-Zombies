package project;

public abstract class Creature extends GameObject {
    public final static int DEFAULT_HEALTH = 100;
    private int health;
    public Creature(float x,float y){
        super(x,y);
        health = DEFAULT_HEALTH;
    }
    
}
