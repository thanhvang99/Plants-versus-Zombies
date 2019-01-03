package Views;

import Helper.ID;
import Models.GameObjectManager;
import Models.GameObject;
import Services.ImageFrames;
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
    
    public boolean isInPlayground(int xPixel,int yPixel){
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
            int YCeil = (int)Math.ceil(object.getX());
            
            int XFloor = (int)Math.floor(object.getX());
            int YFloor = (int)Math.floor(object.getX());
            
            ground[YCeil][XCeil] = object.getID();
            ground[YFloor][YFloor] = object.getID();
            
        }
    }
    public void initializeGround(){
        for(int i=0;i<x;i++){
            for(int j=0;j<y;j++){
                ground[j][i] = null;
            }
        }
    }
    
}
