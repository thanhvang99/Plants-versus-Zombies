package Models;

import java.awt.Graphics;
import java.util.ArrayList;

// Store list of game object
// Can delete or add new game object
// Using singleton patterm
public class GameObjectManager {
    private ArrayList<GameObject> list;
    private static int numberOfZombieDied = 0;
    
    private static GameObjectManager manager = null;
    
    private GameObjectManager(){
        list = new ArrayList<GameObject>();
    }
    public static GameObjectManager getInstance(){
        if( manager == null )
            manager = new GameObjectManager();
        return manager;
    }
    public void addObject(GameObject object){
        list.add(object);
        
    }
    public void removeObject(GameObject object){
        list.remove(object);
    }
    
    public void renderAllObject(Graphics g){
        for( GameObject object : list )
            object.render(g);
    }
    
    // If using for( : ) cause ERROR:ConcurrentModificationException
    // For example, it is not generally permissible for one thread to modify a Collection while another thread is iterating over it ....
    
    public void tickAllObject(){
        for( int i=0;i<list.size();i++ ){
            list.get(i).tick();
        }
    }
    
    public ArrayList<GameObject> getList(){ return list; }
    public ArrayList<GameObject> getList(int KIND){
        ArrayList<GameObject> tempList = new ArrayList<GameObject>();
        for( GameObject object : list ){
            if( object.getKind() == KIND ){
                tempList.add(object);
            }
        }
        return tempList;
    }
    
}
