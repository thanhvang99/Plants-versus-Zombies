package GameInterface;

import GameInterface.ObjectInterface;

public interface ZombieInterface extends ObjectInterface{
    public abstract void move();
    public abstract void isDied();
    public abstract void meetPlant();
}