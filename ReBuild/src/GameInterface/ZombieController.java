package GameInterface;

import GameInterface.ObjectController;

public interface ZombieController extends ObjectController{
    public abstract void move();
    public abstract void isDied();
    public abstract void meetPlant();
}