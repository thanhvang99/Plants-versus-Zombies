package PvZ;

import java.util.ArrayList;

// Store list of game object
// Can delete or add new game object
// Using singleton patterm
public class GameObjectManager {
    private ArrayList<GameObject> list;
    
    private static GameObjectManager manager = null;
    
    private GameObjectManager(){
        list = new ArrayList<GameObject>();
    }
    public static GameObjectManager getInstance(){
        if( manager == null )
            manager = new GameObjectManager();
        return manager;
    }
}
