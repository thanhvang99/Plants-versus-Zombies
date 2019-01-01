package PvZ;

public interface ZombieController extends ObjectController{
    public abstract void move();
    public abstract void isDied();
    public abstract void meetPlant();
}