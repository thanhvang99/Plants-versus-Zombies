package State;

import GameInterface.GameView;
import GameInterface.GameController;

public abstract class State implements GameView,GameController {
    private static State currentState;
    
    public static State getCurrentState(){ return currentState; }
    public static void setState(State state){ currentState = state; }
}