package Services;

// Obtain logic for Objects like zombie, plant, other...

import java.awt.Rectangle;


public interface ObjectInterface extends GameLogic {
    public abstract Rectangle getRect();
    public abstract void setAnimation();
}
