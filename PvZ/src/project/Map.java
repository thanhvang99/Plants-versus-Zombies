package project;


// Map that we can put plant on this or zombies can appears on this..

public class Map {
    private int x,y;            // Not evaluate by pixel (normal cordinate)
    
    // Evaluate by pixel
    private static final int DELTA_X = 105,
                             DELTA_Y = 120,
                             START_X = 360,
                             START_Y = 40;
    public Map(int x,int y){
        this.x = x;
        this.y = y;
    }
    public static boolean isInMap(int xPixel,int yPixel){
        if( xPixel >= START_X && yPixel >= START_Y )
            return true;
        else
            return false;
    }
    
}
