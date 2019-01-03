package Views;

import Helper.ID;
import Models.GameObjectManager;
import Models.GameObject;
import java.util.ArrayList;
import Services.GameLogic;

public class Playground implements GameLogic {
    public static final int DELTA_WIDTH_CELL = 105,
                            DELTA_HEIGHT_CELL = 140,
                            START_X = 360,
                            START_Y = 40;
    
    private int x,y;
    private ID[][] ground;
    
    public Playground(int x,int y){
        this.x = x;
        this.y = y;
        
        ground = new ID[y][x];
        
    }
    public int calculateXPosition(int xPixel){
        return ( xPixel - START_X )/ DELTA_WIDTH_CELL;
    }
    public int calculateYPosition(int yPixel){
        return ( yPixel - START_Y )/ DELTA_HEIGHT_CELL;
    }
    
    public boolean isInSide(int xPixel,int yPixel){
        return ( (xPixel > START_X) && (yPixel > START_Y) ) ? true : false;
    }
    
    @Override
    public void tick() {
        initializeGround();
        updateNewIDPosition();
    }
    
    public void updateNewIDPosition(){
        ArrayList<GameObject> listObject = GameObjectManager.getInstance().getList();
        for(GameObject object : listObject){
            int XCeil = (int)Math.ceil(object.getX());
            int YCeil = (int)Math.ceil(object.getY());
            
            int XFloor = (int)Math.floor(object.getX());
            int YFloor = (int)Math.floor(object.getY());
            
            ground[YCeil][XCeil] = object.getID();
            ground[YFloor][XFloor] = object.getID();
            
        }
    }
    public void initializeGround(){
        for(int i=0;i<y;i++){
            for(int j=0;j<x;j++){
                ground[j][i] = null;
            }
        }
    }
    public boolean isExistCreature(int xPosition,int yPosition){
        if( ground[yPosition][xPosition] == ID.OTHER || ground[yPosition][xPosition] == null  )
            return false;
        else
            return true;
    }
    
}
