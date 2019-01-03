package Views;

import Services.GameDraw;
import Services.GameLogic;

public abstract class State implements GameDraw,GameLogic {
    private static State currentState;
    
    public static State getCurrentState(){ return currentState; }
    public static void setState(State state){ currentState = state; }
}
