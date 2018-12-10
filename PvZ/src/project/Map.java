package project;


// Map that we can put plant on this or zombies can appears on this..

public class Map {
    private int x,y;
    private boolean map[][];
    
    // Evaluate by pixel
    public static final int  DELTA_X = 105,
                             DELTA_Y = 140,
                             START_X = 360,
                             START_Y = 40;
    public Map(int x,int y){
        this.x = x;
        this.y = y;
        
        map = new boolean[x][y];
    }
    public void tick(){
        // Initializing Map Boolean --> False
        for(int i=0;i<y;i++){
            for(int j=0;j<x;j++){
                map[j][i] = false;
            }
        }
        
        // Check x,y exist Object --> Assign --> True
        for(int i=0;i<GameObjectManager.getInstance().getList().size();i++){
            GameObject object = GameObjectManager.getInstance().getList().get(i);
            map[(int)Math.ceil(object.getX())][(int)Math.ceil(object.getY())] = true;
            
        }
    }
    public boolean isExist(int x,int y){
        if( map[x][y] )
            return true;
        else
            return false;
    }
    
    public static boolean isInMap(int xPixel,int yPixel){
        if( xPixel >= START_X && yPixel >= START_Y )
            return true;
        else
            return false;
    }
    
    
}
