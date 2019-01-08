package Services;

// Obtain logic for Objects like zombie, plant, other...

import java.awt.Rectangle;


public interface ObjectInterface {
    public abstract void setAnimation();
    public abstract void act();
    public abstract boolean isSolid();
    public abstract int getKind();
    public abstract void checkCollision();
    public abstract void checkDied();
}
