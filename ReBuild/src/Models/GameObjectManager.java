package Models;

import Helper.ID;
import java.awt.Graphics;
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
    public void tickAllObject(){
        for( GameObject object : list ){
            object.tick();
        }
    }
    
    public ArrayList<GameObject> getListID(ID id){
        ArrayList<GameObject> zombieList = new ArrayList<GameObject>();
        ArrayList<GameObject> plantList = new ArrayList<GameObject>();
        ArrayList<GameObject> otherList = new ArrayList<GameObject>();
        for(GameObject object : list){
            if( object.getID() == ID.ZOMBIE ){
                zombieList.add(object);
            }
            if( object.getID() == ID.PLANT ){
                plantList.add(object);
            }
            if( object.getID() == ID.ZOMBIE ){
                otherList.add(object);
            }
        }
        
        if( id == ID.OTHER )
            return otherList;
        else 
            return id == ID.PLANT ? plantList : zombieList;
    }
    public ArrayList<GameObject> getList(){ return list; }
}
