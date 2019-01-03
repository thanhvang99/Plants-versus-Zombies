package Services;

// Obtain logic for Objects like zombie, plant, other...

import java.awt.Rectangle;


public interface ObjectInterface extends GameInterface {
    public abstract Rectangle getRect();
    public abstract void setAnimation();
}
