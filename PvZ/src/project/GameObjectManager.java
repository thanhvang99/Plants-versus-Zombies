package project;

import java.util.ArrayList;

public class GameObjectManager {
    private static GameObjectManager manager = null;
    private ArrayList<GameObject> list;
    private GameObjectManager(){
        list = new ArrayList<GameObject>();
    }
    public void addObject(GameObject object){
        list.add(object);
    }
    public void removeObject(GameObject object){
        list.remove(object);
    }
    public static GameObjectManager getInstance(){
        if( manager == null ){
            manager = new GameObjectManager();
            return manager;
        }else
            return manager;
    }
    public ArrayList<GameObject> getList(){ return list; }
}
