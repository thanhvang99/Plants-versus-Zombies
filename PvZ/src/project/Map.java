package project;

// Map that we can put plant on this or zombies can appears on this..

public class Map {

    private int x,y;
    private boolean map[][];
    
    // Convert to new ID map
    private ID[][] new_map;
    
    // Evaluate by pixel
    public static final int  DELTA_X = 105,
                             DELTA_Y = 140,
                             START_X = 360,
                             START_Y = 40;
    public Map(int x,int y) {
        this.x = x;
        this.y = y;
        
        map = new boolean[x][y];
        new_map = new ID[x][y];
    }
    public void tick(){
        /*
        // Initializing Map Boolean --> False
        for(int i=0;i<y;i++){
            for(int j=0;j<x;j++){
                map[j][i] = false;
            }
        }
        
        // Check x,y exist Object --> Assign --> True
        for(int i=0;i<GameObjectManager.getInstance().getList().size();i++){
            GameObject object = GameObjectManager.getInstance().getList().get(i);
            if( object.isSolid() ){
                map[(int)Math.ceil(object.getX())][(int)Math.ceil(object.getY())] = true;
            }
            
        }
        */
        
        // Initializing New Map ID --> null
        for(int i=0;i<y;i++){
            for(int j=0;j<x;j++){
                new_map[j][i] = null;
            }
        }
        // Map x,y --> Assign --> its ID
        for(int i=0;i<GameObjectManager.getInstance().getList().size();i++){
            GameObject object = GameObjectManager.getInstance().getList().get(i);
            new_map[(int)Math.ceil(object.getX())][(int)Math.ceil(object.getY())] = object.getID();
        }
        
        
        
    }
    public boolean isExist(int x,int y){
        if( map[x][y] )
            return true;
        else
            return false;
    }
    
    public static boolean isInMap(int xPixel,int yPixel){
        if( xPixel >= START_X && yPixel >= START_Y ){
            return true;
        } else {
            return false;
        }
    }
    public ID[][] getMap(){ return new_map; }
}
    
    
