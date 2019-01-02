package GameInterface;

import GameInterface.ObjectController;

public interface PlantController extends ObjectController {
    public abstract void act();
    public abstract void isDied();
}
