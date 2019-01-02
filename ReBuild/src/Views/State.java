package Views;

import Services.GameInterface;

public abstract class State implements GameView,GameInterface {
    private static State currentState;
    
    public static State getCurrentState(){ return currentState; }
    public static void setState(State state){ currentState = state; }
}
